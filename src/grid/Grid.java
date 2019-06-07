/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

package grid;

public class Grid {
    private int heigth = 9;
    private int width = 9;
    private Square[][] grid;

    public Grid(){}

    public void createGrid() {
        grid = new Square[heigth][width];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = new Square(row);
            }
        }
    }

    public void printGrid(){
        String output = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                output = output + " ["+ grid[i][j].getNumber()+"] ";
            }
            output = output + "\n\n";
        }
        System.out.println(output);
    }
}
