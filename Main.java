import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento de biblioteca.
 * Permite adicionar, remover, listar e pesquisar livros através de uma interface de console.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String menu = """
                1) Adicionar autor e livro
                2) Adicionar livro
                3) Remover livro
                4) Pesquisar livro por titulo
                5) Pesquisar livros por autor
                6) Listar livros
                7) Sair
                """;

        System.out.println("Biblioteca");
        System.out.println("=".repeat(30));

        HashMap<String, ArrayList<String>> biblioteca = new HashMap<>();

        int opcao = -1;
        while (opcao != 7) {
            System.out.println(menu);

            opcao = FuncoesGerenciamento.VerificarInteiroComIntervalo("Digite sua opcao: ", 1, 7);

            switch (opcao) {
                case 1:
                    String autor = "";
                    do {
                        System.out.print("Digite o autor do livro: ");
                        autor = scan.nextLine().toLowerCase().strip();
                        if (autor.isEmpty()) {
                            System.out.println("Campo autor nao pode ser vazio");
                        }

                    } while (autor.isEmpty());

                    if (biblioteca.containsKey(autor)) {
                        System.out.println("Autor ja esta na biblioteca");
                        // Chama Adicionar livro
                    } else {
                        biblioteca.put(autor, new ArrayList<>());
                        String livro = "";

                        do {
                            System.out.print("Digite o titulo do livro: ");
                            livro = scan.nextLine().toLowerCase().strip();

                            if (livro.isEmpty()) {
                                System.out.println("Campo livro nao pode ser vazio");
                            }

                        } while (livro.isEmpty());

                        if (biblioteca.get(autor).contains(livro)) {
                            System.out.println("Livro ja esta na biblioteca");
                        } else {
                            System.out.printf("Livro '%s' do autor(a) %s adicionado com sucesso %n", livro, autor);
                            biblioteca.get(autor).add(livro);
                        }

                    }
                    break;
                case 2:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há autores na biblioteca");
                        break;

                    } else {
                        for (String autores : biblioteca.keySet()) {
                            System.out.println(autores);
                        }

                        String verificarAutor = "";
                        String livro = " ";
                        boolean controleDeLoop = true;
                        while (controleDeLoop) {
                            System.out.println("Digite o nome do autor para adicionar o livro. Deixe em branco " +
                                    "para cancelar: ");
                            verificarAutor = scan.nextLine().toLowerCase().strip();

                            if (verificarAutor.isEmpty() || biblioteca.containsKey(verificarAutor)) {
                                controleDeLoop = false;
                            } else {
                                System.out.println("Autor nao encontrado");
                            }
                        }

                        if (biblioteca.containsKey(verificarAutor)) {
                            System.out.println("Autor esta na biblioteca");

                            do {
                                System.out.print("Digite o titulo do livro: ");
                                livro = scan.nextLine().toLowerCase().strip();

                                if (livro.isEmpty()) {
                                    System.out.println("Campo livro nao pode ser vazio");
                                }

                            } while (livro.isEmpty());

                            if (biblioteca.get(verificarAutor).contains(livro)) {
                                System.out.println("Livro ja esta na biblioteca");
                                break;
                            } else {
                                biblioteca.get(verificarAutor).add(livro);
                                System.out.printf("Livro %s adicionado com sucesso ao autor(a) %s %n", livro,
                                        verificarAutor);
                            }

                        }

                    }
                    break;
                case 3:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Biblioteca esta vazia");
                        break;
                    } else {
                        biblioteca.forEach((chave, valor) -> {
                            System.out.println("Autor: " + chave + " | Livros: " + valor);
                        });

                        String verificarAutor = "";
                        String livro = " ";

                        boolean controleDeLoop = true;
                        while (controleDeLoop) {
                            System.out.println("Digite o nome do autor para remover o livro. Deixe em branco " +
                                    "para cancelar: ");
                            verificarAutor = scan.nextLine().toLowerCase().strip();

                            if (verificarAutor.isEmpty() || biblioteca.containsKey(verificarAutor)) {
                                controleDeLoop = false;
                            } else {
                                System.out.println("Autor nao encontrado");
                            }

                        }
                        if (verificarAutor.equals("")) {
                            break;

                        } else {

                            do {
                                System.out.print("Digite o titulo do livro: ");
                                livro = scan.nextLine().toLowerCase().strip();

                                if (livro.isEmpty()) {
                                    System.out.println("Campo livro nao pode ser vazio");
                                }

                            } while (livro.isEmpty());


                            boolean removeuLivro = biblioteca.get(verificarAutor).remove(livro);

                            if (removeuLivro) {
                                System.out.printf("Livro '%s' do autor '%s' removido %n", livro, verificarAutor);
                            } else {
                                System.out.println("Livro nao encontrado");

                            }
                            if (biblioteca.get(verificarAutor).isEmpty()) {
                                biblioteca.remove(verificarAutor);
                            }

                        }
                    }
                    break;

                case 4:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há livros na biblioteca");
                    } else {
                        String livroPesquisado = "";
                        do {
                            System.out.print("Digite o titulo do livro: ");
                            livroPesquisado = scan.nextLine().toLowerCase().strip();

                            if (livroPesquisado.isEmpty()) {
                                System.out.println("Campo livro nao pode ser vazio");
                            }

                        } while (livroPesquisado.isEmpty());

                        for (Map.Entry<String, ArrayList<String>> entry : biblioteca.entrySet()) {
                            String autores = entry.getKey();
                            ArrayList<String> livrosEscritos = entry.getValue();

                            if (livrosEscritos.contains(livroPesquisado)) {
                                System.out.printf("Livro '%s' escito por %s esta na biblioteca %n", livroPesquisado,
                                        autores);
                            } else {
                                System.out.printf("Livro '%s' não encontrado na biblioteca.%n", livroPesquisado);
                            }


                        }

                    }
                    break;

                case 5:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há livros na biblioteca");
                    } else {
                        String autorPesquisado = "";
                        do {
                            System.out.print("Digite o autor para pesquisar: ");
                            autorPesquisado = scan.nextLine().toLowerCase().strip();

                            if (autorPesquisado.isEmpty()) {
                                System.out.println("Campo autor nao pode ser vazio");
                            }

                        } while (autorPesquisado.isEmpty());

                        for (String livro : biblioteca.get(autorPesquisado)) {
                            System.out.println("- " + livro);
                        }
                    }
                    break;

                case 6:
                    if (biblioteca.isEmpty()) {
                        System.out.println("Não há livros na biblioteca");
                    } else {
                        biblioteca.forEach((chave, valor) -> {
                            System.out.println("Autor: " + chave + " | Livros: " + valor);
                        });
                    }

                    break;

                case 7:
                    System.out.println("Saindo do programa...");
                    scan.close();
                    break;
                default:
                    System.out.println("Opcao invalida");

            }
        }


    }
}
