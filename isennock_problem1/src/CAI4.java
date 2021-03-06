import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

    private int x;
    private int y;
    private int z;
    private Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CAI4 q = new CAI4();
        q.quiz();
    }
    public void quiz(){
        int response;
        int correct;
        int difficultyLevel;
        Boolean cnt;
        do {
            System.out.println("Please choose a difficulty Level : ");
            difficultyLevel = scn.nextInt();

            correct = 0;
            for (int i = 0; i < 10; i++) {
                askQuestion(difficultyLevel);
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

    public void askQuestion(int dL){

        int tempX=0;
        int tempY=0;
        int tempZ;
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

        System.out.printf("How much is %d times %d?%n",getX() , getY());

        tempZ = getX() * getY();

        setZ(tempZ);

    }

    public int readResponse(){
        int response = scn.nextInt();
        return response;
    }

    public int isAnswerCorrect(int response){
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
