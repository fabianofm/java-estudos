CREATE TABLE Usuario(
id INTEGER NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(100) NOT NULL,
email VARCHAR(150) NOT NULL,
login VARCHAR(100) UNIQUE NOT NULL,
senha VARCHAR(500) NOT NULL,
dataCadastro DATE NOT NULL,
dataNasc DATE NOT NULL
);
insert into Usuario(nome,email,login,senha,dataCadastro, dataNasc) values('Administrador','admin@localhost','admin','123','04.02.2017','01.01.1981');

--opcionais
CREATE TABLE SERVICOS_OPCIONAIS(
id INTEGER NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(200) NOT NULL,
tipo VARCHAR(100) NOT NULL);

insert into SERVICOS_OPCIONAIS(nome,tipo) 
values ('Romeu e Julieta de colher','Comidas'),
('Doce de Leite de colher','Comidas'),
('Doce de Leite de Chocolate de colher','Comidas'),
('Doces Fondados','Comidas'),
('Doces Caramelados','Comidas'),
('Quindim','Comidas'),
('Mesa de Guloseimas','Comidas'),
('Buffet de Sorvete','Comidas'),
('Whisky','Bebidas'),
('Vinho','Bebidas'),
('Espumante','Bebidas'),
('Arco de Bolas','Enfeites'),
('Cenário','Enfeites'),
('Enfeites de Mesa','Enfeites'),
('Toalha e Cobre Mancha','Enfeites'),
('Personagem','Diversão'),
('Magico','Diversão'),
('Teatro de Fantoche','Diversão'),
('Foto Maluca','Diversão'),
('Maquiagem Artística','Diversão'),
('Tatuagem (7 dias)','Diversão'),
('Salão de Beleza','Diversão'),
('Produtos p/ Banho personalizados','Diversão');


-- cesta
CREATE TABLE CESTA(
id INTEGER NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
login VARCHAR(100) NOT NULL,
item VARCHAR(200) NOT NULL
);







