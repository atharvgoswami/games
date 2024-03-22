package Game;

import java.util.*;

public class Snake_And_Ladder {
    // searching elements in an array (using binary search){
    public static boolean binarySearch(int arr[], int k) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == k)
                return true;
            if (arr[mid] >= k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    // for snakes:
    public static int snake(int pos) {
        return switch (pos) {
            case 34 -> {
                System.out.println("Oops! You encounterred a snake at " + 34);
                yield 5;
            }
            case 72 -> {
                System.out.println("Oops! You encounterred a snake at " + 72);
                yield 53;
            }
            case 77 -> {
                System.out.println("Oops! You encounterred a snake at " + 77);
                yield 2;
            }
            case 95 -> {
                System.out.println("Oops! You encounterred a snake at " + 95);
                yield 12;
            }
            case 98 -> {
                System.out.println("Oops! You encounterred a snake at " + 98);
                yield 60;
            }
            default -> pos;
        };
    }

    // for ladders:
    public static int ladder(int pos) {
        return switch (pos) {
            case 7 -> {
                System.out.println("Congo! You got a ladder at "+ 7);
                yield 30;
            }
            case 23 -> {
                System.out.println("Congo! You got a ladder at "+ 23);
                yield 73;
            }
            case 36 -> {
                System.out.println("Congo! You got a ladder at "+ 36);
                yield 63;
            }
            case 64 -> {
                System.out.println("Congo! You got a ladder at "+ 64);
                yield 96;
            }
            default -> pos;
        };
    }

    // spinning the dice:
    public static int spinDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    // The main game:
    public static void game(int[] player) {
        Random rand = new Random(); // creating Random object
        Scanner sc = new Scanner(System.in); // creating Scanner object
        // choosing who will start the game
        
        while (!binarySearch(player, 100)) { // loop runs until we get a winner
            for (int i = 0; i < player.length; i++) {
                System.out.println("Its player " + (i + 1) + "\'s turn");
                System.out.print("Type anything to spin the dice ");
                sc.next();
                int move = spinDice();
                System.out.println("Player "+(i+1)+" got "+move);
                if (player[i] + move <= 100) {
                    player[i] += move;
                }
                // if a player reaches 100 it means he won the game
                if (player[i] == 100) {
                    System.out.println("Player " + (i + 1) + " won the game");
                    break;
                }
                // if player gets snake or ladder: 
                player[i]=snake(player[i]);
                player[i]=ladder(player[i]);                
                System.out.println("The player "+(i+1)+" is at "+player[i]);
                if(move == 6){
                    i--;
                }
                System.out.println("_____________________________________");
            }
            
        }
    }

    // main function:
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Atharv's Snake and Ladder Game!");
        System.out.println("__________________________________________");
        System.out.println("Enter the number of players (minimum 2 and maximum 4 players) : ");
        int n = sc.nextInt();
        if(n>4 || n<2){
            System.out.println("Wrong input!");
        }
        else{
        int player[] = new int[n]; // array of players will be created
        // initially, the players will be at position 0, that is, [0,0,0,0]
        game(player);
        }
        sc.close();
    }
}
