
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

						<!-- Formulaire pour l'ajout d'une nouvelle location -->
						<form method="GET" action="">
							<label>Agence</label>
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
							</select>
							<label>Client</label>
							<select name="client">
								<option></option>
								<option value="1">CHEN</option>
								<option value="2">COLL</option>
								<option value="3">MAGNITOT</option>
								<option value="4">DESPORTES</option>
								<option value="5">EZZARI</option>
								<option value="6">GALOUZ</option>
								<option value="7">GAMA</option>
								<option value="8">GASMI</option>
							</select>
							<label>Véhicule</label>
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
							</select>
							<label>Durée de location</label>
							<select name="duree">
								<option></option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
							</select>
						</br>
							<label>Chèque caution à payer</label>
							<select name="caution">
								<option></option>
								<option value="50">50</option>
								<option value="55">55</option>
								<option value="60">60</option>
								<option value="65">65</option>
								<option value="70">70</option>
								<option value="75">75</option>
								<option value="80">80</option>
							</select>
							<label>Tarif journée</label>
							<select name="tarif">
								<option></option>
								<option value="30">30</option>
							</select>
							<label>Prix location</label>
							<select name="prix">
								<option></option>
								<option value="150">150</option>
							</select>
							</br>
							</br>
							<input type="submit" name="ok" value="Validez" />

						</form>

						<?php

						if (isset($_GET['ok'])) {


								if (isset($_GET['agence']) AND isset($_GET['client']) AND isset($_GET['vehicule']) AND isset($_GET['duree']) AND isset($_GET['tarif']) AND isset($_GET['prix'])) {
									
									include 'utils.inc.php';
									$bdd = new PDO(HOST, USER, MDP) or die();
									$today='CURRENT_DATE';
									$duree=$_GET['duree'];
									$caution=$_GET['caution'];
									$tarif=$_GET['tarif'];
									$prix=$_GET['prix'];
									$client=$_GET['client'];
									$vehicule=$_GET['vehicule'];
									$ag=$_GET['agence'];

									/*Insère les nouvelles données pour la nouvelle location, soit une nouvelle ligne*/
									$requete = $bdd->prepare("INSERT INTO LOUER (DATE_DEBUT_LOC,DUREE_LOC,CHEQUE_CAUTION,TARIF_LOC_JOURNEE,PRIX_LOC,NUM_CLIENT, NUM_IMMATRICULATION, ID_AGENCE) VALUES 
										(CURRENT_DATE,$duree,$caution,$tarif,$prix,$client,$vehicule,$ag)");
									//$requete = execute(array($_POST['id']));
									/*$requete->bindParam(1,$today);
									$requete->bindParam(2, $_GET['duree']); 
									$requete->bindParam(3, $_GET['caution']); 
									$requete->bindParam(4, $_GET['tarif']); */
									
									$requete->execute();
									$requete->setFetchMode(PDO::FETCH_ASSOC);

									/*signale que le véhicule n'est plus disponible*/
									$requete = $bdd->prepare("UPDATE VEHICULE SET DISPONIBILITE='0' WHERE NUM_IMMATRICULATION=$vehicule");
									$requete->execute();
									$requete->setFetchMode(PDO::FETCH_ASSOC);

									echo "<font color='red'>Nouvelle location ajoutée !</font>";


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