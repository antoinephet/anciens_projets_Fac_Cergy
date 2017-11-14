
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
						<h2><a href="locations.php" rel="bookmark" title="références">Locations</a></h2> <!-- titre de l'article -->
					</header>
					

					
					<content> <!-- texte ou contenu de l'article -->
						<?php
							include 'utils.inc.php';
							
							$bdd = new PDO(HOST, USER, MDP) or die();

						?>
						<!-- Affichage des données de la table Louer -->
						<table border="1">
							<tr>
								<th>Numéro location</th>
								<th>Date début</th>
								<th>Date fin</th>
								<th>durée</th>
								<th>Chèque caution</th>
								<th>Tarif journée</th>
								<th>Prix</th>
								<th>Numéro client</th>
								<th>Numéro immatriculation</th>
								<th>ID agence</th>
								<th>ID restitution</th>
							</tr>
						<?php
							foreach ($bdd->query("SELECT * FROM LOUER") as $Row){
						?>
							<tr>
								<td><?php echo $Row["NUM_LOC"]; ?></td>
								<td><?php echo $Row["DATE_DEBUT_LOC"]; ?></td>
								<td><?php echo $Row["DATE_FIN_LOC"]; ?></td>
								<td><?php echo $Row["DUREE_LOC"]; ?></td>
								<td><?php echo $Row["CHEQUE_CAUTION"]; ?></td>
								<td><?php echo $Row["TARIF_LOC_JOURNEE"]; ?></td>
								<td><?php echo $Row["PRIX_LOC"]; ?></td>
								<td><?php echo $Row["NUM_CLIENT"]; ?></td>
								<td><?php echo $Row["NUM_IMMATRICULATION"]; ?></td>
								<td><?php echo $Row["ID_AGENCE"]; ?></td>
								<td><?php echo $Row["ID_RESTITUTION"]; ?></td>
							</tr>
						<?php

							}

						?>
						</table>
					</br>
					</br>

					<a href="etape1.php">Enregistrez une nouvelle location</a></br>
					<a href="etape2.php">Restituez une location</a>
					</content>

				</article>

				
		</div>

	</div>

	<footer class="mainFooter"> <!-- pied de page principal du site -->
		<p>Copyright &copy; 2015 <a href="#">Phetramphand et Babaedjou</a></p>
		<!-- <div class="flag">
			<a href="references.php" title="face"><img src="img/fr.png" width="15" height="15" alt="face"></a>
			<a href="eng/references.php" title="face"><img src="img/eng.png" width="15" height="15" alt="face"></a>
			<a href="esp/referencias.php" title="face"><img src="img/esp.png" width="15" height="15" alt="face"></a>
		</div> -->
	</footer>



</body>
</html>
