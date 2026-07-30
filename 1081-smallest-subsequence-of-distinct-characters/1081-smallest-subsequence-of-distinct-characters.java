class Solution {
    public String smallestSubsequence(String s) {

        int[] count = new int[26];

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for(char ch : s.toCharArray()){

            count[ch - 'a']--;

            if(visited[ch - 'a']){
                continue;
            }

            while(!stack.isEmpty() 
                  && stack.peek() > ch 
                  && count[stack.peek() - 'a'] > 0){

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}