import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.HeadlessException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;


public class SeleccionarArchivo extends JFrame{

	private static final long serialVersionUID = -1440264901664686208L;
	private JButton btnSeleccionarArchivo;
	private JTextArea contenido2;
	private JPanel panel2;
	
	public SeleccionarArchivo() throws HeadlessException {
		super("Uso JFileChooser");
		getContentPane().setBackground(Color.WHITE);
		setPreferredSize(new Dimension(900, 900));
		getContentPane().setSize(new Dimension(300, 400));
		getContentPane().setLayout(null);
		
		btnSeleccionarArchivo = new JButton("Seleccionar archivo ...");
		btnSeleccionarArchivo.setBounds(92, 33, 267, 45);
		getContentPane().add(btnSeleccionarArchivo);
		
		JLabel lbImput = new JLabel("Input");
		lbImput.setBounds(10, 77, 46, 14);
		getContentPane().add(lbImput);
		
		JLabel lblTokensTable = new JLabel("Tabla de Tokens");
		lblTokensTable.setBounds(10, 341, 161, 14);
		getContentPane().add(lblTokensTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 120, 503, 198);
		getContentPane().add(scrollPane);
		
		JTextArea contenido = new JTextArea();
		contenido.setEditable(false);
		scrollPane.setViewportView(contenido);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 370, 503, 198);
		getContentPane().add(scrollPane_1);
		
		contenido2 = new JTextArea();
		contenido2.setEditable(false);
		scrollPane_1.setViewportView(contenido2);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(457, 44, 89, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(btnSalir);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 129, 749);
		panel2.setBackground(new Color(255, 0, 51));
		getContentPane().add(panel2);
		getContentPane().setBackground(Color.WHITE);
		
		
		JFileChooser jfcSelectorArchivo = new JFileChooser();
		//Expresión lambda
		btnSeleccionarArchivo.addActionListener((ActionEvent e) -> {
			int resultado = jfcSelectorArchivo.showOpenDialog(this);
			if(resultado == JFileChooser.APPROVE_OPTION) {
				File archivo = jfcSelectorArchivo.getSelectedFile();
				JOptionPane.showMessageDialog(this, "Seleccionó " + archivo.getName());
				SubCadena sc = new SubCadena(archivo);
				contenido.setText(sc.textoSimbolos);
				contenido2.setText(sc.texto2);
				
			} else {
				JOptionPane.showMessageDialog(this, "No se seleccionó ningún archivo");
			}
		});
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(605,670);
	}
	
	public static void main(String[] args) {
		final SeleccionarArchivo ventana = new SeleccionarArchivo();
		SwingUtilities.invokeLater(() -> {
			ventana.setVisible(true);
		});
	}
}
