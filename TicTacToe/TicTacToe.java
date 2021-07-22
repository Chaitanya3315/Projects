package TicTacToe;

import java.util.*;
public class TicTacToe {
    protected static String board[][];
    protected static String turn;
    static boolean winner;

    public static void setUpGame(){
        int count=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=count+"";
                count++;
            }
        }
    }
  
    public static void printGame(){
        System.out.println("----------------------");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print( "|| "+board[i][j]+ " ||");   
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }
    public static void move(int move){
        switch(move){
            case 1 :
               board[0][0]=turn;
               break;
            case 2 :
               board[0][1]=turn;
               break;
            case 3 :
               board[0][2]=turn;
               break;
             case 4 :
               board[1][0]=turn;
               break;
            case 5 :
               board[1][1]=turn;
               break;
            case 6 :
               board[1][2]=turn;
               break;
            case 7:
               board[2][0]=turn;
               break;
            case 8:
               board[2][1]=turn;
               break;
            case 9 :
               board[2][2]=turn;
               break;
            default :
             System.out.println("Invalid");
        }
    }
    
    
    public String checkWin(){
        for(int i=0;i<8;i++){
            String line=null;
            switch(i){
                case 0 :
                   line = board[0][0] + board[0][1] + board[0][2];
                   break;
                case 1 :
                   line = board[1][0] + board[1][1] + board[1][2];
                   break;
                case 2 :
                   line = board[2][0] + board[2][1] + board[2][2];
                   break;
                case 3 :
                   line = board[0][0] + board[1][0] + board[2][0];
                   break;
                case 4 :
                   line = board[0][1] + board[1][1] + board[2][1];
                   break;
                case 5 :
                   line = board[0][2] + board[1][2] + board[2][2];
                   break;
                case 6 :
                   line = board[0][0] + board[1][1] + board[2][2];
                   break;
                case 7 :
                   line = board[0][2] + board[1][1] + board[2][0];
                   break;
            }
            if (line.equals("XXX")){
                winner = true;
                return "X";
            }else if(line.equals("OOO")){
                winner = true;
                return "O";
            }
        }
        return null;
    }
     
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<Integer>();
        board = new String[3][3];
        setUpGame();
        System.out.println("Game Started");
        System.out.println("Enter the player you wanna play X or O");
        turn =sc.next();
        System.out.println(turn);
        printGame();
        int movCount=0;
         while(!winner){
             System.out.println(turn);
             int move =sc.nextInt();
             if(move>9 || move<=0){
                 System.out.println("invalid input");
                 continue;
             }
             if(!set.contains(move)){
                 set.add(move);
                 movCount++;
             }else{
                 System.out.println("Invalid input");
                 continue;
             }
             if(turn.equals("X")){
                 move(move);
                 turn="O";
             }else if (turn.equals("O")){
                 move(move);
                 turn="X";
             }
             String ans= game.checkWin();
             if(winner){
                System.out.println(ans);
                printGame();
                System.out.println(ans + " WON!!");
                break;
             }else if (movCount==9){
                 System.out.println("Draw");
                 break;
             }
         printGame();
        }

    }
}
