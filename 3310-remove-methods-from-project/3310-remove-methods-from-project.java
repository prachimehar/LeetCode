class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : invocations){
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        for(int[] edge : invocations){
            int from = edge[0];
            int to = edge[1];

            if(!suspicious[from] && suspicious[to]){
                List<Integer> answer = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    answer.add(i);
                }

                return answer;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!suspicious[i]){
                answer.add(i);
            }
        }

        return answer;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] suspicious){

        if(suspicious[node]){
            return;
        }

        suspicious[node] = true;

        for(int next : graph[node]){
            dfs(next, graph, suspicious);
        }

    }
}