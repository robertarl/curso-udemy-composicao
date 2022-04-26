package aplicacao;


import entidades.Cliente;
import entidades.Pedido;
import entidades.ItensPedidos;
import entidades.Produtos;
import enums.StatusPedidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Compras {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Digite os dados do cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date dataNascimento = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome, email, dataNascimento);


        System.out.println("Digite os dados do pedido: ");

        System.out.print("Status: ");
        StatusPedidos status = StatusPedidos.valueOf(sc.next());

        Pedido pedido = new Pedido(new Date(), status, cliente);

        System.out.print("Quantos itens para este pedido? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println("Digite os dados do item #"+ i);
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();

            System.out.print("Preço do produto: ");
            Double precoProduto = sc.nextDouble();

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            Produtos produtos = new Produtos(nomeProduto, precoProduto);

            ItensPedidos itensPedidos = new ItensPedidos(quantidade, precoProduto, produtos);

            pedido.addItem(itensPedidos);
        }

        System.out.println();
        System.out.println(pedido);

        sc.close();

    }
}
