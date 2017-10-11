package jfreechart1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IHM extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public IHM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("statistiques1");
		lblNewLabel.setBounds(38, 496, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatistiques = new JLabel("statistiques2");
		lblStatistiques.setBounds(138, 496, 72, 14);
		contentPane.add(lblStatistiques);
		
		JLabel label = new JLabel("statistiques2");
		label.setBounds(239, 496, 72, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("statistiques2");
		label_1.setBounds(353, 496, 72, 14);
		contentPane.add(label_1);
		
		txt1 = new JTextField();
		txt1.setBounds(38, 521, 62, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(148, 521, 62, 20);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(239, 521, 62, 20);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(352, 521, 62, 20);
		contentPane.add(txt4);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int s1 = Integer.parseInt(txt1.getText());
				int s2 = Integer.parseInt(txt2.getText());
				int s3 = Integer.parseInt(txt3.getText());
				int s4 = Integer.parseInt(txt4.getText());
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.setValue(s1, "", "statistiques1");
				dataset.setValue(s2, "", "statistiques2");
				dataset.setValue(s3, "", "statistiques3");
				dataset.setValue(s4, "", "statistiques4");
				
				JFreeChart chart = ChartFactory.createBarChart("Statistiques", "", "", dataset, PlotOrientation.HORIZONTAL,false,false, false);
				
				CategoryPlot catPlot = chart.getCategoryPlot();
				catPlot.setRangeGridlinePaint(Color.BLACK);
				
				ChartPanel chartPanel = new ChartPanel(chart);
				contentPane.removeAll();
				contentPane.add(chartPanel, BorderLayout.CENTER);
				contentPane.validate();
			}
		});
		btnView.setBounds(456, 492, 89, 23);
		contentPane.add(btnView);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 25, 522, 402);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	}
}
