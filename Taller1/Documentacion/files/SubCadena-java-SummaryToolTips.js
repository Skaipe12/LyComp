﻿NDSummary.OnToolTipsLoaded("File:SubCadena.java",{1:"<div class=\"NDToolTip TClass LJava\"><div class=\"NDClassPrototype\" id=\"NDClassPrototype1\"><div class=\"CPEntry TClass Current\"><div class=\"CPModifiers\"><span class=\"SHKeyword\">public</span></div><div class=\"CPName\">Subcadena</div></div></div><div class=\"TTSummary\">Clase donde se guardan todos los opreadores, separadores y palabras reservadas previamente definidas.&nbsp; Tambien guarda los identificadores y numeros que se encuentren.&nbsp; Encargada de guardar las strings donde se van a guardar las tablas de simbolos y de tokens y el contador de identificadores.</div></div>",3:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype3\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public</span> SubCadena(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">File&nbsp;</td><td class=\"PName last\">doc</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Inicializa la clase y llama a los metodos que van a llenar las listas.&nbsp; Encargada de crear el bufferedReader que contiene el txt que se desea analizar y de cerrarlo cuando se termine el analisis.&nbsp; Parameters: doc - File que tiene el txt a analizar See also: leer</div></div>",4:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype4\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> SubCadena()</div></div><div class=\"TTSummary\">Inicializa la clase y llama a los metodos que van a llenar las listas.</div></div>",5:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype5\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> ArrayList&lt;String&gt; fillNaturales()</div></div><div class=\"TTSummary\">Llena la lista de los numeros naturales y el 0</div></div>",6:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype6\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> ArrayList&lt;String&gt; fillSeparadores()</div></div><div class=\"TTSummary\">Llena la lista de los separadores predefinidos</div></div>",7:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype7\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> ArrayList&lt;String&gt; fillTipo2()</div></div><div class=\"TTSummary\">Llena la lista de operadores.</div></div>",8:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype8\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> ArrayList&lt;String&gt; fillTipo3()</div></div><div class=\"TTSummary\">Llena la lista de separadores y operadores que funcionan como estos.</div></div>",9:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype9\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> ArrayList&lt;String&gt; fillOperadores()</div></div><div class=\"TTSummary\">Llena la lista de operadores.</div></div>",10:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype10\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">public</span> ArrayList&lt;String&gt; fillFind()</div></div><div class=\"TTSummary\">Llena la lista de las palabras reservadas</div></div>",11:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype11\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> leer(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">BufferedReader&nbsp;</td><td class=\"PName last\">doc</td></tr></table></td><td class=\"PAfterParameters\">) <span class=\"SHKeyword\">throws</span> IOException</td></tr></table></div></div><div class=\"TTSummary\">Funcion que resive un BufferedReader que divide el txt linea por linea, para ir analizandolas una por una, se crea el objeto subcadena, y desde aqui se llama el metodo cerebro del objeto subcadena.&nbsp; Tambien se llama al metodo clasificarExpresion.&nbsp; Parameters: doc - BufferedReader que contiene el txt.&nbsp; Returns: Void See also: cerebro clasificarExpresiones</div></div>",12:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype12\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> buscar(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">s,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">x,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">linea</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Clasifica una string entre palabara reservada y identificador, agregando el ultimo a una lista de identificadores si no se encuntra en esta.&nbsp; Va agregando informacion a la string que mostrara la informacion de la tabla de simbolos.&nbsp; Llama al metodo clasificarToken Parameters: s - String que se clasifica.&nbsp; x - Posicion de la string.&nbsp; linea - Linea donde esta la string que se analiza.&nbsp; Returns: Void See also: clasificarToken</div></div>",13:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype13\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> cerebro(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">s,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">linea</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Metodo principal que divide la string resivida palabra por palabra, y separador por separador, para despues llamar a los metodos que clasifican la string.&nbsp; Tambien es el metodo encargado de agregar los separadores al texto que mostrara la tabla de simbolos.&nbsp; Parameters: s - String que contiene el texto de una sola linea del txt que se analiza.&nbsp; linea - La linea que se esta analizando.&nbsp; Returns: Void See also: buscar clasificarToken definir</div></div>",14:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype14\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public</span> String verificarIzq(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">cadenaIzq</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Se encarga de verificar una cadena a la izquierda de cada expresi�n encontrada, esta se define cada vez que encuentre un operador.&nbsp; Parameters: cadenaIzq - String que contiene la cadena a la izquierda del operador.&nbsp; returns: Retorna la cadena analizada analizada invertida, pues el an�lisis se da de derecha a izquierda.</div></div>",15:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype15\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public</span> String verificarDer(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">cadenaDer</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Se encarga de verificar una cadena a la derecha de cada expresi�n encontrada, esta se define cada vez que encuentre un operador.&nbsp; Parameters: cadenaDer - String que contiene la cadena a la derecha del operador.&nbsp; returns: Retorna la cadena analizada analizada.</div></div>",16:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype16\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> clasificarExpresiones(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">str,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">posicion</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Se encarga de clasificar las expresiones encontradas. Lo que hace es partir una expresion aritm�tica en dos cadenas y un s�mbolo. Las cadenas son las que est�n a la derecha e izquierda del simbolo.&nbsp; El s�mbolo corresponde al operador que separa la expresi�n.&nbsp; Parameters: str - String que contiene la cadena a analizar posici�n - int que nos dice la posici�n donde encuentra la expresi�n aritmetica.&nbsp; returns: void.</div></div>",17:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype17\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">private void</span> clasificarToken(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">lexema</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Clasifica una string en los token predefinidos y leas asigna su respectivo tokenId.&nbsp; Va agregando informacion a la string que mostrara la informacion de la tabla de tokens.&nbsp; Parameters: lexema - String que contiene el token a clasificar returns: void</div></div>",18:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype18\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> definir(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">s</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Clasifica en la tabla de simbolos si la string es un comparador o separador.&nbsp; Parameters: s - String que se va a clasificar returns: void See also: clasificarToken</div></div>"});