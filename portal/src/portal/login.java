package portal;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -18561447882935195L;
	private JPanel contentPane;
	private JTextField userfield;
	private JPasswordField passfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Portal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 31, 80, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 62, 80, 25);
		contentPane.add(lblPassword);
		
		userfield = new JTextField();
		userfield.setBounds(100, 33, 86, 20);
		contentPane.add(userfield);
		userfield.setColumns(10);
		
		passfield = new JPasswordField();
		passfield.setBounds(100, 64, 86, 20);
		contentPane.add(passfield);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String sql = "Select * from s_users";
			        try {
			            Class.forName("com.mysql.jdbc.Driver");
			            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/multiutility", "root", "");
			            Statement stmt = con.createStatement();
			            ResultSet rs = stmt.executeQuery(sql);
			            String user = userfield.getText();
			            String pwd = new String(passfield.getPassword());
			            while (rs.next()) {
			                String uname = rs.getString("username");
			                String password = rs.getString("password");
			                if ((user.equals(uname)) && (pwd.equals(password))) {

			                            dispose();
			                            new AdminMain().setVisible(true);

			                } else if ((user.equals(uname)) != (pwd.equals(password))) {
			                    String st = "User sau parola incorecta!";
			                    JOptionPane.showMessageDialog(null, st);
			                }
			            }
			        } catch (Exception e) {
			            JOptionPane.showInputDialog(this, e.getMessage());
			        }
			}
		});
		
		btnLogin.setBounds(30, 98, 156, 23);
		contentPane.add(btnLogin);
	}
}
