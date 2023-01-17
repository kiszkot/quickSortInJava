import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import zad.IntQuick;

public class QuickTest {
	
	private static final int MAXIMUM_INTEGER = 1000000;
	
	//do not instantiate
	private QuickTest() { }
	
	public static double time_trial(int n, int m) {
		int[] ran = new int[n];
    	for(int i=0; i<n; i++) {
    		ran[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
    	}
		Stopwatch timer = new Stopwatch();
		IntQuick.sort(ran,m);
		return timer.elapsedTime();
	}

	//output formatted to xml files
	public static void main(String[] args) {
		StdOut.printf("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
		StdOut.printf("<dataset>\n");
		for(int j = 1000;j<=1000000;j*=10) {
			for(int i = 0;i<31;i++) {
				StdOut.printf("\t<record>\n");
				StdOut.printf("\t\t<n>%d</n>\n",j);
				StdOut.printf("\t\t<m>%d</m>\n",i);
				StdOut.printf("\t\t<time>%f</time>\n",time_trial(j,i));
				StdOut.printf("\t</record>\n");
			}
		}
		StdOut.printf("</dataset>");
	}

}
