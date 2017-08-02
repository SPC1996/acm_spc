package four.e;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		int n;
		StringBuilder builder=new StringBuilder();
		TreeNode root=null;
		for(int i=0;i<t;i++) {
			n=scanner.nextInt();
			TreeNode node=null;
			for(int j=0;j<n;j++) {
				node=new TreeNode();
				node.value=scanner.nextInt();
				root=BST.tree_insert(root, node);
			}
			BST.preorder_walk(root, builder);
			System.out.println(builder.toString().trim());
			builder.delete(0, builder.length());
			BST.inorder_walk(root, builder);
			System.out.println(builder.toString().trim());
			builder.delete(0, builder.length());
			BST.poster_walk(root, builder);
			System.out.println(builder.toString().trim());
			builder.delete(0, builder.length());
			System.out.println();
			root=null;
		}
	}

}

class BST{
	public static TreeNode tree_insert(TreeNode root,TreeNode z){
		TreeNode y=null;
		TreeNode x=root;
		while(x!=null){
			y=x;
			if(z.value<x.value){
				x=x.left;
			}
			else {
				x=x.right;
			}
		}
		z.parent=y;
		if(y==null){
			root=z;
		}
		else if (z.value<y.value) {
			y.left=z;
		}
		else {
			y.right=z;
		}
		return root;
	}
	
	public static void preorder_walk(TreeNode x, StringBuilder builder){
		if(x==null)
			return;
		builder.append(x.value+" ");
		preorder_walk(x.left, builder);
		preorder_walk(x.right, builder);
	}
	
	public static void inorder_walk(TreeNode x, StringBuilder builder){
		if(x==null)
			return;
		inorder_walk(x.left, builder);
		builder.append(x.value+" ");
		inorder_walk(x.right, builder);
	}
	
	public static void poster_walk(TreeNode x, StringBuilder builder){
		if(x==null)
			return;
		poster_walk(x.left, builder);
		poster_walk(x.right, builder);
		builder.append(x.value+" ");
	}
}

class TreeNode {
	public int value;
	public TreeNode parent=null;
	public TreeNode left=null;
	public TreeNode right=null;
	
}