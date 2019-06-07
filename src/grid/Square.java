package grid;

import java.util.LinkedList;

/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

public class Square {
    private int number;
    private LinkedList<Integer> possibilities;

    Square(){

    }

    Square(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
