class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;
        int length = word.length();
        
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            }
        }
       
        return uppercaseCount == length || uppercaseCount == 0 || (uppercaseCount == 1 && Character.isUpperCase(word.charAt(0)));
    
    }
}