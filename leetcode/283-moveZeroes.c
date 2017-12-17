void moveZeroes(int* nums, int numsSize) {
    int p = 0;
    for(int i = 0; i < numsSize; i++){
        if(*(nums+i) != 0){
            *(nums+p) = *(nums+i);
            p++;
        }
    }
    while(p < numsSize){
        *(nums+p) = 0;
        p++;
    }
}
