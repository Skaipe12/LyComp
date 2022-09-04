import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SubCadena {
	
	
	//Se inicializan las listas contenedoras de todos los simbolos a identificar en lenguaje java, contadores y textos de output.
	ArrayList<ArrayList<String>> separadores = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> operadores = new ArrayList<ArrayList<String>>();
	ArrayList<String> identificadores = new ArrayList<String>();
	ArrayList<ArrayList<String>> palabraReservada = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> comparadores = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> tipo3 = new ArrayList<ArrayList<String>>();
	ArrayList<String> opAritmeticos = new ArrayList<String>();
	ArrayList<String> naturales = new ArrayList<String>();
	static ArrayList<Integer> numeros = new ArrayList<Integer>();
	static ArrayList<String> expresiones = new ArrayList<String>();
	static String texto;
	static String texto2;
	static int contTokenIdent = 32;
	
	//Constructor en donde se llenan cada una de las listas anteriores con metodos fill para cara tipo.
	//los metodos fill estan detallados mas abajo.
	
	public SubCadena(File doc) {
		super();
		this.separadores = fillSeparadores();
		this.operadores = fillOperadores();
		this.palabraReservada = fillReservadas();
		this.comparadores = fillComparadores();
		this.tipo3 = fillTipo3();
		this.naturales = fillNaturales();
		this.opAritmeticos = fillOpAritmeticos();
		
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
		this.palabraReservada = fillReservadas();
		this.comparadores = fillComparadores();
		this.tipo3 = fillTipo3();
		this.naturales = fillNaturales();
		this.opAritmeticos = fillOpAritmeticos();
		
	}
	
	public ArrayList<ArrayList<String>> fillSeparadores() {																						
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> lexema = new ArrayList<String>();
		ArrayList<ArrayList<String>> contenedor = new ArrayList<ArrayList<String>>();
		temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");temp.add('"'+""); temp.add(","); temp.add(";"); 
		temp.add("."); temp.add("("); temp.add(")"); temp.add("\t"); temp.add(":");
		lexema.add("SeparadorEsp"); lexema.add("LlaveIZq"); lexema.add("LlaveDer"); lexema.add("CorcheteIzq"); lexema.add("CorcheteDer");
		lexema.add("SeparadorComillas"); lexema.add("SeparadorComa"); lexema.add("SeparadorPuntoComa"); lexema.add("SeparadorPunto"); 
		lexema.add("ParentIzq"); lexema.add("ParentDer"); lexema.add("SeparadorTab"); lexema.add("SeparadorDosPuntos");
		contenedor.add(temp); contenedor.add(lexema);
		return contenedor;
	}
	
	public ArrayList<ArrayList<String>> fillOperadores(){
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> lexema = new ArrayList<String>();
		ArrayList<ArrayList<String>> contenedor = new ArrayList<ArrayList<String>>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%"); temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); 
		temp.add(">="); temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<"); temp.add("&&"); temp.add("||"); temp.add("&"); 
		temp.add("|"); temp.add("++"); temp.add("--");
		lexema.add("OperadorMas"); lexema.add("OperadorMenos"); lexema.add("OperadorMult"); lexema.add("OperadorDiv"); lexema.add("OperadorMod");
		lexema.add("OperadorIgual"); lexema.add("OperadorMasIgual"); lexema.add("OperadorMenosIgual"); lexema.add("ComparadorMenorIgualQue"); 
		lexema.add("ComparadorMayorIgualQue"); lexema.add("OperadorDivIgual"); lexema.add("OperadorMultIgual"); lexema.add("OperadorModIgual"); 
		lexema.add("ComparadorMayorQue"); lexema.add("ComparadorMenorQue"); lexema.add("OperadorY"); lexema.add("OperadorO"); lexema.add("OperadorY"); 
		lexema.add("OperadorO"); lexema.add("OperadorMasMas"); lexema.add("OperadorMenosMenos");
		contenedor.add(temp); contenedor.add(lexema);
		return contenedor;
	}
	
	public ArrayList<ArrayList<String>> fillReservadas(){
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> lexema = new ArrayList<String>();
		ArrayList<ArrayList<String>> contenedor = new ArrayList<ArrayList<String>>();
		temp.add("while"); temp.add("for"); temp.add("if");
		lexema.add("ReservadaWhile"); lexema.add("ReservadaFor"); lexema.add("ReservadaIf");
		contenedor.add(temp); contenedor.add(lexema);
		return contenedor;
	}
	
	public ArrayList<ArrayList<String>> fillComparadores(){
		ArrayList<String> tipo2 = new ArrayList<String>();
		ArrayList<String> lexema = new ArrayList<String>();
		ArrayList<ArrayList<String>> contenedor = new ArrayList<ArrayList<String>>();
		tipo2.add("=="); tipo2.add(">=");tipo2.add("<="); tipo2.add(">"); tipo2.add("<"); tipo2.add("=");
		tipo2.add("+"); tipo2.add("-"); tipo2.add("*"); tipo2.add("/"); tipo2.add("%");
		lexema.add("ComparadorIgualQue"); lexema.add("ComparadorMayorIgualQue");lexema.add("ComparadorMenorIgualQue"); 
		lexema.add("ComparadorMayorQue"); lexema.add("ComparadorMenorQue"); lexema.add("OperadorIgual"); lexema.add("OperadorMas"); 
		lexema.add("OperadorMenos"); lexema.add("OperadorMult"); lexema.add("OperadorDiv"); lexema.add("OperadorMod");
		contenedor.add(tipo2); contenedor.add(lexema);
		return contenedor;
	}
	
	public ArrayList<String> fillNaturales() {
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("0");temp.add("1");temp.add("2");temp.add("3");temp.add("4"); temp.add("5");temp.add("6");temp.add("7");temp.add("8");temp.add("9");
		return temp;
	}
	
	public ArrayList<ArrayList<String>> fillTipo3(){
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> lexema = new ArrayList<String>();
		ArrayList<ArrayList<String>> contenedor = new ArrayList<ArrayList<String>>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%"); temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); 
		temp.add(">="); temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<"); temp.add("&&"); temp.add("||"); temp.add("&"); 
		temp.add("|"); temp.add("++"); temp.add("--");temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]"); temp.add(","); 
		temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); temp.add("/t"); temp.add("==");
		lexema.add("OperadorMas"); lexema.add("OperadorMenos"); lexema.add("OperadorMult"); lexema.add("OperadorDiv"); lexema.add("OperadorMod");
		lexema.add("OperadorIgual"); lexema.add("OperadorMasIgual"); lexema.add("OperadorMenosIgual"); lexema.add("ComparadorMenorIgualQue"); 
		lexema.add("ComparadorMayorIgualQue"); lexema.add("OperadorDivIgual"); lexema.add("OperadorMultIgual"); lexema.add("OperadorModIgual"); 
		lexema.add("ComparadorMayorQue"); lexema.add("ComparadorMenorQue"); lexema.add("OperadorY"); lexema.add("OperadorO"); lexema.add("OperadorY"); 
		lexema.add("OperadorO"); lexema.add("OperadorMasMas"); lexema.add("OperadorMenosMenos");lexema.add("SeparadorEsp"); lexema.add("LlaveIZq"); 
		lexema.add("LlaveDer"); lexema.add("CorcheteIzq"); lexema.add("CorcheteDer"); lexema.add("SeparadorComa"); lexema.add("SeparadorPuntoComa"); 
		lexema.add("SeparadorPunto"); lexema.add("ParentIzq"); lexema.add("ParentDer"); lexema.add("SeparadorTab"); lexema.add("ComparadorIgualQue");
		contenedor.add(temp); contenedor.add(lexema);
		return contenedor;
	}
	
	public ArrayList<String> fillOpAritmeticos(){
		ArrayList<String> tipo4 = new ArrayList<String>();
		tipo4.add("="); tipo4.add("+"); tipo4.add("-"); tipo4.add("*"); tipo4.add("/"); tipo4.add("%");
		return tipo4;
	}
	
	
	//Metodo para leer el fichero, recibe un BufferedReader que manda cada linea al m�todo cerebro el cual procesa la cadena.
	public static void leer(BufferedReader doc) throws IOException {
		String linea;
		int contador = 0;
		SubCadena sc = new SubCadena();
		while((linea = doc.readLine()) != null) {
			sc.cerebro(linea, contador);
			contador++; 
		}
		System.out.println("Numeros encontrados: ");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
		System.out.println("Expresiones encontradas: ");
		for (int i = 0; i < expresiones.size(); i++) {
			System.out.print(expresiones.get(i));
		}
		System.out.println("");
		System.out.println(texto);
		
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
		if(s.equals("")) {
		}else if(palabraReservada.contains(s)) {
			texto = texto + s + "\t" + linea + ", " + x + "\tPalabra Reservada";
		}else if(!identificadores.contains(s)) {
			identificadores.add(s);
			texto = texto + s + "\t" + linea + ", " + x + "\tidentificador";
		}else if(identificadores.contains(s)) {
			texto = texto + s + "\t" + linea + ", " + x + "\tIdentificador";
		}
		texto = texto + "\n";
	}
	
//Metodo utilizado para procesar la cadena para analizarla y clasificarla. 
	public void cerebro(String s, int linea) {
		int cont=0;;
		int inicio = 0;
		String subString;
		for(int x = 0; x < s.length(); x++) {
			if(separadores.contains(s.charAt(x)+"") || operadores.contains(s.charAt(x) + "")) {
				if(separadores.contains(s.charAt(x)+"")) {
					
					subString = s.substring(inicio, x);
					clasificarToken(subString);
					if(analizarNumero(subString)==true && !(subString.compareTo("")==0)) {
						expresiones.add(subString +s.charAt(x));
					}
					buscar(subString, inicio, linea);
					texto = texto + s.charAt(x) + "\t" + linea + ", " + x + "\tSeparador\n";
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
						texto = texto + s.charAt(x - 1) + s.charAt(x) + "\t" + linea + ", " + x ;
						definir(s);
					}else {
						subString = s.substring(inicio, x);
						if(analizarNumero(subString)==true && !(subString.compareTo("")==0)) {
							expresiones.add(subString+" " +s.charAt(x));
						}
						
						buscar(subString, inicio, linea);
						inicio = x + 1;
						texto = texto + s.charAt(x) + "\t" + linea + ", " + x;
						definir(s.charAt(x) + "");
					}
				}
			}
		}
		subString = s.substring(inicio, s.length());
		buscar(subString, inicio, linea);	
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
	case "+": {
		token = "opSuma";
		tokenId = 31;
		texto2 = texto2 + token + "\t\t" + tokenId + "\t\t" + "+" + "\n";
	}
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
		if(comparadores.contains(s)) {
			texto = texto + "\tComparador";
		}
		if(tipo3.contains(s)) {
			texto = texto + "\tSeparador";
		}
		texto = texto + "\n";
	}
}