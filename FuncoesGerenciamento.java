import java.util.*;

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
            String livro = "";

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
                System.out.printf("Livro '%s' do autor(a) %s adicionado com sucesso %n", livro, autor);
                hashMap.get(autor).add(livro);
            }

        }


    }

    public static void AdicionarLivro(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {

        for (String autores : hashMap.keySet()) {
            System.out.println(autores);
        }

        String verificarAutor = "";
        String livro = " ";
        boolean controleDeLoop = true;
        while (controleDeLoop) {
            System.out.println("Digite o nome do autor para adicionar o livro. Deixe em branco " +
                    "para cancelar: ");

            verificarAutor = scanner.nextLine().toLowerCase().strip();

            if (verificarAutor.isEmpty() || hashMap.containsKey(verificarAutor)) {
                controleDeLoop = false;

            } else {
                System.out.println("Autor nao encontrado");
            }
        }

        if (hashMap.containsKey(verificarAutor)) {
            System.out.println("Autor esta na biblioteca");

            do {
                System.out.print("Digite o titulo do livro: ");
                livro = scanner.nextLine().toLowerCase().strip();

                if (livro.isEmpty()) {
                    System.out.println("Campo livro nao pode ser vazio");
                }

            } while (livro.isEmpty());

            if (hashMap.get(verificarAutor).contains(livro)) {
                System.out.println("Livro ja esta na biblioteca");

            } else {
                hashMap.get(verificarAutor).add(livro);
                System.out.printf("Livro %s adicionado com sucesso ao autor(a) %s %n", livro,
                        verificarAutor);
            }

        }

    }

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

    public static void ListarLivros(HashMap<String, ArrayList<String>> hashMap, Scanner scanner) {
        hashMap.forEach((chave, valor) -> {
            System.out.println("Autor: " + chave + " | Livros: " + valor);
        });
    }


}



