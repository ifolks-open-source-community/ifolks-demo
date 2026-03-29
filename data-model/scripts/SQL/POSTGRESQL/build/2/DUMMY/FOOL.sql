ALTER TABLE FOOL ADD CONSTRAINT UC_FOOL UNIQUE (CODE);
/

-- table foreign keys and indexes --
CREATE INDEX IDX_FOOL_UC ON FOOL(CODE);
/

-- Specific Code Start --
-- Specific Code End --
