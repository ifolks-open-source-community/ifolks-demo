-- table unique constraints --
ALTER TABLE FOOL ADD CONSTRAINT UC_FOOL UNIQUE (CODE) USING INDEX (CREATE INDEX IDX_FOOL_UC ON FOOL(CODE))
/

-- table foreign keys --
-- table indexes --
-- Specific Code Start --
-- Specific Code End --

