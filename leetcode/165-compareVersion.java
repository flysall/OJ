class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int len1 = v1.length, len2 = v2.length, i = 0, j = 0;
        while(i < len1 && j < len2){
            int value1 = Integer.valueOf(v1[i++]), value2 = Integer.valueOf(v2[j++]);
            if(value1 > value2)
                return 1;
            if(value1 < value2)
                return -1;
        }
        if(i == len1 && j == len2)
            return 0;
        else if(i == len1){
            while(j < len2)
                if(Integer.valueOf(v2[j++]) != 0)
                    return -1;
        }else{
            while(i < len1)
                if(Integer.valueOf(v1[i++]) != 0)
                    return 1;
        }
        return 0;
    }
}
