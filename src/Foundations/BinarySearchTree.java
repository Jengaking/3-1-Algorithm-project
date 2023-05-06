package Foundations;

public class BinarySearchTree extends BinaryTree implements BST_spec{

	public BinarySearchTree(Node root) {
		super(root);
	}
	
	public BinarySearchTree() {
		super();
	}
	
	@Override
	public Node search(Data target) {
		Node cur = this.getRoot();
		if(cur == null) {
			System.out.println("BST is empty.");
			return null;
		}
		int t;
		System.out.println(cur.getNodeData().toString());
		while(cur != null && (t = cur.getNodeData().compare(target)) != 0) {
			System.out.println(t);
			cur = (t < 0) ? cur.getLeftChild() : cur.getRightChild();
			System.out.println(cur.getNodeData().toString());
		}
		System.out.println(cur.getNodeData().toString());
		
		return cur;
	}
	
	@Override
	public Node remove(Data target) {
		Node cur = this.getRoot();
		Node pre = null;
		if(cur == null) return null;
		
		while(cur != null && cur.getNodeData().compare(target) != 0) {
			pre = cur;
			cur = (cur.getNodeData().compare(target) < 0) ? cur.getLeftChild() : cur.getRightChild();
		}
		
		if(cur != null) {
			if(cur.getLeftChild() == null && cur.getRightChild() == null) { // ���� ����� terminal node �� ���
				switch(pre.getChildFlag(cur)) { // 0 : left Child, 1 : right Child
				case 0:
					pre.setLeftChild(null); break;
				case 1:
					pre.setRightChild(null); break;
				}
				
			} else if(cur.getLeftChild() == null || cur.getRightChild() == null) { // ���� ����� �ϳ��� child�� ������ ���
				Node curch = (cur.getLeftChild() == null) ? cur.getRightChild() : cur.getLeftChild();
				switch(pre.getChildFlag(cur)) { // 0 : left Child, 1 : right Child
				case 0:
					pre.setLeftChild(curch); break;
				case 1:
					pre.setRightChild(curch); break;
				}
			} else { // ���� ����� 2���� child�� ������ ���
				// ���� ��� ����� right sub-tree���� ���� ���� ��带 ���� ����� ��ġ�� �̵���Ų��.
				Node cp = cur; // cc�� parent ���
				Node cc = cur.getRightChild(); //right sub-tree�� root node
				while(cc.getLeftChild() != null) { // right sub-tree���� ���� ���� Ű���� ���� ��� Ž��
					cp = cc;
					cc = cc.getLeftChild();
				}
				
				if(cp == cur) { // ���� ����� right child node�� left sub-tree�� ���� �ʴ� ���
					// cur�� cur�� right child�� �����ͷ� �ٲٰ�, cur�� right child �����Ͱ� right child�� right sub tree�� ����Ű���� ��.
					cp.setNodeData(cc.getNodeData());
					cp.setRightChild(cc.getRightChild());
				} else {
					// cur�� �����͸� right sub-tree�� �ּ� Ű������ ����, �ּ� Ű ���� ���� ���� left child�� ������ ����ȴ�.
					// right child�� �� ����� parent�� left child�� ����.
					cur.setNodeData(cc.getNodeData());
					cp.setLeftChild(cc.getRightChild());
				}
			}
		}
		this.nodeCount--;
		return cur; // ��尡 ������ ��ġ�� ���� ��带 ����
	}
	
	
	@Override
	public void insert(Node newnode) {
		Node pre = null, cur = this.getRoot();
		
		this.nodeCount++;
		while(cur != null) {
			pre = cur;
			cur = (cur.getNodeData().compare(newnode.getNodeData()) <= 0) ? cur.getLeftChild() : cur.getRightChild();
		}
		
		if(cur == null && pre != null) {
			if(pre.getNodeData().compare(newnode.getNodeData()) <= 0) pre.setLeftChild(newnode);
			else pre.setRightChild(newnode);
		} else {
			this.setRoot(newnode);
		}
		
	}

}
