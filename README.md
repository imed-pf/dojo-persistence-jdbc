# imed-dojo-persistence-jdbc

  Download [driver] (http://jdbc.postgresql.org/download.html) JDBC Postgres 9.4

  Create database juris
  			
  			CREATE DATABASE dojo_persistence_jdbc
			  WITH OWNER = postgres
			       ENCODING = 'UTF8'
			       TABLESPACE = pg_default
			       LC_COLLATE = 'C'
			       LC_CTYPE = 'C'
			       CONNECTION LIMIT = -1;

  Create table customer
		
			-- customer sequence
			CREATE SEQUENCE public.cliente_codigo
			  INCREMENT 1
			  MINVALUE 1
			  MAXVALUE 9223372036854775807
			  START 1
			  CACHE 1;
			ALTER TABLE public.cliente_codigo
			  OWNER TO postgres;			
	
			-- table customer
			CREATE TABLE cliente
			(
			  codigo bigint NOT NULL DEFAULT nextval('cliente_codigo'::regclass),
			  nome character varying NOT NULL,
			  ativo character(1) DEFAULT '1',
			  CONSTRAINT pk_cliente PRIMARY KEY (codigo)
			)
			WITH (
			  OIDS=FALSE
			);
			ALTER TABLE cliente OWNER TO postgres;

  Create table process
			
			-- process sequence
			CREATE SEQUENCE public.processo_codigo
			  INCREMENT 1
			  MINVALUE 1
			  MAXVALUE 9223372036854775807
			  START 1
			  CACHE 1;
			ALTER TABLE public.processo_codigo OWNER TO postgres;

			-- table process
			CREATE TABLE processo
			(
			  codigo bigint NOT NULL DEFAULT nextval('processo_codigo'::regclass),
			  cliente bigint NOT NULL,
			  numeroprocesso bigint NOT NULL,
			  ativo character(1) DEFAULT '1',
			  datacriacao timestamp without time zone DEFAULT now(),
			  datafechamento timestamp without time zone,
			  CONSTRAINT pk_processo PRIMARY KEY (codigo),
			  CONSTRAINT fk_cliente FOREIGN KEY (cod_cliente) REFERENCES cliente (codigo)
			)
			WITH (
			  OIDS=FALSE
			);
			ALTER TABLE processo OWNER TO postgres;	
				
