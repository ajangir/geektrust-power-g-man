import java.util.List;
import java.util.ArrayList;

public class Direction {
    public static final int NONE = -1;
    private int direction;

    public Direction() {
        direction = NONE;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(String value) {
        
        if (value.equals("N")) {
            direction = 0;
        } 
        else if (value.equals("E")) {
            direction = 1;
        } 
        else if (value.equals("S")) {
            direction = 2;
        } 
        else if (value.equals("W")) {
            direction = 3;
        } 
        else {
            throw new IllegalArgumentException("Invalid Direction: " + value);
        }
    }

    public void setDirection(int value) {
        if (value >= 0 && value <= 3) {
            direction = value;
        } 
        else {
            throw new IllegalArgumentException("Invalid Direction: " + value);
        }
    }

    public List<Integer> getTurns(int dx, int dy) 
    {
        List<Integer> toTurns = new ArrayList<>();
        
        if (isPositive(dx)) {
            toTurns.add(1);
        } 
        else if (isNegative(dx)) {
            toTurns.add(3);
        }
        
        if (isPositive(dy)) {
            toTurns.add(0);
        } 
        else if (isNegative(dy)) {
            toTurns.add(2);
        }
        
        return toTurns;
    }

    public int turnsTaken(List<Integer> changes) {
        int start = direction;
        int count = 0;
        final int MAX_LEN = 4;

        for (int i : changes) {
            count += Math.min((i - start + MAX_LEN) % MAX_LEN, (start - i + MAX_LEN) % MAX_LEN);
            start = i;
        }
        return count;
    }

    public int calcTurns(int dx, int dy) {
        List<Integer> turns = getTurns(dx, dy);

        int ans = Math.min(turnsTaken(turns), turnsTaken(reverseList(turns)));

        return ans;
    }

    private boolean isPositive(int number) {
        return number > 0;
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    private List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>(list);
        java.util.Collections.reverse(reversed);
        return reversed;
    }
}
