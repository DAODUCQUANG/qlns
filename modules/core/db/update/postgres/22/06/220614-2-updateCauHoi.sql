update QLNS_CAU_HOI set TEN_CAUHOI = '' where TEN_CAUHOI is null ;
alter table QLNS_CAU_HOI alter column TEN_CAU_HOI set not null ;
