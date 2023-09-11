
package cadastro;

public class ListaEncadeada {
    private Nodo primeiro;

    private class Nodo {
        ContaCliente cliente;
        Nodo proximo;

        Nodo(ContaCliente cliente) {
            this.cliente = cliente;
            this.proximo = null;
        }
    }

    public void inserirCliente(ContaCliente cliente) {
        Nodo novoNodo = new Nodo(cliente);
        if (primeiro == null) {
            primeiro = novoNodo;
        } else {
            Nodo atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNodo;
        }
    }

    public ContaCliente buscarClientePorNome(String nome) {
        Nodo atual = primeiro;
        while (atual != null) {
            if (atual.cliente.getNomeCliente().equalsIgnoreCase(nome)) {
                return atual.cliente;
            }
            atual = atual.proximo;
        }
        return null; // Cliente não encontrado
    }
      public void imprimirLista() {
        Nodo atual = primeiro;
        while (atual != null) {
            ContaCliente cliente = atual.cliente;
            System.out.println("Número da Conta: " + cliente.getNumConta());
            System.out.println("Nome do Cliente: " + cliente.getNomeCliente());
            System.out.println("Endereço: " + cliente.getEndCliente());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("-----------------------------");
            atual = atual.proximo;
        }
    }
}
