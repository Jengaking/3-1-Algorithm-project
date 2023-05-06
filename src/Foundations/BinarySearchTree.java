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
			if(cur.getLeftChild() == null && cur.getRightChild() == null) { // 삭제 대상이 terminal node 일 경우
				switch(pre.getChildFlag(cur)) { // 0 : left Child, 1 : right Child
				case 0:
					pre.setLeftChild(null); break;
				case 1:
					pre.setRightChild(null); break;
				}
				
			} else if(cur.getLeftChild() == null || cur.getRightChild() == null) { // 삭제 대상이 하나의 child를 가지는 경우
				Node curch = (cur.getLeftChild() == null) ? cur.getRightChild() : cur.getLeftChild();
				switch(pre.getChildFlag(cur)) { // 0 : left Child, 1 : right Child
				case 0:
					pre.setLeftChild(curch); break;
				case 1:
					pre.setRightChild(curch); break;
				}
			} else { // 삭제 대상이 2개의 child를 가지는 경우
				// 삭제 대상 노드의 right sub-tree에서 가장 작은 노드를 삭제 노드의 위치로 이동시킨다.
				Node cp = cur; // cc의 parent 노드
				Node cc = cur.getRightChild(); //right sub-tree의 root node
				while(cc.getLeftChild() != null) { // right sub-tree에서 가장 작은 키값을 갖는 노드 탐색
					cp = cc;
					cc = cc.getLeftChild();
				}
				
				if(cp == cur) { // 삭제 대상의 right child node가 left sub-tree를 갖지 않는 경우
					// cur을 cur의 right child의 데이터로 바꾸고, cur의 right child 포인터가 right child의 right sub tree를 가리키도록 함.
					cp.setNodeData(cc.getNodeData());
					cp.setRightChild(cc.getRightChild());
				} else {
					// cur의 데이터를 right sub-tree의 최소 키값으로 변경, 최소 키 값을 갖는 노드는 left child가 없음이 보장된다.
					// right child를 이 노드의 parent의 left child로 연결.
					cur.setNodeData(cc.getNodeData());
					cp.setLeftChild(cc.getRightChild());
				}
			}
		}
		this.nodeCount--;
		return cur; // 노드가 삭제된 위치의 현재 노드를 리턴
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
