package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6633464863188258950L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
		setTitle("Portal [ADMIN]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new Admin_NewUser().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 125, 25);
		contentPane.add(btnNewButton);
		
		JButton btnAddJob = new JButton("Add Job");
		btnAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                new AdminMain().setVisible(true);
			}
		});
		btnAddJob.setBounds(10, 47, 125, 25);
		contentPane.add(btnAddJob);
		
		JButton btnViewJobList = new JButton("View Job List");
		btnViewJobList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                new AdminMain().setVisible(true);
			}
		});
		btnViewJobList.setBounds(10, 83, 125, 25);
		contentPane.add(btnViewJobList);
	}

}
