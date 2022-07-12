-- alter table QLNS_CAU_HOI add column CHUYEN_NGANH_ID uuid ^
-- update QLNS_CAU_HOI set CHUYEN_NGANH_ID = <default_value> ;
-- alter table QLNS_CAU_HOI alter column CHUYEN_NGANH_ID set not null ;
alter table QLNS_CAU_HOI add column CHUYEN_NGANH_ID uuid not null ;
