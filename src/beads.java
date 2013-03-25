/*
ID: zxddxp1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        f.readLine(); //eat the first line, we don't need the number of beads
        char[] s = f.readLine().trim().toCharArray();
        int maxSoFar = 0;
        int oldV = 0;
        int newV = 0;
        char c = 'w';
        for (int k = 0; k < s.length; k++) {
            if (s[k] != 'w') {
                c = s[k];
                break;
            }
        }
        if (c == 'w') {//a necklace with 'w' only
            out.println(s.length);
            out.close();
            return;
        }

        int i = 0; //find the location of the 1st "switch"
        while (i < s.length && (s[i] == c || s[i] == 'w')) {
            i++;
        }
        if (i == s.length) {//the whole necklace can be used
            maxSoFar = s.length;
        }
        else {
            newV = i; //prefix before the 1st switch
            i--; //back-off to the position just before the "switch"
            int j = s.length - 1;
            while (j > i && (s[j] == c || s[j] == 'w')) {//find the suffix
                newV ++;
                j--;
            }
            oldV = newV; //the 1st segment
            while (j > i) {
                newV = 1;
                c = s[j];
                j--;
                while (j > i && (s[j] == c || s[j] == 'w')) {
                    newV ++;
                    j--;
                }
                c = s[j];
                if ((oldV + newV) > maxSoFar) {
                    maxSoFar = oldV + newV;
                }
                oldV = newV;
            }
        }
        out.println(maxSoFar);                           // output result
        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!
    }
}
