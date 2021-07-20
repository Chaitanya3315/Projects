package TicTacToe;
import java.util.*;
public class TicTacToe {
    
    public void printGame(char[][] arr){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print( "|| "+arr[i][j]+ " ||");
            }
            System.out.println();
        }
    }
    public void move(char[][] arr,int c,char move){
        switch(c){
            case 1 :
               arr[0][0]=move;
               break;

            case 2 :
               arr[0][1]=move;
               break;
            case 3 :
               arr[0][2]=move;
               break;
             case 4 :
               arr[1][0]=move;
               break;
            case 5 :
               arr[1][1]=move;
               break;
            case 6 :
               arr[1][2]=move;
               break;
            case 7:
               arr[2][0]=move;
               break;
            case 8:
               arr[2][1]=move;
               break;
            case 9 :
               arr[2][2]=move;
               break;
            default :
             System.out.println("Invalid");
            
        }
    }
    public boolean checkWin(char[][] arr){
        for(int i=0;i<3;i++){
            
            if(arr[i][0]=='X'&& arr[i][1]=='X' && arr[i][2]=='X'){
                System.out.println("X -WON!");
                return true;
            }else if(arr[0][i]=='X'&& arr[1][i]=='X' && arr[2][i]=='X'){
                System.out.println("X -WON!");
                return true;
            }
            if(arr[i][0]=='O'&& arr[i][1]=='O' && arr[i][2]=='O'){
                System.out.println("O -WON!");
                return true;
            }else if(arr[0][i]=='O'&& arr[1][i]=='O' && arr[2][i]=='O'){
                System.out.println("O -WON!");
                return true;
            } 
        }
        if(arr[0][0]=='O'&& arr[1][1]=='O' && arr[2][2]=='O'){
            System.out.println("O -WON!");
            return true;
        }else if(arr[2][0]=='O'&& arr[1][1]=='O' && arr[0][2]=='O'){
            System.out.println("O -WON!");
            return true;
        }
        if(arr[0][0]=='X'&& arr[1][1]=='X' && arr[2][2]=='X'){
            System.out.println("X -WON!");
            return true;
        }else if(arr[2][0]=='X'&& arr[1][1]=='X' && arr[0][2]=='X'){
            System.out.println("X -WON!");
            return true;
        }
        return false;
    }
     
    public static void main(String[] args){
        char[][] arr = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<Integer>();
        int m=0;
        game.printGame(arr);
        while(m!=9){
            int p =sc.nextInt();
            if(set.contains(p)){
                System.out.println("invalid move");
            }else{
                char c;
                m++;
            if(m%2==0){
                c= 'X';
            }else{
                c='O';
            }
            game.move(arr, p, c);
            if(game.checkWin(arr)){
                m=9;
            }else if(!game.checkWin(arr) && m==9){
                System.out.println("Draw");
            }
            game.printGame(arr);
            set.add(p);
            
            }
        }
        sc.close();
    }
}
