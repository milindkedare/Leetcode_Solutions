class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatesub(nums,0,new ArrayList<>(),ans);
        return ans;

    }
    static void generatesub(int[] nums,int CI, ArrayList<Integer> CS,List<List<Integer>> ans)
    {
        if(CI >= nums.length)
        {
            ans.add(new ArrayList<>(CS));
            return;
        }

        CS.add(nums[CI]);
        generatesub(nums,CI+1,CS,ans);
        CS.remove(CS.size()-1);
        generatesub(nums,CI+1,CS,ans);
        return;
    }
}