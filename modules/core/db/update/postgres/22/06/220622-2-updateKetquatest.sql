-- alter table QLNS_KETQUATEST add column UNG_VIEN_ID uuid ^
-- update QLNS_KETQUATEST set UNG_VIEN_ID = <default_value> ;
-- alter table QLNS_KETQUATEST alter column UNG_VIEN_ID set not null ;
alter table QLNS_KETQUATEST add column UNG_VIEN_ID uuid not null ;
