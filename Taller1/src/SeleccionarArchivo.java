import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.HeadlessException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;


public class SeleccionarArchivo extends JFrame{

	private static final long serialVersionUID = -1440264901664686208L;
	
	public SeleccionarArchivo() throws HeadlessException {
		super("Uso JFileChooser");

		setLayout(new FlowLayout ());
		
		JButton btnSeleccionarArchivo = new JButton("Seleccionar archivo ...");
		add(btnSeleccionarArchivo);
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
		setSize(300,200);
	}
	
	public static void main(String[] args) {
		final SeleccionarArchivo ventana = new SeleccionarArchivo();
		SwingUtilities.invokeLater(() -> {
			ventana.setVisible(true);
		});
	}

}
