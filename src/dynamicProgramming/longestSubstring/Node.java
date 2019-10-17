package dynamicProgramming.longestSubstring;

import java.util.List;

public class Node {
    private int count;
    private List<Integer> indexList;

    public List<Integer> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<Integer> indexList) {
        this.indexList = indexList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
