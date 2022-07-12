alter table QLNS_CAU_HOI rename column ten_cauhoi to ten_cauhoi__u87786 ;
alter table QLNS_CAU_HOI alter column ten_cauhoi__u87786 drop not null ;
alter table QLNS_CAU_HOI add column TEN_CAU_HOI varchar(255) ^
update QLNS_CAU_HOI set TEN_CAU_HOI = '' where TEN_CAU_HOI is null ;
alter table QLNS_CAU_HOI alter column TEN_CAU_HOI set not null ;
