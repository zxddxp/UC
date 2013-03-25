/*
ID: zxddxp1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday {
    public int[] total;
    public int[] daysPerMonth;

    friday() {
        total = new int[7];
        daysPerMonth = new int[12];
        daysPerMonth[0] = 31;
        daysPerMonth[1] = 28;
        daysPerMonth[2] = 31;
        daysPerMonth[3] = 30;
        daysPerMonth[4] = 31;
        daysPerMonth[5] = 30;
        daysPerMonth[6] = 31;
        daysPerMonth[7] = 31;
        daysPerMonth[8] = 30;
        daysPerMonth[9] = 31;
        daysPerMonth[10] = 30;
        daysPerMonth[11] = 31;
    }

    void compute (int n) {
        int firstDay = 0;
        for (int i = 0; i < n; i++) {
            int year = 1900 + i;
            if (isRegular (year)) {
                daysPerMonth[1] = 28;
            }
            else {
                daysPerMonth[1] = 29;
            }

            for (int j = 0; j < 12; j++) {
                total[(firstDay+12)%7]++;
                firstDay = (firstDay + daysPerMonth[j]) % 7;
            }
        }
    }

    boolean isRegular(int year) {
        return ((year % 4 != 0)
                || ((year % 100 == 0) && (year % 400 != 0)));
    }

    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        friday fri = new friday();
        int n = Integer.parseInt(f.readLine().trim());
        fri.compute(n);
        out.print(fri.total[5]+" "+fri.total[6]);
        for (int i = 0; i < 5; i++) {
            out.print(" " + fri.total[i]);
        }
        out.println();                           // output result
        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!
    }
}
