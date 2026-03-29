-- table unique constraints --
ALTER TABLE COUNTRY ADD CONSTRAINT UC_COUNTRY UNIQUE (CODE) USING INDEX (CREATE INDEX IDX_COUNTRY_UC ON COUNTRY(CODE))
/

-- table foreign keys --
-- table indexes --
-- Specific Code Start --
-- Specific Code End --

