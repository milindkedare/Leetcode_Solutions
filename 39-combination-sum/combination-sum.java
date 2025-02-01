class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        generate(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    private void generate(int[] nums,int ci,int target,ArrayList<Integer>current,List<List<Integer>>ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if(ci>=nums.length)
            return;
        
        if(nums[ci]<=target)
        {
            current.add(nums[ci]);
            generate(nums,ci,target-nums[ci],current,ans);
            current.remove(current.size()-1);
        }
         generate(nums,ci+1,target,current,ans);
        return;
        
    }
}