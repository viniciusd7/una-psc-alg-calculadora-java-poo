import java.util.Scanner;

class Calculadora {
    private double numeroUm;
    private double numeroDois;

    public void definirParametros(double numeroUm, double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }

    public void definirNumeroUm(double numeroUm) {
        this.numeroUm = numeroUm;
    }

    public double adicionar() {
        return numeroUm + numeroDois;
    }

    public double subtrair() {
        return numeroUm - numeroDois;
    }

    public double multiplicar() {
        return numeroUm * numeroDois;
    }

    public double dividir() {
        if (numeroDois == 0) {
            System.out.println("Impossivel realizar uma divisao por zero.");
            return Double.NaN;
        }
        return numeroUm / numeroDois;
    }

    public double potencia() {
        if (numeroDois == 0) {
            return 1.0;
        }
        return Math.pow(numeroUm, numeroDois);
    }

    public double raizQuadrada() {
        if (numeroUm < 0) {
            System.out.println("Nao existe raiz de numero negativo.");
            return Double.NaN;
        }
        return Math.sqrt(numeroUm);
    }

    public void executarOperacao(int opcao) {
        double resultado = Double.NaN;

        switch (opcao) {
            case 1:
                resultado = adicionar();
                break;
            case 2:
                resultado = subtrair();
                break;
            case 3:
                resultado = multiplicar();
                break;
            case 4:
                resultado = dividir();
                break;
            case 5:
                resultado = potencia();
                break;
            case 6:
                resultado = raizQuadrada();
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente.");
                return;
        }

        if (!Double.isNaN(resultado)) {
            System.out.println("Resultado: " + resultado);
        }
    }

    public static void main(String[] args) {
        Scanner Leitor = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        while (true) {
            System.out.println("Digite o primeiro numero (ou Q para sair):");
            String input = Leitor.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            double numeroUm = Double.parseDouble(input);

            System.out.println("Digite o segundo numero (ou Q para sair):");
            input = Leitor.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            double numeroDois = Double.parseDouble(input);

            calculadora.definirParametros(numeroUm, numeroDois);

            System.out.println("Escolha a operacao desejada:");
            System.out.println("1. Adicao");
            System.out.println("2. Subtracao");
            System.out.println("3. Multiplicacao");
            System.out.println("4. Divisao");
            System.out.println("5. Potencia");
            System.out.println("6. Raiz Quadrada (do primeiro numero)");

            int opcao = Integer.parseInt(Leitor.nextLine());

            calculadora.executarOperacao(opcao);

            System.out.println();
        }

        Leitor.close();
    }
}
