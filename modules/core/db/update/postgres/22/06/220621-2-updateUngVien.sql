alter table QLNS_UNG_VIEN rename column luong_id to luong_id__u28259 ;
alter table QLNS_UNG_VIEN drop constraint FK_QLNS_UNG_VIEN_ON_LUONG ;
drop index IDX_QLNS_UNG_VIEN_ON_LUONG ;
