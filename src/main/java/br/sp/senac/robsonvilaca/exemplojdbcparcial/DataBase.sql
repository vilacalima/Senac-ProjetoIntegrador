#Criando banco de dados da Nota Fiscal
Create database baseNotaFiscal;

#Entrando na base
use baseNotaFiscal;

#Criando tabela
create table NotaFiscal(
	idNota int not null auto_increment,
    numeroNota int not null,
    valorNota double not null,
    primary key(idNota)
);

#Descrevendo o valor da nota fiscal
desc NotaFiscal;