package TicTacToe;

import java.util.*;
public class TicTacToe {
   protected static String board[][]; 
    static boolean winner;
    static String human="O";
    static String ai="X";
    static class Move {
        int row,col;
    }
    static boolean isMovesLeft(){
    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (board[i][j].equals("-")){
                return true;
            }
        }
    }
    return false;
}
    public static int evaluate(){
        for (int i = 0; i < 3; i++)
    {
        if (board[i][0].equals(board[i][1]) &&board[i][1].equals(board[i][2]))
        {
            if (board[i][0].equals("X"))
                return +10;
            else if (board[i][0].equals("O"))
                return -10;
        }
    }

    // Checking for Columns for X or O victory.
    for (int j = 0; j < 3; j++)
    {
        if (board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]))
        {
            if (board[0][j].equals("X"))
                return +10;
 
            else if (board[0][j].equals("O"))
                return -10;
        }
    }
 
    // Checking for Diagonals for X or O victory.
    if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
    {
        if (board[0][0].equals("X"))
            return +10;
        else if (board[0][0].equals("O"))
            return -10;
    }
 
    if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
    {
        if (board[0][2].equals("X"))
            return +10;
        else if (board[0][2].equals("O"))
            return -10;
    }
 
    // Else if none of them have won then return 0
    return 0;
    }

    public static void setUpGame(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]="-";
            }
        }
    }
    public static Move bestMove(){
        Move bestMove=new Move();
        bestMove.row=-1;
        bestMove.col=-1;
        int bestScore=-1000;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].equals("-")){
                    board[i][j]="X";
                    int score = minimax(false,0);
                    board[i][j]="-";
                    if(score>bestScore){
                        bestScore=score;
                        bestMove.row=i;
                        bestMove.col=j;
                    }
                }
            }
        }
        return bestMove;
    }
    
    public static int minimax(boolean isMax,int depth){
        int score=evaluate();
        if(score==10){
            return score;
        }
        if(score==-10){
            return score;
        }
        if(score==0){
            return 0;
        }
        if(isMax){
            int bestScore=-1000;;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j].equals("-")){
                        board[i][j]="X";
                        bestScore=Math.max(bestScore,minimax(!isMax,depth+1));
                        board[i][j]="-";
                    }
                }
            }
            return bestScore;
        }else if(!isMax){
            int bestScore=+1000;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j].equals("-")){
                        board[i][j]="O";
                        bestScore=Math.min(bestScore,minimax(!isMax,depth+1));
                        board[i][j]="-";
                    }
                }
            }
            return bestScore;
        }
        return 0;
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
            case 1:
             board[0][0]="O";
             break;
            case 2:
             board[0][1]="O";
             break;
            case 3:
             board[0][2]="O";
             break;
            case 4:
             board[1][0]="O";
             break;
            case 5:
             board[1][1]="O";
             break;
            case 6:
             board[1][2]="O";
             break;
            case 7:
             board[2][0]="O";
             break;
            case 8:
             board[2][1]="O";
             break;
            case 9:
             board[2][2]="O";
             break;
        }
    }
    public static int setAiMove(int row,int col){
        int move=0;
        if(row==0 && col==0){
            move=1;
        }else if(row==0 && col==1){
            move=2;
        }else if(row==0 && col==2){
            move=3;
        }else if(row==1 && col==0){
            move=4;
        }else if(row==1 && col==1){
            move=5;
        }else if(row==1 && col==2){
            move=6;
        }else if(row==2 && col==0){
            move=7;
        }else if(row==2 && col==1){
            move=8;
        }else if(row==2 && col==2){
            move=9;
        }
        return move;
    }
    public String checkWin(){
        for(int i=0;i<8;i++){
            String line=null;
            switch (i) {
                case 0:
                    line = board[0][0]+board[0][1]+board[0][2];
                    break;
                case 1:
                    line=board[1][0]+board[1][1]+board[1][2];
                    break;
                case 2:
                    line=board[2][0]+board[2][1]+board[2][2];
                    break;
                case 3:
                    line=board[0][0]+board[1][0]+board[2][0];
                    break;
                case 4:
                    line=board[0][1]+board[1][1]+board[2][1];
                    break;
                case 5:
                    line=board[0][2]+board[1][2]+board[2][2];
                    break;
                case 6:
                    line=board[0][0]+board[1][1]+board[2][2];
                    break;
                case 7:
                    line = board[0][2]+board[1][1]+board[2][0];
                }
            
            if (line.equals("XXX")){
                winner=true;
                return "X";
            }
              
            // For O winner
            else if (line.equals("OOO")){
                winner=true;
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
        int humanMove=0;
        setUpGame();
        System.out.println("Game Started");
        printGame();
         while(!winner){
             Move aiMove=bestMove();
             System.out.println(aiMove.row);
             System.out.println(aiMove.col);
             board[aiMove.row][aiMove.col]="X";
             printGame();
             set.add(setAiMove(aiMove.row,aiMove.col));
             String ans2=game.checkWin();
             if(winner){
                 System.out.println("Game Over " +ans2);
                 break;
             }
             humanMove=sc.nextInt();
             while(set.contains(humanMove)){
                humanMove=sc.nextInt();
                System.out.println("Invalid Input");
             }
             if(!set.contains(humanMove)){
                 move(humanMove);
                 set.add(humanMove);
             }
             printGame();
             String ans=game.checkWin();
             if(winner){
                 System.out.println("Game Over " +ans);
                 break;
             }
             printGame();
        }
    }
}