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


public class SeleccionarArchivo extends JFrame{

	private static final long serialVersionUID = -1440264901664686208L;
	
	public SeleccionarArchivo() throws HeadlessException {
		super("Uso JFileChooser");
		setPreferredSize(new Dimension(600, 600));
		getContentPane().setSize(new Dimension(300, 300));
		getContentPane().setLayout(null);
		
		JButton btnSeleccionarArchivo = new JButton("Seleccionar archivo ...");
		btnSeleccionarArchivo.setBounds(72, 5, 139, 23);
		getContentPane().add(btnSeleccionarArchivo);
		
		JLabel lbImput = new JLabel("Input");
		lbImput.setBounds(10, 77, 46, 14);
		getContentPane().add(lbImput);
		
		JLabel lblTokensTable = new JLabel("Tabla de Tokens");
		lblTokensTable.setBounds(10, 341, 101, 14);
		getContentPane().add(lblTokensTable);
		JFileChooser jfcSelectorArchivo = new JFileChooser();
		//Expresión lambda
		btnSeleccionarArchivo.addActionListener((ActionEvent e) -> {
			int resultado = jfcSelectorArchivo.showOpenDialog(this);
			if(resultado == JFileChooser.APPROVE_OPTION) {
				File archivo = jfcSelectorArchivo.getSelectedFile();
				JOptionPane.showMessageDialog(this, "Seleccionó " + archivo.getName());
				SubCadena sc = new SubCadena(archivo);
				
			} else {
				JOptionPane.showMessageDialog(this, "No se seleccionó ningún archivo");
			}
		});
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(494,409);
	}
	
	public static void main(String[] args) {
		final SeleccionarArchivo ventana = new SeleccionarArchivo();
		SwingUtilities.invokeLater(() -> {
			ventana.setVisible(true);
		});
	}
}
