-- requête 1 --
-- Afficher la liste des noms et adresses de tous les clients qui ont effectué au moins une
-- location d’une voiture et d’un véhicule utilitaire

Select distinct c.nom_client, c.adr_client
from CLIENT c, LOUER l, LOUER m, VEHICULE v, VEHICULE u
WHERE c.num_client=l.num_client
AND l.num_client=m.num_client
AND l.num_immatriculation=v.num_immatriculation
AND m.num_immatriculation=u.num_immatriculation
AND v.type_veh = 'voiture'
AND u.type_veh = 'utilitaire';


-- requête 2 --
-- la liste des modèles de véhicules n’ayant fait l’objet d’aucune location de la part des entreprises,
-- vous indiquerez également la marque de chaque véhicule.
 

Select distinct v.marque,v.modele
from CLIENT c, LOUER l, VEHICULE v
WHERE c.num_client=l.num_client
AND l.num_immatriculation=v.num_immatriculation
AND c.type_client <> 'entreprise'
AND l.num_loc is NOT NULL;


-- requête 3 --
-- les numéros et les noms des clients ayant effectué au moins une location pour laquelle
-- l’agence de restitution est différente de l’agence où le véhicule a été loué.

SELECT c.num_client, c.nom_client
FROM CLIENT c, LOUER l
WHERE c.num_client = l.num_client
AND l.ID_AGENCE != l.ID_RESTITUTION
AND l.ID_RESTITUTION IS NOT NULL;

-- requête 4 --
--  les agences dans lesquelles au moins un véhicule utilitaire de chacune des marques existantes
-- dans l’entreprise est disponible à la location au moment où la requête est exécutée.



SELECT DISTINCT a.nom_agence
FROM AGENCE a, VEHICULE v
WHERE a.id_agence=v.id_agence
AND v.TYPE_VEH='utilitaire'
AND v.disponibilite = '1' ;


-- requête 5 --
--  les noms des responsables des agences dans lesquelles il est impossible de louer un véhicule de catégorie voiture.

SELECT distinct e.NOM_EMP
FROM EMPLOYE e, AGENCE a, VEHICULE v
WHERE e.NUM_EMP = a.NUM_EMP
AND a.ID_AGENCE = v.ID_AGENCE
AND v.TYPE_VEH = 'voiture'
AND v.DISPONIBILITE='0';



-- requête 6 --
-- le plus grand nombre de locations effectuées par un client et afficher les noms et adresses des clients
-- qui ont effectué ce grand nombre de locations.



SELECT c.nom_client , c.adr_client, COUNT(*) as nombre_locations, max(c.NUM_CLIENT)
FROM CLIENT c, LOUER l
WHERE c.num_client = l.num_client
GROUP BY c.nom_client , c.adr_client
HAVING COUNT(*) >= 2;


-- requête 7 --
-- agence par agence, le nom de l’agence, le nom de son responsable, ainsi que
-- le nombre de locations de plus de trois jours effectuées en 2015.

SELECT a.NOM_AGENCE , e.NOM_EMP , COUNT(*) nombre_locations
FROM AGENCE a , EMPLOYE e, LOUER l
WHERE a.ID_AGENCE = e.ID_AGENCE
AND a.ID_AGENCE = l.ID_AGENCE
AND l.DATE_DEBUT_LOC BETWEEN ('01/01/2015') and ('31/12/2015')
AND l.DATE_FIN_LOC BETWEEN ('01/01/2015') and ('31/12/2015')
AND e.TYPE_EMP='responsable'
AND l.DUREE_LOC > 3
GROUP BY a.NOM_AGENCE, e.NOM_EMP;

-- requête 8 --
--  Pour chaque véhicule de moins de 20 000 km (au moment où la requête est effectuée),
-- donner la somme totale des montants de toutes les locations effectuées par des entreprises
-- dont il a fait l’objet au cours du mois de juillet 2015.

SELECT SUM(l.PRIX_LOC) montants_locations
FROM VEHICULE v, LOUER l, CLIENT c
WHERE l.NUM_IMMATRICULATION = v.NUM_IMMATRICULATION
AND c.NUM_CLIENT = l.NUM_CLIENT
AND c.TYPE_CLIENT='entreprise'
AND v.KILOMETRAGE_FIN < 20000
AND l.DATE_DEBUT_LOC BETWEEN ('01/07/2015') and ('31/07/2015')
AND l.DATE_FIN_LOC BETWEEN ('01/07/2015') and ('31/07/2015');