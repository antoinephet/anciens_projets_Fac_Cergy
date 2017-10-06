<?php
session_start();
$connect = mysqli_connect("localhost", "root", "", "aston");
if(isset($_POST["add"]))
{
	if(isset($_SESSION["cart"]))
	{
		$item_array_id = array_column($_SESSION["cart"], "product_id");
		if(!in_array($_GET["id"], $item_array_id))
		{
			$count = count($_SESSION["cart"]);
			$item_array = array(
			'product_id' => $_GET["id"],
			'item_name' => $_POST["hidden_name"],
			'product_price' => $_POST["hidden_price"],
			'item_quantity' => $_POST["quantity"]
			);
			$_SESSION["cart"][$count] = $item_array;
			echo '<script>window.location="shopping.php"</script>'; /*shopping*/
		}
		else
		{
			echo '<script>alert("L\'article a deja ete ajoute au panier")</script>';
			echo '<script>window.location="shopping.php"</script>';/*shopping*/
		}
	}
	else
	{
		$item_array = array(
		'product_id' => $_GET["id"],
		'item_name' => $_POST["hidden_name"],
		'product_price' => $_POST["hidden_price"],
		'item_quantity' => $_POST["quantity"]
		);
		$_SESSION["cart"][0] = $item_array;
	}
}
if(isset($_GET["action"]))
{
	if($_GET["action"] == "delete")
	{
		foreach($_SESSION["cart"] as $keys => $values)
		{
			if($values["product_id"] == $_GET["id"])
			{
				unset($_SESSION["cart"][$keys]);
				echo '<script>alert("L\'article a ete retire")</script>';
				echo '<script>window.location="shopping.php"</script>';/*index*/
			}
		}
	}
}
?>