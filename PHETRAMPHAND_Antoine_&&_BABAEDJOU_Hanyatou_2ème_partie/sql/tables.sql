 ---------------------------------------------------------------
 --        Script Oracle.  
 ---------------------------------------------------------------


------------------------------------------------------------
-- Table: Agence
------------------------------------------------------------
CREATE TABLE Agence(
	id_agence   NUMBER NOT NULL ,
	nom_agence  VARCHAR2 (25)  ,
	adr_agence  VARCHAR2 (40)  ,
	num_emp     NUMBER(10,0)   ,
	CONSTRAINT Agence_Pk PRIMARY KEY (id_agence)
);

------------------------------------------------------------
-- Table: Employé
------------------------------------------------------------
CREATE TABLE Employe(
	num_emp           NUMBER NOT NULL ,
	nom_emp           CHAR (30)   ,
	adr_emp           VARCHAR2 (40)  ,
	date_embauche     DATE   ,
	type_emp          CHAR (25)   ,
	id_agence         NUMBER(10,0)   ,
	CONSTRAINT Employe_Pk PRIMARY KEY (num_emp)
);

------------------------------------------------------------
-- Table: Utilitaire
------------------------------------------------------------
CREATE TABLE Utilitaire(
	capacite             NUMBER(10,0)   ,
	charge_max           FLOAT   ,
	num_immatriculation  NUMBER(10,0)  NOT NULL  ,
	CONSTRAINT Utilitaire_Pk PRIMARY KEY (num_immatriculation)
);

------------------------------------------------------------
-- Table: Vehicule
------------------------------------------------------------
CREATE TABLE Vehicule(
	num_immatriculation  NUMBER(10,0)  NOT NULL  ,
	type_veh             CHAR (25)   ,
	marque               VARCHAR2 (25)  ,
	modele               VARCHAR2 (25)  ,
	coeff_marque         NUMBER(10,0)   ,
	coeff_modele         NUMBER(10,0)   ,
	date_achat           DATE   ,
	disponibilite        NUMBER (1) ,
	kilometrage_debut    NUMBER(10,0)   ,
	kilometrage_fin      NUMBER(10,0)   ,
	id_agence            NUMBER(10,0)   ,
	CONSTRAINT Vehicule_Pk PRIMARY KEY (num_immatriculation) ,
	CONSTRAINT CHK_BOOLEAN_disponibilite CHECK (disponibilite IN (0,1))
);

------------------------------------------------------------
-- Table: Client
------------------------------------------------------------
CREATE TABLE Client(
	num_client   NUMBER NOT NULL ,
	nom_client   VARCHAR2 (25)  ,
	adr_client   VARCHAR2 (40)  ,
	type_client  CHAR (40)   ,
	CONSTRAINT Client_Pk PRIMARY KEY (num_client)
);

------------------------------------------------------------
-- Table: Louer
------------------------------------------------------------
CREATE TABLE Louer(
	num_loc              NUMBER NOT NULL ,
	date_debut_loc       DATE   ,
	date_fin_loc         DATE   ,
	duree_loc            NUMBER(10,0)   ,
	cheque_caution       FLOAT   ,
	tarif_loc_journee    NUMBER(10,0)   ,
	prix_loc             FLOAT   ,
	id_restitution       NUMBER(10,0)   ,
	num_client           NUMBER(10,0)  NOT NULL  ,
	num_immatriculation  NUMBER(10,0)  NOT NULL  ,
	id_agence            NUMBER(10,0)  NOT NULL  ,
	CONSTRAINT Louer_Pk PRIMARY KEY (num_client,num_immatriculation,id_agence)
);



------- Modification des tables pour les clés étrangères
ALTER TABLE Agence ADD FOREIGN KEY (num_emp) REFERENCES Employe(num_emp);
ALTER TABLE Employe ADD FOREIGN KEY (id_agence) REFERENCES Agence(id_agence);
ALTER TABLE Utilitaire ADD FOREIGN KEY (num_immatriculation) REFERENCES Vehicule(num_immatriculation);
ALTER TABLE Vehicule ADD FOREIGN KEY (id_agence) REFERENCES Agence(id_agence);
ALTER TABLE Louer ADD FOREIGN KEY (num_client) REFERENCES Client(num_client);
ALTER TABLE Louer ADD FOREIGN KEY (num_immatriculation) REFERENCES Vehicule(num_immatriculation);
ALTER TABLE Louer ADD FOREIGN KEY (id_agence) REFERENCES Agence(id_agence);


------- Création des séquences pour les auto increments
CREATE SEQUENCE Seq_Agence_id_agence START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Employe_num_emp START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Client_num_client START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Louer_num_loc START WITH 1 INCREMENT BY 1 NOCYCLE;


CREATE OR REPLACE TRIGGER Agence_id_agence
	BEFORE INSERT ON Agence 
  FOR EACH ROW 
	WHEN (NEW.id_agence IS NULL) 
	BEGIN
		 select Seq_Agence_id_agence.NEXTVAL INTO :NEW.id_agence from DUAL; 
	END;
CREATE OR REPLACE TRIGGER Employe_num_emp
	BEFORE INSERT ON Employe 
  FOR EACH ROW 
	WHEN (NEW.num_emp IS NULL) 
	BEGIN
		 select Seq_Employe_num_emp.NEXTVAL INTO :NEW.num_emp from DUAL; 
	END;
CREATE OR REPLACE TRIGGER Client_num_client
	BEFORE INSERT ON Client 
  FOR EACH ROW 
	WHEN (NEW.num_client IS NULL) 
	BEGIN
		 select Seq_Client_num_client.NEXTVAL INTO :NEW.num_client from DUAL; 
	END;
CREATE OR REPLACE TRIGGER Louer_num_loc
	BEFORE INSERT ON Louer 
  FOR EACH ROW 
	WHEN (NEW.num_loc IS NULL) 
	BEGIN
		 select Seq_Louer_num_loc.NEXTVAL INTO :NEW.num_loc from DUAL; 
	END;

