class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preTemp = null;
        for(int i = 1; i <= numRows; i++) {
            if(i == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                result.add(temp);
            } else if(i == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                temp.add(1);
                preTemp = temp;
                result.add(temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                for(int j = 1; j < i-1; j++)
                    temp.add(preTemp.get(j-1) + preTemp.get(j));
                temp.add(1);
                preTemp = temp;
                result.add(temp);
            }
        }
        return result;
    }
}
