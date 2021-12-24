import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        
    }

    public int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        res.add(intervals[0]);
        for(int i = 1 ; i < intervals.length ; i++){
            int[] last = res.get(res.size() - 1);
            if(intervals[i][0] <= last[1]){
                last[1] = Math.max(intervals[i][1], last[1]);
            }else{
                res.add(intervals[i]);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
