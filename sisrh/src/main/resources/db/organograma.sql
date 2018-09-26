INSERT INTO documento_eleitoral (ID_DOCUMENTO_ELEITORAL, DSC_SECAO_TITULO_ELEITOR, DSC_TITULO_ELEITOR, DSC_ZONA_TITULO_ELEITOR, ID_UF) VALUES ('1', '123', '1231', '123', 7);

INSERT INTO filiacao (ID_FILIACAO, DSC_NOME_PAI, DSC_NOME_MAE) VALUES ('1', 'Nome da mãe', 'Nome do pai');

INSERT INTO dados_trabalhistas (ID_DAODS_TRABALHISTAS, DTA_PRIMEIRO_EMPREGO, DSC_PIS_PASEP) VALUES ('1', now(), 'PisPasep');

INSERT INTO estado_civil VALUES (1,'Solteiro'),(2,'Casado'),(3,'Viúvo'),(4,'Separado judicialmente'),(5,'Divorciado'),(6,'Outros');

INSERT INTO rg (ID_RG, DTA_EXPEDICAO, DSC_ORGAO_EMISSOR, DSC_RG, ID_UF) VALUES ('1', now(), 'SSP-DF', '9312481', '7');

INSERT INTO cor_pele (ID_COR_PELE, DSC_COR_DE_PELE) VALUES (1, 'BRANCO');

INSERT INTO endereco (ID_ENDERECO, DSC_LOGRADOURO, DSC_COMPLEMENTO, DSC_BAIRRO, DSC_NUMERO, DSC_CEP, ID_CIDADE) VALUES (2, 'QUADRA 506 EDIFICIO POLIEDRO', null, '', '7', '2500000', '1');


INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (1, 'PRE','presidencia@aeb.gov.br', false, 'PRESIDÊNCIA','Presidência da AEB', null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (2, 'GAB','gab@aeb.gov.br', false, 'GABINETE','Gabinete da Presidência',null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (3, 'PF','pf@aeb.gov.br', false, 'PROCURADORIA FEDERAL','Procuradoria Federal',null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (4, 'AI','auditoria.aeb@aeb.gov.br', false, 'AUDITORIA INTERNA',null,null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (5, 'ACI','aci@aeb.gov.br', false, 'ACESSORIA DE COOPERAÇÃO INTERNACIONAL','Assessoria de Cooperação Internacional',null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (6, 'DPOA','dpoa@aeb.gov.br', false, 'DIRETORIA DE PLANEJAMENTO, ORÇAMENTO E ADMINISTRAÇÃO',null,null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (7, 'DPEI','dpei@aeb.gov.br', false, 'DIRETORIA DE POLÍTICA ESPACIAL E INVESTIMENTOS ESTRATÉGICOS',null,null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (8, 'DSAD','dsad@aeb.gov.br', false, 'DIRETORIA DE SATELITES, APLICAÇÕES E DESENVOLVIMENTO',null,null);

INSERT INTO diretoria (ID_DIRETORIA, DSC_SIGLA, DSC_EMAIL, BOL_EXTINTO, DSC_NOME, DSC_OBS, ID_FUNCIONARIO_DIRETOR) VALUES (9, 'DTEL','dtel@aeb.gov.br', false, 'DIRETORIA DE TRANSPORTE ESPACIAL E LICENCIAMENTO',null,null);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (1, 'CCS', 'COORDENAÇÃO DE COMUNICAÇÃO SOCIAL', null, 2);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (2, 'CPM', 'COORDENAÇÃO DE PLANEJAMENTO E MODERNIZAÇÃO', null, 6);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (3, 'CRH', 'COORDENAÇÃO DE RECURSOS HUMANOS', null, 6);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (4, 'CRL', 'COORDENAÇÃO DE RECURSOS LOGÍSTICOS', null, 6);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (5, 'COF', 'COORDENAÇÃO ORÇAMENTÁRIA E FINANCEIRA', null, 6);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (6, 'CIE', 'COORDENAÇÃO DE INVESTIMENTOS ESTRATÉGICOS', null, 7);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (7, 'CPP', 'COORDENAÇÃO DE POLÍTICAS E PLANOS', null, 7);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (8, 'CPA', 'COORDENAÇÃO DE PROGRAMAÇÃO E AVALIAÇÃO', null, 7);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (9, 'CPDI', 'COORDENAÇÃO DE PESQUISA, DESENVOLVIMENTO E INOVAÇÃO', null, 8);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (10, 'CSA', 'COORDENAÇÃO DE SATÉLITES E APLICAÇÕES', null, 8);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (11, 'CCL', 'COORDENAÇÃO DE CENTROS DE LANÇAMENTO', null, 9);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (12, 'CNL', 'COORDENAÇÃO DE NORMALIZAÇÃO E LICENCIAMENTO', null, 9);

INSERT INTO coordenacao (ID_COORDENACAO, DSC_SIGLA, DSC_NOME, ID_FUNCIONARIO_COORDENADOR, ID_DIRETORIA) VALUES (13, 'CVL', 'COORDENAÇÃO DE VEICULOS LANÇADORES', null, 9);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (1, 'EVENTOS', 'DIVISÃO DE EVENTOS', 1, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (2, 'IMPRENSA', 'DIVISÃO DE IMPRENSA', 1, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (3, 'CRIAÇÃO', 'DIVISÃO DE PROJETOS E CRIAÇÃO', 1, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (4, 'DINF', 'DIVISÃO DE INFORMÁTICA', 2, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (5, 'DPLAN', 'DIVISÃO DE PLANEJAMENTO', 2, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (6, 'DCTD', 'DIVISÃO DE CAPACITAÇÃO, TREINAMENTO E DESENVOLVIMENTO', 3, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (7, 'DIPES', 'DIVISÃO DE PESSOAL', 3, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (8, 'DCSG', 'DIVISÃO DE COMPRAS E SERVIÇOS GERAIS', 4, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (9, 'DICOP', 'DIVISÃO DE COMUNICAÇÃO E PROTOCOLO', 4, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (10, 'DLC', 'DIVISÃO DE LICITAÇÕES E CONTRATOS', 4, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (11, 'SECOV', 'SERVIÇO DE CONTROLE DE DIÁRIAS/PASSAGEM', 4, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (12, 'DCONT', 'DIVISÃO DE CONTABILIDADE', 5, null);

INSERT INTO divisao (ID_DIVISAO, DSC_SIGLA, DSC_NOME, ID_COORDENACAO, ID_FUNCIONARIO_DIVISAO) VALUES (13, 'DIFIN', 'DIVISÃO FINANCEIRA', 5, null);


INSERT INTO funcionario (ID_FUNCIONARIO, BOL_ATIVO, DTA_NASCIMENTO, DSC_FATOR_RH, DSC_CPF, DSC_EMAIL, DTA_SAIDA, DSC_NOME, DSC_LOGIN_REDE, INT_MATRICULA, DTA_CADASTRO, BOL_TERMO_RESPONSABILIDADE, BOL_SEXO, ID_ENDERECO, ID_UF_NASCIMENTO, ID_COORDENACAO, ID_DIRETORIA, ID_DIVISAO, ID_DOCUMENTO_ELEITORAL, ID_CONTATO_EMERGENCIA, ID_CATEGORIA_FUNCIONARIO, ID_CARGO_FUNCIONARIO, ID_FILIACAO, ID_PLANO_SAUDE, ID_DADOS_TRABALHISTAS, ID_ESTADO_CIVIL, ID_DOCUMENTO_MILITAR, ID_RG, ID_CONJUGE, DSC_NATURALIDADE, ID_COR_PELE, DTA_ENTRADA) VALUES (2, true, now(), 'O+', '77777777777', 'mail@mail.com', null, 'felipe souza', 'felipe.sampaio', '213123', now(), true, true, 2, 7, 2, 6, 4, 1, null, 5, 11, 1, null, 1, 1, null, 1, null, 'BRASILEIRO', 1, now());
INSERT INTO funcionario (ID_FUNCIONARIO, BOL_ATIVO, DTA_NASCIMENTO, DSC_FATOR_RH, DSC_CPF, DSC_EMAIL, DTA_SAIDA, DSC_NOME, DSC_LOGIN_REDE, INT_MATRICULA, DTA_CADASTRO, BOL_TERMO_RESPONSABILIDADE, BOL_SEXO, ID_ENDERECO, ID_UF_NASCIMENTO, ID_COORDENACAO, ID_DIRETORIA, ID_DIVISAO, ID_DOCUMENTO_ELEITORAL, ID_CONTATO_EMERGENCIA, ID_CATEGORIA_FUNCIONARIO, ID_CARGO_FUNCIONARIO, ID_FILIACAO, ID_PLANO_SAUDE, ID_DADOS_TRABALHISTAS, ID_ESTADO_CIVIL, ID_DOCUMENTO_MILITAR, ID_RG, ID_CONJUGE, DSC_NATURALIDADE, ID_COR_PELE, DTA_ENTRADA) VALUES (3, true, now(), 'O+', '88888888888', 'mail@mail.com', null, 'Eduardo Santos', 'eduardo.santos', '213123', now(), true, true, 2, 7, 2, 6, 4, 1, null, 5, 11, 1, null, 1, 1, null, 1, null, 'BRASILEIRO', 1, now());
