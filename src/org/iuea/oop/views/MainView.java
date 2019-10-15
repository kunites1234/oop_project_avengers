package org.iuea.oop.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable table_2;
	private JTextField id;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField regnum;
	private JTextField course;
	private JButton submit;
	JComboBox sex;
	/*
	 Launch the application.
	 */
	public static void main(String[] args) {
		
		
		//copied to the class that we want to have access  to
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); //copied to the login class
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,850, 560);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnAction.add(mntmNew);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnAction.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		mnAction.add(separator_1);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnAction.add(mntmSave);
		
		JSeparator separator_2 = new JSeparator();
		mnAction.add(separator_2);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnAction.add(mntmClose);
		
		JSeparator separator_3 = new JSeparator();
		mnAction.add(separator_3);
		
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnAction.add(mntmLogout);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				 EventQueue.invokeLater(new Runnable() {
					
         			public void run() {
         				try {
         					LoginView frame = new LoginView();
         					
         					frame.setVisible(true);
         				} catch (Exception e) {
         					e.printStackTrace();
         				}
         			}
         		});
			}
		});
		mntmClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
		});
	
		
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmMore = new JMenuItem("More ");
		mnHelp.add(mntmMore);
		
		JSeparator separator_4 = new JSeparator();
		mnHelp.add(separator_4);
		
		JMenuItem mntmClose_1 = new JMenuItem("Close");
		mnHelp.add(mntmClose_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//declaration of the student_panel used below 
		JPanel student_panel = new JPanel();
		student_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		student_panel.setBounds(222, 0, 612, 455);
		contentPane.add(student_panel);
		student_panel.setLayout(null);
		student_panel.setVisible(false);
		
		// declaring registration panel
		JPanel registration_panel = new JPanel();
		registration_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		registration_panel.setBounds(222, 0, 612, 455);
		contentPane.add(registration_panel);
		registration_panel.setLayout(null);
		registration_panel.setVisible(false); 
		
		/*JDialog notmodal = new JDialog();
	   contentPane.add(notmodal);
	   notmodal.show();*/

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table_2.getModel();
				if (table_2.getSelectedRow()==-1) {
					if(table_2.getRowCount()==0) {
					
					}
					JOptionPane.showMessageDialog(null,"Select A row first","Hint",JOptionPane.OK_OPTION);
				}
					else {
						model.removeRow(table_2.getSelectedRow());
					}				
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(459, 24, 116, 50);
		student_panel.add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// to clear data from text fields 	
				
				
			id.setText(null);
			firstname.setText(null);
			lastname.setText(null);
			course.setText(null);
			regnum.setText(null);
			
				registration_panel.setVisible(true);
				student_panel.setVisible(false);
				// once add button is click we want panel_3 to appear
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setBounds(42, 24, 116, 50);
		student_panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submit.setText("Edit");
				if(table_2.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select a row to edit");
					return;
				}
				registration_panel.setVisible(true); 
				student_panel.setVisible(false);
				int selectedRow = table_2.getSelectedRow();
				String userId = (String) table_2.getValueAt(selectedRow, 0).toString();
				String fstname = (String) table_2.getValueAt(selectedRow, 1).toString();
				String lstname = (String) table_2.getValueAt(selectedRow, 2).toString();
				String sexGender = (String) table_2.getValueAt(selectedRow, 3).toString();
				String crs = (String) table_2.getValueAt(selectedRow, 4).toString();
				String regNumber = (String) table_2.getValueAt(selectedRow, 5).toString();
				
				id.setText(userId);
				firstname.setText(fstname);
				lastname.setText(lstname);
				course.setText(crs);
				regnum.setText(regNumber);
				sex.setSelectedItem(sexGender.toLowerCase());
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.setBounds(243, 24, 116, 50);
		student_panel.add(btnEdit);
		registration_panel.setVisible(true); 
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 85, 612, 356);
		student_panel.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {//the element that we are entering in the table are in an array form. The array in java is located in the object class. 
				{1, "Kidan", "Belay", "Female", "BSCS", "17/697/BSCS-S"},
				{2, "Cubaka", "Mushamalirwa", "Male", "BIT", "18/973/BIT-S"},
				{3, "Yogesh", "Lakhami", "Male", "BSCS", "18/038/BSCS-M"},
				{4, "Tina", "Mbangu", "Female", "BSCS", "18/896/BSCS-S"},
				{5, "Josue", "Paul", "Male", "BSCS", "17/443/BSCS-S"},
			},
			new String[] {
				"#", "FirstName", "LastName", "Sex", "Course", "Registration #"
			}
		));
		scrollPane_1.setViewportView(table_2);
		
		
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(10, 109, 97, 28);
		registration_panel.add(lblId);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstname.setBounds(10, 148, 97, 28);
		registration_panel.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastname.setBounds(10, 187, 97, 28);
		registration_panel.add(lblLastname);
		
		JLabel lblSex = new JLabel("Registration #");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setBounds(10, 301, 110, 28);
		registration_panel.add(lblSex);
		
		JLabel label = new JLabel("Sex");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 223, 97, 28);
		registration_panel.add(label);
		
		JLabel label_1 = new JLabel("Course");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 262, 97, 28);
		registration_panel.add(label_1);
		
		id = new JTextField();
		id.setBounds(277, 109, 254, 26);
		registration_panel.add(id);
		id.setColumns(10);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(277, 151, 254, 26);
		registration_panel.add(firstname);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(277, 187, 254, 26);
		registration_panel.add(lastname);
		
		regnum = new JTextField();
		regnum.setColumns(10);
		regnum.setBounds(277, 302, 254, 26);
		registration_panel.add(regnum);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(277, 265, 254, 26);
		registration_panel.add(course);
		
		sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"female", "male"}));
		sex.setBounds(277, 229, 254, 25);
		registration_panel.add(sex);
		
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uid = id.getText();
				String fname = firstname.getText();
				String  lname= lastname.getText();
				String ucourse = course.getText();
				String regnumber = regnum.getText();
				String gender = (String) sex.getSelectedItem();
				
				int selectedRow = table_2.getSelectedRow();
				
				if(fname.equals("") || lname.equals("") || ucourse.equals("") || regnumber.equals("") || gender.equals("")) {
					JOptionPane.showMessageDialog(null,"fill requirde fields");
					return;
				}
				
				if(submit.getText().equals("Edit")) {
					table_2.setValueAt(uid, selectedRow, 0);
					table_2.setValueAt(fname, selectedRow, 1);
					table_2.setValueAt(lname, selectedRow, 2);
					table_2.setValueAt(gender, selectedRow, 3);
					table_2.setValueAt(ucourse, selectedRow, 4);
					table_2.setValueAt(regnumber, selectedRow, 5);
					
					
					registration_panel.setVisible(false);
					student_panel.setVisible(true);
					submit.setText("Submit");
					return;
				}
				
				DefaultTableModel model=(DefaultTableModel) table_2.getModel();
				model.addRow(new Object [] {
						id.getText(),
						firstname.getText(),
						lastname.getText(),
						sex.getSelectedItem(),
						course.getText(),
						regnum.getText(),
				});
				
			if(table_2.getSelectedRow()==1) {
				if(table_2.getRowCount()==0) {
					JOptionPane.showConfirmDialog(null, "confirmed","System", JOptionPane.OK_OPTION);
				}
			}
			registration_panel.setVisible(false);
			student_panel.setVisible(true);
			}
		});
		
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBackground(Color.GREEN);
		submit.setBounds(138, 386, 110, 44);
		registration_panel.add(submit);
			
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registration_panel.setVisible(false);
				student_panel.setVisible(true);
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(441, 386, 110, 44);
		registration_panel.add(cancel);
		registration_panel.setVisible(false);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 0, 213, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCourse = new JButton("Course");
		btnCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCourse.setBackground(Color.CYAN);
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCourse.setBounds(0, 82, 213, 81);
		panel.add(btnCourse);
		
		JButton btnCourseUnits = new JButton("Course Units");
		btnCourseUnits.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCourseUnits.setBackground(Color.CYAN);
		btnCourseUnits.setBounds(0, 163, 213, 81);
		panel.add(btnCourseUnits);
		
		JButton btnLecturers = new JButton("Lecturers");
		btnLecturers.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLecturers.setBackground(Color.CYAN);
		btnLecturers.setBounds(0, 244, 213, 81);
		panel.add(btnLecturers);
		
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_panel.setVisible(true);
			}
		});
		btnStudents.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStudents.setBackground(Color.CYAN);
		btnStudents.setBounds(0, 0, 213, 81);
		panel.add(btnStudents);
		
		JPanel navigation_panel = new JPanel();
		navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		navigation_panel.setBounds(10, 455, 824, 45);
		contentPane.add(navigation_panel);
		navigation_panel.setLayout(null);
		
		JLabel lblCopyRightGroupavengers = new JLabel("Copy right group_avengers 2019");
		lblCopyRightGroupavengers.setFont(new Font("SarahLight", Font.BOLD, 12));
		lblCopyRightGroupavengers.setForeground(Color.BLACK);
		lblCopyRightGroupavengers.setBounds(355, 11, 533, 27);
		navigation_panel.add(lblCopyRightGroupavengers);
		
		
		
	}
}
