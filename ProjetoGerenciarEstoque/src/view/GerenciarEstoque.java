package view;

import model.Produto;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    public static List<Produto> listaProdutos = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int escolha = 0;

        while(escolha != 9 ) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar model.Produto");
            System.out.println("2. Alterar modelo do produto");
            System.out.println("3. Excluir modelo do produto");
            System.out.println("4. Entrada de estoque");
            System.out.println("5. Saída do estoque");
            System.out.println("6. Saldo atual do estoque");
            System.out.println("7. Listar produtos");
            System.out.println("9. Sair");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    entradaNoEstoque();
                    break;
                case 5:
                    saidaNoEstoque();
                    break;
                case 6:
                    saldoAtual();
                    break;
                case 7:
                    listarProdutos();
                    break;
                case 9:
                    break;

            }
        }
    }


    private static void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("A quantidade do produto: ");
        int quantidade = scanner.nextInt();

        System.out.print("O preço do produto: ");
        double preco = scanner.nextDouble();

        listaProdutos.add(new Produto(nome, quantidade, preco));
        System.out.println("O produto cadastrado com sucesso!");
    }


    //Encontra um produto pelo nome
    private static Produto encontrarProdutoPeloNome(String nome) {
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }


    private static void alterarProduto() {
        System.out.print("Digite o nome do produto que deseja alterar: ");
        String nome = scanner.nextLine();

        Produto produto = encontrarProdutoPeloNome(nome);

        if (produto != null) {
            System.out.print("Novo nome: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Nova quantidade: ");
            produto.setQuantidade(scanner.nextInt());

            System.out.print("Novo preço: ");
            produto.setPreco(scanner.nextDouble());

            System.out.println("Dados do produto atualizados com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }


    private static void excluirProduto() {
        System.out.print("Digite o nome do produto que deseja excluir: ");
        String nome = scanner.nextLine();

        Produto produto = encontrarProdutoPeloNome(nome);

        if (produto != null) {
            listaProdutos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }


    private static void entradaNoEstoque() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        Produto produto = encontrarProdutoPeloNome(nome);

        if (produto != null) {
            System.out.print("Quantidade a ser adicionada: ");
            int quantidade = scanner.nextInt();

            produto.setQuantidade(produto.getQuantidade() + quantidade);
            System.out.println("Entrada no estoque realizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }


    private static void saidaNoEstoque() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        Produto produto = encontrarProdutoPeloNome(nome);
        if (produto != null) {
            System.out.print("Quantidade a ser retirada: ");
            int quantidade = scanner.nextInt();
            if (produto.getQuantidade() >= quantidade) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                System.out.println("Saída no estoque realizada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque!");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }


    private static void saldoAtual() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        Produto produto = encontrarProdutoPeloNome(nome);

        if (produto != null) {
            System.out.println("Saldo atual: " + produto.getQuantidade());
        } else {
            System.out.println("Produto não encontrado!");
        }
    }


    private static void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado ainda!");

        } else {
            System.out.println("----- Produtos Cadastrados -----");

            for (Produto produto : listaProdutos) {
                System.out.println(produto.toString());
            }
        }
    }

}