package NimGame;

import java.util.Random;
import java.util.Scanner;

public class Nim {
    private int numberOfstack;
    public int[] stacks;
    private boolean player1;

    public Nim(int numberOfstack) {
        this.numberOfstack = numberOfstack;
        stacks=new int[numberOfstack];
        Random rand=new Random(System.currentTimeMillis());
        for (int i=0;i<numberOfstack;i++){
            stacks[i]=rand.nextInt(30);
        }
        interactivePlay();
    }

    public boolean thereAreStonesInStack(){
        boolean stones=false;
        for (int i=0;i<numberOfstack;i++){
            if (stacks[i]!=0)
                stones=true;
        }
        return stones;
    }

    public void displayStaks(){
        for (int i=0;i<numberOfstack;i++)
            System.out.print(stacks[i]+" ");
    }

    public int getBiggestStack(){
        int maximum=0;
        for (int i=0; i<numberOfstack;i++){
            if (stacks[i]>maximum) {
                maximum = stacks[i];
            }
        }
        return maximum;
    }

    public void interactivePlay(){
        Scanner scanner= new Scanner(System.in);
        displayStaks();
        while (thereAreStonesInStack()){
            int[] result=move();
            if (result[0]!=0) {
                System.out.println("Player 1 has moved: " + result[0] + " stones from stack number " +( result[1]+1));
                System.out.println();
                displayStaks();
                player1 = true;
                if (!thereAreStonesInStack())
                    break;
                System.out.println("Your turn! How many stones do you remove and from which stack? ");
                int stones = scanner.nextInt();
                int stack = scanner.nextInt()-1;
                //aici ar mai trebui verificari suplimentare ca numarul de pietre sa nu fie mai mare decat numarul existent
                //si numarul stivei din care se scoate sa nu fie mai mare decat nr de stive existente
                stacks[stack] -= stones;
                displayStaks();
                System.out.println();
                player1 = false;
            }
            else{
                System.out.println("There are no possible move for computer to win");
                break;
            }
        }
        if (player1)
            System.out.println("You lost. Better luck next time");
        else
            System.out.println("You won. Congratulations");
    }

    public int[] move(){
        int numberOfStones;
        int indexOfStack;
        int result=0;
        int temporaryResult=result;
        int[] moves= new int[2];
        for (int k = 0; k < numberOfstack; k++)
            result ^= stacks[k];
        for (numberOfStones=1;numberOfStones<=getBiggestStack();numberOfStones++){
            for (indexOfStack=0;indexOfStack<numberOfstack;indexOfStack++){
                if (stacks[indexOfStack]>=numberOfStones){
                    temporaryResult= result^stacks[indexOfStack]^(stacks[indexOfStack]-numberOfStones);
                    if (temporaryResult==0){
                        stacks[indexOfStack]-=numberOfStones;
                        moves[0]=numberOfStones;
                        moves[1]=indexOfStack;
                        return moves;
                    }
                }

            }
        }
        moves[0]=0;
        moves[1]=0;
        return moves;
    }
}
