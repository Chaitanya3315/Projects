package TicTacToe;

import java.util.*;
public class TicTacToe {
   protected static char board[][]; 
   protected static boolean table[][];
    protected static char turn;
    static boolean winner;
    static char human,ai;
    static class Move {
        int row,col;
    }
    public static int evaluate(){
        for (int row = 0; row < 3; row++)
    {
        if (board[row][0] == board[row][1] &&
            board[row][1] == board[row][2])
        {
            if (board[row][0] ==human)
                return +10;
            else if (board[row][0] == ai)
                return -10;
        }
    }

    // Checking for Columns for X or O victory.
    for (int col = 0; col < 3; col++)
    {
        if (board[0][col] == board[1][col] &&
            board[1][col] == board[2][col])
        {
            if (board[0][col] == human)
                return +10;
 
            else if (board[0][col] == ai)
                return -10;
        }
    }
 
    // Checking for Diagonals for X or O victory.
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
    {
        if (board[0][0] == human)
            return +10;
        else if (board[0][0] == ai)
            return -10;
    }
 
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
    {
        if (board[0][2] == human)
            return +10;
        else if (board[0][2] == ai)
            return -10;
    }
 
    // Else if none of them have won then return 0
    return 0;
    }

    public static void setUpGame(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='-';
            }
        }
    }
    public static void setUpTable(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                table[i][j]=false;
                
            }
        }
    }
    public static Move bestMove(){
        Move bestMove=new Move();
        bestMove.row=-1;
        bestMove.col=-1;
        int bestScore=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='-'){
                    board[i][j]=turn;
                    int score = minimax(false,0);
                    board[i][j]='-';
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
            int bestScore=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j]=='-'){
                        board[i][j]='X';
                        bestScore=Math.max(bestScore,minimax(!isMax,depth+1));
                        board[i][j]='-';
                    }
                }
            }
            return bestScore;
        }else if(!isMax){
            int bestScore=Integer.MAX_VALUE;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j]=='-'){
                        board[i][j]='O';
                        bestScore=Math.min(bestScore,minimax(!isMax,depth+1));
                        board[i][j]='-';
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
    public static void move(int row,int col){
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
        if(board[1][0]=='X' &&  board[1][1]=='X' && board[1][2]=='X'){
            winner = true;
            return "X";
          }
          if(board[1][0]=='O' &&  board[1][1]=='O' && board[1][2]=='O'){
            winner = true;
            return "O";
          }
          if(board[0][0]=='X' &&  board[0][1]=='X' && board[0][2]=='X'){
            winner = true;
            return "X";
          }
          if(board[0][0]=='O' &&  board[0][1]=='O' && board[0][2]=='O'){
            winner = true;
            return "X";
          }
          if(board[2][0]=='X' &&  board[2][1]=='X' && board[2][2]=='X'){
            winner = true;
            return "X";
          }
          if(board[2][0]=='O' &&  board[2][1]=='O' && board[2][2]=='O'){
            winner = true;
            return "O";
          }
          if(board[0][0]=='X' &&  board[1][0]=='X' && board[2][0]=='X'){
            winner = true;
            return "X";
          }
          if(board[0][0]=='O' &&  board[1][0]=='O' && board[2][0]=='O'){
            winner = true;
            return "O";
          }
          if(board[0][1]=='X' &&  board[1][1]=='X' && board[2][1]=='X'){
            winner = true;
            return "X";
          }
          if(board[0][1]=='O' &&  board[1][1]=='O' && board[2][1]=='O'){
            winner = true;
            return "O";
          }
          if(board[0][2]=='X' &&  board[1][2]=='X' && board[2][2]=='X'){
            winner = true;
            return "X";
          }
          if(board[0][2]=='O' &&  board[1][2]=='O' && board[2][2]=='O'){
            winner = true;
            return "O";
          }
          if(board[0][0]=='X' &&  board[1][1]=='X' && board[2][2]=='X'){
            winner = true;
            return "X";
          }
          if(board[0][0]=='O' &&  board[1][1]=='O' && board[2][2]=='O'){
            winner = true;
            return "O";
          }
          if(board[0][2]=='X' &&  board[1][1]=='X' && board[2][0]=='X'){
            winner = true;
            return "X";
          }
          if(board[0][2]=='O' &&  board[1][1]=='O' && board[2][0]=='O'){
            winner = true;
            return "O";
          }
          return null;
    }
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        int count=0;
        board = new char[3][3];
        table = new boolean[3][3];
        setUpGame();
        setUpTable();
        System.out.println("Game Started");
        System.out.println("Enter the player you wanna play X or O");
        turn =sc.next().charAt(0);
        if(turn=='X'){
            human='X';
            ai='O';
        }else{
            human='O';
            ai='X';
        }
        System.out.println(turn);
        printGame();
        int movCount=0;
         while(!winner){
             System.out.println(turn);
             if(turn==human){
                int row =sc.nextInt();
                int col =sc.nextInt();
                if(row>3 || row<0 || col>3 || col<0){
                    System.out.println("Invalid Input");
                    continue;
                }
                if(table[row][col]==false){
                 move(row,col);
                 count++;
                 table[row][col]=true;
                }else{
                    System.out.println("Invalid input");
                    continue;
                }
                 turn='O';
             }else if (turn==ai){
                 Move best=bestMove();
                 board[best.row][best.col]=ai;
                 count++;
                 table[best.row][best.col]=true;
                 turn='X';
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