package grid;

import java.util.LinkedList;

/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

public class Square {
    private int number = -1;
    private boolean initial = false;

    Square(){

    }

    Square(int number){
        if (number >= 0 && number <= 9){
            initial = true;
            this.number = number;
        }
    }

    public int getNumber() {
        return number;
    }

    public String toString(){
        if (number == -1) return " ";
        else return String.valueOf(number);
    }

    public boolean setNumber(int number) {
        if (number >= -1 && number <= 9){
            this.number = number;
            return true;
        } else return false;
    }

    public boolean isInitial() {
        return initial;
    }
}
