<?php

function saisie($valeur)
{
	try
	{
		$pdo = new PDO('mysql:host=localhost;dbname=synthese', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();
		$req = "select * from sport where id_sport='".$valeur."';";

		$stmt = $pdo->query($req);
		$arrAll = $stmt->fetchAll();
		
		foreach ($arrAll as $row) {
		    echo "Nom anglais : ".$row['id_sport']." <br />Nom français : ".$row['nom_sport'];
		}
	} catch (PDOException $e) {
	    print "Erreur : " . $e->getMessage() . "<br/>";
	    die();
	}
}

function affichage($table)
{
	try
	{
		$pdo = new PDO('mysql:host=localhost;dbname=synthese', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();
		$req = "select * from " . $table;

		$stmt = $pdo->query($req);
		$arrAll = $stmt->fetchAll();
		
		foreach ($arrAll as $row) {
		    print_r($row);
		}
	} catch (PDOException $e) {
	    print "Erreur : " . $e->getMessage() . "<br/>";
	    die();
	}
}



function affichage_evt($table)
{
	try
	{
		$pdo = new PDO('mysql:host=localhost;dbname=web', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();
		$req = "select * from " . $table;

		$stmt = $pdo->query($req);
		$arrAll = $stmt->fetchAll();
		
		foreach ($arrAll as $row) {
		    echo "Nom : " . $row['nom_evenement'] . " - type : " . $row['type_evenement'] . " - lieu : " . $row['lieu_evenement']."<br/>";
		}
	} catch (PDOException $e) {
	    print "Erreur : " . $e->getMessage() . "<br/>";
	    die();
	}
}


function affichagecalendrier($table)
{
	try
	{
		$pdo = new PDO('mysql:host=localhost;dbname=web', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();
		$req = "select * from " . $table;

		$stmt = $pdo->query($req);
		$arrAll = $stmt->fetchAll();
		
		foreach ($arrAll as $row) {
		    echo "" . $row['id_calendrier'] . " - date : " . $row['date'] . " - heure : " . $row['heure']." - type : " . $row['type']."<br/>";
		}
	} catch (PDOException $e) {
	    print "Erreur : " . $e->getMessage() . "<br/>";
	    die();
	}
}

function affichage_equipement($table)
{
	try
	{
		$pdo = new PDO('mysql:host=localhost;dbname=web', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();
		$req = "select * from " . $table;

		$stmt = $pdo->query($req);
		$arrAll = $stmt->fetchAll();
		
		foreach ($arrAll as $row) {
		    echo "Nom : " . $row['nom_equipement'] . " - fonction : " . $row['fonction'] ."<br/>";
		}
	} catch (PDOException $e) {
	    print "Erreur : " . $e->getMessage() . "<br/>";
	    die();
	}
}


function select2array($req)
{
	if (isset($_POST['reqs']))
	{
		try {
		$pdo = new PDO('mysql:host=localhost;dbname=synthese', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();

		if ($_POST['req'] == '1')
		{	
			$stmt = $pdo->query($req);
			$arrAll = $stmt->fetchAll();
			foreach ($arrAll as $row) {
			    print "Code : " . $row["id_sport"] . " - Pays : " . $row["nom_sport"] . "<br/>";
			}
		}
		else if($_POST['req'] == '2')
		{
			$stmt = $pdo->query($req);
			$arrAll = $stmt->fetchAll();
			foreach ($arrAll as $row) {
			    print "Pays : " . $row["nom_sport"] . "<br/>";
			}
		}
		} catch (PDOException $e) {
		    print "Erreur !: " . $e->getMessage() . "<br/>";
		    die();
		}
	}
}

function select2htmltable($req)
{
	if (isset($_POST['reqs']))
	{
		$html = "<table>";
		try {
		$pdo = new PDO('mysql:host=localhost;dbname=synthese', 'root', '', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES \'UTF8\'')) or die();

		if ($_POST['req'] == '1')
		{	
			$html .= "<tr><td> Code </td><td> Nom pays </td></tr>";
			$stmt = $pdo->query($req);
			$arrAll = $stmt->fetchAll();

			foreach ($arrAll as $row) {
			    $html .= "<tr><td> " . $row["id_sport"] . " </td><td> " . $row["nom_sport"] . " </td></tr>";
			}
		}
		else if($_POST['req'] == '2')
		{
			$html .= "<tr><td> Nom pays </td></tr>";
			$stmt = $pdo->query($req);
			$arrAll = $stmt->fetchAll();
			foreach ($arrAll as $row) {
			    $html .= "<tr><td> " . $row["nom_sport"] . "</td></tr>";
			}
		}
		$html .= "</table>";
		return $html;
		} catch (PDOException $e) {
		    print "Erreur !: " . $e->getMessage() . "<br/>";
		    die();
		}
	}
}

?>
