import java.util.*;

public class TicTacToe {
        char board[][]=new char[3][3];
        //Display the board
        public static void display(char board[][]){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(board[i][j]+"  ");
                }System.out.println(" ");
            }
        }
        //replace function
        static void replace(char arr[][], char find, char replace) {
            for (int i = 0; i < 3 ; i++) 
         {
          for(int j=0 ; j < 3 ; j++)
          {
           if (arr[i][j] == find) 
           {
            arr[i][j] = replace;
            return;
           }
                }
            }
        }
        //check for wins
        public boolean checkForWin() {
            return (checkForRow() || checkForColomn() || checkForDiagnol());
           }
           
            //This function check row, colomn, diagnol for checkForRow, checForDiagnol, checkForColomn function
           public boolean check(char c1,char c2, char c3)
           {
            return((c1==c2) && (c2==c3));
           }
           //check for row function
           public boolean checkForRow() {
            for(int i=0; i<3; i++)
            {
             if(check(board[i][0],board[i][1],board[i][2])==true)
              return true;
            }
            return false;
           }
           //check for colomn function
           public boolean checkForColomn() {
            for(int i=0; i<3; i++)
            {
             if(check(board[0][i],board[1][i],board[2][0])==true)
              return true;
            }
            return false;
           }
           //check for Diagnol function
           public boolean checkForDiagnol()
           {
            return((check(board[0][0],board[1][1],board[2][2])==true) || (check(board[0][2],board[1][1],board[2][0])==true));
           }
           public static void main(String []args){
            TicTacToe play=new TicTacToe();
            Scanner inp=new Scanner(System.in);
            int count=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    play.board[i][j]=Character.forDigit(count++,10);
                    
                }
            }
            display(play.board);
            //players name
            System.out.print("Enter player1 name:");
            String player1=inp.nextLine();
            System.out.print("Enter player2 name:");
            String player2=inp.nextLine();
            //player choose the marker
            char player1marker,player2marker;
            System.out.println(player1+" Select Your Marker (O or X): ");
            player1marker=inp.next().charAt(0);
            if(player1marker=='X' || player1marker=='x'){
                    player2marker='O';
            }
            else{player2marker='X';}
            char input;
            int cnt=0;
            for(int i=0;i<4;i++){
                System.out.print(player1+" Turn: ");
                input=inp.next().charAt(0);
                replace(play.board,input,player1marker);
                display(play.board);
                if(play.checkForWin()){
                    System.out.println("X wins");
                    break;
                }
                System.out.print(player2+" Turn: ");
                input=inp.next().charAt(0);
                replace(play.board,input,player2marker);
                display(play.board);
                if(play.checkForWin()){
                    System.out.println("O wins");
                       
                       break;
                   }
                cnt++;
             }
             if(cnt==4){
            System.out.print(player1+"Turn: ");
            input=inp.next().charAt(0);
            replace(play.board,input,player1marker);
             display(play.board);
             if(play.checkForWin()){
                System.out.print("We have a Winner");
             }
             else{
                System.out.print("Match is Draw");
            }
        }
    }

    
}
