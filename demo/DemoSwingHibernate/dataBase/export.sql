--------------------------------------------------------
--  File created - Friday-July-11-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Type ACTIONS_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ACTIONS_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        ACTION ACTION_V
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type ACTION_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ACTION_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        ACTIONED_BY VARCHAR2 (10) ,
        DATE_ACTIONED DATE
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type ACTION_V
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ACTION_V" 
    IS VARRAY ( 4 ) OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type CATALOG_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."CATALOG_TYP" 
    UNDER COMPOSITE_CATEGORY_TYP (
        MEMBER FUNCTION GETCATALOGNAME
        RETURN VARCHAR2 ,
        MEMBER FUNCTION CATEGORY_DESCRIBE
        RETURN VARCHAR2
    ) FINAL
;
/
CREATE OR REPLACE TYPE BODY "SYSTEM"."CATALOG_TYP" 
    AS
    MEMBER FUNCTION GETCATALOGNAME
    RETURN VARCHAR
    AS
    BEGIN
    -- Return the category name from the supertype
    RETURN self.category_name;
  END;
    MEMBER FUNCTION CATEGORY_DESCRIBE
    RETURN VARCHAR
    AS
    BEGIN
    RETURN 'catalog_typ';
  END;
    END
;


/

--------------------------------------------------------
--  DDL for Type CATEGORY_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."CATEGORY_TYP" 
    AS OBJECT
    (
        CATEGORY_NAME VARCHAR2 (50) ,
        CATEGORY_DESCRIPTION VARCHAR2 (1000) ,
        CATEGORY_ID NUMBER (2) ,
        PARENT_CATEGORY_ID NUMBER (2) ,
        MEMBER FUNCTION CATEGORY_DESCRIBE
        RETURN VARCHAR2
    ) NOT FINAL NOT INSTANTIABLE
;
/
CREATE OR REPLACE TYPE BODY "SYSTEM"."CATEGORY_TYP" 
    AS
    MEMBER FUNCTION CATEGORY_DESCRIBE
    RETURN VARCHAR
    AS
    -- Empty PL/SQL Body
    END
;


/

--------------------------------------------------------
--  DDL for Type COMPOSITE_CATEGORY_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."COMPOSITE_CATEGORY_TYP" 
    UNDER CATEGORY_TYP (
        SUBCATEGORY_REF_LIST SUBCATEGORY_REF_LIST_TYP ,
        MEMBER FUNCTION CATEGORY_DESCRIBE
        RETURN VARCHAR2
    ) NOT FINAL
;
/
CREATE OR REPLACE TYPE BODY "SYSTEM"."COMPOSITE_CATEGORY_TYP" 
    AS
    MEMBER FUNCTION CATEGORY_DESCRIBE
    RETURN VARCHAR
    AS
    BEGIN
      RETURN 'composite_category_typ';
    END;

    END
;


/

--------------------------------------------------------
--  DDL for Type CORPORATE_CUSTOMER_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."CORPORATE_CUSTOMER_TYP" 
    UNDER CUSTOMER_TYP (
        ACCOUNT_MGR_ID NUMBER (6)
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type CUSTOMER_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."CUSTOMER_TYP" 
    AS OBJECT
    (
        CUSTOMER_ID NUMBER (6) ,
        CUST_FIRST_NAME VARCHAR2 (20) ,
        CUST_LAST_NAME VARCHAR2 (20) ,
        CUST_ADDRESS CUST_ADDRESS_TYP ,
        PHONE_NUMBERS PHONE_LIST_TYP ,
        NLS_LANGUAGE VARCHAR2 (3) ,
        NLS_TERRITORY VARCHAR2 (30) ,
        CREDIT_LIMIT NUMBER (9,2) ,
        CUST_EMAIL VARCHAR2 (30) ,
        CUST_ORDERS ORDER_LIST_TYP
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type CUST_ADDRESS_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."CUST_ADDRESS_TYP" 
    AS OBJECT
    (
        STREET_ADDRESS VARCHAR2 (40) ,
        POSTAL_CODE VARCHAR2 (10) ,
        CITY VARCHAR2 (30) ,
        STATE_PROVINCE VARCHAR2 (10) ,
        COUNTRY_ID CHAR (2)
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type INVENTORY_LIST_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."INVENTORY_LIST_TYP" 
    IS TABLE OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type INVENTORY_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."INVENTORY_TYP" 
    AS OBJECT
    (
        PRODUCT_ID NUMBER (6) ,
        WAREHOUSE WAREHOUSE_TYP ,
        QUANTITY_ON_HAND NUMBER (8)
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type LEAF_CATEGORY_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."LEAF_CATEGORY_TYP" 
    UNDER CATEGORY_TYP (
        PRODUCT_REF_LIST PRODUCT_REF_LIST_TYP ,
        MEMBER FUNCTION CATEGORY_DESCRIBE
        RETURN VARCHAR2
    ) FINAL
;
/
CREATE OR REPLACE TYPE BODY "SYSTEM"."LEAF_CATEGORY_TYP" 
    AS
    MEMBER FUNCTION CATEGORY_DESCRIBE
    RETURN VARCHAR
    AS
    BEGIN
       RETURN  'leaf_category_typ';
    END;

    END
;


/

--------------------------------------------------------
--  DDL for Type LINEITEMS_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."LINEITEMS_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        LINEITEM LINEITEM_V
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type LINEITEM_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."LINEITEM_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        ITEMNUMBER NUMBER (38) ,
        DESCRIPTION VARCHAR2 (256) ,
        PART PART_T
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type LINEITEM_V
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."LINEITEM_V" 
    IS VARRAY ( 2147483647 ) OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type ORDER_ITEM_LIST_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ORDER_ITEM_LIST_TYP" 
    IS TABLE OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type ORDER_ITEM_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ORDER_ITEM_TYP" 
    AS OBJECT
    (
        ORDER_ID NUMBER (12) ,
        LINE_ITEM_ID NUMBER (3) ,
        UNIT_PRICE NUMBER (8,2) ,
        QUANTITY NUMBER (8) ,
        PRODUCT_REF REF PRODUCT_INFORMATION_TYP
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type ORDER_LIST_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ORDER_LIST_TYP" 
    IS TABLE OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type ORDER_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."ORDER_TYP" 
    AS OBJECT
    (
        ORDER_ID NUMBER (12) ,
        ORDER_MODE VARCHAR2 (8) ,
        CUSTOMER_REF REF CUSTOMER_TYP ,
        ORDER_STATUS NUMBER (2) ,
        ORDER_TOTAL NUMBER (8,2) ,
        SALES_REP_ID NUMBER (6) ,
        ORDER_ITEM_LIST ORDER_ITEM_LIST_TYP
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type PART_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."PART_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        PART_NUMBER VARCHAR2 (14) ,
        QUANTITY NUMBER (8,4) ,
        UNITPRICE NUMBER (12,2)
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type PHONE_LIST_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."PHONE_LIST_TYP" 
    IS VARRAY ( 5 ) OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type PRODUCT_INFORMATION_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."PRODUCT_INFORMATION_TYP" 
    AS OBJECT
    (
        PRODUCT_ID NUMBER (6) ,
        PRODUCT_NAME VARCHAR2 (50) ,
        PRODUCT_DESCRIPTION VARCHAR2 (2000) ,
        CATEGORY_ID NUMBER (2) ,
        WEIGHT_CLASS NUMBER (1) ,
        WARRANTY_PERIOD INTERVAL YEAR TO MONTH ,
        SUPPLIER_ID NUMBER (6) ,
        PRODUCT_STATUS VARCHAR2 (20) ,
        LIST_PRICE NUMBER (8,2) ,
        MIN_PRICE NUMBER (8,2) ,
        CATALOG_URL VARCHAR2 (50) ,
        INVENTORY_LIST INVENTORY_LIST_TYP
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type PRODUCT_REF_LIST_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."PRODUCT_REF_LIST_TYP" 
    IS TABLE OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type PURCHASEORDER_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."PURCHASEORDER_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        REFERENCE VARCHAR2 (30) ,
        ACTIONS ACTIONS_T ,
        REJECTION REJECTION_T ,
        REQUESTOR VARCHAR2 (128) ,
        USERID VARCHAR2 (10) ,
        COST_CENTER VARCHAR2 (4) ,
        SHIPPING_INSTRUCTIONS SHIPPING_INSTRUCTIONS_T ,
        SPECIAL_INSTRUCTIONS VARCHAR2 (2048) ,
        LINEITEMS LINEITEMS_T
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type REJECTION_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."REJECTION_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        REJECTED_BY VARCHAR2 (10) ,
        DATE_REJECTED DATE ,
        REASON_REJECTED VARCHAR2 (2048)
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type REPCAT$_OBJECT_NULL_VECTOR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."REPCAT$_OBJECT_NULL_VECTOR" AS OBJECT
(
  -- type owner, name, hashcode for the type represented by null_vector
  type_owner      VARCHAR2(30),
  type_name       VARCHAR2(30),
  type_hashcode   RAW(17),
  -- null_vector for a particular object instance
  -- ROBJ REVISIT: should only contain the null image, and not version#
  null_vector     RAW(2000)
)


/

--------------------------------------------------------
--  DDL for Type SDO_ELEM_INFO_ARRAY
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."SDO_ELEM_INFO_ARRAY" 
    IS VARRAY ( 1048576 ) OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type SDO_ORDINATE_ARRAY
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."SDO_ORDINATE_ARRAY" 
    IS VARRAY ( 1048576 ) OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type SHIPPING_INSTRUCTIONS_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."SHIPPING_INSTRUCTIONS_T" 
    AS OBJECT
    (
        SYS_XDBPD$ XDB$RAW_LIST_T ,
        SHIP_TO_NAME VARCHAR2 (20) ,
        SHIP_TO_ADDRESS VARCHAR2 (256) ,
        SHIP_TO_PHONE VARCHAR2 (24)
    ) NOT FINAL
;


/

--------------------------------------------------------
--  DDL for Type SUBCATEGORY_REF_LIST_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."SUBCATEGORY_REF_LIST_TYP" 
    IS TABLE OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Type WAREHOUSE_TYP
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."WAREHOUSE_TYP" 
    AS OBJECT
    (
        WAREHOUSE_ID NUMBER (3) ,
        WAREHOUSE_NAME VARCHAR2 (35) ,
        LOCATION_ID NUMBER (4)
    ) FINAL
;


/

--------------------------------------------------------
--  DDL for Type XDB$RAW_LIST_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."XDB$RAW_LIST_T" 
    IS VARRAY ( 1000 ) OF UNKNOWN
;


/

--------------------------------------------------------
--  DDL for Sequence SEQ_DANHMUC
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."SEQ_DANHMUC"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_HOADON
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."SEQ_HOADON"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table CHITIETHOADON
--------------------------------------------------------

  CREATE TABLE "HR"."CHITIETHOADON" 
   (	"MAHOADON" NUMBER(6,0), 
	"MASANPHAM" NUMBER(6,0), 
	"GIA" NUMBER, 
	"SOLUONG" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table DANHMUC
--------------------------------------------------------

  CREATE TABLE "HR"."DANHMUC" 
   (	"MADANHMUC" NUMBER(6,0), 
	"TENDANHMUC" VARCHAR2(60)
   ) ;
--------------------------------------------------------
--  DDL for Table HOADON
--------------------------------------------------------

  CREATE TABLE "HR"."HOADON" 
   (	"MAHOADON" NUMBER(6,0), 
	"TENHOADON" VARCHAR2(60), 
	"NGAYLAP" DATE, 
	"TINHTRANG" VARCHAR2(20), 
	"HINHTHUCTHANHTOAN" VARCHAR2(20), 
	"USERNAME" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table SANPHAM
--------------------------------------------------------

  CREATE TABLE "HR"."SANPHAM" 
   (	"MASANPHAM" NUMBER(6,0), 
	"TENSANPHAM" VARCHAR2(60), 
	"GIA" NUMBER, 
	"SOLUONG" NUMBER, 
	"TINHTRANG" VARCHAR2(60), 
	"MOTA" VARCHAR2(200), 
	"NGAYSANXUAT" NUMBER, 
	"MADANHMUC" NUMBER(6,0), 
	"HINHANH" VARCHAR2(100)
   ) ;
--------------------------------------------------------
--  DDL for Table TAIKHOAN
--------------------------------------------------------

  CREATE TABLE "HR"."TAIKHOAN" 
   (	"USERNAME" VARCHAR2(20), 
	"PASSWORD" VARCHAR2(40), 
	"HOTEN" VARCHAR2(60), 
	"EMAIL" VARCHAR2(60), 
	"DIENTHOAI" NUMBER(11,0), 
	"CONGTY" VARCHAR2(60), 
	"DIACHI" VARCHAR2(60)
   ) ;

---------------------------------------------------
--   DATA FOR TABLE CHITIETHOADON
--   FILTER = none used
---------------------------------------------------
REM INSERTING into HR.CHITIETHOADON

---------------------------------------------------
--   END DATA FOR TABLE CHITIETHOADON
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE DANHMUC
--   FILTER = none used
---------------------------------------------------
REM INSERTING into HR.DANHMUC
Insert into HR.DANHMUC (MADANHMUC,TENDANHMUC) values (1,'danh muc 1');
Insert into HR.DANHMUC (MADANHMUC,TENDANHMUC) values (2,'danh muc 2');
Insert into HR.DANHMUC (MADANHMUC,TENDANHMUC) values (3,'danh muc 3');
Insert into HR.DANHMUC (MADANHMUC,TENDANHMUC) values (4,'danh muc 4');

---------------------------------------------------
--   END DATA FOR TABLE DANHMUC
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE HOADON
--   FILTER = none used
---------------------------------------------------
REM INSERTING into HR.HOADON

---------------------------------------------------
--   END DATA FOR TABLE HOADON
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE SANPHAM
--   FILTER = none used
---------------------------------------------------
REM INSERTING into HR.SANPHAM

---------------------------------------------------
--   END DATA FOR TABLE SANPHAM
---------------------------------------------------


---------------------------------------------------
--   DATA FOR TABLE TAIKHOAN
--   FILTER = none used
---------------------------------------------------
REM INSERTING into HR.TAIKHOAN
Insert into HR.TAIKHOAN (USERNAME,PASSWORD,HOTEN,EMAIL,DIENTHOAI,CONGTY,DIACHI) values ('tk4','123456','Tai Khoan 4','tk4@gmail.com',242342,'adsd','asdasd');
Insert into HR.TAIKHOAN (USERNAME,PASSWORD,HOTEN,EMAIL,DIENTHOAI,CONGTY,DIACHI) values ('tk3','123456','Tai Khoan 3','tk3@gmail.com',1231231,'adsd','asdasd');
Insert into HR.TAIKHOAN (USERNAME,PASSWORD,HOTEN,EMAIL,DIENTHOAI,CONGTY,DIACHI) values ('tk1','123456','Tai Khoan 1','tk1@yahoo.com',123467,'ABC','124 ABC');
Insert into HR.TAIKHOAN (USERNAME,PASSWORD,HOTEN,EMAIL,DIENTHOAI,CONGTY,DIACHI) values ('tk2','123456','Tai Khoan 2','tk2@yahoo.com',124234234,'abc','asddfs');

---------------------------------------------------
--   END DATA FOR TABLE TAIKHOAN
---------------------------------------------------






--------------------------------------------------------
--  DDL for Index CHITETHOADON_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."CHITETHOADON_PK" ON "HR"."CHITIETHOADON" ("MAHOADON", "MASANPHAM") 
  ;
--------------------------------------------------------
--  DDL for Index DANHMUC_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."DANHMUC_PK" ON "HR"."DANHMUC" ("MADANHMUC") 
  ;
--------------------------------------------------------
--  DDL for Index HOADON_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."HOADON_PK" ON "HR"."HOADON" ("MAHOADON") 
  ;
--------------------------------------------------------
--  DDL for Index SANPHAM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SANPHAM_PK" ON "HR"."SANPHAM" ("MASANPHAM") 
  ;
--------------------------------------------------------
--  DDL for Index TAIKHOAN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."TAIKHOAN_PK" ON "HR"."TAIKHOAN" ("USERNAME") 
  ;





--------------------------------------------------------
--  DDL for Trigger DANHMUC_TRIGGER_IDUP
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."DANHMUC_TRIGGER_IDUP" 
BEFORE INSERT ON danhmuc
	for each row
	begin
    select seq_danhmuc.nextval into :new.madanhmuc from dual;
	end;
/
ALTER TRIGGER "HR"."DANHMUC_TRIGGER_IDUP" ENABLE;
--------------------------------------------------------
--  DDL for Trigger HOADON_TRIGGER_IDUP
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."HOADON_TRIGGER_IDUP" 
BEFORE INSERT ON hoadon
for each row
begin
    select seq_hoadon.nextval into :new.mahoadon from dual;
end;
/
ALTER TRIGGER "HR"."HOADON_TRIGGER_IDUP" ENABLE;
--------------------------------------------------------
--  DDL for View EMP_DETAILS_VIEW
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."EMP_DETAILS_VIEW" ("EMPLOYEE_ID", "JOB_ID", "MANAGER_ID", "DEPARTMENT_ID", "LOCATION_ID", "COUNTRY_ID", "FIRST_NAME", "LAST_NAME", "SALARY", "COMMISSION_PCT", "DEPARTMENT_NAME", "JOB_TITLE", "CITY", "STATE_PROVINCE", "COUNTRY_NAME", "REGION_NAME") AS 
  SELECT
  e.employee_id,
  e.job_id,
  e.manager_id,
  e.department_id,
  d.location_id,
  l.country_id,
  e.first_name,
  e.last_name,
  e.salary,
  e.commission_pct,
  d.department_name,
  j.job_title,
  l.city,
  l.state_province,
  c.country_name,
  r.region_name
FROM
  employees e,
  departments d,
  jobs j,
  locations l,
  countries c,
  regions r
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id
  AND l.country_id = c.country_id
  AND c.region_id = r.region_id
  AND j.job_id = e.job_id
WITH READ ONLY;
--------------------------------------------------------
--  DDL for View MVIEW_EVALUATIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_EVALUATIONS" ("RUNID", "MVIEW_OWNER", "MVIEW_NAME", "RANK", "STORAGE_IN_BYTES", "FREQUENCY", "CUMULATIVE_BENEFIT", "BENEFIT_TO_COST_RATIO") AS 
  select
  t1.runid# as runid,
  summary_owner AS mview_owner,
  summary_name AS mview_name,
  rank# as rank,
  storage_in_bytes,
  frequency,
  cumulative_benefit,
  benefit_to_cost_ratio
from SYSTEM.MVIEW$_ADV_OUTPUT t1, SYSTEM.MVIEW$_ADV_LOG t2, ALL_USERS u
where
  t1.runid# = t2.runid# and
  u.username = t2.uname and
  u.user_id = userenv('SCHEMAID') and
  t1.output_type = 1
order by t1.rank#;
--------------------------------------------------------
--  DDL for View MVIEW_EXCEPTIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_EXCEPTIONS" ("RUNID", "OWNER", "TABLE_NAME", "DIMENSION_NAME", "RELATIONSHIP", "BAD_ROWID") AS 
  select
  t1.runid# as runid,
  owner,
  table_name,
  dimension_name,
  relationship,
  bad_rowid
from SYSTEM.MVIEW$_ADV_EXCEPTIONS t1, SYSTEM.MVIEW$_ADV_LOG t2, ALL_USERS u
where
  t1.runid# = t2.runid# and
  u.username = t2.uname and
  u.user_id = userenv('SCHEMAID');
--------------------------------------------------------
--  DDL for View MVIEW_FILTER
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_FILTER" ("FILTERID", "SUBFILTERNUM", "SUBFILTERTYPE", "STR_VALUE", "NUM_VALUE1", "NUM_VALUE2", "DATE_VALUE1", "DATE_VALUE2") AS 
  select
      a.filterid# as filterid,
      a.subfilternum# as subfilternum,
      decode(a.subfiltertype,1,'APPLICATION',2,'CARDINALITY',3,'LASTUSE',
                             4,'FREQUENCY',5,'USER',6,'PRIORITY',7,'BASETABLE',
                             8,'RESPONSETIME',9,'COLLECTIONID',10,'TRACENAME',
                             11,'SCHEMA','UNKNOWN') AS subfiltertype,
      a.str_value,
      to_number(decode(a.num_value1,-999,NULL,a.num_value1)) AS num_value1,
      to_number(decode(a.num_value2,-999,NULL,a.num_value2)) AS num_value2,
      a.date_value1,
      a.date_value2
   from system.mview$_adv_filter a, system.mview$_adv_log b, ALL_USERS u
   WHERE a.filterid# = b.runid#
   AND b.uname = u.username
   AND u.user_id = userenv('SCHEMAID');
--------------------------------------------------------
--  DDL for View MVIEW_FILTERINSTANCE
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_FILTERINSTANCE" ("RUNID", "FILTERID", "SUBFILTERNUM", "SUBFILTERTYPE", "STR_VALUE", "NUM_VALUE1", "NUM_VALUE2", "DATE_VALUE1", "DATE_VALUE2") AS 
  select
      a.runid# as runid,
      a.filterid# as filterid,
      a.subfilternum# as subfilternum,
      decode(a.subfiltertype,1,'APPLICATION',2,'CARDINALITY',3,'LASTUSE',
                             4,'FREQUENCY',5,'USER',6,'PRIORITY',7,'BASETABLE',
                             8,'RESPONSETIME',9,'COLLECTIONID',10,'TRACENAME',
                             11,'SCHEMA','UNKNOWN') AS subfiltertype,
      a.str_value,
      to_number(decode(a.num_value1,-999,NULL,a.num_value1)) AS num_value1,
      to_number(decode(a.num_value2,-999,NULL,a.num_value2)) AS num_value2,
      a.date_value1,
      a.date_value2
   from system.mview$_adv_filterinstance a;
--------------------------------------------------------
--  DDL for View MVIEW_LOG
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_LOG" ("ID", "FILTERID", "RUN_BEGIN", "RUN_END", "TYPE", "STATUS", "MESSAGE", "COMPLETED", "TOTAL", "ERROR_CODE") AS 
  select
      m.runid# as id,
      m.filterid# as filterid,
      m.run_begin,
      m.run_end,
      decode(m.run_type,1,'EVALUATE',2,'EVALUATE_W',3,'RECOMMEND',
                      4,'RECOMMEND_W',5,'VALIDATE',6,'WORKLOAD',
                      7,'FILTER','UNKNOWN') AS type,
      decode(m.status,0,'UNUSED',1,'CANCELLED',2,'IN_PROGRESS',3,'COMPLETED',
                    4,'ERROR','UNKNOWN') AS status,
      m.message,
      m.completed,
      m.total,
      m.error_code
   from system.mview$_adv_log m, all_users u
   where m.uname = u.username
   and   u.user_id = userenv('SCHEMAID');
--------------------------------------------------------
--  DDL for View MVIEW_RECOMMENDATIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_RECOMMENDATIONS" ("RUNID", "ALL_TABLES", "FACT_TABLES", "GROUPING_LEVELS", "QUERY_TEXT", "RECOMMENDATION_NUMBER", "RECOMMENDED_ACTION", "MVIEW_OWNER", "MVIEW_NAME", "STORAGE_IN_BYTES", "PCT_PERFORMANCE_GAIN", "BENEFIT_TO_COST_RATIO") AS 
  select
  t1.runid# as runid,
  t1.from_clause as all_tables,
  fact_tables,
  grouping_levels,
  query_text,
  rank# as recommendation_number,
  action_type as recommended_action,
  summary_owner as mview_owner,
  summary_name as mview_name,
  storage_in_bytes,
  pct_performance_gain,
  benefit_to_cost_ratio
from SYSTEM.MVIEW$_ADV_OUTPUT t1, SYSTEM.MVIEW$_ADV_LOG t2, ALL_USERS u
where
  t1.runid# = t2.runid# and
  u.username = t2.uname and
  u.user_id = userenv('SCHEMAID') and
  t1.output_type = 0
order by t1.rank#;
--------------------------------------------------------
--  DDL for View MVIEW_WORKLOAD
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_WORKLOAD" ("WORKLOADID", "IMPORT_TIME", "QUERYID", "APPLICATION", "CARDINALITY", "RESULTSIZE", "LASTUSE", "FREQUENCY", "OWNER", "PRIORITY", "QUERY", "RESPONSETIME") AS 
  select
  a.collectionid# as workloadid,
  a.collecttime as import_time,
  a.queryid# as queryid,
  a.application,
  a.cardinality,
  a.resultsize,
  a.qdate as lastuse,
  a.frequency,
  a.uname as owner,
  a.priority,
  a.sql_text as query,
  a.exec_time as responsetime
from SYSTEM.MVIEW$_ADV_WORKLOAD A, SYSTEM.MVIEW$_ADV_LOG B, ALL_USERS D
WHERE a.collectionid# = b.runid#
AND b.uname = d.username
AND d.user_id = userenv('SCHEMAID');
--------------------------------------------------------
--  DDL for View PRODUCT_PRIVS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."PRODUCT_PRIVS" ("PRODUCT", "USERID", "ATTRIBUTE", "SCOPE", "NUMERIC_VALUE", "CHAR_VALUE", "DATE_VALUE", "LONG_VALUE") AS 
  SELECT PRODUCT, USERID, ATTRIBUTE, SCOPE,
         NUMERIC_VALUE, CHAR_VALUE, DATE_VALUE, LONG_VALUE
  FROM SQLPLUS_PRODUCT_PROFILE
  WHERE USERID = 'PUBLIC' OR USER LIKE USERID;
--------------------------------------------------------
--  DDL for Package DBMS_REPCAT_AUTH
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SYSTEM"."DBMS_REPCAT_AUTH" wrapped
a000000
1
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
9
bf d6
0cfc6e4Sm6mfaMYwsbW2JygBepcwg/BKmJ4VZy/pO06UXsVUMejsissTcGWYR4qeK4TPqfDK
q7UPH+SmKP6nW9zmxMZnuK1VDzM0Iv9O4E4SvvsnHWn+EPF9hR+oBFe3fEro6RQ5R5Ejd1nr
e+fAK010dExf76gg/c6ZB3YxGPHDOqkGI4lV6HNsd57gKLwTd0bxan5UwJriIpt7Vjc=

/

--------------------------------------------------------
--  DDL for Package Body DBMS_REPCAT_AUTH
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "SYSTEM"."DBMS_REPCAT_AUTH" wrapped
a000000
1
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
b
ba5 3a0
WEr0nOgRMSPBS3Z7Kvjx5JCUt2owg5WnTCCDfI5Av1UPOFy3ytP8lZ8t3hEfG60CTfSQMcvV
6ivyNKey557uUQmq5H5JbD4u2nCU8C8sxsa7x7zmdjj+nij7sk14NSnX4GLHDewbAlnflaQV
5Ip0a4vV4HdElsmpesU60A7ZRG8v4fOFSRFfWNoVil6uEiKYBLiqWripX8GpJaZ8UshyxIOj
3EV/homo0wcdcBB50gZ8bonh0GB5pN1QSW8ltNLN2ps5qHg4TFDnWgG7up3N8kaIB0jtO+rR
OP839Jnm3sPBXdL8EIaW3GOR7ycVj6toVCHpkKRN/WnLPYPi/XGYL71P09LHNjbMf+HU9z+W
ttKW9ohPDLdUXmufaLawN9vr5XOAgXkPX9PgtMFLHhe8jXO5u0o3rjZ87bqbdX97dwK3zxUy
OkWEQPSP30tF7ju3s8C+dWlmC1W3i3GtyWbzGK2Eurr+TuoTsQS0Dt/syQBYtpARlGmMcJ/Q
uZHG0WvcncL9qX/vNbNCWwB6eljzuQfMpuir8Y8vRTLYSlLNbup7L7i0RH8E69URqExlq/ko
CrPr/P+gWYZqqKbq0vWo8JEolfewBUbS3Tu7sQKjcYnE5Mb8PMR/fVNBoOXYkAMs3eudRCE1
YAM+sULch667d2YxFf7vvKfyn066LtD/6OlO0EWc6368k1axWwIxZjIKp8Wuno28ytJgAT8N
j5LHQVUcVKXxVfHM7P8oicVqILtVxXIrgOk8iVWdqwrPp0MDBvmkyJvfct+wRz2bw6Mum72v
bKVdOosnO6+VVrq8mcPRw1KcY0mRSRP16HIg6fdySN8Ce94HnJ2LA9Squbok3/mN0v1H0lLO
XPFJRbPFqmI2+F8/KVORKCsXMw4BHLV0Zh+Z9At//KrOmWxKssU=

/

--------------------------------------------------------
--  DDL for Procedure ADD_JOB_HISTORY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SYSTEM"."ADD_JOB_HISTORY" 
  (  p_emp_id          job_history.employee_id%type
   , p_start_date      job_history.start_date%type
   , p_end_date        job_history.end_date%type
   , p_job_id          job_history.job_id%type
   , p_department_id   job_history.department_id%type
   )
IS
BEGIN
  INSERT INTO job_history (employee_id, start_date, end_date,
                           job_id, department_id)
    VALUES(p_emp_id, p_start_date, p_end_date, p_job_id, p_department_id);
END add_job_history;

/

--------------------------------------------------------
--  DDL for Procedure ORA$_SYS_REP_AUTH
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SYSTEM"."ORA$_SYS_REP_AUTH" as
begin
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.repcat$_repschema TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.repcat$_repprop TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_aqcall TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_calldest TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_error TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_destination TO SYS ' ||
                 'WITH GRANT OPTION';
end;

/

--------------------------------------------------------
--  DDL for Procedure SECURE_DML
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SYSTEM"."SECURE_DML" 
IS
BEGIN
  IF TO_CHAR (SYSDATE, 'HH24:MI') NOT BETWEEN '08:00' AND '18:00'
        OR TO_CHAR (SYSDATE, 'DY') IN ('SAT', 'SUN') THEN
	RAISE_APPLICATION_ERROR (-20205,
		'You may only make changes during normal office hours');
  END IF;
END secure_dml;

/

--------------------------------------------------------
--  DDL for Synonymn CATALOG
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."CATALOG" FOR "SYS"."CATALOG";
--------------------------------------------------------
--  DDL for Synonymn COL
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."COL" FOR "SYS"."COL";
--------------------------------------------------------
--  DDL for Synonymn PRODUCT_USER_PROFILE
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."PRODUCT_USER_PROFILE" FOR "SYSTEM"."SQLPLUS_PRODUCT_PROFILE";
--------------------------------------------------------
--  DDL for Synonymn PUBLICSYN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."PUBLICSYN" FOR "SYS"."PUBLICSYN";
--------------------------------------------------------
--  DDL for Synonymn SYSCATALOG
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."SYSCATALOG" FOR "SYS"."SYSCATALOG";
--------------------------------------------------------
--  DDL for Synonymn SYSFILES
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."SYSFILES" FOR "SYS"."SYSFILES";
--------------------------------------------------------
--  DDL for Synonymn TAB
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."TAB" FOR "SYS"."TAB";
--------------------------------------------------------
--  DDL for Synonymn TABQUOTAS
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."TABQUOTAS" FOR "SYS"."TABQUOTAS";
--------------------------------------------------------
--  DDL for Queue DEF$_AQERROR
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE(
     Queue_name          => 'SYSTEM.DEF$_AQERROR',
     Queue_table         => 'SYSTEM.DEF$_AQERROR',
     Queue_type          =>  0,
     Max_retries         =>  5,
     Retry_delay         =>  0,
     dependency_tracking =>  TRUE,
     comment             => 'Error Queue for Deferred RPCs');
  END;
--------------------------------------------------------
--  DDL for Queue DEF$_AQCALL
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE(
     Queue_name          => 'SYSTEM.DEF$_AQCALL',
     Queue_table         => 'SYSTEM.DEF$_AQCALL',
     Queue_type          =>  0,
     Max_retries         =>  5,
     Retry_delay         =>  0,
     dependency_tracking =>  TRUE,
     comment             => 'Deferred RPC Queue');
  END;
--------------------------------------------------------
--  DDL for Queue Table DEF$_AQCALL
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE_TABLE(
     Queue_table        => '"SYSTEM"."DEF$_AQCALL"',
     Queue_payload_type => 'VARIANT',
     storage_clause     => 'PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 TABLESPACE SYSTEM',
     Sort_list          => 'ENQ_TIME',
     Compatible         => '8.0.3');
  END;
--------------------------------------------------------
--  DDL for Queue Table DEF$_AQERROR
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE_TABLE(
     Queue_table        => '"SYSTEM"."DEF$_AQERROR"',
     Queue_payload_type => 'VARIANT',
     storage_clause     => 'PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 TABLESPACE SYSTEM',
     Sort_list          => 'ENQ_TIME',
     Compatible         => '8.0.3');
  END;
