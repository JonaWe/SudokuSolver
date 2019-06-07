/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

package grid;

import java.util.LinkedList;

public class Grid {
    private int heigth = 9;
    private int width = 9;
    private Square[][] grid;

    public Grid(){}

    private Grid(Square[][] grid){
        this.grid = grid;
    }

    public void createGrid() {
        grid = new Square[heigth][width];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = new Square();
            }
        }
    }

    public void createGrid(int[][] addArray){
        grid = new Square[heigth][width];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = new Square(addArray[row][col]);
            }
        }

        addPossibilities();
    }

    public void printGrid(){
        String output = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                output = output + " ["+ grid[i][j].toString()+"] ";
            }
            output = output + "\n\n";
        }
        System.out.println(output);
    }

    private void addPossibilities(){
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (!grid[r][c].isInitial()){
                    for (int num = 1; num < 10; num++) {
                        if (isPossible(r, c, num)) grid[r][c].addPossibility(num);
                    }
                }
            }
        }
    }

    public boolean isPossible(int row, int col, int number){
        //if (grid[row][col].isInitial()) return false;

        // row
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col].getNumber() == number) return false;
        }

        // col
        for (int i = 0; i < grid[row].length; i++) {
            if (grid[row][i].getNumber() == number) return false;
        }

        // square
        int r = row - row%3;
        int c = col - col%3;

        for (int offsetR = 0; offsetR < 3; offsetR++) {
            for (int offsetC = 0; offsetC < 3; offsetC++) {
                if (grid[r+offsetR][c+offsetC].getNumber() == number) return false;
            }
        }

        // everything is checked
        return true;
    }

    public Grid clone(){
        Square[][] newGrid = new Square[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                newGrid[row][col] = grid[row][col].clone();
            }
        }

        return new Grid(newGrid);
    }

    public void set(int row, int column, int number){
        grid[row][column].setNumber(number);
    }

    public boolean isInitial(int row, int column){
        return grid[row][column].isInitial();
    }

    public LinkedList<Integer> getPossibilities(int row, int col) {
        return grid[row][col].getPossibilities();
    }
}
