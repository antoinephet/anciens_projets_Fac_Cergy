package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textEnergie;
	private JTextField textNourriture;
	private JTextField textEnergieMax;

	private int energieMax;
	private int nourriture;
	private int energie;

	public Pam() {

		textEnergie = new JTextField(10);
		textNourriture = new JTextField(10);
		textEnergieMax = new JTextField(5);

		JButton buttonAdd = new JButton("OK");

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp4.setLayout(new BorderLayout());

		buttonAdd.addActionListener(new ActionOk());

		getContentPane().setLayout(new GridLayout(4, 1));

		jp1.add(new JLabel(" Pourcentage de nourriture     : "));
		jp1.add(textEnergie);

		jp2.add(new JLabel(" Pourcentage d'energie  : "));
		jp2.add(textNourriture);

		jp3.add(new JLabel(" Energie maximale  : "));
		jp3.add(textEnergieMax);

		jp4.add(buttonAdd, BorderLayout.EAST);

		getContentPane().add(jp1);
		getContentPane().add(jp2);
		getContentPane().add(jp3);
		getContentPane().add(jp4);

		pack();
		setVisible(true);
	}

	private class ActionOk implements ActionListener {

		public void actionPerformed(ActionEvent e) {
            
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			energieMax = Integer.valueOf(textEnergieMax.getText());
			energie = Integer.valueOf(textEnergie.getText());
			nourriture = Integer.valueOf(textNourriture.getText());
			
		}
	}

	public int getEnergieMax() {
		return energieMax;
	}

	public int getNourriture() {
		return nourriture;
	}

	public int getEnergie() {
		return energie;
	}
}
