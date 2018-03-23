class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList(), candidates, target, 0);
        return list;
    }
    public void backtrack(List<List<Integer>> list,  List<Integer> item, int[] candidates, int target, int start){
        if(target < 0) return;
        else if(target == 0){
            list.add(new ArrayList(item));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            item.add(candidates[i]);
            backtrack(list, item, candidates, target-candidates[i], i+1);
            item.remove(item.size()-1);
        }
    }
}
