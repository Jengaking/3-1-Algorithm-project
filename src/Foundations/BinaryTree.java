package Foundations;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root = null;
	protected int nodeCount = 0;
	
	public BinaryTree(Node root) {
		this.root = root;
		nodeCount = 0;
	}
	
	public BinaryTree() { this(null); }
	
	public Node getRoot() { return root; }
	public void setRoot(Node n) { this.root = n; }
	
	public void Traversal(int mode) {
		switch(mode) {
		case 1: preorderTraversal(root); break;
		case 2: inorderTraversal(root); break;
		case 3: postorderTraversal(root); break;
		case 4: levelTraversal(root); break;
		default : System.out.println("Error : undefined mode!");
		}
	}
	
	protected void preorderTraversal(Node node) {
		if(node != null) {
			System.out.println(node.getNodeData().toString()+"was visited");
			preorderTraversal(node.getLeftChild());
			preorderTraversal(node.getRightChild());
		}
	}
	
	protected void inorderTraversal(Node node) {
		if(node != null) {
			inorderTraversal(node.getLeftChild());
			System.out.println(node.getNodeData().toString()+"was visited");
			inorderTraversal(node.getRightChild());
		}
	}
	
	protected void postorderTraversal(Node node) {
		if(node != null) {
			postorderTraversal(node.getLeftChild());
			postorderTraversal(node.getRightChild());
			System.out.println(node.getNodeData().toString() + "was visited");
		}
	}
	
	// null 을 고려해서 정확한 트리 모습을 출력하도록 수정.
	protected void levelTraversal(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		int lineCount = 0, punc = 1, i = 0;
		
		if(node == null) return;
		
		queue.add(node);
		
		TRAVERSAL:
		while(!queue.isEmpty()) {
			Node tmp = queue.remove();
			
			if(tmp != null) {
				i++;
				System.out.print(tmp.getNodeData().toString()+" ");
				queue.add(tmp.getLeftChild());
				queue.add(tmp.getRightChild());
			} else {
				System.out.print("_ ");
				queue.add(null);
				queue.add(null);
			}
			
			if((int)Math.pow(2, lineCount) == punc++) {
				System.out.println(); punc = 1; lineCount++;
				if(i == nodeCount) break TRAVERSAL;
			}
		}
	}
	
	public int getNumberOfNodes() {
		return nodeCount; 
	}
	
	public int getTreeHeight() {
		return getHeight(root);
	}
	
	protected int getHeight(Node node) {
		if(node == null) return 0;
		int lh = getHeight(node.getLeftChild());
		int rh = getHeight(node.getRightChild());
		return (lh < rh) ? rh + 1 : lh + 1;
	}
}
