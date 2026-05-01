ALTER TABLE CALENDAR ADD CONSTRAINT UC_CALENDAR UNIQUE (CODE);
/

-- table foreign keys and indexes --
CREATE INDEX IDX_CALENDAR_UC ON CALENDAR(CODE);
/

-- Specific Code Start --
-- Specific Code End --
