﻿NDSummary.OnToolTipsLoaded("JavaClass:ExpresionesSubCadena_",{20:"<div class=\"NDToolTip TClass LJava\"><div class=\"TTSummary\">*Clase encargada de aplicar la gram�tica de expresiones a las mismas encontradas en la clase *SubCadena.&nbsp; *</div></div>",22:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">Funcion encargada de seguir la gram�tica, derivando a factor y termino prima.&nbsp; Como se logra observar, la recursividad a la izquierda tambi�n es eliminada.</div></div>",23:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">Funci�n que verifica siempre si el token de entrada es un simbolo terminal para hacer match con este y luego deriva las correspondientes funciones que van acorde a la gram�tica.</div></div>",24:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype24\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">private void</span> factor()</div></div><div class=\"TTSummary\">Funcion similar a termino prima en donde se evaluan los factores, que empiezan con un par�ntesis y luego derivan la gram�tica correspondiente (expresi�n).&nbsp; Al finalizar, vuelve a llamar la funci�n hacer Match para verificar si termina con un parentesis.&nbsp; En caso de no empezar con par�ntesis, se deriva a n�mero.</div></div>",25:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype25\" class=\"NDPrototype\"><div class=\"PSection PPlainSection\"><span class=\"SHKeyword\">private void</span> expresion_Prima()</div></div><div class=\"TTSummary\">funcion que verifica que el simbolo de entrada presente cuando sea llamada sea terminal, para inmediatamente hacer match y continuar con la derivaci�n de la gram�tica.</div></div>",26:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">Funci�n encargada de verificar los numeros encontrados en la cadena principal para verificar su derivaci�n.</div></div>",27:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">Funci�n utilizada para eliminar la recursividad por la izquierda de la funci�n n�mero. Verifica si el actual token de entrada es un digito para seguir con la derivaci�n acorde a n�mero.</div></div>",28:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">Funci�n encargada de verificar la derivaci�n de digito. Cuando no es d�gito, marca error en la posici�n actual del token de entrada.</div></div>",29:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">M�todo encargado de verificar que los token de entrada sean d�gitos. Recibe el token que se quiere analizar y lo convierte a un entero para as� buscar su equivalente valor en un array de digitos. Se tiene una bandera que cambia su estado a True al encontrar el digito en el array.&nbsp; Parameters: token_Entrada - Character analisado Returns: boolean</div></div>",30:"<div class=\"NDToolTip TFunction LJava\"><div id=\"NDPrototype30\" class=\"NDPrototype WideForm\"><div class=\"PSection PParameterSection CStyle\"><table><tr><td class=\"PBeforeParameters\"><span class=\"SHKeyword\">public void</span> hacerMatch(</td><td class=\"PParametersParentCell\"><table class=\"PParameters\"><tr><td class=\"PType first\"><span class=\"SHKeyword\">char</span>&nbsp;</td><td class=\"PName last\">t</td></tr></table></td><td class=\"PAfterParameters\">)</td></tr></table></div></div><div class=\"TTSummary\">Funci�n encargada de dar paso al siguiente token si las reglas de derivaci�n van acorde a lo que se tiene planteado en la gram�tica. No retorna ning�n valor.&nbsp; Parameters: t - Character</div></div>",31:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">Funci�n encargada de mover el puntero en las posiciones de la cadena.&nbsp; Returns: Character</div></div>",32:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">M�todo encargado de dar inicio al analizador entregando el primer token de la cadena a analizar y sumando por primera vez la posici�n del puntero.&nbsp; Returns: Character</div></div>",33:"<div class=\"NDToolTip TFunction LJava\"><div class=\"TTSummary\">M�todo encargado de poner en funcionamiento al analizador.&nbsp; Deja en orden todo lo necesario para empezar el an�lisis con el m�todo expresi�n.</div></div>"});