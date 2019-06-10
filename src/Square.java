import java.util.LinkedList;

/**
 * created by Jona Wessendorf
 * on 04.06.2019
 */

public class Square {
    private int number = 0;
    private boolean initial = false;
    private LinkedList<Integer> possibilities = new LinkedList<>();

    Square(){

    }

    Square(int number){
        if (number >= 1 && number <= 9){
            initial = true;
            this.number = number;
        }
    }

    public void addPossibility(int num){
        if (!possibilities.contains(num))possibilities.add(num);

    }

    public LinkedList<Integer> getPossibilities() {
        return possibilities;
    }
    
    public boolean hasNumber(){
        return number != 0;
    }

    public void removePossibilities(){
        possibilities = new LinkedList<>();
    }

    public int numberOfPossibilities(){
        return possibilities.size();
    }

    public int getNumber() {
        return number;
    }

    public String toString(){
        if (initial) return "  "+number+"  ";
        else{
            if (number == 0) return " [ ] ";
            else return " ["+number+"] ";
        }
    }

    public boolean setNumber(int number) {
        if (number >= 0 && number <= 9){
            this.number = number;
            return true;
        } else return false;
    }

    public boolean isInitial() {
        return initial;
    }

    public Square clone(){
        Square newSquare;
        if (initial){
            newSquare = new Square(number);
            for (int i: possibilities){
                newSquare.addPossibility(i);
            }
        } else {
            newSquare = new Square();
            newSquare.setNumber(number);
            for (int i: possibilities){
                newSquare.addPossibility(i);
            }
        }
        return newSquare;
    }
}
