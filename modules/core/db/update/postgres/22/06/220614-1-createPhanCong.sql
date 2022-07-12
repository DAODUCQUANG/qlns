create table QLNS_PHAN_CONG (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    UNG_VIEN_ID uuid,
    CHUYEN_NGANH_ID uuid,
    --
    primary key (ID)
);