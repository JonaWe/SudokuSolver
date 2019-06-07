import grid.Grid;


/**
 * created by Jona Wessendorf
 * on 07.06.2019
 */

public class Solver {
    Grid solved;

    public boolean solve(Grid grid){
        int row = 0;
        int col = 0;

        while (grid.isInitial(row, col)){
            if (col < 8) col++;
            else {
                col = 0;
                if (row < 8) row++;
                else return true;
            }
        }
        return solve(row, col, grid.clone());
    }

    private boolean solve(int row, int col, Grid grid){
        for (int number: grid.getPossibilities(row, col)) {
            if (grid.isPossible(row, col, number)){
                Grid ng = grid.clone();
                ng.set(row, col, number);
                int r = row;
                int c = col;
                do {
                    if (c < 8) c += 1;
                    else {
                        c = 0;
                        if (r < 8) r += 1;
                        else{
                            solved = ng;
                            return true;
                        }
                    }
                } while (grid.isInitial(r, c));
                System.out.println("row: "+row+" col: "+col+" number: "+number);
                if (solve(r, c, ng)) return true;
            }
        }
        return false;
    }

    public Grid getSolved() {
        return solved;
    }

    public boolean isCorrect(){
        return true;
    }
}
