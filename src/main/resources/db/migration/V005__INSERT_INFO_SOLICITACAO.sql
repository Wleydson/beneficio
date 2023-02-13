INSERT INTO solicitacao (solicitante, data_criacao) VALUES ((SELECT id FROM pessoa WHERE cpf = '18261770001'), CURRENT_TIMESTAMP());
INSERT INTO solicitacao (solicitante, data_criacao) VALUES ((SELECT id FROM pessoa WHERE cpf = '19686707000'), CURRENT_TIMESTAMP());
INSERT INTO solicitacao (solicitante, data_criacao) VALUES ((SELECT id FROM pessoa WHERE cpf = '90553421069'), CURRENT_TIMESTAMP());
INSERT INTO solicitacao (solicitante, data_criacao) VALUES ((SELECT id FROM pessoa WHERE cpf = '06783137090'), CURRENT_TIMESTAMP());
