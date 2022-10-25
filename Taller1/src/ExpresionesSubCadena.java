import java.util.ArrayList;
//para manejadorde errores seguir la cadena en termino, no en expresión.
import java.util.Stack;

/*Class: ExpresionesSubCadena:
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
	ArrayList<String> notacionPrefija = new ArrayList<String>();
	ArrayList<String> notacionPosfija = new ArrayList<String>();
	String strInfix = "";
	/*Constructor:
	*Parameters: 
	* str - String que recibe para analizar su gramática.
	*/
	
	public ExpresionesSubCadena(String str) {
		this.cadena = str;
		principal();
		System.out.println("Notación Prefija: ");
		for (int i = 0; i < notacionPrefija.size(); i++) {
			strInfix += notacionPrefija.get(i);
			System.out.println(notacionPrefija.get(i));
		}
		
		System.out.println("Notación PosFija: ");
		for (int i = 0; i < notacionPosfija.size(); i++) {
			System.out.println(notacionPosfija.get(i));
		}

	}
	
	/*
	 *Function: Expresion.
	 *Funcion que empieza la gramatica de expresion. Llama a la función termino y elimina
	 *la recursividad por la izquierda con expresión prima.
	 */
	public void expresion() {
		termino();
		expresion_Prima();
	}
	
	/*
	 * Function: Termino.
	 * Funcion encargada de seguir la gramática, derivando a factor y termino prima.
	 * Como se logra observar, la recursividad a la izquierda también es eliminada.
	 */
	private void termino() {
		factor();
		termino_Prima();
		
	}
	/*
	 * Function: termino_Prima.
	 * Función que verifica siempre si el token de entrada es un simbolo terminal
	 * para hacer match con este y luego deriva las correspondientes funciones que van acorde a la 
	 * gramática.
	 *
	 */
	private void termino_Prima() {
		if(token_Entrada=='*') {
			hacerMatch(token_Entrada);
			notacionPrefija.add("*");
			factor();
			termino_Prima();
			notacionPosfija.add("*");
		} else if(token_Entrada=='/') {
			hacerMatch(token_Entrada);
			notacionPrefija.add("/");
			factor();
			termino_Prima();
			notacionPosfija.add("/");
		} else {
			//epsilon
		}
		
	}

	/*
	 * Function: Factor
	 * Funcion similar a termino prima en donde se evaluan los factores, que empiezan
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
			//Nuevo
			
			numero();
			}
		
	}

	/*
	 * Function: Expresion_Prima
	 * funcion que verifica que el simbolo de entrada presente cuando sea llamada sea 
	 * terminal, para inmediatamente hacer match y continuar con la derivación de la gramática.
	 *
	 */
	private void expresion_Prima() {
		if(token_Entrada=='+') {
			hacerMatch(token_Entrada);
			//nuevo
			//System.out.println("+");
			notacionPrefija.add("+");
			termino();
			expresion_Prima();
			notacionPosfija.add("+");
		} else if(token_Entrada=='-') {
				hacerMatch(token_Entrada);
				notacionPrefija.add("-");
				termino();
				expresion_Prima();
				notacionPosfija.add("-");
			}else {
				//Epsilon
		}
	}
	
	
	

	/*
	 * Function: numero.
	 * Función encargada de verificar los numeros encontrados en la cadena principal
	 * para verificar su derivación.
	 */
	public void numero() {
		digito();
		numero_Prima();
	}
	
	/*
	 * Function: numero_Prima.
	 * Función utilizada para eliminar la recursividad por la izquierda de la función 
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
	 * Function: digito.
	 * Función encargada de verificar la derivación de digito. Cuando no es dígito, marca
	 * error en la posición actual del token de entrada.
	 *
	 */
	private void digito() {
		if(isDigito(token_Entrada)) {
			notacionPrefija.add(token_Entrada+"");
			notacionPosfija.add(token_Entrada+"");
			hacerMatch(token_Entrada);
		} else {
			System.out.println("error en posición " + posicion);
			arrayErrores.add("Error en posición " + posicion);
		}
		
	}
	
	/*
	 * Function: isDigito.
	 * Método encargado de verificar que los token de entrada sean dígitos. Recibe el token
	 * que se quiere analizar y lo convierte a un entero para así buscar su equivalente valor en un array de 
	 * digitos. Se tiene una bandera que cambia su estado a True al encontrar el digito en el array.
	 * Parameters: 
	 *  token_Entrada - Character analisado
	 * Returns:
	 *  boolean 
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
	 * Function: hacerMatch
	 * Función encargada de dar paso al siguiente token si las reglas de derivación
	 * van acorde a lo que se tiene planteado en la gramática. No retorna ningún valor.
	 * Parameters:
	 *  t - Character
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
	 * Function: siguienteToken.
	 * Función encargada de mover el puntero en las posiciones de la cadena.
	 * Returns:
	 *  Character
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
	 * Function: primerToken.
	 * Método encargado de dar inicio al analizador entregando el primer token de la cadena
	 * a analizar y sumando por primera vez la posición del puntero.
	 * Returns: 
	 *  Character
	 */
	public char primerToken() {
		posicion+=1;
		return cadena.charAt(0);
	}
	
	/*
	 * Function: principal.
	 * Método encargado de poner en funcionamiento al analizador.
	 * Deja en orden todo lo necesario para empezar el análisis con el método expresión.
	 */
	public void principal() {
		posicion = 0;
		token_Entrada = primerToken();
		expresion();
	}
	
	static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPreFix(String expression){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor "("
                result.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
            result.append(stack.pop());
        }
        
        result.reverse();
        String aux = result.toString();
        
        return aux;
    }
	


}
