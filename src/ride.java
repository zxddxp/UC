/*
ID: zxddxp1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        String st = f.readLine().trim();
        int i1 = 1;
        for (int i = 0; i < st.length(); i++) {
            i1 *= (st.charAt(i) - 'A' + 1);
        }
        st = f.readLine().trim();
        int i2 = 1;
        for (int i = 0; i < st.length(); i++) {
            i2 *= (st.charAt(i) - 'A' + 1);
        }
        if (i1 % 47 == i2 % 47) {
            out.println("GO");
        }
        else {
            out.println("STAY");
        }
        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!
    }
}
