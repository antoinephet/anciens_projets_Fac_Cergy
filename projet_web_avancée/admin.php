<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Test Site Web</title>

</head>

<body>
	<?php
	include("utils.inc.php");
	?>

<header>
<h1>MonSite.Com</h1>
<nav>
<ul>
	<li><a href="index.php">Accueil</a></li>
	<li><a href="biographie.php">Biographie</a></li>
	<li><a href="multimedia.php">Multimédia</a></li>
	<li><a href="formulaires.php">Formulaires</a></li>
	<li><a href="contact.php">Contact</a></li>
</ul>
</nav>
</header>
<section>
<article>
 <h3>Formulaires</h3>
 <p>

 	<form>
 		<label>Nom Localhost : </label><input type="text" name="local" id="local"/></br>
 		<label>Nom Base de données : </label><input type="text" name="bd" id="bd"/></br>
 		<label>Nom utilisateur : </label><input type="text" name="user" id="user"/></br>
 		<label>Mot de passe : </label><input type="pass" name="mdp" id="mdp"/></br>
 		<input type="submit" value="Envoyer" id="submit"/></br>

 	</form>

 	

</p>

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
<p>-- MonSite.Com || @Copyright 2015 --</p>
</footer>



</body>
</html>

