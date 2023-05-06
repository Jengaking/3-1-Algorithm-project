package Foundations;


// 트리의 구성요소인 노드
public class Node {
	private Node left = null;		//왼쪽 자식노드
	private Node right = null;		//오른쪽 자식노드
	private Data nodeData = null; 	// 노드의 데이터
	
	public Node(Data nd, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.nodeData = nd;
	}
	
	public Node(Data nd) {
		this(nd, null, null);
	}
	
	public void setNodeData(Data d) { this.nodeData = d; }
	public Data getNodeData() { return nodeData; }
	public void setLeftChild(Node left) { this.left = left; }
	public void setRightChild(Node right) { this.right = right; }
	public Node getLeftChild() { return left;}
	public Node getRightChild() { return right; }
	
	public int getChildFlag(Node ch) {
		if(this.left == ch) return 0;
		else if(this.right == ch) return 1;
		else return -1;
	}
	
	public static Node createNode(Data d) { return new Node(d); }
}
