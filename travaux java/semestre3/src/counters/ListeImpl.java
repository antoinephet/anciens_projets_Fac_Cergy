package counters;

public class ListeImpl implements Liste {

	/*
	 * Champs d'instance
	 */
	protected Object premier;
	protected ListeImpl reste;

	/*
	 * Champs de classe
	 */
	public static final ListeImpl LISTEVIDE = new ListeImpl();

	/*
	 * Constructeurs
	 */
	protected ListeImpl() {
	}
	protected ListeImpl(Object o, ListeImpl l) {
		premier = o;
		reste = l;
	}

	/*
	 * Les méthodes
	 */
    public static Liste creer() {
        return LISTEVIDE;
    }
    public Liste cons(Object o) {
        return new ListeImpl(o,this);
    }
    public boolean estVide() {
		/*
		 * a completer
		 */
    }
    public Object premier() {
		/*
		 * a completer
		 */
    }
    public Liste reste() {
		/*
		 * a completer
		 */
    }
    public String toString() {
		/*
		 * a completer
		 */
    }
    public Liste copy() {
		/*
		 * a completer
		 */
    }   
    public Liste concat(Liste l) {
		/*
		 * a completer
		 */
    }        
    public int longueur() {
		/*
		 * a completer
		 */
    }        
    public Liste ajouter(int n, Object o) {
		/*
		 * a completer
		 */
    }   
    public Liste retirer (int n) {
		/*
		 * a completer
		 */
    }   
    public Object nieme(int n) {
		/*
		 * a completer
		 */
    }

    /*
     * Programme de tests
     *
     */
    public static void main(String[] args) {
        Liste l1 = ListeImpl.creer();
        
        if (l1.estVide()) 
            System.out.println("Vide au depart");
        
        System.out.println();
        System.out.println("Liste de chaines de caracteres");    
        l1 = l1.cons("bonjour");
        l1 = l1.cons("monsieur");
        System.out.println("l1 = " + l1);
    
        System.out.println();
        System.out.println("Copie d'une liste");    
                Liste l2 = ListeImpl.creer();
        l2 = l1.copy();
        System.out.println("l2 = " + l2);    
    
        System.out.println();
        System.out.println("Lecture des elements de la liste l1"); 
        while (!l1.estVide()) {
            System.out.println(l1.premier());
            l1 = l1.reste();
        }

        System.out.println();
        System.out.println("Concatenation de deux listes");
        Liste l3 = ListeImpl.creer();
        l3 = l3.cons("c'est la pause...:-)");
        System.out.println("l3 = " + l3);    
        Liste l4 = ListeImpl.creer();
        l4 = l4.cons("Il est l'heure ?!?");
        System.out.println("l4 = " + l4);    
        Liste l5 = ListeImpl.creer();
        l5 = l3.concat(l4);
        System.out.println("l5 = " + l5);

        System.out.println();
        System.out.println("Liste d'entiers");
        Liste l6 = ListeImpl.creer();
        l6 = l6.cons(new Integer(7));
        l6 = l6.cons(new Integer(6));
        l6 = l6.cons(new Integer(5));
        l6 = l6.cons(new Integer(2));
        l6 = l6.cons(new Integer(4));
        l6 = l6.cons(new Integer(1));
        System.out.println("l6 = " + l6);
        System.out.println("Longueur de la liste l6: " + l6.longueur());
        System.out.println("Le 3eme element est: " + l6.nieme(3));

        System.out.println();
        System.out.println("Ajout de la valeur '33' en position 3");    
        l6 = l6.ajouter(3,new Integer(33));
        System.out.println("l6 = " + l6);
        System.out.println("Longueur de la liste l6: " + l6.longueur());
        System.out.println("Le 3eme element est: " + l6.nieme(3));
    
        System.out.println();
        System.out.println("Le 5eme element est: " + l6.nieme(5));    
        System.out.println("Retrait de la valeur en position 5");    
        l6 = l6.retirer(5);
        System.out.println("l6 = " + l6);    
        System.out.println("Longueur de la liste l6: " + l6.longueur());
        System.out.println("Le 5eme element est: " + l6.nieme(5));
       
        System.out.println();
        System.out.println("Fin de l'execution du programme !!!");
    } // fin du programme de tests
} // fin de la classe
