alter table QLNS_CAU_HOI rename column chuyen_nganh_id to chuyen_nganh_id__u98855 ;
alter table QLNS_CAU_HOI drop constraint FK_QLNS_CAU_HOI_ON_CHUYEN_NGANH ;
drop index IDX_QLNS_CAU_HOI_ON_CHUYEN_NGANH ;
