package entidades;

import enums.StatusPedidos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private StatusPedidos status;
    private Cliente cliente;

    private List<ItensPedidos> items = new ArrayList<ItensPedidos>();

    public Pedido(Date momento, StatusPedidos status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public void addItem(ItensPedidos item){
        items.add(item);
    }
    public void removeItem(ItensPedidos item){
        items.remove(item);
    }

    public double total(){
        double total = 0.0;
        for(ItensPedidos item : items){
            total += item.subTotal();
        }
        return total;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusPedidos getStatus() {
        return status;
    }

    public void setStatus(StatusPedidos status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Resumo do pedido: \n");

        sb.append("Momento do pedido: ");
        sb.append(sdf.format(momento) + "\n");

        sb.append("Status do pedido: ");
        sb.append(status + "\n");

        sb.append("Cliente: ");
        sb.append(cliente + "\n");

        sb.append("Items do pedido: \n");
        for (ItensPedidos item : items) {
            sb.append(item + "\n");
        }

        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}
