import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
                    System.out.printf("Opcao Invalida. Digite um numero entre %d e %d %n", minimo, maximo);
                }

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }
        } while (controleDeLoop);

        return numero;
    }

    public static void AdicionarLivro(List<String> lista, Scanner scanner) {
        String livro = "";

        do {
            System.out.print("Digite o livro para adicionar: ");
            livro = scanner.nextLine().toLowerCase().strip();
            if (livro.isEmpty()) {
                System.out.println("Campo livro nao pode ser vazio");
            }

        } while (livro.isEmpty());

        if (lista.contains(livro)) {
            System.out.println("Livro ja esta na biblioteca");

        } else {
            lista.add(livro);
            System.out.printf("Livro ' %s ' adicionado com sucesso %n", livro);

        }

    }
    public static void main(String[] args) {


        System.out.print("Digite o livro para adicionar: ");



    }

}
