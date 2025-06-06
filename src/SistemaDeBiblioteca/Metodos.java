package SistemaDeBiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    public static void Separador(){
        System.out.println("------------------------------");
    }

    public static int MostrarMenu(Scanner sc){
        Separador();
        System.out.println("Digite a opção desejada:");
        System.out.println("[1] Adicionar livros");
        System.out.println("[2] Listar livros");
        System.out.println("[3] Empréstimo de livros");
        System.out.println("[4] Devolver livros");
        System.out.println("[5] Excluir livros");
        System.out.println("[6] Encerrar programa");
        System.out.print("Opção: ");
        int opção = sc.nextInt();
        Separador();
        return opção;
    }

    public Biblioteca AdcionarLivros(int id){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autor = sc.nextLine();
        System.out.print("Digite o ano do lançamento: ");
        String ano = sc.nextLine();

        Biblioteca biblioteca = new Biblioteca(id,titulo,autor,ano,true);

        System.out.println("Livro adicionado com sucesso!");
        Separador();

        return biblioteca;
    }

    public void ListarLivros(ArrayList<Biblioteca> bibliotecas){
        if (bibliotecas.isEmpty()){
            System.out.println("Nenhum livro foi registrado!");
            return;
        }

        System.out.println();
        System.out.println("Lista de livros");

        for (int i = 0; i < bibliotecas.size(); i++) {
            System.out.println(bibliotecas.get(i).toString());
        }

        Separador();
    }

    public void EmprestarLivros(ArrayList<Biblioteca> bibliotecas){
        if (bibliotecas.isEmpty()){
            System.out.println("Nenhum livro foi registrado!");
            return;
        }
        System.out.print("Digite o id do livro que deseja emprestar: ");
        int idUser = sc.nextInt();

        for (int i = 0; i < bibliotecas.size(); i++) {
            if (idUser == bibliotecas.get(i).getId()){
                if (!bibliotecas.get(i).getDisponibilidade()){
                    System.out.println("Livro não disponível no momento!");
                    return;
                }
                System.out.println("Livro emprestado com sucesso: " + bibliotecas.get(i).getTitulo());
                bibliotecas.get(i).setDisponibilidade(false);
                return;
            }
        }

        System.out.println("Livro não encontrado!");
        System.out.println();

    }

    public void DevolverLivros(ArrayList<Biblioteca> bibliotecas){
        if (bibliotecas.isEmpty()){
            System.out.println("Nenhum livro foi registrado!");
            return;
        }
        System.out.print("Digite o id do livro que deseja devolver: ");
        int idUser = sc.nextInt();

        for (int i = 0; i < bibliotecas.size(); i++) {
            if (idUser == bibliotecas.get(i).getId()){
                if (bibliotecas.get(i).getDisponibilidade()){
                    System.out.println("Impossível devolver, por que já estava e está disponível para empréstimo");
                    return;
                }
                bibliotecas.get(i).setDisponibilidade(true);
                System.out.println("Livro devolvido com sucesso: " + bibliotecas.get(i).getTitulo());
                return;
            }
        }

        System.out.println("Livro não encontrado!");
        System.out.println();
    }

    public void DeletarLivros(ArrayList<Biblioteca> bibliotecas){
        if (bibliotecas.isEmpty()){
            System.out.println("Nenhum livro foi registrado!");
            return;
        }

        ListarLivros(bibliotecas);
        System.out.print("Digite o id do livro que deseja deletar: ");
        int idUser = sc.nextInt();

        for (int i = 0; i < bibliotecas.size(); i++) {
            if (idUser == bibliotecas.get(i).getId()){
                System.out.println("Livro deletado com sucesso: " + bibliotecas.get(i).getTitulo());
                bibliotecas.remove(i);
                return;
            }
        }

        System.out.println("Livro não encontado!");
        System.out.println();
    }
}
