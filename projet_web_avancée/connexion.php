<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=web', 'root', '');

if(isset($_POST['formconnexion']))
{
	$mailconnect = htmlspecialchars($_POST['mailconnect']);
	$mdpconnect = sha1($_POST['mdpconnect']);

	if (!empty($mailconnect) AND !empty($mdpconnect)) {

		$requser=$bdd->prepare("SELECT * FROM membres WHERE mail= ? AND motdepasse = ?");
		$requser->execute(array($mailconnect,$mdpconnect));
		$userexist=$requser->rowCount();

		if ($userexist==1) {
			$userinfo=$requser->fetch();

			$_SESSION['id']=$userinfo['id'];
			$_SESSION['pseudo']=$userinfo['pseudo'];
			$_SESSION['mail']=$userinfo['mail'];
			header("Location: profil.php?id=".$_SESSION['id']);


		}
		else
		{
			$erreur = "Mauvais mot de passe ou adresse mail !";
		}
	}
	else
	{
		$erreur = "Tous les champs doivent être complétés !";
	}

}

?>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Test Site Web</title>

</head>

<body>

<header>
	<img src="images/VERT-FFA.jpg" alt="Smiley face" height="100" width="100">
<h1>SportsClub</h1>
<nav>
<ul>
	<li><a href="index.php">Accueil</a></li>
	<li><a href="equipement.php">Equipement</a></li>
	<li><a href="calendrier.php">Calendrier</a></li>
	<li><a href="event.php">Evènements</a></li>
	<li><a href="inscription.php">Inscription</a></li>
	<li><a href="contact.php">Contact</a></li>
	<li><a href="connexion.php">Connexion</a></li>
</ul>
</nav>
</header>
<section>
<article>

	<h3>Connexion</h3>
			<br /><br />
			<form method="POST" action="">

				<input type="email" name="mailconnect" placeholder="Mail" />

				<input type="password" name="mdpconnect" placeholder="Mot de passe" />

				<input type="submit" name="formconnexion" value="Se connecter" />
						
				
			</form>
			<?php
			if(isset($erreur))
			{
				echo '<font color="red">'.$erreur."</font>";
			}
			?>


</article>
</section>

<aside>
<h4>Musique</h4>
<p>
		<audio class="audio1" controls>
	<source src="Hot_Thursday.mp3" type="audio/mp3">
		</audio>
	
</p>


<h4>Liens externes</h4>

<ul>
<li><a href="http://www.u-cergy.fr/">u-cergy</a></li>
<li><a href="http://www.facebook.com/">Facebook</a></li>
</ul>
</aside>
<footer class="clear">
<p>-- SportsClub || @Copyright 2015 --</p>
</footer>



</body>
</html>

