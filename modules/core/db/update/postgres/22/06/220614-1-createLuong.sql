create table QLNS_LUONG (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LUONG_HIENTAI varchar(255) not null,
    LUONG_DEXUAT varchar(255) not null,
    --
    primary key (ID)
);