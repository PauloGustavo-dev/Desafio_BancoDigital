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

        System.out.println("Bem vindo ao Banco Digital!");
        //Coleta de dados do Cliente
        System.out.println("Para iniciar a sua conta insira os dados a seguir: ");
        System.out.println("Nome: ");
        String nomeCliente = leitor.nextLine();
        while(tipoDeConta.equals("vazio")){
            System.out.println(menuTipoDeConta);
            tipoDeConta = leitor.nextLine();
            System.out.println(tipoDeConta);
            if (tipoDeConta.equals("1") || tipoDeConta.equals("2")) {
                if (tipoDeConta.equals("1")){
                    tipoDeConta = "Corrente";
                }   else{
                    tipoDeConta = "Poupança";
                }
                System.out.println("Parabens,você selecionou a conta "+ tipoDeConta);
            }   else{
                System.out.println("Opção invalida, tente novamente");
                tipoDeConta = "vazio";
            }
        }
        System.out.println("Saldo inicial:");
        Float saldoCliente = leitor.nextFloat();
    }
}
