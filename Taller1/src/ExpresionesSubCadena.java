
public class ExpresionesSubCadena {
	String cadena = "348";
	int posicion;
	char token_Entrada;
	int[] digitos = new int[]{0,1,2,3,4,5,6,7,8,9};
	
	
	
	public void numero() {
		digito();
		numero_Prima();
		
	}
	

	private void numero_Prima() {
		if(isDigito(token_Entrada) ) {
			if(token_Entrada!=cadena.charAt(cadena.length()-1)) {
				digito();
				numero_Prima();
			} else {
				//epsilon
			}
		} 
		
	}

	private void digito() {
		if(isDigito(token_Entrada)) {
			hacerMatch(token_Entrada);
		} else {
			System.out.println("error");
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
			System.out.println("Error");
		}
	}
	
	public char siguienteToken() {
		if(posicion==cadena.length()) {
			System.out.println("ACEPTADO");
		}else {
		posicion+=1;
		}
		return cadena.charAt(posicion-1);
	}
	
	
	public char primerToken() {
		posicion+=1;
		return cadena.charAt(0);
	}
	
	public void principal() {
		posicion = 0;
		token_Entrada = primerToken();
		numero();
	}
	
	public static void main(String[] args) {
		ExpresionesSubCadena e = new ExpresionesSubCadena();
		e.principal();
		System.out.println("Es numero");
	}

}
