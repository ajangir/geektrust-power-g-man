public class Main {

    public static void main(String[] args) {

        Solution solver = new Solution();

        if(args.length != 1)
        {
            System.out.println("Usage: java main input_file_name not given");
            return;
        }
        
        try {
            String fileName = args[0];
            FastReader reader = new FastReader(fileName);
            solver.runInput(reader);
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}