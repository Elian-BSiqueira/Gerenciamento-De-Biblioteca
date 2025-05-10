import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncoesGerenciamento {
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
