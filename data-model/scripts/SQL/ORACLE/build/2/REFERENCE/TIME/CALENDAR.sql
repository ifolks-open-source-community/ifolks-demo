-- table unique constraints --
ALTER TABLE CALENDAR ADD CONSTRAINT UC_CALENDAR UNIQUE (CODE) USING INDEX (CREATE INDEX IDX_CALENDAR_UC ON CALENDAR(CODE))
/

-- table foreign keys --
-- table indexes --
-- Specific Code Start --
-- Specific Code End --

