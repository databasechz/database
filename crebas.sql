/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     2018/12/28 19:52:53                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('cs') and o.name = 'FK_CS_RELATIONS_CAREER')
alter table cs
   drop constraint FK_CS_RELATIONS_CAREER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('cs') and o.name = 'FK_CS_RELATIONS_STAFF')
alter table cs
   drop constraint FK_CS_RELATIONS_STAFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('evaluate') and o.name = 'FK_EVALUATE_RELATIONS_USER')
alter table evaluate
   drop constraint FK_EVALUATE_RELATIONS_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('evaluate') and o.name = 'FK_EVALUATE_RELATIONS_MOVIE')
alter table evaluate
   drop constraint FK_EVALUATE_RELATIONS_MOVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('mc') and o.name = 'FK_MC_RELATIONS_COUNTRY')
alter table mc
   drop constraint FK_MC_RELATIONS_COUNTRY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('mc') and o.name = 'FK_MC_RELATIONS_MOVIE')
alter table mc
   drop constraint FK_MC_RELATIONS_MOVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ml') and o.name = 'FK_ML_RELATIONS_LANGUAGE')
alter table ml
   drop constraint FK_ML_RELATIONS_LANGUAGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ml') and o.name = 'FK_ML_RELATIONS_MOVIE')
alter table ml
   drop constraint FK_ML_RELATIONS_MOVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('mr') and o.name = 'FK_MR_RELATIONS_REWARD')
alter table mr
   drop constraint FK_MR_RELATIONS_REWARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('mr') and o.name = 'FK_MR_RELATIONS_MOVIE')
alter table mr
   drop constraint FK_MR_RELATIONS_MOVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('mt') and o.name = 'FK_MT_RELATIONS_TYPE')
alter table mt
   drop constraint FK_MT_RELATIONS_TYPE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('mt') and o.name = 'FK_MT_RELATIONS_MOVIE')
alter table mt
   drop constraint FK_MT_RELATIONS_MOVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sf') and o.name = 'FK_SF_RELATIONS_MOVIE')
alter table sf
   drop constraint FK_SF_RELATIONS_MOVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('sf') and o.name = 'FK_SF_RELATIONS_STAFF')
alter table sf
   drop constraint FK_SF_RELATIONS_STAFF
go

if exists (select 1
            from  sysobjects
           where  id = object_id('career')
            and   type = 'U')
   drop table career
go

if exists (select 1
            from  sysobjects
           where  id = object_id('country')
            and   type = 'U')
   drop table country
go

if exists (select 1
            from  sysobjects
           where  id = object_id('cs')
            and   type = 'U')
   drop table cs
go

if exists (select 1
            from  sysobjects
           where  id = object_id('evaluate')
            and   type = 'U')
   drop table evaluate
go

if exists (select 1
            from  sysobjects
           where  id = object_id('language')
            and   type = 'U')
   drop table language
go

if exists (select 1
            from  sysobjects
           where  id = object_id('mc')
            and   type = 'U')
   drop table mc
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ml')
            and   type = 'U')
   drop table ml
go

if exists (select 1
            from  sysobjects
           where  id = object_id('movie')
            and   type = 'U')
   drop table movie
go

if exists (select 1
            from  sysobjects
           where  id = object_id('mr')
            and   type = 'U')
   drop table mr
go

if exists (select 1
            from  sysobjects
           where  id = object_id('mt')
            and   type = 'U')
   drop table mt
go

if exists (select 1
            from  sysobjects
           where  id = object_id('reward')
            and   type = 'U')
   drop table reward
go

if exists (select 1
            from  sysobjects
           where  id = object_id('sf')
            and   type = 'U')
   drop table sf
go

if exists (select 1
            from  sysobjects
           where  id = object_id('staff')
            and   type = 'U')
   drop table staff
go

if exists (select 1
            from  sysobjects
           where  id = object_id('type')
            and   type = 'U')
   drop table type
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"user"')
            and   type = 'U')
   drop table "user"
go

/*==============================================================*/
/* Table: career                                                */
/*==============================================================*/
create table career (
   "career id"          varchar(20)          not null,
   "career name"        varchar(30)          not null,
   constraint PK_CAREER primary key nonclustered ("career id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'career',
   'user', @CurrentUser, 'table', 'career'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'career id',
   'user', @CurrentUser, 'table', 'career', 'column', 'career id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'career name',
   'user', @CurrentUser, 'table', 'career', 'column', 'career name'
go

/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/
create table country (
   "country id"         char(20)             not null,
   "country name"       varchar(30)          not null,
   constraint PK_COUNTRY primary key nonclustered ("country id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'country',
   'user', @CurrentUser, 'table', 'country'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'country id',
   'user', @CurrentUser, 'table', 'country', 'column', 'country id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'country name',
   'user', @CurrentUser, 'table', 'country', 'column', 'country name'
go

/*==============================================================*/
/* Table: cs                                                    */
/*==============================================================*/
create table cs (
   "career id"          varchar(20)          not null,
   staffid              int                  not null,
   constraint PK_CS primary key nonclustered ("career id", staffid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'cs',
   'user', @CurrentUser, 'table', 'cs'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'career id',
   'user', @CurrentUser, 'table', 'cs', 'column', 'career id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'staffid',
   'user', @CurrentUser, 'table', 'cs', 'column', 'staffid'
go

/*==============================================================*/
/* Table: evaluate                                              */
/*==============================================================*/
create table evaluate (
   movieid              char(50)             not null,
   userid               char(50)             not null,
   Score                float(20)            not null,
   Assessment           varchar(1000)        not null,
   Label                varchar(20)          not null,
   constraint PK_EVALUATE primary key nonclustered (movieid, userid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'evaluate',
   'user', @CurrentUser, 'table', 'evaluate'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'evaluate', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'userid',
   'user', @CurrentUser, 'table', 'evaluate', 'column', 'userid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Score',
   'user', @CurrentUser, 'table', 'evaluate', 'column', 'Score'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Assessment',
   'user', @CurrentUser, 'table', 'evaluate', 'column', 'Assessment'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Label',
   'user', @CurrentUser, 'table', 'evaluate', 'column', 'Label'
go

/*==============================================================*/
/* Table: language                                              */
/*==============================================================*/
create table language (
   "language id"        char(20)             not null,
   "language name"      varchar(30)          null,
   constraint PK_LANGUAGE primary key nonclustered ("language id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'language',
   'user', @CurrentUser, 'table', 'language'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'language id',
   'user', @CurrentUser, 'table', 'language', 'column', 'language id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'language name',
   'user', @CurrentUser, 'table', 'language', 'column', 'language name'
go

/*==============================================================*/
/* Table: mc                                                    */
/*==============================================================*/
create table mc (
   movieid              char(50)             not null,
   "country id"         char(20)             not null,
   constraint PK_MC primary key nonclustered (movieid, "country id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'mc',
   'user', @CurrentUser, 'table', 'mc'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'mc', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'country id',
   'user', @CurrentUser, 'table', 'mc', 'column', 'country id'
go

/*==============================================================*/
/* Table: ml                                                    */
/*==============================================================*/
create table ml (
   movieid              char(50)             not null,
   "language id"        char(20)             not null,
   constraint PK_ML primary key nonclustered (movieid, "language id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'ml',
   'user', @CurrentUser, 'table', 'ml'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'ml', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'language id',
   'user', @CurrentUser, 'table', 'ml', 'column', 'language id'
go

/*==============================================================*/
/* Table: movie                                                 */
/*==============================================================*/
create table movie (
   movieid              char(50)             not null,
   movename             varchar(50)          not null,
   "show time"          date                 not null,
   "lasting time"       int                  not null,
   nickname             varchar(100)         not null,
   "IMDb link"          varchar(20)          not null,
   introduction         varchar(1024)        not null,
   "photo and video"    ntext                not null,
   "final score"        float(20)            not null,
   constraint PK_MOVIE primary key nonclustered (movieid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movie',
   'user', @CurrentUser, 'table', 'movie'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'movie', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movename',
   'user', @CurrentUser, 'table', 'movie', 'column', 'movename'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'show time',
   'user', @CurrentUser, 'table', 'movie', 'column', 'show time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'lasting time',
   'user', @CurrentUser, 'table', 'movie', 'column', 'lasting time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'nickname',
   'user', @CurrentUser, 'table', 'movie', 'column', 'nickname'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'IMDb link',
   'user', @CurrentUser, 'table', 'movie', 'column', 'IMDb link'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'introduction',
   'user', @CurrentUser, 'table', 'movie', 'column', 'introduction'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'photo and video',
   'user', @CurrentUser, 'table', 'movie', 'column', 'photo and video'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'final score',
   'user', @CurrentUser, 'table', 'movie', 'column', 'final score'
go

/*==============================================================*/
/* Table: mr                                                    */
/*==============================================================*/
create table mr (
   movieid              char(50)             not null,
   "reward id"          int                  not null,
   constraint PK_MR primary key nonclustered (movieid, "reward id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'mr',
   'user', @CurrentUser, 'table', 'mr'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'mr', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'reward id',
   'user', @CurrentUser, 'table', 'mr', 'column', 'reward id'
go

/*==============================================================*/
/* Table: mt                                                    */
/*==============================================================*/
create table mt (
   movieid              char(50)             not null,
   "type id"            char(20)             not null,
   constraint PK_MT primary key nonclustered (movieid, "type id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'mt',
   'user', @CurrentUser, 'table', 'mt'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'mt', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'type id',
   'user', @CurrentUser, 'table', 'mt', 'column', 'type id'
go

/*==============================================================*/
/* Table: reward                                                */
/*==============================================================*/
create table reward (
   "reward id"          int                  not null,
   "reward name"        varchar(20)          not null,
   constraint PK_REWARD primary key nonclustered ("reward id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'reward',
   'user', @CurrentUser, 'table', 'reward'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'reward id',
   'user', @CurrentUser, 'table', 'reward', 'column', 'reward id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'reward name',
   'user', @CurrentUser, 'table', 'reward', 'column', 'reward name'
go

/*==============================================================*/
/* Table: sf                                                    */
/*==============================================================*/
create table sf (
   movieid              char(50)             not null,
   staffid              int                  not null,
   constraint PK_SF primary key nonclustered (movieid, staffid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'sf',
   'user', @CurrentUser, 'table', 'sf'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'movieid',
   'user', @CurrentUser, 'table', 'sf', 'column', 'movieid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'staffid',
   'user', @CurrentUser, 'table', 'sf', 'column', 'staffid'
go

/*==============================================================*/
/* Table: staff                                                 */
/*==============================================================*/
create table staff (
   staffid              int                  not null,
   staffname            varchar(50)          not null,
   country              varchar(50)          not null,
   sex                  char(4)              not null,
   birthday             date                 not null,
   intorduction         varchar(8000)        not null,
   photos               ntext                not null,
   constraint PK_STAFF primary key nonclustered (staffid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'staff',
   'user', @CurrentUser, 'table', 'staff'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'staffid',
   'user', @CurrentUser, 'table', 'staff', 'column', 'staffid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'staffname',
   'user', @CurrentUser, 'table', 'staff', 'column', 'staffname'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'country',
   'user', @CurrentUser, 'table', 'staff', 'column', 'country'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'sex',
   'user', @CurrentUser, 'table', 'staff', 'column', 'sex'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'birthday',
   'user', @CurrentUser, 'table', 'staff', 'column', 'birthday'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'intorduction',
   'user', @CurrentUser, 'table', 'staff', 'column', 'intorduction'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'photos',
   'user', @CurrentUser, 'table', 'staff', 'column', 'photos'
go

/*==============================================================*/
/* Table: type                                                  */
/*==============================================================*/
create table type (
   "type id"            char(20)             not null,
   "type name"          varchar(30)          not null,
   constraint PK_TYPE primary key nonclustered ("type id")
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'type',
   'user', @CurrentUser, 'table', 'type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'type id',
   'user', @CurrentUser, 'table', 'type', 'column', 'type id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'type name',
   'user', @CurrentUser, 'table', 'type', 'column', 'type name'
go

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" (
   userid               char(50)             not null,
   passwoed             char(50)             not null,
   WeChat               varchar(20)          null,
   QQ                   int                  null,
   Sina                 varchar(20)          null,
   Email                char(10)             null,
   "Phone number"       int                  null,
   constraint PK_USER primary key nonclustered (userid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'user',
   'user', @CurrentUser, 'table', 'user'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'userid',
   'user', @CurrentUser, 'table', 'user', 'column', 'userid'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'passwoed',
   'user', @CurrentUser, 'table', 'user', 'column', 'passwoed'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'WeChat',
   'user', @CurrentUser, 'table', 'user', 'column', 'WeChat'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'QQ',
   'user', @CurrentUser, 'table', 'user', 'column', 'QQ'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Sina',
   'user', @CurrentUser, 'table', 'user', 'column', 'Sina'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Email',
   'user', @CurrentUser, 'table', 'user', 'column', 'Email'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Phone number',
   'user', @CurrentUser, 'table', 'user', 'column', 'Phone number'
go

alter table cs
   add constraint FK_CS_RELATIONS_CAREER foreign key ("career id")
      references career ("career id")
go

alter table cs
   add constraint FK_CS_RELATIONS_STAFF foreign key (staffid)
      references staff (staffid)
go

alter table evaluate
   add constraint FK_EVALUATE_RELATIONS_USER foreign key (userid)
      references "user" (userid)
go

alter table evaluate
   add constraint FK_EVALUATE_RELATIONS_MOVIE foreign key (movieid)
      references movie (movieid)
go

alter table mc
   add constraint FK_MC_RELATIONS_COUNTRY foreign key ("country id")
      references country ("country id")
go

alter table mc
   add constraint FK_MC_RELATIONS_MOVIE foreign key (movieid)
      references movie (movieid)
go

alter table ml
   add constraint FK_ML_RELATIONS_LANGUAGE foreign key ("language id")
      references language ("language id")
go

alter table ml
   add constraint FK_ML_RELATIONS_MOVIE foreign key (movieid)
      references movie (movieid)
go

alter table mr
   add constraint FK_MR_RELATIONS_REWARD foreign key ("reward id")
      references reward ("reward id")
go

alter table mr
   add constraint FK_MR_RELATIONS_MOVIE foreign key (movieid)
      references movie (movieid)
go

alter table mt
   add constraint FK_MT_RELATIONS_TYPE foreign key ("type id")
      references type ("type id")
go

alter table mt
   add constraint FK_MT_RELATIONS_MOVIE foreign key (movieid)
      references movie (movieid)
go

alter table sf
   add constraint FK_SF_RELATIONS_MOVIE foreign key (movieid)
      references movie (movieid)
go

alter table sf
   add constraint FK_SF_RELATIONS_STAFF foreign key (staffid)
      references staff (staffid)
go

