package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JComboBox;

import net.proteanit.sql.DbUtils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import donnees.JDBCconnect;
import donnees.JdbcUtilisateurAccess;
import donnees.Utilisateur;
import donnees.UtilisateurTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


// c'est la classe qui représente l'interfrace principale
public class IHM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps= null;
	
	private JdbcUtilisateurAccess u;
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_1 = new JComboBox();
	
	
	JLabel image = new JLabel(new ImageIcon("sport.jpg"));
	private JTextField txt_max;
	private JTextField txt_min;
	private JTable table_1;
	private JTextField txt_id;

	// lance l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM frame = new IHM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crée le JFrame
	public IHM() {
		
		
		try {
			u = new JdbcUtilisateurAccess();
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
			}
		
		
		setTitle("Statistiques Sport");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vos donn\u00E9es personnelles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 193, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblSaisirUneDonne = new JLabel("Saisir une donn\u00E9e :");
		lblSaisirUneDonne.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaisirUneDonne.setBounds(10, 58, 107, 14);
		contentPane.add(lblSaisirUneDonne);
		
		textField = new JTextField();
		textField.setBounds(127, 56, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// image importé
		contentPane.add(image);
	    image.setBounds(1050,300,252,211);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setBounds(310, 55, 114, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// saisir le nom dans le textfield
				// Si le champ est vide, on affiche tous les utilisateurs		
				
				try {
					String nom = textField.getText();

					List<Utilisateur> users = null;

					if (nom != null && nom.trim().length() > 0) {
						users = u.rechercheUtilisateur(nom);
					} else {
						users = u.getUtlisateurs();
					}
					
					// on créé le TableModel
					UtilisateurTableModel model = new UtilisateurTableModel(users);
					
					table.setModel(model);
					
				
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(IHM.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		
		//  AJOUTER utilisateur
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBounds(310, 15, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// crée le JDialog
				UtilisateurDialog dialog = new UtilisateurDialog(IHM.this, u);

				// affichage
				dialog.setVisible(true);
			}
		});
		
		// modification utilisateur
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// avoir la ligne sélectionné
				int row = table.getSelectedRow();
				
				// erreur si ligne non sélectionné
				if (row < 0) {
					JOptionPane.showMessageDialog(IHM.this, "Vous devez sélectionner un utilisateur", "Erreur",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				// get the current utilisateur
				Utilisateur tempUtilisateur = (Utilisateur) table.getValueAt(row, UtilisateurTableModel.OBJECT_COL);
				
				// crée le Jdialog
				UtilisateurDialog dialog = new UtilisateurDialog(IHM.this, u, 
															tempUtilisateur, true);

				// affiche le Jdialog
				dialog.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(427, 15, 89, 23);
		contentPane.add(btnNewButton_2);
		
		// SUPPRIMER utilisateur
		JButton btnNewButton_3 = new JButton("Supprimer");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					// avoir la ligne sélectionné
					int row = table.getSelectedRow();

					// message erreur si ligne non séléectionné
					if (row < 0) {
						JOptionPane.showMessageDialog(IHM.this, 
								"vous devez sélectionner un utilisateur", "Error", JOptionPane.ERROR_MESSAGE);				
						return;
					}

					// demande à l'utilisateur si oui ou non de supprimer les données
					int response = JOptionPane.showConfirmDialog(
							IHM.this, "voulez vous supprimé l'utilisateur ?", "Confirmer ?", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response != JOptionPane.YES_OPTION) {
						return;
					}

					
					Utilisateur tempUtilisateur = (Utilisateur) table.getValueAt(row, UtilisateurTableModel.OBJECT_COL);

					// supprime l'utilisateur
					u.supprimeUtilisateur(tempUtilisateur.getId());

					// rafraichit le Jframe
					refreshUtilisateurs();

					// affiche le message réussi
					JOptionPane.showMessageDialog(IHM.this,
							"utlisateur supprimé .", "utilisateur supprimé",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception exc) {
					JOptionPane.showMessageDialog(IHM.this,
							"Erreur de suppression utilisateur: " + exc.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(548, 15, 107, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Quitter");
		btnNewButton_4.setBounds(684, 15, 89, 23);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}		
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 763, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// jCOMbo
		comboBox.setBounds(1005, 15, 141, 22);
		contentPane.add(comboBox);
		
		
		comboBox_1.setBounds(1005, 70, 141, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblSport = new JLabel("sport :");
		lblSport.setBounds(892, 18, 56, 16);
		contentPane.add(lblSport);
		
		JLabel lblExercice = new JLabel("exercice : ");
		lblExercice.setBounds(892, 72, 77, 16);
		contentPane.add(lblExercice);
		
		JLabel lblVotreVitesse = new JLabel("Votre Vitesse : ");
		lblVotreVitesse.setBounds(53, 339, 101, 14);
		contentPane.add(lblVotreVitesse);
		
		JLabel lblVitesseMax = new JLabel("Vitesse max");
		lblVitesseMax.setBounds(53, 409, 83, 14);
		contentPane.add(lblVitesseMax);
		
		JLabel lblVitesseMin = new JLabel("Vitesse min :");
		lblVitesseMin.setBounds(53, 444, 83, 14);
		contentPane.add(lblVitesseMin);
		
		txt_max = new JTextField();
		txt_max.setBounds(146, 406, 86, 20);
		contentPane.add(txt_max);
		txt_max.setColumns(10);
		
		txt_min = new JTextField();
		txt_min.setColumns(10);
		txt_min.setBounds(146, 441, 86, 20);
		contentPane.add(txt_min);
		
		// ajout données vitesse
		JButton ajout_vit = new JButton("Ajouter");
		ajout_vit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String sql ="insert into vitesse(id_vitesse,vitesseMax ,vitesseMin) VALUES (?,?,?)";
					ps=conn.prepareStatement(sql);
					
					
					ps.setString(1,txt_id.getText());
					ps.setString(2,txt_max.getText());
					ps.setString(3,txt_min.getText());
				
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Ligne ajoutée");
					
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
				Update_table();
			}
		});
		ajout_vit.setBounds(47, 488, 89, 23);
		contentPane.add(ajout_vit);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					int row = table_1.getSelectedRow();
					String table_clik = (table_1.getModel().getValueAt(row, 0).toString());
					String sql = "select * from vitesse where id_vitesse='"+table_clik+"' ";
					ps=conn.prepareStatement(sql);
					
					rs=ps.executeQuery();
					if(rs.next()){
						
						String add1 = rs.getString("id_vitesse");
						txt_id.setText(add1);
						String add2 = rs.getString("vitesseMax");
						txt_max.setText(add2);
						String add3 = rs.getString("vitesseMin");
						txt_min.setText(add3);
						
						
						
					}
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		table_1.setBounds(275, 367, 239, 102);
		contentPane.add(table_1);
		
		// modification données vitesse
		JButton modif_vit = new JButton("Modifier");
		modif_vit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String valeur1 = txt_id.getText();
					String valeur2 = txt_max.getText();
					String valeur3 = txt_min.getText();
					String sql ="update vitesse set id_vitesse='"+valeur1+"' ,vitesseMax ='"+valeur2+"' ,vitesseMin ='"+valeur3+"' where id_vitesse='"+valeur1+"'  ";
					
					
					ps=conn.prepareStatement(sql);
					ps.execute();
					JOptionPane.showMessageDialog(null, "mise à jour");
					
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
				Update_table();
			}
		});
		modif_vit.setBounds(158, 488, 89, 23);
		contentPane.add(modif_vit);
		
		
		// suppression données vitesse
		JButton supp_vit = new JButton("Supprimer");
		supp_vit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String sql ="delete from vitesse where id_vitesse=?";
					ps=conn.prepareStatement(sql);
					
					ps.setString(1,txt_id.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Ligne supprimée");
					
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
				Update_table();
			}
		});
		supp_vit.setBounds(272, 488, 107, 23);
		contentPane.add(supp_vit);
		
		// statistiques camembert
		JButton stats_vit = new JButton("Pie Chart");
		stats_vit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String max = txt_max.getText();
				String min = txt_min.getText();
				
				
				DefaultPieDataset pieDataset = new DefaultPieDataset();
				pieDataset.setValue("Vitesse max", new Double(max));
				pieDataset.setValue("Vitesse min", new Double(min));
				//pieDataset.setValue("volume", new Integer(volume));
				//pieDataset.setValue("four", new Integer(40));
				
				JFreeChart chart = ChartFactory.createPieChart("Vos statistiques",pieDataset,true,true,true);
				
				PiePlot P=(PiePlot)chart.getPlot();
				ChartFrame frame = new ChartFrame("Vos statistiques", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
			}
		});
		stats_vit.setBounds(47, 535, 89, 23);
		contentPane.add(stats_vit);
		
		// statistiques histogramme
		
		JButton stats_vit1 = new JButton("Bar Chart");
		stats_vit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String max = txt_max.getText();
				String min = txt_min.getText();
				
				DefaultCategoryDataset ds = new DefaultCategoryDataset();
				ds.setValue(new Double(max), "Marks", "Vitesse max");
				ds.setValue(new Double(min), "Marks", "Vitesse min");
				
		
			
				
				JFreeChart chart = ChartFactory.createBarChart3D("Vos statistiques","absicisse","ordonnée",ds,PlotOrientation.VERTICAL,false,rootPaneCheckingEnabled,rootPaneCheckingEnabled);
				CategoryPlot p= chart.getCategoryPlot();
				
				ChartFrame frame = new ChartFrame("Vos statistiques", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
			}
		});
		stats_vit1.setBounds(158, 535, 89, 23);
		contentPane.add(stats_vit1);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(146, 364, 86, 20);
		contentPane.add(txt_id);
		
		JLabel lblIdVitesse = new JLabel("id vitesse");
		lblIdVitesse.setBounds(53, 367, 83, 14);
		contentPane.add(lblIdVitesse);
		
		conn =JDBCconnect.connectbd();
		rempliJcombo();
		rempliJcombo1();
		Update_table();
	}
	
	// Dans le JTable, crée un TableModel et rafraichit
	public void refreshUtilisateurs() {

		try {
			List<Utilisateur> users = u.getUtlisateurs();

			
			UtilisateurTableModel model = new UtilisateurTableModel(users);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	// affiche les noms des sports dans le 1er JCOmbo
	private void rempliJcombo(){
		
		try {
			String sql = "select * from sport";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			
			while(rs.next()){
				String nom = rs.getString("nom_sport");
				comboBox.addItem(nom);
				
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, e1);
		}
		
		
	}
	
	// affiche les types d'exercice dans le 2e JCOmbo
	
	private void rempliJcombo1(){
		
		try {
			String sql = "select * from exercice";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			
			while(rs.next()){
				String nom = rs.getString("type_execice");
				comboBox_1.addItem(nom);
				
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, e1);
		}
		
		
	}
	
	// rafraichit le 2e JTable et affiche les données
		private void Update_table(){
			
			try {
				String sql = "select * from vitesse";
				ps=conn.prepareStatement(sql);
				
				rs=ps.executeQuery();
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null, e1);
			} finally {
				try{
					rs.close();
					ps.close();
					
				}catch(Exception e){
					
				}
			}
			
		}
}
