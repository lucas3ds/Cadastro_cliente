
package cadastro;

import java.util.Random;

public class ContaCliente {
    
private String numConta;
    private String nomeCliente;
    private String endCliente;
    private String cpf;

    public ContaCliente(String nomeCliente, String endCliente, String cpf) {
        this.numConta = gerarNumeroConta();
        this.nomeCliente = nomeCliente;
        this.endCliente = endCliente;
        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    // Gerar um número de conta aleatório (com letras e números)
    private String gerarNumeroConta() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append(letras.charAt(random.nextInt(letras.length())));
        }

        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    // Método para validar CPF
    private boolean validarCPF(String cpf) {
        String cpf_cliente = cpf; // Substitua pelo CPF que deseja verificar

    // Remove caracteres não numéricos
    String cpfNumerico = cpf_cliente.replaceAll("[^0-9]", "");

    // Verifica se o CPF possui 11 dígitos
    if (cpfNumerico.length() != 11) {
        System.out.println("CPF inválido: deve conter 11 dígitos.");
        return false;
    }

    // Calcula o primeiro dígito de verificação
    int digito1 = calcularDigitoVerificador(cpfNumerico.substring(0, 9));

    // Calcula o segundo dígito de verificação
    int digito2 = calcularDigitoVerificador(cpfNumerico.substring(0, 10));

    // Verifica se os dígitos de verificação calculados são iguais aos dígitos originais
    if (digito1 == Character.getNumericValue(cpfNumerico.charAt(9)) &&
        digito2 == Character.getNumericValue(cpfNumerico.charAt(10))) {
        System.out.println("CPF válido.");
        return true;
    } else {
        System.out.println("CPF inválido.");
        return false; // Adicione essa linha para retornar explicitamente false em caso de CPF inválido.
    }

    }
    // Função para calcular um dígito de verificação do CPF
    private static int calcularDigitoVerificador(String parteCpf) {
        int total = 0;
        int peso = parteCpf.length() + 1;

        for (int i = 0; i < parteCpf.length(); i++) {
            total += Character.getNumericValue(parteCpf.charAt(i)) * peso;
            peso--;
        }

        int resto = total % 11;
        if (resto < 2) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
    public String getNumConta() {
        return numConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public String getCpf() {
        return cpf;
    }
}