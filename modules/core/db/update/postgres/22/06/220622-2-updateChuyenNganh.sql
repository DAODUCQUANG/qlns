alter table QLNS_CHUYEN_NGANH rename column cau_hoi_id to cau_hoi_id__u94608 ;
alter table QLNS_CHUYEN_NGANH drop constraint FK_QLNS_CHUYEN_NGANH_ON_CAU_HOI ;
drop index IDX_QLNS_CHUYEN_NGANH_ON_CAU_HOI ;
