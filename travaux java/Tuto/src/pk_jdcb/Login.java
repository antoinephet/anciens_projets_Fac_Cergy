package pk_jdcb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps= null;
	private JPanel contentPane;
	private JTextField txt_username;
	private JLabel lblPassword;
	private JPanel panel;
	private JPasswordField txt_password;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(203, 117, 197, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(6, 19, 54, 14);
		panel.add(lblNewLabel);
		
		txt_username = new JTextField();
		txt_username.setBounds(86, 16, 86, 20);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(6, 56, 46, 14);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = "select * from employeinfo where username=? and password=?";
				
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, txt_username.getText());
					ps.setString(2, txt_password.getText());
					rs=ps.executeQuery();
					if(rs.next()){
						
						JOptionPane.showMessageDialog(null, "Username and Password are correct");
						rs.close();
						ps.close();
						close();
						Employee_info frame = new Employee_info();
						frame.setVisible(true);
						
					}else{
						JOptionPane.showMessageDialog(null, "Username and Password are not correct");
					}
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);
				}finally {
					try{
						rs.close();
						ps.close();
						
					}catch(Exception e){
						
					}
				}
			}
		});
		btnNewButton.setBounds(98, 102, 89, 23);
		panel.add(btnNewButton);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(86, 53, 86, 20);
		panel.add(txt_password);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PHETRAMPHAND\\workspace\\Tuto\\sport.jpg"));
		lblNewLabel_1.setBounds(21, 23, 103, 72);
		contentPane.add(lblNewLabel_1);
		
		// connexion
		conn =Javaconnect.connecdb();
	}
	// ferme la fenêtre Login
	public void close(){
		WindowEvent winClosinEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosinEvent);
	}
	
	
}
