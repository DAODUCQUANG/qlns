alter table QLNS_CAU_HOI rename column dap_an_dung_id to dap_an_dung_id__u08913 ;
drop index IDX_QLNS_CAU_HOI_ON_DAP_AN_DUNG ;
alter table QLNS_CAU_HOI add column DAP_AN_DUNG_ID uuid ;
