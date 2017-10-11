package modele;


import java.util.ArrayList;

import visiteurs.Visiteur;

public class Obstacle {

		protected int x;
	    protected int y;

		public Obstacle() {
			super();
		}

		public Obstacle(int x, int y) {
			this.x = x;
			 this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "Obstacle [x=" + x + ", y=" + y + "]";
		}
		void accepteVisiteur(Visiteur v) {
			v.visite(this);
		}

	}

