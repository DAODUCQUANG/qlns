alter table QLNS_CHUYEN_NGANH add column DIEM_YEU_CAU double precision ^
update QLNS_CHUYEN_NGANH set DIEM_YEU_CAU = 0 where DIEM_YEU_CAU is null ;
alter table QLNS_CHUYEN_NGANH alter column DIEM_YEU_CAU set not null ;
