-- Tabela de Usuário
CREATE TABLE usuario (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(255) NOT NULL
);

-- Tabela de Empreendimento
CREATE TABLE empreendimento (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    localizacao VARCHAR(255)
);

-- Tabela de Apartamento
CREATE TABLE apartamento (
    id UUID PRIMARY KEY,
    numero INT NOT NULL,
    area FLOAT NOT NULL,
    preco FLOAT NOT NULL
);

-- Tabela de Lead
CREATE TABLE lead (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(255) NOT NULL,
    origem VARCHAR(255),
    informacoes_adicionais VARCHAR(500),
    endereco VARCHAR(500),
    status VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id UUID,
    empreendimento_id UUID,
    apartamento_id UUID,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (empreendimento_id) REFERENCES empreendimento(id),
    FOREIGN KEY (apartamento_id) REFERENCES apartamento(id)
);

-- Tabela de Contrato
CREATE TABLE contrato (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    valor FLOAT,
    lead_id UUID,
    apartamento_id UUID,
    FOREIGN KEY (lead_id) REFERENCES lead(id),
    FOREIGN KEY (apartamento_id) REFERENCES apartamento(id)
);

-- Relacionamento entre Empreendimento e Apartamento
CREATE TABLE empreendimento_apartamento (
    empreendimento_id UUID REFERENCES empreendimento(id),
    apartamento_id UUID REFERENCES apartamento(id),
    PRIMARY KEY (empreendimento_id, apartamento_id)
);
