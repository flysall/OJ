class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null) return 0;
        Arrays.sort(citations);
        if(citations[citations.length-1] == 0) return 0;
        int paperNum = 0;
        for(int i = citations.length-1; i >= 0; i--){
            paperNum = citations.length - i;
            if(citations[i] == paperNum)
                return paperNum;
            if(citations[i] < paperNum){
                paperNum -= 1;
                break;
            }
        }
        return paperNum;
    }
}
