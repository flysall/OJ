/**Defition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        int[] starts = new int[len], ends = new int[len];
        for(int i = 0; i < len; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> list = new ArrayList<>();
        for(int i = 0, j = 0; i < len; i++){
            if(i == len-1 || starts[i+1] > ends[i]){
                list.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return list;
    }
}
