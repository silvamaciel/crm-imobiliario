-- Tabela de Usuário
CREATE TABLE usuario (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(255) NOT NULL
);

-- Tabela de Lead
CREATE TABLE lead (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(255) NOT NULL,
    origem VARCHAR(255),
    status VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id UUID REFERENCES usuario(id)
);

-- Tabela de Contrato
CREATE TABLE contrato (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    valor FLOAT,
    lead_id UUID REFERENCES lead(id),
    apartamento_id UUID REFERENCES apartamento(id)
);

-- Tabela de Apartamento
CREATE TABLE apartamento (
    id UUID PRIMARY KEY,
    numero INT,
    area FLOAT,
    preco FLOAT
);

-- Tabela de Empreendimento
CREATE TABLE empreendimento (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    localizacao VARCHAR(255)
);

-- Relacionamento entre Empreendimento e Apartamento
CREATE TABLE empreendimento_apartamento (
    empreendimento_id UUID REFERENCES empreendimento(id),
    apartamento_id UUID REFERENCES apartamento(id),
    PRIMARY KEY (empreendimento_id, apartamento_id)
);
