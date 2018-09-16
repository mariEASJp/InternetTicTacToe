package sovsen;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static List<ServerThread> observers = new ArrayList<ServerThread>();

    private static final int NO_PLAYER = 0;
    private static final int PLAYER_X = 1;
    private static final int PLAYER_O = 2;
    private static final int GAME_END = 3;

    private static int state = 0;
    private static int[][] grid = new int[3][3];
    private static int player = 0;
    private static int winner = 0;

    public static void processInput(String input){
        String OUTPUT = "";
        System.out.println("processInput()");

        if (validMove(getField(input)) == true){
            setMark(player, getField(input));


            if (checkWin() == true){
                showWin();
                OUTPUT = "Congratulations!";
            } else {

                if (player == PLAYER_X) {
                    setPlayer(PLAYER_O);
                    OUTPUT = "O's turn;";
                } else if ((player == PLAYER_O) || (state == NO_PLAYER)){
                    setPlayer(PLAYER_X);
                    OUTPUT = "X's turn";
                } else if (state == GAME_END) {
                    if (winner == PLAYER_X){
                        OUTPUT = "Player X has won";
                    } else if (winner == PLAYER_O){
                        OUTPUT = "Player O has won";
                    }
                }
            }


        } else {

            OUTPUT = "Field occupied. Please select another location.";
        }


        notifyAllObservers();

    }



   public static String showWin(){
        return "Player " + player + " won!";
   }



    private static int[] getField(String str){
        int[] temp = new int[2];


        switch(str){
            case "1":
                temp[0] = 0;
                temp[1] = 0;
                break;
            case "2":
                temp[0] = 0;
                temp[1] = 1;
                break;
            case "3":
                temp[0] = 0;
                temp[1] = 2;
                break;
            case "4":
                temp[0] = 1;
                temp[1] = 0;
                break;
            case "5":
                temp[0] = 1;
                temp[1] = 1;
                break;
            case "6":
                temp[0] = 1;
                temp[1] = 2;
                break;
            case "7":
                temp[0] = 2;
                temp[1] = 0;
                break;
            case "8":
                temp[0] = 2;
                temp[1] = 1;
                break;
            case "9":
                temp[0] = 2;
                temp[1] = 2;
                break;
            default:
                return null;
        }
        return temp;
    }

    private static boolean validMove(int[] i){

        if(grid[i[0]][i[1]] == 0){

            return true;
        }

        return false;
    }


    private static void setMark(int mark, int[] i){
        grid[i[0]][i[1]] = mark;
    }


    public static String viewBoard(){


        StringBuilder out = new StringBuilder();

            out.append("BOARD~");

            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid.length; j++){

                    out.append("|");

                    if (grid[i][j] == 0) {
                        out.append(" ");
                    } else if (grid[i][j] == 1){
                        out.append("X");
                    } else if (grid[i][j]  == 2){
                        out.append("O");
                    }

                }

                out.append("|");
                out.append("~");
            }




        return out.toString();
    }


    private static boolean checkWin(){

        for (int i = 0; i < 2; i++){

            if (checkH(i,0) || checkV(0,1) || checkCr()){
                return true;
            }

        }
        return false;
    }


    private static boolean checkH(int i1, int i2){

        if (grid[i1][i2] != 0){

            if ((grid[i1][i2] == grid[i1][i2 + 1]) && (grid[i1][i2] == grid[i1][i2 + 2])){

                return true;
            }
        }

        return false;
    }

    private static boolean checkV(int i1, int i2){

        if (grid[i1][i2] != 0) {

            if ((grid[i1][i2] == grid[i1 + 1][i2]) && (grid[i1][i2] == grid[i1 + 2][i2])) {

                return true;
            }
        }
        return false;
    }

    private static boolean checkCr(){

        int topleft = grid[0][0];
       int mid = grid[1][1];
        int topright = grid[0][2];
        int botleft = grid[2][0];
        int botright = grid[2][2];

        if (mid != 0) {

            if (((mid == topleft) && (mid == botright)) || ((mid == botleft) && (mid == topright))) {

                 return true;
            }
        }

        return false;
    }


    public static void notifyAllObservers(){
        System.out.println("NotifyAllObservers()");

        for (ServerThread s : observers) {
            System.out.println("Notify all observers " + s.toString());
            s.update(viewBoard());
        }

    }

    public static void attach(ServerThread s){
        System.out.println("ATTACH---");
        observers.add(s);
    }






    public static int getObservers(){
        return observers.size();
    }


    private static void setPlayer(int player1){

        player = player1;
    }


}
