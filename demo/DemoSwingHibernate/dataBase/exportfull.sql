--------------------------------------------------------
--  File created - Friday-July-11-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DEPARTMENTS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."DEPARTMENTS_SEQ"  MINVALUE 1 MAXVALUE 9990 INCREMENT BY 10 START WITH 280 NOCACHE  NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence EMPLOYEES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."EMPLOYEES_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 207 NOCACHE  NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence IDS
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."IDS"  MINVALUE 50 MAXVALUE 500 INCREMENT BY 5 START WITH 90 NOCACHE  NOORDER  CYCLE
--------------------------------------------------------
--  DDL for Sequence LOCATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."LOCATIONS_SEQ"  MINVALUE 1 MAXVALUE 9900 INCREMENT BY 100 START WITH 3300 NOCACHE  NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence SEQ_DANHMUC
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."SEQ_DANHMUC"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence SEQ_HOADON
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."SEQ_HOADON"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Table CHITIETHOADON
--------------------------------------------------------

  CREATE TABLE "HR"."CHITIETHOADON" ("MAHOADON" NUMBER(6,0), "MASANPHAM" NUMBER(6,0), "GIA" NUMBER, "SOLUONG" NUMBER)
--------------------------------------------------------
--  DDL for Table COUNTRIES
--------------------------------------------------------

  CREATE TABLE "HR"."COUNTRIES" ("COUNTRY_ID" CHAR(2), "COUNTRY_NAME" VARCHAR2(40), "REGION_ID" NUMBER,  CONSTRAINT "COUNTRY_C_ID_PK" PRIMARY KEY ("COUNTRY_ID") ENABLE) ORGANIZATION INDEX NOCOMPRESS 
 

   COMMENT ON COLUMN "HR"."COUNTRIES"."COUNTRY_ID" IS 'Primary key of countries table.'
 
   COMMENT ON COLUMN "HR"."COUNTRIES"."COUNTRY_NAME" IS 'Country name'
 
   COMMENT ON COLUMN "HR"."COUNTRIES"."REGION_ID" IS 'Region ID for the country. Foreign key to region_id column in the departments table.'
 
   COMMENT ON TABLE "HR"."COUNTRIES"  IS 'country table. Contains 25 rows. References with locations table.'
--------------------------------------------------------
--  DDL for Table DANHMUC
--------------------------------------------------------

  CREATE TABLE "HR"."DANHMUC" ("MADANHMUC" NUMBER(6,0), "TENDANHMUC" VARCHAR2(60))
--------------------------------------------------------
--  DDL for Table DEPARTMENTS
--------------------------------------------------------

  CREATE TABLE "HR"."DEPARTMENTS" ("DEPARTMENT_ID" NUMBER(4,0), "DEPARTMENT_NAME" VARCHAR2(30), "MANAGER_ID" NUMBER(6,0), "LOCATION_ID" NUMBER(4,0)) 
 

   COMMENT ON COLUMN "HR"."DEPARTMENTS"."DEPARTMENT_ID" IS 'Primary key column of departments table.'
 
   COMMENT ON COLUMN "HR"."DEPARTMENTS"."DEPARTMENT_NAME" IS 'A not null column that shows name of a department. Administration,
Marketing, Purchasing, Human Resources, Shipping, IT, Executive, Public
Relations, Sales, Finance, and Accounting. '
 
   COMMENT ON COLUMN "HR"."DEPARTMENTS"."MANAGER_ID" IS 'Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.'
 
   COMMENT ON COLUMN "HR"."DEPARTMENTS"."LOCATION_ID" IS 'Location id where a department is located. Foreign key to location_id column of locations table.'
 
   COMMENT ON TABLE "HR"."DEPARTMENTS"  IS 'Departments table that shows details of departments where employees
work. Contains 27 rows; references with locations, employees, and job_history tables.'
--------------------------------------------------------
--  DDL for Table EMPLOYEES
--------------------------------------------------------

  CREATE TABLE "HR"."EMPLOYEES" ("EMPLOYEE_ID" NUMBER(6,0), "FIRST_NAME" VARCHAR2(20), "LAST_NAME" VARCHAR2(25), "EMAIL" VARCHAR2(25), "PHONE_NUMBER" VARCHAR2(20), "HIRE_DATE" DATE, "JOB_ID" VARCHAR2(10), "SALARY" NUMBER(8,2), "COMMISSION_PCT" NUMBER(2,2), "MANAGER_ID" NUMBER(6,0), "DEPARTMENT_ID" NUMBER(4,0)) 
 

   COMMENT ON COLUMN "HR"."EMPLOYEES"."EMPLOYEE_ID" IS 'Primary key of employees table.'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."FIRST_NAME" IS 'First name of the employee. A not null column.'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."LAST_NAME" IS 'Last name of the employee. A not null column.'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."EMAIL" IS 'Email id of the employee'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."PHONE_NUMBER" IS 'Phone number of the employee; includes country code and area code'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."HIRE_DATE" IS 'Date when the employee started on this job. A not null column.'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."JOB_ID" IS 'Current job of the employee; foreign key to job_id column of the
jobs table. A not null column.'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."SALARY" IS 'Monthly salary of the employee. Must be greater
than zero (enforced by constraint emp_salary_min)'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."COMMISSION_PCT" IS 'Commission percentage of the employee; Only employees in sales
department elgible for commission percentage'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."MANAGER_ID" IS 'Manager id of the employee; has same domain as manager_id in
departments table. Foreign key to employee_id column of employees table.
(useful for reflexive joins and CONNECT BY query)'
 
   COMMENT ON COLUMN "HR"."EMPLOYEES"."DEPARTMENT_ID" IS 'Department id where employee works; foreign key to department_id
column of the departments table'
 
   COMMENT ON TABLE "HR"."EMPLOYEES"  IS 'employees table. Contains 107 rows. References with departments,
jobs, job_history tables. Contains a self reference.'
--------------------------------------------------------
--  DDL for Table HOADON
--------------------------------------------------------

  CREATE TABLE "HR"."HOADON" ("MAHOADON" NUMBER(6,0), "TENHOADON" VARCHAR2(60), "NGAYLAP" DATE, "TINHTRANG" VARCHAR2(20), "HINHTHUCTHANHTOAN" VARCHAR2(20), "USERNAME" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table JOBS
--------------------------------------------------------

  CREATE TABLE "HR"."JOBS" ("JOB_ID" VARCHAR2(10), "JOB_TITLE" VARCHAR2(35), "MIN_SALARY" NUMBER(6,0), "MAX_SALARY" NUMBER(6,0)) 
 

   COMMENT ON COLUMN "HR"."JOBS"."JOB_ID" IS 'Primary key of jobs table.'
 
   COMMENT ON COLUMN "HR"."JOBS"."JOB_TITLE" IS 'A not null column that shows job title, e.g. AD_VP, FI_ACCOUNTANT'
 
   COMMENT ON COLUMN "HR"."JOBS"."MIN_SALARY" IS 'Minimum salary for a job title.'
 
   COMMENT ON COLUMN "HR"."JOBS"."MAX_SALARY" IS 'Maximum salary for a job title'
 
   COMMENT ON TABLE "HR"."JOBS"  IS 'jobs table with job titles and salary ranges. Contains 19 rows.
References with employees and job_history table.'
--------------------------------------------------------
--  DDL for Table JOB_HISTORY
--------------------------------------------------------

  CREATE TABLE "HR"."JOB_HISTORY" ("EMPLOYEE_ID" NUMBER(6,0), "START_DATE" DATE, "END_DATE" DATE, "JOB_ID" VARCHAR2(10), "DEPARTMENT_ID" NUMBER(4,0)) 
 

   COMMENT ON COLUMN "HR"."JOB_HISTORY"."EMPLOYEE_ID" IS 'A not null column in the complex primary key employee_id+start_date.
Foreign key to employee_id column of the employee table'
 
   COMMENT ON COLUMN "HR"."JOB_HISTORY"."START_DATE" IS 'A not null column in the complex primary key employee_id+start_date.
Must be less than the end_date of the job_history table. (enforced by
constraint jhist_date_interval)'
 
   COMMENT ON COLUMN "HR"."JOB_HISTORY"."END_DATE" IS 'Last day of the employee in this job role. A not null column. Must be
greater than the start_date of the job_history table.
(enforced by constraint jhist_date_interval)'
 
   COMMENT ON COLUMN "HR"."JOB_HISTORY"."JOB_ID" IS 'Job role in which the employee worked in the past; foreign key to
job_id column in the jobs table. A not null column.'
 
   COMMENT ON COLUMN "HR"."JOB_HISTORY"."DEPARTMENT_ID" IS 'Department id in which the employee worked in the past; foreign key to deparment_id column in the departments table'
 
   COMMENT ON TABLE "HR"."JOB_HISTORY"  IS 'Table that stores job history of the employees. If an employee
changes departments within the job or changes jobs within the department,
new rows get inserted into this table with old job information of the
employee. Contains a complex primary key: employee_id+start_date.
Contains 25 rows. References with jobs, employees, and departments tables.'
--------------------------------------------------------
--  DDL for Table LOCATIONS
--------------------------------------------------------

  CREATE TABLE "HR"."LOCATIONS" ("LOCATION_ID" NUMBER(4,0), "STREET_ADDRESS" VARCHAR2(40), "POSTAL_CODE" VARCHAR2(12), "CITY" VARCHAR2(30), "STATE_PROVINCE" VARCHAR2(25), "COUNTRY_ID" CHAR(2)) 
 

   COMMENT ON COLUMN "HR"."LOCATIONS"."LOCATION_ID" IS 'Primary key of locations table'
 
   COMMENT ON COLUMN "HR"."LOCATIONS"."STREET_ADDRESS" IS 'Street address of an office, warehouse, or production site of a company.
Contains building number and street name'
 
   COMMENT ON COLUMN "HR"."LOCATIONS"."POSTAL_CODE" IS 'Postal code of the location of an office, warehouse, or production site
of a company. '
 
   COMMENT ON COLUMN "HR"."LOCATIONS"."CITY" IS 'A not null column that shows city where an office, warehouse, or
production site of a company is located. '
 
   COMMENT ON COLUMN "HR"."LOCATIONS"."STATE_PROVINCE" IS 'State or Province where an office, warehouse, or production site of a
company is located.'
 
   COMMENT ON COLUMN "HR"."LOCATIONS"."COUNTRY_ID" IS 'Country where an office, warehouse, or production site of a company is
located. Foreign key to country_id column of the countries table.'
 
   COMMENT ON TABLE "HR"."LOCATIONS"  IS 'Locations table that contains specific address of a specific office,
warehouse, and/or production site of a company. Does not store addresses /
locations of customers. Contains 23 rows; references with the
departments and countries tables. '
--------------------------------------------------------
--  DDL for Table REGIONS
--------------------------------------------------------

  CREATE TABLE "HR"."REGIONS" ("REGION_ID" NUMBER, "REGION_NAME" VARCHAR2(25))
--------------------------------------------------------
--  DDL for Table SANPHAM
--------------------------------------------------------

  CREATE TABLE "HR"."SANPHAM" ("MASANPHAM" NUMBER(6,0), "TENSANPHAM" VARCHAR2(60), "GIA" NUMBER, "SOLUONG" NUMBER, "TINHTRANG" VARCHAR2(60), "MOTA" VARCHAR2(200), "NGAYSANXUAT" NUMBER, "MADANHMUC" NUMBER(6,0), "HINHANH" VARCHAR2(100))
--------------------------------------------------------
--  DDL for Table STUDENTS
--------------------------------------------------------

  CREATE TABLE "HR"."STUDENTS" ("NAME" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table TABLE1
--------------------------------------------------------

  CREATE TABLE "HR"."TABLE1" ("ID" NUMBER(3,0), "NAME" VARCHAR2(20), "ADDRESS" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table TAIKHOAN
--------------------------------------------------------

  CREATE TABLE "HR"."TAIKHOAN" ("USERNAME" VARCHAR2(20), "PASSWORD" VARCHAR2(40), "HOTEN" VARCHAR2(60), "EMAIL" VARCHAR2(60), "DIENTHOAI" NUMBER(11,0), "CONGTY" VARCHAR2(60), "DIACHI" VARCHAR2(60))
--------------------------------------------------------
--  DDL for Trigger DANHMUC_TRIGGER_IDUP
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."DANHMUC_TRIGGER_IDUP" 
BEFORE INSERT ON danhmuc
	for each row
	begin
    select seq_danhmuc.nextval into :new.madanhmuc from dual;
	end;
ALTER TRIGGER "HR"."DANHMUC_TRIGGER_IDUP" ENABLE
--------------------------------------------------------
--  DDL for Trigger HOADON_TRIGGER_IDUP
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."HOADON_TRIGGER_IDUP" 
BEFORE INSERT ON hoadon
for each row
begin
    select seq_hoadon.nextval into :new.mahoadon from dual;
end;
ALTER TRIGGER "HR"."HOADON_TRIGGER_IDUP" ENABLE
--------------------------------------------------------
--  DDL for Trigger SECURE_EMPLOYEES
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."SECURE_EMPLOYEES" 
  BEFORE INSERT OR UPDATE OR DELETE ON employees
BEGIN
  secure_dml;
END secure_employees;
ALTER TRIGGER "HR"."SECURE_EMPLOYEES" DISABLE
--------------------------------------------------------
--  DDL for Trigger UPDATE_JOB_HISTORY
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."UPDATE_JOB_HISTORY" 
  AFTER UPDATE OF job_id, department_id ON employees
  FOR EACH ROW
BEGIN
  add_job_history(:old.employee_id, :old.hire_date, sysdate,
                  :old.job_id, :old.department_id);
END;
ALTER TRIGGER "HR"."UPDATE_JOB_HISTORY" ENABLE
