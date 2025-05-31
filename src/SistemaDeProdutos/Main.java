package SistemaDeProdutos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();

        MetodosProdutos metodo = new MetodosProdutos();


        int id = 1;

        boolean parar = false;


        do {
            int opcao = metodo.Menu(sc);

            switch (opcao){
                case 1 :
                    metodo.VenderProdutos(produtos);
                    break;
                case 2 :
                    produtos.add(metodo.AdicionarProdutos(id));
                    id ++;
                    break;
                case 3 :
                    metodo.ListarProdutos(produtos);
                    break;
                case 4 :
                    metodo.DeletarProdutos(produtos);
                case 5:
                    parar = true;
                    System.out.println("Encerrando......");
                    break;
            }

        }while(!parar);
    }
}
