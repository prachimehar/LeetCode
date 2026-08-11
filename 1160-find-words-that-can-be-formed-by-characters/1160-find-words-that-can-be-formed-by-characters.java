class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] available = new int[26];
        for (char c : chars.toCharArray()) {
            available[c - 'a']++;
        }

        int answer = 0;
        for (String word : words) {
            int[] required = new int[26];
            boolean canForm = true;
            
            for (char c : word.toCharArray()) {
                required[c - 'a']++;
                if (required[c - 'a'] > available[c - 'a']) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                answer += word.length();
            }
        }

        return answer;
    }
}