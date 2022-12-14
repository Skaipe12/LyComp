import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Versi?n del archivo que no se envi?

public class SubCadena {
	
	
	//Se inicializan las listas contenedoras de todos los simbolos a identificar en lenguaje java.
	ArrayList<String> separadores = new ArrayList<String>();
	ArrayList<String> operadores = new ArrayList<String>();
	ArrayList<String> identificadores = new ArrayList<String>();
	ArrayList<String> find = new ArrayList<String>();
	ArrayList<String> tipo2 = new ArrayList<String>();
	ArrayList<String> tipo3 = new ArrayList<String>();
	ArrayList<String> naturales = new ArrayList<String>();
	static ArrayList<Integer> numeros = new ArrayList<Integer>();
	static ArrayList<String> expresiones = new ArrayList<String>();
	
	
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
		temp.add("0");temp.add("1");temp.add("3");temp.add("4"); temp.add("5");temp.add("6");temp.add("7");temp.add("8");temp.add("9");
		return temp;
	}
	
	//M?todo que llena la lista de separadores simbolos de tipo separador. 
	public ArrayList<String> fillSeparadores() {
		//Se crea una lista temporal para a?adir los separadores, y se retorna temp para que pueda ser asignado a la respectiva lista
		//																						de separadores.		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(" "); temp.add("{"); temp.add("}"); temp.add("["); temp.add("]");
		temp.add('"'+""); temp.add(","); temp.add(";"); temp.add("."); temp.add("("); temp.add(")"); 
		temp.add("\\u0009"); temp.add(":");
		return temp;
	}
	
	//Para la identificaci?n de los tipos, que en nuestro caso sigue la la jerarquia: 
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
	
	
	//Se crea una lista temporal para a?adir los Operadores, y se retorna temp para que pueda ser asignado a la respectiva lista
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
	
	//Se utiliza este metodo para identificar algunas palabras clave. El proceso de retorno y su asignaci?n en el constructor es similar a
	//																							Operadores y Separadores
	public ArrayList<String> fillFind(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("while");
		temp.add("for");
		temp.add("if");
		return temp;
	}
	
	
	//Metodo para leer el fichero, recibe un BufferedReader que manda cada linea al m?todo cerebro el cual procesa la cadena.
	public static void leer(BufferedReader doc) throws IOException {
		String linea;
		int contador = 0;
		SubCadena sc = new SubCadena();
		//Para hasta la primera linea nula
		while((linea = doc.readLine()) != null) {
			sc.cerebro(linea, contador);
			contador++; 
		}
		
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
		for (int i = 0; i < expresiones.size(); i++) {
			System.out.print(expresiones.get(i));
		}
		
	}
	
	//falta add identificador con valor numerico.
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

	
	//Metodo para buscar o agregar un identificador, recibe la cadena a buscar, x el cual es su posici?n en la linea y la linea.
	public void buscar(String s, int x, int linea) {
		//Si hay una cadena vac?a no hace nada
		if(s.equals("")) {
			//Se busca primero si la cadena enviada es una palabra reservada perteneciente a las definidas en la lista.
		}else if(find.contains(s)) {
			System.out.println(s + "\t\t\t" + linea + ", " + x + "\t\t\tPalabra Reservada");
			//Si el identificador no existe, lo agrega.
		}else if(!identificadores.contains(s)) {
			identificadores.add(s);
			System.out.println(s + "\t\t\t" + linea + ", " + x + "\t\t\tidentificador");
			//Si s? lo tiene, imprime su ubicaci?n-
		}else if(identificadores.contains(s)) {
			System.out.println(s + "\t\t\t" + linea + ", " + x + "\t\t\tIdentificador");

		}
	}
	
//Metodo utilizado para procesar la cadena para analizarla y clasificarla. 
	public void cerebro(String s, int linea) {
		int cont=0;;
		//La variable inicio se restaurar? cada vez que se detecte un nuevo s?mbolo a analizar
		int inicio = 0;
		//Subcadena que se utilizara para manipular cada s?mbolo encontrado. Se env?a a m?todos externos.
		String subString;
		//Este for analiza cada linea del fichero, esta linea llega desde el parametro .
		for(int x = 0; x < s.length(); x++) {
			
			//Se pregunta si es separador o operador (ambos separan). Esto nos define un s?mbolo completo para analizar.
			if(separadores.contains(s.charAt(x)+"") || operadores.contains(s.charAt(x) + "")) {
				//Se identifica si es separador o operador
				if(separadores.contains(s.charAt(x)+"")) {
					
					subString = s.substring(inicio, x);
					if(analizarNumero(subString)==true && !(subString.compareTo("")==0)) {
						expresiones.add(subString+" " +s.charAt(x));
					}
					//El simbolo identificado se manda al metodo buscar
					buscar(subString, inicio, linea);
					//Se imprime la respectiva ubicaci?n del separador
					System.out.println(s.charAt(x) + "\t\t\t" + linea + ", " + x + "\t\t\tSeparador");
					//Operaciones varias para manejar el tama?o de la cadena a analizar
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
						//Se imprime la respectiva ubicaci?n del operador
						System.out.print(s.charAt(x - 1) + s.charAt(x) + "\t\t\t" + linea + ", " + x );
						definir(s);
					}else {
						//Si el operador tiene un solo caracter.
						subString = s.substring(inicio, x);
						if(analizarNumero(subString)==true && !(subString.compareTo("")==0)) {
							expresiones.add(subString+" " +s.charAt(x));
						}
						
						buscar(subString, inicio, linea);
						inicio = x + 1;
						//Se imprime la respectiva ubicaci?n del operador
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
//Plan de accion:
//1. Crear ArrayList donde se guarden valores desde el 0-9 =Done
//2. Crear un arraylist Numeros vacio, donde a medida que se lea el codigo, vaya guardando los numeros encontrados y los identificadores que tengan un valor numerico = Done
//3. Codigo para identificar operaciones aritmeticas con la estructura numero + Operador + numero. Obviando espacios = SemiDone (falta tokens con valores numericos)
//4. Tabla de tokens, Preguntar.
//5. Interfaz para mostrar lo que se muestra en consola.
 /* 
  * INPUT ACTUAL: 
  * 3+1;
p?pe
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