import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String menu = """
                1) Adicionar livro
                2) Remover livro por titulo
                3) Pesquisar livro por titulo
                4) Listar livros
                5) Sair
                """;

        System.out.println("Biblioteca");
        System.out.println("=".repeat(30));

        ArrayList<String> biblioteca = new ArrayList<>();

        int opcao = -1;
        while (opcao != 5) {
            System.out.println(menu);

            opcao = FuncoesGerenciamento.VerificarInteiroComIntervalo("Digite sua opcao: ", 1, 5);

            switch (opcao) {
                case 1:
                    String livro = "";
                    do {
                        System.out.print("Digite o livro para adicionar: ");
                        livro = scan.nextLine().toLowerCase().strip();
                        if (livro.isEmpty()) {
                            System.out.println("Campo livro nao pode ser vazio");
                        }

                    } while (livro.isEmpty());

                    if (biblioteca.contains(livro)) {
                        System.out.println("Livro ja esta na biblioteca");

                    } else {
                        biblioteca.add(livro);
                        System.out.printf("Livro ' %s ' adicionado com sucesso %n", livro);

                    }

                    break;

                case 2:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há livros no biblioteca");
                        break;

                    } else {

                        for (String livros : biblioteca) {
                            System.out.println(livros);


                        }
                        String removerLivro = "";
                        do {
                            System.out.print("Digite o livro que quer remover: ");
                            removerLivro = scan.nextLine().toLowerCase().strip();
                            if (removerLivro.isEmpty()) {
                                System.out.println("Campo livro nao pode ser vazio");
                            }

                        } while (removerLivro.isEmpty());

                        boolean removeu = biblioteca.remove(removerLivro);

                        if (removeu) {
                            System.out.printf("Livro %s removido %n", removerLivro);
                        } else {
                            System.out.printf("Livro %s não encontrado na biblioteca %n", removerLivro);
                        }


                    }

                    break;

                case 3:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há livros no biblioteca");
                        break;

                    } else {
                        String pesquisarLivro = "";
                        do {
                            System.out.print("Digite o livro que quer pesquisar: ");
                            pesquisarLivro = scan.nextLine().toLowerCase().strip();
                            if (pesquisarLivro.isEmpty()) {
                                System.out.println("Campo livro nao pode ser vazio");
                            }
                        } while (pesquisarLivro.isEmpty());

                        if (biblioteca.contains(pesquisarLivro)) {
                            System.out.printf("O livro ' %s ' esta na biblioteca %n", pesquisarLivro);
                        } else {
                            System.out.printf("livro ' %s ' nao esta na biblioteca %n", pesquisarLivro);
                        }
                    }

                    break;

                case 4:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há livros na biblioteca");
                    } else {
                        for (String livros : biblioteca) {
                            System.out.println(livros);
                        }
                    }

                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida");

            }
        }


    }
}
