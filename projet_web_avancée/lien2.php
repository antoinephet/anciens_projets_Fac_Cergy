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
	<img src="images/VERT-FFA.jpg" alt="Smiley face" height="100" width="100">
<h1>SportsClub</h1>
<nav>
<ul>
	<li><a href="index.php">Accueil</a></li>
	<li><a href="equipement.php">Equipement</a></li>
	<li><a href="calendrier.php">Calendrier</a></li>
	<li><a href="event.php">Evènements</a></li>
	<li><a href="formulaires.php">Formulaires</a></li>
	<li><a href="contact.php">Contact</a></li>
	<li><a href="connexion.php">Connexion</a></li>
</ul>
</nav>
</header>
<section>
<article>
 <h3>Formulaires</h3>
 <p>
 	<a href="formulaires.php">Lien1</a> <a href="lien2.php">Lien2</a> <a href="lien3.php">Lien3</a> </br>

 	<form name="form" method="POST" action="lien2.php">
<input type="radio" name="req" value="1" checked="checked" />Sélectionner les codes des pays et leur nom en français<br />
<input type="radio" name="req" value="2" />Sélectionner les noms des pays en anglais<br />
<br />
<select name="choix">
   <option selected="selected">Simple</option>
   <option>Table HTML</option>
</select>
<input type="submit" name="reqs" value="OK"/><br />
</form>
	<?php
	if(isset($_POST['choix']) && $_POST['choix'] == "Simple")
	{
		select2array("select * from sport;");
	}
	else if (isset($_POST['choix']) && $_POST['choix'] == "Table HTML")
	{
		echo select2htmltable("select * from sport;"); 
	}	
	?>
 	
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
<p>-- SportsClub || @Copyright 2015 --</p>
</footer>



</body>
</html>

