// end < sta[i] -> add to list
// end >= sta[i] -> merge: 

class Solution {
    public int[][] merge(int[][] intervals) {
        int[] sta = new int[intervals.length], end = new int[intervals.length];
        List<int[]> list = new LinkedList<>();
        if(intervals.length == 0){
            return list.toArray(new int[][]{});
        }
        for(int i = 0; i < intervals.length; i ++){
            sta[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(sta);
        Arrays.sort(end);
        int left = sta[0], right = end[0];
        for(int i = 1; i < intervals.length; i ++){
            if(right < sta[i]){ // add to result
                list.add(new int[]{left,right});
                left = sta[i];
                right = end[i];
            } else{
                right = end[i];
            }
        }
        list.add(new int[]{left,right});
        return list.toArray(new int[][]{});
    }
}