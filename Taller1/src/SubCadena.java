import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*class: Subcadena
 * Clase donde se guardan todos los opreadores, separadores y palabras reservadas previamente definidas.
 * Tambien guarda los identificadores y numeros que se encuentren.
 * Encargada de guardar las strings donde se van a guardar las tablas de simbolos y de tokens y el contador de identificadores.
 */
public class SubCadena {
	
	ArrayList<String> separadores = new ArrayList<String>();
	ArrayList<String> operadores = new ArrayList<String>();
	ArrayList<String> identificadores = new ArrayList<String>();
	ArrayList<String> find = new ArrayList<String>();
	ArrayList<String> tipo2 = new ArrayList<String>();
	ArrayList<String> tipo3 = new ArrayList<String>();
	ArrayList<String> naturales = new ArrayList<String>();
	ArrayList<Integer> numeros = new ArrayList<Integer>();
	static String expresiones = "";
	static String textInput="";
	static String textoSimbolos="";
	static String texto2="";
	static int contTokenIdent = 0;
	static String aux="";
	
	/*Constructor: SubCadena
	 * Inicializa la clase y llama a los metodos que van a llenar las listas.
	 * Encargada de crear el bufferedReader que contiene el txt que se desea analizar y de cerrarlo cuando se termine el analisis.
	 * Parameters:
	 * 	doc - File que tiene el txt a analizar
	 * See also:
	 * 	<leer>
	 */
	public SubCadena(File doc) {
		super();
		this.separadores = fillSeparadores();
		this.operadores = fillOperadores();
		this.find = fillFind();
		this.tipo2 = fillTipo2();
		this.tipo3 = fillTipo3();
		this.naturales = fillNaturales();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(doc));
			leer(br);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Constructor: SubCadena
	 * Inicializa la clase y llama a los metodos que van a llenar las listas.
	 */
	public SubCadena() {
		super();
		this.separadores = fillSeparadores();
		this.operadores = fillOperadores();
		this.find = fillFind();
		this.tipo2 = fillTipo2();
		this.tipo3 = fillTipo3();
		this.naturales = fillNaturales();
		
	}
	
	/*Function: fillNaturales
	 * Llena la lista de los numeros naturales y el 0
	 */
	public ArrayList<String> fillNaturales() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("0");temp.add("1");temp.add("2");temp.add("3");temp.add("4"); temp.add("5");temp.add("6");temp.add("7");temp.add("8");temp.add("9");
		return temp;
	}
	
	/*Function: fillSeparadores
	 * Llena la lista de los separadores predefinidos
	 */
	public ArrayList<String> fillSeparadores() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");
		temp.add('"'+""); temp.add(","); temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); 
		temp.add("\t"); temp.add(":");
		return temp;
	}
	
	/*Function: fillTipo2
	 * Llena la lista de operadores.
	 */
	public ArrayList<String> fillTipo2(){
		ArrayList<String> tipo2 = new ArrayList<String>();
		tipo2.add("=="); tipo2.add(">=");tipo2.add("<="); tipo2.add(">"); tipo2.add("<"); tipo2.add("=");
		tipo2.add("+"); tipo2.add("-"); tipo2.add("*"); tipo2.add("/"); tipo2.add("%");
		return tipo2;
	}
	
	/*Function: fillTipo3
	 * Llena la lista de separadores y operadores que funcionan como estos.
	 */
	public ArrayList<String> fillTipo3(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%");
		temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); temp.add(">=");
		temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<");
		temp.add("&&"); temp.add("||"); temp.add("&"); temp.add("|"); temp.add("++");
		temp.add("--");temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");
		temp.add(","); temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); temp.add("\t"); temp.add("=="); temp.add(";");

		return temp;
	}
		
	/*Function: fillOperadores
	 * Llena la lista de operadores.
	 */
	public ArrayList<String> fillOperadores(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%");
		temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); temp.add(">=");
		temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<");
		temp.add("&&"); temp.add("||"); temp.add("&"); temp.add("|"); temp.add("++");
		temp.add("--");
		return temp;
	}
	
	/*Function: fillFind
	 * Llena la lista de las palabras reservadas
	 */
	public ArrayList<String> fillFind(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("while");
		temp.add("for");
		temp.add("if");
		return temp;
	}
	
	/*Function: leer
	 * Funcion que resive un BufferedReader que divide el txt linea por linea, para ir analizandolas una por una,
	 * se crea el objeto subcadena, y desde aqui se llama el metodo cerebro del objeto subcadena.
	 * Tambien se llama al metodo clasificarExpresion.
	 * Parameters:
	 * 	doc - BufferedReader que contiene el txt.
	 * Returns:
	 * 	Void
	 * See also:
	 * 	<cerebro> <clasificarExpresiones>
	 */
	public void leer(BufferedReader doc) throws IOException {
		String linea;
		int contador = 0;
		SubCadena sc = new SubCadena();
		while((linea = doc.readLine()) != null) {
			textInput += linea + "\n";
			sc.cerebro(linea, contador);
			clasificarExpresiones(linea,contador);
			contador++; 
		}
		System.out.println("Numeros encontrados: ");
		for (int i = 0; i < sc.numeros.size(); i++) {
			System.out.println(sc.numeros.get(i));
		}
		System.out.println(textoSimbolos);
	}
	
	/*Function: AnalizarNumero
	 * Verifica si el token recibido es un número.
	 * Parameters: 
	 * 	s - String que se clasifica.
	 * 	x - Posicion de la string.
	 * 	linea - Linea donde esta la string que se analiza.
	 * Returns:
	 * 	Void
	 * See also:
	 * 	<clasificarToken>
	 */
	public boolean analizarNumero(String token) {
		int cont=0;
		for (int i = 0; i < token.length(); i++) {
			if(naturales.contains(token.charAt(i)+"")) {
				cont++;
			}
		}
		if(cont==token.length()) {
			if(token.compareTo("")==0) {
			} else {
				numeros.add(Integer.parseInt(token));
				return true;
			}
		}
		return false;
	}

	/*Function: buscar
	 * Clasifica una string entre palabara reservada y identificador, agregando el ultimo a una lista de identificadores si no se encuntra en esta.
	 * Va agregando informacion a la string que mostrara la informacion de la tabla de simbolos.
	 * Llama al metodo clasificarToken
	 * Parameters: 
	 * 	s - String que se clasifica.
	 * 	x - Posicion de la string.
	 * 	linea - Linea donde esta la string que se analiza.
	 * Returns:
	 * 	Void
	 * See also:
	 * 	<clasificarToken>
	 */
	public void buscar(String s, int x, int linea) {
		if(s.equals("")) {
		}else if(find.contains(s)) {
			textoSimbolos = textoSimbolos + s + "\t" + linea + ", " + x + "\tPalabra Reservada";
			clasificarToken(s);
		}else if(!identificadores.contains(s)) {
			identificadores.add(s);
			textoSimbolos = textoSimbolos + s + "\t" + linea + ", " + x + "\tidentificador";
			clasificarToken(s);
		}else if(identificadores.contains(s)) {
			textoSimbolos = textoSimbolos + s + "\t" + linea + ", " + x + "\tIdentificador";
			clasificarToken(s);
		}
		textoSimbolos = textoSimbolos + "\n";
	}
	
	/*Function: cerebro
	 * Metodo principal que divide la string resivida palabra por palabra, y separador por separador, para despues llamar a los metodos
	 * que clasifican la string.
	 * Tambien es el metodo encargado de agregar los separadores al texto que mostrara la tabla de simbolos. 
	 * Parameters:
	 * 	s - String que contiene el texto de una sola linea del txt que se analiza.
	 * 	linea - La linea que se esta analizando.
	 * Returns:
	 * 	Void
	 * See also:
	 * 	<buscar> <clasificarToken> <definir>
	 */
	public void cerebro(String s, int linea) {
		int inicio = 0;
		String subString;
		for(int x = 0; x < s.length(); x++) {
			if(separadores.contains(s.charAt(x)+"") || operadores.contains(s.charAt(x) + "")) {
				if(separadores.contains(s.charAt(x)+"")) {
					subString = s.substring(inicio, x);
					clasificarToken(s.charAt(x) + "");
					buscar(subString, inicio, linea);
					textoSimbolos = textoSimbolos + s.charAt(x) + "\t" + linea + ", " + x + "\tSeparador\n";
					if(x + 1 < s.length() && separadores.contains(s.charAt(x + 1)+"")) {
						int y = 1;
						while(x + y < s.length() && separadores.contains(s.charAt(x + y)+"")) {
							y++;
						}
						inicio = x + y;
						x = inicio - 1;
					}else {
						inicio = x + 1;
					}
				}else {
					if(x + 1 < s.length() && operadores.contains(s.charAt(x + 1) + "")) {
						subString = s.substring(inicio, x);
						buscar(subString, inicio, linea);
						x++;
						inicio = x + 1;
						textoSimbolos = textoSimbolos + s.charAt(x - 1) + s.charAt(x) + "\t" + linea + ", " + x ;
						definir(s);
					}else {
						subString = s.substring(inicio, x);
						buscar(subString, inicio, linea);
						inicio = x + 1;
						textoSimbolos = textoSimbolos + s.charAt(x) + "\t" + linea + ", " + x;
						definir(s.charAt(x) + "");
					}
				}
			}
		}
		subString = s.substring(inicio, s.length());
		buscar(subString, inicio, linea);	
	}
	
	
	/*
	 * Function: VerificarIzq
	 * Se encarga de verificar una cadena a la izquierda de cada expresión encontrada, esta se define
	 * cada vez que encuentre un operador.
	 * Parameters:
	 * 	cadenaIzq - String que contiene la cadena a la izquierda del operador.
	 * returns:
	 * 	Retorna la cadena analizada analizada invertida, pues el análisis se da de derecha a izquierda.
	 */
	public String verificarIzq(String cadenaIzq) {
		String aux="";
		for (int i = cadenaIzq.length()-1; i >= 0; i--) {
			if(analizarNumero(cadenaIzq.charAt(i)+"")==true||cadenaIzq.charAt(i)=='('||operadores.contains(cadenaIzq.charAt(i)+"")) {
				aux+=cadenaIzq.charAt(i);
			} else {
				break;
			}
		}
		StringBuilder stringBuilder = new StringBuilder(aux);
		String invertida = stringBuilder.reverse().toString();
		
		return invertida;
		
	}
	
	/*
	 * Function: VerificarDer
	 * Se encarga de verificar una cadena a la derecha de cada expresión encontrada, esta se define
	 * cada vez que encuentre un operador.
	 * Parameters:
	 * 	cadenaDer - String que contiene la cadena a la derecha del operador.
	 * returns:
	 * 	Retorna la cadena analizada analizada.
	 */
	public String verificarDer(String cadenaDer) {
		String aux="";
		for (int i = 0; i < cadenaDer.length(); i++) {
			if(analizarNumero(cadenaDer.charAt(i)+"")==true||cadenaDer.charAt(i)==')'||operadores.contains(cadenaDer.charAt(i)+"")) {
				if(cadenaDer.charAt(i)+""!=";") {
				aux+=cadenaDer.charAt(i);
				}
			} else {
				break;
			}
		}
		
		return aux;
		
	}
	
	/*
	 * Function: clasificarExpresiones
	 * Se encarga de clasificar las expresiones encontradas. Lo que hace es partir una expresion aritmética
	 * en dos cadenas y un símbolo. Las cadenas son las que están a la derecha e izquierda del simbolo.
	 * El símbolo corresponde al operador que separa la expresión.
	 * Parameters:
	 * 	str - String que contiene la cadena a analizar
	 *  posición - int que nos dice la posición donde encuentra la expresión aritmetica.
	 * returns:
	 * 	void.
	 */
	public void clasificarExpresiones(String str, int posicion) {
		String subString;
		String strAuxIzq;
		String strAuxDer;
		int inicio=0;
		for (int i = 0; i < str.length(); i++) {
			if(operadores.contains(str.charAt(i)+"")) {
				strAuxIzq = verificarIzq(str.substring(0, i));
				inicio = i+1;
				strAuxDer = verificarDer(str.substring(inicio,str.length()));
				if(strAuxIzq.equals("") && strAuxDer.equals("")) {
					break;
				}
				subString = strAuxIzq+str.charAt(i)+strAuxDer;
				i = str.indexOf(str.charAt(i))+strAuxDer.length()+2;
				System.out.println(subString);
				expresiones+= subString + "\n";
			}
		}
	}
	
	/*
	 * Function: clasificarToken
	 * Clasifica una string en los token predefinidos y leas asigna su respectivo tokenId.
	 * Va agregando informacion a la string que mostrara la informacion de la tabla de tokens.
	 * Parameters:
	 * 	lexema - String que contiene el token a clasificar
	 * returns:
	 * 	void
	 */
	private void clasificarToken(String lexema) {
	int tokenId=0;
	String token;
		switch (lexema) {
	case "if": {
		token = "CondIf";
		tokenId = 101;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "if" + "\n";
		break;
	}
	case "(": {
		token = "parentIzq";
		tokenId = 201;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "(" + "\n";
		break;
	}
	
	case "+": {
		token = "opSuma";
		tokenId = 301;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "+" + "\n";
		break;
	}
	case "-": {
		token = "opResta";
		tokenId = 302;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "-" + "\n";
		break;
	}
	
	case ">=": {
		token = "mayorIgual";
		tokenId = 401;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ">=" + "\n";
		break;
	}
	
	case "<=": {
		token = "menorIgual";
		tokenId = 402;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "<=" + "\n";
		break;
	}
	case ";": {
		token = "puntoComa";
		tokenId = 210;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ";" + "\n";
		break;
	}
	case "<": {
		token = "menor";
		tokenId = 403;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "<" + "\n";
		break;
	}
	case ">": {
		token = "mayor";
		tokenId = 404;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ">" + "\n";
		break;
	}
	case "while": {
		token = "condWhile";
		tokenId = 102;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "while" + "\n";
		break;
	}
	case "{": {
		token = "llaveIzq";
		tokenId = 203;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "{" + "\n";
		break;
	}
	case "}": {
		token = "llaveDer";
		tokenId = 204;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "}" + "\n";
		break;
	}
	case "[": {
		token = "corcheteIzq";
		tokenId = 205;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "[" + "\n";
		break;
	}
	case "]": {
		token = "corcheteDer";
		tokenId = 206;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "]" + "\n";
		break;
	}
	case ":": {
		token = "dosPuntos";
		tokenId = 207;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ":" + "\n";
		break;
	}
	case " ": {
		token = "espacio";
		tokenId = 208;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + " " + "\n";
		break;
	}
	case "\t": {
		token = "tabulador";
		tokenId = 209;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "\t" + "\n";
		break;
	}
	
	case "=": {
		token = "Operadorigual";
		tokenId = 303;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "=" + "\n";
		break;
	}
	case "==": {
		token = "OperadorigualIgual";
		tokenId = 405;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" +"==" + "\n";
		break;
	}
	case "*": {
		token = "OperadorMultiplicacion";
		tokenId = 304;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "*" + "\n";
		break;
	}
	case "/": {
		token = "OperadorDiv";
		tokenId = 305;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "/" + "\n";
		break;
	}
	case "%": {
		token = "OperadorMod";
		tokenId = 306;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "%" + "\n";
		break;
	}
	case "+=": {
		token = "opMasIgual";
		tokenId = 307;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "+=" + "\n";
		break;
	}
	case "-=": {
		token = "opMenosIgual";
		tokenId = 308;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "-=" + "\n";
		break;
	}
	case "/=": {
		token = "opDivisonIgual";
		tokenId = 309;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "/=" + "\n";
		break;
	}
	case "*=": {
		token = "OperadorMultpIgual";
		tokenId = 310;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "*=" + "\n";
		break;
	}
	case "++": {
		token = "OperadorDobleMas";
		tokenId = 311;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "++" + "\n";
		break;
	}
	
	case "--": {
		token = "OperadorDobleMenos";
		tokenId = 312;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "--" + "\n";
		break;
	}
	
	case "&&": {
		token = "comparador&&";
		tokenId = 406;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" +"&&" + "\n";
		break;
	}
	
	case "&": {
		token = "comparador&";
		tokenId = 407;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "&" + "\n";
		break;
	}
	case "||": {
		token = "comparador||";
		tokenId = 408;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "||" + "\n";
		break;
	}
	case ")": {
		token = "parentDer";
		tokenId = 202;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "+" + "\n";
		break;
	}
	default:
		if(lexema.equals("")) {
			
		}else {
			if(identificadores.contains(lexema)) {
				token = "Identificador";
				tokenId = identificadores.indexOf(lexema)+501;
				texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + lexema + "\n";
			} else {
				token = "identificador";
				tokenId += contTokenIdent + 500;
				texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + lexema + "\n";
				contTokenIdent++;
			}
		}
	}
		
}

	/*Function: definir
	 * Clasifica en la tabla de simbolos si la string es un comparador o separador.
	 * Parameters:
	 * 	s - String que se va a clasificar
	 * returns:
	 * 	void
	 * See also:
	 * 	<clasificarToken>
	 */
	public void definir(String s) {
		if(tipo2.contains(s)) {
			textoSimbolos = textoSimbolos + "\tComparador";
		}
		if(tipo3.contains(s)) {
			textoSimbolos = textoSimbolos + "\tSeparador";
		}
		clasificarToken(s);
		textoSimbolos = textoSimbolos + "\n";
	}

}