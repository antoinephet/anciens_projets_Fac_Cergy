<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=siteweb', 'root', '');

if (isset($_SESSION['id'])) {


	$requser=$bdd->prepare("SELECT * FROM membres WHERE id= ?");
	$requser->execute(array($_SESSION['id']));
	$user=$requser->fetch();

	if (isset($_POST['newpseudo']) AND !empty($_POST['newpseudo']) AND ($_POST['newpseudo'] != $user['pseudo'])) {

		$newpseudo =htmlspecialchars($_POST['newpseudo']);
		$insertpseudo =$bdd->prepare("UPDATE membres SET pseudo=? WHERE id=?");
		$insertpseudo->execute(array($newpseudo, $_SESSION['id']));
		header("Location: profil.php?id=".$_SESSION['id']);
	}

	if (isset($_POST['newmail']) AND !empty($_POST['newmail']) AND ($_POST['newmail'] != $user['mail'])) {

		$newmail =htmlspecialchars($_POST['newmail']);
		$insertmail =$bdd->prepare("UPDATE membres SET mail=? WHERE id=?");
		$insertmail->execute(array($newmail, $_SESSION['id']));
		header("Location: profil.php?id=".$_SESSION['id']);
	}

	if (isset($_POST['newmdp1']) AND !empty($_POST['newmdp1']) AND isset($_POST['newmdp2']) AND !empty($_POST['newmdp2'])) {

		$mdp1=sha1($_POST['newmdp1']);
		$mdp2=sha1($_POST['newmdp2']);
		if ($mdp1 == $mdp2) {

			$insertmdp=$bdd->prepare("UPDATE membres SET motdepasse=? WHERE id=?");
			$insertmdp->execute(array($mdp1, $_SESSION['id']));
			header("Location: profil.php?id=".$_SESSION['id']);
		}
		else
		{
			$msg = "Vos mdp ne correspondent pas!!";
		}
	}

	if (isset($_POST['newpseudo']) AND $_POST['newpseudo'] == $user['pseudo']) {

		header("Location: profil.php?id=".$_SESSION['id']);
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
 <h3>Edition de mon Profil</h3>
			<div align="left">
			<form method="POST" action="">
				<label>Pseudo : </label>
				<input type="text" name="newpseudo" placeholder="Pseudo" value="<?php echo $user['pseudo']; ?>" /><br/><br/>
				<label>Mail : </label>
				<input type="text" name="newmail" placeholder="Mail" value="<?php echo $user['mail']; ?>" /><br/><br/>
				<label>Mot de passe : </label>
				<input type="password" name="newmdp1" placeholder="Mot de passe" /><br/><br/>
				<label>Confirmez votre mot de passe : </label>
				<input type="password" name="newmdp2" placeholder="Confirmez mdp"  /><br/><br/>
				<input type="submit" value="Mettre à jour mon profil!" /><br/><br/>
			</form>
			<?php if (isset($msg)) {
				echo $msg;
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
else{
	header("Location: connexion.php");
}
?>