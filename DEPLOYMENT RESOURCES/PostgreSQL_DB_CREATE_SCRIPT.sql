--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-04-15 12:30:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2969 (class 1262 OID 16819)
-- Name: escalade; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE escalade WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE escalade OWNER TO postgres;

\connect escalade

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 2969
-- Name: DATABASE escalade; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE escalade IS 'OC P6 - Escalade Database';


--
-- TOC entry 8 (class 2615 OID 16820)
-- Name: escalade; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA escalade;


ALTER SCHEMA escalade OWNER TO postgres;

--
-- TOC entry 2 (class 3079 OID 16939)
-- Name: citext; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS citext WITH SCHEMA escalade;


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION citext; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION citext IS 'data type for case-insensitive character strings';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 16853)
-- Name: comment; Type: TABLE; Schema: escalade; Owner: postgres
--

CREATE TABLE escalade.comment (
    commentid integer NOT NULL,
    userid integer NOT NULL,
    siteid integer NOT NULL,
    commentcontent character varying NOT NULL,
    commentdate date NOT NULL
);


ALTER TABLE escalade.comment OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16851)
-- Name: comment_commentid_seq; Type: SEQUENCE; Schema: escalade; Owner: postgres
--

CREATE SEQUENCE escalade.comment_commentid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE escalade.comment_commentid_seq OWNER TO postgres;

--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 209
-- Name: comment_commentid_seq; Type: SEQUENCE OWNED BY; Schema: escalade; Owner: postgres
--

ALTER SEQUENCE escalade.comment_commentid_seq OWNED BY escalade.comment.commentid;


--
-- TOC entry 212 (class 1259 OID 16926)
-- Name: countries; Type: TABLE; Schema: escalade; Owner: postgres
--

CREATE TABLE escalade.countries (
    country_id integer NOT NULL,
    country_code character varying NOT NULL,
    country_name character varying NOT NULL
);


ALTER TABLE escalade.countries OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16916)
-- Name: departments; Type: TABLE; Schema: escalade; Owner: postgres
--

CREATE TABLE escalade.departments (
    department_id integer NOT NULL,
    department_code character varying NOT NULL,
    department_name character varying NOT NULL
);


ALTER TABLE escalade.departments OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16834)
-- Name: registereduser; Type: TABLE; Schema: escalade; Owner: postgres
--

CREATE TABLE escalade.registereduser (
    userid integer NOT NULL,
    userlogin escalade.citext,
    userpassword character varying NOT NULL,
    usernickname escalade.citext NOT NULL,
    userfirstname character varying,
    userlastname character varying,
    usermail escalade.citext NOT NULL,
    usertelephone character varying,
    userismember boolean NOT NULL,
    CONSTRAINT registereduser_usermail_check CHECK (((usermail)::text ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$'::text)),
    CONSTRAINT registereduser_usernickname_check CHECK (((usernickname)::text ~ '^[A-Za-zÀ-ÖØ-öø-ÿ]*$'::text)),
    CONSTRAINT registereduser_userpassword_check CHECK (((userpassword)::text ~ '^[a-zA-Z0-9 !"#$%&()*+,-./:;<=>?@[\]^_`{|}~]*$'::text))
);


ALTER TABLE escalade.registereduser OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16832)
-- Name: registereduser_userid_seq; Type: SEQUENCE; Schema: escalade; Owner: postgres
--

CREATE SEQUENCE escalade.registereduser_userid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE escalade.registereduser_userid_seq OWNER TO postgres;

--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 205
-- Name: registereduser_userid_seq; Type: SEQUENCE OWNED BY; Schema: escalade; Owner: postgres
--

ALTER SEQUENCE escalade.registereduser_userid_seq OWNED BY escalade.registereduser.userid;


--
-- TOC entry 204 (class 1259 OID 16823)
-- Name: site; Type: TABLE; Schema: escalade; Owner: postgres
--

CREATE TABLE escalade.site (
    siteid integer NOT NULL,
    sitename character varying NOT NULL,
    sitecountry character varying NOT NULL,
    sitedepartment character varying,
    sitelatitude character varying NOT NULL,
    sitelongitude character varying NOT NULL,
    siteheight character varying NOT NULL,
    sitetracks character varying NOT NULL,
    sitecotationmin character varying NOT NULL,
    sitecotationmax character varying NOT NULL,
    sitedescription character varying NOT NULL,
    siteisofficial boolean NOT NULL,
    sitecreationdate date NOT NULL
);


ALTER TABLE escalade.site OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16821)
-- Name: site_siteid_seq; Type: SEQUENCE; Schema: escalade; Owner: postgres
--

CREATE SEQUENCE escalade.site_siteid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE escalade.site_siteid_seq OWNER TO postgres;

--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 203
-- Name: site_siteid_seq; Type: SEQUENCE OWNED BY; Schema: escalade; Owner: postgres
--

ALTER SEQUENCE escalade.site_siteid_seq OWNED BY escalade.site.siteid;


--
-- TOC entry 208 (class 1259 OID 16845)
-- Name: topo; Type: TABLE; Schema: escalade; Owner: postgres
--

CREATE TABLE escalade.topo (
    topoid integer NOT NULL,
    siteid integer NOT NULL,
    userid integer NOT NULL,
    topopublishingdate date NOT NULL,
    topoisreserved boolean DEFAULT false NOT NULL,
    reserveduserid integer,
    topoispending boolean DEFAULT false
);


ALTER TABLE escalade.topo OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16843)
-- Name: topo_topoid_seq; Type: SEQUENCE; Schema: escalade; Owner: postgres
--

CREATE SEQUENCE escalade.topo_topoid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE escalade.topo_topoid_seq OWNER TO postgres;

--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 207
-- Name: topo_topoid_seq; Type: SEQUENCE OWNED BY; Schema: escalade; Owner: postgres
--

ALTER SEQUENCE escalade.topo_topoid_seq OWNED BY escalade.topo.topoid;


--
-- TOC entry 2817 (class 2604 OID 16856)
-- Name: comment commentid; Type: DEFAULT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.comment ALTER COLUMN commentid SET DEFAULT nextval('escalade.comment_commentid_seq'::regclass);


--
-- TOC entry 2810 (class 2604 OID 16837)
-- Name: registereduser userid; Type: DEFAULT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.registereduser ALTER COLUMN userid SET DEFAULT nextval('escalade.registereduser_userid_seq'::regclass);


--
-- TOC entry 2809 (class 2604 OID 16826)
-- Name: site siteid; Type: DEFAULT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.site ALTER COLUMN siteid SET DEFAULT nextval('escalade.site_siteid_seq'::regclass);


--
-- TOC entry 2814 (class 2604 OID 16848)
-- Name: topo topoid; Type: DEFAULT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.topo ALTER COLUMN topoid SET DEFAULT nextval('escalade.topo_topoid_seq'::regclass);


--
-- TOC entry 2827 (class 2606 OID 16861)
-- Name: comment comment_pk; Type: CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.comment
    ADD CONSTRAINT comment_pk PRIMARY KEY (commentid);


--
-- TOC entry 2833 (class 2606 OID 16935)
-- Name: countries countries_pk; Type: CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.countries
    ADD CONSTRAINT countries_pk PRIMARY KEY (country_id);


--
-- TOC entry 2829 (class 2606 OID 16923)
-- Name: departments departments_pk; Type: CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.departments
    ADD CONSTRAINT departments_pk PRIMARY KEY (department_id);


--
-- TOC entry 2821 (class 2606 OID 16842)
-- Name: registereduser registereduser_pk; Type: CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.registereduser
    ADD CONSTRAINT registereduser_pk PRIMARY KEY (userid);


--
-- TOC entry 2819 (class 2606 OID 16831)
-- Name: site site_pk; Type: CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.site
    ADD CONSTRAINT site_pk PRIMARY KEY (siteid);


--
-- TOC entry 2825 (class 2606 OID 16850)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (topoid);


--
-- TOC entry 2830 (class 1259 OID 16932)
-- Name: countries_country_code_uindex; Type: INDEX; Schema: escalade; Owner: postgres
--

CREATE UNIQUE INDEX countries_country_code_uindex ON escalade.countries USING btree (country_code);


--
-- TOC entry 2831 (class 1259 OID 16933)
-- Name: countries_country_id_uindex; Type: INDEX; Schema: escalade; Owner: postgres
--

CREATE UNIQUE INDEX countries_country_id_uindex ON escalade.countries USING btree (country_id);


--
-- TOC entry 2822 (class 1259 OID 17051)
-- Name: registereduser_usermail_uindex; Type: INDEX; Schema: escalade; Owner: postgres
--

CREATE UNIQUE INDEX registereduser_usermail_uindex ON escalade.registereduser USING btree (usermail);


--
-- TOC entry 2823 (class 1259 OID 17050)
-- Name: registereduser_usernickname_uindex; Type: INDEX; Schema: escalade; Owner: postgres
--

CREATE UNIQUE INDEX registereduser_usernickname_uindex ON escalade.registereduser USING btree (usernickname);


--
-- TOC entry 2836 (class 2606 OID 16862)
-- Name: comment site_comments_fk; Type: FK CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.comment
    ADD CONSTRAINT site_comments_fk FOREIGN KEY (siteid) REFERENCES escalade.site(siteid);


--
-- TOC entry 2834 (class 2606 OID 16867)
-- Name: topo site_topo_fk; Type: FK CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.topo
    ADD CONSTRAINT site_topo_fk FOREIGN KEY (siteid) REFERENCES escalade.site(siteid);


--
-- TOC entry 2837 (class 2606 OID 16890)
-- Name: comment user_comments_fk; Type: FK CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.comment
    ADD CONSTRAINT user_comments_fk FOREIGN KEY (userid) REFERENCES escalade.registereduser(userid);


--
-- TOC entry 2835 (class 2606 OID 16877)
-- Name: topo users_topo_fk; Type: FK CONSTRAINT; Schema: escalade; Owner: postgres
--

ALTER TABLE ONLY escalade.topo
    ADD CONSTRAINT users_topo_fk FOREIGN KEY (userid) REFERENCES escalade.registereduser(userid);


-- Completed on 2020-04-15 12:30:47

--
-- PostgreSQL database dump complete
--

