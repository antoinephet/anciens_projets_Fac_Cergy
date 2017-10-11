package deviner;
import javax.swing.*;

public class DevinerNombre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// contient les essais de l'utilisateur
		int essai = -1;
		// nombre d'essais
		int nombre = 0;
		int num = (int) (Math.random()*100);
		// boucle pour interroger l'utilisateur
		do
		{
			essai = Integer.parseInt(JOptionPane.showInputDialog("Devinez un nombre entre 0 et 100"));
			if(essai>num){
				JOptionPane.showMessageDialog(null, "Trop grand");
			}
			if(essai<num){
				JOptionPane.showMessageDialog(null, "Trop petit");
				nombre++;
			}
			// continuer jusqu'à ce que l'utilisateur trouve le nombre
		}while(num!=essai);
		JOptionPane.showMessageDialog(null,"Vous avez deviné le nombre, " + num + ", en " + nombre + " essai(s) !" );
	}

}
