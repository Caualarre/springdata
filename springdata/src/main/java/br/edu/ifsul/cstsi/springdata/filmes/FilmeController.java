package br.edu.ifsul.cstsi.springdata.filmes;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class FilmeController {

    private static final Scanner input = new Scanner(System.in);
    private static FilmeService filmeService;

    //Injeção de dependência
   public FilmeController(FilmeService filmeService) {
      FilmeController.filmeService = filmeService;
   }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU cliente -------\"");
            System.out.print(
                """

                    1. Inserir novo Filme
                    2. Atualizar um Filme
                    3. Excluir um Filme (retirar de exebicao)
                    4. Ativar ou Desativar um cliente
                    5. Listar todos os clientes
                    6. Buscar cliente pelo código
                    7. Buscar clientes pelo nome
                    8. Buscar clientes pela situação
                    Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
               // case 4 -> ativar();
                //case 5 -> selectclientes();
                case 6 -> selectfilmeById();
               // case 7 -> selectclientesByNome();
               // case 8 -> selectClientesBySituacao();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
        //opção 1

    }
       //opção 1
       private static void inserir() {
           Filme filme = new Filme();
           System.out.println("\n++++++ Cadastro de novo Filme++++++");
           System.out.print("Digite o nome do filme: ");
           filme.setTitulo(input.nextLine());
           System.out.print("\nDigite o Duracao do filme: ");
           filme.setDuracao(input.nextLine());
           System.out.println("Filme salvo com sucesso:" + filmeService.insert(filme));
       }

    //opção 2
   private static void atualizar() {
       System.out.println("\n++++++ Alterar um filme++++++");
       Filme filme;
       int opcao = 0;
       do {
           System.out.print("\nDigite o código do filme Zero p/sair): ");
           long codigo = input.nextLong();
           input.nextLine();
           if (codigo == 0) {
                opcao = 0;
           } else {
               filme = filmeService.getFilmeById(codigo);
               if (filme == null) {
                  System.out.println("Código inválido.");
              } else {
                    System.out.println("Titulo: " + filme.getTitulo());
                   System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                       System.out.println("Digite o novo nome do filme: ");
                        filme.setTitulo(input.nextLine());
                   }
                    System.out.println("Duracao: " + filme.getDuracao());
                  System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                       input.nextLine();
                        System.out.print("Digite o novo duracao do filme: ");
                      filme.setDuracao(input.nextLine());
                  }if(filmeService.update(filme) != null) {
                       System.out.println("cliente atualizado com sucesso. " + filmeService.getFilmeById(filme.getId()));
                   } else {
                       System.out.println("Não foi possível atualizar este cliente. Por favor, contate o administrador.");
                   }


                   opcao = 1;
               }
           }
       } while (opcao != 0);
    }
    private static void excluir() {
        System.out.println("\n++++++ Excluir um Filme++++++");
        Filme filme;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do filme (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                filme = filmeService.getFilmeById(codigo);
                if (filme == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(filme);
                    System.out.print("Excluir este filme? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        filmeService.delete(filme.getId());
                        System.out.println("filme retirado de exibicao com sucesso:" + filme);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }
    private static void selectfilmeById() {
        System.out.print("\nDigite o código do Filme: ");
        Filme filme= filmeService.getFilmeById(input.nextLong());
        input.nextLine();
        if (filme != null) {
            System.out.println(filme);
        } else {
            System.out.println("Código não localizado.");
        }
    }

}//fim classe


