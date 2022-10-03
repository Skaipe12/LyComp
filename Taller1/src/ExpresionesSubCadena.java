import java.util.ArrayList;

//para manejadorde errores seguir la cadena en termino, no en expresión.

/*Clase ExpresionesSubCadena:
*Clase encargada de aplicar la gramática de expresiones a las mismas encontradas en la clase 
*SubCadena.
*
*/
public class ExpresionesSubCadena {
	String cadena = "";
	int posicion;
	char token_Entrada;
	int[] digitos = new int[]{0,1,2,3,4,5,6,7,8,9};
	ArrayList<String> arrayErrores = new ArrayList<String>();

	/*Constructor:
	Parámetros: String str -> Cadena que recibe para analizar su gramática.
	*/
	
	public ExpresionesSubCadena(String str) {
		this.cadena = str;
		principal();
		
	}
	
	/*
	 * Funcion Expresion:
	 * Parametros: N/A
	 * Descripción: Funcion que empieza la gramatica de expresion. Llama a la función termino y elimina
	 * la recursividad por la izquierda con expresión prima.
	 *
	 */
	public void expresion() {
		termino();
		expresion_Prima();
	}
	
	/*
	 * Funcion Termino:
	 * Parametros: N/A
	 * Descripción: Funcion encargada de seguir la gramática, derivando a factor y termino prima.
	 * Como se logra observar, la recursividad a la izquierda también es eliminada.
	 *
	 */
	private void termino() {
		factor();
		termino_Prima();
		
	}
	/*
	 * Funcion termino_Prima:
	 * Parametros: N/A
	 * Descripción: Función que verifica siempre si el token de entrada es un simbolo terminal
	 * para hacer match con este y luego deriva las correspondientes funciones que van acorde a la 
	 * gramática.
	 *
	 */
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

	/*
	 * Funcion Factir:
	 * Parametros: N/A
	 * Descripción: Funcion similar a termino prima en donde se evaluan los factores, que empiezan
	 * con un paréntesis y luego derivan la gramática correspondiente (expresión).
	 * Al finalizar, vuelve a llamar la función hacer Match para verificar si termina con un parentesis.
	 * En caso de no empezar con paréntesis, se deriva a número.
	 */
	private void factor() {
		if(token_Entrada=='(') {
			hacerMatch(token_Entrada);
			expresion();
			hacerMatch(token_Entrada);
		} else {
			numero();
			}
		
	}

	/*
	 * Funcion Expresion_Prima:
	 * Parametros: N/A
	 * Descripción: funcion que verifica que el simbolo de entrada presente cuando sea llamada sea 
	 * terminal, para inmediatamente hacer match y continuar con la derivación de la gramática.
	 *
	 */
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
	
	
	/*
	 * Funcion Numero:
	 * Parametros: N/A
	 * Descripción: Función encargada de verificar los numeros encontrados en la cadena principal
	 * para verificar su derivación.
	 */
	public void numero() {
		digito();
		numero_Prima();
	}
	
	/*
	 * Funcion numero_Prima:
	 * Parametros: N/A
	 * Descripción: Función utilizada para eliminar la recursividad por la izquierda de la función 
	 * número. Verifica si el actual token de entrada es un digito para seguir con la derivación
	 * acorde a número.
	 */
	private void numero_Prima() {
		if(isDigito(token_Entrada) ) {
				digito();
				numero_Prima();
		} else {
			//epsilon
		}
		
	}

	/*
	 * Funcion digito:
	 * Parametros: N/A
	 * Descripción: Función encargada de verificar la derivación de digito. Cuando no es dígito, marca
	 * error en la posición actual del token de entrada.
	 *
	 */
	private void digito() {
		if(isDigito(token_Entrada)) {
			hacerMatch(token_Entrada);
		} else {
			System.out.println("error en posición " + posicion);
			arrayErrores.add("Error en posición " + posicion);
		}
		
	}
	
	/*
	 * Funcion isDigito:
	 * Parametros: char token_Entrada
	 * Descripción: Método encargado de verificar que los token de entrada sean dígitos. Recibe el token
	 * que se quiere analizar y lo convierte a un entero para así buscar su equivalente valor en un array de 
	 * digitos. Se tiene una bandera que cambia su estado a True al encontrar el digito en el array.
	 * Output: True-False. 
	 *
	 */
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
	
	/*
	 * Funcion hacerMatch:
	 * Parametros: char t
	 * Descripción: Función encargada de dar paso al siguiente token si las reglas de derivación
	 * van acorde a lo que se tiene planteado en la gramática. No retorna ningún valor.
	 *
	 */
	public void hacerMatch(char t) {
		if(t == token_Entrada) {
			token_Entrada = siguienteToken();
		} else {
			System.out.println("error");
		}
	}
	
	/*
	 * Funcion siguienteToken:
	 * Parametros: N/A
	 * Descripción: Función encargada de mover el puntero en las posiciones de la cadena.
	 * Output: 
	 * Retorna la posición deseada si no ha llegado al final de la cadena.
	 * Retorna un caracter vacío si se llegó al final de la cadena. (Esto sirve de modo de verificación
	 * cuando se quiera para de analizar).
	 * 
	 */
	public char siguienteToken() {
		char aux = '\0';
		if(posicion == cadena.length()) {
			return aux;
		}else {
			posicion+=1;
			return cadena.charAt(posicion-1);
		}
	}
	
	/*
	 * Funcion primerToken:
	 * Parametros: N/A
	 * Descripción: Método encargado de dar inicio al analizador entregando el primer token de la cadena
	 * a analizar y sumando por primera vez la posición del puntero.
	 * Output: Primera posición de la cadena.
	 */
	public char primerToken() {
		posicion+=1;
		return cadena.charAt(0);
	}
	
	/*
	 * Funcion principal:
	 * Parametros: N/A
	 * Descripción: Método encargado de poner en funcionamiento al analizador.
	 * Deja en orden todo lo necesario para empezar el análisis con el método expresión.
	 */
	public void principal() {
		posicion = 0;
		token_Entrada = primerToken();
		expresion();
	}
	


}
