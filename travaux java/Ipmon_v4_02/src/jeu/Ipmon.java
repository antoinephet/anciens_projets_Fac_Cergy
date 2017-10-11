package jeu;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Ipmon extends ChoseAbstraite{
	
	private Image ipmon;
	private ImageIcon iIpmon = new ImageIcon();
	private ArrayList<String> noms = new ArrayList<String>();
	private String nom = "Inconnu";
	private String preference;
	private int vieBase;
	private int vieActuelle;
	private int force;
	
	
	public Ipmon() {}
	
	public Ipmon(int x, int y) {
		super(x, y);		
		ipmon = iIpmon.getImage();
		listeNomsIpmonsDefaut();
		
		vieBase = (int) (Math.random() * 150 +90);
		vieActuelle = vieBase;
		force = (int) (Math.random() * 70 +30);
		int random=(int) (Math.random() * 7 );     //Pour un entier entre 0 et 7;
		for (int i=0; i<noms.size();i++){
			if (random == i) {
				nom = noms.get(i);
				ImageIcon iIpmon = new ImageIcon("images/" + nom + ".png");
				ipmon = iIpmon.getImage();
			}
		}
		
		if (nom.equals("Salamèche")) preference ="Manger";
		else if (nom.equals("Carapuce")) preference ="Grimace";
		else if (nom.equals("Pikachu")) preference ="Câlin";
		else if (nom.equals("Evoli")) preference ="Câlin";
		else if (nom.equals("Chetiflore")) preference ="Grimace";
		else if (nom.equals("Pichu")) preference ="Câlin";
		else if (nom.equals("Onix")) preference ="Manger";
	}
	
	public void isCapture(){
		iIpmon = new ImageIcon("");
		ipmon = iIpmon.getImage();
	}
	
	public ImageIcon imageIpmon(){ return iIpmon;}
	
	public String getNom() { return nom;}
	
	public void setNom(String n) { this.nom = n;}
	
	public String getPreference() { return preference;}
	
	public void setPreference (String preference) { this.preference = preference;}
	
	public int getVie() { return vieActuelle;}
	
	public int getVieBase() { return vieBase;}
	
	public void setVie (int vie) { this.vieActuelle = vie;}
	
	public int getForce() { return force;}
	
	public void setForce (int force) { this.force = force;}
	
	public void ajoutNomIpmon(String ipmon){ noms.add(ipmon);}
	
	public ArrayList<String> listeNomsIpmons(){	return noms;}
	
	public void listeNomsIpmonsDefaut(){
		noms.add("Salamèche");
		noms.add("Carapuce");
		noms.add("Pikachu");
		noms.add("Evoli");
		noms.add("Chetiflore");
		noms.add("Pichu");
		noms.add("Onix");
	}
	
	public Image getIpmon(){ return ipmon;}
	
	@Override
	public String toString() {
		return nom + " - Vie : " + vieActuelle + " - Force : " + force;
	}
}
