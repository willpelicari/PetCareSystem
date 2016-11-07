CREATE TABLE tipopessoa (
  IdTipoPessoa INT NOT NULL,
  Descricao VARCHAR(45) NULL,
  PRIMARY KEY (IdTipoPessoa)
);

CREATE TABLE tipoanimal (
  IdTipoAnimal INT NOT NULL,
  Descricao VARCHAR(45) NULL,
  PRIMARY KEY (IdTipoAnimal)
);

CREATE TABLE pessoa (
  IdPessoa INT NOT NULL,
  Nome VARCHAR(200) NULL,
  IdTipo INT NOT NULL,
  Login VARCHAR(45) NULL,
  Senha VARCHAR(45) NULL,
  CEP VARCHAR(9) NULL,
  Numero VARCHAR(5) NULL,
  Telefone VARCHAR(10) NULL,
  Email VARCHAR(60) NULL,
  PRIMARY KEY (IdPessoa),
  CONSTRAINT IdTipoFK
    FOREIGN KEY (IdTipo)
    REFERENCES tipopessoa (IdTipoPessoa)
)
COMMENT = 'Toda e qualquer pessoa que fara uso do sistema';

CREATE TABLE animal (
  IdAnimal INT NOT NULL,
  IdPessoa INT NOT NULL,
  Nome VARCHAR(200) NULL,
  IdTipo INT NOT NULL,
  Raca VARCHAR(45) NULL,
  DtNasc DATE NULL,
  Observacoes VARCHAR(200) NULL,
  PRIMARY KEY (IdAnimal),
  CONSTRAINT IdPessoaFK
    FOREIGN KEY (IdPessoa)
    REFERENCES pessoa (IdPessoa),
  CONSTRAINT IdTipoAnimalFK
    FOREIGN KEY (IdTipo)
    REFERENCES tipoanimal (IdTipoAnimal)
);


CREATE TABLE evento (
  IdEvento INT NOT NULL,
  Data DATE NULL,
  Descricao VARCHAR(100) NULL,
  IdAnimal INT NULL,
  IdResponsavel INT NULL,
  Valor FLOAT NULL,
  PRIMARY KEY (IdEvento),
  CONSTRAINT IdAnimalFK
    FOREIGN KEY (IdAnimal)
    REFERENCES animal (IdAnimal),
  CONSTRAINT IdResponsavelFK
    FOREIGN KEY (IdResponsavel)
    REFERENCES pessoa (IdPessoa)
)
COMMENT = 'Todo cuidado que foi feito com o cachorro';