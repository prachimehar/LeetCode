class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        String[] words = paragraph.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (word.length() == 0 || bannedSet.contains(word)) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String answer = "";
        int max = 0;

        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                answer = word;
            }
        }

        return answer;
    }
}