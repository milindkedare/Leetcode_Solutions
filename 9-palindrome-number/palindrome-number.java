class Solution {
    public boolean isPalindrome(int x) {
    // Step 1: Edge cases
    if (x < 0 || (x % 10 == 0 && x != 0)) 
        return false;

    int reversedHalf = 0;
    
    // Step 2: Reverse only half of the number
    while (x > reversedHalf) {
        reversedHalf = reversedHalf * 10 + x % 10;
        x /= 10;
    }

    // Step 3: Check if the first half matches the reversed second half
    return x == reversedHalf || x == reversedHalf / 10;
}

}