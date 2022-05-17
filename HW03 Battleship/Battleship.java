import java.util.Scanner;

public class Battleship {
    //welcome to main
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        //constructor call to tell subsequent code which player object is being operated
        Battleship playerOne = new Battleship(1);
        Battleship playerTwo = new Battleship(2);

        //welcome message
        System.out.println("Welcome to Battleship!");
        playerOne.shipLocation(user);
        playerTwo.shipLocation(user);

        //The game starts.
        do {
           playerTwo.Ships = playerOne.turn(user, playerOne.whichPlayer, playerTwo.Ships, playerTwo.locationBoard);
            if (playerTwo.Ships == 0){
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
                System.out.println("Final boards:\n");
                printBattleShip(playerOne.locationBoard);
                System.out.println();
                printBattleShip(playerTwo.locationBoard);
                break;
            }
           playerOne.Ships = playerTwo.turn(user, playerTwo.whichPlayer, playerOne.Ships, playerOne.locationBoard);
            if (playerOne.Ships == 0) {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
                System.out.println("Final boards:\n");
                printBattleShip(playerOne.locationBoard);
                System.out.println();
                printBattleShip(playerTwo.locationBoard);
                break;
            }

        //System.out.printf("PlayerOne Ships: %d, PlayerTwo Ships: %d\n", playerOne.Ships, playerTwo.Ships);
        } while(playerOne.Ships!=0 || playerTwo.Ships!=0);


    }
    //which player object are we working on is signified by an int. This is for accurate System.print.out messages.
    int whichPlayer;
    //flag value/iterator for no of ships per player, used in do-while loop for Battle method.
    int Ships = 5;
    //2 5x5 Location Board Arrays init and mem allocate.
    char[][] locationBoard = new char[5][5];
    //2 5x5 Target History Arrays init and mem allocate.
    char[][] targetBoard = new char[5][5];
    //methods
    //class Constructor
    Battleship(int Player){
        whichPlayer = Player;
        init();
    }
    //turn method
    int turn(Scanner user, int whichPlayer, int Ships, char[][] oppLocBoard) {
        int x, y;
        int turncheck = 0;
        //do-while or while loops allow us to resume current iteration by modifying test variable value which is not possible in for loops.
        do {
            System.out.println("Player "+ whichPlayer + ", enter hit row/column:");
            // function takeInput, checks for Integer input, 5x5 range and takes row&col values.
            x = takeInput(user);
            y = takeInput(user);
            //check if entered input is more than 2d Array Limits.
            if (x>4 || y>4){
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            //check ship locations & update boards
            if (oppLocBoard[x][y] == '@' && targetBoard[x][y] != 'X'){
                if (whichPlayer == 1) System.out.println("PLAYER 1 HIT PLAYER 2’s SHIP!");
                else System.out.println("PLAYER 2 HIT PLAYER 1’s SHIP!");
                targetBoard[x][y] = 'X';
                oppLocBoard[x][y] = 'X';
                Ships -= 1;
                turncheck = 1;
                printBattleShip(targetBoard);
            } else if (oppLocBoard[x][y] == '-' && targetBoard[x][y] != 'O'){
                System.out.println("PLAYER " + whichPlayer + " MISSED!");
                targetBoard[x][y] = 'O';
                oppLocBoard[x][y] = 'O';
                turncheck = 1;
                printBattleShip(targetBoard);
            } else{
                System.out.println("You already fired on this spot. Choose different coordinates.");
            }

        }while (turncheck == 0);

        if (Ships == 0) return Ships;

        System.out.println();
        return Ships;
    }

   static int takeInput (Scanner user) {
        int turncheck=0;
        int x = 0;
        do {
            if (user.hasNextInt()) { //check if input is integer.
                x = user.nextInt(); //copy System.in token into variable
                turncheck = 1;
            }
            else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                user.nextLine();
            }
        }while (turncheck==0);
        return x;
    }

    static void printhundredLines() {
        for (int i=0; i<99; i++){
            System.out.println();
        }
    }

    private void init(){
        int x, y;
        for (x=0; x<5; x++){
            for (y=0; y<5; y++){
                locationBoard[x][y] = '-';
                targetBoard[x][y] = '-';
            }
        }
    }

    private void shipLocation(Scanner user) {
        int i = 0;
        int x, y;
        System.out.println("\nPLAYER " + whichPlayer + ", ENTER YOUR SHIPS’ COORDINATES.");
        //do-while or while loops allow us to resume current iteration by modifying test variable value which is not possible in for loops.
        do {
            System.out.println("Enter ship " + (i + 1) + " location:");
            x = takeInput(user);
            y = takeInput(user);
            if (x>4 || y>4){  //check if entered input is more than 2d Array Limits.
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            //check if chosen row & col values are already assigned. If not, assign a ship at that position.
            if (locationBoard[x][y] == '@') {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    i = i - 1;
                } else locationBoard[x][y] = '@';
            i++;
        }while (i<5);
        printBattleShip(locationBoard);
        printhundredLines();
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

}