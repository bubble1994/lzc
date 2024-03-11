// Find
HashMap<Integer, Intger> father = new HashMap<>();
pubic int find(int x) {
	int parent = father.get(x);
	while (parent != father.get(parent)) {
		parent = father.get(parent);
	}
	return parent;
}
//Time Complexity O(n) 

// Union
// union(E, B)
HashMap<Integer, Integer> father = new HashMap<>();
public void union(int x, int y) {
	int fa_x = find(x);
	int fa_y = find(y);
	if (fa_x != fa_y) {
		father.put(fa_x, fa_y);
	}
}
// Time Complexity O(n)


class UnionFind {
	HashMap<Integer, Integer> father = new HashMap<>();
	UnionFind(int n) {
		for (int i = 0; i < n; i++) {
			father.put(i, i);
		}
	}

	int find2(int x) {
		int parent = father.get(x);
		while (parent != father.get(parent)) {
			parent = father.get(parent);
		}
		int temp = -1;
		int fa = father.get(x);
		while (fa != father.get(fa)) {
			temp = father.get(fa);
			father.put(fa, parent);
			fa = temp;
		}
		return parent;
	}

	void union(int x, int y) {
		int fa_x = find2(x);
		int fa_y = find2(y);
		if (fa_x != fa_y) {
			father.put(fa_x, fa_y);
		}
	}
}