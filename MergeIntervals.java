public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new MyComparator());
        
        int i = 0;
        
        while(i<intervals.size()-1){
            if(intervals.get(i).end >= intervals.get(i+1).start){
                if(intervals.get(i).end < intervals.get(i+1).end)
                   intervals.get(i).end = intervals.get(i+1).end;
                intervals.remove(i+1);
            }else{
                i++;
            }
        }
        return intervals;
    }
    
    
}

class MyComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        if(a.start<b.start) return -1;
        else if(a.start == b.start) return 0;
        else return 1;
    }
}
