package entidades;

public class ItensPedidos {

    private int quantidade;
    private double preco;

    private Produtos produto;

    public ItensPedidos(int quantity, double price, Produtos produto) {
        this.quantidade = quantity;
        this.preco = price;
        this.produto = produto;
    }

    public double subTotal(){
        return  preco * quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return  getProduto().getNome() + ", $" + String.format("%.2f",preco) + "," +
                "Quantidade: " + quantidade + "," + "Subtotal $: " + String.format("%.2f",subTotal()) ;
    }
}
