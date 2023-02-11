CREATE TABLE IF NOT EXISTS solicitacao (
    id BIGSERIAL NOT NULL,
    solicitante INTEGER NOT NULL,
    data_criacao DATETIME  NOT NULL,
    CONSTRAINT pk_solicitacao PRIMARY KEY (id),
    CONSTRAINT fk_solicitante_id FOREIGN KEY (solicitante) REFERENCES pessoa (id)
);