class Solution {

    List<Integer> result = new ArrayList<>();

    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits); // VERY IMPORTANT
        boolean[] used = new boolean[digits.length];
        ThreeDigit(digits, new ArrayList<>(), used);
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = result.get(i);
        return ans;
    }

    private void ThreeDigit(int[] digits, List<Integer> current, boolean[] used) {
        if (current.size() == 3) {
            int num = current.get(0) * 100 + current.get(1) * 10 + current.get(2);
            if (num % 2 == 0 && current.get(0) != 0) {
                result.add(num);
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1])
                continue;
            if (used[i]) continue;
            used[i] = true;
            current.add(digits[i]);
            ThreeDigit(digits, current, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
