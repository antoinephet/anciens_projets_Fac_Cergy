package test2;
import java.io.*;
import org.w3c.dom.*;


import javax.xml.parsers.*;



public class Test {

	
	public static void main(String[] args) {
		try{
			
			String ligne;
			//creation des flux
			BufferedReader in=new BufferedReader(new FileReader("mairie-95012-01.xml"));
			//lecture et copie des donn�es
			try{
				BufferedWriter out=new BufferedWriter(new FileWriter("dist.xml"));
				
				try{	
					while((ligne=in.readLine())!=null){
					out.write(ligne);
					System.out.println(ligne);
					//ins�rer un saut de ligne d'une mani�re portable
					out.newLine();
					}
					out.flush(); //vider le buffer
				}finally{
					//fermeture de out
					out.close();
				}
			}
			finally{
				in.close();
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
	}


	}

