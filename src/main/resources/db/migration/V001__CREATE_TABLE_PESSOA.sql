CREATE TABLE IF NOT EXISTS pessoa (
    id BIGSERIAL NOT NULL,
    nome TEXT NOT NULL,
    email TEXT NOT NULL,
    idade INTEGER NOT NULL,
    cpf TEXT NOT NULL,
    renda NUMERIC NOT NULL,
    CONSTRAINT pk_pessoa PRIMARY KEY (id)
);