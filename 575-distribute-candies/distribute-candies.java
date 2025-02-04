class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int n : candyType)
            set.add(n);
        int n = candyType.length/2;
        if(set.size() > n)
            return n;
        else
            return set.size();
    }
}