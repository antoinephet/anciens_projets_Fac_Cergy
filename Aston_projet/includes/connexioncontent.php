<?php
	session_start();

	$bdd = new PDO('mysql:host=localhost;dbname=aston', 'root', '');

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
				$_SESSION['nom']=$userinfo['nom'];
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

<article class="connexioncontent">
	<header>
		<h3>Connexion</h3>
	</header>
					
	<content>
		<br /><br />
			<form method="POST" action="">

				<input type="email" name="mailconnect" placeholder="Mail" />

				<input type="password" name="mdpconnect" placeholder="Mot de passe" />

				<input type="submit" name="formconnexion" value="Se connecter" />
						
				
			</form>

			<br /><br />
			<?php
			if(isset($erreur))
			{
				echo '<font color="red">'.$erreur."</font>";
			}
			?>
	</content>
</article>
