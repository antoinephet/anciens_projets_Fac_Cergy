<?php
	session_start();
	$connect = mysqli_connect("localhost", "root", "", "aston");
?>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>GAME Boutique</title>

	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- librairie jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<div class="container" style="width:60%;">
	<h2 align="center">GAME Boutique | A vos achats! <a href="index.php" style="font-size: 16px;">Retour à l'accueil</a></h2>
    <?php
	$query = "SELECT * FROM articles ORDER BY id ASC";
	$result = mysqli_query($connect, $query);
	if(mysqli_num_rows($result) > 0)
	{
		while($row = mysqli_fetch_array($result))
		{
			?>
            <div class="col-md-3">
            <form method="post" action="panier.php?action=add&id=<?php echo $row["id"]; ?>">
            <div style="border: 1px solid #eaeaec; margin: -1px 19px 3px -1px; box-shadow: 0 1px 2px rgba(0,0,0,0.05); padding:10px;" align="center">
            <img src="<?php echo $row["image"]; ?>" class="img-responsive" height="100" width="100">
            <h5 class="text-info"><?php echo $row["nom"]; ?></h5>
            <h5 class="text-danger">$ <?php echo $row["prix"]; ?></h5>
            <input type="text" name="quantity" class="form-control" value="1">
            <input type="hidden" name="hidden_name" value="<?php echo $row["nom"]; ?>">
            <input type="hidden" name="hidden_price" value="<?php echo $row["prix"]; ?>">
            <input type="submit" name="add" style="margin-top:5px;" class="btn btn-default" value="Ajouter">
            </div>
            </form>
            </div>
            <?php
		}
	}
	?>
    <div style="clear:both"></div>
    <h2>Mon Panier</h2>
    <div class="table-responsive">
    <table class="table table-bordered">
    <tr>
    <th width="40%">Nom du produit</th>
    <th width="10%">Quantité</th>
    <th width="18%">Prix</th>
    <th width="15%">Montant Total</th>
    <th width="5%">Action</th>
    </tr>
    <?php
	if(!empty($_SESSION["cart"]))
	{
		$total = 0;
		foreach($_SESSION["cart"] as $keys => $values)
		{
			?>
            <tr>
            <td><?php echo $values["item_name"]; ?></td>
            <td><?php echo $values["item_quantity"] ?></td>
            <td>$ <?php echo $values["product_price"]; ?></td>
            <td>$ <?php echo number_format($values["item_quantity"] * $values["product_price"], 2); ?></td>
            <td><a href="panier.php?action=delete&id=<?php echo $values["product_id"]; ?>"><span class="text-danger">X</span></a></td>
            </tr>
            <?php 
			$total = $total + ($values["item_quantity"] * $values["product_price"]);
		}
		?>
        <tr>
        <td colspan="3" align="right">Total</td>
        <td align="right">$ <?php echo number_format($total, 2); ?></td>
        <td></td>
        </tr>
        <?php
	}
	?>
    </table>
    </div>
    </div>
</body>
</html>


<?php  ?>