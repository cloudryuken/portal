package portal;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Admin_NewUser extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3306427556678755325L;
	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPass;
	private JTextField tfPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_NewUser frame = new Admin_NewUser();
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
	public Admin_NewUser() {
		setTitle("Portal [ADD USER]");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 371);
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
		btnNewButton.setBounds(181, 308, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 80, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPass = new JLabel("Password:");
		lblPass.setBounds(10, 47, 80, 25);
		contentPane.add(lblPass);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 85, 80, 25);
		contentPane.add(lblPhone);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(100, 11, 170, 25);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(100, 49, 170, 25);
		contentPane.add(tfPass);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(100, 85, 170, 25);
		contentPane.add(tfPhone);
		
		JButton btnAdd = new JButton("Add User");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = "'" + tfUsername.getText() + "'";
				String password = "'" + tfPass.getText() + "'";
				String phone_number = "'" + tfPhone.getText() + "'";
				String sql = "INSERT INTO s_users " + "VALUES (NULL, " + username + ", " + password + ", " + phone_number + ");";
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
		btnAdd.setBounds(10, 308, 89, 23);
		contentPane.add(btnAdd);
	}
}
