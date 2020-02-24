import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
    private int x;
    private int y;
    private int z;
    private Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CAI2 q = new CAI2();
        q.quiz();
    }
    public void quiz(){
        int response;
        Boolean correct = false;
        askQuestion();
        do{
            response = readResponse();
            correct = isAnswerCorrect(response);

        }while (!correct);
    }

    public void askQuestion(){

        int tempX;
        int tempY;
        int tempZ;
        SecureRandom sr = new SecureRandom();

        tempX = sr.nextInt(100)%10;
        tempY = sr.nextInt(100)%10;

        setX(tempX);
        setY(tempY);

        System.out.printf("How much is %d times %d?%n",getX() , getY());

        tempZ = getX() * getY();

        setZ(tempZ);

    }

    public int readResponse(){
        int response = scn.nextInt();
        return response;
    }

    public Boolean isAnswerCorrect(int response){
        if(response == getZ()){
            displayCorrectResponse();
            return true;
        }else{
            displayIncorrectResponse();
            return false;
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

    public void setX(int tempX){
        x = tempX;
    }
    public void setY(int tempY){
        y = tempY;
    }
    public void setZ(int tempZ){
        z = tempZ;
    }
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}
