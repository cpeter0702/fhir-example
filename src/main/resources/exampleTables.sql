create table FHIR_ADDRESS
(
    ADDR_ID         VARCHAR(50) not null
        primary key,
    ADDR_SOURCE     VARCHAR(50),
    ADDR_ORG_ID     VARCHAR(50),
    ADDR_CONTACT_ID VARCHAR(50),
    ADDR_1          VARCHAR(100),
    ADDR_2          VARCHAR(100),
    ADDR_CITY       VARCHAR(100),
    ADDR_DISTRICT   VARCHAR(100),
    ADDR_STATE      VARCHAR(100),
    ADDR_ZIPCODE    VARCHAR(100),
    ADDR_COUNTRY    VARCHAR(100),
    ADD_CREATED     TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_ADDRESS (ADDR_ID, ADDR_SOURCE, ADDR_ORG_ID, ADDR_CONTACT_ID, ADDR_1, ADDR_2, ADDR_CITY, ADDR_DISTRICT, ADDR_STATE, ADDR_ZIPCODE, ADDR_COUNTRY, ADD_CREATED) VALUES ('357b8bdf-98ae-40ae-9275-5c8d08ad0697', 'organization', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'f0bff7ee-d568-4854-ab1e-0d55f9b08daf', '石牌路二段', '201號', '台北市', '北投區', '台灣省', '11217', '中華民國', '2021-10-01 17:13:22.540000');
INSERT INTO MYSCHEMA.FHIR_ADDRESS (ADDR_ID, ADDR_SOURCE, ADDR_ORG_ID, ADDR_CONTACT_ID, ADDR_1, ADDR_2, ADDR_CITY, ADDR_DISTRICT, ADDR_STATE, ADDR_ZIPCODE, ADDR_COUNTRY, ADD_CREATED) VALUES ('7ca0145e-53ec-4a41-8c72-7f47b1d04eaf', 'organization', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'f0bff7ee-d568-4854-ab1e-0d55f9b08daf', 'Sec. 2, Shipai Rd.', 'No.201', 'Taipei', 'Beitou', 'Taiwan', '11217', 'R.O.C.', '2021-10-01 17:13:27.320000');
INSERT INTO MYSCHEMA.FHIR_ADDRESS (ADDR_ID, ADDR_SOURCE, ADDR_ORG_ID, ADDR_CONTACT_ID, ADDR_1, ADDR_2, ADDR_CITY, ADDR_DISTRICT, ADDR_STATE, ADDR_ZIPCODE, ADDR_COUNTRY, ADD_CREATED) VALUES ('afe642b5-6ffd-452d-81cd-fa9a701d383a', 'organization', '2e3d28b9-a09e-4018-901c-1339152e9420', '4b15400d-9ba2-4704-87af-29f8bcc312c2', '中山南路', '7號', '台北市', '中正區', '台灣省', '100225 ', '中華民國', '2021-10-01 17:13:32.773000');
INSERT INTO MYSCHEMA.FHIR_ADDRESS (ADDR_ID, ADDR_SOURCE, ADDR_ORG_ID, ADDR_CONTACT_ID, ADDR_1, ADDR_2, ADDR_CITY, ADDR_DISTRICT, ADDR_STATE, ADDR_ZIPCODE, ADDR_COUNTRY, ADD_CREATED) VALUES ('1ecb6585-7b56-4ae8-a3a1-88704e842769', 'organization', '2e3d28b9-a09e-4018-901c-1339152e9420', '4b15400d-9ba2-4704-87af-29f8bcc312c2', 'Jhongshan S. Rd.', 'No.7', 'Taipei', 'Zhongzheng', 'Taiwan', '100225 ', 'R.O.C.', '2021-10-01 17:13:36.194000');

create table FHIR_CONTACT
(
    CON_ID          VARCHAR(50) not null
        primary key,
    CON_SOURCE      VARCHAR(50),
    CON_ORG_ID      VARCHAR(50),
    CON_NAME_USE    VARCHAR(100),
    CON_NAME_TEXT   VARCHAR(100),
    CON_NAME_FAMILY VARCHAR(100),
    CON_NAME_GIVEN  VARCHAR(100),
    CON_NAME_PREFIX VARCHAR(100),
    CON_CREATED     TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_CONTACT (CON_ID, CON_SOURCE, CON_ORG_ID, CON_NAME_USE, CON_NAME_TEXT, CON_NAME_FAMILY, CON_NAME_GIVEN, CON_NAME_PREFIX, CON_CREATED) VALUES ('f0bff7ee-d568-4854-ab1e-0d55f9b08daf', 'organization', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'official', '行政單位', 'Brand', 'Ronald', 'Prof.', '2021-10-01 17:14:18.027000');
INSERT INTO MYSCHEMA.FHIR_CONTACT (CON_ID, CON_SOURCE, CON_ORG_ID, CON_NAME_USE, CON_NAME_TEXT, CON_NAME_FAMILY, CON_NAME_GIVEN, CON_NAME_PREFIX, CON_CREATED) VALUES ('4b15400d-9ba2-4704-87af-29f8bcc312c2', 'organization', '2e3d28b9-a09e-4018-901c-1339152e9420', 'official', '客戶服務單位', 'James', 'Lebron', 'Dr.', '2021-10-01 17:14:26.200000');

create table FHIR_ENCOUNTER
(
    ENCOUNTER_ID            VARCHAR(50),
    IDENDIFIER              VARCHAR(50),
    STATUS                  VARCHAR(50),
    ENCOUNTER_SYSTEM        VARCHAR(100),
    CODE                    VARCHAR(100),
    DISPLAY                 VARCHAR(100),
    SUBJECT_TYPE            VARCHAR(50),
    SUBJECT_URL             VARCHAR(50),
    HOSPITALIZATION_SYSTEM  VARCHAR(300),
    HOSPITALIZATION_CODE    VARCHAR(300),
    HOSPITALIZATION_DISPLAY VARCHAR(300),
    CREATED                 TIMESTAMP(6),
    PERIOD_START            TIMESTAMP(6),
    PERIOD_END              TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_ENCOUNTER (ENCOUNTER_ID, IDENDIFIER, STATUS, ENCOUNTER_SYSTEM, CODE, DISPLAY, SUBJECT_TYPE, SUBJECT_URL, HOSPITALIZATION_SYSTEM, HOSPITALIZATION_CODE, HOSPITALIZATION_DISPLAY, CREATED, PERIOD_START, PERIOD_END) VALUES ('68e8e442-563f-48cd-8845-d39e31cb4396', 'A123456789', 'in-progress', 'http://terminology.hl7.org/CodeSystem/v3-ActCode', 'IMP', 'inpatient encounter', 'Patient', '17c96bac20a-8d6e5de5-cd82-46a2-b769-41ba356cb2ef', 'http://terminology.hl7.org/CodeSystem/admit-source', 'emd', 'From accident/emergency department', '2021-10-17 17:05:09.067000', '2017-02-01 07:15:00.000000', null);

create table FHIR_ENCOUNTER_CLASS_HISTORY
(
    ENCOUNTER_HISTORY_ID VARCHAR(50),
    ENCOUNTER_ID         VARCHAR(50),
    CLASS_SYSTEM         VARCHAR(50),
    CLASS_CODE           VARCHAR(50),
    CLASS_DISPLAY        VARCHAR(50),
    CLASS_START          TIMESTAMP(6),
    CLASS_END            TIMESTAMP(6),
    CREATED              TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_CLASS_HISTORY (ENCOUNTER_HISTORY_ID, ENCOUNTER_ID, CLASS_SYSTEM, CLASS_CODE, CLASS_DISPLAY, CLASS_START, CLASS_END, CREATED) VALUES ('36d51017-2fba-468f-87ea-205d45637a39', '68e8e442-563f-48cd-8845-d39e31cb4396', 'http://terminology.hl7.org/CodeSystem/v3-ActCode', 'EMER', 'emergency', '2017-02-01 07:15:00.000000', '2017-02-01 09:27:00.000000', '2021-10-17 17:10:02.000000');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_CLASS_HISTORY (ENCOUNTER_HISTORY_ID, ENCOUNTER_ID, CLASS_SYSTEM, CLASS_CODE, CLASS_DISPLAY, CLASS_START, CLASS_END, CREATED) VALUES ('7040823f-5fc6-47bc-98ab-6f655065d678', '68e8e442-563f-48cd-8845-d39e31cb4396', 'http://terminology.hl7.org/CodeSystem/v3-ActCode', 'IMP', 'inpatient encounter', '2017-02-01 09:27:00.000000', null, '2021-10-17 17:11:04.000000');

create table FHIR_ENCOUNTER_LOCATION
(
    ENCOUNTER_LOCATION_ID VARCHAR(50),
    ENCOUNTER_ID          VARCHAR(50),
    LOCATION_STATUS       VARCHAR(50),
    LOCATION_START        TIMESTAMP(6),
    LOCATION_END          TIMESTAMP(6),
    CREATED               TIMESTAMP(6),
    LOCATION_DISPLAY      VARCHAR(50)
);

INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_LOCATION (ENCOUNTER_LOCATION_ID, ENCOUNTER_ID, LOCATION_STATUS, LOCATION_START, LOCATION_END, CREATED, LOCATION_DISPLAY) VALUES ('4d028121-4675-479a-95ee-bb5a0bbd6221', '68e8e442-563f-48cd-8845-d39e31cb4396', 'active', '2017-02-01 07:15:00.000000', '2017-02-01 08:45:00.000000', '2021-10-17 17:15:54.000000', 'Emergency Waiting Room');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_LOCATION (ENCOUNTER_LOCATION_ID, ENCOUNTER_ID, LOCATION_STATUS, LOCATION_START, LOCATION_END, CREATED, LOCATION_DISPLAY) VALUES ('13b611cb-6460-4518-acfd-bf5c1bcae403', '68e8e442-563f-48cd-8845-d39e31cb4396', 'active', '2017-02-01 08:45:00.000000', '2017-02-01 09:27:00.000000', '2021-10-17 17:16:39.000000', 'Emergency');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_LOCATION (ENCOUNTER_LOCATION_ID, ENCOUNTER_ID, LOCATION_STATUS, LOCATION_START, LOCATION_END, CREATED, LOCATION_DISPLAY) VALUES ('831e9aa8-87ce-4743-acec-0e3826a7d3b3', '68e8e442-563f-48cd-8845-d39e31cb4396', 'active', '2017-02-01 09:27:00.000000', '2017-02-01 12:15:00.000000', '2021-10-17 17:17:24.000000', 'Ward 1, Room 42, Bed 1');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_LOCATION (ENCOUNTER_LOCATION_ID, ENCOUNTER_ID, LOCATION_STATUS, LOCATION_START, LOCATION_END, CREATED, LOCATION_DISPLAY) VALUES ('87f8cb23-b98e-40b1-b05a-0cbe9162d332', '68e8e442-563f-48cd-8845-d39e31cb4396', 'reserved', '2017-02-01 12:15:00.000000', '2017-02-01 12:45:00.000000', '2021-10-17 17:18:10.000000', 'Ward 1, Room 42, Bed 1');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_LOCATION (ENCOUNTER_LOCATION_ID, ENCOUNTER_ID, LOCATION_STATUS, LOCATION_START, LOCATION_END, CREATED, LOCATION_DISPLAY) VALUES ('f77ae2fc-34f0-4410-a88d-a7cdb534df47', '68e8e442-563f-48cd-8845-d39e31cb4396', 'active', '2017-02-01 12:45:00.000000', null, '2021-10-17 17:18:39.000000', 'Ward 1, Room 42, Bed 1');

create table FHIR_ENCOUNTER_STATUS_HISTORY
(
    STATUS_HISTORY_ID    VARCHAR(50),
    ENCOUNTER_ID         VARCHAR(50),
    STATUS_VALUE         VARCHAR(50),
    STATUS_HISTORY_START TIMESTAMP(6),
    STATUS_HISTORY_END   TIMESTAMP(6),
    CREATED              TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_STATUS_HISTORY (STATUS_HISTORY_ID, ENCOUNTER_ID, STATUS_VALUE, STATUS_HISTORY_START, STATUS_HISTORY_END, CREATED) VALUES ('b8bb84e0-8ba9-4fd6-aba4-0d55feabbff5', '68e8e442-563f-48cd-8845-d39e31cb4396', 'arrived', '2017-02-01 07:15:00.000000', '2017-02-01 07:35:00.000000', '2021-10-18 13:46:43.000000');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_STATUS_HISTORY (STATUS_HISTORY_ID, ENCOUNTER_ID, STATUS_VALUE, STATUS_HISTORY_START, STATUS_HISTORY_END, CREATED) VALUES ('1a84a65e-bcbe-45d9-ba79-b35c72a46d04', '68e8e442-563f-48cd-8845-d39e31cb4396', 'in-progress', '2017-02-01 12:45:00.000000', '2017-02-01 12:55:00.000000', '2021-10-18 13:50:17.000000');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_STATUS_HISTORY (STATUS_HISTORY_ID, ENCOUNTER_ID, STATUS_VALUE, STATUS_HISTORY_START, STATUS_HISTORY_END, CREATED) VALUES ('4d2798b8-d6c2-43b4-b43c-abb2a4ee2729', '68e8e442-563f-48cd-8845-d39e31cb4396', 'onleave', '2017-02-01 12:15:00.000000', '2017-02-01 12:45:00.000000', '2021-10-18 13:50:21.000000');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_STATUS_HISTORY (STATUS_HISTORY_ID, ENCOUNTER_ID, STATUS_VALUE, STATUS_HISTORY_START, STATUS_HISTORY_END, CREATED) VALUES ('aa21d2c8-2e09-43d0-b249-19a16432b7df', '68e8e442-563f-48cd-8845-d39e31cb4396', 'in-progress', '2017-02-01 08:45:00.000000', '2017-02-01 12:15:00.000000', '2021-10-18 13:50:23.000000');
INSERT INTO MYSCHEMA.FHIR_ENCOUNTER_STATUS_HISTORY (STATUS_HISTORY_ID, ENCOUNTER_ID, STATUS_VALUE, STATUS_HISTORY_START, STATUS_HISTORY_END, CREATED) VALUES ('966a7751-70cb-411b-9233-9341f4ee9ac3', '68e8e442-563f-48cd-8845-d39e31cb4396', 'triaged', '2017-02-01 07:35:00.000000', '2017-02-01 08:45:00.000000', '2021-10-18 13:50:24.000000');

create table FHIR_IMMUNIZATION
(
    IMMUNIZATION_ID            VARCHAR(50),
    IDENTIFIER_SYSTEM_1        VARCHAR(200),
    IDENTIFIER_VALUE_1         VARCHAR(200),
    IDENTIFIER_SYSTEM_2        VARCHAR(200),
    IDENTIFIER_VALUE_2         VARCHAR(200),
    IMMUNIZATION_STATUS        VARCHAR(50),
    VACCINECODE_SYSTEM         VARCHAR(200),
    VACCINECODE_CODE           VARCHAR(50),
    VACCINECODE_DISPLAY        VARCHAR(200),
    VACCINECODE_TEXT           VARCHAR(200),
    PATIENT_REFERENCE          VARCHAR(200),
    PATIENT_TYPE               VARCHAR(50),
    PATIENT_DISPLAY            VARCHAR(200),
    ENCOUNTER_REFERENCE        VARCHAR(200),
    OCCURRENCE_DATETIME        TIMESTAMP(6),
    PRIMARY_SOURCE             BOOLEAN,
    LOCATION_REFERENCE         VARCHAR(200),
    LOCATION_DISPLAY           VARCHAR(200),
    MANUFACTURER_REFERENCE     VARCHAR(200),
    MANUFACTURER_DISPLAY       VARCHAR(200),
    LOT_NUMBER                 VARCHAR(50),
    SITE_SYSTEM                VARCHAR(200),
    SITE_CODE                  VARCHAR(50),
    SITE_DISPLAY               VARCHAR(200),
    ROUTE_SYSTEM               VARCHAR(200),
    ROUTE_CODE                 VARCHAR(50),
    ROUTE_DISPLAY              VARCHAR(200),
    DOSE_QUANTITY_VALUE        INTEGER,
    DOSE_QUANTITY_SYSTEM       VARCHAR(200),
    DOSE_QUANTITY_CODE         VARCHAR(50),
    PERFORMER_FUNCTION_SYSTEM  VARCHAR(200),
    PERFORMER_FUNCTION_CODE    VARCHAR(50),
    PERFORMER_ACTOR_REFERENCE  VARCHAR(200),
    PERFORMER_ACTOR_TYPE       VARCHAR(50),
    PERFORMER_ACTOR_DISPLAY    VARCHAR(200),
    IS_SUBPOTENT               BOOLEAN,
    PROGRAM_ELIGIBILITY_SYSTEM VARCHAR(200),
    PROGRAM_ELIGIBILITY_CODE   VARCHAR(50),
    FUNDING_SOURCE_SYSTEM      VARCHAR(200),
    FUNDING_SOURCE_CODE        VARCHAR(50),
    PROTOCOL_APPLIED_SERIES    VARCHAR(200),
    PROTOCOL_APPLIED_SYSTEM    VARCHAR(200),
    PROTOCOL_APPLIED_CODE      VARCHAR(50),
    PROTOCOL_APPLIED_TEXT      VARCHAR(200),
    DOSE_NUMBER_POSITIVE_INT   INTEGER,
    CREATED                    TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_IMMUNIZATION (IMMUNIZATION_ID, IDENTIFIER_SYSTEM_1, IDENTIFIER_VALUE_1, IDENTIFIER_SYSTEM_2, IDENTIFIER_VALUE_2, IMMUNIZATION_STATUS, VACCINECODE_SYSTEM, VACCINECODE_CODE, VACCINECODE_DISPLAY, VACCINECODE_TEXT, PATIENT_REFERENCE, PATIENT_TYPE, PATIENT_DISPLAY, ENCOUNTER_REFERENCE, OCCURRENCE_DATETIME, PRIMARY_SOURCE, LOCATION_REFERENCE, LOCATION_DISPLAY, MANUFACTURER_REFERENCE, MANUFACTURER_DISPLAY, LOT_NUMBER, SITE_SYSTEM, SITE_CODE, SITE_DISPLAY, ROUTE_SYSTEM, ROUTE_CODE, ROUTE_DISPLAY, DOSE_QUANTITY_VALUE, DOSE_QUANTITY_SYSTEM, DOSE_QUANTITY_CODE, PERFORMER_FUNCTION_SYSTEM, PERFORMER_FUNCTION_CODE, PERFORMER_ACTOR_REFERENCE, PERFORMER_ACTOR_TYPE, PERFORMER_ACTOR_DISPLAY, IS_SUBPOTENT, PROGRAM_ELIGIBILITY_SYSTEM, PROGRAM_ELIGIBILITY_CODE, FUNDING_SOURCE_SYSTEM, FUNDING_SOURCE_CODE, PROTOCOL_APPLIED_SERIES, PROTOCOL_APPLIED_SYSTEM, PROTOCOL_APPLIED_CODE, PROTOCOL_APPLIED_TEXT, DOSE_NUMBER_POSITIVE_INT, CREATED) VALUES ('735864b3-515e-49fa-8185-508cdb9eadd8', 'https://tools.ietf.org/html/rfc4122', 'a9e514e2-64fc-495e-9a92-28c786807879', 'hasDoc', 'N', 'completed', 'http://snomed.info/sct', '39114911000001105', 'COVID-19 Vaccine AstraZeneca (ChAdOx1 S [recombinant]) 5x10,000,000,000 viral particles/0.5ml dose solution for injection multidose vials (AstraZeneca)', 'Oxford–AstraZeneca COVID-19 vaccine (AZD1222)', '/Patient?identifier=A123456789', 'Patient', '原嘉', 'Encounter/example', '2021-05-17 00:00:00.000000', true, 'Location/1', '中華民國／臺北榮總', 'Organization/hl7', 'ASTRA ZENECA', 'CTMAV513', 'http://terminology.hl7.org/CodeSystem/v3-ActSite', 'LA', 'left arm', 'http://terminology.hl7.org/CodeSystem/v3-RouteOfAdministration', 'IM', 'Injection, intramuscular', 5, 'http://unitsofmeasure.org', 'mg', 'http://terminology.hl7.org/CodeSystem/v2-0443', 'OP', 'Practitioner/1797901c830-3509916f-e15f-49f8-aeda-f74862c40187', 'Practitioner', '周惟誼 4101A', false, 'http://terminology.hl7.org/CodeSystem/immunization-funding-source', 'ineligible', 'http://terminology.hl7.org/CodeSystem/immunization-funding-source', 'private', '1-dose', 'http://snomed.info/sct', '40468003', 'COVID-19', 1, '2021-10-18 16:28:06.000000');
INSERT INTO MYSCHEMA.FHIR_IMMUNIZATION (IMMUNIZATION_ID, IDENTIFIER_SYSTEM_1, IDENTIFIER_VALUE_1, IDENTIFIER_SYSTEM_2, IDENTIFIER_VALUE_2, IMMUNIZATION_STATUS, VACCINECODE_SYSTEM, VACCINECODE_CODE, VACCINECODE_DISPLAY, VACCINECODE_TEXT, PATIENT_REFERENCE, PATIENT_TYPE, PATIENT_DISPLAY, ENCOUNTER_REFERENCE, OCCURRENCE_DATETIME, PRIMARY_SOURCE, LOCATION_REFERENCE, LOCATION_DISPLAY, MANUFACTURER_REFERENCE, MANUFACTURER_DISPLAY, LOT_NUMBER, SITE_SYSTEM, SITE_CODE, SITE_DISPLAY, ROUTE_SYSTEM, ROUTE_CODE, ROUTE_DISPLAY, DOSE_QUANTITY_VALUE, DOSE_QUANTITY_SYSTEM, DOSE_QUANTITY_CODE, PERFORMER_FUNCTION_SYSTEM, PERFORMER_FUNCTION_CODE, PERFORMER_ACTOR_REFERENCE, PERFORMER_ACTOR_TYPE, PERFORMER_ACTOR_DISPLAY, IS_SUBPOTENT, PROGRAM_ELIGIBILITY_SYSTEM, PROGRAM_ELIGIBILITY_CODE, FUNDING_SOURCE_SYSTEM, FUNDING_SOURCE_CODE, PROTOCOL_APPLIED_SERIES, PROTOCOL_APPLIED_SYSTEM, PROTOCOL_APPLIED_CODE, PROTOCOL_APPLIED_TEXT, DOSE_NUMBER_POSITIVE_INT, CREATED) VALUES ('e9d8dff9-22dd-48bb-99ba-dde2c11ff96d', 'http://hl7.org/fhir/StructureDefinition/data-absent-reason', 'unknown', 'http://hl7.org/fhir/StructureDefinition/data-absent-reason', 'unknown', 'completed', 'YvJT4T6NkW', '_EmcRZ1Dqv', 'wPqB24W8AT', '4unQHRC0ds', '/Patient?identifier=A123456789', 'Patient', '原嘉', 'Encounter/GRRHGZfJ-m', '2021-06-18 16:15:54.000000', true, 'Location/p9N7OyOowS', 'gLnIzrvSWe', 'Organization/cFINJF8qIj', '1CwgXVEUgA', 'R9QZSJazlM', 'A4BEFsI7z1', 'UWsEZZHdgT', 'vfyL_XLQHB', 'bUY4KEbxOB', 'hw84QXJIFh', 'sNLy8V6u6s', 568, '1hH_whmsPU', 'qdS98rZfWG', 'mlhH3Hr4sA', 'dDxHa6gQnq', 'Practitioner/c8ifKeNMHa', 'Practitioner', '9mB9gN3766', false, 'ivhV1dexaw', 'oOcH6UFSi2', 'dqmbiaMhxI', '3KoIojqJrj', 'wcehojycYL', 't_K7WZGXIi', 'hWTg_ZqH21', 'Q9376uZ8Md', 2, '2021-10-18 16:28:08.000000');

create table FHIR_MEDICATION
(
    MEDICATION_ID                   VARCHAR(50),
    IDENTIFIER_VALUE                VARCHAR(50),
    MEDICATION_CODE                 VARCHAR(50),
    MEDICATION_STATUS               VARCHAR(50),
    MEDICATION_ORG                  VARCHAR(200),
    MEDICATION_FORM                 VARCHAR(50),
    MEDICATION_AMOUNT               DOUBLE,
    MEDICATION_INGREDIENT_CODE      VARCHAR(50),
    MEDICATION_INGREDIENT_REFERENCE VARCHAR(200),
    MEDICATION_IS_ACTIVE            BOOLEAN,
    MEDICATION_STRENGTH             DOUBLE,
    BATCH_NUMBER                    VARCHAR(50),
    BATCH_DATE                      TIMESTAMP(6),
    CREATED                         TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_MEDICATION (MEDICATION_ID, IDENTIFIER_VALUE, MEDICATION_CODE, MEDICATION_STATUS, MEDICATION_ORG, MEDICATION_FORM, MEDICATION_AMOUNT, MEDICATION_INGREDIENT_CODE, MEDICATION_INGREDIENT_REFERENCE, MEDICATION_IS_ACTIVE, MEDICATION_STRENGTH, BATCH_NUMBER, BATCH_DATE, CREATED) VALUES ('3375cd88-ac97-4924-80ec-e52110850bd5', 'Panadol', 'panadol', 'active', 'Organization/17bb48fc5fc-17fae685-d483-4776-b5da-71d28099614e', 'capsule', 4000, 'Acetaminophen', 'Medication/testid', true, 50, '1', '2021-10-20 09:57:44.000000', '2021-10-20 09:57:47.000000');

create table FHIR_OBSERVATION
(
    OBS_ID              VARCHAR(50),
    OBS_STATUS          VARCHAR(50),
    OBS_SUBJECT_TYPE    VARCHAR(50),
    OBS_SUBJECT_ID      VARCHAR(50),
    OBS_EFFECTIVE_START TIMESTAMP(6),
    OBS_EFFECTIVE_END   TIMESTAMP(6),
    OBS_PERFORMER_TYPE  VARCHAR(50),
    OBS_PERFORMER_ID    VARCHAR(50),
    OBS_VALUE           VARCHAR(50),
    OBS_CREATED         TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_OBSERVATION (OBS_ID, OBS_STATUS, OBS_SUBJECT_TYPE, OBS_SUBJECT_ID, OBS_EFFECTIVE_START, OBS_EFFECTIVE_END, OBS_PERFORMER_TYPE, OBS_PERFORMER_ID, OBS_VALUE, OBS_CREATED) VALUES ('3d6b7828-469a-4985-90b4-38b4ade9cad9', 'final', 'Patient', '17baa20dade-a04cbe92-2250-4bc0-8fb8-1876367b3c65', '2021-07-01 10:30:10.000000', '2021-07-08 10:30:10.000000', 'Organization', '17ba99eed9d-c5f9ef7c-076b-4c23-a378-5604361bb0f7', 'Negative', '2021-10-13 10:48:14.893000');

create table FHIR_ORGANIZATION
(
    ORG_ID      VARCHAR(200) not null
        primary key,
    ORG_NAME    VARCHAR(500),
    ORG_NAME_EN VARCHAR(500),
    ORG_CREATED TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_ORGANIZATION (ORG_ID, ORG_NAME, ORG_NAME_EN, ORG_CREATED) VALUES ('8e630b09-88db-4cfe-8005-9303db0d95e6', '臺北榮民總醫院', 'Taipei Veterans General Hospital', '2021-10-01 16:52:59.400000');
INSERT INTO MYSCHEMA.FHIR_ORGANIZATION (ORG_ID, ORG_NAME, ORG_NAME_EN, ORG_CREATED) VALUES ('2e3d28b9-a09e-4018-901c-1339152e9420', '國立臺灣大學醫學院附設醫院', 'National Taiwan University Hospital', '2021-10-01 16:53:02.362000');

create table FHIR_ORGANIZATION_NAME
(
    ON_ID      VARCHAR(50) not null
        primary key,
    ORG_ID     VARCHAR(50),
    ON_TYPE    VARCHAR(100),
    ON_DISPLAY VARCHAR(100),
    ON_CREATED TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_ORGANIZATION_NAME (ON_ID, ORG_ID, ON_TYPE, ON_DISPLAY, ON_CREATED) VALUES ('6f907785-cd9e-4f8d-93f7-0f6ba5ceb3ec', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'fullname', '臺北榮民總醫院 (VGHTPE)', '2021-10-01 17:12:22.480000');
INSERT INTO MYSCHEMA.FHIR_ORGANIZATION_NAME (ON_ID, ORG_ID, ON_TYPE, ON_DISPLAY, ON_CREATED) VALUES ('51cd8503-4154-47ac-a651-8afb8549e46c', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'alias', '臺北榮總', '2021-10-01 17:12:28.588000');
INSERT INTO MYSCHEMA.FHIR_ORGANIZATION_NAME (ON_ID, ORG_ID, ON_TYPE, ON_DISPLAY, ON_CREATED) VALUES ('b0914e66-a8f9-4d86-9533-2ac3e2b0f6c0', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'alias', '北榮', '2021-10-01 17:12:32.453000');
INSERT INTO MYSCHEMA.FHIR_ORGANIZATION_NAME (ON_ID, ORG_ID, ON_TYPE, ON_DISPLAY, ON_CREATED) VALUES ('ac8d01cb-22be-4017-abad-73a17fd1353b', '2e3d28b9-a09e-4018-901c-1339152e9420', 'fullname', '國立臺灣大學醫學院附設醫院(NTUH)', '2021-10-01 17:12:35.329000');
INSERT INTO MYSCHEMA.FHIR_ORGANIZATION_NAME (ON_ID, ORG_ID, ON_TYPE, ON_DISPLAY, ON_CREATED) VALUES ('11e5665c-2fe5-4176-92a8-5e56d81bc847', '2e3d28b9-a09e-4018-901c-1339152e9420', 'alias', '臺大醫院', '2021-10-01 17:12:39.610000');

create table FHIR_PRACTITIONER
(
    PRACTITIONER_ID                 VARCHAR(50),
    IDENTIFIER_USE1                 VARCHAR(200),
    IDENTIFIER_SYSTEM1              VARCHAR(200),
    IDENTIFIER_VALUE1               VARCHAR(200),
    IDENTIFIER_USE2                 VARCHAR(200),
    IDENTIFIER_SYSTEM2              VARCHAR(200),
    IDENTIFIER_VALUE2               VARCHAR(200),
    PRACTITIONER_ACTIVE             BOOLEAN,
    NAME_USE                        VARCHAR(200),
    NAME_FAMILY                     VARCHAR(200),
    NAME_GIVEN                      VARCHAR(200),
    NAME_SUFFIX                     VARCHAR(200),
    TELECOM_SYSTEM1                 VARCHAR(200),
    TELECOM_VALUE1                  VARCHAR(200),
    TELECOM_USE1                    VARCHAR(200),
    TELECOM_SYSTEM2                 VARCHAR(200),
    TELECOM_VALUE2                  VARCHAR(200),
    TELECOM_USE2                    VARCHAR(200),
    TELECOM_SYSTEM3                 VARCHAR(200),
    TELECOM_VALUE3                  VARCHAR(200),
    TELECOM_USE3                    VARCHAR(200),
    ADDRESS_USE                     VARCHAR(200),
    ADDRESS_LINE                    VARCHAR(200),
    ADDRESS_CITY                    VARCHAR(200),
    ADDRESS_POSTAL_CODE             VARCHAR(200),
    ADDRESS_COUNTRY                 VARCHAR(200),
    GENDER                          VARCHAR(50),
    BIRTHDATE                       TIMESTAMP(6),
    QUALIFICATION_IDENTIFIER_SYSTEM VARCHAR(200),
    QUALIFICATION_IDENTIFIER_VALUE  VARCHAR(200),
    QUALIFICATION_CODING_SYSTEM     VARCHAR(200),
    QUALIFICATION_CODING_CODE       VARCHAR(200),
    QUALIFICATION_TEXT              VARCHAR(200),
    QUALIFICATION_PERIOD_START      TIMESTAMP(6),
    QUALIFICATION_PERIOD_END        TIMESTAMP(6),
    QUALIFICATION_ISSUER_DISPLAY    VARCHAR(200),
    COMMUNICATION_SYSTEM            VARCHAR(200),
    COMMUNICATION_CODE              VARCHAR(200),
    COMMUNICATION_DISPLAY           VARCHAR(200),
    CREATED                         TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_PRACTITIONER (PRACTITIONER_ID, IDENTIFIER_USE1, IDENTIFIER_SYSTEM1, IDENTIFIER_VALUE1, IDENTIFIER_USE2, IDENTIFIER_SYSTEM2, IDENTIFIER_VALUE2, PRACTITIONER_ACTIVE, NAME_USE, NAME_FAMILY, NAME_GIVEN, NAME_SUFFIX, TELECOM_SYSTEM1, TELECOM_VALUE1, TELECOM_USE1, TELECOM_SYSTEM2, TELECOM_VALUE2, TELECOM_USE2, TELECOM_SYSTEM3, TELECOM_VALUE3, TELECOM_USE3, ADDRESS_USE, ADDRESS_LINE, ADDRESS_CITY, ADDRESS_POSTAL_CODE, ADDRESS_COUNTRY, GENDER, BIRTHDATE, QUALIFICATION_IDENTIFIER_SYSTEM, QUALIFICATION_IDENTIFIER_VALUE, QUALIFICATION_CODING_SYSTEM, QUALIFICATION_CODING_CODE, QUALIFICATION_TEXT, QUALIFICATION_PERIOD_START, QUALIFICATION_PERIOD_END, QUALIFICATION_ISSUER_DISPLAY, COMMUNICATION_SYSTEM, COMMUNICATION_CODE, COMMUNICATION_DISPLAY, CREATED) VALUES ('70741d60-2be1-4b23-b927-a3d4a2a49be5', 'official', 'urn:oid:2.16.528.1.1007.3.1', '938273695', 'usual', 'urn:oid:2.16.840.1.113883.2.4.6.3', '129IDH4OP733', true, 'official', '周惟誼', '原嘉', 'MD', 'phone', '0205568263', 'work', 'email', 'E.M.vandenbroek@bmc.nl', 'work', 'fax', '0205664440', 'work', 'work', 'Galapagosweg 91', 'Den Burg', '9105 PZ', 'NL', 'male', '1975-12-07 00:00:00.000000', 'http://example.org/UniversityIdentifier', '12345', 'http://terminology.hl7.org/CodeSystem/v2-0360', 'MD', 'MD', '2021-10-18 21:36:39.000000', null, 'State of Illinois', 'urn:ietf:bcp:47', 'fr', 'France', '2021-10-18 21:37:10.000000');

create table FHIR_SYSTEMS
(
    SYSTEM_ID      VARCHAR(50),
    SYSTEM_URL     VARCHAR(50),
    SYSTEM_CODE    VARCHAR(50),
    SYSTEM_DISPLAY VARCHAR(500),
    SYSTEM_CREATED TIMESTAMP(6),
    SYSTEM_REF_ID  VARCHAR(50)
);

INSERT INTO MYSCHEMA.FHIR_SYSTEMS (SYSTEM_ID, SYSTEM_URL, SYSTEM_CODE, SYSTEM_DISPLAY, SYSTEM_CREATED, SYSTEM_REF_ID) VALUES ('eb8fae78-a3cc-4b7b-bfa8-256415e941a7', 'http://loinc.org', 'LP6464-4', 'Nucleic acid amplification with probe detection', '2021-10-13 10:50:11.000000', '3d6b7828-469a-4985-90b4-38b4ade9cad9');
INSERT INTO MYSCHEMA.FHIR_SYSTEMS (SYSTEM_ID, SYSTEM_URL, SYSTEM_CODE, SYSTEM_DISPLAY, SYSTEM_CREATED, SYSTEM_REF_ID) VALUES ('32f246c7-1eb4-4a06-9720-5c983863e6da', 'https://www.nhi.gov.tw', 'PCR-COVID19', 'SARS-CoV-2', '2021-10-13 10:52:11.294000', '3d6b7828-469a-4985-90b4-38b4ade9cad9');

create table FHIR_TELCOM
(
    T_ID         VARCHAR(50) not null
        primary key,
    T_SOURCE     VARCHAR(50),
    T_ORG_ID     VARCHAR(50),
    T_CONTACT_ID VARCHAR(50),
    T_TYPE       VARCHAR(100),
    T_VALUE      VARCHAR(100),
    T_PURPOSE    VARCHAR(100),
    HP_CREATED   TIMESTAMP(6)
);

INSERT INTO MYSCHEMA.FHIR_TELCOM (T_ID, T_SOURCE, T_ORG_ID, T_CONTACT_ID, T_TYPE, T_VALUE, T_PURPOSE, HP_CREATED) VALUES ('f2696a05-ac54-430c-980c-d8ab06f0286e', 'ortanization', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'f0bff7ee-d568-4854-ab1e-0d55f9b08daf', 'phone', '+886-2-28712121', 'work', '2021-10-01 17:12:43.063000');
INSERT INTO MYSCHEMA.FHIR_TELCOM (T_ID, T_SOURCE, T_ORG_ID, T_CONTACT_ID, T_TYPE, T_VALUE, T_PURPOSE, HP_CREATED) VALUES ('88937a83-7ddb-45ec-909d-68a3d32f0b14', 'ortanization', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'f0bff7ee-d568-4854-ab1e-0d55f9b08daf', 'fax', '+886-2-28732131', 'work', '2021-10-01 17:12:47.080000');
INSERT INTO MYSCHEMA.FHIR_TELCOM (T_ID, T_SOURCE, T_ORG_ID, T_CONTACT_ID, T_TYPE, T_VALUE, T_PURPOSE, HP_CREATED) VALUES ('b5037af9-28f5-4b33-89df-4292cab279ca', 'ortanization', '8e630b09-88db-4cfe-8005-9303db0d95e6', 'f0bff7ee-d568-4854-ab1e-0d55f9b08daf', 'email', 'imsc@vghtpe.gov.tw', 'work', '2021-10-01 17:12:51.354000');
INSERT INTO MYSCHEMA.FHIR_TELCOM (T_ID, T_SOURCE, T_ORG_ID, T_CONTACT_ID, T_TYPE, T_VALUE, T_PURPOSE, HP_CREATED) VALUES ('6792542d-9d32-43e1-b888-5353e4c88c45', 'ortanization', '2e3d28b9-a09e-4018-901c-1339152e9420', '4b15400d-9ba2-4704-87af-29f8bcc312c2', 'phone', '+886-2-23123456', 'work', '2021-10-01 17:12:55.681000');
INSERT INTO MYSCHEMA.FHIR_TELCOM (T_ID, T_SOURCE, T_ORG_ID, T_CONTACT_ID, T_TYPE, T_VALUE, T_PURPOSE, HP_CREATED) VALUES ('54d8714d-4c74-44ac-b790-8bde13a54bd0', 'ortanization', '2e3d28b9-a09e-4018-901c-1339152e9420', '4b15400d-9ba2-4704-87af-29f8bcc312c2', 'email', 'test@ntuh.gov.tw', 'work', '2021-10-01 17:12:59.405000');

create table PBASINFO
(
    PHISTNUM DOUBLE,
    PIDNO    VARCHAR(10),
    PRKNO    INTEGER,
    PNAMEC   VARCHAR(500),
    PNAME    VARCHAR(500),
    PSEX     INTEGER,
    PBIRTHDT INTEGER,
    PETHGRP  VARCHAR(500),
    PRESDNCE VARCHAR(500),
    PRELIGIN VARCHAR(500),
    PVETERAN VARCHAR(500),
    PADDR1   VARCHAR(500),
    PPATZIP  INTEGER,
    PPHONNO1 VARCHAR(500),
    PPATCAGY INTEGER,
    PFSTVDT  INTEGER,
    PFSTMED  VARCHAR(500),
    PLSTVDT  INTEGER,
    PLSTMED  VARCHAR(500),
    PACCVOL  INTEGER,
    PMEDSTAT INTEGER,
    PCNTCARD VARCHAR(500),
    PBFIN1   VARCHAR(500),
    PBFIN2   VARCHAR(500),
    PICD91   VARCHAR(500),
    PICD92   VARCHAR(500),
    PICD93   VARCHAR(500),
    POR1     VARCHAR(500),
    POR2     VARCHAR(500),
    PMEDCAGY VARCHAR(500),
    PFIRE    VARCHAR(500),
    PMODFYDT INTEGER,
    POPERID  VARCHAR(500),
    PPBLOOD  VARCHAR(500),
    PPAIDS   VARCHAR(500),
    PPINF1   VARCHAR(500),
    PPINF2   VARCHAR(500),
    PPINF3   VARCHAR(500),
    PADDR2   VARCHAR(500),
    PPHONNO2 VARCHAR(500),
    PPATSTAT VARCHAR(500),
    PDEADFLG VARCHAR(500),
    PAPPEND  VARCHAR(500)
);

INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (32723016, 'A120673957', 1667947, '孫樹義', 'SUN SHUH YIH', 1, 19600809, 'M', '81', '    ', ' ', '臺北市北投區行義路１２４巷６號５樓', 112, '0918653775', 6, 20040505, '63  ', 20201229, '44  ', 1, 0, '0', '    ', '    ', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20170125, 'HIST2134', 'B +', ' ', ' ', ' ', ' ', '北投區行義路１２４巷６號５樓', '0939007002', ' ', ' ', '　　　　　　　　　　　　　　');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (42777388, 'J120455108', 2553753, '孫議德', 'SUN YI DE', 1, 19740118, 'U', '35', '    ', ' ', '新北市淡水區中正東路一段８３－１號７樓', 251, '26291957', 6, 20151216, '91  ', 20191007, '91  ', 1, 0, '0', '5099', '6000', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20180607, 'HIST6696', '   ', ' ', ' ', ' ', ' ', '新北市淡水區中正東路一段８３－１號７樓', '26291957', ' ', ' ', '　　　　　　　　　　　　　　');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (26260117, 'D121303733', 894576, '錢政平', 'CHIARN JEHN BEENG', 1, 19750312, ' ', '  ', '    ', ' ', '高雄巿南台路２０１巷１９號', 800, '07-2155915', 8, 19960906, 'A3  ', 20200928, 'T5  ', 1, 6, '0', '    ', '    ', '       ', '       ', '       ', '     ', '     ', ' ', '20200518', 19960907, 'DR      ', '   ', ' ', ' ', ' ', ' ', '高雄巿南台路２０１巷１９號', '07-2155915', ' ', ' ', '　　　　　　　　　　　　　　');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (37172659, 'A128042669', 2080986, '林德銘', 'LIN DE MING', 1, 19850925, ' ', '02', '    ', ' ', '臺北市內湖區文湖街２１巷１１０號３樓', 114, '27986956', 10, 20091211, '58  ', 20200624, '90  ', 1, 0, '0', '5099', '6000', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20180828, 'HIST2134', '   ', ' ', ' ', ' ', ' ', '內湖區文湖街２１巷１１０號３樓', '8#4601', ' ', ' ', '　　　　　　　　　　　　　　');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (46614088, 'B222945539', 2925091, '林欣郁', 'LIN XIN YU', 2, 19921021, ' ', '81', '    ', ' ', '台中市南屯區惠得街１２號', 408, '27986655', 6, 20201104, '91  ', 20201104, '91  ', 1, 0, ' ', '5099', '6000', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20201104, 'OPD151Q ', '   ', ' ', ' ', ' ', ' ', '台中市南屯區惠得街１２號', '', ' ', ' ', '                              ');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (37428185, 'C101101349', 2246578, '曹啟華', 'CAO QI HUA', 1, 19600416, ' ', '81', '    ', ' ', '北投區西安街一段３６９號２樓', 112, '28273648', 6, 20100510, '81  ', 20141111, '10  ', 1, 0, ' ', '5099', '6000', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20100510, 'OPD36Q  ', '   ', ' ', ' ', ' ', ' ', '北投區西安街一段３６９號２樓', '28273648', ' ', ' ', '                              ');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (27961699, 'A223893837', 1085336, '鄭之雅', 'CHENG JY YAA', 2, 19741231, ' ', '81', '    ', ' ', '臺北市中山區民生東路一段１巷８號１樓', 104, '25715965', 10, 19981121, '55  ', 20210106, '77  ', 1, 0, '0', '    ', '    ', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20170610, 'HIST2134', '   ', ' ', ' ', ' ', ' ', '台北巿光復南路５７巷２３號２樓', '', ' ', ' ', '兒童醫學部契約醫事技術師');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (7108307, 'M220980879', 564724, '廖彩言', 'LIAO TSAI YEN', 2, 19631115, ' ', '01', '    ', ' ', '北投區石牌路２段３１５巷２８弄２之２號２樓', 112, '8746471', 6, 19780513, '01  ', 20160721, '03  ', 1, 6, '0', '    ', '    ', '       ', '       ', '       ', '     ', '     ', ' ', '20160803', 20071018, 'ISC9950 ', '   ', ' ', ' ', ' ', ' ', '中寮龍安村', '', ' ', ' ', '　　　　　　　　　　　　　　');
INSERT INTO MYSCHEMA.PBASINFO (PHISTNUM, PIDNO, PRKNO, PNAMEC, PNAME, PSEX, PBIRTHDT, PETHGRP, PRESDNCE, PRELIGIN, PVETERAN, PADDR1, PPATZIP, PPHONNO1, PPATCAGY, PFSTVDT, PFSTMED, PLSTVDT, PLSTMED, PACCVOL, PMEDSTAT, PCNTCARD, PBFIN1, PBFIN2, PICD91, PICD92, PICD93, POR1, POR2, PMEDCAGY, PFIRE, PMODFYDT, POPERID, PPBLOOD, PPAIDS, PPINF1, PPINF2, PPINF3, PADDR2, PPHONNO2, PPATSTAT, PDEADFLG, PAPPEND) VALUES (20435181, 'Q220259194', 330142, '杜昭理', 'DUH JAU LII', 2, 19600705, 'M', '81', '    ', ' ', '臺北市北投區石牌路二段３１０號７樓', 112, '28212506', 12, 19891105, '95  ', 20210104, '10  ', 1, 0, '0', '    ', '    ', '       ', '       ', '       ', '     ', '     ', ' ', '        ', 20090924, 'OPD3720 ', 'B +', ' ', ' ', ' ', ' ', '臺北市北投區石牌路二段３１０號７樓', '28212506', ' ', ' ', '夫陳育民胸腔部醫師');



