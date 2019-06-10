import grid.Grid;


/**
 * created by Jona Wessendorf
 * on 07.06.2019
 */

public class Solver {
    private Grid solved;

    public boolean solve(Grid grid){
        int bestRow = -1;
        int bestCol = -1;
    
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (!grid.isInitial(r, c)){
                    if (bestCol == -1){
                        bestRow = r;
                        bestCol = c;
                    } else if(grid.numberOfPossibilities(bestRow, bestCol) > grid.numberOfPossibilities(r, c)){
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }
        }
    
        if (bestRow == -1){
            solved = grid;
            return true;
        }
        
        return solve(bestRow, bestCol, grid.clone());
    }

    private boolean solve(int row, int col, Grid grid){
        for (int number: grid.getPossibilities(row, col)) {
            if (grid.isPossible(row, col, number)){
                Grid ng = grid.clone();
                ng.set(row, col, number);
                ng.updatePossibilities();
    
                int bestRow = -1;
                int bestCol = -1;
    
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        if (!ng.hasNumber(r, c)){
                            if (bestCol == -1){
                                bestRow = r;
                                bestCol = c;
                            } else if(ng.numberOfPossibilities(bestRow, bestCol) > ng.numberOfPossibilities(r, c)){
                                bestRow = r;
                                bestCol = c;
                            }
                        }
                    }
                }
    
                if (bestRow == -1){
                    solved = ng;
                    return true;
                }
    
                if (solve(bestRow, bestCol, ng)) return true;
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
