package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import donnees.JdbcUtilisateurAccess;
import donnees.Utilisateur;


import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Classe qui crée une fenêtre JDialog et permet d'ajouter et modifier les données des utilisateurs

public class UtilisateurDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTextField;
	private JTextField sexeTextField;
	private JTextField nomTextField;
	private JTextField prenomTextField;

	private JdbcUtilisateurAccess j;

	private IHM ihm;

	private Utilisateur tempUtilisateur = null;
	private boolean updateMode = false;

	// Constructeur
	public UtilisateurDialog(IHM ihm1,JdbcUtilisateurAccess user, Utilisateur u, boolean update) {
		this();
		j = user;
		ihm = ihm1;

		tempUtilisateur = u;
		
		updateMode = update;

		if (updateMode) {
			setTitle("Update Utilisateur");
			
			populateGui(tempUtilisateur);
		}
	}
	
	// constructeur
	public UtilisateurDialog(IHM ihm1,JdbcUtilisateurAccess u) {
		this(ihm1, u, null, false);
	}

	

	// crée le JDialog
	public UtilisateurDialog() {
		setTitle("Ajout utilisateur");
		setBounds(100, 100, 450, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));
		{
			JLabel lblID = new JLabel("ID");
			contentPanel.add(lblID, "2, 2, right, default");
		}
		{
			idTextField = new JTextField();
			contentPanel.add(idTextField, "4, 2, fill, default");
			idTextField.setColumns(10);
		}
		{
			JLabel lblSexe = new JLabel("Sexe");
			contentPanel.add(lblSexe, "2, 4, right, default");
		}
		{
			sexeTextField = new JTextField();
			contentPanel.add(sexeTextField, "4, 4, fill, default");
			sexeTextField.setColumns(10);
		}
		{
			JLabel lblNom = new JLabel("Nom");
			contentPanel.add(lblNom, "2, 6, right, default");
		}
		{
			nomTextField = new JTextField();
			contentPanel.add(nomTextField, "4, 6, fill, default");
			nomTextField.setColumns(10);
		}
		{
			JLabel lblPrenom = new JLabel("Prenom");
			contentPanel.add(lblPrenom, "2, 8, right, default");
		}
		{
			prenomTextField = new JTextField();
			contentPanel.add(prenomTextField, "4, 8, fill, default");
			prenomTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Enregistré");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sauvegarderUtilisateur();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annulez");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Annulez");
				buttonPane.add(cancelButton);
			}
		}
	}

	// méthode qui permet de sauvergarder les données de l'utilisateur
	protected void sauvegarderUtilisateur() {

		
		
		String id = idTextField.getText();
		String sexe = sexeTextField.getText();
		String nom = nomTextField.getText();

		String prenom = prenomTextField.getText();

		Utilisateur u = null;

		if (updateMode) {
			u = tempUtilisateur;
			
			u.setId(id);
			u.setSexe(sexe);
			u.setNom(nom);
			u.setPrenom(prenom);
			u = new Utilisateur(id, sexe, nom, prenom,"0","bd");
			
		} else {
			u = new Utilisateur(id, sexe, nom, prenom,"0","bd");
		}

		try {
			
			if (updateMode) {
				j.modifUtilisateur(u);
			} else {
				j.addUtilisateur(u);
			}

			
			setVisible(false);
			dispose();

			
			ihm.refreshUtilisateurs();

			
			JOptionPane.showMessageDialog(ihm,
					"Sauvegarde réussi.", "Utilisateur enregistré",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(ihm,
					"Erreur de sauvegarde: " + exc.getMessage(), "Erreur",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	private void populateGui(Utilisateur u) {

		idTextField.setText(u.getId());
		sexeTextField.setText(u.getSexe());
		nomTextField.setText(u.getNom());
		prenomTextField.setText(u.getPrenom());		
	}

}
