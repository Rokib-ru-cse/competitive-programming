import java.util.*;




public class DFSEdgeDeletion {
    private static int nodes;
    private static int edges;
    private static ArrayList<Integer>[] adjclt;

    private static void initializedAdjcl() {
        for (int i = 1; i <= nodes; i++) {
            adjclt[i] = new ArrayList<>();
        }
    }

    private static void getTree() {
        Scanner in = new Scanner(System.in);
        int x, y;
        for (int i = 0; i < edges; i++) {
            x = in.nextInt();
            y = in.nextInt();
            adjclt[x].add(y);
            adjclt[y].add(x);
        }
    }

    private static void dfs(int parent, int child) {

        for (int i : adjclt[child]) {
            if (parent != i) {
                dfs(child, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        adjclt = new ArrayList[nodes + 1];
        initializedAdjcl();
        getTree();
        dfs(0, 1);
    }
}
