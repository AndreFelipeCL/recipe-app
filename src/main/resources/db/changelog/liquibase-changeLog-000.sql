--liquibase formatted sql


--changeset AndreFelipeCL92:000.01:
CREATE SEQUENCE CATEGORY_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 5;
CREATE TABLE CATEGORY
(
    ID            NUMERIC(19, 0) NOT NULL,
    CATEGORY_NAME VARCHAR(255),
    PRIMARY KEY (ID)
);
--rollback DROP TABLE CATEGORY;
--rollback DROP SEQUENCE CATEGORY_ID_SEQ;


--changeset AndreFelipeCL92:000.02:
CREATE SEQUENCE INGREDIENT_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 5;
CREATE TABLE INGREDIENT
(
    ID                 NUMERIC(19, 0) NOT NULL,
    AMOUNT             NUMERIC(19, 2),
    DESCRIPTION        VARCHAR(255),
    RECIPE_ID          NUMERIC(19, 0),
    UNIT_OF_MEASURE_ID NUMERIC(19, 0),
    PRIMARY KEY (ID)
);
--rollback DROP TABLE INGREDIENT;
--rollback DROP SEQUENCE INGREDIENT_ID_SEQ;


--changeset AndreFelipeCL92:000.03:
CREATE SEQUENCE NOTES_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 5;
CREATE TABLE NOTES
(
    ID           NUMERIC(19, 0) NOT NULL,
    RECIPE_NOTES TEXT,
    RECIPE_ID    NUMERIC(19, 0),
    PRIMARY KEY (ID)
);
--rollback DROP TABLE NOTES;
--rollback DROP SEQUENCE NOTES_ID_SEQ;


--changeset AndreFelipeCL92:000.04:
CREATE SEQUENCE RECIPE_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 5;
CREATE TABLE RECIPE
(
    ID               NUMERIC(19, 0) NOT NULL,
    COOK_TIME        NUMERIC(19, 0),
    DESCRIPTION      VARCHAR(255),
    DIFFICULTY       VARCHAR(25),
    DIRECTIONS       VARCHAR(255),
    IMAGE            OID,
    PREPARATION_TIME NUMERIC(19, 0),
    SERVING          NUMERIC(19, 0),
    SOURCE           VARCHAR(255),
    URL              VARCHAR(255),
    NOTES_ID         NUMERIC(19, 0),
    PRIMARY KEY (ID)
);
--rollback DROP TABLE RECIPE;
--rollback DROP SEQUENCE RECIPE_ID_SEQ;


--changeset AndreFelipeCL92:000.05:
CREATE TABLE RECIPE_CATEGORY
(
    RECIPE_ID   NUMERIC(19, 0) NOT NULL,
    CATEGORY_ID NUMERIC(19, 0) NOT NULL,
    PRIMARY KEY (RECIPE_ID, CATEGORY_ID)
);
--rollback DROP TABLE RECIPE_CATEGORY;


--changeset AndreFelipeCL92:000.06:
CREATE SEQUENCE UNIT_OF_MEASURE_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 5;
CREATE TABLE UNIT_OF_MEASURE
(
    ID          NUMERIC(19, 0) NOT NULL,
    DESCRIPTION VARCHAR(255),
    PRIMARY KEY (ID)
);
--rollback DROP TABLE UNIT_OF_MEASURE;
--rollback DROP SEQUENCE UNIT_OF_MEASURE_ID_SEQ;


--changeset AndreFelipeCL92:000.07:
ALTER TABLE NOTES ADD CONSTRAINT FK_RECIPE_ID FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE;
ALTER TABLE RECIPE ADD CONSTRAINT FK_NOTES_ID FOREIGN KEY (NOTES_ID) REFERENCES NOTES;
ALTER TABLE INGREDIENT ADD CONSTRAINT FK_RECIPE_ID FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE;
ALTER TABLE INGREDIENT ADD CONSTRAINT FK_UNIT_OF_MEASURE_ID FOREIGN KEY (UNIT_OF_MEASURE_ID) REFERENCES UNIT_OF_MEASURE;
ALTER TABLE RECIPE_CATEGORY ADD CONSTRAINT FK_RECIPE_ID FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE;
ALTER TABLE RECIPE_CATEGORY ADD CONSTRAINT FK_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY;
--rollback ALTER TABLE NOTES DROP CONSTRAINT FK_RECIPE_ID;
--rollback ALTER TABLE RECIPE DROP CONSTRAINT FK_NOTES_ID;
--rollback ALTER TABLE INGREDIENT DROP CONSTRAINT FK_RECIPE_ID;
--rollback ALTER TABLE INGREDIENT DROP CONSTRAINT FK_UNIT_OF_MEASURE_ID;
--rollback ALTER TABLE RECIPE_CATEGORY DROP CONSTRAINT FK_RECIPE_ID;
--rollback ALTER TABLE RECIPE_CATEGORY DROP CONSTRAINT FK_CATEGORY_ID;
