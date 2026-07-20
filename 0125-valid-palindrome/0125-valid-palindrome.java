class Solution {
    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String rev = reverse(s);

        return s.equals(rev);
    }

    public String reverse(String s) {

        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}