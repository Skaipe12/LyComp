import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SubCadena {
	
	
	//Se inicializan las listas contenedoras de todos los simbolos a identificar en lenguaje java, contadores y textos de output.
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
	static int contTokenIdent = 32;
	static String aux="";
	
	
	//Constructor en donde se llenan cada una de las listas anteriores con metodos fill para cara tipo.
	//los metodos fill estan detallados mas abajo.
	
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
	
	public SubCadena() {
		super();
		this.separadores = fillSeparadores();
		this.operadores = fillOperadores();
		this.find = fillFind();
		this.tipo2 = fillTipo2();
		this.tipo3 = fillTipo3();
		this.naturales = fillNaturales();
		
	}
	
	
	
	public ArrayList<String> fillNaturales() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("0");temp.add("1");temp.add("2");temp.add("3");temp.add("4"); temp.add("5");temp.add("6");temp.add("7");temp.add("8");temp.add("9");
		return temp;
	}
	
	//M�todo que llena la lista de separadores simbolos de tipo separador. 
	public ArrayList<String> fillSeparadores() {
		//Se crea una lista temporal para a�adir los separadores, y se retorna temp para que pueda ser asignado a la respectiva lista
		//																						de separadores.		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");
		temp.add('"'+""); temp.add(","); temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); 
		temp.add("\t"); temp.add(":");
		return temp;
	}
	
	//Para la identificaci�n de los tipos, que en nuestro caso sigue la la jerarquia: 
//	tipo 1: identificadores
//	tipo 2: comparadores
//	tipo 3: separadores
	
	public ArrayList<String> fillTipo2(){
		ArrayList<String> tipo2 = new ArrayList<String>();
		tipo2.add("=="); tipo2.add(">=");tipo2.add("<="); tipo2.add(">"); tipo2.add("<"); tipo2.add("=");
		tipo2.add("+"); tipo2.add("-"); tipo2.add("*"); tipo2.add("/"); tipo2.add("%");
		return tipo2;
	}
	
	
	
	public ArrayList<String> fillTipo3(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%");
		temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); temp.add(">=");
		temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<");
		temp.add("&&"); temp.add("||"); temp.add("&"); temp.add("|"); temp.add("++");
		temp.add("--");temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");
		temp.add(","); temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); temp.add("	"); temp.add("=="); temp.add(";");

		return temp;
	}
	
	
	//Se crea una lista temporal para a�adir los Operadores, y se retorna temp para que pueda ser asignado a la respectiva lista
			//																						de Operadores.		
	public ArrayList<String> fillOperadores(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%");
		temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); temp.add(">=");
		temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<");
		temp.add("&&"); temp.add("||"); temp.add("&"); temp.add("|"); temp.add("++");
		temp.add("--");
		return temp;
	}
	
	//Se utiliza este metodo para identificar algunas palabras clave. El proceso de retorno y su asignaci�n en el constructor es similar a
	//																							Operadores y Separadores
	public ArrayList<String> fillFind(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("while");
		temp.add("for");
		temp.add("if");
		return temp;
	}
	
	
	//Metodo para leer el fichero, recibe un BufferedReader que manda cada linea al m�todo cerebro el cual procesa la cadena.
	public void leer(BufferedReader doc) throws IOException {
		String linea;
		int contador = 0;
		SubCadena sc = new SubCadena();
		//Para hasta la primera linea nula
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

	
	//Metodo para buscar o agregar un identificador, recibe la cadena a buscar, x el cual es su posici�n en la linea y la linea.
	public void buscar(String s, int x, int linea) {
		//Si hay una cadena vac�a no hace nada
		if(s.equals("")) {
			//Se busca primero si la cadena enviada es una palabra reservada perteneciente a las definidas en la lista.
		}else if(find.contains(s)) {
			//texto = texto + s + "\t" + linea + ", " + x + "\tPalabra Reservada";
			textoSimbolos = textoSimbolos + s + "\t" + linea + ", " + x + "\tPalabra Reservada";
			//Si el identificador no existe, lo agrega.
		}else if(!identificadores.contains(s)) {
			identificadores.add(s);
			textoSimbolos = textoSimbolos + s + "\t" + linea + ", " + x + "\tidentificador";
			//Si s� lo tiene, imprime su ubicaci�n-
		}else if(identificadores.contains(s)) {
			textoSimbolos = textoSimbolos + s + "\t" + linea + ", " + x + "\tIdentificador";
		}
		textoSimbolos = textoSimbolos + "\n";
	}
	
//Metodo utilizado para procesar la cadena para analizarla y clasificarla. 
	public void cerebro(String s, int linea) {
		int cont=0;;
		//La variable inicio se restaurar� cada vez que se detecte un nuevo s�mbolo a analizar
		int inicio = 0;
		//Subcadena que se utilizara para manipular cada s�mbolo encontrado. Se env�a a m�todos externos.
		String subString;
		//Este for analiza cada linea del fichero, esta linea llega desde el parametro .
		for(int x = 0; x < s.length(); x++) {
			
			//Se pregunta si es separador o operador (ambos separan). Esto nos define un s�mbolo completo para analizar.
			if(separadores.contains(s.charAt(x)+"") || operadores.contains(s.charAt(x) + "")) {
				//Se identifica si es separador o operador
				if(separadores.contains(s.charAt(x)+"")) {
					subString = s.substring(inicio, x);
					clasificarToken(subString);
					//El simbolo identificado se manda al metodo buscar
					buscar(subString, inicio, linea);
					//Se agrega la respectiva ubicaci�n del separador
					textoSimbolos = textoSimbolos + s.charAt(x) + "\t" + linea + ", " + x + "\tSeparador\n";
					//Operaciones varias para manejar el tama�o de la cadena a analizar
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
					//Si el que los separa no es separador sino operador y el operador tiene dos caracteres
					if(x + 1 < s.length() && operadores.contains(s.charAt(x + 1) + "")) {
						subString = s.substring(inicio, x);
						//Se envia al metodo buscar para definir el simbolo o palabra reservada.
						buscar(subString, inicio, linea);
						x++;
						inicio = x + 1;
						//Se agrega la respectiva ubicaci�n del operador
						textoSimbolos = textoSimbolos + s.charAt(x - 1) + s.charAt(x) + "\t" + linea + ", " + x ;
						definir(s);
					}else {
						//Si el operador tiene un solo caracter.
						subString = s.substring(inicio, x);
						buscar(subString, inicio, linea);
						inicio = x + 1;
						//Se agrega la respectiva ubicaci�n del operador
						textoSimbolos = textoSimbolos + s.charAt(x) + "\t" + linea + ", " + x;
						definir(s.charAt(x) + "");
					}
				}
			}
		}
		//si la linea no termina con ningun separador definido
		subString = s.substring(inicio, s.length());
		buscar(subString, inicio, linea);	
	}
	
	
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
	
	//Switch case para identificar correctamente el token y su id
	private void clasificarToken(String lexema) {
	int tokenId=0;
	String token;
		switch (lexema) {
	case "if": {
		token = "CondIf";
		tokenId = 1;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "if" + "\n";
	}
	case "(": {
		token = "parentIzq";
		tokenId = 2;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "(" + "\n";
	}
	
	case ")": {
		token = "opSuma";
		tokenId = 3;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ")" + "\n";
	}
	case "-": {
		token = "opResta";
		tokenId = 4;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "-" + "\n";
	}
	
	case ">=": {
		token = "mayorIgual";
		tokenId = 5;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ">=" + "\n";
	}
	
	case "<=": {
		token = "menorIgual";
		tokenId = 6;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "<=" + "\n";
	}
	case ";": {
		token = "puntoComa";
		tokenId = 7;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ";" + "\n";
	}
	case "<": {
		token = "menor";
		tokenId = 8;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "<" + "\n";
	}
	case ">": {
		token = "mayor";
		tokenId = 9;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ">" + "\n";
	}
	case "while": {
		token = "condWhile";
		tokenId = 10;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "while" + "\n";
	}
	case "{": {
		token = "llaveIzq";
		tokenId = 11;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "{" + "\n";
	}
	case "}": {
		token = "llaveDer";
		tokenId = 12;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "}" + "\n";
	}
	case "[": {
		token = "corcheteIzq";
		tokenId = 13;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "[" + "\n";
	}
	case "]": {
		token = "corcheteDer";
		tokenId = 14;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "]" + "\n";
	}
	case ":": {
		token = "dosPuntos";
		tokenId = 15;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + ":" + "\n";
	}
	case " ": {
		token = "espacio";
		tokenId = 16;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + " " + "\n";
	}
	case "\t": {
		token = "tabulador";
		tokenId = 17;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "\t" + "\n";
	}
	
	case "=": {
		token = "Operadorigual";
		tokenId = 18;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "=" + "\n";
	}
	case "==": {
		token = "OperadorigualIgual";
		tokenId = 19;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" +"==" + "\n";
	}
	case "*": {
		token = "OperadorMultiplicacion";
		tokenId = 20;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "*" + "\n";
	}
	case "/": {
		token = "OperadorDiv";
		tokenId = 21;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "/" + "\n";
	}
	case "%": {
		token = "OperadorMod";
		tokenId = 22;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "%" + "\n";
	}
	case "+=": {
		token = "opMasIgual";
		tokenId = 23;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "+=" + "\n";
	}
	case "-=": {
		token = "opMenosIgual";
		tokenId = 24;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "-=" + "\n";
	}
	case "/=": {
		token = "opDivisonIgual";
		tokenId = 25;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "/=" + "\n";
	}
	case "*=": {
		token = "OperadorMultpIgual";
		tokenId = 26;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "*=" + "\n";
	}
	case "++": {
		token = "OperadorDobleMas";
		tokenId = 27;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "++" + "\n";
	}
	
	case "--": {
		token = "OperadorDobleMenos";
		tokenId = 28;
		texto2 = texto2 + token + "\t" + tokenId + "\t\t" + "--" + "\n";
	}
	
	case "&&": {
		token = "comparador&&";
		tokenId = 29;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" +"&&" + "\n";
	}
	
	case "&": {
		token = "comparador&";
		tokenId = 29;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "&" + "\n";
	}
	case "||": {
		token = "comparador||";
		tokenId = 30;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "||" + "\n";
	}
	case ")": {
		token = "parentDer";
		tokenId = 31;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "+" + "\n";
	}
	//Debido a que hay 31 tokens predefinidos, el resto serian identificadores, por lo que se empiezan a contar desde 31
	default:
		if(lexema == "") {
			
		} else {
		if(identificadores.contains(lexema)) {
			token = "Identificador";
			tokenId = identificadores.indexOf(lexema)+32;
		} else {
			
			token = "identificador";
			tokenId += contTokenIdent;
			contTokenIdent++;
		}
	}
		}
		
}

	
	//Metodo para definir el tipo explicado mas ariba
	public void definir(String s) {
		if(tipo2.contains(s)) {
			textoSimbolos = textoSimbolos + "\tComparador";
		}
		if(tipo3.contains(s)) {
			textoSimbolos = textoSimbolos + "\tSeparador";
		}
		textoSimbolos = textoSimbolos + "\n";
	}

	//Main
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		File doc = new File("src\\input.txt");
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(doc));
//			leer(br);
//			br.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//Plan de accion:
//1. Crear ArrayList donde se guarden valores desde el 0-9 =Done
//2. Crear un arraylist Numeros vacio, donde a medida que se lea el codigo, vaya guardando los numeros encontrados y los identificadores que tengan un valor numerico = Done
//3. Codigo para identificar operaciones aritmeticas con la estructura numero + Operador + numero. Obviando espacios = SemiDone (falta tokens con valores numericos)
//4. Tabla de tokens, Preguntar.
//5. Interfaz para mostrar lo que se muestra en consola.
 /* 
  * INPUT ACTUAL: 
  * 3+1;
p�pe
brayanb
brayanb
huevos 23
556*3689=0;
	public void buscar(String s, int x, int linea) {
		if(s.equals("")) {
		}else if(find.contain(s)) {
			System.out.println(s + " posicion: " + linea + ", " + x);
		}else if(!identificadores.contains(s)) {
			identificadores.add(s);
			System.out.println("Identificador: " + s + " Posicion: " + linea + ", " + x + " Tipo 1");

		}else if(identificadores.contains(s)) {
			System.out.println("Identificador: " + s + " Posicion:" + linea + ", " + x + " Tipo 1");
>
=

		}
  * 
  * 
  * 
  * */

}