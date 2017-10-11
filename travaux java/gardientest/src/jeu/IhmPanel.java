package jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class IhmPanel extends JPanel implements KeyListener{
	
	
	String game[][] = new String[12][12];
	int level = 1;
	private static ArrayList<Mur> murs;
	private static ArrayList<Eau> eaux;
	private static ArrayList<Arbre> arbres;
	private static ArrayList<Gardien> gardiens;
	private static ArrayList<Intrus> intrus1;
	private Mur mur;
	private Eau eau;
	private Arbre arbre;
	private Gardien gardien;
	private Intrus intrus;
	private Font levelFont = new Font("SansSerif", Font.BOLD, 30);
	private FileWriter fw;
	private FileReader fr;
	
	public IhmPanel(){
		
		chargerLevel();
		setFocusable(true);
		addKeyListener(this);
		
		
	}
	
	public void chargerLevel(){
		
		try{
			
			fr = new FileReader ("Level"+ level + ".level");
			//fr = new FileReader ("Maps/Level" + level + ".level");
			
			int i = 0;
			int x=0, y = 0;
			
			murs = new ArrayList<Mur>();
			eaux = new ArrayList<Eau>();
			arbres = new ArrayList<Arbre>();
			gardiens = new ArrayList<Gardien>();
			intrus1 = new ArrayList<Intrus>();
			
			while((i = fr.read()) != -1){
				char strImg = (char) i;
				
				if(strImg == '0'){
					game[x][y] = "MUR";
					mur = new Mur(x * 34, y * 34);
					murs.add(mur);
				}
				
				else if(strImg == '1'){
					game[x][y] = "GARDIEN";
					gardien = new Gardien(x * 34, y * 34);
				}
				
				else if(strImg == '2'){
					game[x][y] = "INTRUS";
					intrus = new Intrus(x * 34, y * 34);
					intrus1.add(intrus);
				}
				
				else if(strImg == '3'){
					game[x][y] = "ARBRE";
					arbre = new Arbre(x * 34, y * 34);
					arbres.add(arbre);
				}
				
				else if(strImg == '4'){
					game[x][y] = "EAU";
					eau = new Eau(x * 34, y * 34);
					eaux.add(eau);
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
			mur = (Mur) murs.get(i);
			g2d.drawImage(mur.getMur(), mur.getX(), mur.getY(), null);
			
		}
		
		for(int i=0;i < arbres.size();i++){
			arbre = (Arbre) arbres.get(i);
			g2d.drawImage(arbre.getArbre(), arbre.getX(), arbre.getY(), null);
			
		}
		
		for(int i=0;i < eaux.size();i++){
			eau = (Eau) eaux.get(i);
			g2d.drawImage(eau.getEau(), eau.getX(), eau.getY(), null);
			
		}
		
		for(int i=0;i < intrus1.size();i++){
			intrus = (Intrus) intrus1.get(i);
			g2d.drawImage(intrus.getIntrus(), intrus.getX(), intrus.getY(), null);
			
		}
		
		try{
			
			g2d.drawImage(gardien.getGardien(), gardien.getX(), gardien.getY(), null);
			
			
		}catch(Exception ex){}
		
		g.setColor(Color.BLACK);
		g.setFont(levelFont);
		g.drawString("Level : " + level, 10, 25);
		
	}
	
	public void checkCollision(){
		
		
	}
	
	public void verifierLevelFini(){
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
