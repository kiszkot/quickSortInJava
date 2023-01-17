package zad;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class IntQuick {
	
	public static void sort(int[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	public static void sortNonShuffle(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	//sort untill table of length m
	public static void sort(int[] a, int m) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1,m);
	}
	
	public static void sort(int[] a, int lo, int hi) {
		if(lo >= hi) { return; }
		int i = partition(a, lo, hi);
		sort(a, lo, i-1);
		sort(a, i+1, hi);
	}
	
	//Quicksort utill table of length m
	public static void sort(int[] a, int lo, int hi, int m) {
		if(lo >= hi) { return; }
		if(hi-lo+1<m) {
			IntInsertion.sort(a,lo,hi);
			return;
		}
		int i = partition(a, lo, hi);
		sort(a, lo, i-1);
		sort(a, i+1, hi);
	}
	
	public static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		int v = a[lo];
		while(true) {
			
			//index lo
			while(a[++i] < v) {
				if(i == hi) { break; }
			}
			
			//index hi
			while(a[--j] > v) {
				if(j == lo) { break; }
			}
			
			if(i >= j) { break; }
			
			swap(a, i, j);
		}
		
		swap(a, lo, j);
		return j;
	}
	
	public static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	
	public static void show(int[] a) {
		for(int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		sort(a,5);
		show(a);
	}

}
