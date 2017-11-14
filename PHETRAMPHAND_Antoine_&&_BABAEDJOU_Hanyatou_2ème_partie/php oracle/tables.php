
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
						<h2><a href="tables.php" rel="bookmark" title="tables">Tables</a></h2> <!-- titre de l'article -->
					</header>
					
					
					<content> <!-- texte ou contenu de l'article -->
						<p></p>
					</content>
					
				</article>

				<article class="bottomcontent">	<!-- article du bas donc ici le 1er article -->
					<header>
						<h2><a href="#" rel="bookmark" title="agence">Agence</a></h2>
					</header>
					
					<content> <!-- texte ou contenu de l'article -->
						<?php
						/*Appel au fichier pour la connexion à la base de données*/
							include 'utils.inc.php';
							
							$bdd = new PDO(HOST, USER, MDP) or die();

						?>
						<!-- Affichage des données de la table AGENCE -->
						<table border="1">
							<tr>
								<th>ID</th>
								<th>Nom</th>
								<th>Adresse</th>
								<th>Numéro employé</th>
							</tr>
						<?php
							foreach ($bdd->query("SELECT * FROM AGENCE") as $Row){
						?>
							<tr>
								<td><?php echo $Row["ID_AGENCE"]; ?></td>
								<td><?php echo $Row["NOM_AGENCE"]; ?></td>
								<td><?php echo $Row["ADR_AGENCE"]; ?></td>
								<td><?php echo $Row["NUM_EMP"]; ?></td>
							</tr>
						<?php

							}

						?>
						</table>
					</content>
				
				</article>
				
				<article class="bottomcontent">	<!-- article du bas donc ici le 1er article -->
					<header>
						<h2><a href="#" rel="bookmark" title="client">Client</a></h2>
					</header>

					
					<content> <!-- texte ou contenu de l'article -->
						 <?php

							
							$bdd = new PDO(HOST, USER, MDP) or die();

						?>
						<!-- Affichage des données de la table CLIENT -->
						<table border="1">
							<tr>
								<th>ID</th>
								<th>Nom</th>
								<th>Adresse</th>
								<th>Type</th>
							</tr>
						<?php
							foreach ($bdd->query("SELECT * FROM CLIENT") as $Row){
						?>
							<tr>
								<td><?php echo $Row["NUM_CLIENT"]; ?></td>
								<td><?php echo $Row["NOM_CLIENT"]; ?></td>
								<td><?php echo $Row["ADR_CLIENT"]; ?></td>
								<td><?php echo $Row["TYPE_CLIENT"]; ?></td>
							</tr>
						<?php

							}

						?>
						</table>

					</content>
				
				</article>
				
				<article class="bottomcontent">	<!-- article du bas donc ici le 1er article -->
					<header>
						<h2><a href="#" rel="bookmark" title="employe">Employé</a></h2>
					</header>
					
					<content> <!-- texte ou contenu de l'article -->
						<?php
							
							$bdd = new PDO(HOST, USER, MDP) or die();

						?>
								<!-- Affichage des données de la table EMPLOYE -->
						<table border="1">
							<tr>
								<th>ID</th>
								<th>Nom</th>
								<th>Adresse</th>
								<th>Date embauche</th>
								<th>Type</th>
								<th>ID agence</th>
							</tr>
						<?php
							foreach ($bdd->query("SELECT * FROM EMPLOYE") as $Row){
						?>
							<tr>
								<td><?php echo $Row["NUM_EMP"]; ?></td>
								<td><?php echo $Row["NOM_EMP"]; ?></td>
								<td><?php echo $Row["ADR_EMP"]; ?></td>
								<td><?php echo $Row["DATE_EMBAUCHE"]; ?></td>
								<td><?php echo $Row["TYPE_EMP"]; ?></td>
								<td><?php echo $Row["ID_AGENCE"]; ?></td>
							</tr>
						<?php

							}

						?>
						</table>
					</content>
				
				</article>
				
				<article class="bottomcontent">	<!-- article du bas donc ici le 1er article -->
					<header>
						<h2><a href="#" rel="bookmark" title="utili">Utilitaire</a></h2>
					</header>
					
					<content> <!-- texte ou contenu de l'article -->
						<?php
							
							$bdd = new PDO(HOST, USER, MDP) or die();

						?>
								<!-- Affichage des données de la table UTILITAIRE -->
						<table border="1">
							<tr>
								<th>Capacité</th>
								<th>Charge maximale</th>
								<th>numéro immatriculation</th>
							</tr>
						<?php
							foreach ($bdd->query("SELECT * FROM UTILITAIRE") as $Row){
						?>
							<tr>
								<td><?php echo $Row["CAPACITE"]; ?></td>
								<td><?php echo $Row["CHARGE_MAX"]; ?></td>
								<td><?php echo $Row["NUM_IMMATRICULATION"]; ?></td>
							</tr>
						<?php

							}

						?>
						</table>
					</content>
				
				</article>
				
				<article class="bottomcontent">	<!-- article du bas donc ici le 1er article -->
					<header>
						<h2><a href="#" rel="bookmark" title="vehicule">Véhicule</a></h2>
					</header>

					<content> <!-- texte ou contenu de l'article -->
						<?php
							
							$bdd = new PDO(HOST, USER, MDP) or die();

						?>
								<!-- Affichage des données de la table VEHICULE -->
						<table border="1">
							<tr>
								<th>numéro immatriculation</th>
								<th>Type</th>
								<th>Marque</th>
								<th>Modèle</th>
								<th>Coeff marque</th>
								<th>Coeff modele</th>
								<th>Date achat</th>
								<th>Disponibilité</th>
								<th>Kilométrage début</th>
								<th>Kilométrage début </th>
								<th>ID agence</th>
							</tr>
						<?php
							foreach ($bdd->query("SELECT * FROM VEHICULE") as $Row){
						?>
							<tr>
								<td><?php echo $Row["NUM_IMMATRICULATION"]; ?></td>
								<td><?php echo $Row["TYPE_VEH"]; ?></td>
								<td><?php echo $Row["MARQUE"]; ?></td>
								<td><?php echo $Row["MODELE"]; ?></td>
								<td><?php echo $Row["COEFF_MARQUE"]; ?></td>
								<td><?php echo $Row["COEFF_MODELE"]; ?></td>
								<td><?php echo $Row["DATE_ACHAT"]; ?></td>
								<td><?php echo $Row["DISPONIBILITE"]; ?></td>
								<td><?php echo $Row["KILOMETRAGE_DEBUT"]; ?></td>
								<td><?php echo $Row["KILOMETRAGE_FIN"]; ?></td>
								<td><?php echo $Row["ID_AGENCE"]; ?></td>
							</tr>
						<?php

							}

						?>
						</table>
					</content>
				
				</article>
		</div>

	</div>

	<footer class="mainFooter"> <!-- pied de page principal du site -->
		<p>Copyright &copy; 2015 <a href="#">Phetramphand et Babaedjou</a></p>
		<!--<div class="flag">
			<a href="agence.php" title="face"><img src="img/fr.png" width="15" height="15" alt="face"></a>
			<a href="eng/agency.php" title="face"><img src="img/eng.png" width="15" height="15" alt="face"></a>
			<a href="esp/agencia.php" title="face"><img src="img/esp.png" width="15" height="15" alt="face"></a>
		</div> -->
	</footer>
	


</body>
</html>
