--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public.empresa DROP CONSTRAINT fktnhiur1kpa3q7juxs8novr6np;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT fktgrcmnot3otuopt5fepv2ha5p;
ALTER TABLE ONLY public.rg DROP CONSTRAINT fktfgxa3i4a89k4tklu5oeh3qlw;
ALTER TABLE ONLY public.divisao DROP CONSTRAINT fkt7wv9154eoshcotpjnki6tgcb;
ALTER TABLE ONLY public.orgao DROP CONSTRAINT fksck60kwiuqc8rw9pmuo07fc4j;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fks855l3x9midr22sqj9swtvj48;
ALTER TABLE ONLY public.saida DROP CONSTRAINT fks4np7bq0cjwtcg3ngvtyvsirr;
ALTER TABLE ONLY public.contato_emergencia DROP CONSTRAINT fkqc852mylfwmpel7bf60069e2h;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkq4uqaudhnp6lqct6wo70umr8l;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT fkpk1q0appaseigxcamy8jl762u;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkpehl4be2mulssiw0np11a5e22;
ALTER TABLE ONLY public.servidor DROP CONSTRAINT fkp9defpi4q41cb2h73at0p618o;
ALTER TABLE ONLY public.diretoria DROP CONSTRAINT fkookr7tsbtcpllsywq94vf7ksa;
ALTER TABLE ONLY public.dependente DROP CONSTRAINT fkofll4316q3sue0khar3qtn01e;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fko9chbisbqy8igdl95wxfgap3e;
ALTER TABLE ONLY public.conta DROP CONSTRAINT fko797b6qsp9mp9hv5q21witda4;
ALTER TABLE ONLY public.documento_eleitoral DROP CONSTRAINT fknpr1fi6ecw0uxba0gyqf7q1v4;
ALTER TABLE ONLY public.empresa DROP CONSTRAINT fknpp981dvv4cc3bfptleerwfbm;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkn5q7ltk9uidqfy9fsw7jh6q65;
ALTER TABLE ONLY public.cidade DROP CONSTRAINT fkmw4snsmnccrgwb078vn6p6m5j;
ALTER TABLE ONLY public.telefone_funcionario DROP CONSTRAINT fkmk5cbvxdycpt98e1b1xhstr4h;
ALTER TABLE ONLY public.servidor DROP CONSTRAINT fkly5ji3fsuf961m1khgpef8b77;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkknnyhvmwohetrs2qo33ggj505;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkkg7vis41p9ryv8i7xcmvt6cbx;
ALTER TABLE ONLY public.conta DROP CONSTRAINT fkkbe0w8mcwxmvkye6i5527pbba;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkk2nce65qoex7gbg5q4tq1eh7p;
ALTER TABLE ONLY public.hobbie DROP CONSTRAINT fkjxl3v61uxad20umghbdd4xbqb;
ALTER TABLE ONLY public.documento_militar DROP CONSTRAINT fkjt1hv7d2b5cndb2byda35s63d;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkhbhyewfbirds5y2aw31tsnru;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkgr1o5eb3iu45etxtrqte4k40;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkgjky2jcofyj3u0yu0umh8sseu;
ALTER TABLE ONLY public.telefone DROP CONSTRAINT fkgdkm38yco3t8knb1sk1osi2a;
ALTER TABLE ONLY public.servidor DROP CONSTRAINT fkg4s48b6vyukosfhm5i3vgmxn4;
ALTER TABLE ONLY public.plano_saude DROP CONSTRAINT fkfti65u464ljhm3w5og6mr4m0t;
ALTER TABLE ONLY public.formacao DROP CONSTRAINT fkfs1p948nh3w5wgt21rr4g2e1m;
ALTER TABLE ONLY public.saida DROP CONSTRAINT fkesdg0roq5fm7prx2sb3kobfi4;
ALTER TABLE ONLY public.coordenacao DROP CONSTRAINT fkejhy0ent1wn9nf7lgmf584ngg;
ALTER TABLE ONLY public.terceiro DROP CONSTRAINT fkedlkwdsaoanohley2p2t33nsu;
ALTER TABLE ONLY public.telefone_funcionario DROP CONSTRAINT fkecvkskhu1e0je1uxqhas1hyuo;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkdyc6emsg4l3c6nqd3ro4dr4rf;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT fkdugi284bche6yfh7liq2kymci;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkdsao37s7j6niffmyhm7nemjmi;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkdrvyu7dpbcff08o8bkdatooac;
ALTER TABLE ONLY public.endereco DROP CONSTRAINT fkdl2qj4sw0uh0fxrvb31yn17pr;
ALTER TABLE ONLY public.empresa DROP CONSTRAINT fkd7pfihegc6i3inesdd7caqric;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkd0v7yhnduveytg071nk0jsur3;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkcmgjxpslydrqktqo7vbxd7je2;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fkbwwlv1k8jpxnn47htltsf5dm1;
ALTER TABLE ONLY public.divisao DROP CONSTRAINT fkbvnt2q3c0wms87famjfkdxbcr;
ALTER TABLE ONLY public.orgao DROP CONSTRAINT fkbod8h1ur8quu7rlcij57tvpyb;
ALTER TABLE ONLY public.coordenacao DROP CONSTRAINT fkat38uca0m13wa0ncb8kr0bhoi;
ALTER TABLE ONLY public.servidor DROP CONSTRAINT fk8rrn0orqojtw9pwalkl97bfvs;
ALTER TABLE ONLY public.orgao DROP CONSTRAINT fk8n6ah0wsnhdtrapw317bj5d47;
ALTER TABLE ONLY public.formacao DROP CONSTRAINT fk8843vhmvg72jnq7v9lm8c0501;
ALTER TABLE ONLY public.local_interno DROP CONSTRAINT fk8054lt7wvgaue0pqs9aymgfaj;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT fk7v7mmlg1u5ormoiv7uasc7qu5;
ALTER TABLE ONLY public.local_interno DROP CONSTRAINT fk7pvc0tneb5rxd0qv0tsswxioq;
ALTER TABLE ONLY public.orgao DROP CONSTRAINT fk6hyy5fwe1dt9ci65amc5qn331;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fk68p08al1sfkehu3xj31h7wy7k;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT fk5fjo58gnfvxuqevucooljo64k;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fk5ac9yfchfvqw5vxkpf16cw4cq;
ALTER TABLE ONLY public.orgao DROP CONSTRAINT fk4cohf6skyrg65sj36bb7sv3nu;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT fk3o53xoijqimt58eh9ibeel346;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT fk346rah3evptuo3h51klff5q2r;
ALTER TABLE ONLY public.terceiro DROP CONSTRAINT fk2edgfrrx74ptl5biwkawm51hq;
ALTER TABLE ONLY public.empresa DROP CONSTRAINT fk241nmu5wtgx8dsfv558it0g8y;
ALTER TABLE ONLY public.dependente DROP CONSTRAINT fk1d29oc6r6qxc1rui57aeqav9p;
ALTER TABLE ONLY public.uf DROP CONSTRAINT uf_pkey;
ALTER TABLE ONLY public.tipo_saida DROP CONSTRAINT tipo_saida_pkey;
ALTER TABLE ONLY public.terceiro DROP CONSTRAINT terceiro_pkey;
ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_pkey;
ALTER TABLE ONLY public.servidor DROP CONSTRAINT servidor_pkey;
ALTER TABLE ONLY public.saida DROP CONSTRAINT saida_pkey;
ALTER TABLE ONLY public.rg DROP CONSTRAINT rg_pkey;
ALTER TABLE ONLY public.predio DROP CONSTRAINT predio_pkey;
ALTER TABLE ONLY public.plano_saude DROP CONSTRAINT plano_saude_pkey;
ALTER TABLE ONLY public.orgao DROP CONSTRAINT orgao_pkey;
ALTER TABLE ONLY public.nivel_formacao DROP CONSTRAINT nivel_formacao_pkey;
ALTER TABLE ONLY public.local_interno DROP CONSTRAINT local_interno_pkey;
ALTER TABLE ONLY public.hobbie DROP CONSTRAINT hobbie_pkey;
ALTER TABLE ONLY public.historico_funcionario DROP CONSTRAINT historico_funcionario_pkey;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
ALTER TABLE ONLY public.formacao DROP CONSTRAINT formacao_pkey;
ALTER TABLE ONLY public.filiacao DROP CONSTRAINT filiacao_pkey;
ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_pkey;
ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
ALTER TABLE ONLY public.empresa_plano_de_saude DROP CONSTRAINT empresa_plano_de_saude_pkey;
ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
ALTER TABLE ONLY public.documento_militar DROP CONSTRAINT documento_militar_pkey;
ALTER TABLE ONLY public.documento_eleitoral DROP CONSTRAINT documento_eleitoral_pkey;
ALTER TABLE ONLY public.divisao DROP CONSTRAINT divisao_pkey;
ALTER TABLE ONLY public.diretoria DROP CONSTRAINT diretoria_pkey;
ALTER TABLE ONLY public.dependente DROP CONSTRAINT dependente_pkey;
ALTER TABLE ONLY public.dados_trabalhistas DROP CONSTRAINT dados_trabalhistas_pkey;
ALTER TABLE ONLY public.cor_pele DROP CONSTRAINT cor_pele_pkey;
ALTER TABLE ONLY public.coordenacao DROP CONSTRAINT coordenacao_pkey;
ALTER TABLE ONLY public.contato_emergencia DROP CONSTRAINT contato_emergencia_pkey;
ALTER TABLE ONLY public.conta DROP CONSTRAINT conta_pkey;
ALTER TABLE ONLY public.conjuge DROP CONSTRAINT conjuge_pkey;
ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
ALTER TABLE ONLY public.categoria_telefone DROP CONSTRAINT categoria_telefone_pkey;
ALTER TABLE ONLY public.categoria_funcionario DROP CONSTRAINT categoria_funcionario_pkey;
ALTER TABLE ONLY public.cargo_funcionario DROP CONSTRAINT cargo_funcionario_pkey;
ALTER TABLE ONLY public.banco DROP CONSTRAINT banco_pkey;
DROP SEQUENCE public.uf_id_seq;
DROP TABLE public.uf;
DROP SEQUENCE public.tipo_saida_id_seq;
DROP TABLE public.tipo_saida;
DROP SEQUENCE public.terceiro_id_seq;
DROP TABLE public.terceiro;
DROP SEQUENCE public.telefone_id_seq;
DROP TABLE public.telefone_funcionario;
DROP TABLE public.telefone;
DROP SEQUENCE public.servidor_id_seq;
DROP TABLE public.servidor;
DROP SEQUENCE public.saida_id_seq;
DROP TABLE public.saida;
DROP SEQUENCE public.rg_id_seq;
DROP TABLE public.rg;
DROP SEQUENCE public.predio_id_seq;
DROP TABLE public.predio;
DROP SEQUENCE public.plano_saude_id_seq;
DROP TABLE public.plano_saude;
DROP SEQUENCE public.orgao_id_seq;
DROP TABLE public.orgao;
DROP SEQUENCE public.nivel_formacao_id_seq;
DROP TABLE public.nivel_formacao;
DROP SEQUENCE public.local_interno_id_seq;
DROP TABLE public.local_interno;
DROP SEQUENCE public.hobbie_id_seq;
DROP TABLE public.hobbie;
DROP SEQUENCE public.historico_funcionario_id_seq;
DROP TABLE public.historico_funcionario;
DROP TABLE public.hibernate_sequence;
DROP SEQUENCE public.functionario_id_seq;
DROP TABLE public.funcionario;
DROP SEQUENCE public.formacao_id_seq;
DROP TABLE public.formacao;
DROP SEQUENCE public.filiacao_id_seq;
DROP TABLE public.filiacao;
DROP SEQUENCE public.estado_civil_id_seq;
DROP TABLE public.estado_civil;
DROP SEQUENCE public.endereco_id_seq;
DROP TABLE public.endereco;
DROP SEQUENCE public.empresa_plano_de_saude_id_seq;
DROP TABLE public.empresa_plano_de_saude;
DROP SEQUENCE public.empresa_id_seq;
DROP TABLE public.empresa;
DROP SEQUENCE public.documento_militar_id_seq;
DROP TABLE public.documento_militar;
DROP TABLE public.documento_eleitoral;
DROP SEQUENCE public.document_eleitoral_id_seq;
DROP SEQUENCE public.divisao_id_seq;
DROP TABLE public.divisao;
DROP SEQUENCE public.diretoria_id_seq;
DROP TABLE public.diretoria;
DROP SEQUENCE public.dependente_id_seq;
DROP TABLE public.dependente;
DROP SEQUENCE public.dados_trabalhistas_id_seq;
DROP TABLE public.dados_trabalhistas;
DROP SEQUENCE public.cor_pele_id_seq;
DROP TABLE public.cor_pele;
DROP SEQUENCE public.coordenacao_id_seq;
DROP TABLE public.coordenacao;
DROP SEQUENCE public.contato_emergencia_id_seq;
DROP TABLE public.contato_emergencia;
DROP SEQUENCE public.conta_id_seq;
DROP TABLE public.conta;
DROP SEQUENCE public.conjuge_id_seq;
DROP TABLE public.conjuge;
DROP SEQUENCE public.cidade_id_seq;
DROP TABLE public.cidade;
DROP SEQUENCE public.categoria_telefone_id_seq;
DROP TABLE public.categoria_telefone;
DROP SEQUENCE public.categoria_funcionario_id_seq;
DROP TABLE public.categoria_funcionario;
DROP SEQUENCE public.cargo_funcionario_id_seq;
DROP TABLE public.cargo_funcionario;
DROP SEQUENCE public.banco_id_seq;
DROP TABLE public.banco;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: banco; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE banco (
    id_banco bigint NOT NULL,
    int_codigo_banco integer NOT NULL,
    dsc_banco character varying(255) NOT NULL
);


ALTER TABLE banco OWNER TO aebrh;

--
-- Name: banco_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE banco_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE banco_id_seq OWNER TO aebrh;

--
-- Name: cargo_funcionario; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE cargo_funcionario (
    id_cargo_funcionario bigint NOT NULL,
    dsc_cargo character varying(255) NOT NULL,
    dsc_obs character varying(255)
);


ALTER TABLE cargo_funcionario OWNER TO aebrh;

--
-- Name: cargo_funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE cargo_funcionario_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cargo_funcionario_id_seq OWNER TO aebrh;

--
-- Name: categoria_funcionario; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE categoria_funcionario (
    id_categoria_funcionario bigint NOT NULL,
    dsc_categoria_funcionario character varying(255) NOT NULL
);


ALTER TABLE categoria_funcionario OWNER TO aebrh;

--
-- Name: categoria_funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE categoria_funcionario_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categoria_funcionario_id_seq OWNER TO aebrh;

--
-- Name: categoria_telefone; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE categoria_telefone (
    id_categoria_telefone bigint NOT NULL,
    dsc_categoria_telefone character varying(255) NOT NULL
);


ALTER TABLE categoria_telefone OWNER TO aebrh;

--
-- Name: categoria_telefone_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE categoria_telefone_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categoria_telefone_id_seq OWNER TO aebrh;

--
-- Name: cidade; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE cidade (
    id_cidade bigint NOT NULL,
    dsc_sigla_cidade character varying(255),
    dsc_nome_cidade character varying(255) NOT NULL,
    id_uf bigint NOT NULL
);


ALTER TABLE cidade OWNER TO aebrh;

--
-- Name: cidade_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE cidade_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cidade_id_seq OWNER TO aebrh;

--
-- Name: conjuge; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE conjuge (
    id_conjuge bigint NOT NULL,
    dta_nascimento_conjuge timestamp without time zone NOT NULL,
    dsc_conjuge character varying(255) NOT NULL
);


ALTER TABLE conjuge OWNER TO aebrh;

--
-- Name: conjuge_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE conjuge_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE conjuge_id_seq OWNER TO aebrh;

--
-- Name: conta; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE conta (
    id_conta bigint NOT NULL,
    dsc_conta character varying(255) NOT NULL,
    bol_ativa boolean NOT NULL,
    dsc_agencia character varying(255) NOT NULL,
    id_banco bigint NOT NULL,
    id_funcionario bigint NOT NULL
);


ALTER TABLE conta OWNER TO aebrh;

--
-- Name: conta_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE conta_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE conta_id_seq OWNER TO aebrh;

--
-- Name: contato_emergencia; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE contato_emergencia (
    id_contato_emergencia bigint NOT NULL,
    dsc_nome character varying(255) NOT NULL,
    id_telefone bigint NOT NULL
);


ALTER TABLE contato_emergencia OWNER TO aebrh;

--
-- Name: contato_emergencia_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE contato_emergencia_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE contato_emergencia_id_seq OWNER TO aebrh;

--
-- Name: coordenacao; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE coordenacao (
    id_coordenacao bigint NOT NULL,
    dsc_sigla character varying(255) NOT NULL,
    dsc_nome character varying(255) NOT NULL,
    id_funcionario_coordenador bigint,
    id_diretoria bigint NOT NULL
);


ALTER TABLE coordenacao OWNER TO aebrh;

--
-- Name: coordenacao_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE coordenacao_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE coordenacao_id_seq OWNER TO aebrh;

--
-- Name: cor_pele; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE cor_pele (
    id_cor_pele bigint NOT NULL,
    dsc_cor_de_pele character varying(255)
);


ALTER TABLE cor_pele OWNER TO aebrh;

--
-- Name: cor_pele_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE cor_pele_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cor_pele_id_seq OWNER TO aebrh;

--
-- Name: dados_trabalhistas; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE dados_trabalhistas (
    id_daods_trabalhistas bigint NOT NULL,
    dta_primeiro_emprego timestamp without time zone,
    dsc_pis_pasep character varying(255)
);


ALTER TABLE dados_trabalhistas OWNER TO aebrh;

--
-- Name: dados_trabalhistas_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE dados_trabalhistas_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dados_trabalhistas_id_seq OWNER TO aebrh;

--
-- Name: dependente; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE dependente (
    id_dependente bigint NOT NULL,
    dta_nascimento timestamp without time zone NOT NULL,
    dsc_cpf character varying(255) NOT NULL,
    dsc_nome character varying(255),
    id_funcionario bigint NOT NULL,
    id_filiacao bigint NOT NULL
);


ALTER TABLE dependente OWNER TO aebrh;

--
-- Name: dependente_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE dependente_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dependente_id_seq OWNER TO aebrh;

--
-- Name: diretoria; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE diretoria (
    id_diretoria bigint NOT NULL,
    dsc_sigla character varying(255) NOT NULL,
    dsc_email character varying(255) NOT NULL,
    bol_extinto boolean NOT NULL,
    dsc_nome character varying(255) NOT NULL,
    dsc_obs character varying(255),
    id_funcionario_diretor bigint
);


ALTER TABLE diretoria OWNER TO aebrh;

--
-- Name: diretoria_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE diretoria_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE diretoria_id_seq OWNER TO aebrh;

--
-- Name: divisao; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE divisao (
    id_divisao bigint NOT NULL,
    dsc_sigla character varying(255) NOT NULL,
    dsc_nome character varying(255) NOT NULL,
    id_coordenacao bigint,
    id_funcionario_divisao bigint
);


ALTER TABLE divisao OWNER TO aebrh;

--
-- Name: divisao_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE divisao_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE divisao_id_seq OWNER TO aebrh;

--
-- Name: document_eleitoral_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE document_eleitoral_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE document_eleitoral_id_seq OWNER TO aebrh;

--
-- Name: documento_eleitoral; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE documento_eleitoral (
    id_documento_eleitoral bigint NOT NULL,
    dsc_secao_titulo_eleitor character varying(255),
    dsc_titulo_eleitor character varying(255),
    dsc_zona_titulo_eleitor character varying(255),
    id_uf bigint
);


ALTER TABLE documento_eleitoral OWNER TO aebrh;

--
-- Name: documento_militar; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE documento_militar (
    id_documento_militar bigint NOT NULL,
    dsc_categoria_reservista character varying(255) NOT NULL,
    dsc_numero_reservista character varying(255) NOT NULL,
    dsc_serie_reservista character varying(255) NOT NULL,
    id_uf bigint NOT NULL
);


ALTER TABLE documento_militar OWNER TO aebrh;

--
-- Name: documento_militar_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE documento_militar_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE documento_militar_id_seq OWNER TO aebrh;

--
-- Name: empresa; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE empresa (
    id_empresa bigint NOT NULL,
    dsc_cnpj character varying(255) NOT NULL,
    dsc_email character varying(255) NOT NULL,
    dsc_nome_fantasia character varying(255) NOT NULL,
    dsc_nome character varying(255) NOT NULL,
    dsc_obs character varying(255),
    bol_vigente boolean NOT NULL,
    dta_cadastro timestamp without time zone NOT NULL,
    dsc_url_site character varying(255),
    dta_update timestamp without time zone NOT NULL,
    id_endereco bigint NOT NULL,
    id_telefone_fax bigint,
    id_telefone bigint NOT NULL,
    id_telefone_secundario bigint
);


ALTER TABLE empresa OWNER TO aebrh;

--
-- Name: empresa_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE empresa_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE empresa_id_seq OWNER TO aebrh;

--
-- Name: empresa_plano_de_saude; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE empresa_plano_de_saude (
    id_empresa_plano_de_saude bigint NOT NULL,
    dsc_nome character varying(255)
);


ALTER TABLE empresa_plano_de_saude OWNER TO aebrh;

--
-- Name: empresa_plano_de_saude_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE empresa_plano_de_saude_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE empresa_plano_de_saude_id_seq OWNER TO aebrh;

--
-- Name: endereco; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE endereco (
    id_endereco bigint NOT NULL,
    dsc_logradouro character varying(255) NOT NULL,
    dsc_complemento character varying(255),
    dsc_bairro character varying(255),
    dsc_numero character varying(255),
    dsc_cep character varying(255) NOT NULL,
    id_cidade bigint
);


ALTER TABLE endereco OWNER TO aebrh;

--
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE endereco_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE endereco_id_seq OWNER TO aebrh;

--
-- Name: estado_civil; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE estado_civil (
    id_estado_civil bigint NOT NULL,
    dsc_estado_civil character varying(255) NOT NULL
);


ALTER TABLE estado_civil OWNER TO aebrh;

--
-- Name: estado_civil_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE estado_civil_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estado_civil_id_seq OWNER TO aebrh;

--
-- Name: filiacao; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE filiacao (
    id_filiacao bigint NOT NULL,
    dsc_nome_pai character varying(255),
    dsc_nome_mae character varying(255) NOT NULL
);


ALTER TABLE filiacao OWNER TO aebrh;

--
-- Name: filiacao_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE filiacao_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE filiacao_id_seq OWNER TO aebrh;

--
-- Name: formacao; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE formacao (
    id_formacao bigint NOT NULL,
    dta_inicio timestamp without time zone,
    dta_conclusao timestamp without time zone,
    dsc_curso character varying(255),
    dsc_instituicao character varying(255) NOT NULL,
    dsc_obs character varying(255),
    dta_atualizacao timestamp without time zone,
    id_nivel_formacao bigint NOT NULL,
    id_funcionario bigint NOT NULL
);


ALTER TABLE formacao OWNER TO aebrh;

--
-- Name: formacao_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE formacao_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE formacao_id_seq OWNER TO aebrh;

--
-- Name: funcionario; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE funcionario (
    id_funcionario bigint NOT NULL,
    bol_ativo boolean NOT NULL,
    dta_nascimento timestamp without time zone NOT NULL,
    dsc_fator_rh character varying(255),
    dsc_cpf character varying(255) NOT NULL,
    dsc_email character varying(255) NOT NULL,
    dta_saida timestamp without time zone,
    dsc_nome character varying(255) NOT NULL,
    dsc_login_rede character varying(255) NOT NULL,
    dsc_naturalidade character varying(255) NOT NULL,
    int_matricula integer NOT NULL,
    dta_cadastro timestamp without time zone NOT NULL,
    bol_termo_responsabilidade boolean NOT NULL,
    bol_sexo boolean NOT NULL,
    id_endereco bigint,
    id_uf_nascimento bigint,
    id_coordenacao bigint,
    id_diretoria bigint NOT NULL,
    id_divisao bigint,
    id_documento_eleitoral bigint,
    id_contato_emergencia bigint,
    id_categoria_funcionario bigint NOT NULL,
    id_cargo_funcionario bigint NOT NULL,
    id_filiacao bigint NOT NULL,
    id_plano_saude bigint,
    id_ramal bigint,
    id_dados_trabalhistas bigint,
    id_estado_civil bigint,
    id_documento_militar bigint,
    id_terceiro bigint,
    id_servidor bigint,
    id_rg bigint NOT NULL,
    id_cor_pele bigint,
    id_conjuge bigint
);


ALTER TABLE funcionario OWNER TO aebrh;

--
-- Name: functionario_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE functionario_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE functionario_id_seq OWNER TO aebrh;

--
-- Name: hibernate_sequence; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE hibernate_sequence (
    next_val bigint
);


ALTER TABLE hibernate_sequence OWNER TO aebrh;

--
-- Name: historico_funcionario; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE historico_funcionario (
    id_historico_funcionario bigint NOT NULL,
    bol_ativo boolean NOT NULL,
    dta_saida timestamp without time zone,
    dta_alteracao timestamp without time zone NOT NULL,
    id_coordenacao bigint,
    id_diretoria bigint NOT NULL,
    id_divisao bigint,
    id_funcionario bigint NOT NULL,
    id_categoria_funcionario bigint NOT NULL,
    id_cargo_funcionario bigint NOT NULL
);


ALTER TABLE historico_funcionario OWNER TO aebrh;

--
-- Name: historico_funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE historico_funcionario_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE historico_funcionario_id_seq OWNER TO aebrh;

--
-- Name: hobbie; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE hobbie (
    id_hobbie bigint NOT NULL,
    dsc_description character varying(255),
    id_funcionario bigint NOT NULL
);


ALTER TABLE hobbie OWNER TO aebrh;

--
-- Name: hobbie_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE hobbie_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hobbie_id_seq OWNER TO aebrh;

--
-- Name: local_interno; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE local_interno (
    id_local_interno bigint NOT NULL,
    dta_cadastro timestamp without time zone NOT NULL,
    dsc_numero_sala character varying(255),
    id_predio bigint NOT NULL,
    id_telefone_ramal bigint
);


ALTER TABLE local_interno OWNER TO aebrh;

--
-- Name: local_interno_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE local_interno_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE local_interno_id_seq OWNER TO aebrh;

--
-- Name: nivel_formacao; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE nivel_formacao (
    id_nivel_formacao bigint NOT NULL,
    dsc_nivel_formacao character varying(255) NOT NULL
);


ALTER TABLE nivel_formacao OWNER TO aebrh;

--
-- Name: nivel_formacao_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE nivel_formacao_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE nivel_formacao_id_seq OWNER TO aebrh;

--
-- Name: orgao; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE orgao (
    id_orgao bigint NOT NULL,
    dsc_sigla character varying(255) NOT NULL,
    dsc_codigo character varying(255) NOT NULL,
    dsc_nome character varying(255) NOT NULL,
    dsc_url_site character varying(255) NOT NULL,
    id_endereco bigint NOT NULL,
    id_cidade bigint NOT NULL,
    id_telefone_fax bigint,
    id_telefone bigint NOT NULL,
    id_uf bigint NOT NULL
);


ALTER TABLE orgao OWNER TO aebrh;

--
-- Name: orgao_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE orgao_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orgao_id_seq OWNER TO aebrh;

--
-- Name: plano_saude; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE plano_saude (
    id_plano_saude bigint NOT NULL,
    dta_validade timestamp without time zone,
    dsc_numero character varying(255),
    id_empresa_plano_de_saude bigint
);


ALTER TABLE plano_saude OWNER TO aebrh;

--
-- Name: plano_saude_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE plano_saude_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE plano_saude_id_seq OWNER TO aebrh;

--
-- Name: predio; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE predio (
    id_predio bigint NOT NULL,
    dsc_predio character varying(255) NOT NULL
);


ALTER TABLE predio OWNER TO aebrh;

--
-- Name: predio_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE predio_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE predio_id_seq OWNER TO aebrh;

--
-- Name: rg; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE rg (
    id_rg bigint NOT NULL,
    dta_expedicao timestamp without time zone NOT NULL,
    dsc_orgao_emissor character varying(255) NOT NULL,
    dsc_rg character varying(255) NOT NULL,
    id_uf bigint
);


ALTER TABLE rg OWNER TO aebrh;

--
-- Name: rg_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE rg_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rg_id_seq OWNER TO aebrh;

--
-- Name: saida; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE saida (
    id_saida bigint NOT NULL,
    dta_dia_saida timestamp without time zone,
    num_duracao bigint,
    dta_dia_fim_saida timestamp without time zone,
    txt_observacao character varying(255),
    bol_vigente boolean,
    id_funcionario bigint,
    id_tipo_saida bigint
);


ALTER TABLE saida OWNER TO aebrh;

--
-- Name: saida_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE saida_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE saida_id_seq OWNER TO aebrh;

--
-- Name: servidor; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE servidor (
    id_servidor bigint NOT NULL,
    dta_entrada timestamp without time zone NOT NULL,
    dta_ingresso timestamp without time zone NOT NULL,
    dta_ato_nomeacao timestamp without time zone NOT NULL,
    dta_publicacao_dou timestamp without time zone NOT NULL,
    bol_aposentado boolean NOT NULL,
    id_coordenacao_origem bigint,
    id_diretoria_origem bigint,
    id_divisao_origim bigint,
    id_orgao bigint NOT NULL
);


ALTER TABLE servidor OWNER TO aebrh;

--
-- Name: servidor_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE servidor_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE servidor_id_seq OWNER TO aebrh;

--
-- Name: telefone; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE telefone (
    id_telefone bigint NOT NULL,
    dsc_codigo_pais character varying(255),
    dcs_ddd character varying(255),
    dsc_numero character varying(255) NOT NULL,
    id_categoria_telefone bigint NOT NULL
);


ALTER TABLE telefone OWNER TO aebrh;

--
-- Name: telefone_funcionario; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE telefone_funcionario (
    id_funcionario bigint NOT NULL,
    id_telefone bigint NOT NULL
);


ALTER TABLE telefone_funcionario OWNER TO aebrh;

--
-- Name: telefone_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE telefone_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE telefone_id_seq OWNER TO aebrh;

--
-- Name: terceiro; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE terceiro (
    id_terceiro bigint NOT NULL,
    bol_ativo boolean NOT NULL,
    dsc_clt character varying(255) NOT NULL,
    dsc_orgao_clt character varying(255) NOT NULL,
    dta_expedicao_clt timestamp without time zone NOT NULL,
    dta_entrada timestamp without time zone NOT NULL,
    dta_saida timestamp without time zone,
    dta_atualizacao timestamp without time zone NOT NULL,
    id_empresa bigint NOT NULL,
    id_uf bigint NOT NULL
);


ALTER TABLE terceiro OWNER TO aebrh;

--
-- Name: terceiro_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE terceiro_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE terceiro_id_seq OWNER TO aebrh;

--
-- Name: tipo_saida; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE tipo_saida (
    id_tipo_saida bigint NOT NULL,
    txt_codigo character varying(255),
    txt_nome_tipo character varying(255)
);


ALTER TABLE tipo_saida OWNER TO aebrh;

--
-- Name: tipo_saida_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE tipo_saida_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_saida_id_seq OWNER TO aebrh;

--
-- Name: uf; Type: TABLE; Schema: public; Owner: aebrh; Tablespace: 
--

CREATE TABLE uf (
    id_uf bigint NOT NULL,
    dsc_sigla character varying(255) NOT NULL,
    dsc_nome character varying(255) NOT NULL
);


ALTER TABLE uf OWNER TO aebrh;

--
-- Name: uf_id_seq; Type: SEQUENCE; Schema: public; Owner: aebrh
--

CREATE SEQUENCE uf_id_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE uf_id_seq OWNER TO aebrh;

--
-- Data for Name: banco; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY banco (id_banco, int_codigo_banco, dsc_banco) FROM stdin;
1	1	BANCO DO BRASIL S.A.
2	3	BANCO DA AMAZONIA S.A.
3	4	BANCO DO NORDESTE DO BRASIL S.A.
4	19	BANCO AZTECA DO BRASIL S.A.
5	21	BANESTES S.A. BANCO DO ESTADO DO ESPIRITO SANTO
6	25	BANCO ALFA S.A
7	33	BANCO SANTANDER BANESPA S.A.
8	37	BANCO DO ESTADO DO PARÁ S.A.
9	40	BANCO CARGILL S.A.
10	41	BANCO DO ESTADO DO RIO GRANDE DO SUL S.A.
11	44	BANCO BVA S.A.
12	45	BANCO OPPORTUNITY S.A.
13	47	BANCO DO ESTADO DE SERGIPE S.A.
14	62	HIPERCARD BANCO MÚLTIPLO S.A.
15	63	BANCO IBI S.A. - BANCO MÚLTIPLO
16	65	BANCO LEMON S.A.
17	66	BANCO MORGAN STANLEY S.A.
18	69	BPN BRASIL BANCO MÚLTIPLO S.A.
19	70	BRB - BANCO DE BRASILIA S.A.
20	72	BANCO RURAL MAIS S.A.
21	73	BB BANCO POPULAR DO BRASIL S.A.
22	74	BANCO J. SAFRA S.A.
23	75	BANCO CR2 S/A
24	76	BANCO KDB DO BRASIL S.A.
25	77	BANCO INTERMEDIUM S/A
26	79	JBS BANCO S/A
27	81	CONCÓRDIA BANCO S.A.
28	96	BANCO BM&F DE SERVIÇOS DE LIQUIDAÇÃO E CUSTÓDIA S.A.
29	104	CAIXA ECONOMICA FEDERAL
30	107	BANCO BBM S/A
31	151	BANCO NOSSA CAIXA S.A.
32	208	BANCO UBS PACTUAL S.A.
33	212	BANCO MATONE S.A.
34	213	BANCO ARBI S.A.
35	214	BANCO DIBENS S.A.
36	217	BANCO JOHN DEERE S.A.
37	218	BANCO BONSUCESSO S.A.
38	222	BANCO CALYON BRASIL S.A.
39	224	BANCO FIBRA S.A.
40	225	BANCO BRASCAN S.A.
41	229	BANCO CRUZEIRO DO SUL S.A.
42	230	UNICARD BANCO MÚLTIPLO S.A.
43	233	BANCO GE CAPITAL S.A.
44	237	BANCO BRADESCO S.A.
45	241	BANCO CLASSICO S.A.
46	243	BANCO MÁXIMA S.A.
47	246	BANCO ABC BRASIL S.A.
48	248	BANCO BOAVISTA INTERATLANTICO S.A.
49	249	BANCO INVESTCRED UNIBANCO S.A.
50	250	BANCO SCHAHIN S.A.
51	254	PARANÁ BANCO S.A.
52	263	BANCO CACIQUE S.A.
53	265	BANCO FATOR S.A.
54	266	BANCO CEDULA S.A.
55	300	BANCO DE LA NACION ARGENTINA
56	318	BANCO BMG S.A.
57	341	BANCO ITAÚ S.A.
58	356	BANCO ABN AMRO REAL S.A.
59	366	BANCO SOCIETE GENERALE BRASIL S.A.
60	370	BANCO WESTLB DO BRASIL S.A.
61	376	BANCO J.P. MORGAN S.A.
62	389	BANCO MERCANTIL DO BRASIL S.A.
63	394	BANCO FINASA BMC S.A.
64	399	HSBC BANK BRASIL S.A. - BANCO MULTIPLO
65	409	UNIBANCO-UNIAO DE BANCOS BRASILEIROS S.A.
66	412	BANCO CAPITAL S.A.
67	422	BANCO SAFRA S.A.
68	453	BANCO RURAL S.A.
69	456	BANCO DE TOKYO-MITSUBISHI UFJ BRASIL S/A
70	464	BANCO SUMITOMO MITSUI BRASILEIRO S.A.
71	477	CITIBANK N.A.
72	487	DEUTSCHE BANK S.A. - BANCO ALEMAO
73	488	JPMORGAN CHASE BANK, NATIONAL ASSOCIATION
74	492	ING BANK N.V.
75	494	BANCO DE LA REPUBLICA ORIENTAL DEL URUGUAY
76	495	BANCO DE LA PROVINCIA DE BUENOS AIRES
77	505	BANCO CREDIT SUISSE (BRASIL) S.A.
78	600	BANCO LUSO BRASILEIRO S.A.
79	604	BANCO INDUSTRIAL DO BRASIL S.A.
80	610	BANCO VR S.A.
81	611	BANCO PAULISTA S.A.
82	612	BANCO GUANABARA S.A.
83	613	BANCO PECUNIA S.A.
84	623	BANCO PANAMERICANO S.A.
85	626	BANCO FICSA S.A.
86	630	BANCO INTERCAP S.A.
87	633	BANCO RENDIMENTO S.A.
88	634	BANCO TRIANGULO S.A.
89	637	BANCO SOFISA S.A.
90	638	BANCO PROSPER S.A.
91	643	BANCO PINE S.A.
92	653	BANCO INDUSVAL S.A.
93	654	BANCO A.J. RENNER S.A.
94	655	BANCO VOTORANTIM S.A.
95	707	BANCO DAYCOVAL S.A.
96	719	BANIF - BANCO INTERNACIONAL DO FUNCHAL (BRASIL), S.A.
97	721	BANCO CREDIBEL S.A.
98	734	BANCO GERDAU S.A
99	735	BANCO POTTENCIAL S.A.
100	738	BANCO MORADA S.A.
101	739	BANCO BGN S.A.
102	740	BANCO BARCLAYS S.A.
103	741	BANCO RIBEIRAO PRETO S.A.
104	743	BANCO EMBLEMA S.A.
105	745	BANCO CITIBANK S.A.
106	746	BANCO MODAL S.A.
107	747	BANCO RABOBANK INTERNATIONAL BRASIL S.A.
108	748	BANCO COOPERATIVO SICREDI S.A.
109	749	BANCO SIMPLES S.A.
110	751	DRESDNER BANK BRASIL S.A. BANCO MULTIPLO
111	752	BANCO BNP PARIBAS BRASIL S.A.
112	753	NBC BANK BRASIL S. A. - BANCO MÚLTIPLO
113	756	BANCO COOPERATIVO DO BRASIL S.A. - BANCOOB
114	757	BANCO KEB DO BRASIL S.A.
115	0	Não informado
\.


--
-- Name: banco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('banco_id_seq', 1000, false);


--
-- Data for Name: cargo_funcionario; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY cargo_funcionario (id_cargo_funcionario, dsc_cargo, dsc_obs) FROM stdin;
1	Diretor	DAS 101.5
2	Administrador de Rede	Administrador de Rede
3	Estagiário	Estagiário
4	Coordenador	DAS 101.3
6	Administrador do Sistema	Administrador do Sistema
7	Programador	Programador
8	Analista de Sistema	Analista de Sistema
9	Gerente de Projeto	Gerente de Projeto
10	Chefe de Divisão	DAS 101.2
11	Chefe de Serviço	DAS 101.1
12	Assistente Administrativo	Assistente Administrativo
13	Suporte Técnico	Técnico de Informática
14	Assistente Técnico	DAS 102.1
15	Assistente	DAS 102.2
16	Assessor Técnico	DAS 102.3
17	Chefe de Gabinete	DAS 101.4
18	Auditor-Chefe	DAS 101.3
19	Chefe de Assessoria	DAS 101.4
20	Presidente	NE
24	Procurador Chefe	DAS 101.4
25	Função Gratificada	FG-1
26	Sem Função	cedido
27	Motorista Oficial	\N
28	Motorista	\N
29	Jornalista	\N
30	Copeira	Terceirizados
31	Auxiliar de Serviços Gerais	Treceirizado
32	Garçom	Terceirizado
33	Gestor de Programas e Projetos	Gestor de Programas e Projetos
34	Assistente em Ciência e Tecnologia	Assistente em Ciência e Tecnologia
35	Tecnologista	Tecnologista
36	Analista em Ciência e Tecnologia	Analista em Ciência e Tecnologia
\.


--
-- Name: cargo_funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('cargo_funcionario_id_seq', 1000, false);


--
-- Data for Name: categoria_funcionario; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY categoria_funcionario (id_categoria_funcionario, dsc_categoria_funcionario) FROM stdin;
1	Outros
2	Convêniado
3	Estagiário
4	Terceirizado
5	Servidor
6	Sem vínculo
7	Bolsista
\.


--
-- Name: categoria_funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('categoria_funcionario_id_seq', 1000, false);


--
-- Data for Name: categoria_telefone; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY categoria_telefone (id_categoria_telefone, dsc_categoria_telefone) FROM stdin;
1	TELEFONE CELULAR
2	TELEFONE RESIDENCIAL
3	FAX
4	RAMAL
5	COMERCIAL
\.


--
-- Name: categoria_telefone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('categoria_telefone_id_seq', 1000, false);


--
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY cidade (id_cidade, dsc_sigla_cidade, dsc_nome_cidade, id_uf) FROM stdin;
1	BSB	Brasília	7
2	\N	Belém	14
3	BH	Belo Horizonte	13
\.


--
-- Name: cidade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('cidade_id_seq', 1000, false);


--
-- Data for Name: conjuge; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY conjuge (id_conjuge, dta_nascimento_conjuge, dsc_conjuge) FROM stdin;
\.


--
-- Name: conjuge_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('conjuge_id_seq', 1000, false);


--
-- Data for Name: conta; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY conta (id_conta, dsc_conta, bol_ativa, dsc_agencia, id_banco, id_funcionario) FROM stdin;
\.


--
-- Name: conta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('conta_id_seq', 1000, false);


--
-- Data for Name: contato_emergencia; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY contato_emergencia (id_contato_emergencia, dsc_nome, id_telefone) FROM stdin;
\.


--
-- Name: contato_emergencia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('contato_emergencia_id_seq', 1000, false);


--
-- Data for Name: coordenacao; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY coordenacao (id_coordenacao, dsc_sigla, dsc_nome, id_funcionario_coordenador, id_diretoria) FROM stdin;
1	CCS	COORDENAÇÃO DE COMUNICAÇÃO SOCIAL	\N	2
2	CPM	COORDENAÇÃO DE PLANEJAMENTO E MODERNIZAÇÃO	\N	6
3	CRH	COORDENAÇÃO DE RECURSOS HUMANOS	\N	6
4	CRL	COORDENAÇÃO DE RECURSOS LOGÍSTICOS	\N	6
5	COF	COORDENAÇÃO ORÇAMENTÁRIA E FINANCEIRA	\N	6
6	CIE	COORDENAÇÃO DE INVESTIMENTOS ESTRATÉGICOS	\N	7
7	CPP	COORDENAÇÃO DE POLÍTICAS E PLANOS	\N	7
8	CPA	COORDENAÇÃO DE PROGRAMAÇÃO E AVALIAÇÃO	\N	7
9	CPDI	COORDENAÇÃO DE PESQUISA, DESENVOLVIMENTO E INOVAÇÃO	\N	8
10	CSA	COORDENAÇÃO DE SATÉLITES E APLICAÇÕES	\N	8
11	CCL	COORDENAÇÃO DE CENTROS DE LANÇAMENTO	\N	9
12	CNL	COORDENAÇÃO DE NORMALIZAÇÃO E LICENCIAMENTO	\N	9
13	CVL	COORDENAÇÃO DE VEICULOS LANÇADORES	\N	9
\.


--
-- Name: coordenacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('coordenacao_id_seq', 1000, false);


--
-- Data for Name: cor_pele; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY cor_pele (id_cor_pele, dsc_cor_de_pele) FROM stdin;
1	BRANCO
\.


--
-- Name: cor_pele_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('cor_pele_id_seq', 1000, false);


--
-- Data for Name: dados_trabalhistas; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY dados_trabalhistas (id_daods_trabalhistas, dta_primeiro_emprego, dsc_pis_pasep) FROM stdin;
1	2016-11-07 12:36:12.66111	PisPasep
\.


--
-- Name: dados_trabalhistas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('dados_trabalhistas_id_seq', 1000, false);


--
-- Data for Name: dependente; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY dependente (id_dependente, dta_nascimento, dsc_cpf, dsc_nome, id_funcionario, id_filiacao) FROM stdin;
\.


--
-- Name: dependente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('dependente_id_seq', 1000, false);


--
-- Data for Name: diretoria; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY diretoria (id_diretoria, dsc_sigla, dsc_email, bol_extinto, dsc_nome, dsc_obs, id_funcionario_diretor) FROM stdin;
1	PRE	presidencia@aeb.gov.br	f	PRESIDÊNCIA	Presidência da AEB	\N
2	GAB	gab@aeb.gov.br	f	GABINETE	Gabinete da Presidência	\N
3	PF	pf@aeb.gov.br	f	PROCURADORIA FEDERAL	Procuradoria Federal	\N
4	AI	auditoria.aeb@aeb.gov.br	f	AUDITORIA INTERNA	\N	\N
5	ACI	aci@aeb.gov.br	f	ACESSORIA DE COOPERAÇÃO INTERNACIONAL	Assessoria de Cooperação Internacional	\N
6	DPOA	dpoa@aeb.gov.br	f	DIRETORIA DE PLANEJAMENTO, ORÇAMENTO E ADMINISTRAÇÃO	\N	\N
7	DPEI	dpei@aeb.gov.br	f	DIRETORIA DE POLÍTICA ESPACIAL E INVESTIMENTOS ESTRATÉGICOS	\N	\N
8	DSAD	dsad@aeb.gov.br	f	DIRETORIA DE SATELITES, APLICAÇÕES E DESENVOLVIMENTO	\N	\N
9	DTEL	dtel@aeb.gov.br	f	DIRETORIA DE TRANSPORTE ESPACIAL E LICENCIAMENTO	\N	\N
\.


--
-- Name: diretoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('diretoria_id_seq', 1000, false);


--
-- Data for Name: divisao; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY divisao (id_divisao, dsc_sigla, dsc_nome, id_coordenacao, id_funcionario_divisao) FROM stdin;
1	EVENTOS	DIVISÃO DE EVENTOS	1	\N
2	IMPRENSA	DIVISÃO DE IMPRENSA	1	\N
3	CRIAÇÃO	DIVISÃO DE PROJETOS E CRIAÇÃO	1	\N
4	DINF	DIVISÃO DE INFORMÁTICA	2	\N
5	DPLAN	DIVISÃO DE PLANEJAMENTO	2	\N
6	DCTD	DIVISÃO DE CAPACITAÇÃO, TREINAMENTO E DESENVOLVIMENTO	3	\N
7	DIPES	DIVISÃO DE PESSOAL	3	\N
8	DCSG	DIVISÃO DE COMPRAS E SERVIÇOS GERAIS	4	\N
9	DICOP	DIVISÃO DE COMUNICAÇÃO E PROTOCOLO	4	\N
10	DLC	DIVISÃO DE LICITAÇÕES E CONTRATOS	4	\N
11	SECOV	SERVIÇO DE CONTROLE DE DIÁRIAS/PASSAGEM	4	\N
12	DCONT	DIVISÃO DE CONTABILIDADE	5	\N
13	DIFIN	DIVISÃO FINANCEIRA	5	\N
\.


--
-- Name: divisao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('divisao_id_seq', 1000, false);


--
-- Name: document_eleitoral_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('document_eleitoral_id_seq', 1000, false);


--
-- Data for Name: documento_eleitoral; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY documento_eleitoral (id_documento_eleitoral, dsc_secao_titulo_eleitor, dsc_titulo_eleitor, dsc_zona_titulo_eleitor, id_uf) FROM stdin;
1	123	1231	123	7
\.


--
-- Data for Name: documento_militar; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY documento_militar (id_documento_militar, dsc_categoria_reservista, dsc_numero_reservista, dsc_serie_reservista, id_uf) FROM stdin;
\.


--
-- Name: documento_militar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('documento_militar_id_seq', 1000, false);


--
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY empresa (id_empresa, dsc_cnpj, dsc_email, dsc_nome_fantasia, dsc_nome, dsc_obs, bol_vigente, dta_cadastro, dsc_url_site, dta_update, id_endereco, id_telefone_fax, id_telefone, id_telefone_secundario) FROM stdin;
\.


--
-- Name: empresa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('empresa_id_seq', 1000, false);


--
-- Data for Name: empresa_plano_de_saude; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY empresa_plano_de_saude (id_empresa_plano_de_saude, dsc_nome) FROM stdin;
1	SIS
\.


--
-- Name: empresa_plano_de_saude_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('empresa_plano_de_saude_id_seq', 1000, false);


--
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY endereco (id_endereco, dsc_logradouro, dsc_complemento, dsc_bairro, dsc_numero, dsc_cep, id_cidade) FROM stdin;
2	QUADRA 506 EDIFICIO POLIEDRO	\N		7	2500000	1
\.


--
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('endereco_id_seq', 1000, false);


--
-- Data for Name: estado_civil; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY estado_civil (id_estado_civil, dsc_estado_civil) FROM stdin;
1	Solteiro
2	Casado
3	Viúvo
4	Separado judicialmente
5	Divorciado
6	Outros
\.


--
-- Name: estado_civil_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('estado_civil_id_seq', 1000, false);


--
-- Data for Name: filiacao; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY filiacao (id_filiacao, dsc_nome_pai, dsc_nome_mae) FROM stdin;
1	Nome da mãe	Nome do pai
\.


--
-- Name: filiacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('filiacao_id_seq', 1000, false);


--
-- Data for Name: formacao; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY formacao (id_formacao, dta_inicio, dta_conclusao, dsc_curso, dsc_instituicao, dsc_obs, dta_atualizacao, id_nivel_formacao, id_funcionario) FROM stdin;
\.


--
-- Name: formacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('formacao_id_seq', 1000, false);


--
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY funcionario (id_funcionario, bol_ativo, dta_nascimento, dsc_fator_rh, dsc_cpf, dsc_email, dta_saida, dsc_nome, dsc_login_rede, dsc_naturalidade, int_matricula, dta_cadastro, bol_termo_responsabilidade, bol_sexo, id_endereco, id_uf_nascimento, id_coordenacao, id_diretoria, id_divisao, id_documento_eleitoral, id_contato_emergencia, id_categoria_funcionario, id_cargo_funcionario, id_filiacao, id_plano_saude, id_ramal, id_dados_trabalhistas, id_estado_civil, id_documento_militar, id_terceiro, id_servidor, id_rg, id_cor_pele, id_conjuge) FROM stdin;
2	t	2016-11-07 12:36:13.172399	O+	00000000000	mail@mail.com	\N	felipe souza	felipe.sampaio	BRASILEIRO	213123	2016-11-07 12:36:13.172399	t	t	2	7	2	6	4	1	\N	5	11	1	\N	\N	1	1	\N	\N	\N	1	1	\N
3	t	2016-11-07 12:36:13.183466	O+	00000000000	mail@mail.com	\N	Eduardo Santos	eduardo.santos	BRASILEIRO	213123	2016-11-07 12:36:13.183466	t	t	2	7	2	6	4	1	\N	5	11	1	\N	\N	1	1	\N	\N	\N	1	1	\N
1	t	2016-11-07 12:36:13.206764	O+	11111111111	mail@mail.com	\N	Thiago Kairala	thiago.kairala	BRASILEIRO	213123	2016-11-07 12:36:13.206764	t	t	2	7	2	6	4	1	\N	5	11	1	\N	\N	1	1	\N	\N	\N	1	1	\N
4	t	2016-11-07 12:36:13.216872	O+	00000000000	mail@mail.com	\N	Lucas Cavalcanti Rosa	lucas.rosa	BRASILEIRO	213123	2016-11-07 12:36:13.216872	t	t	2	7	2	6	4	1	\N	5	11	1	\N	\N	1	1	\N	\N	\N	1	1	\N
5	t	2016-11-07 12:36:13.228051	O+	00000000000	mail@mail.com	\N	Paulo Henrique a Silva Junior	paulo.junior	BRASILEIRO	213123	2016-11-07 12:36:13.228051	t	t	2	7	2	6	4	1	\N	5	11	1	\N	\N	1	1	\N	\N	\N	1	1	\N
\.


--
-- Name: functionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('functionario_id_seq', 1000, false);


--
-- Data for Name: hibernate_sequence; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY hibernate_sequence (next_val) FROM stdin;
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
\.


--
-- Data for Name: historico_funcionario; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY historico_funcionario (id_historico_funcionario, bol_ativo, dta_saida, dta_alteracao, id_coordenacao, id_diretoria, id_divisao, id_funcionario, id_categoria_funcionario, id_cargo_funcionario) FROM stdin;
\.


--
-- Name: historico_funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('historico_funcionario_id_seq', 1000, false);


--
-- Data for Name: hobbie; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY hobbie (id_hobbie, dsc_description, id_funcionario) FROM stdin;
\.


--
-- Name: hobbie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('hobbie_id_seq', 1000, false);


--
-- Data for Name: local_interno; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY local_interno (id_local_interno, dta_cadastro, dsc_numero_sala, id_predio, id_telefone_ramal) FROM stdin;
\.


--
-- Name: local_interno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('local_interno_id_seq', 1000, false);


--
-- Data for Name: nivel_formacao; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY nivel_formacao (id_nivel_formacao, dsc_nivel_formacao) FROM stdin;
1	Ensino fundamental
2	Ensiono médio
3	Ensino superior
4	Especialização
5	Mestrado
6	Doutorado
7	Pós-Doutrorado
8	Nenhum
\.


--
-- Name: nivel_formacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('nivel_formacao_id_seq', 1000, false);


--
-- Data for Name: orgao; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY orgao (id_orgao, dsc_sigla, dsc_codigo, dsc_nome, dsc_url_site, id_endereco, id_cidade, id_telefone_fax, id_telefone, id_uf) FROM stdin;
1	AEB	123	Agência Espacial Brasileira	www.aeb.gov.br	2	1	\N	1	7
\.


--
-- Name: orgao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('orgao_id_seq', 1000, false);


--
-- Data for Name: plano_saude; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY plano_saude (id_plano_saude, dta_validade, dsc_numero, id_empresa_plano_de_saude) FROM stdin;
\.


--
-- Name: plano_saude_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('plano_saude_id_seq', 1000, false);


--
-- Data for Name: predio; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY predio (id_predio, dsc_predio) FROM stdin;
\.


--
-- Name: predio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('predio_id_seq', 1000, false);


--
-- Data for Name: rg; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY rg (id_rg, dta_expedicao, dsc_orgao_emissor, dsc_rg, id_uf) FROM stdin;
1	2016-11-07 12:36:12.683422	SSP-DF	9312481	7
\.


--
-- Name: rg_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('rg_id_seq', 1000, false);


--
-- Data for Name: saida; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY saida (id_saida, dta_dia_saida, num_duracao, dta_dia_fim_saida, txt_observacao, bol_vigente, id_funcionario, id_tipo_saida) FROM stdin;
\.


--
-- Name: saida_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('saida_id_seq', 1000, false);


--
-- Data for Name: servidor; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY servidor (id_servidor, dta_entrada, dta_ingresso, dta_ato_nomeacao, dta_publicacao_dou, bol_aposentado, id_coordenacao_origem, id_diretoria_origem, id_divisao_origim, id_orgao) FROM stdin;
\.


--
-- Name: servidor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('servidor_id_seq', 1000, false);


--
-- Data for Name: telefone; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY telefone (id_telefone, dsc_codigo_pais, dcs_ddd, dsc_numero, id_categoria_telefone) FROM stdin;
1	+55	61	33333333	1
\.


--
-- Data for Name: telefone_funcionario; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY telefone_funcionario (id_funcionario, id_telefone) FROM stdin;
\.


--
-- Name: telefone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('telefone_id_seq', 1000, false);


--
-- Data for Name: terceiro; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY terceiro (id_terceiro, bol_ativo, dsc_clt, dsc_orgao_clt, dta_expedicao_clt, dta_entrada, dta_saida, dta_atualizacao, id_empresa, id_uf) FROM stdin;
\.


--
-- Name: terceiro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('terceiro_id_seq', 1000, false);


--
-- Data for Name: tipo_saida; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY tipo_saida (id_tipo_saida, txt_codigo, txt_nome_tipo) FROM stdin;
0	00.00	Falta não justificada
1	01.02	A disposição da Justiça Eleitoral
2	01.47	Abono em horas
3	01.46	Abono por esquecimento de Registro de Ponto
4	02.01	Afastamento para acompanhar Cônjuge ou companheiro art. 84 Lei 8.112/90
5	01.03	Afastamento para estudos ou missão no exterior Art.95 Lei 8.112/90
6	02.02	Afastamento para exercício de mandato eletivo
7	02.06	Afastamento para servir em organismo internacional Art. 96 Lei 8.112/90
8	01.07	Afastamento preventivo Art. 147 Lei 8.112/90
9	02.07	Afastamento sindicância (Suspensão)
10	01.08	Alistamento como Eleitor Art 97, inciso III Lei 8.112/90
11	01.62	Amamentação Art. 209 Lei 8112/90
12	01.48	Atestado comparecimento (tratamento da própria saúde)
13	01.50	Atestado de acompanhante (doença em pessoa da família)
14	01.10	Atraso/Saída antecipada
15	01.04	Ausência autorizada pela chefia imediata
16	09.03	Ausência não justificada
17	01.11	Ausência prevista Art.15 Lei 8.868/94
18	01.12	Casamento Art.97, Inciso III, Alinia A, Lei 8.112/90
19	01.13	Comparecimento a congresso, conferência ou similares (Reunião fora)
20	01.14	Compensação
21	02.77	Data de ingresso posterior ao dia 1º
22	03.01	Data de ingresso posterior ao dia 1º
23	02.55	Desligamento do estágio
24	01.25	Dispensa por atividade eleitoral
25	01.18	Disponibilidade 
26	01.19	Doação voluntária de sangue Art.97, Inciso I, Lei 8.112/90
27	01.20	Falecimento de pessoa da família Art 97, Inciso III, Alinia B, Lei 8.112/90
28	02.21	Falta
29	02.17	Falta por greve
30	01.22	Férias
31	01.23	Jurí
32	01.24	Licença adoção ou guarda judicial Art. 210, Lei 8.112/90
33	02.00	Licença concedida por junta médica
34	01.26	Licença gestante Art. 207, Lei 8.112/90
35	01.27	Licença para atividade política Art. 86, 8.112/90
36	01.63	Licença para tratamento da própria saúde Art. 202 , Lei 8.112/90
37	01.30	Licença paternidade Art. 208, Lei 8.112/90
38	01.32	Licença por motivo de acidente em serviço ou doença profissional Art.211, Lei 8112/90
39	01.31	Licença por motivo de doença em pessoa da família Art. 83, Parágrafo 2, Lei 8112/90
40	01.33	Licença premio por assiduidade
41	01.35	Participação em competição desportiva nacional ou no exterior Art. 102, Inciso X, Lei 8112/90
42	01.51	Participação em processo disciplinar Art. 152, Parágrafo 1, Lei 8112/90
43	01.37	Participação em programa de treinamento Art. 102, Inciso IV, Lei 8112/90
44	03.03	Ponto facultativo
45	03.02	Ponto em manutenção
46	01.42	Serviço externo
47	01.43	Serviço extraordinário
48	03.04	Servidor cedido
49	01.77	Servidor não cadastrado
50	09.01	Sistema de frequência com defeito
51	09.02	Sistema elétrico com defeito
52	01.61	Substituição de cargo em comição, DAS 101.4, 101.5, 101.6
53	02.25	Suspensão disciplinar Art. 130, Lei 8112/90
54	01.44	Viagem a serviço
\.


--
-- Name: tipo_saida_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('tipo_saida_id_seq', 1000, false);


--
-- Data for Name: uf; Type: TABLE DATA; Schema: public; Owner: aebrh
--

COPY uf (id_uf, dsc_sigla, dsc_nome) FROM stdin;
1	AC	ACRE
2	AL	ALAGOAS
3	AP	AMAPÁ
4	AM	AMAZONAS
5	BA	BAHIA
6	CE	CEARÁ
7	DF	DISTRITO FEDERAL
8	ES	ESPIRITO SANTO
9	GO	GOIÁS
10	MA	MARANHÃO
11	MT	MATO GROSSO
12	MS	MATO GROSSO DO SUL
13	MG	MINAS GERAIS
14	PA	PARÁ
15	PB	PARAIBA
16	PR	PARANÁ
17	PE	PERNAMBUCO
18	PI	PIAUÍ
19	RJ	RIO DE JANEIRO
20	RN	RIO GRAND DO NORTE
21	RS	RIO GRANDE DO SUL
22	RO	RONDÔNIA
23	RR	RORAIMA
24	SC	SANTA CATARINA
25	SP	SÃO PAULO
26	SE	SERGIPE
27	TO	TOCANTIS
\.


--
-- Name: uf_id_seq; Type: SEQUENCE SET; Schema: public; Owner: aebrh
--

SELECT pg_catalog.setval('uf_id_seq', 1000, false);


--
-- Name: banco_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY banco
    ADD CONSTRAINT banco_pkey PRIMARY KEY (id_banco);


--
-- Name: cargo_funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY cargo_funcionario
    ADD CONSTRAINT cargo_funcionario_pkey PRIMARY KEY (id_cargo_funcionario);


--
-- Name: categoria_funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY categoria_funcionario
    ADD CONSTRAINT categoria_funcionario_pkey PRIMARY KEY (id_categoria_funcionario);


--
-- Name: categoria_telefone_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY categoria_telefone
    ADD CONSTRAINT categoria_telefone_pkey PRIMARY KEY (id_categoria_telefone);


--
-- Name: cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id_cidade);


--
-- Name: conjuge_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY conjuge
    ADD CONSTRAINT conjuge_pkey PRIMARY KEY (id_conjuge);


--
-- Name: conta_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY conta
    ADD CONSTRAINT conta_pkey PRIMARY KEY (id_conta);


--
-- Name: contato_emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY contato_emergencia
    ADD CONSTRAINT contato_emergencia_pkey PRIMARY KEY (id_contato_emergencia);


--
-- Name: coordenacao_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY coordenacao
    ADD CONSTRAINT coordenacao_pkey PRIMARY KEY (id_coordenacao);


--
-- Name: cor_pele_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY cor_pele
    ADD CONSTRAINT cor_pele_pkey PRIMARY KEY (id_cor_pele);


--
-- Name: dados_trabalhistas_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY dados_trabalhistas
    ADD CONSTRAINT dados_trabalhistas_pkey PRIMARY KEY (id_daods_trabalhistas);


--
-- Name: dependente_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY dependente
    ADD CONSTRAINT dependente_pkey PRIMARY KEY (id_dependente);


--
-- Name: diretoria_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY diretoria
    ADD CONSTRAINT diretoria_pkey PRIMARY KEY (id_diretoria);


--
-- Name: divisao_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY divisao
    ADD CONSTRAINT divisao_pkey PRIMARY KEY (id_divisao);


--
-- Name: documento_eleitoral_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY documento_eleitoral
    ADD CONSTRAINT documento_eleitoral_pkey PRIMARY KEY (id_documento_eleitoral);


--
-- Name: documento_militar_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY documento_militar
    ADD CONSTRAINT documento_militar_pkey PRIMARY KEY (id_documento_militar);


--
-- Name: empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id_empresa);


--
-- Name: empresa_plano_de_saude_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY empresa_plano_de_saude
    ADD CONSTRAINT empresa_plano_de_saude_pkey PRIMARY KEY (id_empresa_plano_de_saude);


--
-- Name: endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id_endereco);


--
-- Name: estado_civil_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY estado_civil
    ADD CONSTRAINT estado_civil_pkey PRIMARY KEY (id_estado_civil);


--
-- Name: filiacao_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY filiacao
    ADD CONSTRAINT filiacao_pkey PRIMARY KEY (id_filiacao);


--
-- Name: formacao_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY formacao
    ADD CONSTRAINT formacao_pkey PRIMARY KEY (id_formacao);


--
-- Name: funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id_funcionario);


--
-- Name: historico_funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT historico_funcionario_pkey PRIMARY KEY (id_historico_funcionario);


--
-- Name: hobbie_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY hobbie
    ADD CONSTRAINT hobbie_pkey PRIMARY KEY (id_hobbie);


--
-- Name: local_interno_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY local_interno
    ADD CONSTRAINT local_interno_pkey PRIMARY KEY (id_local_interno);


--
-- Name: nivel_formacao_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY nivel_formacao
    ADD CONSTRAINT nivel_formacao_pkey PRIMARY KEY (id_nivel_formacao);


--
-- Name: orgao_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT orgao_pkey PRIMARY KEY (id_orgao);


--
-- Name: plano_saude_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY plano_saude
    ADD CONSTRAINT plano_saude_pkey PRIMARY KEY (id_plano_saude);


--
-- Name: predio_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY predio
    ADD CONSTRAINT predio_pkey PRIMARY KEY (id_predio);


--
-- Name: rg_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY rg
    ADD CONSTRAINT rg_pkey PRIMARY KEY (id_rg);


--
-- Name: saida_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY saida
    ADD CONSTRAINT saida_pkey PRIMARY KEY (id_saida);


--
-- Name: servidor_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY servidor
    ADD CONSTRAINT servidor_pkey PRIMARY KEY (id_servidor);


--
-- Name: telefone_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (id_telefone);


--
-- Name: terceiro_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY terceiro
    ADD CONSTRAINT terceiro_pkey PRIMARY KEY (id_terceiro);


--
-- Name: tipo_saida_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY tipo_saida
    ADD CONSTRAINT tipo_saida_pkey PRIMARY KEY (id_tipo_saida);


--
-- Name: uf_pkey; Type: CONSTRAINT; Schema: public; Owner: aebrh; Tablespace: 
--

ALTER TABLE ONLY uf
    ADD CONSTRAINT uf_pkey PRIMARY KEY (id_uf);


--
-- Name: fk1d29oc6r6qxc1rui57aeqav9p; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY dependente
    ADD CONSTRAINT fk1d29oc6r6qxc1rui57aeqav9p FOREIGN KEY (id_filiacao) REFERENCES filiacao(id_filiacao);


--
-- Name: fk241nmu5wtgx8dsfv558it0g8y; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT fk241nmu5wtgx8dsfv558it0g8y FOREIGN KEY (id_telefone_secundario) REFERENCES telefone(id_telefone);


--
-- Name: fk2edgfrrx74ptl5biwkawm51hq; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY terceiro
    ADD CONSTRAINT fk2edgfrrx74ptl5biwkawm51hq FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa);


--
-- Name: fk346rah3evptuo3h51klff5q2r; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT fk346rah3evptuo3h51klff5q2r FOREIGN KEY (id_categoria_funcionario) REFERENCES categoria_funcionario(id_categoria_funcionario);


--
-- Name: fk3o53xoijqimt58eh9ibeel346; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk3o53xoijqimt58eh9ibeel346 FOREIGN KEY (id_estado_civil) REFERENCES estado_civil(id_estado_civil);


--
-- Name: fk4cohf6skyrg65sj36bb7sv3nu; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT fk4cohf6skyrg65sj36bb7sv3nu FOREIGN KEY (id_uf) REFERENCES uf(id_uf);


--
-- Name: fk5ac9yfchfvqw5vxkpf16cw4cq; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk5ac9yfchfvqw5vxkpf16cw4cq FOREIGN KEY (id_conjuge) REFERENCES conjuge(id_conjuge);


--
-- Name: fk5fjo58gnfvxuqevucooljo64k; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT fk5fjo58gnfvxuqevucooljo64k FOREIGN KEY (id_diretoria) REFERENCES diretoria(id_diretoria);


--
-- Name: fk68p08al1sfkehu3xj31h7wy7k; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk68p08al1sfkehu3xj31h7wy7k FOREIGN KEY (id_filiacao) REFERENCES filiacao(id_filiacao);


--
-- Name: fk6hyy5fwe1dt9ci65amc5qn331; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT fk6hyy5fwe1dt9ci65amc5qn331 FOREIGN KEY (id_telefone_fax) REFERENCES telefone(id_telefone);


--
-- Name: fk7pvc0tneb5rxd0qv0tsswxioq; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY local_interno
    ADD CONSTRAINT fk7pvc0tneb5rxd0qv0tsswxioq FOREIGN KEY (id_telefone_ramal) REFERENCES telefone(id_telefone);


--
-- Name: fk7v7mmlg1u5ormoiv7uasc7qu5; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT fk7v7mmlg1u5ormoiv7uasc7qu5 FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fk8054lt7wvgaue0pqs9aymgfaj; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY local_interno
    ADD CONSTRAINT fk8054lt7wvgaue0pqs9aymgfaj FOREIGN KEY (id_predio) REFERENCES predio(id_predio);


--
-- Name: fk8843vhmvg72jnq7v9lm8c0501; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY formacao
    ADD CONSTRAINT fk8843vhmvg72jnq7v9lm8c0501 FOREIGN KEY (id_nivel_formacao) REFERENCES nivel_formacao(id_nivel_formacao);


--
-- Name: fk8n6ah0wsnhdtrapw317bj5d47; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT fk8n6ah0wsnhdtrapw317bj5d47 FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco);


--
-- Name: fk8rrn0orqojtw9pwalkl97bfvs; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY servidor
    ADD CONSTRAINT fk8rrn0orqojtw9pwalkl97bfvs FOREIGN KEY (id_divisao_origim) REFERENCES divisao(id_divisao);


--
-- Name: fkat38uca0m13wa0ncb8kr0bhoi; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY coordenacao
    ADD CONSTRAINT fkat38uca0m13wa0ncb8kr0bhoi FOREIGN KEY (id_diretoria) REFERENCES diretoria(id_diretoria);


--
-- Name: fkbod8h1ur8quu7rlcij57tvpyb; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT fkbod8h1ur8quu7rlcij57tvpyb FOREIGN KEY (id_telefone) REFERENCES telefone(id_telefone);


--
-- Name: fkbvnt2q3c0wms87famjfkdxbcr; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY divisao
    ADD CONSTRAINT fkbvnt2q3c0wms87famjfkdxbcr FOREIGN KEY (id_funcionario_divisao) REFERENCES funcionario(id_funcionario);


--
-- Name: fkbwwlv1k8jpxnn47htltsf5dm1; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkbwwlv1k8jpxnn47htltsf5dm1 FOREIGN KEY (id_contato_emergencia) REFERENCES contato_emergencia(id_contato_emergencia);


--
-- Name: fkcmgjxpslydrqktqo7vbxd7je2; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkcmgjxpslydrqktqo7vbxd7je2 FOREIGN KEY (id_cor_pele) REFERENCES cor_pele(id_cor_pele);


--
-- Name: fkd0v7yhnduveytg071nk0jsur3; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkd0v7yhnduveytg071nk0jsur3 FOREIGN KEY (id_documento_eleitoral) REFERENCES documento_eleitoral(id_documento_eleitoral);


--
-- Name: fkd7pfihegc6i3inesdd7caqric; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT fkd7pfihegc6i3inesdd7caqric FOREIGN KEY (id_telefone_fax) REFERENCES telefone(id_telefone);


--
-- Name: fkdl2qj4sw0uh0fxrvb31yn17pr; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fkdl2qj4sw0uh0fxrvb31yn17pr FOREIGN KEY (id_cidade) REFERENCES cidade(id_cidade);


--
-- Name: fkdrvyu7dpbcff08o8bkdatooac; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkdrvyu7dpbcff08o8bkdatooac FOREIGN KEY (id_uf_nascimento) REFERENCES uf(id_uf);


--
-- Name: fkdsao37s7j6niffmyhm7nemjmi; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkdsao37s7j6niffmyhm7nemjmi FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco);


--
-- Name: fkdugi284bche6yfh7liq2kymci; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT fkdugi284bche6yfh7liq2kymci FOREIGN KEY (id_coordenacao) REFERENCES coordenacao(id_coordenacao);


--
-- Name: fkdyc6emsg4l3c6nqd3ro4dr4rf; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkdyc6emsg4l3c6nqd3ro4dr4rf FOREIGN KEY (id_terceiro) REFERENCES terceiro(id_terceiro);


--
-- Name: fkecvkskhu1e0je1uxqhas1hyuo; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY telefone_funcionario
    ADD CONSTRAINT fkecvkskhu1e0je1uxqhas1hyuo FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fkedlkwdsaoanohley2p2t33nsu; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY terceiro
    ADD CONSTRAINT fkedlkwdsaoanohley2p2t33nsu FOREIGN KEY (id_uf) REFERENCES uf(id_uf);


--
-- Name: fkejhy0ent1wn9nf7lgmf584ngg; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY coordenacao
    ADD CONSTRAINT fkejhy0ent1wn9nf7lgmf584ngg FOREIGN KEY (id_funcionario_coordenador) REFERENCES funcionario(id_funcionario);


--
-- Name: fkesdg0roq5fm7prx2sb3kobfi4; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY saida
    ADD CONSTRAINT fkesdg0roq5fm7prx2sb3kobfi4 FOREIGN KEY (id_tipo_saida) REFERENCES tipo_saida(id_tipo_saida);


--
-- Name: fkfs1p948nh3w5wgt21rr4g2e1m; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY formacao
    ADD CONSTRAINT fkfs1p948nh3w5wgt21rr4g2e1m FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fkfti65u464ljhm3w5og6mr4m0t; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY plano_saude
    ADD CONSTRAINT fkfti65u464ljhm3w5og6mr4m0t FOREIGN KEY (id_empresa_plano_de_saude) REFERENCES empresa_plano_de_saude(id_empresa_plano_de_saude);


--
-- Name: fkg4s48b6vyukosfhm5i3vgmxn4; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY servidor
    ADD CONSTRAINT fkg4s48b6vyukosfhm5i3vgmxn4 FOREIGN KEY (id_orgao) REFERENCES orgao(id_orgao);


--
-- Name: fkgdkm38yco3t8knb1sk1osi2a; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT fkgdkm38yco3t8knb1sk1osi2a FOREIGN KEY (id_categoria_telefone) REFERENCES categoria_telefone(id_categoria_telefone);


--
-- Name: fkgjky2jcofyj3u0yu0umh8sseu; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkgjky2jcofyj3u0yu0umh8sseu FOREIGN KEY (id_documento_militar) REFERENCES documento_militar(id_documento_militar);


--
-- Name: fkgr1o5eb3iu45etxtrqte4k40; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkgr1o5eb3iu45etxtrqte4k40 FOREIGN KEY (id_dados_trabalhistas) REFERENCES dados_trabalhistas(id_daods_trabalhistas);


--
-- Name: fkhbhyewfbirds5y2aw31tsnru; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkhbhyewfbirds5y2aw31tsnru FOREIGN KEY (id_coordenacao) REFERENCES coordenacao(id_coordenacao);


--
-- Name: fkjt1hv7d2b5cndb2byda35s63d; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY documento_militar
    ADD CONSTRAINT fkjt1hv7d2b5cndb2byda35s63d FOREIGN KEY (id_uf) REFERENCES uf(id_uf);


--
-- Name: fkjxl3v61uxad20umghbdd4xbqb; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY hobbie
    ADD CONSTRAINT fkjxl3v61uxad20umghbdd4xbqb FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fkk2nce65qoex7gbg5q4tq1eh7p; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkk2nce65qoex7gbg5q4tq1eh7p FOREIGN KEY (id_rg) REFERENCES rg(id_rg);


--
-- Name: fkkbe0w8mcwxmvkye6i5527pbba; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY conta
    ADD CONSTRAINT fkkbe0w8mcwxmvkye6i5527pbba FOREIGN KEY (id_banco) REFERENCES banco(id_banco);


--
-- Name: fkkg7vis41p9ryv8i7xcmvt6cbx; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkkg7vis41p9ryv8i7xcmvt6cbx FOREIGN KEY (id_plano_saude) REFERENCES plano_saude(id_plano_saude);


--
-- Name: fkknnyhvmwohetrs2qo33ggj505; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkknnyhvmwohetrs2qo33ggj505 FOREIGN KEY (id_divisao) REFERENCES divisao(id_divisao);


--
-- Name: fkly5ji3fsuf961m1khgpef8b77; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY servidor
    ADD CONSTRAINT fkly5ji3fsuf961m1khgpef8b77 FOREIGN KEY (id_coordenacao_origem) REFERENCES coordenacao(id_coordenacao);


--
-- Name: fkmk5cbvxdycpt98e1b1xhstr4h; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY telefone_funcionario
    ADD CONSTRAINT fkmk5cbvxdycpt98e1b1xhstr4h FOREIGN KEY (id_telefone) REFERENCES telefone(id_telefone);


--
-- Name: fkmw4snsmnccrgwb078vn6p6m5j; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT fkmw4snsmnccrgwb078vn6p6m5j FOREIGN KEY (id_uf) REFERENCES uf(id_uf);


--
-- Name: fkn5q7ltk9uidqfy9fsw7jh6q65; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkn5q7ltk9uidqfy9fsw7jh6q65 FOREIGN KEY (id_diretoria) REFERENCES diretoria(id_diretoria);


--
-- Name: fknpp981dvv4cc3bfptleerwfbm; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT fknpp981dvv4cc3bfptleerwfbm FOREIGN KEY (id_telefone) REFERENCES telefone(id_telefone);


--
-- Name: fknpr1fi6ecw0uxba0gyqf7q1v4; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY documento_eleitoral
    ADD CONSTRAINT fknpr1fi6ecw0uxba0gyqf7q1v4 FOREIGN KEY (id_uf) REFERENCES uf(id_uf);


--
-- Name: fko797b6qsp9mp9hv5q21witda4; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY conta
    ADD CONSTRAINT fko797b6qsp9mp9hv5q21witda4 FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fko9chbisbqy8igdl95wxfgap3e; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fko9chbisbqy8igdl95wxfgap3e FOREIGN KEY (id_servidor) REFERENCES servidor(id_servidor);


--
-- Name: fkofll4316q3sue0khar3qtn01e; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY dependente
    ADD CONSTRAINT fkofll4316q3sue0khar3qtn01e FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fkookr7tsbtcpllsywq94vf7ksa; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY diretoria
    ADD CONSTRAINT fkookr7tsbtcpllsywq94vf7ksa FOREIGN KEY (id_funcionario_diretor) REFERENCES funcionario(id_funcionario);


--
-- Name: fkp9defpi4q41cb2h73at0p618o; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY servidor
    ADD CONSTRAINT fkp9defpi4q41cb2h73at0p618o FOREIGN KEY (id_diretoria_origem) REFERENCES diretoria(id_diretoria);


--
-- Name: fkpehl4be2mulssiw0np11a5e22; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkpehl4be2mulssiw0np11a5e22 FOREIGN KEY (id_cargo_funcionario) REFERENCES cargo_funcionario(id_cargo_funcionario);


--
-- Name: fkpk1q0appaseigxcamy8jl762u; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT fkpk1q0appaseigxcamy8jl762u FOREIGN KEY (id_cargo_funcionario) REFERENCES cargo_funcionario(id_cargo_funcionario);


--
-- Name: fkq4uqaudhnp6lqct6wo70umr8l; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fkq4uqaudhnp6lqct6wo70umr8l FOREIGN KEY (id_ramal) REFERENCES telefone(id_telefone);


--
-- Name: fkqc852mylfwmpel7bf60069e2h; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY contato_emergencia
    ADD CONSTRAINT fkqc852mylfwmpel7bf60069e2h FOREIGN KEY (id_telefone) REFERENCES telefone(id_telefone);


--
-- Name: fks4np7bq0cjwtcg3ngvtyvsirr; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY saida
    ADD CONSTRAINT fks4np7bq0cjwtcg3ngvtyvsirr FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario);


--
-- Name: fks855l3x9midr22sqj9swtvj48; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fks855l3x9midr22sqj9swtvj48 FOREIGN KEY (id_categoria_funcionario) REFERENCES categoria_funcionario(id_categoria_funcionario);


--
-- Name: fksck60kwiuqc8rw9pmuo07fc4j; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY orgao
    ADD CONSTRAINT fksck60kwiuqc8rw9pmuo07fc4j FOREIGN KEY (id_cidade) REFERENCES cidade(id_cidade);


--
-- Name: fkt7wv9154eoshcotpjnki6tgcb; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY divisao
    ADD CONSTRAINT fkt7wv9154eoshcotpjnki6tgcb FOREIGN KEY (id_coordenacao) REFERENCES coordenacao(id_coordenacao);


--
-- Name: fktfgxa3i4a89k4tklu5oeh3qlw; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY rg
    ADD CONSTRAINT fktfgxa3i4a89k4tklu5oeh3qlw FOREIGN KEY (id_uf) REFERENCES uf(id_uf);


--
-- Name: fktgrcmnot3otuopt5fepv2ha5p; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY historico_funcionario
    ADD CONSTRAINT fktgrcmnot3otuopt5fepv2ha5p FOREIGN KEY (id_divisao) REFERENCES divisao(id_divisao);


--
-- Name: fktnhiur1kpa3q7juxs8novr6np; Type: FK CONSTRAINT; Schema: public; Owner: aebrh
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT fktnhiur1kpa3q7juxs8novr6np FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

