import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        String moedaBase = "";
        String moedaDestino = "";

        System.out.println("****************************************");
        System.out.println("Seja vem-vindo ao Conversor de Moeda!");

        while (true) {

            System.out.println("""
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileiro
                    4) Real brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiao =>> Dólar
                    7) Sair
                    
                    """);
            System.out.println("****************************************");

            int opcaoDigitada = -1;
            try {
                opcaoDigitada = leitura.nextInt();

                if (opcaoDigitada == 7) {
                    System.out.println("Saindo...");
                    break;
                }

                switch (opcaoDigitada) {
                    case 1:
                        moedaBase = "USD";
                        moedaDestino = "ARS";
                        break;
                    case 2:
                        moedaBase = "ARS";
                        moedaDestino = "USD";
                        break;
                    case 3:
                        moedaBase = "USD";
                        moedaDestino = "BRL";
                        break;
                    case 4:
                        moedaBase = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 5:
                        moedaBase = "USD";
                        moedaDestino = "COP";
                        break;
                    case 6:
                        moedaBase = "COP";
                        moedaDestino = "USD";
                        break;

                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Insira apenas números inteiros.");
                leitura.nextLine();
                continue;

            }

            System.out.println("Digite o valor que deseja converter:");
            double valor = leitura.nextDouble();

            ConverterMoeda conversor = new ConverterMoeda();

            try {
                MostraMoeda taxas = conversor.conversao(moedaBase);

                double taxa = taxas.conversion_rates().getOrDefault(moedaDestino, 0.0);
                if (taxa == 0.0) {
                    System.out.println("Não foi possível obter a taxa de conversão para " + moedaDestino);
                } else {

                    double valorConvertido = valor * taxa;
                    System.out.printf("Você inseriu %.2f %s. Isso equivale a %.2f %s.%n",
                            valor, moedaBase, valorConvertido, moedaDestino);
                }

                //System.out.println(taxas);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação.");
                break;
            }

        }
    }



        }


