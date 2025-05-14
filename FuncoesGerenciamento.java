import java.util.*;

/*
 * Classe utilitária que contém funções de validação para o sistema de biblioteca.
 */

public class FuncoesGerenciamento {

    /**
     * Solicita um número inteiro dentro de um intervalo específico.
     *
     * @param texto  Mensagem de entrada a ser exibida.
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
                } else {
                    System.out.printf("Opcao Invalida. Digite um numero entre %d e %d %n", minimo, maximo);
                }

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }
        } while (controleDeLoop);

        return numero;
    }

    /**
     * Adiciona um livro a um autor já existente na biblioteca.
     *
     * @param autor    O nome do autor ao qual o livro será associado.
     * @param scanner  Scanner utilizado para entrada do nome do livro.
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     */
    private static void AdicionarLivro(String autor, Scanner scanner, HashMap<String, ArrayList<String>> hashMap) {
        String livro;
        do {
            System.out.print("Digite o titulo do livro: ");
            livro = scanner.nextLine().toLowerCase().strip();

            if (livro.isEmpty()) {
                System.out.println("Campo livro nao pode ser vazio");
            }

        } while (livro.isEmpty());

        if (hashMap.get(autor).contains(livro)) {
            System.out.println("Livro ja esta na biblioteca");

        } else {
            hashMap.get(autor).add(livro);
            System.out.printf("Livro %s adicionado com sucesso ao autor(a) %s. Total de livros: %d %n", livro,
                    autor, hashMap.get(autor).size());
        }
    }

    /**
     * Adiciona um novo autor e o primeiro livro relacionado a ele.
     * Caso o autor já exista na biblioteca, informa o usuário.
     *
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     * @param scanner  Scanner utilizado para entrada dos dados do autor e livro.
     */
    public static void AdicionarAutorELivro(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {
        String autor = "";
        do {
            System.out.print("Digite o autor do livro: ");
            autor = scanner.nextLine().toLowerCase().strip();
            if (autor.isEmpty()) {
                System.out.println("Campo autor nao pode ser vazio");
            }

        } while (autor.isEmpty());

        if (hashMap.containsKey(autor)) {
            System.out.println("Autor ja esta na biblioteca");
        } else {
            hashMap.put(autor, new ArrayList<>());
            AdicionarLivro(autor, scanner, hashMap);


        }


    }

    /**
     * Adiciona um novo livro a um autor já existente.
     * Exibe os autores cadastrados e permite ao usuário escolher um.
     * Caso o autor não exista ou a entrada seja inválida, informa o usuário.
     *
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     * @param scanner  Scanner utilizado para entrada do nome do autor e do livro.
     */
    public static void AdicionarLivroAoAutor(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {

        for (String autores : hashMap.keySet()) {
            System.out.println(autores);
        }

        String autor = "";
        String livro = " ";
        boolean controleDeLoop = true;
        while (controleDeLoop) {
            System.out.println("Digite o nome do autor para adicionar o livro. Deixe em branco " +
                    "para cancelar: ");

            autor = scanner.nextLine().toLowerCase().strip();

            if (autor.isEmpty() || hashMap.containsKey(autor)) {
                controleDeLoop = false;

            } else {
                System.out.println("Autor nao encontrado");
            }
        }

        if (hashMap.containsKey(autor)) {
            System.out.println("Autor esta na biblioteca");
            AdicionarLivro(autor, scanner, hashMap);

        }

    }

    /**
     * Remove um livro de um autor específico da biblioteca.
     * Caso o autor não tenha mais livros após a remoção, o autor também é removido.
     *
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     * @param scanner  Scanner utilizado para entrada do nome do autor e do livro.
     */
    public static void RemoverLivro(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {

        hashMap.forEach((chave, valor) -> {
            System.out.println("Autor: " + chave + " | Livros: " + valor);
        });

        String verificarAutor = "";
        String livro = " ";

        boolean controleDeLoop = true;
        while (controleDeLoop) {
            System.out.println("Digite o nome do autor para remover o livro. Deixe em branco " +
                    "para cancelar: ");
            verificarAutor = scanner.nextLine().toLowerCase().strip();

            if (verificarAutor.isEmpty() || hashMap.containsKey(verificarAutor)) {
                controleDeLoop = false;

            } else {
                System.out.println("Autor nao encontrado");
            }

        }

        if (verificarAutor.equals("")) {
            return;

        } else {

            do {
                System.out.print("Digite o titulo do livro: ");
                livro = scanner.nextLine().toLowerCase().strip();

                if (livro.isEmpty()) {
                    System.out.println("Campo livro nao pode ser vazio");
                }

            } while (livro.isEmpty());


            boolean removeuLivro = hashMap.get(verificarAutor).remove(livro);

            if (removeuLivro) {
                System.out.printf("Livro '%s' do autor '%s' removido %n", livro, verificarAutor);
            } else {
                System.out.println("Livro nao encontrado");

            }
            if (hashMap.get(verificarAutor).isEmpty()) {
                hashMap.remove(verificarAutor);
            }

        }
    }

    /**
     * Pesquisa se um determinado título de livro está presente na biblioteca
     * e exibe o autor correspondente, se encontrado.
     *
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     * @param scanner  Scanner utilizado para entrada do título do livro.
     */
    public static void PesquisarLivroPorTitulo(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {
        String livroPesquisado = "";
        boolean controleDeLoop = true;

        while (controleDeLoop) {
            System.out.println("Digite o nome do titulo do livro para pesquisar. Deixe em branco " +
                    "para cancelar: ");
            livroPesquisado = scanner.nextLine().toLowerCase().strip();
            if (livroPesquisado.isEmpty()) {
                controleDeLoop = false;

            } else {
                for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
                    String autores = entry.getKey();
                    ArrayList<String> livrosEscritos = entry.getValue();

                    if (livrosEscritos.contains(livroPesquisado)) {
                        System.out.printf("Livro '%s' escito por %s esta na biblioteca %n", livroPesquisado,
                                autores);
                        return;
                    } else {
                        System.out.printf("Livro '%s' não encontrado na biblioteca.%n", livroPesquisado);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Exibe todos os livros de um autor específico, se ele estiver cadastrado.
     *
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     * @param scanner  Scanner utilizado para entrada do nome do autor.
     */
    public static void PesquisarLivroPorAutor (HashMap < String, ArrayList < String >> hashMap, Scanner scanner){
            String autorPesquisado = "";
            boolean controleDeLoop = true;

            while (controleDeLoop) {
                System.out.println("Digite o nome do autor para pesquisar. Deixe em branco " +
                        "para cancelar: ");
                autorPesquisado = scanner.nextLine().toLowerCase().strip();

                if (autorPesquisado.isEmpty() || hashMap.containsKey(autorPesquisado)) {
                    controleDeLoop = false;

                } else {
                    System.out.println("Autor nao encontrado");
                }
            }

            if (hashMap.containsKey(autorPesquisado)) {
                System.out.printf("Livros do Autor(a) %s: ", autorPesquisado);
                for (String livro : hashMap.get(autorPesquisado)) {
                    System.out.println("- " + livro);
                }
            }

        }

    /**
     * Lista todos os autores cadastrados na biblioteca e seus respectivos livros.
     *
     * @param hashMap  Estrutura que armazena autores e seus respectivos livros.
     * @param scanner  Scanner (não é utilizado neste método, mas está presente na assinatura).
     */
    public static void ListarLivros(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {
        hashMap.forEach((chave, valor) -> {
            System.out.println("Autor: " + chave + " | Livros: " + valor);
        });
    }


}



