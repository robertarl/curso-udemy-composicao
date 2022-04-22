package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class OrderProgram {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Digite os dados do cliente: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);


        System.out.println("Digite os dados do pedido: ");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos itens para este pedido? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println("Digite os dados do item #"+ i);
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Preço do produto: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);

        sc.close();

    }
}
