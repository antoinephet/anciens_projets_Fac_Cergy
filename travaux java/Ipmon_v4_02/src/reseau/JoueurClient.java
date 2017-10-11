package reseau;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jeu.Joueur;

public class JoueurClient  extends Joueur implements Runnable  {
	public JoueurClient() {}

	public JoueurClient(Socket socket)  throws Exception{	
		super(socket);
		adversaire = new JoueurClient();
	}	

	public void traiterMessage(String message) {
		Scanner scan = new Scanner(message);
		int type = scan.nextInt();
		switch(type) {
		case Constantes.NUM : 
			numero = scan.nextInt();
			jouer = true;
			break;
		case Constantes.GAGNE : 
			aGagne();
			break;
		case Constantes.PERDU : 
			aPerdu();
			break;
		case Constantes.ECHANGER : 
			enEchange();jeuFini = true;
			jouer = true;
			break;
		case Constantes.PARTIE_GAGNEE : 
			//partieGagnee = true;
			jeuFini = true;
			break;
		case Constantes.PARTIE_PERDUE : 
			//partiePerdue = true;
			jeuFini = true;
			break;
		case Constantes.CHOIX_ADVERSAIRE : 
			adversaire.choix = Choix.valueOf(scan.next());
			break;
		}
		setChanged();
		notifyObservers();
	}

	public void run() {
		while(!jeuFini)
			try {
				String message = in.readLine();
				traiterMessage(message);
			}
		catch(Exception exc) {
			System.err.println(pseudo +"s'est déconnecté ");
		}
	}

	public static void main(String[] arg) throws Exception {
		  String nomMachine = null;
		  boolean ok = false;
		  
		  while (!ok){
		      try{
		       nomMachine = JOptionPane.showInputDialog (null, "Sur quelle machine est le serveur  ?");
		       if(nomMachine == null || !nomMachine.equals("")) {
		        ok=true;
		       }
		      }
		      catch(Exception e){} 
		     }
		  if (nomMachine != null){
		   String nomPort = JOptionPane.showInputDialog (null, "Et sur quel port ?");
		   
		   try {
		    int nomPort2 = Integer.parseInt(nomPort); 
		    Socket socket = new Socket(nomMachine, nomPort2);
		    JoueurClient joueur = new JoueurClient (socket);
		    IHMJoueurClient i = new IHMJoueurClient(joueur);
		   }
		   catch (NumberFormatException e) {
		    JOptionPane.showMessageDialog (null, nomPort + " n'est pas un nombre", "Client", JOptionPane.ERROR_MESSAGE);
		   }
		   catch (UnknownHostException e) {
		    JOptionPane.showMessageDialog (null, "Impossible de se connecter à " + nomMachine, "Client", JOptionPane.ERROR_MESSAGE);  
		   }
		   
		   catch (IOException ioe) {
		    JOptionPane.showMessageDialog (null, "Connexion refusée (Serveur plein ou erreur de port)", "Client", JOptionPane.ERROR_MESSAGE);
		   }
		  }
		  else JOptionPane.showMessageDialog(null, "Vous avez annulé la connexion", "Client non connecté", JOptionPane.WARNING_MESSAGE);
		 }
}
