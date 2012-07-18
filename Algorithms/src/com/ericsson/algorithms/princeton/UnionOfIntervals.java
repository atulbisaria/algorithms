package com.ericsson.algorithms.princeton;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.algorithms.QuickSort;


public class UnionOfIntervals {

	public static Interval[] union(Interval[] intervals) {
		
//		if(intervals == null || intervals.length == 1)
//			return intervals;
//		
//		int middle = intervals.length >> 2;
//		
//		Interval[] left = new Interval[middle];
//		Interval[] right = new Interval[intervals.length - middle];
//		
//		for (int i = 0; i < middle; i++) 
//			left[i] = intervals[i];
//		for (int i = middle; i < intervals.length; i++) 
//			right[i - middle] = intervals[i];
//		
//		left = union(left);
//		right = union(right);
//		
//		

		List<Interval> result = new ArrayList<Interval>();
		result.add(intervals[0]);
		
		for (int i = 1; i < intervals.length; i++) {
			Interval interval1 = result.get(result.size() - 1);
			Interval interval2 = intervals[i];
			
			if(interval2.start <= interval1.start && interval2.end >= interval1.end) {
				result.remove(result.size() - 1);
				result.add(interval2);
			}
			else if(interval1.start <= interval2.start && interval1.end >= interval2.end)
				continue;
			else if(interval1.end >= interval2.start && interval1.start <= interval2.end) {
				result.remove(result.size() - 1);
				result.add(new Interval(interval1.start, interval2.end));
			}
			else if(interval2.end >= interval1.start && interval2.start <= interval1.end) {
				result.remove(result.size() - 1);
				result.add(new Interval(interval2.start, interval1.end));
			} 
			else
				result.add(interval2);
		}
		
		System.out.println(result);
		
		Interval[] resultArray = new Interval[result.size()];
		result.toArray(resultArray);
		return resultArray;
	}
	
	public static void main(String[] args) {
		
//		List<Interval> intervals = new ArrayList<Interval>();
//		intervals.add(new Interval(2, 4.5));
//		intervals.add(new Interval(6, 9));
//		intervals.add(new Interval(7, 8));
//		intervals.add(new Interval(1, 3));
		
		Interval[] intervals = new Interval[4];
		
		intervals[0] = new Interval(2, 4.5);
		intervals[1] = new Interval(6, 9);
		intervals[2] = new Interval(7, 8);
		intervals[3] = new Interval(1, 3);
		
		QuickSort.quickSortInPlace(intervals, 0, intervals.length - 1);
		for (int i = 0; i < intervals.length; i++) {
			System.out.println(intervals[i]);
		}

		union(intervals);

	}
}

class Interval implements Comparable<Interval>{
	public double start;
	public double end;
	
	public Interval(double start, double end) {
		this.start = start;
		this.end = end;
	}

	public double getStart() {
		return start;
	}

	public double getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}

	@Override
	public int compareTo(Interval o) {
		if(start == o.start)
			return 0;
		else if(start < o.start)
			return -1;
		
		return 1;
	}
	
	
}
