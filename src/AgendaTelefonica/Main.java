package AgendaTelefonica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MetodosMenus menu = new MetodosMenus();
        Scanner sc = new Scanner(System.in);
        List<Contato> agenda = new ArrayList<Contato>();

        while (true) {

            menu.ExibirMenu();
            int opção = sc.nextInt();
            sc.nextLine();

            switch (opção){
                case 1:
                    menu.AdcionarContato(agenda,sc);
                    break;
                case 2:
                    menu.MostrarContatos(agenda);
                    break;
                case 3:
                    menu.ProcurarContato(agenda,sc);
                    break;
                case 4:
                    menu.RemoverContato(agenda,sc);
                    break;
                case 5:
                    System.out.println("Programa finalizado!");
                    menu.Separador();
                    return;
                default:
                    menu.Separador();
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
