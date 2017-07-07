
-- Database: BD_CLINICA_HOMO

-- DROP DATABASE "BD_CLINICA_HOMO";

CREATE DATABASE "BD_CLINICA_HOMO"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- Table: public."CELULA_IDENTIFICACION"

-- DROP TABLE public."CELULA_IDENTIFICACION";

CREATE TABLE public."CELULA_IDENTIFICACION"
(
    "ID_CELULA_IDENTIFICACION" integer NOT NULL DEFAULT nextval('identificacion_sec'::regclass),
    "NOMBRE" character varying(20) COLLATE pg_catalog."default",
    "APELLIDO_PATERNO" character varying(20) COLLATE pg_catalog."default",
    "CURP" character varying(40) COLLATE pg_catalog."default",
    "FECHA_NACIMIENTO" date,
    "APELLIDO_MATERNO" character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT "CELULA_IDENTIFICACION_pkey" PRIMARY KEY ("ID_CELULA_IDENTIFICACION")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."CELULA_IDENTIFICACION"
    OWNER to postgres;

-- Table: public."CIUDAD_MUNICIPIO"

-- DROP TABLE public."CIUDAD_MUNICIPIO";

CREATE TABLE public."CIUDAD_MUNICIPIO"
(
    "ID_CIUDAD_MUNICIPIO" integer NOT NULL DEFAULT nextval('ciudad_sec'::regclass),
    "NOMBRE" character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT "CIUDAD_MUNICIPIO_pkey" PRIMARY KEY ("ID_CIUDAD_MUNICIPIO")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."CIUDAD_MUNICIPIO"
    OWNER to postgres;


-- Table: public."COMPUESTOS"

-- DROP TABLE public."COMPUESTOS";

CREATE TABLE public."COMPUESTOS"
(
    "ID_COMPUESTOS" integer NOT NULL DEFAULT nextval('comuesto_sec'::regclass),
    "CANTIDAD" double precision,
    "ID_SUSTANCIA" integer,
    CONSTRAINT "COMPUESTOS_pkey" PRIMARY KEY ("ID_COMPUESTOS"),
    CONSTRAINT "COMPUESTOS_fk" FOREIGN KEY ("ID_SUSTANCIA")
        REFERENCES public."SUSTANCIAS" ("ID_SUSTANCIA") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."COMPUESTOS"
    OWNER to postgres;


-- Table: public."CONSULTA"

-- DROP TABLE public."CONSULTA";

CREATE TABLE public."CONSULTA"
(
    "ID_CONSULTA" integer NOT NULL DEFAULT nextval('consulta_sec'::regclass),
    "FECHA_CONSULTA" date,
    "COSTO" double precision,
    "HORARIO" time without time zone,
    "ID_PACIENTE" integer,
    "ID_DOCTOR" integer,
    CONSTRAINT "CONSULTA_pkey" PRIMARY KEY ("ID_CONSULTA"),
    CONSTRAINT "DOCTOR_fk" FOREIGN KEY ("ID_DOCTOR")
        REFERENCES public."DOCTOR" ("ID_DOCTOR") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "PACIENTE_fk" FOREIGN KEY ("ID_PACIENTE")
        REFERENCES public."PACIENTES" ("ID_PACIENTES") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."CONSULTA"
    OWNER to postgres;


-- Table: public."DETALLES_CONSULTA"

-- DROP TABLE public."DETALLES_CONSULTA";

CREATE TABLE public."DETALLES_CONSULTA"
(
    "ID_CONSULTA" integer,
    "ID_ENFERMEDAD" integer NOT NULL,
    "ID_MEDICAMENTO" integer NOT NULL,
    CONSTRAINT "CONSULTA_fk" FOREIGN KEY ("ID_CONSULTA")
        REFERENCES public."CONSULTA" ("ID_CONSULTA") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "ENFERMEDAD_fk" FOREIGN KEY ("ID_ENFERMEDAD")
        REFERENCES public."ENFERMEDARES" ("ID_ENFERMEDAD") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "MEDICAMENTO_fk" FOREIGN KEY ("ID_MEDICAMENTO")
        REFERENCES public."MEDICAMENTOS" ("ID_MEDICAMENTOS") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DETALLES_CONSULTA"
    OWNER to postgres;



-- Table: public."DIRECCION"

-- DROP TABLE public."DIRECCION";

CREATE TABLE public."DIRECCION"
(
    "ID_DIRECCION" integer NOT NULL DEFAULT nextval('direccion_sec'::regclass),
    "CALLE" character varying(30) COLLATE pg_catalog."default",
    "COLONIA_BARRIO" character varying(20) COLLATE pg_catalog."default",
    "ID_CIUDAD_MUNICIPIO" integer NOT NULL,
    CONSTRAINT "DIRECCION_pkey" PRIMARY KEY ("ID_DIRECCION"),
    CONSTRAINT "DIRECCION_fk" FOREIGN KEY ("ID_CIUDAD_MUNICIPIO")
        REFERENCES public."CIUDAD_MUNICIPIO" ("ID_CIUDAD_MUNICIPIO") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DIRECCION"
    OWNER to postgres;




-- Table: public."DOCTOR"

-- DROP TABLE public."DOCTOR";

CREATE TABLE public."DOCTOR"
(
    "ID_DOCTOR" integer NOT NULL DEFAULT nextval('doctor_sec'::regclass),
    "NOMBRE" character varying(20) COLLATE pg_catalog."default",
    "TELEFONO" bigint,
    "FECHA_INICIO_PROFECION" date,
    "ACTIVO" character varying(40) COLLATE pg_catalog."default",
    "CODIGO" character varying(20) COLLATE pg_catalog."default",
    "ID_CELULA_IDENTIFICACION" integer,
    "ID_ESPECIALIDAD" integer,
    "ID_DIRECCION" integer,
    CONSTRAINT "DOCTOR_pkey" PRIMARY KEY ("ID_DOCTOR"),
    CONSTRAINT "DIRECCION_fk" FOREIGN KEY ("ID_DIRECCION")
        REFERENCES public."DIRECCION" ("ID_DIRECCION") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "DOCTOR_CELULA_fk" FOREIGN KEY ("ID_CELULA_IDENTIFICACION")
        REFERENCES public."CELULA_IDENTIFICACION" ("ID_CELULA_IDENTIFICACION") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "ESPECIALIDAD_fk" FOREIGN KEY ("ID_ESPECIALIDAD")
        REFERENCES public."ESPECIALIDAD" ("ID_ESPECIALIDAD") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DOCTOR"
    OWNER to postgres;



-- Table: public."ENFERMEDARES"

-- DROP TABLE public."ENFERMEDARES";

CREATE TABLE public."ENFERMEDARES"
(
    "ID_ENFERMEDAD" integer NOT NULL DEFAULT nextval('enfer_sec2'::regclass),
    "NOMBRE" character varying(20) COLLATE pg_catalog."default",
    "DESCRIPCION" character varying(100) COLLATE pg_catalog."default",
    "ID_MEDICAMENTO" integer,
    CONSTRAINT "ENFERMEDARES_pkey" PRIMARY KEY ("ID_ENFERMEDAD"),
    CONSTRAINT "MEDICAMENTOS_fk" FOREIGN KEY ("ID_MEDICAMENTO")
        REFERENCES public."MEDICAMENTOS" ("ID_MEDICAMENTOS") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."ENFERMEDARES"
    OWNER to postgres;


-- Table: public."ESPECIALIDAD"

-- DROP TABLE public."ESPECIALIDAD";

CREATE TABLE public."ESPECIALIDAD"
(
    "ID_ESPECIALIDAD" integer NOT NULL DEFAULT nextval('espe_sec'::regclass),
    "NOMBRE" character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT "ESPECIALIDAD_pkey" PRIMARY KEY ("ID_ESPECIALIDAD")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."ESPECIALIDAD"
    OWNER to postgres;


-- Table: public."MEDICAMENTOS"

-- DROP TABLE public."MEDICAMENTOS";

CREATE TABLE public."MEDICAMENTOS"
(
    "ID_MEDICAMENTOS" integer NOT NULL DEFAULT nextval('med_sec'::regclass),
    "NOMBRE" character varying(20) COLLATE pg_catalog."default",
    "CODIGO" integer,
    "ID_ENFERMEDAD" integer,
    "ID_COMPUESTO" integer,
    CONSTRAINT "MEDICAMENTOS_pkey" PRIMARY KEY ("ID_MEDICAMENTOS"),
    CONSTRAINT "COMPUESTOS_fk" FOREIGN KEY ("ID_COMPUESTO")
        REFERENCES public."COMPUESTOS" ("ID_COMPUESTOS") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "ENFERMEDAD_fk" FOREIGN KEY ("ID_ENFERMEDAD")
        REFERENCES public."ENFERMEDARES" ("ID_ENFERMEDAD") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."MEDICAMENTOS"
    OWNER to postgres;


-- Table: public."PACIENTES"

-- DROP TABLE public."PACIENTES";

CREATE TABLE public."PACIENTES"
(
    "ID_PACIENTES" integer NOT NULL DEFAULT nextval('pacietes_sec'::regclass),
    "NOMBRE" character varying(20) COLLATE pg_catalog."default",
    "TELEFONO" bigint,
    "ACTIVO" character varying(15) COLLATE pg_catalog."default",
    "ID_CELULA_IDENTIFICACION" integer,
    "ID_DIRECCION" integer,
    CONSTRAINT "PACIETES_pkey" PRIMARY KEY ("ID_PACIENTES"),
    CONSTRAINT "PACIENTE_DIRECION_fk" FOREIGN KEY ("ID_DIRECCION")
        REFERENCES public."DIRECCION" ("ID_DIRECCION") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "PACIENTE_fk" FOREIGN KEY ("ID_CELULA_IDENTIFICACION")
        REFERENCES public."CELULA_IDENTIFICACION" ("ID_CELULA_IDENTIFICACION") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."PACIENTES"
    OWNER to postgres;


-- Table: public."PELIGROSAS"

-- DROP TABLE public."PELIGROSAS";

CREATE TABLE public."PELIGROSAS"
(
    "ID_PELIGRO" integer NOT NULL DEFAULT nextval('peligro_sec'::regclass),
    "DESCRIPCION" character varying(100) COLLATE pg_catalog."default",
    "STATUS" character varying(15) COLLATE pg_catalog."default",
    "ID_SUSTANCIA" integer,
    CONSTRAINT "PELIGROSAS_pkey" PRIMARY KEY ("ID_PELIGRO"),
    CONSTRAINT "PELIGROSAS_fk" FOREIGN KEY ("ID_SUSTANCIA")
        REFERENCES public."SUSTANCIAS" ("ID_SUSTANCIA") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."PELIGROSAS"
    OWNER to postgres;

-- Table: public."SUSTANCIAS"

-- DROP TABLE public."SUSTANCIAS";

CREATE TABLE public."SUSTANCIAS"
(
    "ID_SUSTANCIA" integer NOT NULL DEFAULT nextval('sus_sec'::regclass),
    "NOMBRE" character varying(20) COLLATE pg_catalog."default",
    "CODIGO" character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT "SUSTANCIAS_pkey" PRIMARY KEY ("ID_SUSTANCIA")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."SUSTANCIAS"
    OWNER to postgres;