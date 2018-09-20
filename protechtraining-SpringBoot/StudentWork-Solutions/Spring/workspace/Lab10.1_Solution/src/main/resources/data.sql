INSERT INTO Item VALUES (DEFAULT, 'DownloadableItem', 'Diva', 'Annie Lennox', '1992-01-04', 17.97, 1,'POP');
INSERT INTO Item VALUES (DEFAULT, 'Item','Dream of the Blue Turtles', 'Sting', '1985-02-05', 14.99,1, 'POP');
INSERT INTO Item VALUES (DEFAULT, 'Item','Trouble is...', 'Kenny Wayne Shepherd Band', '1997-08-08', 14.99,1, 'BLUES');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Lie to Me', 'Jonny Lang', '1997-08-26', 17.97,1, 'BLUES');
INSERT INTO Item VALUES (DEFAULT, 'DownloadableItem', 'Little Earthquakes', 'Tori Amos', '1992-01-18', 14.99,1, 'ALTERNATIVE');
INSERT INTO Item VALUES (DEFAULT, 'Item','Seal', 'Seal', '1991-08-18', 17.97,1, 'POP');
INSERT INTO Item VALUES (DEFAULT, 'Item','Ian Moore', 'Ian Moore', '1993-12-05', 9.97,1, 'CLASSICAL');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'So Much for the Afterglow', 'Everclear', '1997-01-19', 13.99,1, 'ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Surfacing', 'Sarah McLachlan', '1997-12-04', 17.97, 1, 'ALTERNATIVE');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Hysteria', 'Def Leppard', '1987-06-20', 17.97, 1, 'ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'A Life of Saturdays', 'Dexter Freebish', '2000-12-06', 12.99,1, 'RAP');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Human Clay', 'Creed', '1999-10-21', 18.97, 1, 'ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'My, I''m Large', 'Bobs', '1987-02-20',  11.97,1, 'COUNTRY');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'So', 'Peter Gabriel', '1986-10-03', 13.99,1, 'POP');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Big Ones', 'Aerosmith', '1994-05-08', 14.99,1, 'ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', '90125', 'Yes', '1983-10-16', 11.97, 1, 'ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', '1984', 'Van Halen', '1984-08-19', 11.97,1, 'ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Escape', 'Journey', '1981-02-25', 11.97,1, 'CLASSIC_ROCK');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Greatest Hits', 'Jay and the Americans', '1966-12-05', 9.97,1, 'POP');
INSERT INTO Item VALUES (DEFAULT, 'Item', 'Ray of Light', 'Madonna', '2000-12-15', 10.97,1, 'POP');

INSERT INTO Item_BandMember VALUES (1, 'Annie Lennox');
INSERT INTO Item_BandMember VALUES (2, 'Sting');
INSERT INTO Item_BandMember VALUES (3, 'Kenny Wayne Shepherd');
INSERT INTO Item_BandMember VALUES (3, 'Jimmy Wallace');
INSERT INTO Item_BandMember VALUES (3, 'Shaun Hague');
INSERT INTO Item_BandMember VALUES (3, 'Michael Devin');
INSERT INTO Item_BandMember VALUES (3, 'Bogie Bowles');
INSERT INTO Item_BandMember VALUES (4, 'Jonny Lang');
INSERT INTO Item_BandMember VALUES (5, 'Tori Amos');
INSERT INTO Item_BandMember VALUES (6, 'Seal');
INSERT INTO Item_BandMember VALUES (7, 'Ian Moore');
INSERT INTO Item_BandMember VALUES (9, 'Sarah McLachlan');
INSERT INTO Item_BandMember VALUES (10, 'Joe Elliot');
INSERT INTO Item_BandMember VALUES (10, 'Rick Savage');
INSERT INTO Item_BandMember VALUES (10, 'Phil Cohen');
INSERT INTO Item_BandMember VALUES (10, 'Rick Allen');
INSERT INTO Item_BandMember VALUES (10, 'Steve Clark');
INSERT INTO Item_BandMember VALUES (11, 'Dexter Freebish');
INSERT INTO Item_BandMember VALUES (14, 'Peter Gabriel');
INSERT INTO Item_BandMember VALUES (20, 'Madonna');


INSERT INTO DownloadableItem VALUES (1, 'http://www.javatunes.com/music/download/CD501.mp3','MP3');
INSERT INTO DownloadableItem VALUES (5, 'http://www.javatunes.com/music/download/CD505.wma', 'WMA');

INSERT INTO Inventory VALUES (DEFAULT, 1, 'Piscataway', 10, 1);
INSERT INTO Inventory VALUES (DEFAULT, 1, 'Dallas', 25, 1);
INSERT INTO Inventory VALUES (DEFAULT, 1, 'New York', 50, 1);
INSERT INTO Inventory VALUES (DEFAULT, 1, 'St. Louis', 15, 1);
INSERT INTO Inventory VALUES (DEFAULT, 1, 'Santa Clara', 30, 1);
INSERT INTO Inventory VALUES (DEFAULT, 7, 'New York', 10, 1);
INSERT INTO Inventory VALUES (DEFAULT, 8, 'New York', 10, 1);
INSERT INTO Inventory VALUES (DEFAULT, 9, 'Edwardsville', 10, 1);


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
