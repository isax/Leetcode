public class InsertInterval {
    /*
     * Reference Link: http://yucoding.blogspot.com/2013/01/leetcode-question-35-insert-interval.html
     * 1. Insert the new interval according to the start value.
     * 2. Scan the whole intervals, merge two intervals if necessary.
     */
    public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        while(i<intervals.size()){ // careful!!!
            if(newInterval.start< intervals.get(i).start){
               intervals.add(i, newInterval); 
               break;
            }
            i++;
        }
        if(intervals.size() == i){
            intervals.add(newInterval);
        }
        
        if(i!=0){
            i--;
        }
        while(i<intervals.size()-1){
            if(intervals.get(i).end>=intervals.get(i+1).start){
                if(intervals.get(i).end<intervals.get(i+1).end)
                    intervals.get(i).end = intervals.get(i+1).end;
                intervals.remove(i+1);
            }
            else{
                i++;
            }
        }
        return intervals;
        
    }
    
    /*
     * Binary Search for overlapping range
     * Check for newStart and newEnd
     * Delete old ones
     * Insert (newStart, newEnd)
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        int start = binarySearch(intervals, newInterval.start);
        int end = binarySearch(intervals, newInterval.end);
        
        int newStart = 0;
        if(start>0 && intervals.get(start-1).end>=newInterval.start){
            newStart = intervals.get(start-1).start;
            start--;
        }else{
            newStart = newInterval.start;
        }
        
        int newEnd;
        if(end<intervals.size()&&intervals.get(end).start==newInterval.end) {
            newEnd = intervals.get(end).end;
            end++;
        }else if(end>0){
        	newEnd= Math.max(newInterval.end, intervals.get(end-1).end);
        }
        else newEnd = newInterval.end;
        
        for(int i =start; i<end; i++){
            intervals.remove(start);
        }
        
        intervals.add(start,new Interval(newStart, newEnd));
        
        return intervals;
        
    }
    
    public int binarySearch(ArrayList<Interval> intervals, int x){
        int a = 0;
        int b = intervals.size()-1;
        int mid = (a+b)/2;
        while(a<=b){
            mid = (a+b)/2;
            if(intervals.get(mid).start==x){
                return mid;
            }else if(intervals.get(mid).start<x){
                a = mid + 1;
            }else{
                b = mid - 1;
            }
        }
        return a;//the index with value >= x [0, length]
    }
    
    
}
