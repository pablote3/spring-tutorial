CREATE TABLE Item
(
   id             BIGINT         NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   dtype          VARCHAR(50),
   title          VARCHAR(40),
   artist         VARCHAR(40),
   releaseDate    DATE,
   cost           DECIMAL(5,2),
   version        INTEGER,
   musicCategory  VARCHAR(40),
   CONSTRAINT     PK_Item  PRIMARY KEY(id)
);

CREATE TABLE Item_BandMember
(
   itemId          BIGINT        NOT NULL,
   member          VARCHAR(80)   NOT NULL,
   CONSTRAINT      PK_Item_BandMember   PRIMARY KEY(itemId, member),
   CONSTRAINT      FK_MIBM_to_Item      FOREIGN KEY(itemId) REFERENCES Item(id)
);

CREATE TABLE DownloadableItem
(
   itemId        BIGINT        NOT NULL,
   url           VARCHAR(120),
   fileType      VARCHAR(40),
   CONSTRAINT    PK_DownloadableItem  PRIMARY KEY(itemId),
   CONSTRAINT    FK_DMI_to_Item       FOREIGN KEY(itemId) REFERENCES Item(id)
);


CREATE TABLE Inventory
(
   id              BIGINT       NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   itemId          BIGINT       NOT NULL,
   location        VARCHAR(25)  NOT NULL,
   quantity        INTEGER      NOT NULL,
   version         INTEGER,
   CONSTRAINT      PK_Inventory                 PRIMARY KEY(id),
   CONSTRAINT      UQ_itemId_location      UNIQUE(itemId, location),
   CONSTRAINT      FK_IV_to_Item           FOREIGN KEY(itemId) REFERENCES Item(id)
);

CREATE TABLE PurchaseOrder
(
   id          BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   Status      INTEGER     NOT NULL,
   OrderDate   DATE        NOT NULL,
   UserId      CHAR(80)    NOT NULL,
   CONSTRAINT  PK_PurchaseOrder  PRIMARY KEY(id)
);

CREATE TABLE PurchaseOrder_LineItem
(
   purchaseOrderId    BIGINT               NOT NULL,
   lineNumber         INTEGER              NOT NULL,
   itemId             INTEGER              NOT NULL,
   quantity           INTEGER              NOT NULL,
   unitPrice          DECIMAL(5,2)         NOT NULL,
   CONSTRAINT         PK_PurchaseOrder_LineItem           PRIMARY KEY(purchaseOrderId, lineNumber),
   CONSTRAINT         FK_POLI_to_PurchaseOrder            FOREIGN KEY(purchaseOrderId) REFERENCES PurchaseOrder(id)
);


/* 
Here are our naming conventions 

    Table Names: CamelCase
        Start with cap, because then they map directly to Java class names. 
        We're using these a lot in Java labs, so might as well be consistent with those conventions.
        Singluar.
    Column Names: camelCase
        Start with lowercase letter - again to be consistent with Java classes. 
        Also differentiates between table and column names.
    Table primary key id column: Always called "id"
        e.g. in Item table -
            CREATE TABLE Item (id           BIGINT     ... )
    Master-Detail detail table names: MasterTable_DetailName
    	e.g. BandMember detail table for Item is now Item_BandMember
    Foreign key columns: camelCase of form otherTableId
        e.g. in Inventory table, which has a foreign key column to Item
            itemId     BIGINT       NOT NULL,
    Primary Key Constraint declaration: PK_TableName
        e.g. for Item
            CONSTRAINT    PK_Item  PRIMARY KEY(id)
    Foreign Key Constraint declaration: FK_ThisTableAbbreviated_OtherTable
        e.g. for Inventory foreign key to Item
            CONSTRAINT      FK_IV_to_Item  FOREIGN KEY(itemId) REFERENCES Item(id)
    Other constraints: As needed.
        e.g. Unique constraint on in Inventory on ItemId and location
               CONSTRAINT      UNQ_itemId_location     UNIQUE(itemId, location),
*/
