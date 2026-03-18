package com.example.search;

public class BlockSearchDemo02 {

    static void main(String[] args) {

        // 分块查找

        // 需要被查找的数组
        int[] arr = {27, 22, 30, 40, 36,
                    13, 19, 16, 20,
                    7, 10,
                    43, 50, 48};

        // block对象
        Block02 b1 = new Block02(22, 40, 0, 4);
        Block02 b2 = new Block02(13, 20, 5, 8);
        Block02 b3 = new Block02(7, 10, 9, 10);
        Block02 b4 = new Block02(43, 50, 11, 23);

        // 要查找的数字
        int num = 10 ;

        // 索引表
        Block02[] blockArr = {b1, b2, b3, b4};

        int index = getIndex(blockArr, num, arr);
        System.out.println(index);
    }

    private static int getBlockIndex(Block02[] blockArr, int num){

        for (int i = 0; i < blockArr.length; i++) {

            int min = blockArr[i].getMin();
            int max = blockArr[i].getMax();

            if(min <= num && num <= max){
                return i;
            }
        }
        return -1;

    }

    private static int getIndex(Block02[] blockArr, int num, int[] arr){

        int blockIndex = getBlockIndex(blockArr, num);
        
        if(blockIndex == -1){
            return -1;
        }

        int startIndex = blockArr[blockIndex].getStartIndex();
        int endIndex = blockArr[blockIndex].getEndIndex();

        for (int i = startIndex; i <= endIndex ; i++) {

            if(arr[i] == num){
                return i;
            }
        }
        return  -1;
    }
}

class Block02{

    private int max;
    private int min;
    private int startIndex;
    private int EndIndex;

    public Block02() {
    }

    public Block02(int min, int max, int startIndex, int endIndex) {
        this.max = max;
        this.min = min;
        this.startIndex = startIndex;
        EndIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return EndIndex;
    }

    public void setEndIndex(int endIndex) {
        EndIndex = endIndex;
    }
}
