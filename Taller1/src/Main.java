import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;

public class Main {

	public JFrame frame;
	private JTextArea contenido2;
	private File Archivo1;
	private JTabbedPane tabbedPane;
	private JPanel panelMain;
	private JPanel panelSimbolos;
	private JPanel panelTokens;
	private JPanel panel_2;
	private JTextArea input;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private JScrollPane scrollPane_1;
	private JTextArea textSimbolos;
	private JLabel lblTablaSimbolos;
	private JButton btnGenTablaSimb;
	private JScrollPane scrollPane_2;
	private JTextArea textTokens;
	private JLabel lblTablaTokens;
	private JButton btnGenTablaTokens;
	private String AuxTxt1;
	private String AuxTxt2;
	private String auxTxtExp;
	private JTable table;
	private JTable table_1;
	private JPanel panel_3;
	private JTextArea textExp;
	private String auxExp;
	private String auxPrefija ="";
	private String auxPosfija= "";
	private JScrollPane scrollPane_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 750, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		SubCadena sc = new SubCadena();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 248, 255));
		tabbedPane.setBounds(0, 0, 734, 563);
		frame.getContentPane().add(tabbedPane);
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		tabbedPane.addTab("Inicio", null, panelMain, null);
		panelMain.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 0, 51));
		panel_1.setBounds(511, 0, 218, 535);
		panelMain.add(panel_1);
		panel_1.setLayout(null);
		
		JFileChooser jfcSelectorArchivo = new JFileChooser();
		
		JButton btnSeleccionarArchivo = new JButton("Seleccionar Archivo");
		btnSeleccionarArchivo.setFont(new Font("Georgia", Font.BOLD, 12));
		btnSeleccionarArchivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int resultado = jfcSelectorArchivo.showDialog(null, "Abrir");
				if(resultado == JFileChooser.APPROVE_OPTION) {
				File archivo = jfcSelectorArchivo.getSelectedFile();
				JOptionPane.showMessageDialog(null, "Seleccionó " + archivo.getName());
				SubCadena sc = new SubCadena(archivo);
				input.setText("");
				input.setText(sc.textInput);
				AuxTxt1 = sc.textoSimbolos;
				AuxTxt2 = sc.texto2;
				auxTxtExp = sc.expresiones;
				}
			}
		});
		btnSeleccionarArchivo.setBounds(24, 82, 171, 33);
		panel_1.add(btnSeleccionarArchivo);
		
		
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Georgia", Font.BOLD, 11));
		btnSalir.setBounds(46, 328, 128, 33);
		panel_1.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 491, 497);
		panelMain.add(scrollPane);
		
		input = new JTextArea();
		input.setEditable(false);
		input.setBackground(SystemColor.controlHighlight);
		scrollPane.setViewportView(input);
		
		JLabel lblInput = new JLabel("Su archivo:");
		lblInput.setBounds(10, 11, 89, 14);
		panelMain.add(lblInput);
		
		panelSimbolos = new JPanel();
		panelSimbolos.setBackground(Color.WHITE);
		tabbedPane.addTab("Tabla de Simbolos", null, panelSimbolos, null);
		panelSimbolos.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(510, 0, 219, 535);
		panelSimbolos.add(panel);
		panel.setLayout(null);
		
		btnGenTablaSimb = new JButton("Generar Tabla de simbolos");
		btnGenTablaSimb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSimbolos.setText("");
				textSimbolos.setText(AuxTxt1);
				
			}
		});
		btnGenTablaSimb.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnGenTablaSimb.setBounds(10, 102, 199, 34);
		panel.add(btnGenTablaSimb);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 68, 479, 456);
		panelSimbolos.add(scrollPane_1);
		
		textSimbolos = new JTextArea();
		textSimbolos.setEditable(false);
		textSimbolos.setBackground(SystemColor.controlHighlight);
		scrollPane_1.setViewportView(textSimbolos);
		
		lblTablaSimbolos = new JLabel("TABLA DE SIMBOLOS");
		lblTablaSimbolos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTablaSimbolos.setBounds(10, 24, 237, 20);
		panelSimbolos.add(lblTablaSimbolos);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Simbolo", "Ubicaci\u00F3n", "Clasificaci\u00F3n"},
			},
			new String[] {
				"Simbolo", "New column", "New column"
			}
		));
		table.setBounds(10, 48, 479, 20);
		panelSimbolos.add(table);
		
		panelTokens = new JPanel();
		panelTokens.setBackground(Color.WHITE);
		tabbedPane.addTab("Tabla de Tokens", null, panelTokens, null);
		panelTokens.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 0, 51));
		panel_2.setBounds(514, 0, 215, 535);
		panelTokens.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 69, 479, 455);
		panelTokens.add(scrollPane_2);
		
		textTokens = new JTextArea();
		textTokens.setEditable(false);
		textTokens.setBackground(SystemColor.controlHighlight);
		scrollPane_2.setViewportView(textTokens);
		
		lblTablaTokens = new JLabel("TABLA DE TOKENS");
		lblTablaTokens.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTablaTokens.setBounds(10, 24, 237, 20);
		panelTokens.add(lblTablaTokens);
		
		btnGenTablaTokens = new JButton("Generar Tabla de Tokens");
		btnGenTablaTokens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTokens.setText("");
				textTokens.setText(AuxTxt2);
			}
		});
		btnGenTablaTokens.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnGenTablaTokens.setBounds(10, 99, 199, 34);
		panel_2.add(btnGenTablaTokens);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Token", "#IdToken", "Lexema Generador"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setEnabled(false);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(10, 48, 479, 26);
		panelTokens.add(table_1);
		
		btnLimpiar = new JButton("Limpiar todo");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				textSimbolos.setText("");
				textTokens.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Georgia", Font.BOLD, 11));
		btnLimpiar.setBounds(46, 267, 128, 33);
		panel_1.add(btnLimpiar);
		
		JPanel panelExpresiones = new JPanel();
		tabbedPane.addTab("Expresiones", null, panelExpresiones, null);
		panelExpresiones.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 0, 51));
		panel_3.setBounds(514, 0, 215, 535);
		panelExpresiones.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 28, 462, 95);
		panelExpresiones.add(scrollPane_3);
		
		textExp = new JTextArea();
		textExp.setEditable(false);
		scrollPane_3.setViewportView(textExp);
		
		
		JLabel lblExpresiones = new JLabel("Expresiones encontradas:");
		lblExpresiones.setBounds(10, 11, 172, 14);
		panelExpresiones.add(lblExpresiones);
		
		JLabel lblValExpresiones = new JLabel("Validaci\u00F3n de Expresiones:");
		lblValExpresiones.setBounds(10, 177, 157, 14);
		panelExpresiones.add(lblValExpresiones);
		
		JButton btnGenExpresiones = new JButton("Generar Expresiones");
		btnGenExpresiones.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnGenExpresiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textExp.setText(auxTxtExp);
			}
		});
		btnGenExpresiones.setBounds(10, 77, 195, 42);
		panel_3.add(btnGenExpresiones);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 202, 462, 116);
		panelExpresiones.add(scrollPane_4);
		
		JTextArea textArea = new JTextArea();
		scrollPane_4.setViewportView(textArea);
		
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 411, 235, 34);
		panelExpresiones.add(scrollPane_5);
		
		JTextArea txtPrefija = new JTextArea();
		txtPrefija.setEditable(false);
		txtPrefija.setBounds(10, 411, 235, 34);
		scrollPane_5.setViewportView(txtPrefija);
		

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(255, 411, 235, 34);
		panelExpresiones.add(scrollPane_6);
		
		JTextArea txtPosfija = new JTextArea();
		txtPosfija.setEditable(false);
		txtPosfija.setBounds(255, 411, 235, 34);
		scrollPane_6.setViewportView(txtPosfija);
		
		JButton btnNotacionPrefija = new JButton("Notaci\u00F3n Prefija");
		btnNotacionPrefija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPrefija.setText(auxPrefija);
				auxPrefija ="";
			}
		});
		btnNotacionPrefija.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnNotacionPrefija.setBounds(46, 365, 157, 34);
		panelExpresiones.add(btnNotacionPrefija);
		
		JButton btnNotacionPosfija = new JButton("Notaci\u00F3n Posfija");
		btnNotacionPosfija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPosfija.setText(auxPosfija);
				auxPosfija = "";
			}
		});
		btnNotacionPosfija.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnNotacionPosfija.setBounds(298, 365, 157, 34);
		panelExpresiones.add(btnNotacionPosfija);
		
		
		
		
		
		JButton btnEvaluarExp = new JButton("Evaluar Expresiones");
		btnEvaluarExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auxExp = textArea.getText();
				txtPrefija.setText("");
				txtPosfija.setText("");
				ExpresionesSubCadena exp = new ExpresionesSubCadena(auxExp);
				if(exp.arrayErrores.size()>0) {
				for (int i = 0; i < exp.arrayErrores.size(); i++) {
					auxExp += "\n" + exp.arrayErrores.get(i) ;
				}
				textArea.setText(auxExp);
				} else {
					if(exp.posicion<exp.cadena.length()) {
						auxExp += "\n" + "undefined " + (exp.posicion-1);
						textArea.setText(auxExp);
					}else {
					auxExp += "\n"+ "Aceptado";
					textArea.setText(auxExp);
					}
				}
				//Infija y posFija
				for (int i = 0; i < exp.notacionPrefija.size(); i++) {
					auxPrefija += " " + exp.notacionPrefija.get(i);
				}
				
				for (int i = 0; i < exp.notacionPosfija.size(); i++) {
					auxPosfija += " " + exp.notacionPosfija.get(i);
				}
				
			}
		});
		btnEvaluarExp.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnEvaluarExp.setBounds(10, 223, 195, 42);
		panel_3.add(btnEvaluarExp);
		
		
		
		
		
	}
}
