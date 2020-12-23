package com.java.exercises.school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SchoolApp extends JFrame {
	SchoolManagement manager = new SchoolManagement();
	private JPanel contentPane;
	private JTextField txtIdStudent;
	private JTextField txtStudentName;
	private JTextField txtPayment;
	private JTextField txtGetStudentId;
	private JComboBox<String> cmbCareer = new JComboBox<String>();
	private JTextArea taPaymentList = new JTextArea();
	
	private JTable tableStudentPayments;
	
	private JScrollPane spStudentPayments;
	private DefaultTableModel tableModelStudentPayments;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolApp frame = new SchoolApp();
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
	public SchoolApp() {
		setResizable(true);
		setTitle("Sistema de Pagos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnCreatePayment = new JButton("Generar Pago");
		btnCreatePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student studentObj = new Student();
				studentObj.setIdStudent(Integer.parseInt(txtIdStudent.getText()));
				studentObj.setStudentName(txtStudentName.getText());
				studentObj.setCareer((String)cmbCareer.getSelectedItem());
				studentObj.setPayment(Double.parseDouble(txtPayment.getText()));
				
				manager.addStudentToList(studentObj);
		
				JOptionPane.showMessageDialog(null, "¡Pago realizado con éxito!");
				
				txtIdStudent.setText(null);
				txtStudentName.setText(null);
				cmbCareer.setSelectedIndex(0);
				txtPayment.setText(null);
				
				
			}
		});
		btnCreatePayment.setBounds(277, 307, 156, 29);
		panel.add(btnCreatePayment);
		
		JLabel lblInstituteImage = new JLabel("");
		lblInstituteImage.setIcon(new ImageIcon(SchoolApp.class.getResource("/com/java/exercises/school/TESCI.jpg")));
		lblInstituteImage.setBounds(455, 51, 156, 163);
		panel.add(lblInstituteImage);
		
		JLabel lblIdalumno = new JLabel("idAlumno:");
		lblIdalumno.setBounds(35, 123, 84, 25);
		panel.add(lblIdalumno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(46, 179, 84, 25);
		panel.add(lblNombre);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(46, 240, 84, 25);
		panel.add(lblCarrera);
		
		JLabel lblPago = new JLabel("Pago: $");
		lblPago.setBounds(46, 307, 65, 25);
		panel.add(lblPago);
		
		txtIdStudent = new JTextField();
		txtIdStudent.setBounds(120, 119, 57, 33);
		panel.add(txtIdStudent);
		txtIdStudent.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setColumns(10);
		txtStudentName.setBounds(120, 179, 114, 33);
		panel.add(txtStudentName);
		
		txtPayment = new JTextField();
		txtPayment.setColumns(10);
		txtPayment.setBounds(120, 303, 114, 33);
		panel.add(txtPayment);
		
	    cmbCareer = new JComboBox();
		cmbCareer.setModel(new DefaultComboBoxModel(new String[] {"Selecciona Carrera ...", "Ing. en Sistemas ", "Lic. en Derecho", "Ing. Mecánica", "Lic. en Turismo", "Lic. en Administración"}));
		cmbCareer.setBounds(120, 240, 205, 33);
		panel.add(cmbCareer);
		
		JButton btnShowAllPayments = new JButton("Mostrar Todos");
		btnShowAllPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                SchoolManagement schoolManagement = new SchoolManagement();
				
				String StudentColumns[] = { "Id", "Nombre", "Carrera", "Pago"};
				tableModelStudentPayments = new DefaultTableModel(StudentColumns, 0);
				tableStudentPayments = new JTable(tableModelStudentPayments);
				tableStudentPayments.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				tableStudentPayments.getColumnModel().getColumn(0).setPreferredWidth(50);
				tableStudentPayments.getColumnModel().getColumn(1).setPreferredWidth(150);
				tableStudentPayments.getColumnModel().getColumn(2).setPreferredWidth(150);
				tableStudentPayments.getColumnModel().getColumn(3).setPreferredWidth(150);
				
				List<Student> studentList = schoolManagement.showStudentList();
				
				for(Student student : studentList ) {
				Object[] studentItems = { student.getIdStudent(), student.getStudentName(),
						student.getCareer(), student.getPayment()};
				tableModelStudentPayments.addRow(studentItems);
				}
				
				spStudentPayments.setViewportView(tableStudentPayments);
				
			
			}
		});
		btnShowAllPayments.setBounds(228, 615, 147, 25);
		panel.add(btnShowAllPayments);
		
		JLabel lblConsultaPorIdalumno = new JLabel("Consulta por IdAlumno:");
		lblConsultaPorIdalumno.setBounds(79, 380, 185, 25);
		panel.add(lblConsultaPorIdalumno);
		
		txtGetStudentId = new JTextField();
		txtGetStudentId.setColumns(10);
		txtGetStudentId.setBounds(253, 376, 65, 33);
		panel.add(txtGetStudentId);
		
		JButton btnSearchStudentId = new JButton("Buscar");
		btnSearchStudentId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SchoolManagement schoolManagement = new SchoolManagement();
				
				String StudentColumns[] = { "Id", "Nombre", "Carrera", "Pago"};
				tableModelStudentPayments = new DefaultTableModel(StudentColumns, 0);
				tableStudentPayments = new JTable(tableModelStudentPayments);
				tableStudentPayments.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				tableStudentPayments.getColumnModel().getColumn(0).setPreferredWidth(50);
				tableStudentPayments.getColumnModel().getColumn(1).setPreferredWidth(150);
				tableStudentPayments.getColumnModel().getColumn(2).setPreferredWidth(150);
				tableStudentPayments.getColumnModel().getColumn(3).setPreferredWidth(150);
				
				Student student = schoolManagement.searchStudentId(Integer.parseInt(txtGetStudentId.getText()));
				
				Object[] studentItems = { student.getIdStudent(), student.getStudentName(),
						student.getCareer(), student.getPayment()};
				tableModelStudentPayments.addRow(studentItems);
				spStudentPayments.setViewportView(tableStudentPayments);
				
				
			}
		});
		btnSearchStudentId.setBounds(330, 383, 94, 25);
		panel.add(btnSearchStudentId);
		
		JButton btnCloseApp2 = new JButton("Salir");
		btnCloseApp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnCloseApp2.setBounds(499, 629, 89, 23);
		panel.add(btnCloseApp2);
		
		JLabel lblTecnolgicoDeEstudios = new JLabel("Tecnológico de Estudios Superiores de Cuautitlán Izcallí");
		lblTecnolgicoDeEstudios.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTecnolgicoDeEstudios.setBounds(35, 12, 597, 29);
		panel.add(lblTecnolgicoDeEstudios);
		
		JLabel lblControlDePagos = new JLabel("Control de Pagos");
		lblControlDePagos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblControlDePagos.setBounds(213, 48, 222, 44);
		panel.add(lblControlDePagos);
		
	    spStudentPayments = new JScrollPane();
		spStudentPayments.setBounds(84, 430, 447, 154);
		panel.add(spStudentPayments);
		
		tableStudentPayments = new JTable();
		spStudentPayments.setViewportView(tableStudentPayments);
		
		
	}
}
