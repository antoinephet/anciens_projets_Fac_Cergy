
<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Société Locations de voitures</title>
	<meta charset="utf-8" />
	
	<link rel="stylesheet" href="style1.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body class="body">

	<header class="mainHeader">
		<!-- img src="img/logo.gif" --><center>Société Locations de voitures</center>  <!-- header on place les rubriques ou liens ainsi que l'image en haut du site -->
		<nav><ul>
			<li class="active"><a href="accueil.php">Accueil</a></li>  <!-- header on place les rubriques ainsi que l'image en haut du site -->
			<li><a href="tables.php">Tables</a></li>  <!-- lien Tables du site -->
			<li><a href="requetes.php">Requêtes</a></li>  <!-- page des Requêtes du site -->
			<li><a href="locations.php">Locations</a></li>  <!-- page Locations du site -->
			<!-- <li><a href="editorial.php">&Eacute;DITORIAL</a></li> --> <!-- regroupe news+articles site -->
			<!-- <li><a href="contact.php">CONTACT</a></li> -->  <!-- contact du site -->
			<!-- <li><a href="liens.php">LIENS</a></li> --> <!-- liens externes du site --> 
		</ul>
	</nav>
	</header>


	<div class="mainContent"> <!-- contenu principal càd l'article -->
		<div class="content">	
				<article class="topcontent">	<!-- article du haut donc ici le second article -->
					<header>
						<h2><a href="requetes.php" rel="bookmark" title="profil">Requêtes</a></h2> <!-- titre de l'article -->
					</header>
					
					
					<content> <!-- texte ou contenu de l'article -->
						<!-- Formulaire pour les requêtes de 1 à 8 -->
						<form name="form" Method ="POST" ACTION ="requetes.php">
							<input type="radio" name="req" value="1" checked="checked" /> 1. la liste des noms et adresses de tous les clients qui ont effectué au moins une
location d’une voiture et d’un véhicule utilitaire.<br>
							<input type="radio" name="req" value="2" /> 2. la liste des modèles de véhicules n’ayant fait l’objet d’aucune location de la part
des entreprises, vous indiquerez également la marque de chaque véhicule.<br>
							<input type="radio" name="req" value="3" /> 3. les numéros et les noms des clients ayant effectué au moins une location pour
laquelle l’agence de restitution est différente de l’agence où le véhicule a été loué.<br>
							<input type="radio" name="req" value="4" /> 4. les agences dans lesquelles au moins un véhicule utilitaire de chacune des
marques existantes dans l’entreprise est disponible à la location au moment où la requête
est exécutée.<br>
							<input type="radio" name="req" value="5" /> 5. les noms des responsables des agences dans lesquelles il est impossible de louer
un véhicule de catégorie voiture.<br>
							<input type="radio" name="req" value="6" /> 6. le plus grand nombre de locations effectuées par un client et afficher les noms et
adresses des clients qui ont effectué ce grand nombre de locations.<br>
							<input type="radio" name="req" value="7" /> 7. agence par agence, le nom de l’agence, le nom de son responsable, ainsi que le
nombre de locations de plus de trois jours effectuées en 2015.<br>
							<input type="radio" name="req" value="8" /> 8. Pour chaque véhicule de moins de 20 000 km (au moment où la requête est effectuée),
donner la somme totale des montants de toutes les locations effectuées par des entreprises
dont il a fait l’objet au cours du mois de juillet 2015.<br>

							<input type="submit" name="sub" value="OK"/><br />
						</form>
						<p></p>


						<?php                  // nom bd + user+ mdp 
						//$connect=obdc_connect ("bd_aphe","aphe","") ;
						include 'utils.inc.php';
						if (isset($_POST['sub'])){

							// Connexion, sélection de la base de données
							$bdd = new PDO(HOST, USER, MDP) or die();
							echo '<p> Connexion ok ! </p>' . "\n";

								/*requête 1*/
								if ($_POST['req'] == '1'){
						?>
									<table border="1">
										<tr>
											<th>Nom client</th>
											<th>Adresse client</th>
										</tr>
									<?php

										foreach ($bdd->query("Select distinct c.nom_client, c.adr_client
										from CLIENT c, LOUER l, LOUER m, VEHICULE v, VEHICULE u
										WHERE c.num_client=l.num_client
										AND l.num_client=m.num_client
										AND l.num_immatriculation=v.num_immatriculation
										AND m.num_immatriculation=u.num_immatriculation
										AND v.type_veh = 'voiture'
										AND u.type_veh = 'utilitaire'") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["NOM_CLIENT"]; ?></td>
										<td><?php echo $Row["ADR_CLIENT"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 2*/
								if ($_POST['req'] == '2'){
						?>
									<table border="1">
										<tr>
											<th>Marque</th>
											<th>Modèle</th>
										</tr>
									<?php

										foreach ($bdd->query("Select distinct v.marque,v.modele
										from CLIENT c, LOUER l, VEHICULE v
										WHERE c.num_client=l.num_client
										AND l.num_immatriculation=v.num_immatriculation
										AND c.type_client <> 'entreprise'
										AND l.num_loc is NOT NULL") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["MARQUE"]; ?></td>
										<td><?php echo $Row["MODELE"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 3*/
							if ($_POST['req'] == '3'){
						?>
									<table border="1">
										<tr>
											<th>Numéro client</th>
											<th>Nom client</th>
										</tr>
									<?php

										foreach ($bdd->query("Select distinct c.num_client,c.nom_client
										from CLIENT c, LOUER l
										WHERE c.num_client=l.num_client
										AND l.ID_AGENCE!=l.ID_RESTITUTION
										AND l.ID_RESTITUTION IS NOT NULL") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["NUM_CLIENT"]; ?></td>
										<td><?php echo $Row["NOM_CLIENT"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 4*/
							if ($_POST['req'] == '4'){
						?>
									<table border="1">
										<tr>
											<th>Nom agence</th>
										</tr>
									<?php

										foreach ($bdd->query("Select distinct a.nom_agence
										from AGENCE a, vehicule v
										WHERE a.id_agence=v.id_agence
										AND v.TYPE_VEH='utilitaire'
										AND v.disponibilite = '1'") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["NOM_AGENCE"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 5*/
							if ($_POST['req'] == '5'){
						?>
									<table border="1">
										<tr>
											<th>Nom Employé</th>
										</tr>
									<?php

										foreach ($bdd->query("Select e.NOM_EMP
										from EMPLOYE e, AGENCE a, VEHICULE v
										WHERE e.NUM_EMP = a.NUM_EMP
										AND a.ID_AGENCE = v.ID_AGENCE
										AND v.TYPE_VEH = 'voiture'
										AND v.DISPONIBILITE='0'") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["NOM_EMP"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 6*/
							if ($_POST['req'] == '6'){
						?>
									<table border="1">
										<tr>
											<th>Nom client</th>
											<th>Adresse client</th>
											<th>Nombre locations</th>
											<th>Numéro client</th>
										</tr>
									<?php

										foreach ($bdd->query("Select c.nom_client , c.adr_client, COUNT(*) as nombre_locations, max(c.NUM_CLIENT) as max
										from CLIENT c, LOUER l
										WHERE c.num_client = l.num_client
										GROUP BY c.nom_client , c.adr_client
										HAVING COUNT(*)>=2") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["NOM_CLIENT"]; ?></td>
										<td><?php echo $Row["ADR_CLIENT"]; ?></td>
										<td><?php echo $Row["NOMBRE_LOCATIONS"]; ?></td>
										<td><?php echo $Row["MAX"]; ?></td>
			
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 7*/
							if ($_POST['req'] == '7'){
						?>
									<table border="1">
										<tr>
											<th>Nom agence</th>
											<th>Nom employé</th>
											<th>Nombre locations</th>
										</tr>
									<?php

										foreach ($bdd->query("Select a.NOM_AGENCE , e.NOM_EMP , COUNT(*) nombre_locations
										from AGENCE a , EMPLOYE e, LOUER l
										WHERE a.ID_AGENCE = e.ID_AGENCE
										AND a.ID_AGENCE=l.ID_AGENCE
										AND l.DATE_DEBUT_LOC BETWEEN ('01/01/2015') and ('31/12/2015')
										AND l.DATE_FIN_LOC BETWEEN ('01/01/2015') and ('31/12/2015')
										AND e.TYPE_EMP='responsable'
										AND l.DUREE_LOC > 3
										GROUP BY a.NOM_AGENCE, e.NOM_EMP") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["NOM_AGENCE"]; ?></td>
										<td><?php echo $Row["NOM_EMP"]; ?></td>
										<td><?php echo $Row["NOMBRE_LOCATIONS"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}
							/*requête 8*/
							if ($_POST['req'] == '8'){
						?>
									<table border="1">
										<tr>
											<th>Montant</th>

										</tr>
									<?php

										foreach ($bdd->query("Select SUM(l.PRIX_LOC) montants_locations
										from VEHICULE v, LOUER l, CLIENT c
										WHERE l.NUM_IMMATRICULATION = v.NUM_IMMATRICULATION
										AND c.NUM_CLIENT = l.NUM_CLIENT
										AND c.TYPE_CLIENT='entreprise'
										AND v.KILOMETRAGE_FIN < 20000
										AND l.DATE_DEBUT_LOC BETWEEN ('01/07/2015') and ('31/07/2015')
										AND l.DATE_FIN_LOC BETWEEN ('01/07/2015') and ('31/07/2015')") as $Row){

									?>
		
									<tr>
										<td><?php echo $Row["MONTANTS_LOCATIONS"]; ?></td>
									</tr>
									<?php
							}
 									?>
 									</table>
 									<?php
							}

						}

						?>

					</content>
					
				</article>

		</div>

	</div>

	<footer class="mainFooter"> <!-- pied de page principal du site -->
		<p>Copyright &copy; 2015 <a href="#">Phetramphand et Babaedjou</a></p>
		<!-- <div class="flag">
			<a href="profil.php" title="face" target="_blank"><img src="img/fr.png" width="15" height="15" alt="face"></a>
			<a href="eng/profile.php" title="face" target="_blank"><img src="img/eng.png" width="15" height="15" alt="face"></a>
			<a href="esp/perfil.php" title="face" target="_blank"><img src="img/esp.png" width="15" height="15" alt="face"></a>
		</div> -->
	</footer>
	


</body>
</html>
