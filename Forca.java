package matematica;
/*1. Desenvolva em Java o clássico “jogo de forca”. O jogo deverá atender os requisitos a seguir.
a. A entrada e saída de dados deverá ocorrer em ambiente texto;
b. O programa deverá receber um conjunto ilimitado de palavras por meio do parâmetro
“args” do método “main”. Exemplo de entrada:
java forca palmeiras santos corinthians portuguesa
c. O programa deverá escolher aleatoriamente uma das palavras informadas e após a
escolha exibir o caractere “_” (underline) para cada letra da palavra escolhida. Por
exemplo, supondo que a palavra escolhida tenha sido “palmeiras” o programa deverá
exibir:
Palavra: _ _ _ _ _ _ _ _ _
d. Em seguida, o programa também deverá a quantidade de erros do jogador e o limite de
erros permitido. Por exemplo:
Erros: 0 / 7
e. Após exibir essas informações, deverá exibir as seguintes opções:
Pressione “s” para sair ou “j” para jogar. Opção: _
f. Se o usuário escolher a opção sair o programa se encerra imediatamente. Se o usuário
escolher jogar, o programa deve solicitar uma letra para o usuário. Se a letra fizer parte
da palavra escolhida, o programa deverá substituir o caractere underline na posição
correspondente pela letra digitada. Caso contrário, deverá atualizar a quantidade de erros
do usuário. Em seguida, as opções definidas no Item “e” são apresentadas novamente.
g. O jogo termina quando o usuário atinge o limite de erros ou quando não houver mais
underlines a serem substituídos.
h. Podem ser definidas mensagens ao usuário para quando o usuário escolher sair, ganhar
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

			System.out.print("\nPressione \"s\" para sair ou \"j\" para jogar. Opção: ");
			opcao = ler.next().charAt(0);
			switch (opcao) {

			case 's':
				System.out.println("Você escolheu SAIR!");
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

							System.out.println("\nVocê Ganhou! \nPalavra Completa: \n" + frases + " ");
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
				System.out.println("Opção inválida");
				break;
			}
		} while (opcao == 'j');
		ler.close();
	}
}