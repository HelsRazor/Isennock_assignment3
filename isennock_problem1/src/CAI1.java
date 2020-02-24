import java.security.SecureRandom;

import java.util.Scanner;


public class CAI1 {
    private int x;
    private int y;
    private int z;
    private Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CAI1 q = new CAI1();
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
        System.out.printf("Very good!");
    }

    public void displayIncorrectResponse(){
        System.out.printf("No . Please try again.%n");
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
