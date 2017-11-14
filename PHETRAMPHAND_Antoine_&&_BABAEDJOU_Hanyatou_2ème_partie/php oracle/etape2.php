
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
				<!-- Formulaire pour la restitution -->
					<form method="GET" action="">
						<label>Numéro de location ?</label>
							<input type="text" name="numero" placeholder="Numéro" />
							<label>Agence de restitution</label>
							<select name="agence">
								<option></option>
								<option value="1">Rent A Car</option>
								<option value="2">Car Go</option>
								<option value="3">Cooldrive</option>
								<option value="4">Europcar France</option>
								<option value="5">Livop</option>
								<option value="6">SAAI</option>
								<option value="7">Hertz</option>
								<option value="8">CLOVIS</option>
								<option value="9">Blooweels</option>
								<option value="10">Ada</option>
							</select></br>
							<label>Quel véhicule ?</label>
							<select name="vehicule">
								<option></option>
								<option value="555901">Audi - voiture - A3</option>
								<option value="555902">Audi - voiture - A4 Ambiente</option>
								<option value="555903">Audi - utilitaire - Q5</option>
								<option value="555904">Citroen - utilitaire - Berlingo</option>
								<option value="555905">Citroen - utilitaire - Jumpy</option>
								<option value="555906">Citroen - utilitaire - Nemo</option>
								<option value="555907">Citroen - voiture - C1</option>
								<option value="555908">Citroen - voiture - C8</option>
								<option value="555909">Dacia - voiture - Logan</option>
								<option value="555910">Dacia - voiture - Logan Break</option>
								<option value="555911">Dacia - voiture - Sandero</option>
								<option value="555912">Nissan - voiture - Qashqai</option>
							</select></br></br>
							
							<input type="submit" name="ok" value="Validez" />

						</form>

						<?php

						if (isset($_GET['ok'])) {


								if (isset($_GET['agence']) AND isset($_GET['vehicule']) AND isset($_GET['numero'])) {
									
									
									/*$bdd = new PDO(HOST, USER, MDP) or die();*/
									$today='CURRENT_DATE';
									$num=$_GET['numero'];
									$vehicule=$_GET['vehicule'];
									$ag=$_GET['agence'];

									/*Met à jour les données de lalocation*/
									$requete = $bdd->prepare("UPDATE LOUER SET DATE_FIN_LOC=CURRENT_DATE,ID_RESTITUTION=$ag WHERE NUM_IMMATRICULATION=$vehicule AND NUM_LOC=$num");
									$requete->execute();
									$requete->setFetchMode(PDO::FETCH_ASSOC);

									/*signale que le véhicule est disponible*/
									$requete = $bdd->prepare("UPDATE VEHICULE SET DISPONIBILITE='1' WHERE NUM_IMMATRICULATION=$vehicule");
									$requete->execute();
									$requete->setFetchMode(PDO::FETCH_ASSOC);

									echo "<font color='red'>location restituée !</font>";


								}else{

									echo "<font color='red'>Tous les champs doivent être complétés !</font>";
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