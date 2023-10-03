package CarrinhoDeCompras;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinhoList;
    
    public CarrinhoDeCompras() {
        this.carrinhoList = new ArrayList<>();
    }
    
    public void adicionarItem(String nome, double preço, int quantidade) {
        carrinhoList.add(new Item(nome, preço, quantidade));
    } 

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for(Item i : carrinhoList) {
            if(i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        carrinhoList.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        
        if(!carrinhoList.isEmpty()) {
            for(Item item : carrinhoList) {
                double valorItem = item.getPreço() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!carrinhoList.isEmpty()) {
          System.out.println(this.carrinhoList);
        } else {
          System.out.println("A lista está vazia!");
        }
      }

      @Override
      public String toString() {
        return "CarrinhoDeCompras{" +
            "itens=" + carrinhoList +
            '}';
      }
    
    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Pao", 1d, 23);

        carrinhoDeCompras.exibirItens();
    }

}
