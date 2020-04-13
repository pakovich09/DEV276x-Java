import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int player_choice = 0;

        System.out.println("Let’s play a game called “Odds and Evens”");
        System.out.print("What is your name?  ");
        String name = input.next();
        System.out.print("Hello "+ name + "! Shall we start!\nWhich do you choose? (O)dds or (E)vens?   ");
        String choice = input.next();

        while(!choice.startsWith("O") && !choice.startsWith("o") && !choice.startsWith("E") && !choice.startsWith("e")){
            System.out.print("Bitch u stoopid...\nEnter o for (O)dds or e for (E)vens   ");
            choice = input.next();
        }
        if(choice.startsWith("O") || choice.startsWith("o")){
            player_choice = 1;
            System.out.println(name + " has picked odds! Computer will pick evens.");
        }
        else if(choice.startsWith("E") || choice.startsWith("e")){
            player_choice = 2;
            System.out.println(name + " has picked evens! Computer will pick odds.");
        }
        System.out.println("-------------------------");

        System.out.print("How many \"fingers\" do you put out? (a number from 0 to 5)");
        int fingers = input.nextInt();
        while(fingers<0 || fingers>5){
            System.out.print("Please enter a number from 0 to 5.\n" +
                    "How many \"fingers\" do you put out? (a number from 0 to 5)");
            fingers = input.nextInt();
        }

        Random random = new Random();
        int computer_fingers = random.nextInt(6);
        System.out.println("The computer plays "+ computer_fingers + "fingers.\n-------------------------");

        System.out.println(fingers + " + " + computer_fingers + " = "+ (fingers+computer_fingers));
        if((fingers+computer_fingers)%player_choice!=0)
            System.out.println("Haha you LOSER! HERE IS YOUR L, biatch");
        else
            System.out.println("Ok i loose, gonna beat your ass next time...");
    }
}
