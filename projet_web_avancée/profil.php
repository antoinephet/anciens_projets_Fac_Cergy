<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=web', 'root', '');

if (isset($_GET['id']) AND $_GET['id'] > 0) {
	$getid=intval($_GET['id']);
	$requser=$bdd->prepare("SELECT * FROM membres WHERE id= ?");
	$requser->execute(array($getid));
	$userinfo=$requser->fetch();

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
 <h3>Profil de <?php echo $userinfo['pseudo'] ?></h3>
			<br/><br/>
			Pseudo : <?php echo $userinfo['pseudo'] ?>
			<br/>
			Mail : <?php echo $userinfo['mail'] ?>
			<br/>

			<?php 
			if (isset($_SESSION['id']) AND $userinfo['id']==$_SESSION['id']) {
			?>
			<a href="#">Editer mon profil</a>
			<a href="deconnexion.php">Se déconnecter</a>
			<?php
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

<?php
}
?>