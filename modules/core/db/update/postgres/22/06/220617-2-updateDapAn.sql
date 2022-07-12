alter table QLNS_DAP_AN rename column noidung_dapan to noidung_dapan__u87671 ;
alter table QLNS_DAP_AN alter column noidung_dapan__u87671 drop not null ;
-- update QLNS_DAP_AN set CAU_HOI_ID = <default_value> where CAU_HOI_ID is null ;
alter table QLNS_DAP_AN alter column CAU_HOI_ID set not null ;
