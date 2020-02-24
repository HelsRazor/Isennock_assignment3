import java.math.BigDecimal;
import java.math.MathContext;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5{

    private double x;
    private double y;
    private double z;

    private Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CAI5 q = new CAI5();
        q.quiz();
    }
    public void quiz(){
        double response;
        int correct;
        int difficultyLevel;
        int problemSpread;
        Boolean cnt;
        do {
            System.out.println("Please choose a difficulty Level : ");
            difficultyLevel = scn.nextInt();

            System.out.println("Please select 1 for addition, 2 for multiplication, 3 for subtraction, 4 for division, 5 for a mix");
            problemSpread = scn.nextInt();

            correct = 0;

            for (int i = 0; i < 10; i++) {
                askQuestion(difficultyLevel,problemSpread);
                response = readResponse();
                correct += isAnswerCorrect(response);

            }
            displayCompletionMessage(correct);
            System.out.println("Would you like to solve more problems? (1 for yes 0 for no)");
            if(scn.nextInt() == 1){
                cnt = true;
            }else{
                cnt = false;
            }
        }while(cnt);
    }

    public void askQuestion(int dL,int pS){

        int tempX=0;
        int tempY=0;
        int tempPS = pS;
        double tempZ;



        SecureRandom sr = new SecureRandom();
        switch (dL) {
            case 1:
                tempX = sr.nextInt(100) % 10;
                tempY = sr.nextInt(100) % 10;
                break;
            case 2:
                tempX = sr.nextInt(1000) % 1000;
                tempY = sr.nextInt(1000) % 1000;
                break;
            case 3:
                tempX = sr.nextInt(10000) % 10000;
                tempY = sr.nextInt(10000) % 10000;
                break;
            case 4:
                tempX = sr.nextInt(100000) % 100000;
                tempY = sr.nextInt(100000) % 100000;
        }
        setX(tempX);
        setY(tempY);

        if(pS==5){
            tempPS = (sr.nextInt(3)+1);
        }

        switch (tempPS) {
            case 1:
                System.out.printf("How much is %.0f plus %.0f?%n", getX(), getY());

                tempZ = getX() + getY();

                setZ(tempZ);

                break;

            case 2:

                System.out.printf("How much is %.0f times %.0f?%n", getX(), getY());

                tempZ = getX() * getY();

                setZ(tempZ);

                break;

            case 3:
                System.out.printf("How much is %.0f minus %.0f?%n", getX(), getY());

                tempZ = getX() - getY();

                setZ(tempZ);

                break;

            case 4:

                if(getY()==0){
                  //  System.out.printf("Y is zero :%.0f",getY());
                    setY(1.0);
                //    System.out.printf("Y is no longer 0 it is %.0f",getY());
                }

                System.out.printf("How much is %.0f divided by %.0f?%n", getX(), getY());

                tempZ = (double) getX() / (double)getY();
                BigDecimal bd = new BigDecimal(tempZ);
                MathContext mc = new MathContext(3);
                bd = bd.round(mc);
                tempZ = bd.doubleValue();
                setZ(tempZ);

                break;
            }
    }

    public double readResponse(){
        double response = scn.nextDouble();
        return response;
    }

    public int isAnswerCorrect(double response){

        if(response == getZ()){
            displayCorrectResponse();
            return 1;
        }else{
            displayIncorrectResponse();
            return 0;
        }
    }

    public void displayCorrectResponse(){

        SecureRandom sr = new SecureRandom();
        int selector = (sr.nextInt(4) % 4) + 1;

        switch (selector){

            case 1:
                System.out.println("Very Good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice Work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;

        }

    }

    public void displayIncorrectResponse(){
        SecureRandom sr = new SecureRandom();
        int selector = (sr.nextInt(4) % 4) + 1;
        //System.out.println("Selector is :" + selector);
        switch (selector){

            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don’t give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;

        }

    }


    public void displayCompletionMessage(int correct){

        double score = (double)correct / 10;

        if(score >= .75){
            score = score * 100;
            int readableScore = (int)score;
            System.out.printf("%d%% Congratulations, you are ready to go to the next level!%n", readableScore);
        }else{
            score = score * 100;
            int readableScore = (int)score;
            System.out.printf("%d%% Please ask your teacher for extra help.%n", readableScore);
        }

    }


    public void setX(double tempX){
        x = tempX;
    }
    public void setY(double tempY){
        y = tempY;
    }
    public void setZ(double tempZ){
        z = tempZ;
    }
    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

}