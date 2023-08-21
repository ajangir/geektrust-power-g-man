import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testRunInput()
    {
        Solution solver = new Solution();
        FastReader fr = new FastReader("sample/in0.txt");
        assertThrows(IllegalArgumentException.class,()->{
            solver.runInput(fr);
        });
    }

    @Test
    public void testPointInitialization() {
        Point point = new Point(3, 4);
        assertEquals(3, point.getX());
        assertEquals(4, point.getY());
    }

    @Test
    public void testPointSetX()
    {
        Point point = new Point();
        point.setX(2);

        assertEquals(2, point.getX());
        assertEquals(0, point.getY());
    }

    @Test
    public void testPointSetY()
    {
        Point point = new Point();
        point.setY(3);

        assertEquals(3, point.getY());
        assertEquals(0, point.getX());
    }

    @Test
    public void testDirectionSetNone()
    {
        Direction dr = new Direction();

        assertEquals(-1, dr.getDirection());
    }

    @Test
    public void testDirectionSetString()
    {
        Direction dr = new Direction();
        dr.setDirection("S");

        assertEquals(2, dr.getDirection());
    }

    @Test
    public void testDirectionSetStringException()
    {
        Direction direction = new Direction();
        assertThrows(IllegalArgumentException.class, ()->{
            direction.setDirection("invalid");
        });
    }

    @Test
    public void testDirectionSetIntException()
    {
        Direction direction = new Direction();
        assertThrows(IllegalArgumentException.class, ()->{
            direction.setDirection(6);
        });
    }

    @Test
    public void testDirectionSetInt()
    {
        Direction dr = new Direction();
        dr.setDirection(3);
        
        assertEquals(3, dr.getDirection());
    }


    @Test
    public void testDirectionInitialization() {
        Direction direction = new Direction();
        assertEquals(Direction.NONE, direction.getDirection());
    }

    @Test
    public void testDirectionSetDirection() {
        Direction direction = new Direction();
        direction.setDirection("N");
        assertEquals(0, direction.getDirection());
        
        direction.setDirection(2);
        assertEquals(2, direction.getDirection());
    }

    @Test
    public void testDirectionCalcTurns() {
        Direction direction = new Direction();
        direction.setDirection(0);

        assertEquals(0, direction.calcTurns(0, 0));
        assertEquals(1, direction.calcTurns(1, 0));
        assertEquals(0, direction.calcTurns(0, 1));
        assertEquals(1, direction.calcTurns(-1, 0));
        assertEquals(2, direction.calcTurns(0, -1));
    }

    @Test
    public void testSolutionCalculatePower() {
        Solution solution = new Solution();
        solution.getStart().setX(2);
        solution.getStart().setY(3);
        solution.getStartDirection().setDirection("E");
        solution.getEnd().setX(5);
        solution.getEnd().setY(2);

        solution.calculatePower();
    }
    
    @Test
    public void testSolutionStartX()
    {
        Solution solution = new Solution();
        solution.getStart().setX(2);

        assertEquals(2, solution.getStart().getX());
    }

    @Test
    public void testSolutionStartY()
    {
        Solution solution = new Solution();
        solution.getStart().setY(3);

        assertEquals(3, solution.getStart().getY());
        
    }

    @Test
    public void testSolutionEndX()
    {
        Solution solution = new Solution();
        solution.getEnd().setX(5);

        assertEquals(5, solution.getEnd().getX());
        
    }

    @Test
    public void testSolutionEndY()
    {
        Solution solution = new Solution();
        solution.getEnd().setY(2);
        assertEquals(2, solution.getEnd().getY());
        
    }

    @Test
    public void testSolutionStartDirectionString()
    {

        Solution solution = new Solution();
        solution.getStartDirection().setDirection("E");

        assertEquals(1, solution.getStartDirection().getDirection());
    }
    
    @Test
    public void testSolutionStartDirectionInt()
    {

        Solution solution = new Solution();
        solution.getStartDirection().setDirection(0);

        assertEquals(0, solution.getStartDirection().getDirection());
        
    }

    @Test
    public void testFastReaderOutput(){
        FastReader fr = new FastReader("sample/input1.txt");
        String result = fr.next();
        assertEquals("SOURCE", result);
        
        int value = fr.nextInt();
        assertEquals(2, value);

        value = fr.nextInt();
        assertEquals(1, value);

        result = fr.next();
        assertEquals("E", result);

        result = fr.next();
        assertEquals("DESTINATION", result);

        value = fr.nextInt();
        assertEquals(4, value);

        value = fr.nextInt();
        assertEquals(3, value);

        result = fr.next();
        assertEquals("PRINT_POWER", result);
    }
}
