import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Versión del archivo que no se envió

public class SubCadena {
	//Se inicializan las listas contenedoras de todos los simbolos a identificar en lenguaje java.
	ArrayList<String> separadores = new ArrayList<String>();
	ArrayList<String> operadores = new ArrayList<String>();
	ArrayList<String> identificadores = new ArrayList<String>();
	ArrayList<String> find = new ArrayList<String>();
	ArrayList<String> tipo2 = new ArrayList<String>();
	ArrayList<String> tipo3 = new ArrayList<String>();
	
	//Constructor en donde se llenan cada una de las listas anteriores con metodos fill para cara tipo.
	//los metodos fill estan detallados mas abajo.
	
	public SubCadena(File doc) {
		super();
		this.separadores = fillSeparadores();
		this.operadores = fillOperadores();
		this.find = fillFind();
		this.tipo2 = fillTipo2();
		this.tipo3 = fillTipo3();
		
		
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
		
		
	}
	
	//Método que llena la lista de separadores simbolos de tipo separador. 
	
	public ArrayList<String> fillSeparadores() {
		//Se crea una lista temporal para añadir los separadores, y se retorna temp para que pueda ser asignado a la respectiva lista
		//																						de separadores.		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");
		temp.add('"'+""); temp.add(","); temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); 
		temp.add("\\u0009"); temp.add(":");
		return temp;
	}
	
	//Para la identificación de los tipos, que en nuestro caso sigue la la jerarquia: 
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
	
	
	//Se crea una lista temporal para añadir los Operadores, y se retorna temp para que pueda ser asignado a la respectiva lista
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
	
	//Se utiliza este metodo para identificar algunas palabras clave. El proceso de retorno y su asignación en el constructor es similar a
	//																							Operadores y Separadores
	public ArrayList<String> fillFind(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("while");
		temp.add("for");
		temp.add("if");
		return temp;
	}
	
	
	//Metodo para leer el fichero, recibe un BufferedReader que manda cada linea al método cerebro el cual procesa la cadena.
	public static void leer(BufferedReader doc) throws IOException {
		String linea;
		int contador = 0;
		//Para hasta la primera linea nula
		while((linea = doc.readLine()) != null) {
			SubCadena sc = new SubCadena();
			sc.cerebro(linea, contador);
			contador++; 
		}
	}
	
	//Metodo para buscar o agregar un identificador, recibe la cadena a buscar, x el cual es su posición en la linea y la linea.
	public void buscar(String s, int x, int linea) {
		//Si hay una cadena vacía no hace nada
		if(s.equals("")) {
			//Se busca primero si la cadena enviada es una palabra reservada perteneciente a las definidas en la lista.
		}else if(find.contains(s)) {
			System.out.println(s + "\t\t\t" + linea + ", " + x + "\t\t\tPalabra Reservada");
			//Si el identificador no existe, lo agrega.
		}else if(!identificadores.contains(s)) {
			identificadores.add(s);
			System.out.println(s + "\t\t\t" + linea + ", " + x + "\t\t\tidentificador");
			//Si sí lo tiene, imprime su ubicación-
		}else if(identificadores.contains(s)) {
			System.out.println(s + "\t\t\t" + linea + ", " + x + "\t\t\tIdentificador");

		}
	}
	
//Metodo utilizado para procesar la cadena para analizarla y clasificarla. 
	public void cerebro(String s, int linea) {
		//La variable inicio se restaurará cada vez que se detecte un nuevo símbolo a analizar
		int inicio = 0;
		//Subcadena que se utilizara para manipular cada símbolo encontrado. Se envía a métodos externos.
		String subString;
		//Este for analiza cada linea del fichero, esta linea llega desde el parametro .
		for(int x = 0; x < s.length(); x++) {
			//Se pregunta si es separador o operador (ambos separan). Esto nos define un símbolo completo para analizar.
			if(separadores.contains(s.charAt(x)+"") || operadores.contains(s.charAt(x) + "")) {
				//Se identifica si es separador o operador
				if(separadores.contains(s.charAt(x)+"")) {
					subString = s.substring(inicio, x);
					//El simbolo identificado se manda al metodo buscar
					buscar(subString, inicio, linea);
					//Se imprime la respectiva ubicación del separador
					System.out.println(s.charAt(x) + "\t\t\t" + linea + ", " + x + "\t\t\tSeparador");
					//Operaciones varias para manejar el tamaño de la cadena a analizar
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
						//Se imprime la respectiva ubicación del operador
						System.out.print(s.charAt(x - 1) + s.charAt(x) + "\t\t\t" + linea + ", " + x );
						definir(s);
					}else {
						//Si el operador tiene un solo caracter.
						subString = s.substring(inicio, x);
						buscar(subString, inicio, linea);
						inicio = x + 1;
						//Se imprime la respectiva ubicación del operador
						System.out.print(s.charAt(x) + "\t\t\t" + linea + ", " + x);
						definir(s.charAt(x) + "");
					}
				}
			}
		}
		//si la linea no termina con ningun separador definido
		subString = s.substring(inicio, s.length());
		buscar(subString, inicio, linea);	
	}
	
	//Metodo para definir el tipo explicado mas ariba
	public void definir(String s) {
		if(tipo2.contains(s)) {
			System.out.print("\t\t\t\t\t\tComparador");
		}
		if(tipo3.contains(s)) {
			System.out.print("\t\t\t\tSeparador");
		}
		System.out.println("");
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

}