-- Tabela de Empresa
CREATE TABLE empresa (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE
);

-- Tabela de Usuário
CREATE TABLE usuario (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil VARCHAR(255) NOT NULL,
    empresa_id UUID NOT NULL,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id) ON DELETE CASCADE
);

-- Tabela de Empreendimento
CREATE TABLE empreendimento (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    localizacao VARCHAR(255),
    informacoes_adicionais JSONB,
    empresa_id UUID NOT NULL,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id) ON DELETE CASCADE
);

-- Tabela de Apartamento
CREATE TABLE apartamento (
    id UUID PRIMARY KEY,
    numero INT NOT NULL,
    area FLOAT NOT NULL,
    preco FLOAT NOT NULL,
    informacoes_adicionais JSONB,
    empreendimento_id UUID NOT NULL,
    FOREIGN KEY (empreendimento_id) REFERENCES empreendimento(id) ON DELETE CASCADE
);

-- Tabela de Lead
CREATE TABLE lead (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(255) NOT NULL,
    cpf VARCHAR(14),
    estado_civil VARCHAR(50),
    origem VARCHAR(255),
    informacoes_adicionais JSONB,
    endereco VARCHAR(500),
    status VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id UUID NOT NULL,
    empresa_id UUID NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id) ON DELETE CASCADE
);

-- Tabela de Contrato
CREATE TABLE contrato (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    valor FLOAT,
    lead_id UUID NOT NULL,
    apartamento_id UUID NOT NULL,
    FOREIGN KEY (lead_id) REFERENCES lead(id) ON DELETE CASCADE,
    FOREIGN KEY (apartamento_id) REFERENCES apartamento(id) ON DELETE CASCADE
);

-- Relacionamento entre Empreendimento e Apartamento
CREATE TABLE empreendimento_apartamento (
    empreendimento_id UUID REFERENCES empreendimento(id) ON DELETE CASCADE,
    apartamento_id UUID REFERENCES apartamento(id) ON DELETE CASCADE,
    PRIMARY KEY (empreendimento_id, apartamento_id)
);
