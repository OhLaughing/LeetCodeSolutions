package LeetCodeSolutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _56_MergeIntervals {
    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> linktedList = new LinkedList<>(intervals);
        if(intervals.size()<2)
            return intervals;
        Collections.sort(linktedList, new IntervalComparator());
        int index = 0;
        int size = linktedList.size()-1;
        while (index != size) {
            Interval curr = linktedList.get(index);
            Interval next = linktedList.get(index + 1);
            if (curr.end < next.start) {
                index++;
                continue;
            } else {
                int tmp = Math.max(curr.end, next.end);
                linktedList.remove(index+1);
                size--;
                curr.end = tmp;
            }
        }
        return linktedList;
    }
}


