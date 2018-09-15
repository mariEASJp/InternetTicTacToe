package sovsen;

import java.sql.SQLOutput;

public class Board {

    private static int[][] grid = new int[3][3];
    private static int player = 0;

    public Board(){
        for (int[] c : grid) {
            for (int j : c){
                c[j] = 0;
            }
        }
    }

    private static void setPlayer(int player1){
        System.out.println("Set the next player");
        player = player1;
    }



    public static String processInput(String input){
        String OUTPUT = "";
        System.out.println("ProccessInput()");
        if (validMove(getField(input)) == true){
            setMark(player, getField(input));
            System.out.println("teset1");
        } else {
            System.out.println("test2");
            OUTPUT = "Field occupied. Please select another location.";
        }


        if (checkWin() == true){
            showWin();
            return "Congratulations!";
        } else {
            System.out.println("No winners yet");
            if (player == 1) {
                setPlayer(2);
                OUTPUT = "O's turn;";
            } else {
                setPlayer(1);
                OUTPUT = "X's turn";
            }
        }

        System.out.println("End of ProcessInput()");

        return OUTPUT;
    }



   public static String showWin(){
        return "Player " + player + " won!";
   }



    private static int[] getField(String str){
        int[] temp = new int[2];
        System.out.println("getGrid()");
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
                System.out.println("Nothing matches");
        }

        System.out.println("Return");
        return temp;
    }

    private static boolean validMove(int[] i){
        System.out.println("validMove()");
        if(grid[i[0]][i[1]] == 0){
            System.out.println("It's true");
            return true;
        }
        System.out.println("It's false");
        return false;
    }


    private static void setMark(int mark, int[] i){
        System.out.println("SetMark()");
        grid[i[0]][i[1]] = mark;
    }


    public static String viewBoard(){


        StringBuilder out = new StringBuilder();


        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){

                out.append("|");

                if (grid[i][j] == 0) {
                    out.append(" \t");
                } else if (grid[i][j] == 1){
                    out.append("X\t");
                } else if (grid[i][j]  == 2){
                    out.append("O\t");
                }

            }

            out.append("|");
            out.append("\n");
        }


        return out.toString();
    }



    private static boolean checkWin(){
        System.out.println("CheckWin()");



        for (int i = 0; i < 2; i++){

            System.out.println("Loop #" + i);
            if (checkH(0,i) || checkV(i,0) || checkCr()){
                return true;
            }

        }
        return false;
    }


    private static boolean checkH(int i1, int i2){
        System.out.println("checkH");
        if (grid[i1][i2] != 0){
            System.out.println("Not 0");
            if ((grid[i1][i2] == grid[i1][i2 + 1]) && (grid[i1][i2] == grid[i1][i2 + 2])){
                System.out.println("Horizontal win");
                return true;
            }
        }

        return false;
    }

    private static boolean checkV(int i1, int i2){
        System.out.println("CheckV");
        if (grid[i1][i2] != 0) {
            System.out.println("Not 0");
            if ((grid[i1][i2] == grid[i1 + 1][i2]) && (grid[i1][i2] == grid[i1 + 2][i2])) {
                System.out.println("Vertical win");
                return true;
            }
        }
        return false;
    }

    private static boolean checkCr(){
        System.out.println("CheckCr");
        int topleft = grid[0][0];
        System.out.println(topleft);
        int mid = grid[1][1];
        System.out.println(mid);
        int topright = grid[0][1];
        System.out.println(topright);
        int botleft = grid[2][0];
        System.out.println(botleft);
        int botright = grid[2][2];
        System.out.println(botright);

        System.out.println("Start of check");
        if (mid != 0) {
            System.out.println("Mid is not 0");
            if (((mid == topleft) && (mid == topright)) || ((mid == botleft) && (mid == botright))) {
                System.out.println("There's a win across");
                return true;
            }
        }
        System.out.println("End of checkCR");
        return false;
    }

}
