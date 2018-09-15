package sovsen;

public class Board {

    private static int[][] grid = new int[3][3];

    public Board(){
        for (int[] c : grid) {
            for (int j : c){
                c[j] = 0;
            }
        }
    }



    public static String processInput(String input){

            switch(input){
                case "0":


            }

        return "";
    }


    public void setMark(int mark, int arr1, int arr2){

        grid[arr1][arr2] = mark;
    }


    public String viewBoard(){


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
}
