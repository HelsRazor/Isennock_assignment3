public class SavingsAccountTest {
    public static void main(String[] args){

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.setAnnualInterestRate(.04);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Saver1 at %.2f%% : %.2f%nSaver2 at %.2f%% : %.2f%n",SavingsAccount.getAnnualInterestRate(),saver1.getSavingsBalance(),SavingsAccount.getAnnualInterestRate(),saver2.getSavingsBalance());

        SavingsAccount.setAnnualInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Saver1 at %.2f%% : %.2f%nSaver2 at %.2f%% : %.2f",SavingsAccount.getAnnualInterestRate(),saver1.getSavingsBalance(),SavingsAccount.getAnnualInterestRate(),saver2.getSavingsBalance());

    }
}
