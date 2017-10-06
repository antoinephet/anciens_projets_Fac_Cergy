
<?php
	session_start();

	$bdd = new PDO('mysql:host=localhost;dbname=aston', 'root', '');

	if (isset($_GET['id']) AND $_GET['id'] > 0) {
	$getid=intval($_GET['id']);
	$requser=$bdd->prepare("SELECT * FROM membres WHERE id= ?");
	$requser->execute(array($getid));
	$userinfo=$requser->fetch();

?>


<article class="profilcontent">
	<header>
		<h3>Profil</h3>
	</header>
					
	<content>
		<br/><br/>
		Nom : <?php echo $userinfo['nom'] ?>
		<br/>
		Mail : <?php echo $userinfo['mail'] ?>
		<br/>

		<?php 
			if (isset($_SESSION['id']) AND $userinfo['id']==$_SESSION['id']) {
		?>
		<a href="#">Éditer mon profil</a> | <a href="deconnexion.php">Se déconnecter</a>
		
		<?php
			}
		?>
		
	</content>
</article>

<?php
	}
?>