package ipmon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GameBoard extends JPanel implements KeyListener{
	
	String game[][] = new String[12][12];
	int level = 1;
	private static ArrayList<Arbre> murs;
	private static ArrayList<Objectif> objectifs;
	private static ArrayList<Ipmon> caisses;
	Arbre mur;
	Objectif objectif;
	Joueur mario;
	Ipmon caisse;
	Font levelFont = new Font("SansSerif", Font.BOLD, 30);
	FileWriter fw;
	FileReader fr;
	Frame gFrame;
	
	public GameBoard(Frame gf){
		
		chargerLevel();
		
		gFrame = gf;
		setFocusable(true);
		addKeyListener(this);
		
		
	}
	
	
	public void chargerLevel(){
		
		try{
			
			fr = new FileReader ("Level"+ level + ".level");
			//fr = new FileReader ("Maps/Level" + level + ".level");
			
			int i = 0;
			int x=0, y = 0;
			
			murs = new ArrayList<Arbre>();
			caisses = new ArrayList<Ipmon>();
			objectifs = new ArrayList<Objectif>();
			
			while((i = fr.read()) != -1){
				char strImg = (char) i;
				
				if(strImg == '0'){
					game[x][y] = "MUR";
					mur = new Arbre(x * 34, y * 34);
					murs.add(mur);
				}
				
				else if(strImg == '1'){
					game[x][y] = "MARIO";
					mario = new Joueur(x * 34, y * 34);
				}
				
				else if(strImg == '2'){
					game[x][y] = "CAISSE";
					caisse = new Ipmon(x * 34, y * 34);
					caisses.add(caisse);
				}
				
				else if(strImg == '3'){
					game[x][y] = "OBJECTIF";
					objectif = new Objectif(x * 34, y * 34);
					objectifs.add(objectif);
				}
				
				else if(strImg == ' '){
					game[x][y] = null;
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
			
		}catch(Exception ex){}
		repaint();
	}
	
	public void paint(Graphics g){
		
		// modification taille des images
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0;i < murs.size();i++){
			mur = (Arbre) murs.get(i);
			g2d.drawImage(mur.getImage(), mur.getX(), mur.getY(), null);
			
		}
		
		for(int i=0;i < objectifs.size();i++){
			objectif = (Objectif) objectifs.get(i);
			g2d.drawImage(objectif.getImage(), objectif.getX(), objectif.getY(), null);
			
		}
		
		for(int i=0;i < caisses.size();i++){
			caisse = (Ipmon) caisses.get(i);
			g2d.drawImage(caisse.getImage(), caisse.getX(), caisse.getY(), null);
			
		}
		
		try{
			
			g2d.drawImage(mario.getImage(), mario.getX(), mario.getY(), null);
			
			
		}catch(Exception ex){}
		
		g.setColor(Color.BLACK);
		g.setFont(levelFont);
		g.drawString("Level : " + level, 10, 25);
		
	}
	
	public void checkCollision(){
		Rectangle marioRec;
		marioRec = mario.getBounds();
		
		// Collisions avec les murs
		
		for(int i=0;i < murs.size();i++){
			
			mur = (Arbre) murs.get(i);
			Rectangle murRec = mur.getBounds();
			
			if(marioRec.intersects(murRec)){
				if(mario.getMarioDir() == "BAS"){
					
					mario.setY(mario.getY() - 34);
					
				}
				else if(mario.getMarioDir() == "HAUT"){
					
					mario.setY(mario.getY() + 34);
					
				}
				else if(mario.getMarioDir() == "GAUCHE"){
					
					mario.setX(mario.getX() + 34);
					
				}
				else if(mario.getMarioDir() == "DROITE"){
					
					mario.setX(mario.getX() - 34);
					
				}
				
			}
			
		}
		
		// Collisions avec les caisses
		
		for(int i=0;i < caisses.size();i++){
			
			caisse = (Ipmon) caisses.get(i);
			Rectangle caisseRec = caisse.getBounds();
			
			if(marioRec.intersects(caisseRec)){
				if(mario.getMarioDir() == "BAS"){
					if(game[caisseRec.x / 34][(caisseRec.y + 34) / 34] != "MUR"){
						
						mario.setY(mario.getY() + 34);
						
					}
					else if(game[caisseRec.x / 34][(caisseRec.y + 34) / 34] == "MUR"){
						
						mario.setY(mario.getY() - 34);
						
					}
					
				}
				else if(mario.getMarioDir() == "HAUT"){
					if(game[caisseRec.x / 34][(caisseRec.y - 34) / 34] != "MUR"){
						
						mario.setY(mario.getY() - 34);
						
					}
					else if(game[caisseRec.x / 34][(caisseRec.y - 34) / 34] == "MUR"){
						
						mario.setY(mario.getY() + 34);
						
					}
					
					
					
				}
				else if(mario.getMarioDir() == "GAUCHE"){
					if(game[(caisseRec.x - 34) / 34][caisseRec.y / 34] != "MUR"){
						
						mario.setX(mario.getX() - 34);
						
					}
					else if(game[(caisseRec.x - 34) / 34][caisseRec.y / 34] == "MUR"){
						
						mario.setX(mario.getX() + 34);
						
					}
					
					
					
				}
				else if(mario.getMarioDir() == "DROITE"){
					if(game[(caisseRec.x + 34) / 34][caisseRec.y / 34] != "MUR"){
						
						mario.setX(mario.getX() + 34);
						
					}
					else if(game[(caisseRec.x + 34) / 34][caisseRec.y / 34] == "MUR"){
						
						mario.setX(mario.getX() - 34);
						
					}
					
					
					
				}
				
			}
			
		}
		
		// Collisions avec les objectifs
		
		for(int i=0;i < objectifs.size();i++){
			
			objectif = (Objectif) objectifs.get(i);
			Rectangle objectifRec = objectif.getBounds();
			for(int j=0;j < caisses.size();j++){
				
				caisse = (Ipmon) caisses.get(j);
				Rectangle caisseRec = caisse.getBounds();
				if(caisseRec.intersects(objectifRec) && !caisse.isCaissejuste() && !objectif.isCaisseDessus()){
					
					caisse.setEtat("OBJECTIF");
					caisse.setCaissejuste(true);
					objectif.setCaisseDessus(true);
					
				}
				else if(!caisseRec.intersects(objectifRec) && caisse.isCaissejuste() && objectif.isCaisseDessus()){
					
					caisse.setEtat("NORMALE");
					caisse.setCaissejuste(false);
					objectif.setCaisseDessus(false);
					
				}
				
				
			}
			
			
		}
		
	}
	
	public void verifierLevelFini(){
		int nbCaisseJuste = 0;
		
		for(int i=0;i < caisses.size();i++){
			caisse = (Ipmon) caisses.get(i);
			
			if(caisse.etat == "OBJECTIF"){
				nbCaisseJuste++;
				
			}
			
			if(nbCaisseJuste == caisses.size()){
				level++;
				chargerLevel();
				
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int touche = e.getKeyCode();
		
		if(touche == KeyEvent.VK_DOWN){
			mario.setMarioDir("BAS");
			mario.deplacer();
			checkCollision();
		}
		else if(touche == KeyEvent.VK_UP){
			mario.setMarioDir("HAUT");
			mario.deplacer();
			checkCollision();
		}
		else if(touche == KeyEvent.VK_RIGHT){
			mario.setMarioDir("DROITE");
			mario.deplacer();
			checkCollision();
		}
		else if(touche == KeyEvent.VK_LEFT){
			mario.setMarioDir("GAUCHE");
			mario.deplacer();
			checkCollision();
		}
		else if(touche == KeyEvent.VK_R){
			chargerLevel();
		}
		else if(touche == KeyEvent.VK_ESCAPE){
			MenuFrame frm = new MenuFrame();
			gFrame.dispose();
			
		}
		
		repaint();
		verifierLevelFini();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
