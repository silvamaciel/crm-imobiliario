ALTER TABLE empreendimento 
ADD COLUMN matricula_imovel VARCHAR(255),
ADD COLUMN area_de_lazer VARCHAR(255),
ADD COLUMN registro_de_incorporacao VARCHAR(255),
ADD COLUMN dt_lancamento DATE,
ADD COLUMN previsao_de_entrega DATE;
DROP COLUMN informacoes_adicionais;