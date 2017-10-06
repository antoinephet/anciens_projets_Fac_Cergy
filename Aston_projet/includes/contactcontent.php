

<article class="contactcontent">
	<header>
		<h3>Formulaire de contact</h3>
	</header>
					
	<content>
		<p></p>
		<form action='' method='post'>
   <input type='text' name='nom'/> Nom <br>
   <input type='email' name='email'/> Email<br>
   <input type='text' name='objet'/> Objet <br>
   Message : <br>
   <textarea name='message' cols='50' rows='4'></textarea><br>
   <input type='submit' value='Envoyer'/>
  </form>
	</content>
					
</article>


<?php
	if(isset($_POST)&& !empty($_POST['nom'])&& !empty($_POST['objet'])&& !empty($_POST['message'])){
		extract($_POST);
		$destinataire='yakuza78@hotmail.fr'; // Adresse email destinataire
		$expediteur=$pseudo_exp.' <'.$email_exp.'>';
		$mail=mail($destinataire,$objet,$message,$expediteur.' : Patrimgest.com : Mail de test');
		
		if($mail) echo 'Email envoyé avec succés !!';
		else echo'Echec envoi ';
  }

  else echo"";
?>