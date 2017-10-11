package pk_jdcb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Employee_info extends JFrame {

	private JPanel contentPane;
	private JTable table_Employe;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps= null;
	private JComboBox comboBox = new JComboBox();
	private JLabel lblNewLabel;
	private JTextField txt_employeid;
	private JLabel lblName;
	private JTextField txt_name;
	private JLabel lblSurname;
	private JLabel lblAge;
	private JTextField txt_age;
	private JTextField txt_surname;
	private JButton btnUpdate;
	private JTextField txt_search;
	private JTextField txt_pumpid;
	private JLabel lblNewLabel_1;
	private JLabel lblPressure;
	private JTextField txt_pressure;
	private JLabel lblTemperature;
	private JTextField txt_temperature;
	private JLabel lblVolume;
	private JTextField txt_volume;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_info frame = new Employee_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Employee_info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_Employe = new JTable();
		// quand on clik sur une donnée sur le Jtable, ça affiche dans Jtextfield
		table_Employe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					int row = table_Employe.getSelectedRow();
					String table_clik = (table_Employe.getModel().getValueAt(row, 0).toString());
					String sql = "select * from employeinfo where employeid='"+table_clik+"' ";
					ps=conn.prepareStatement(sql);
					
					rs=ps.executeQuery();
					if(rs.next()){
						
						String add1 = rs.getString("employeid");
						txt_employeid.setText(add1);
						String add2 = rs.getString("name");
						txt_name.setText(add2);
						String add3 = rs.getString("surname");
						txt_surname.setText(add3);
						String add4 = rs.getString("age");
						txt_age.setText(add4);
						
						
					}
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		table_Employe.setBounds(406, 36, 319, 183);
		contentPane.add(table_Employe);
		// quand on sélectionne dans Jcombobox, ça affiche dans Jtextfield
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
				String tmp = (String)comboBox.getSelectedItem();
				String sql ="select * from employeinfo where name=?";
				try{
					ps = conn.prepareStatement(sql);
					ps.setString(1, tmp);
					rs=ps.executeQuery();
					if(rs.next()){
						String add1 =rs.getString("employeid");
						txt_employeid.setText(add1);
						String add2 =rs.getString("name");
						txt_name.setText(add2);
						String add3 =rs.getString("surname");
						txt_surname.setText(add3);
						String add4 =rs.getString("age");
						txt_age.setText(add4);
					}
					
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		
		
		
		comboBox.setBounds(151, 36, 85, 20);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("employeid");
		lblNewLabel.setBounds(22, 94, 72, 14);
		contentPane.add(lblNewLabel);
		
		txt_employeid = new JTextField();
		txt_employeid.setBounds(130, 91, 86, 20);
		contentPane.add(txt_employeid);
		txt_employeid.setColumns(10);
		
		lblName = new JLabel("name");
		lblName.setBounds(22, 136, 64, 14);
		contentPane.add(lblName);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(130, 133, 86, 20);
		contentPane.add(txt_name);
		
		lblSurname = new JLabel("surname");
		lblSurname.setBounds(22, 167, 72, 14);
		contentPane.add(lblSurname);
		
		lblAge = new JLabel("age");
		lblAge.setBounds(22, 209, 72, 14);
		contentPane.add(lblAge);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(130, 206, 86, 20);
		contentPane.add(txt_age);
		
		txt_surname = new JTextField();
		txt_surname.setColumns(10);
		txt_surname.setBounds(130, 164, 86, 20);
		contentPane.add(txt_surname);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String sql ="insert into employeinfo(employeid,name ,surname ,age,username,password) VALUES (?,?,?,?,?, ?)";
					ps=conn.prepareStatement(sql);
					
					
					ps.setString(1,txt_employeid.getText());
					ps.setString(2,txt_name.getText());
					ps.setString(3,txt_surname.getText());
					ps.setString(4,txt_age.getText());
					ps.setString(5,"");
					ps.setString(6,"");
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Saved");
					
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
				Update_table();
			}
		});
		btnNewButton.setBounds(284, 90, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//
				
				try{
					
					String sql ="delete from employeinfo where employeid=?";
					ps=conn.prepareStatement(sql);
					
					ps.setString(1,txt_employeid.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Deleted");
					
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
				Update_table();
			}
		});
		btnNewButton_1.setBounds(284, 146, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{
					
					String value1 = txt_employeid.getText();
					String value2 = txt_name.getText();
					String value3 = txt_surname.getText();
					String value4 = txt_age.getText();
					String sql ="update employeinfo set employeid='"+value1+"' ,name ='"+value2+"' ,surname ='"+value3+"' ,age ='"+value4+"' where employeid='"+value1+"'  ";
					
					
					ps=conn.prepareStatement(sql);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Update");
					
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, e1);
					
				}
				Update_table();
				
			}
		});
		btnUpdate.setBounds(284, 205, 89, 23);
		contentPane.add(btnUpdate);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					
					String sql ="select * from employeinfo where name=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, txt_search.getText());
					rs=ps.executeQuery();
					if(rs.next()){
						
						String add1=rs.getString("employeid");
						txt_employeid.setText(add1);
						String add2=rs.getString("name");
						txt_name.setText(add2);
						String add3=rs.getString("surname");
						txt_surname.setText(add3);
						String add4=rs.getString("age");
						txt_age.setText(add4);
					}
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		txt_search.setBounds(10, 33, 117, 20);
		contentPane.add(txt_search);
		txt_search.setColumns(10);
		
		txt_pumpid = new JTextField();
		txt_pumpid.setBounds(150, 277, 86, 20);
		contentPane.add(txt_pumpid);
		txt_pumpid.setColumns(10);
		
		lblNewLabel_1 = new JLabel("pumpid");
		lblNewLabel_1.setBounds(22, 280, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		lblPressure = new JLabel("pressure");
		lblPressure.setBounds(22, 311, 72, 14);
		contentPane.add(lblPressure);
		
		txt_pressure = new JTextField();
		txt_pressure.setColumns(10);
		txt_pressure.setBounds(150, 308, 86, 20);
		contentPane.add(txt_pressure);
		
		lblTemperature = new JLabel("temperature");
		lblTemperature.setBounds(22, 342, 72, 14);
		contentPane.add(lblTemperature);
		
		txt_temperature = new JTextField();
		txt_temperature.setColumns(10);
		txt_temperature.setBounds(150, 339, 86, 20);
		contentPane.add(txt_temperature);
		
		lblVolume = new JLabel("volume");
		lblVolume.setBounds(22, 384, 72, 14);
		contentPane.add(lblVolume);
		
		txt_volume = new JTextField();
		txt_volume.setColumns(10);
		txt_volume.setBounds(150, 381, 86, 20);
		contentPane.add(txt_volume);
		
		btnNewButton_2 = new JButton("Pie Chart");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pressure = txt_pressure.getText();
				String temperature = txt_temperature.getText();
				String volume = txt_volume.getText();
				
				DefaultPieDataset pieDataset = new DefaultPieDataset();
				pieDataset.setValue("Pressure", new Integer(pressure));
				pieDataset.setValue("temperature", new Integer(temperature));
				pieDataset.setValue("volume", new Integer(volume));
				pieDataset.setValue("four", new Integer(40));
				
				JFreeChart chart = ChartFactory.createPieChart("Pie chart",pieDataset,true,true,true);
				
				PiePlot P=(PiePlot)chart.getPlot();
				ChartFrame frame = new ChartFrame("Pie Chart", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
				
			}
		});
		btnNewButton_2.setBounds(302, 280, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("freeChart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pressure = txt_pressure.getText();
				String temperature = txt_temperature.getText();
				String volume = txt_volume.getText();
				
				DefaultCategoryDataset ds = new DefaultCategoryDataset();
				ds.setValue(new Double(pressure), "Marks", "pressure");
				ds.setValue(new Double(temperature), "Marks", "temperature");
				ds.setValue(new Double(volume), "Marks", "volume");
		
			
				
				JFreeChart chart = ChartFactory.createBarChart3D("Pie chart","Student Name","Mark",ds,PlotOrientation.VERTICAL,false,rootPaneCheckingEnabled,rootPaneCheckingEnabled);
				CategoryPlot p= chart.getCategoryPlot();
				
				ChartFrame frame = new ChartFrame("Free Chart", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
				
			}
		});
		btnNewButton_3.setBounds(302, 338, 89, 23);
		contentPane.add(btnNewButton_3);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table_Employe}));
		
		conn =Javaconnect.connecdb();
		Update_table();
		Fillcombo();
	}
	
	// affiche les données dans le JTable
	private void Update_table(){
		
		try {
			String sql = "select * from employeinfo";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			table_Employe.setModel(DbUtils.resultSetToTableModel(rs));
			
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
	// remplit le jCombo à partir de la BDD
	private void Fillcombo(){
		
		try {
			String sql = "select * from employeinfo";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			
			while(rs.next()){
				String name = rs.getString("name");
				comboBox.addItem(name);
				
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, e1);
		}
		
		
	}
}
