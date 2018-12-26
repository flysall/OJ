class Solution {
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", n);
        return res.get(k-1);
    }
    private void backtrack(List<String> res, String str, int n) {
        if(str.length() == n)
            res.add(new String(str));
        else {
            for(int i = 1; i <= n; i++) {
                if(str.contains("" + i))
                    continue;
                str = str + "" + i;
                backtrack(res, str, n);
                str = str.substring(0, str.length()-1);
            }
        }
    }
}
