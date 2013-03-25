/*
ID: zxddxp1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        String st = f.readLine();
        int np = Integer.parseInt(st);
        String[] name = new String[np];
        int [] oldM = new int[np];
        int [] newM = new int[np];
        HashMap<String,Integer> dict = new HashMap<String, Integer>(np);
        for (int i = 0; i < np; i++) {
            name[i] = f.readLine().trim();
            dict.put(name[i],i);
        }
        while ((st = f.readLine()) != null) {
            String s = st.trim();
            int giver = dict.get(s);
            st = f.readLine().trim();
            String[] rs = st.split("\\s+");
            int amount = Integer.parseInt(rs[0]);
            int num = Integer.parseInt(rs[1]);
            oldM[giver] = amount;
            if (num > 0) {
                int each = amount / num;
                newM[giver] += amount % num;
                for (int j = 0; j < num; j++) {
                    int k = dict.get(f.readLine().trim());
                    newM[k] += each;
                }
            }
            else {
                newM[giver] += oldM[giver];
            }
        }
        for (int i = 0; i < np; i++) {
            out.println(name[i] + " " + (- oldM[i] + newM[i]));
        }
        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!
    }
}
