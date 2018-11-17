package matematica;

import java.util.Scanner;
/**
 * @author Jane Fernanda Martins
 *
 */
public class Arranjos {
	static int fatorial(int numero) {
		int resultado = 1;
		while (numero > 0) {
			resultado = resultado * numero;
			numero--;
		}
		return resultado;
	}

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int n = ler.nextInt();
		int p = ler.nextInt();
		int fatorialN = fatorial(n);
		int fatorialP = fatorial(p);
		int fatorialNP = fatorial(n - p);

		double resultado = (double) fatorialN / (fatorialP * fatorialNP)* fatorial(p);

		System.out.println(resultado);

		ler.close();
	}
}
