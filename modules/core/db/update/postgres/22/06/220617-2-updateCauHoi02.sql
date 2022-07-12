alter table QLNS_CAU_HOI rename column dap_an_dung_id to dap_an_dung_id__u86473 ;
alter table QLNS_CAU_HOI drop constraint FK_QLNS_CAU_HOI_ON_DAP_AN_DUNG ;
drop index IDX_QLNS_CAU_HOI_ON_DAP_AN_DUNG ;
alter table QLNS_CAU_HOI add column DAP_AN_DUNG uuid ;
