package exercicosudemy;

public class FuncoesInteressantesString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Formatar: toLowerCase(), toUpperCase(), trim()
		 * Recortar: substring(inicio), substring(inicio,fim)
		 * Substituir: Replace(char, char), Replace(string,string)
		 * Buscar: IndexOf, LastIndexOf
		 * str.split(" ") 
		 */
		String original = "abcd FGJHG ABC abc DEFG     ";
		
		//converter minúsculas
		String s01 = original.toLowerCase();
		
		System.out.println("-" + s01 + "-");
		
		//converter maiúsculas
		String s02 = original.toUpperCase();
		
		
		System.out.println("-" + s02 + "-");

		//retirar espaços
		String s03 = original.trim();
		
		System.out.println("-" + s03 + "-");
		
		//Substring pega o caracter a partir do indice correspondente (no exemplo a partir indice 2)
		String s04 = original.substring(2);
		
		System.out.println("-" + s04 + "-");
		
		//Substring pegando inicio e fim com argumentos
		String s05 = original.substring(2,6);
		
		System.out.println("-" + s05 + "-");
		
		
		//Replace substitui um caracter ou uma frase por outra
		String s06 = original.replace('a', 'x');
		String s07 = original.replace("abc", "xy");
		
		System.out.println("-" + s06 + "-");
		System.out.println("-" + s07 + "-");
		
		
		
	}

}
