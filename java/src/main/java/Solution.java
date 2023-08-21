public class Solution 
{
    private Point start;
    private Point end;
    private Direction startDirection;

    public Solution() {
        start = new Point();
        end = new Point();
        startDirection = new Direction();
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point value) {
        start = value;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point value) {
        end = value;
    }

    public Direction getStartDirection() {
        return startDirection;
    }

    public void setStartDirection(Direction value) {
        startDirection = value;
    }
    public void runInput(FastReader fastReader)
    {
        String source = fastReader.next();
        if( source.equals("SOURCE"))
        {
            start.setX(fastReader.nextInt());
            start.setY(fastReader.nextInt());
            startDirection.setDirection(fastReader.next());
        }
        else
        {
            System.out.println("Wrong Source Line" + source);
            throw new IllegalArgumentException("Invalid Source Line");
        }

        String dest = fastReader.next();
        if (dest.equals("DESTINATION"))
        {
            end.setX(fastReader.nextInt());
            end.setY(fastReader.nextInt());

        }
        else
        {
            System.out.println("Wrong Destination Line" + dest);
        }
        
        String printPower = fastReader.next();
        if(printPower.equals("PRINT_POWER"))
        {
            calculatePower();
        }
        else
        {
            System.out.println("Wrong Print Line" + printPower);
        }
    }
    public void calculatePower() {
        final int STEP_POINT = 10;
        final int TURN_POINT = 5;
        final int STARTING_POWER = 200;

        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();

        int absDist = Math.abs(dx) + Math.abs(dy);

        int turnDist = startDirection.calcTurns(dx, dy);

        int distance = STARTING_POWER - (absDist * STEP_POINT + turnDist * TURN_POINT);

        System.out.println("POWER " + distance);
    }
}
