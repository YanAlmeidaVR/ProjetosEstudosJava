import java.util.List;
import java.util.Scanner;

// Uma classe que é composto por funcionalidades do menu da agenda e ações que executam através do menu.
public class MetodosMenus {

    // Separador é um metodo que imprime uma linha.
    public void Separador() {
        // Adiciona um saída que imprime uma linha.
        System.out.println("------------------------------");
    }

    // Exibir Menu imprimirá a estrutura do menu.
    public void ExibirMenu() {
        Separador();
        System.out.println("Agenda Telefônica:");
        System.out.println("[1] Adicionar Contato");
        System.out.println("[2] Lista de Contatos");
        System.out.println("[3] Procurar Contatos");
        System.out.println("[4] Excluir Contatos");
        System.out.println("[5] Sair");
        Separador();
        System.out.print("OPÇÃO: ");
    }

    // Uma funcionalidade que irá adicionar um contato na agenda.
    public void AdcionarContato(List<Contato> agenda, Scanner sc) {

        // Entradas do nome,número e e-mail.

        System.out.print("Digite o nome do contato: ");
        String nome = sc.nextLine();
        System.out.print("Digite o número do telefone: ");
        String numero = sc.nextLine();
        // Verificando se o tamanho do número é igual a 11.
        if (numero.length() < 11) return;
        System.out.print("Digite o e-mail do contato: ");
        String email = sc.nextLine();

        // Verificando se uma das entradas é nula.
        if (nome == null || numero == null || email == null) return;

        // Verificando se o email tem arroba.
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')) return;

        //Criando um contato e adicionando na agenda telefônica
        Contato novoContato = new Contato(nome, numero, email);
        agenda.add(novoContato);

        Separador();

        // Saída que confirma que o contato foi adicionado.
        System.out.println("Contato adicionado com sucesso!");
    }

    // Uma funcionalidade que irá mostrar os contatos da agenda.
    public void MostrarContatos(List<Contato> agenda) {

        //Verificando se a agenda está vazia
        if (agenda == null) return;

        //Irá mostrar os contatos que estão na agenda.
        for (int i = 0; i < agenda.size(); i++) {
            Separador();
            System.out.println("Contato : " + (i + 1));
            System.out.println(agenda.get(i).toString());
            Separador();
        }
    }

    // Uma funcionalidade que irá procurar por nomes que o usuário desejar.
    public void ProcurarContato(List<Contato> agenda, Scanner sc) {
        // Usuário digitará o nome que está procurando
        System.out.println("Digite o nome do contato: ");
        String nome = sc.nextLine();

        boolean Encontrou = false;

        // Procurará o nome que o usuário escreveu.
        for (int i = 0; i < agenda.size(); i++) {
            // Vai verificar o nome ignorando qualquer letra maisculo e minuscula.
            if (nome.equalsIgnoreCase(agenda.get(i).getNome())) {
                Separador();
                System.out.println("Contato encontrado com sucesso!");
                System.out.println(agenda.get(i).toString());
                Separador();
                Encontrou = true;
                break;
            }
        }

        //  Senão tiver o nome na agenda, vai gerar uma saída comunicando não encontrou o contato.
        if (!Encontrou) {
            Separador();
            System.out.println("Contato não encontrado!");
            Separador();
        }

    }

    // Uma funcionalidade que irá remover o contato que o usuário desejar.
    public void RemoverContato(List<Contato> agenda, Scanner sc) {
        //Entrada em que o usuário escreverá o nome que deseja excluir na agenda.
        System.out.println("Digite o nome do contato que deseja excluir: ");
        String nome = sc.nextLine();

    boolean Encontrou = false;

        // Procurará o nome que o usuário escreveu.
        for (int i = 0; i < agenda.size() ; i++) {
            // Vai verificar o nome ignorando qualquer letra maisculo e minuscula.
            if (nome.equalsIgnoreCase(agenda.get(i).getNome())) {
                agenda.remove(i);
                Separador();
                System.out.println("Contato removido com sucesso!");
                Separador();
                Encontrou = true;
                break;
            }
        }

        //  Senão tiver o nome na agenda, vai gerar uma saída comunicando que não encontrou o contato.
        if(!Encontrou){
            Separador();
            System.out.println("Contato não encontrado!");
            Separador();
        }
    }
}
