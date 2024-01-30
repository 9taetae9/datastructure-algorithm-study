import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Bomber {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */


    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        if(n == 1){
            return grid;
        }
        if(n%2 == 0){
            return fullBombGrid(grid.size(), grid.get(0).length());
        }

        List<String> detonatedGrid = detonateBombs(grid);
        if(n%4 == 3){
            return detonatedGrid;
        }else{
            return detonateBombs(detonatedGrid);
        }
    }

    private static List<String> detonateBombs(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] newGrid = new char[rows][cols];

        for(int i=0; i<rows; i++){
            Arrays.fill(newGrid[i], 'O');
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid.get(i).charAt(j) == 'O'){
                    newGrid[i][j] = '.';


                    //up
                    if(i>0) newGrid[i-1][j] = '.';
                    //down
                    if(i<rows-1) newGrid[i+1][j] = '.';
                    //right
                    if(j<cols-1) newGrid[i][j+1] = '.';
                    //left
                    if(j>0) newGrid[i][j-1] = '.';
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(char[] row : newGrid){
            result.add(new String(row));
        }
        return result;
    }

    private static List<String> fullBombGrid(int rows, int cols) {
        String row = String.join("", Collections.nCopies(cols,"O"));
        // java 11 => row = "O".repeat(cols);
        return Collections.nCopies(rows,row); //ncopies returns imutable list
    }



}

public class Bomberman {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<String> result = Bomber.bomberMan(n, grid);

        // Printing the result to the console
        result.forEach(System.out::println);

        bufferedReader.close();
    }
}

