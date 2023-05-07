package Foundations;

public class RBTNode extends Node{
	public static final int RED = 1;
	public static final int BLACK = 0;
	
	private RBTNode parent = null; // 부모 노드 포인터
	private int color = BLACK; // 노드 자신의 색상
	
	public RBTNode(Data nd) {
		super(nd);
		// TODO Auto-generated constructor stub
	}
	
	public RBTNode(Data nd, RBTNode left, RBTNode right) {
		super(nd, left, right);
	}
	
	public void setColor(int color) { this.color = color; }
	public void setParent(RBTNode parent) { this.parent = parent; }
	public void setLeftChild(RBTNode left) { this.setLeftChild(left); }
	public void setRightChild(RBTNode right) { this.setRightChild(right); }
	
	public int getColor() { return color; }
	public RBTNode getLeftChild() { return (RBTNode)this.getLeftChild();}
	public RBTNode getRightChild() { return (RBTNode)this.getRightChild(); }
	public RBTNode getParent() { return parent; }
	
}
