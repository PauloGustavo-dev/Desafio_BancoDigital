import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String tipoDeConta = "vazio";
        String menuTipoDeConta="""
            Tipo de conta:
            1 -  Corrente
            2 - Poupança 
            Digite o número da opção escolhida: """;
        Float saldoCliente = (float) 0.0 ;
        String menuPrincipal="""

        ------------------------------------
        Operações

        1- Consultar saldos
        2- Receber valor
        3- Transferir valor
        4- Dados pessoais
        5- Sair

        Digite a opção desejada:""";
        String opcaoMenuPrincipal ="vazio";

        System.out.println("Bem vindo ao Banco Digital!");
        //Coleta de dados do Cliente
        System.out.println("Para iniciar a sua conta insira os dados a seguir: ");
        System.out.println("Nome: ");
        String nomeCliente = leitor.nextLine();
        //loop validador de opcão inserida para tipo de conta
        while(tipoDeConta.equals("vazio")){
            System.out.println(menuTipoDeConta);
            tipoDeConta = leitor.nextLine();
            switch (tipoDeConta) {
                case "1":
                    tipoDeConta = "Corrente";
                    System.out.println("Parabens,você selecionou a conta "+ tipoDeConta);
                    break;
                case "2":
                    tipoDeConta = "Poupança";
                    System.out.println("Parabens,você selecionou a conta "+ tipoDeConta);
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    tipoDeConta = "vazio";
                    break;
            }
    
        }
        while(saldoCliente == 0.0){
            try {
                System.out.println("Saldo inicial:");
                saldoCliente = leitor.nextFloat();
                //limpando cache do scanner
                leitor.nextLine();
            } catch (Exception e) {
                System.out.println("Digite apenas numeros");
                saldoCliente = (float) 0.0 ;
                //limpando cache do scanner
                leitor.nextLine();
            }  
        }
        //loop menu principal
        while(opcaoMenuPrincipal.equals("5") == false){
            System.out.println(menuPrincipal);
            opcaoMenuPrincipal = leitor.nextLine();
            switch (opcaoMenuPrincipal) {
                case "1":
                    System.out.format("O saldo atual é de R$"+" %.2f ", saldoCliente);
                    break;
                case "2":
                    try {
                        System.out.println("Informe o valor a receber: ");
                        Float valorRecebido = leitor.nextFloat();
                        saldoCliente += valorRecebido;
                        System.out.format("Saldo atualizado: R$"+"%.2f", saldoCliente);
                        //limpando cache do scanner
                        leitor.nextLine();
                    } catch (Exception e) {
                        System.out.println("Digite apenas numeros");
                        //limpando cache do scanner
                        leitor.nextLine();
                    }
                    break;
                case "3":
                    try {
                        System.out.println("Informe o valor que deseja transferir: ");
                        Float valorTransferencia = leitor.nextFloat();
                        //limpando cache do scanner
                        leitor.nextLine();
                        if(valorTransferencia > saldoCliente){
                            System.out.println("O saldo não é suficiente para realizar a transferencia");
                            break;
                        }
                        saldoCliente -= valorTransferencia;
                        System.out.format("Saldo atualizado: R$"+"%.2f", saldoCliente);
                        
                    } catch (Exception e) {
                        System.out.println("Digite apenas numeros");
                        //limpando cache do scanner
                        leitor.nextLine();
                    }
                    break;
                case "4":
                    System.out.println("Nome: "+nomeCliente);
                    System.out.println("Tipo de conta: "+tipoDeConta);
                    System.out.format("Saldo: R$"+"%.2f", saldoCliente);
                    break;
                case "5":
                    System.out.println("Obrigado por ultilizar os serviços do Banco Digital!!");
                    opcaoMenuPrincipal = "5";
                    leitor.close();
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }
        }
    }
}
