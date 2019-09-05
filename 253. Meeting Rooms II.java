// sort by start time
// keep a heap for earliest ending meeting

public class Meeting{
    int staTime;
    int endTime;
    Meeting(int sta, int end){
        staTime = sta;
        endTime = end;
    }
}

class Solution {
    //Heap
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length < 1){
            return 0;
        }
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(
            intervals.length,
            new Comparator<Meeting>(){
                public int compare(Meeting a, Meeting b) {
                    return a.endTime - b.endTime;
                }
            }
        );
        Meeting[] meetings = new Meeting[intervals.length];
        
        for(int i = 0; i < intervals.length; i ++){
            meetings[i] = new Meeting(intervals[i][0], intervals[i][1]);
        }
        // Sort the intervals by start time
        Arrays.sort(
            meetings,
            new Comparator<Meeting>() {
            public int compare(Meeting a, Meeting b) {
                return a.staTime - b.staTime;
            }
        });
        // Start iteration
        minHeap.add(meetings[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(meetings[i].staTime >= minHeap.peek().endTime){
                minHeap.poll();
            }
            minHeap.add(meetings[i]);
        }
        
        return minHeap.size();
    }

    // Array
    public int minMeetingRooms(int[][] intervals) {
       int[] starts = new int[intervals.length], ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int ans = 0, ptr = 0;
        for(int i = 0; i < starts.length; i++){
            if(starts[i] < ends[ptr]){
                ans ++;
            } else {
                ptr ++;
            }
        }
        return ans;
    }
}