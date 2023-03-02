CREATE TABLE IF NOT EXISTS public.menu
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    image_url character varying(255) COLLATE pg_catalog."default",
    link_url character varying(255) COLLATE pg_catalog."default",
    link character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    parent_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT menu_pkey PRIMARY KEY (id),
    CONSTRAINT fkgeupubdqncc1lpgf2cn4fqwbc FOREIGN KEY (parent_id)
        REFERENCES public.menu (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.menu
    OWNER to lkm;