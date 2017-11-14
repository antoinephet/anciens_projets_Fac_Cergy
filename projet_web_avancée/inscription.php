<?php

$bdd = new PDO('mysql:host=localhost;dbname=web', 'root', '');

if(isset($_POST['forminscription']))
{
	$pseudo = htmlspecialchars($_POST['pseudo']);
	$mail = htmlspecialchars($_POST['mail']);
	$mail2 = htmlspecialchars($_POST['mail2']);
	$mdp = sha1($_POST['mdp']);
	$mdp2 = sha1($_POST['mdp2']);

	if(!empty($_POST['pseudo']) AND !empty($_POST['mail']) AND !empty($_POST['mail2']) AND !empty($_POST['mdp']) AND !empty($_POST['mdp2']))
	{
		$pseudolength = strlen($pseudo);
		if($pseudolength <= 255)
		{
			if($mail == $mail2)
			{
				if(filter_var($mail, FILTER_VALIDATE_EMAIL))
				{
					$reqmail = $bdd->prepare("SELECT * FROM membres WHERE mail = ?");
					$reqmail->execute(array($mail));
					$mailexist = $reqmail->rowCount();
					if($mailexist == 0)
					{
						if($mdp == $mdp2)
						{
							$insertmbr = $bdd->prepare("INSERT INTO membres(pseudo, mail, motdepasse) VALUES(?, ?, ?)");
							$insertmbr->execute(array($pseudo, $mail, $mdp));
							$erreur = "Votre compte a bien été créé !<a href=\"connexion.php\">Me connecter</a>";
						}
						else
						{
							$erreur = "Vos mots de passes ne correspondent pas !";
						}
					}
					else
					{
						$erreur = "Adresse mail déjà utilisée !";
					}
				}
				else
				{
					$erreur = "Votre adresse mail n'est pas valide !";
				}
			}
			else
			{
				$erreur = "Vos adresses mail ne correspondent pas !";
			}
		}
		else
		{
			$erreur = "Votre pseudo ne doit pas dépasser 255 caractères !";
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
 <h3>Inscription</h3>
<br /><br />
			<form method="POST" action="">
				<table>
					<tr>
						<td align="right">
							<label for="pseudo">Pseudo :</label>
						</td>
						<td>
							<input type="text" placeholder="Votre pseudo" id="pseudo" name="pseudo" value="<?php if(isset($pseudo)) { echo $pseudo; } ?>" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<label for="mail">Mail :</label>
						</td>
						<td>
							<input type="email" placeholder="Votre mail" id="mail" name="mail" value="<?php if(isset($mail)) { echo $mail; } ?>" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<label for="mail2">Confirmation du mail :</label>
						</td>
						<td>
							<input type="email" placeholder="Confirmez votre mail" id="mail2" name="mail2" value="<?php if(isset($mail2)) { echo $mail2; } ?>" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<label for="mdp">Mot de passe :</label>
						</td>
						<td>
							<input type="password" placeholder="Votre mot de passe" id="mdp" name="mdp" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<label for="mdp2">Confirmation du mot de passe :</label>
						</td>
						<td>
							<input type="password" placeholder="Confirmez votre mdp" id="mdp2" name="mdp2" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="center">
							<br />
							<input type="submit" name="forminscription" value="Je m'inscris" />
						</td>
					</tr>
				</table>
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

