CREATE TABLE IF NOT EXISTS dependentes (
    id BIGSERIAL NOT NULL,
    solicitacao_id INTEGER NOT NULL,
    pessoa_id INTEGER  NOT NULL,
    CONSTRAINT pk_dependentes PRIMARY KEY (id),
    CONSTRAINT fk_solicitacao_id FOREIGN KEY (solicitacao_id) REFERENCES solicitacao (id),
    CONSTRAINT fk_pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);