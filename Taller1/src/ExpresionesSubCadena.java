import java.util.ArrayList;

//para manejadorde errores seguir la cadena en termino, no en expresión.


public class ExpresionesSubCadena {
	String cadena = "";
	int posicion;
	char token_Entrada;
	int[] digitos = new int[]{0,1,2,3,4,5,6,7,8,9};
	ArrayList<String> arrayErrores = new ArrayList<String>();
	
	public ExpresionesSubCadena(String str) {
		this.cadena = str;
		principal();
		
	}
	
	public void expresion() {
		termino();
		expresion_Prima();
	}
	
	private void termino() {
		factor();
		termino_Prima();
		
	}
	
	private void termino_Prima() {
		if(token_Entrada=='*') {
			hacerMatch(token_Entrada);
			factor();
			termino_Prima();
		} else if(token_Entrada=='/') {
			hacerMatch(token_Entrada);
			factor();
			termino_Prima();
		} else {
			//epsilon
		}
		
	}

	private void factor() {
		if(token_Entrada=='(') {
			hacerMatch(token_Entrada);
			expresion();
			hacerMatch(token_Entrada);
		} else {
			numero();
			}
		
	}

	private void expresion_Prima() {
		if(token_Entrada=='+') {
			hacerMatch(token_Entrada);
			termino();
			expresion_Prima();
		} else if(token_Entrada=='-') {
				hacerMatch(token_Entrada);
				termino();
				expresion_Prima();
			}else {
				//Epsilon
		}
	}
	
	

	public void numero() {
		digito();
		numero_Prima();
	}
	

	private void numero_Prima() {
		if(isDigito(token_Entrada) ) {
				digito();
				numero_Prima();
		} else {
			//epsilon
		}
		
	}

	private void digito() {
		if(isDigito(token_Entrada)) {
			hacerMatch(token_Entrada);
		} else {
			System.out.println("error en posición " + posicion);
			arrayErrores.add("Error en posición " + posicion);
		}
		
	}

	private boolean isDigito(char token_Entrada2) {
		int token_int = Character.getNumericValue(token_Entrada2);
		boolean flag = false;;
		for (int i = 0; i < digitos.length; i++) {
			if(token_int == digitos[i]) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return (flag==true)? true:false;
	}
	
	
	public void hacerMatch(char t) {
		if(t == token_Entrada) {
			token_Entrada = siguienteToken();
		} else {
			System.out.println("error");
		}
	}
	
	public char siguienteToken() {
		char aux = '\0';
		if(posicion == cadena.length()) {
			return aux;
		}else {
			posicion+=1;
			return cadena.charAt(posicion-1);
		}
	}
	
	
	public char primerToken() {
		posicion+=1;
		return cadena.charAt(0);
	}
	
	public void principal() {
		posicion = 0;
		token_Entrada = primerToken();
		expresion();
	}
	
//	public static void main(String[] args) {
//		ExpresionesSubCadena e = new ExpresionesSubCadena();
//		e.principal();
//		
//	}

}
