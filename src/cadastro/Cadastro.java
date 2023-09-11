
package cadastro;

public class Cadastro {

    public static void main(String[] args) {
         ListaEncadeada listaClientes = new ListaEncadeada();

        ContaCliente cliente1 = new ContaCliente("João", "Rua A, 123", "708250971-50");
        ContaCliente cliente2 = new ContaCliente("Maria", "Rua B, 456", "987.654.321-00");

        listaClientes.inserirCliente(cliente1);
        listaClientes.inserirCliente(cliente2);
        listaClientes.imprimirLista();
        
        ContaCliente clienteEncontrado = listaClientes.buscarClientePorNome("João");
        
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNomeCliente());
            System.out.println("Número da Conta: " + clienteEncontrado.getNumConta());
            System.out.println("Endereço: " + clienteEncontrado.getEndCliente());
            System.out.println("CPF: " + clienteEncontrado.getCpf());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
