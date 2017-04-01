package portal;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Admin_ViewJob extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6957112857051538961L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_header;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_ViewJob frame = new Admin_ViewJob();
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
	public Admin_ViewJob() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(new String[] 
				{"User", "Contractor", "Job Type", "City", "Street", "Date", "Hour Start", "Hour End"}, 0);
		String sql = "Select * From l_jobs";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/multiutility", "root", "");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next())
			{
				String f = rs.getString("user"); 
				String g = rs.getString("contractor");
				String h = rs.getString("job_type");
				String i = rs.getString("city");
				String j = rs.getString("street");
				String k = rs.getString("date");
				String l = rs.getString("hour_start");
				String m = rs.getString("hour_end");
				model.addRow(new Object[]{f, g, h, i, j, k, l, m});
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog(this, e.getMessage());
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 377);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		table_header = new JTable();
		table_header.setModel(model);
		scrollPane.setColumnHeaderView(table_header);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AdminMain().setVisible(true);
			}
		});
		btnBack.setBounds(494, 399, 90, 25);
		contentPane.add(btnBack);
	}
}
