package donnees;

//Classe Temps qui constitue ses informations
public class Temps {
	
	private String id;
	private int heure;
	private int minute;
	private int seconde;
	
	public Temps() {
		
	}

	public Temps(String id, int heure, int minute, int seconde) {
		
		this.id = id;
		this.heure = heure;
		this.minute = minute;
		this.seconde = seconde;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSeconde() {
		return seconde;
	}

	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}

	@Override
	public String toString() {
		return "Temps [id=" + id + ", heure=" + heure + ", minute=" + minute
				+ ", seconde=" + seconde + "]";
	}
	
	
	

}
