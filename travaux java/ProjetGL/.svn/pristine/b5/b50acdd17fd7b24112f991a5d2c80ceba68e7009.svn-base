package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Grid {
	
	String grid[][];
	int nbLine,nbColumn,nb;
	private static ArrayList<Wall> walls;
	private static ArrayList<Water> waters;
	private static ArrayList<Tree> trees;
	
	boolean choiceGuardian1;
	boolean choiceGuardian2;
	boolean choiceGuardian3;
	boolean choiceGuardian4;
	
	Guardian guardian;
	Intruder intruder;
	Wall wall;
	Tree tree;
	Water water;
	FileReader fr;
	
	
	public Grid(int nbLine,int nbColumn, int nb) {
		
		this.nbLine = nbLine;
		this.nbColumn = nbColumn;
		this.nb = nb;
	}
	
	// int choice = (int)(Math.random()*4+1);
	
	public Grid(int line,int column) {
		
		
		System.out.println("What kind of choice you pick dimensions for your screen ?\n1) Random\n2) Manual");
		Scanner sc1 = new Scanner(System.in);
		int choice = sc1.nextInt() ;
		
		switch (choice){
		
		// random choice between 1 and 3
		case 1 : int choice1 = (int)(Math.random()*2+1);
		
		switch (choice1){
		
		case 1 : nbLine = nbColumn = 12;
		System.out.println("you pick 12x12");
		break ; 
						
		case 2 : nbLine = nbColumn = 16;
		System.out.println("you pick 16x16");
		break ; 
						
		case 3 : nbLine = nbColumn = 20;
		System.out.println("you pick 20x20");
		break ;
					
		default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
		
		}
		break ; 
		
		// manual choice 
		case 2 : System.out.println("Choose game's size :\n1)12x12\n2)16x16\n3)20x20");
		Scanner sc2 = new Scanner(System.in);
		int choice2 = sc2.nextInt() ;
		
		switch (choice2){
		
		case 1 : nbLine = nbColumn = 12;
		System.out.println("you pick 12x12");
		break ; 
						
		case 2 : nbLine = nbColumn = 16;
		System.out.println("you pick 16x16");
		break ; 
						
		case 3 : nbLine = nbColumn = 20;
		System.out.println("you pick 20x20");
		break ;
					
		default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
		
		}
		break ;
					
		default : System.out.println("Erreur!! Choisissez un autre chiffre svp");
		
		}
		
		
		
		
		grid = new String[nbLine][nbColumn];
	}
	
	public void load(){
		
		try{
			
			if(nbLine==12 && nbColumn==12){
				
				fr = new FileReader("Maps/Map1.txt");
				
			}
			
			if(nbLine==16 && nbColumn==16){
				
				fr = new FileReader("Maps/Map2.txt");
				
			}
			
			if((nbLine==20) && (nbColumn==20)){
				
				fr = new FileReader("Maps/Map3.txt");
				
			}
			
			
			
			//fr = new FileReader ("Maps/Level" + level + ".level");
			
			int i = 0;
			int x=0, y = 0;
			
			walls = new ArrayList<Wall>();
			waters = new ArrayList<Water>();
			trees = new ArrayList<Tree>();
			
			while((i = fr.read()) != -1){
				char conv = (char) i;
				
				if(conv == '0'){
					grid[x][y] = "W";
					wall = new Wall(x, y);
					walls.add(wall);
					
				}
				
				else if(conv == '1'){
					
					grid[x][y] = "T";
					tree = new Tree(x, y);
					trees.add(tree);
				}
				
				else if(conv == '2'){
					grid[x][y] = "A";
					water = new Water(x, y);
					waters.add(water);
				}
				
				else if(conv == '3'){
					
					grid[x][y] = "G";
					guardian = new Guardian(x, y);
					
				}
				
				else if(conv == '4'){
					grid[x][y] = "S";
					guardian = new Guardian(x, y);
					
				}
				
				else if(conv == '5'){
					grid[x][y] = "C";
					guardian = new Guardian(x, y);
					
				}
				
				else if(conv == '6'){
					grid[x][y] = "P";
					guardian = new Guardian(x, y);
					
				}
				
				else if(conv == '7'){
					grid[x][y] = "I";
					intruder = new Intruder(x, y);
					
				}
				
				else if(conv == '8'){
					grid[x][y] = "R";
					intruder = new Intruder(x, y);
					
				}
				
				else if(conv == '9'){
					grid[x][y] = "E";
					intruder = new Intruder(x, y);
					
				}
				
				else if(conv == ' '){
					grid[x][y] = " ";
				}
				else if(conv == '\r' || conv == '\n'){
					x--;
				}
				
				if(x == nbLine-1){ //11
					y++;
					x=0;
				}
				else {
					x++;
				}
				
			}
			
		}catch(Exception ex){}
		
	}
	
	public void display(){
		
		System.out.println();
		for (int i=0  ; i<nbLine ; i++){
			for(int j=0 ; j<nbColumn ; j++){
				System.out.print(" |  " + grid[i][j] );
				
			}
			System.out.println(" | ");
		
		} 
		System.out.println();
		
	}
	
	public void moveUp(){
		
		String tmp ;
		choiceGuardian1 = true;
		
		for(int i = 0;i<nbLine;i++){
			// guardian 1
			for(int j = 0;j<nbColumn;j++){
				if(grid[i][j] == "G" && choiceGuardian1){ // finding player
					if(i-1 >=0 && grid[i-1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "I"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "R"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "E"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}
					
				}
				// guardian 2
				if(grid[i][j] == "S" && choiceGuardian2){ // finding player
					if(i-1 >=0 && grid[i-1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "I"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "R"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "E"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}
					
				}
				
				// guardian 3
				if(grid[i][j] == "C" && choiceGuardian3){ // finding player
					if(i-1 >=0 && grid[i-1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "I"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "R"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "E"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}
					
				}
				// guardian 4
				if(grid[i][j] == "P" && choiceGuardian4){ // finding player
					if(i-1 >=0 && grid[i-1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "I"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "R"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 >=0 && grid[i-1][j] == "E"){
						grid[i-1][j] = " ";
						spottedCollision();
						
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}
					
				}
				// intruder 1
				if(grid[i][j] == "I"){//  finding intruder
					if(i-1 >=0 && grid[i-1][j] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}


				}
				// intruder 2
				if(grid[i][j] == "R"){//  finding intruder
					if(i-1 >=0 && grid[i-1][j] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}


				}
				// intruder 3
				if(grid[i][j] == "E"){//  finding intruder
					if(i-1 >=0 && grid[i-1][j] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i-1][j] = tmp; // moving character
						
					}if(i-1 >=0 && grid[i-1][j] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 >=0 && grid[i-1][j] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(i-1 <= nbLine || grid[i-1][j] == "T" || grid[i-1][j] == "A" || grid[i-1][j] == "W"){
						
						obstacleCollision();
						
						
					}


				}
				
			}
		}
		
		
		
	}
	
	public void moveDown(){
		
		choiceGuardian1 = true;
		
		String tmp ;
		for(int i = 0;i<nbLine;i++){
			for(int j = 0;j<nbColumn;j++){
				
				if(grid[i][j] == "G" && choiceGuardian1){ // finding player
					if(i+1 <= nbLine && grid[i+1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
					}if(i+1 <=nbLine && grid[i+1][j] == "I"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "R"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "E"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}
				// guardian 2
				if(grid[i][j] == "S" && choiceGuardian2){ // finding player
					if(i+1 <= nbLine && grid[i+1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
					}if(i+1 <=nbLine && grid[i+1][j] == "I"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "R"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "E"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}
				// guardian 3
				if(grid[i][j] == "C" && choiceGuardian3){ // finding player
					if(i+1 <= nbLine && grid[i+1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
					}if(i+1 <=nbLine && grid[i+1][j] == "I"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "R"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "E"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}
				// guardian 4
				if(grid[i][j] == "P" && choiceGuardian4){ // finding player
					if(i+1 <= nbLine && grid[i+1][j] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
					}if(i+1 <=nbLine && grid[i+1][j] == "I"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "R"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <=nbLine && grid[i+1][j] == "E"){
						grid[i+1][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}
				// intruder 1
				if(grid[i][j] == "I"){// finding intruder
					if(i+1 <= nbLine && grid[i+1][j] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
						
					}if(i+1 <= nbLine && grid[i+1][j] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <= nbLine && grid[i+1][j] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine && grid[i+1][j] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine && grid[i+1][j] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}
				// intruder 2
				if(grid[i][j] == "R"){// finding intruder
					if(i+1 <= nbLine && grid[i+1][j] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
						
					}if(i+1 <= nbLine && grid[i+1][j] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <= nbLine && grid[i+1][j] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine && grid[i+1][j] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine && grid[i+1][j] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}
				// intruder 3
				if(grid[i][j] == "E"){// finding intruder
					if(i+1 <= nbLine && grid[i+1][j] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i+1][j] = tmp; // moving character
						return;
						
					}if(i+1 <= nbLine && grid[i+1][j] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}if(i+1 <= nbLine && grid[i+1][j] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine && grid[i+1][j] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine && grid[i+1][j] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						return;
						
					}
					if(i+1 <= nbLine || grid[i+1][j] == "T" || grid[i+1][j] == "A" || grid[i+1][j] == "W"){
						
						obstacleCollision();
						return;
						
					}


				}

			}

		}
	
	}
	
	public void moveLeft(){
		
		choiceGuardian1 = true;
		
		String tmp ;
		for(int i = 0;i<nbLine;i++){
			for(int j = 0;j<nbColumn;j++){
				// guardian 1
				if(grid[i][j] == "G" && choiceGuardian1){ // finding player
					if(j-1 >=0 && grid[i][j-1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "I"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "R"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "E"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}
				// guardian 2
				if(grid[i][j] == "S" && choiceGuardian2){ // finding player
					if(j-1 >=0 && grid[i][j-1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "I"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "R"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "E"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}
				// guardian 3
				if(grid[i][j] == "C" && choiceGuardian3){ // finding player
					if(j-1 >=0 && grid[i][j-1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "I"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "R"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "E"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}
				// guardian 4
				if(grid[i][j] == "P" && choiceGuardian4){ // finding player
					if(j-1 >=0 && grid[i][j-1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "I"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "R"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "E"){
						grid[i][j-1] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}
				
				// intruder 1
				if(grid[i][j] == "I"){// finding intruder
					if(j-1 >=0 && grid[i][j-1] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}
				// intruder 2
				if(grid[i][j] == "R"){// finding intruder
					if(j-1 >=0 && grid[i][j-1] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}
				// intruder 3 
				if(grid[i][j] == "E"){// finding intruder
					if(j-1 >=0 && grid[i][j-1] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j-1] = tmp; // moving character
						
					}if(j-1 >=0 && grid[i][j-1] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						
					}if(j-1 >=0 && grid[i][j-1] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						
					}
					if(j-1 >=0 || grid[i][j-1] == "T" || grid[i][j-1] == "A" || grid[i][j-1] == "W"){
						
						obstacleCollision();
						
					}

				}

			}

		}
	
	}
	
	public void moveRight(){
		
		choiceGuardian1 = true;
		
		String tmp ;
		for(int i = 0;i<nbLine;i++){
			for(int j = 0;j<nbColumn;j++){
				if(grid[i][j] == "G" && choiceGuardian1){ // finding player
					if(j+1 <=nbColumn && grid[i][j+1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "I"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "R"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "E"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}
					
				}
				// guardian 2
				if(grid[i][j] == "S" && choiceGuardian2){ // finding player
					if(j+1 <=nbColumn && grid[i][j+1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "I"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "R"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "E"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}
					
				}
				// guardian 3
				if(grid[i][j] == "C" && choiceGuardian3){ // finding player
					if(j+1 <=nbColumn && grid[i][j+1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "I"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "R"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "E"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}
					
				}
				
				// guardian 4
				if(grid[i][j] == "P" && choiceGuardian4){ // finding player
					if(j+1 <=nbColumn && grid[i][j+1] == " "){ // checking player's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "I"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "R"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "E"){
						grid[i][j+1] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}
					
				}
				
				// intruder 1
				
				if(grid[i][j] == "I"){// finding intruder
					if(j+1 <=nbColumn && grid[i][j+1] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}

				}
				
				// intruder 2
				if(grid[i][j] == "R"){// finding intruder
					if(j+1 <=nbColumn && grid[i][j+1] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}

				}
				// intruder 3
				if(grid[i][j] == "E"){// finding intruder
					if(j+1 <=nbColumn && grid[i][j+1] == " "){// checking intruder's position
						tmp = grid[i][j];
						grid[i][j] = " "; // removing this case
						grid[i][j+1] = tmp; // moving character
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "G"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "S"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "C"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}if(j+1 <=nbColumn && grid[i][j+1] == "P"){
						grid[i][j] = " ";
						spottedCollision();
						break;
						
					}
					if(j+1 <=nbColumn || grid[i][j+1] == "T" || grid[i][j+1] == "A" || grid[i][j+1] == "W"){
						
						obstacleCollision();
						break;
					}

				}
			}

		}
		
	}
	
	public void randomMove(){
		choiceGuardian1 = true; choiceGuardian2 = true;choiceGuardian3 = true;choiceGuardian4 = true;
		int i=0;
		
		//(int)(Math.random()*4+1);
		while(i<100){
			
			// choosing random number between 1 and 4
			int choice = (int)(Math.random()*4+1);
			
			switch (choice){
			
			case 1 : moveUp();
			break ; 
							
			case 2 : moveDown();
			break ; 
							
			case 3 : moveLeft();
			break ; 
							
			case 4 : moveRight();
			break ;  
						
			default : System.out.println("Error!! Choose an other number please!");
			
			}
			
			try {
				// refresh the screen
				Runtime.getRuntime().exec("cmd /c cls");
				Thread.sleep(2000);
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			// update the grid
			display();
			i++;
			
		}
		
	}
	
	public void manualMove(){
		
		int i=0;
		
		//String str = sc1.nextLine();
		
		//(int)(Math.random()*4+1);
		while(i<100){
			
			System.out.println("What direction ?\n\n1 : up\n2 : down \n3 : left\n4 : right\n5 : choose an other guardian\n6 : quit ");
			Scanner sc1 = new Scanner(System.in);
			int choice = sc1.nextInt() ;
			
			switch (choice){
			
			case 1 : moveUp(); 
			break ; 
							
			case 2 : moveDown();
			break ; 
							
			case 3 : moveLeft();
			break ; 
							
			case 4 : moveRight();
			break ; 
			
			case 5 : System.out.println("Choose your guardian\n\n1 : guardian n°1\n2 : guardian n°2\n3 : guardian n°3\n4 : guardian n°4");
			Scanner sc2 = new Scanner(System.in);
			int choice1 = sc2.nextInt() ;
			switch (choice1){
			
			case 1 : choiceGuardian1 = true; choiceGuardian2 = false;choiceGuardian3 = false;choiceGuardian4 = false;
			break;
			
			case 2 : choiceGuardian1 = false; choiceGuardian2 = true;choiceGuardian3 = false;choiceGuardian4 = false;
			break;
			
			case 3 : choiceGuardian1 = false; choiceGuardian2 = false;choiceGuardian3 = true;choiceGuardian4 = false;
			break;
			
			case 4 : choiceGuardian1 = false; choiceGuardian2 = false;choiceGuardian3 = false;choiceGuardian4 = true;
			break;
			
			default : System.out.println("Error!! Choose an other number please!");
			}
			break ;
			
			case 6 :i=100 ; 
			break ;
						
			default : System.out.println("Error!! Choose an other number please!");
			
			}
			try {
				// refresh screen
				Runtime.getRuntime().exec("cmd /c cls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// update the grid
			display();
			i++;
			
		}
		
	}
	
	public void spottedCollision(){
		
		System.out.println("\n Alert collision! Guardian spotted and caught an enemy!!");
		
	}

	public void obstacleCollision(){
		
		System.out.println("\n Alert collision! Guardian or intruder can't pass through!");
	
	}
	
	
	
	
	
	

}
