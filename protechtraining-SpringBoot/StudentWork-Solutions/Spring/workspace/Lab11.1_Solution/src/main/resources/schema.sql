CREATE TABLE MusicItem
(
   id     	BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   Title       VARCHAR(40),
   Artist      VARCHAR(40),
   ReleaseDate DATE,
   Price       DECIMAL(5,2),
   Version     INTEGER,
   MusicCategory VARCHAR(40),
   CONSTRAINT  PK_MusicItem  PRIMARY KEY(id)
);

CREATE TABLE MusicItem_BandMembers
(
   MusicItemId     BIGINT NOT NULL,
   Member      VARCHAR(40) NOT NULL,
   CONSTRAINT  PK_MusicItemBandMembers  PRIMARY KEY(MusicItemId, Member),
   CONSTRAINT  FK_BM_to_MusicItem    FOREIGN KEY(MusicItemId) REFERENCES MusicItem(id)
);

CREATE TABLE DownloadableMusicItem
(
   MusicItemId     BIGINT NOT NULL,
   Url         VARCHAR(120) NOT NULL,
   FileType   VARCHAR(40) NOT NULL,
   CONSTRAINT  PK_Downloadable  PRIMARY KEY(MusicItemId),
   CONSTRAINT  FK_DI_to_MusicItem    FOREIGN KEY(MusicItemId) REFERENCES MusicItem(id)
);


CREATE TABLE Inventory
(
   InvId      BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   MusicItemId     BIGINT NOT NULL,
   Location    VARCHAR(25) NOT NULL,
   Quantity    INTEGER       NOT NULL,
   Version     INTEGER,
   CONSTRAINT  PK_Inventory  PRIMARY KEY(InvId),
   CONSTRAINT  ID_Location   UNIQUE(MusicItemId, Location),
   CONSTRAINT  FK_IV_to_MusicItem    FOREIGN KEY(MusicItemId) REFERENCES MusicItem(id)
);

CREATE TABLE PurchaseOrder
(
   PoId       BIGINT            NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   Status      INTEGER           NOT NULL,
   OrderDate   DATE              NOT NULL,
   UserId      CHAR(8)           NOT NULL,
   CONSTRAINT  PK_PurchaseOrder  PRIMARY KEY(PoId)
);

CREATE TABLE PurchaseMusicItem
(
   PoId             BIGINT               NOT NULL,
   Lineidber       INTEGER              NOT NULL,
   MusicItemID           VARCHAR(10)          NOT NULL,
   Quantity         INTEGER              NOT NULL,
   UnitPrice        DECIMAL(5,2)         NOT NULL,
   CONSTRAINT       PK_PurchaseMusicItem      PRIMARY KEY(PoId, Lineidber),
   CONSTRAINT       FK_to_PO  FOREIGN KEY(PoId) REFERENCES PurchaseOrder(PoId)
);
