class Solution {
	List<Set<Integer>> graph;
	int[] answer, count;
	int n;

	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		this.n = n;
		answer = new int[n];

		count = new int[n];
		Arrays.fill(count, 1);

		graph = new ArrayList<>();

		for (int i = 0; i < n; i++)
			graph.add(i, new HashSet<>());

		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		dfs(0, -1);
		dfs2(0, -1);

		return answer;
	}

	private void dfs(int node, int parent) {
		for (int child : graph.get(node)) {
			if (child != parent) {
				dfs(child, node);
				count[node] += count[child];
				answer[node] += answer[child] + count[child];
			}
		}
	}

	private void dfs2(int node, int parent) {
		for (int child : graph.get(node)) {
			if (child != parent) {
				answer[child] = answer[node] - count[child] + n - count[child];
				dfs2(child, node);
			}
		}
	}}