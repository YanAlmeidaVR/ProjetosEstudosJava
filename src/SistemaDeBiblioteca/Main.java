package SistemaDeBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
        Metodos md = new Metodos();

        boolean parar = false;
        int id = 1;

        do {
            int opção = md.MostrarMenu(sc);

            switch (opção){
                case 1:
                    bibliotecas.add(md.AdcionarLivros(id));
                    id ++;
                    break;
                case 2:
                    md.ListarLivros(bibliotecas);
                    break;
                case 3:
                    md.EmprestarLivros(bibliotecas);
                    break;
                case 4:
                    md.DevolverLivros(bibliotecas);
                    break;
                case 5:
                    md.DeletarLivros(bibliotecas);
                    break;
                case 6:
                    parar = true;
            }
        }while (!parar);

        sc.close();
    }
}
