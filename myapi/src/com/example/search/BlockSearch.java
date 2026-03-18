package com.example.search;

public class BlockSearch {

    static void main(String[] args) {

        // 块寻找

        // 要查询的数组
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};

        // block对象
        Block b1 = new Block(0, 5, 21);
        Block b2 = new Block(6, 11, 45);
        Block b3 = new Block(12, 17, 73);

        // 要查询的数字
        int number = 72;

        // 索引表 用来干啥？
        Block[] blockArr = {b1, b2, b3};

        int index = getIndex(blockArr, number, arr);

        System.out.println(index);

    }

    // 确定数字在哪块区，获取索引
    public static int getBlockIndex(Block[] blockArr, int number) {

        for (int i = 0; i < blockArr.length; i++) {
            if (blockArr[i].getMax() >= number) {
                return i;
            }
        }
        return -1;
    }

    // 在此区块中顺序查找
    public static int getIndex(Block[] blockArr, int number, int[] arr) {

        int blockIndex = getBlockIndex(blockArr, number);

        if (blockIndex == -1) {
            return -1;
        }

        int startIndex = blockArr[blockIndex].getStartIndex();
        int endIndex = blockArr[blockIndex].getEndIndex();

        for (int i = startIndex; i <= endIndex; i++) {

            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }
}

class Block {

    private int startIndex;
    private int endIndex;
    private int max;

    public Block() {
    }

    public Block(int startIndex, int endIndex, int max) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

