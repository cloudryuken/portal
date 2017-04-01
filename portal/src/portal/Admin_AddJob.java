package portal;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Admin_AddJob extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUser;
	private JTextField tfContractor;
	private JTextField tfJobType;
	private JTextField tfCity;
	private JTextField tfStreet;
	private JTextField tfDate;
	private JTextField tfHourStart;
	private JTextField tfHourEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_AddJob frame = new Admin_AddJob();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_AddJob() {
		setTitle("Portal [ADD JOB]");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminMain().setVisible(true);
			}
		});
		btnNewButton.setBounds(195, 307, 89, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(10, 11, 80, 25);
		contentPane.add(lblUser);
		
		JLabel lblContractor = new JLabel("Contractor:");
		lblContractor.setBounds(10, 47, 80, 25);
		contentPane.add(lblContractor);
		
		JLabel lblJobType = new JLabel("Job Type:");
		lblJobType.setBounds(10, 83, 80, 25);
		contentPane.add(lblJobType);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 119, 80, 25);
		contentPane.add(lblCity);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setBounds(10, 155, 80, 25);
		contentPane.add(lblStreet);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 191, 80, 25);
		contentPane.add(lblDate);
		
		JLabel lblHourStart = new JLabel("Hour Start:");
		lblHourStart.setBounds(10, 227, 80, 25);
		contentPane.add(lblHourStart);
		
		JLabel lblHourEnd = new JLabel("Hour End:");
		lblHourEnd.setBounds(10, 264, 80, 25);
		contentPane.add(lblHourEnd);
		
		tfUser = new JTextField();
		tfUser.setBounds(100, 11, 184, 25);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfContractor = new JTextField();
		tfContractor.setColumns(10);
		tfContractor.setBounds(100, 49, 184, 25);
		contentPane.add(tfContractor);
		
		tfJobType = new JTextField();
		tfJobType.setColumns(10);
		tfJobType.setBounds(100, 85, 184, 25);
		contentPane.add(tfJobType);
		
		tfCity = new JTextField();
		tfCity.setColumns(10);
		tfCity.setBounds(100, 121, 184, 25);
		contentPane.add(tfCity);
		
		tfStreet = new JTextField();
		tfStreet.setColumns(10);
		tfStreet.setBounds(100, 157, 184, 25);
		contentPane.add(tfStreet);
		
		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(100, 193, 184, 25);
		contentPane.add(tfDate);
		
		tfHourStart = new JTextField();
		tfHourStart.setColumns(10);
		tfHourStart.setBounds(100, 229, 184, 25);
		contentPane.add(tfHourStart);
		
		tfHourEnd = new JTextField();
		tfHourEnd.setColumns(10);
		tfHourEnd.setBounds(100, 266, 184, 25);
		contentPane.add(tfHourEnd);
		
		JButton btnAddJob = new JButton("Add Job");
		btnAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = "'" + tfUser.getText() + "'";
				String contractor = "'" + tfContractor.getText() + "'";
				String job_type = "'" + tfJobType.getText() + "'";
				String city = "'" + tfCity.getText() + "'";
				String street = "'" + tfStreet.getText() + "'";
				String date = "'" + tfDate.getText() + "'";
				String hour_start = "'" + tfHourStart.getText() + "'";
				String hour_end = "'" + tfHourEnd.getText() + "'";
				String sql = "INSERT INTO l_jobs " + "VALUES (NULL, NULL, " + user + ", " + contractor + ", " + job_type + ", " + city  + ", "
						+ street + ", " + date + ", " + hour_start + ", " + hour_end + ");";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/multiutility", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate(sql);
					
					dispose();
                    new AdminMain().setVisible(true);					
				} catch (Exception e1){
					JOptionPane.showInputDialog(this, e1.getMessage());
				}
			}
		});
		btnAddJob.setBounds(10, 307, 89, 25);
		contentPane.add(btnAddJob);
	}
}
