import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Point {
	int x;
	int y;
	Point() {
		x = 0;
		y = 0;
	}
	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class NumberOfIsland2 {
	public static void main(String[] args) {
		int n = 4;
		int m = 5;
		Point[] operators = new Point[4];
		Point point1 = new Point(1, 1);
		Point point2 = new Point(0, 1);
		Point point3 = new Point(3, 3);
		Point point4 = new Point(3, 4);
		operators[0] = point1;
		operators[1] = point2;
		operators[2] = point3;
		operators[3] = point4;
		List<Integer> list = new NumberOfIsland2().numIslands(n, m, operators);
		for (int number: list) {
			System.out.println(number);
		}
	}
	class UnionFind {
		private Map<Integer, Integer> father = new HashMap<>();
		public UnionFind(int row, int column) {
			for (int i = 0; i < row; i ++) {
				for (int j = 0; j < column; j++) {
					int id = convertedId(i, j, column);
					father.put(id,  id);
				}
			}
		}
		
		public int find(int x) {
			int parent = father.get(x);
			while (parent != father.get(parent)) {
				parent = father.get(parent);
			}
			int temp = -1;
			int fa = father.get(x);
			while (fa != father.get(fa)) {
				temp = father.get(fa);
				father.put(fa,  parent);
				fa = temp;
			}
			return parent;
		}
		
		public void union(int x, int y) {
			int parent_x = father.get(x);
			int parent_y = father.get(y);
			if (parent_x != parent_y) {
				father.put(parent_x, parent_y);
			}
		}
		public int convertedId(int x, int y, int row) {
			return x * row + y;
		}
	}
	public List<Integer> numIslands(int n, int m, Point[] operators) {
		List<Integer> result = new ArrayList<>();
		if (operators == null || operators.length == 0) {
			return result;
		}
		UnionFind unionFind = new UnionFind(n, m);
		boolean[][] island = new boolean[n][m];
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int count = 0;
		for (Point point: operators) {
			int x = point.x;
			int y = point.y;
			if (!island[x][y]) {
				island[x][y] = true;
				count++;
				int id = unionFind.convertedId(x, y, m);
				for (int i = 0; i < 4; i++) {
					int current_x = x + dx[i];
					int current_y = y + dy[i];
					if (current_x >= 0 && current_x < n && current_y >= 0 && current_y < m && island[current_x][current_y]) {
						int nid = unionFind.convertedId(current_x, current_y, m);
						int father = unionFind.find(id);
						int nfather = unionFind.find(nid);
						if (father != nfather) {
							count--;
							unionFind.union(father, nfather);
						}
					}
				}
				result.add(count);
			}
		}
		return result;
	}
}