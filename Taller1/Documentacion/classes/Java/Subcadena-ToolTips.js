﻿NDContentPage.OnToolTipsLoaded({11:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype11\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> leer(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">BufferedReader&nbsp;</td><td class=\"PName last\">doc</td></tr></table></td><td class=\"PAfterParameters\">) <span class=\"SHKeyword\">throws</span> IOException</td></tr></table></div></div><div class=\"TTSummary\">Funcion que resive un BufferedReader que divide el txt linea por linea, para ir analizandolas una por una, se crea el objeto subcadena, y desde aqui se llama el metodo cerebro del objeto subcadena.&nbsp; Tambien se llama al metodo clasificarExpresion.&nbsp; Parameters: doc - BufferedReader que contiene el txt.&nbsp; Returns: Void See also: cerebro clasificarExpresiones</div></div>",12:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype12\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> buscar(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">s,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">x,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">linea</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Clasifica una string entre palabara reservada y identificador, agregando el ultimo a una lista de identificadores si no se encuntra en esta.&nbsp; Va agregando informacion a la string que mostrara la informacion de la tabla de simbolos.&nbsp; Llama al metodo clasificarToken Parameters: s - String que se clasifica.&nbsp; x - Posicion de la string.&nbsp; linea - Linea donde esta la string que se analiza.&nbsp; Returns: Void See also: clasificarToken</div></div>",13:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype13\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> cerebro(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">s,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">linea</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Metodo principal que divide la string resivida palabra por palabra, y separador por separador, para despues llamar a los metodos que clasifican la string.&nbsp; Tambien es el metodo encargado de agregar los separadores al texto que mostrara la tabla de simbolos.&nbsp; Parameters: s - String que contiene el texto de una sola linea del txt que se analiza.&nbsp; linea - La linea que se esta analizando.&nbsp; Returns: Void See also: buscar clasificarToken definir</div></div>",16:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype16\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> clasificarExpresiones(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">str,</td></tr><tr><td class=\"PType first\"><span class=\"SHKeyword\">int</span>&nbsp;</td><td class=\"PName last\">posicion</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Se encarga de clasificar las expresiones encontradas. Lo que hace es partir una expresion aritm�tica en dos cadenas y un s�mbolo. Las cadenas son las que est�n a la derecha e izquierda del simbolo.&nbsp; El s�mbolo corresponde al operador que separa la expresi�n.&nbsp; Parameters: str - String que contiene la cadena a analizar posici�n - int que nos dice la posici�n donde encuentra la expresi�n aritmetica.&nbsp; returns: void.</div></div>",17:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype17\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">private void</span> clasificarToken(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">lexema</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Clasifica una string en los token predefinidos y leas asigna su respectivo tokenId.&nbsp; Va agregando informacion a la string que mostrara la informacion de la tabla de tokens.&nbsp; Parameters: lexema - String que contiene el token a clasificar returns: void</div></div>",18:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype18\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> definir(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\">String&nbsp;</td><td class=\"PName last\">s</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Clasifica en la tabla de simbolos si la string es un comparador o separador.&nbsp; Parameters: s - String que se va a clasificar returns: void See also: clasificarToken</div></div>"});