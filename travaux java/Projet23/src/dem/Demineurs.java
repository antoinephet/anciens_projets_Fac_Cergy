package dem;


import  java.awt.*;
import  java.awt.event.*;
import  javax.swing.*;
import  javax.swing.event.*;

public class Demineurs extends JFrame implements ActionListener {
	
  //temps restant avant la détonation
	
  int tempsRestant = 12;
  
  //JLabel affichant le temps restant
  
  JLabel temps = new JLabel(tempsRestant+"");
  
  //JLabel de la bombe
  
  JLabel bombe = new JLabel(new ImageIcon("bombe.png"));
  
  //indice
  
  JLabel indice = new JLabel();
  
  //code:
  
  int code = 0;
  
  //champ de code de désamorçage
  
  TextField essai = new TextField(20);
  
  //bouton de désamorçage
  
  JButton desamorcage = new JButton("DéSAMORCER");
  
  //conteneur pour les composants
  
  Container cont;
  
  //fil d'exécution
  
  Compteur compteur;
  
  public Demineurs() {
    super("Démineurs");
    setSize(500,550);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    cont.setBackground(Color.gray);
    
    //ajoute l'image de fond
    
    cont.add(bombe);
    bombe.setBounds(0,0,500,500);
    
    //police du JLabel
    
    temps.setFont(new Font("Courier", Font.BOLD, 20));
    
    //ajoute le JLabel de temps restant
    
    cont.add(temps);
    
    //définit la position
    
    temps.setBounds(250,371,150,18);
    
    //place le JLabel au-dessus du fond
    
    cont.setComponentZOrder(temps,0);
    
    //ajoute le bouton de désamorçage
    
    cont.add(desamorcage);
    desamorcage.setBounds(200,456,150,30);
    desamorcage.addActionListener(this);
    cont.setComponentZOrder(desamorcage,0);
    indice.setText("Un nombre entre 0 et "+20);
    cont.add(indice);
    indice.setBounds(167,435,250,20);
    
    //place le JLabel au-dessus du fond
    
    cont.setComponentZOrder(indice,0);
    
    //ajoute le champs de texte
    
    cont.add(essai);
    essai.setBounds(271,404,150,25);
    
    //valide tous les composants
    
    cont.validate();
    setContentPane(cont);
    setCode();
    compteur = new Compteur();
    compteur.start();
  }
  public void setCode() {
    code = (int)(Math.random()*20);
  }
  
//fil d'exécution du décompte
  
  public class Compteur extends Thread {
    public void run() {
      while(true) {
        try {
          tempsRestant--;
          temps.setText(tempsRestant+"");
          Thread.sleep(1000);
        } catch(Exception e){ }
      }
    }
  }
  public void actionPerformed(ActionEvent event) {
    if(Integer.parseInt(essai.getText())>code) {
      indice.setText("ATTENTION : le code saisi est TROP GRAND");
    }
    if(Integer.parseInt(essai.getText())<code) {
      indice.setText("ATTENTION : le code saisi est TROP PETIT");
    }
    if(essai.getText().equals(""+code)) {
    	
      //rien ne se passe pour l'instant
    }
  }
  public static void main(String[ ] args) {
    new Demineurs();
  }
}
