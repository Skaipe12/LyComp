import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class TablaSimbolos extends Main {
	
	SubCadena scSimbolos;
	JFrame frame;
	private JPanel panel;
	private JTextArea contenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaSimbolos window = new TablaSimbolos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public TablaSimbolos() {
		initialize();
	}
	
	public TablaSimbolos(SubCadena sc) {
		scSimbolos = sc;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 819, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 0, 51));
		panel_1.setBounds(614, 0, 205, 550);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnGenerarTabla = new JButton("Generar Tabla");
		btnGenerarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenido.setText(scSimbolos.textoSimbolos);
			}
		});
		btnGenerarTabla.setBounds(26, 116, 159, 31);
		panel_1.add(btnGenerarTabla);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(26, 208, 159, 31);
		panel_1.add(btnLimpiar);
		
		JLabel lblTablaSimbolos = new JLabel("TABLA DE SIMBOLOS");
		lblTablaSimbolos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTablaSimbolos.setBounds(10, 38, 222, 25);
		panel.add(lblTablaSimbolos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 552, 476);
		panel.add(scrollPane);
		
		contenido = new JTextArea();
		scrollPane.setViewportView(contenido);
		contenido.setEditable(false);
		contenido.setBackground(SystemColor.controlHighlight);
		
		
	}
}
