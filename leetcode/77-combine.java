class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> item, int start, int n, int k) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(item));
        } else {
            for(int i = start; i <= n; i++) {
                item.add(i);
                backtrack(res, item, i+1, n, k-1);
                item.remove(item.size()-1);
            }
        }
    }
}
