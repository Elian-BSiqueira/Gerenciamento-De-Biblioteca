import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Classe utilitária que contém funções de validação para o sistema de biblioteca.
 */

public class FuncoesGerenciamento {

    /**
     * Solicita ao usuário que digite um número inteiro.
     * Continua pedindo até que uma entrada válida seja fornecida.
     *
     * @param texto Mensagem a ser exibida ao usuário.
     * @return O número inteiro fornecido pelo usuário.
     */
    public static int VerificarNumeroInt(String texto) {


        Scanner scan = new Scanner(System.in);
        boolean controleDeLoop = true;
        int numero = 0;

        while (controleDeLoop) {
            System.out.print(texto);
            try {
                numero = scan.nextInt();
                controleDeLoop = false;

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }

        }
        return numero;
    }


    /**
     * Solicita um número inteiro dentro de um intervalo específico.
     *
     * @param texto Mensagem de entrada a ser exibida.
     * @param minimo Valor mínimo permitido (inclusive).
     * @param maximo Valor máximo permitido (inclusive).
     * @return Um número inteiro dentro do intervalo definido.
     */
    public static int VerificarInteiroComIntervalo(String texto, int minimo, int maximo) {
        Scanner scan = new Scanner(System.in);
        boolean controleDeLoop = true;
        int numero = 0;
        do {
            System.out.print(texto);
            try {
                numero = scan.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    controleDeLoop = false;
                }
                else {
                    System.out.println("Opcao Invalida. Digite um numero entre 1 e 5");
                }

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }
        } while (controleDeLoop);

        return numero;
    }

}
