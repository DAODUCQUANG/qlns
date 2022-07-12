alter table QLNS_CHUYEN_NGANH add column THOI_GIAN integer ^
update QLNS_CHUYEN_NGANH set THOI_GIAN = 0 where THOI_GIAN is null ;
alter table QLNS_CHUYEN_NGANH alter column THOI_GIAN set not null ;
