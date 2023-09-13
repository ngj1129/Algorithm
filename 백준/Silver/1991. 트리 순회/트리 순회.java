import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] tree = new String[n][3];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i][0] = st.nextToken();
            tree[i][1] = st.nextToken();
            tree[i][2] = st.nextToken();
        }
        preorder(tree, "A", n, 0);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        inorder(tree, "A", n, 0);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        postorder(tree, "A", n, 0);
        System.out.println(sb.toString());
    }
    public static void preorder(String[][] tree, String root, int n, int ix) {
        for (int i=ix; i<n; i++) {
            if (tree[i][0].equals(root)) {
                sb.append(root);
                if (!tree[i][1].equals(".")) {
                    preorder(tree, tree[i][1], n, ix+1);
                }
                if (!tree[i][2].equals(".")) {
                    preorder(tree, tree[i][2], n, ix+1);
                }
            }
        }
    }

    public static void inorder(String[][] tree, String root, int n, int ix) {
        for (int i=ix; i<n; i++) {
            if (tree[i][0].equals(root)) {
                if (!tree[i][1].equals(".")) {
                    inorder(tree, tree[i][1], n, ix+1);
                }
                sb.append(root);
                if (!tree[i][2].equals(".")) {
                    inorder(tree, tree[i][2], n, ix+1);
                }
            }
        }
    }

    public static void postorder(String[][] tree, String root, int n, int ix) {
        for (int i=ix; i<n; i++) {
            if (tree[i][0].equals(root)) {
                if (!tree[i][1].equals(".")) {
                    postorder(tree, tree[i][1], n, ix+1);
                }
                if (!tree[i][2].equals(".")) {
                    postorder(tree, tree[i][2], n, ix+1);
                }
                sb.append(root);
            }
        }
    }
}