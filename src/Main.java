import grid.Grid;

import java.util.LinkedList;

/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

public class Main {
    public static void main(String[] args) {
        Grid g = new Grid();
        g.addGrid(new int[][]{
                {-1, 3, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 1, 9, 5, -1, -1, -1},
                {-1, -1, 8, -1, -1, -1, -1, 6, -1},
                {8, -1, -1, -1, 6, -1, -1, -1, -1},
                {4, -1, -1, 8, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, 2, -1, -1, -1, -1},
                {-1, 6, -1, -1, -1, -1, 2, 8, -1},
                {-1, -1, -1, 4, 1, 8, -1, -1, 5},
                {-1, -1, -1, -1, -1, -1, -1, 7, -1}
        });
        g.printGrid();
    }
}
