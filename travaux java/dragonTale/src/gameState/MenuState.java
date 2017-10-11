package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TitleMap.Background;

public class MenuState extends GameState{
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Help",
		"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-.1, 0); // pour faire bouger l'arri�re plan grace a la classe Background
			
			
			titleColor = new Color(128,0,0);
			titleFont = new Font("Century Gothic",Font.PLAIN,28); // les codes de couleurs,taille et style du titre
			
			font = new Font("Arial", Font.PLAIN, 12); // style et taille des mots en dessous du titre
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		bg.update();
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		// draw bg
		bg.draw(g);
				
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Dragon Tale", 80, 70); // on met le titre + taille
		
				
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
				}
			else {
				g.setColor(Color.RED);
				}
				g.drawString(options[i], 145, 140 + i * 15); // style et position des mots
			}
		
	}
	
	

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			
			gsm.setState(GameStateManager.LEVEL1STATE);
			// start
		}
		if(currentChoice == 1) {
			// help
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}

}
