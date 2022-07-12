alter table QLNS_UNG_VIEN rename column ket_qua_test_id to ket_qua_test_id__u09968 ;
alter table QLNS_UNG_VIEN drop constraint FK_QLNS_UNG_VIEN_ON_KET_QUA_TEST ;
drop index IDX_QLNS_UNG_VIEN_ON_KET_QUA_TEST ;
alter table QLNS_UNG_VIEN alter column MOTA drop not null ;
alter table QLNS_UNG_VIEN alter column KETQUADANHGIA drop not null ;
