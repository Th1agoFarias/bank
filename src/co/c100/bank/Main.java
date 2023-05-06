package co.c100.bank;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Bank santander = new Bank("00001");

        while (true) {


            System.out.println("O que deseja fazer ? C=Criar conta, E=Sai do programa");
            String op = input.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome: ");
                String name = input.nextLine();
                System.out.println(name);
                Account account = santander.generateAccoount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente !");
            }
        }

        List<Account> accountList = santander.getAccount();
            for(Account cc: accountList){
                System.out.println(cc);
            }
            santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("O que deseja fazer ? D=Deposito, S=Saque, E= Sair da conta ");
            String op = input.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar ? ");
                double value = input.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual valor deseja sacar ?");
                double value = input.nextDouble();
                if (!account.toWithDraw(value)) {
                    System.out.println("Ops ! Não foi possível sacar o valor !" + value);
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente !");
            }

            input = new Scanner(System.in);

        }

    }

}

