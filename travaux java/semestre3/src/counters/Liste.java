package counters;

public interface Liste {

	/**
	 *
	 * Fonctionnalites de base : (de-)construction
	 *
	 */
	public Liste cons(Object o);
	public Object premier();
	public Liste reste();
	public boolean estVide();

	/**
	 *
	 * Fonctions classiques
	 *
	 */ 
	public int longueur();
	public Liste ajouter(int n, Object o);
	public Liste retirer (int n);
	public Object nieme(int n);

	/**
	 *
	 * Fonctions supplementaires
	 *
	 */
	public Liste copy();
	public Liste concat(Liste l);

}