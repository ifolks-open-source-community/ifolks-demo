ALTER TABLE COUNTRY ADD CONSTRAINT UC_COUNTRY UNIQUE (CODE);
/

-- table foreign keys and indexes --
CREATE INDEX IDX_COUNTRY_UC ON COUNTRY(CODE);
/

-- Specific Code Start --
-- Specific Code End --
