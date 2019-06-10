/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

public class Main {
    public static void main(String[] args) {
        Grid g = new Grid();
        g.createNewGrid(72);
        
        /*g.createGrid(new int[][]{
                {0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 0, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 0},
                {4, 0, 0, 8, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 7, 0}
        });*/

        /*g.createGrid(new int[][]{
                {1, 3, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 9, 5, 1, 1, 1},
                {1, 1, 8, 1, 1, 1, 1, 6, 1},
                {8, 1, 1, 1, 6, 1, 1, 1, 1},
                {4, 1, 1, 8, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 2, 1, 1, 1, 1},
                {1, 6, 1, 1, 1, 1, 2, 8, 1},
                {1, 1, 1, 4, 1, 8, 1, 1, 5},
                {1, 1, 1, 1, 1, 1, 1, 7, 1}
    });*/
        
        Solver s = new Solver();
        long start = System.currentTimeMillis();
        s.solve(g);
        long end = System.currentTimeMillis();
    
        if (s.isSolved()){
            s.getSolvedGrid().printGrid();
            System.out.println("solved in: "+(end-start)+" ms");
        }
        else System.out.println("Sudoku is not solvable!");

        // 1. Version: ca. 85000 ms
        // 2. Version: ca. 85 ms

    }
}
