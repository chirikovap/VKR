CREATE TABLE IF NOT EXISTS public.sources_table
(
    id serial NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    age text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sources_table_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.sources_table
    OWNER to postgres;