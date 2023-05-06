package co.c100.bank;

public class Account {

    private static final int Max_LENGTH = 12;
    private String ag; // agência
    private String cc; // conta
    private String name;
    private double balance;

    private Log logger = new Log();

    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);

    }

    public void setName(String name) {
        if (name.length() > Max_LENGTH) {
            this.name = name.substring(0, Max_LENGTH);
        } else {
            this.name = name;
        }
    }

       public void deposit(double value){
            balance+=value;
            logger.out("DEPOSITO - R$" + value + "Sua conta agora é de R$ " + balance);
       }


    public boolean toWithDraw(double value) {
        if (balance < value) {
            logger.out("SAQUE - R$ " + value + "Seu saldo atual é de R$ " + balance);
            return false;
        } else {
            balance -= value;
            logger.out("SAQUE - R$ " + value + "Sua conta agora é de R$ " + balance);
            return true;
        }
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        //String result =
        return  "A conta " + this.name + "  " + this.ag + " " + " / " + this.cc + "possui: R$" + balance;
    }
}

