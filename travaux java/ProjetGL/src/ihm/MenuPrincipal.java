package ihm;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


// la classe qui créé une fenêtre d'introduction du jeu
public class MenuPrincipal extends JFrame implements ActionListener{
	
	private Container cont;
	private JButton cmdJeu = new JButton("Commencez");
	private JButton cmdQuitter = new JButton("Quitter");
	private Color titreCouleur;
	private Font titreFont;

	// initialise la mise en page du JFrame ou la fenêtre
	public MenuPrincipal(){
		
		init();
		initActions();
		cont.setBackground(Color.WHITE);
		titreCouleur = new Color(128,0,0);
		titreFont = new Font("Century Gothic",Font.PLAIN,30);
		
		
	}
	
	private void init() {
		
		setTitle("Menu Principal");
		setSize(514, 536);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// mise en place du conteneur principal
	    
	    cont = getContentPane();
	    cont.setLayout(null);
		
	    
	    // ajout des composants
	    
	    cont.add(cmdJeu);
		cont.add(cmdQuitter);
		
		
		cmdJeu.setBounds(150, 230, 200, 50);
	    cont.setComponentZOrder(cmdJeu,0);
	    
	    cmdQuitter.setBounds(150, 330, 200, 50);
	    cont.setComponentZOrder(cmdQuitter,0);
		
	}
	
	private void initActions() {
		
		cmdJeu.addActionListener(this);
		cmdQuitter.addActionListener(this);
	}
	
	public void paint(Graphics g){
		
		// modification taille des images
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// dessine titres
		g.setColor(titreCouleur);
		g.setFont(titreFont);
		g.drawString("Le Gardien de parc", 125, 160);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// si clique sur le bouton "Commencer" alors il instancie la classe IHM et ouvre une nouvelle fenêtre
		if(arg0.getSource() == cmdJeu){
			dispose();
			Ihm frm = new Ihm();
			
			
		} else if(arg0.getSource() == cmdQuitter){
			dispose();
			
		}
		
	}

}
