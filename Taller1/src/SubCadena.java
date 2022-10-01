import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


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
	
	public ArrayList<String> fillSeparadores() {
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
		
	public ArrayList<String> fillOperadores(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("+"); temp.add("-"); temp.add("*"); temp.add("/"); temp.add("%");
		temp.add("="); temp.add("+="); temp.add("-="); temp.add("<="); temp.add(">=");
		temp.add("/="); temp.add("*="); temp.add("%="); temp.add(">"); temp.add("<");
		temp.add("&&"); temp.add("||"); temp.add("&"); temp.add("|"); temp.add("++");
		temp.add("--");
		return temp;
	}
	
	public ArrayList<String> fillFind(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("while");
		temp.add("for");
		temp.add("if");
		return temp;
	}
	
	
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
	
	/*
	 * Metodo: clasificar token
	 * 
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