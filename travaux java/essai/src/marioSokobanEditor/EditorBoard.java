package marioSokobanEditor;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import marioSokoban.MenuFrame;

import org.w3c.dom.events.MouseEvent;



public class EditorBoard extends JPanel implements MouseListener,MouseMotionListener,MouseWheelListener,KeyListener{
	
	// variables
	
	String editeur[][] = new String[30][30];
	String imageSelect[] = {"MUR","CAISSE","MARIO","OBJECTIF"};
	String imageCourante = "MUR";
	int mx,my;
	int indexInc = 0;
	Image mario;
	Image mur;
	Image caisse;
	Image objectif;
	FileWriter fw;
	FileReader fr;
	Frame eFrame;
	
	
	public EditorBoard(Frame ef){
		
		// insertion des images
		
		ImageIcon iMario = new ImageIcon("images/mario_bas.gif");
		mario = iMario.getImage();
		
		ImageIcon iMur = new ImageIcon("images/mur.jpg");
		mur = iMur.getImage();
		
		ImageIcon iObjectif = new ImageIcon("images/objectif.png");
		objectif = iObjectif.getImage();
		
		ImageIcon iCaisse = new ImageIcon("images/caisse.jpg");
		caisse = iCaisse.getImage();
		
		eFrame = ef;
		
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
		
		for(int i=0;i <= 29;i++){
			for(int j=0;j <= 29;j++){
				if(editeur[i][j] == "MUR"){
					
					g2d.drawImage(mur, i * 34, j * 34, null);
					
				}
				
				if(editeur[i][j] == "MARIO"){
					
					g2d.drawImage(mario, i * 34, j * 34, null);
					
				}
				
				if(editeur[i][j] == "CAISSE"){
					
					g2d.drawImage(caisse, i * 34, j * 34, null);
					
					
				}
				
				if(editeur[i][j] == "OBJECTIF"){
					
					g2d.drawImage(objectif, i * 34, j * 34, null);
					
				}
			}
			
		}
		
		if(imageCourante == "MUR"){
			
			g2d.drawImage(mur, mx, my, null);
		}
		else if(imageCourante == "CAISSE"){
			g2d.drawImage(caisse, mx, my, null);
			
		}
		else if(imageCourante == "MARIO"){
			g2d.drawImage(mario, mx, my, null);
			
		}
		else if(imageCourante == "OBJECTIF"){
			g2d.drawImage(objectif, mx, my, null);
			
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		// sauvegarde de l'edition au clavier
		
		char key = e.getKeyChar();
		
		if(key == 's'){
			
			try{
				
				fw = new FileWriter (JOptionPane.showInputDialog(null,"Entrez le chemin de sauvegarde : ","Editeur de Map",JOptionPane.QUESTION_MESSAGE));
				for(int i=0;i < 30;i++){
					for(int j=0;j < 30;j++){
						if(editeur[j][i] == "MUR"){
							
							fw.write("0");
							
						}
						else if(editeur[j][i] == "MARIO"){
							fw.write("1");
							
						}
						else  if(editeur[j][i] == "CAISSE"){
							
							fw.write("2");
							
						}
						else if(editeur[j][i] == "OBJECTIF"){
							
							fw.write("3");
							
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
						editeur[x][y] = "MARIO";
					}
					
					else if(strImg == '2'){
						editeur[x][y] = "CAISSE";
					}
					
					else if(strImg == '3'){
						editeur[x][y] = "OBJECTIF";
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
		
		// appui sur espace pour revenir au menu
		
		else if(key == KeyEvent.VK_ESCAPE){
			MenuFrame frm = new MenuFrame();
			eFrame.dispose();
			
		}
			
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
		// moyen de changer d'element à la molette de la souris
		
		int rot = e.getWheelRotation();
		
		if(rot < 0){
			if(indexInc > 0){
				indexInc--;
				
			}
			
		}
		else if(rot > 0){
			if(indexInc < 3){
				indexInc++;
				
			}
			
			
		}
		
		imageCourante = imageSelect[indexInc];
		repaint();
		
	}


	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
		mx = e.getX() - 17;
		my = e.getY() - 17;
		
		repaint();
		
	}


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x = e.getX() / 34;
		int y = e.getY() / 34;
		
		if(e.getButton() == java.awt.event.MouseEvent.BUTTON1){
			
			editeur[x][y] = imageCourante;
			
		}
		else if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
			
			editeur[x][y] = null;
		}
		
		repaint();
		
	}


	

}
