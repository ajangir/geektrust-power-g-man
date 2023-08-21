import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(String fileName)
        {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next()); 
        }
}