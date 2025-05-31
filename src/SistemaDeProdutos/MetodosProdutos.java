package SistemaDeProdutos;

import java.util.ArrayList;
import java.util.Scanner;

public class MetodosProdutos {
    Scanner sc = new Scanner(System.in);

    public static void Separador(){
        System.out.println("------------------------------");
    }

    public static int Menu(Scanner sc){
        Separador();
        System.out.println("Digite a opção desejada: ");
        System.out.println("[1] Vender produto");
        System.out.println("[2] Adicionar produto");
        System.out.println("[3] Listar produtos");
        System.out.println("[4] Deletar produto");
        System.out.println("[5] Sair");
        System.out.print("Opção: ");
        int opção = sc.nextInt();
        Separador();

        return opção;
    }

    public Produto AdicionarProdutos(int id){

        System.out.println("Adicione nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Adicione o valor do produto: ");
        double valor = sc.nextDouble();

        Produto produto = new Produto(id,nome,valor);

        System.out.println("Produto adicionado com sucesso!");

        Separador();
        return produto;
    }

    public void ListarProdutos(ArrayList<Produto> produtos){

        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.println();
        System.out.println("Lista de Produtos: ");

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i).toString());
        }
        Separador();
    }

    public void DeletarProdutos(ArrayList<Produto> produtos){

        if (produtos.isEmpty()) {
            System.out.println("Não existe produtos cadastrados!");
            return;
        }

        ListarProdutos(produtos);
        System.out.println("Digite a id do produto que deseja excluir:");
        int idEscolhido = sc.nextInt();

        for (int i = 0; i < produtos.size() ; i++) {
            if (produtos.get(i).getId() == idEscolhido){
                produtos.remove(i);
                return;
            }
        }

        System.out.println("Id não encontrado!");
        System.out.println();
    }

    public void VenderProdutos(ArrayList<Produto> produtos){

        if (produtos.isEmpty()){
            System.out.println("Não existe produtos!");
            System.out.println();
            return;
        }

        ListarProdutos(produtos);

        System.out.println("Digite o id do produto que deseja vender");
        int idVenda = sc.nextInt();
        sc.nextLine();

        Produto produtoSelecionado = null;

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == idVenda){
                produtoSelecionado = produtos.get(i);
                break;
            }
        }

        if (produtoSelecionado == null){
            System.out.println();
            System.out.println("Produto não encontrado!");
            System.out.println();
            return;
        }

        System.out.println("Digite a quantidade de produtos que deseja vender: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.println();
        System.out.println("Total da venda: R$" + produtoSelecionado.getValor()*quantidade);
        System.out.println("Venda realizada com sucesso!");
    }
}
