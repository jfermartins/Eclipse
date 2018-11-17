package matematica;
/*1. Desenvolva em Java o cl�ssico �jogo de forca�. O jogo dever� atender os requisitos a seguir.
a. A entrada e sa�da de dados dever� ocorrer em ambiente texto;
b. O programa dever� receber um conjunto ilimitado de palavras por meio do par�metro
�args� do m�todo �main�. Exemplo de entrada:
java forca palmeiras santos corinthians portuguesa
c. O programa dever� escolher aleatoriamente uma das palavras informadas e ap�s a
escolha exibir o caractere �_� (underline) para cada letra da palavra escolhida. Por
exemplo, supondo que a palavra escolhida tenha sido �palmeiras� o programa dever�
exibir:
Palavra: _ _ _ _ _ _ _ _ _
d. Em seguida, o programa tamb�m dever� a quantidade de erros do jogador e o limite de
erros permitido. Por exemplo:
Erros: 0 / 7
e. Ap�s exibir essas informa��es, dever� exibir as seguintes op��es:
Pressione �s� para sair ou �j� para jogar. Op��o: _
f. Se o usu�rio escolher a op��o sair o programa se encerra imediatamente. Se o usu�rio
escolher jogar, o programa deve solicitar uma letra para o usu�rio. Se a letra fizer parte
da palavra escolhida, o programa dever� substituir o caractere underline na posi��o
correspondente pela letra digitada. Caso contr�rio, dever� atualizar a quantidade de erros
do usu�rio. Em seguida, as op��es definidas no Item �e� s�o apresentadas novamente.
g. O jogo termina quando o usu�rio atinge o limite de erros ou quando n�o houver mais
underlines a serem substitu�dos.
h. Podem ser definidas mensagens ao usu�rio para quando o usu�rio escolher sair, ganhar
ou perder o jogo.*/

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jane Fernanda Martins
 */
public class Forca {

	public static void main(String[] args) {
		boolean acertou = false;
		int qtd = 0;
		int contaErros = 0;
		String senha, tenta;
		char opcao;
		Scanner ler = new Scanner(System.in);
		Random r = new Random();
		int limite = args.length;

		String frases = (args[r.nextInt(limite)]);
		char formaPalavra[] = new char[frases.length()];
		String apresentaPalavra = " ";
		for (int y = 0; y < frases.length(); y++) {
			formaPalavra[y] = '_';
			apresentaPalavra += formaPalavra[y] + " ";
		}

		do {
			System.out.println("\nPalavra: " + apresentaPalavra);

			System.out.println("Erros: " + contaErros + " / 7");

			System.out.print("\nPressione \"s\" para sair ou \"j\" para jogar. Op��o: ");
			opcao = ler.next().charAt(0);
			switch (opcao) {

			case 's':
				System.out.println("Voc� escolheu SAIR!");
				System.exit(0);

			case 'j':
				acertou = false;
				System.out.println("\nPalavra: " + apresentaPalavra + "\n" + "Erros: " + contaErros + " / 7" + "\n"
						+ "\nDigite a letra:");
				senha = ler.next();
				apresentaPalavra = " ";

				for (int i = 0; i < frases.length(); i++) {
					tenta = frases.substring(i, i + 1);

					if (senha.trim().equalsIgnoreCase(tenta)) {
						acertou = true;
						qtd++;
						formaPalavra[i] = senha.charAt(0);
						apresentaPalavra = apresentaPalavra + formaPalavra[i] + " ";
						if (qtd == frases.length()) {

							System.out.println("\nVoc� Ganhou! \nPalavra Completa: \n" + frases + " ");
							System.exit(0);
						}
					} else {
						apresentaPalavra += formaPalavra[i] + " ";
					}
				}
				if (acertou == false) {
					contaErros++;
				}
				if (contaErros >= 7) {
					System.out.println("PERDEU! FIM DO JOGO");
					System.exit(0);
				}
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		} while (opcao == 'j');
		ler.close();
	}
}