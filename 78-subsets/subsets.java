class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubset(nums,0,new ArrayList<>(),ans);
        return ans;     
}

    private void generateSubset(int[] nums, int CI, ArrayList<Integer>CurrentSubset, List<List<Integer>> ans){
        if(CI >= nums.length){
            ans.add(new ArrayList<>(CurrentSubset));
            return;
        }
        generateSubset(nums,CI+1,CurrentSubset,ans);
        CurrentSubset.add(nums[CI]);
        generateSubset(nums,CI+1,CurrentSubset,ans);
        CurrentSubset.remove(CurrentSubset.size()-1);
        return;
    }
}