package TicTacToe;

import java.util.*;
public class TicTacToe { 
    static boolean winner;
    static char human='O';
    static char ai='X';
    static class Move {
        int row,col;
    }
    static boolean isMovesLeft(char[][] board){
    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (board[i][j]=='_'){
                return true;
            }
        }
    }
    return false;
}
    public static int evaluate(char[][] board){
        for (int i = 0; i < 3; i++)
    {
        if (board[i][0]==board[i][1] &&board[i][1]==board[i][2])
        {
            if (board[i][0]=='X')
                return +10;
            else if (board[i][0]=='O')
                return -10;
        }
    }

    // Checking for Columns for X or O victory.
    for (int j = 0; j < 3; j++)
    {
        if (board[0][j]==board[1][j] && board[1][j]==board[2][j])
        {
            if (board[0][j]=='X')
                return +10;
 
            else if (board[0][j]=='O')
                return -10;
        }
    }
 
    // Checking for Diagonals for X or O victory.
    if (board[0][0]==board[1][1] && board[1][1]==board[2][2])
    {
        if (board[0][0]=='X')
            return +10;
        else if (board[0][0]=='O')
            return -10;
    }
 
    if (board[0][2]==board[1][1] && board[1][1]==board[2][0])
    {
        if (board[0][2]=='X')
            return +10;
        else if (board[0][2]=='O')
            return -10;
    }
 
    // Else if none of them have won then return 0
    return 0;
    }

    public static void setUpGame(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='_';
            }
        }
    }
    public static Move bestMove(char[][] board){
    int bestVal = -1000;
    Move bestMove = new Move();
    bestMove.row = -1;
    bestMove.col = -1;
 
    
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
           
            if (board[i][j]=='_')
            {
               
                board[i][j] = 'X';
 
                int moveVal = minimax(board, 0, false);
 
                board[i][j] = '_';
                if (moveVal > bestVal)
                {
                    bestMove.row = i;
                    bestMove.col = j;
                    bestVal = moveVal;
                }
            }
        }
    }
    return bestMove;
}
    
    public static int minimax(char[][] board,int depth,boolean isMax){
        int score = evaluate(board);
 
    
    if (score == 10)
        return score;
 
    
    if (score == -10)
        return score;
 
    
    if (isMovesLeft(board) == false)
        return 0;
 
    // If this maximizer's move
    if (isMax)
    {
        int best = -1000;
 

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                
                if (board[i][j]=='_')
                {
                    
                    board[i][j] = 'X';
                    best = Math.max(best, minimax(board,depth + 1, !isMax));
                    board[i][j] ='_';
                }
            }
        }
        return best;
    }
 
    // If this minimizer's move
    else
    {
        int best = 1000;
 
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
               
                if (board[i][j]=='_')
                {
                    
                    board[i][j] = 'O';
                    best = Math.min(best, minimax(board,depth + 1, !isMax));
                    board[i][j] = '_';
                }
            }
        }
        return best;
    }
    }
  
    public static void printGame(char[][] board){
        System.out.println("----------------------");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print( "|| "+board[i][j]+ " ||");   
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }
    public static void move(char[][] board,int move){
        switch(move){
            case 1:
             board[0][0]='O';
             break;
            case 2:
             board[0][1]='O';
             break;
            case 3:
             board[0][2]='O';
             break;
            case 4:
             board[1][0]='O';
             break;
            case 5:
             board[1][1]='O';
             break;
            case 6:
             board[1][2]='O';
             break;
            case 7:
             board[2][0]='O';
             break;
            case 8:
             board[2][1]='O';
             break;
            case 9:
             board[2][2]='O';
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
    public char checkWin(char[][] board){
        for(int i=0;i<8;i++){
            ArrayList<Character> line = new ArrayList<Character>();
            switch (i) {
                case 0:
                    line.add(board[0][0]);
                    line.add(board[0][1]);
                    line.add(board[0][2]);
                    break;
                case 1:
                    line.add(board[1][0]);
                    line.add(board[1][1]);
                    line.add(board[1][2]);
                    break;
                case 2:
                    line.add(board[2][0]);
                    line.add(board[2][1]);
                    line.add(board[2][2]);
                    break;
                case 3:
                    line.add(board[0][0]);
                    line.add(board[1][0]);
                    line.add(board[2][0]);
                    break;
                case 4:
                    line.add(board[0][1]);
                    line.add(board[1][1]);
                    line.add(board[2][1]);
                    break;
                case 5:
                    line.add(board[0][2]);
                    line.add(board[1][2]);
                    line.add(board[2][2]);
                    break;
                case 6:
                    line.add(board[0][0]);
                    line.add(board[1][1]);
                    line.add(board[2][2]);
                    break;
                case 7:
                    line.add(board[0][2]);
                    line.add(board[1][1]);
                    line.add(board[2][0]);
                    break;
                }
                if(line.get(0)=='X' && line.get(1)=='X'&& line.get(2)=='X' ){
                    winner=true;
                    return 'X';
                }
              
            // For O winner
            else if(line.get(0)=='O' && line.get(1)=='O'&& line.get(2)=='O' ){
                winner=true;
                return 'O';
            }
        }
        if(board[0][0]!='_' && board[0][1]!='_' && board[0][2]!='_' && board[1][0]!='_' && board[1][1]!='_' && board[1][2]!='_' && board[2][0]!='_' && board[2][1]!='_' && board[2][2]!='_'){
            winner =true;
            return 'D';
        }
        return '0';
    }
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<Integer>();
        char board[][] = {{ '-', '-', '-' },
                      { '-', '-', '-' },
                      { '-', '-', '-'}};
        
        int humanMove=0;
        int count=0;
        setUpGame(board);
        System.out.println("Game Started");
        printGame(board);
         while(!winner){
             Move aiMove=bestMove(board);
             board[aiMove.row][aiMove.col]='X';
             printGame(board);
             set.add(setAiMove(aiMove.row,aiMove.col));
             char ans2=game.checkWin(board);
             if(winner && ans2!='D'){
                 System.out.println("Game Over " +ans2);
                 break;
             }else if(ans2=='D'){
                System.out.println("DRAW GAME WELL PLAYED");
                break;
             }
             humanMove=sc.nextInt();
             while(set.contains(humanMove)){
                humanMove=sc.nextInt();
                System.out.println("Invalid Input");
             }
             if(!set.contains(humanMove)){
                 move(board,humanMove);
                 set.add(humanMove);
             }
             printGame(board);
             char ans=game.checkWin(board);
             if(winner && ans!='D'){
                 System.out.println("Game Over " +ans);
                 break;
             }else if(ans2=='D'){
                System.out.println("DRAW GAME WELL PLAYED");
                break;
             }
             printGame(board);
        }
    }
}