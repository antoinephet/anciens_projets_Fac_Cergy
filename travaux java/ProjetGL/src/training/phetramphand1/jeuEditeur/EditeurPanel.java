package training.phetramphand1.jeuEditeur;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditeurPanel extends JPanel implements MouseListener,MouseMotionListener,MouseWheelListener,KeyListener{
	
	
	// variables
	
	private String editeur[][] = new String[12][12];
	private String imageSelect[] = {"MUR","EAU","ARBRE","GARDIEN","INTRUS"};
	private String imageCourante = "MUR";
	private int mx,my;
	private int indexInc = 0;
	private Image gardien;
	private Image intrus;
	private Image mur;
	private Image arbre;
	private Image eau;
	private FileWriter fw;
	private FileReader fr;
	
	
	public EditeurPanel() {
	
		// insertion des images
		
		ImageIcon iGardien = new ImageIcon("images/gardien.png");
		gardien = iGardien.getImage();
		
		ImageIcon iIntrus = new ImageIcon("images/intrus.png");
		intrus = iIntrus.getImage();
		
		ImageIcon iMur = new ImageIcon("images/mur.png");
		mur = iMur.getImage();
		
		ImageIcon iEau = new ImageIcon("images/eau.png");
		eau = iEau.getImage();
		
		ImageIcon iArbre = new ImageIcon("images/arbre.png");
		arbre = iArbre.getImage();
		
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		addKeyListener(this);
		
	}
	
	public void paint(Graphics g){
		
		// modification taille des images
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0;i <= 11;i++){
			for(int j=0;j <= 11;j++){
				if(editeur[i][j] == "MUR"){
					
					g2d.drawImage(mur, i * 34, j * 34, null);
					
				}
				
				if(editeur[i][j] == "EAU"){
					
					g2d.drawImage(eau, i * 34, j * 34, null);
					
				}
				
				if(editeur[i][j] == "ARBRE"){
					
					g2d.drawImage(arbre, i * 34, j * 34, null);
					
					
				}
				
				if(editeur[i][j] == "GARDIEN"){
					
					g2d.drawImage(gardien, i * 34, j * 34, null);
					
				}
				if(editeur[i][j] == "INTRUS"){
					
					g2d.drawImage(intrus, i * 34, j * 34, null);
					
				}
			}
			
		}
		
		if(imageCourante == "MUR"){
			
			g2d.drawImage(mur, mx, my, null);
		}
		else if(imageCourante == "EAU"){
			g2d.drawImage(eau, mx, my, null);
			
		}
		else if(imageCourante == "ARBRE"){
			g2d.drawImage(arbre, mx, my, null);
			
		}
		else if(imageCourante == "GARDIEN"){
			g2d.drawImage(gardien, mx, my, null);
			
		}
		else if(imageCourante == "INTRUS"){
			g2d.drawImage(intrus, mx, my, null);
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		// sauvegarde de l'edition au clavier
		
				char key = arg0.getKeyChar();
				
				if(key == 's'){
					
					try{
						
						fw = new FileWriter (JOptionPane.showInputDialog(null,"Entrez le chemin de sauvegarde : ","Editeur de Map",JOptionPane.QUESTION_MESSAGE));
						for(int i=0;i < 12;i++){
							for(int j=0;j < 12;j++){
								if(editeur[j][i] == "MUR"){
									
									fw.write("0");
									
								}
								else if(editeur[j][i] == "GARDIEN"){
									fw.write("1");
									
								}
								else  if(editeur[j][i] == "INTRUS"){
									
									fw.write("2");
									
								}
								else if(editeur[j][i] == "ARBRE"){
									
									fw.write("3");
									
								}
								else if(editeur[j][i] == "EAU"){
									
									fw.write("4");
									
								}
								else if(editeur[j][i] == null){
									
									fw.write(" ");
									
								}
								
							}
							fw.write("\r\n");
						}
						fw.close();
							
					}
							
					catch(Exception ex){}
					
				}
				
				// lecture de l'edition au clavier
				
				else if(key == 'l'){
					
					try {
						
						fr = new FileReader (JOptionPane.showInputDialog(null,"Entrez le chemin de lecteur : ","Editeur de Map",JOptionPane.QUESTION_MESSAGE));
						int i = 0;
						int x=0, y = 0;
						while((i = fr.read()) != -1){
							char strImg = (char) i;
							
							if(strImg == '0'){
								editeur[x][y] = "MUR";
							}
							
							else if(strImg == '1'){
								editeur[x][y] = "GARDIEN";
							}
							
							else if(strImg == '2'){
								editeur[x][y] = "INTRUS";
							}
							
							else if(strImg == '3'){
								editeur[x][y] = "ARBRE";
							}
							else if(strImg == '4'){
								editeur[x][y] = "EAU";
							}
							
							else if(strImg == ' '){
								editeur[x][y] = null;
							}
							else if(strImg == '\r' || strImg == '\n'){
								x--;
							}
							
							if(x == 11){
								y++;
								x=0;
							}
							else {
								x++;
							}
							
						}
						
					} catch (Exception ex){}
					
					
					
				}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		
		// moyen de changer d'element à la molette de la souris
		
				int rot = arg0.getWheelRotation();
				
				if(rot < 0){
					if(indexInc > 0){
						indexInc--;
						
					}
					
				}
				else if(rot > 0){
					if(indexInc < 4){
						indexInc++;
						
					}
					
					
				}
				
				imageCourante = imageSelect[indexInc];
				repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		mx = arg0.getX() - 17;
		my = arg0.getY() - 17;
		
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		int x = arg0.getX() / 34;
		int y = arg0.getY() / 34;
		
		if(arg0.getButton() == java.awt.event.MouseEvent.BUTTON1){
			
			editeur[x][y] = imageCourante;
			
		}
		else if(arg0.getButton() == java.awt.event.MouseEvent.BUTTON3){
			
			editeur[x][y] = null;
		}
		
		repaint();
		
	}

}
