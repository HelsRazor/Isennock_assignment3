public class SavingsAccount {
    static private double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance){
        setSavingsBalance(balance);

    }

    public void calculateMonthlyInterest(){
        double monthlyInterest;
        monthlyInterest = (getSavingsBalance() * annualInterestRate)/12;
        setSavingsBalance(getSavingsBalance()+monthlyInterest);
    }

    public void setSavingsBalance(double balance){
        savingsBalance = balance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    static public void modifyInterestRate(double newInterestRate){
        setAnnualInterestRate(newInterestRate);
    }

}
