/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() <=1){
            return intervals;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        Interval last = intervals.get(0);
        for(int i = 1 ; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= last.end){
                last.end = Math.max(last.end,current.end);
            } else {
                result.add(last);
                last = current;
            }
        }
        result.add(last);
        return result;
    }
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
            //从小到大，前减后
        }
    }
}