class Solution {
    public String makeFancyString(String s) {

        if (s.length() < 3) {
            return s;
        }

        char[] arr = s.toCharArray();
        int j = 2;

        for (int i = 2; i < s.length(); ++i) {
            if (arr[i] != arr[j - 1] || arr[i] != arr[j - 2]) {
                arr[j++] = arr[i];
            }
        }

        return new String(arr, 0, j);
    }
}