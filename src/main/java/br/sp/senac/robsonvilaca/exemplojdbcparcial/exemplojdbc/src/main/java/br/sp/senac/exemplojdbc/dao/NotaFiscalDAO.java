package br.sp.senac.exemplojdbc.dao;

import br.sp.senac.exemplojdbc.model.NotaFiscal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.fernandes
 */
public class NotaFiscalDAO {
    
    public static String url = "jdbc:mysql://localhost:3306/basenotafiscal";
    public static String login = "root";
    public static String senha = "P@$$w0rd";
    
    public static boolean salvar(NotaFiscal obj) throws ClassNotFoundException, SQLException{
        
        //Criando uma conexão
        Connection conexao = null;
        //Se der certo a inserção no banco retorne verdadeiro se não falso
        boolean retorno = false;
        
        //Chamando a classe do banco de dados para o projeto
        try{
            //TODO: Implementar insert na tabela NotaFiscal
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrindo uma conexão com o MYSQL
            conexao = DriverManager.getConnection(url, login, senha);
        
            //Criar o comando SQL - > Cada ? é um parametro 
            PreparedStatement comandoSQL= conexao.prepareStatement("INSERT INTO NotaFiscal(numeroNota, valorNota) VALUES(?,?)");
            //Inserindo os parametros, o numero é o primeiro parametro e o objeto depois da virgula é o método chamado
            comandoSQL.setInt(1,obj.getNumeroNota());
            comandoSQL.setDouble(2,obj.getValorNota());
            
            //Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                //Se der certo retorne true
                retorno = true;
            }
            //Se der certo retorne true
//            retorno = true;
        //catch para tratar possivel erro na classe
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        //Catch para tratar possivel erro no SQL
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
        return retorno;
    }

    public static ArrayList<NotaFiscal> listar(){
        ArrayList<NotaFiscal> lista = new ArrayList<NotaFiscal>();
        Connection conexao = null;
        try {
            //TODO: Implementar consulta à tabela NotaFiscal
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Abrindo uma conexão com o MYSQL
            conexao = DriverManager.getConnection(url, login, senha);
            //Executando um comando para voltar o valor
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM NotaFiscal");
            
            //Comando para trazer o valor da tabela
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs != null){
                //Pecorrendo os dados da tabela
                while(rs.next()){
                    NotaFiscal novoObjeto = new NotaFiscal();
                    novoObjeto.setIdNota(rs.getInt("idNota"));
                    novoObjeto.setNumeroNota(rs.getInt("numeroNota"));
                    novoObjeto.setValorNota(rs.getDouble("valorNota"));
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lista;
    }

    public static NotaFiscal consultarPorID(int idNota){
        NotaFiscal lista = new NotaFiscal();

        //TODO: Implementar consulta à tabela NotaFiscal pelo id

        return lista;
    }

    public static boolean atualizar(NotaFiscal obj){
        
        //Criando uma conexão
        Connection conexao = null;
        //Se der certo a inserção no banco retorne verdadeiro se não falso
        boolean retorno = false;
        
        //Chamando a classe do banco de dados para o projeto
        try{
            //TODO: Implementar insert na tabela NotaFiscal
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrindo uma conexão com o MYSQL
            conexao = DriverManager.getConnection(url, login, senha);
        
            //Criar o comando SQL - > Cada ? é um parametro 
            PreparedStatement comandoSQL= conexao.prepareStatement("Update NotaFiscal SET numeroNota");
            //Inserindo os parametros, o numero é o primeiro parametro e o objeto depois da virgula é o método chamado
            comandoSQL.setInt(1,obj.getNumeroNota());
            comandoSQL.setDouble(2,obj.getValorNota());
            comandoSQL.setInt(3,obj.getIdNota());
            
            //Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                //Se der certo retorne true
                retorno = true;
            }
            //Se der certo retorne true
//            retorno = true;
        //catch para tratar possivel erro na classe
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        //Catch para tratar possivel erro no SQL
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }  
        return retorno;
    }
    
}
