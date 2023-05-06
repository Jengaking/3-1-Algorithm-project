package test;

import Foundations.*;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(Node.createNode(new Data(5)));
		bst.insert(Node.createNode(new Data(3)));
		bst.insert(Node.createNode(new Data(8)));
		bst.insert(Node.createNode(new Data(1)));
		bst.insert(Node.createNode(new Data(2)));
		bst.insert(Node.createNode(new Data(4)));
		bst.insert(Node.createNode(new Data(6)));
		bst.insert(Node.createNode(new Data(7)));
		bst.insert(Node.createNode(new Data(9)));
		System.out.println(bst.getRoot().toString());
		
		bst.Traversal(4);
		System.out.println();
		System.out.println("hegiht : " + bst.getTreeHeight());
		System.out.println("count : " + bst.getNumberOfNodes());
		System.out.println("target : data = 1");
		System.out.println("result : " + bst.search(new Data(9)).getNodeData());
		
		//remove test 1: terminal node
//		bst.remove(new Data(2));
//		bst.Traversal(4);
//		System.out.println("hegiht : " + bst.getTreeHeight());
//		System.out.println("count : " + bst.getNumberOfNodes());
		
		//remove test 2: node having a child
//		bst.remove(new Data(6));
//		bst.Traversal(4);
//		System.out.println("hegiht : " + bst.getTreeHeight());
//		System.out.println("count : " + bst.getNumberOfNodes());

		//remove test 2: node having two children
//		bst.remove(new Data(5));
//		bst.Traversal(4);
//		System.out.println("hegiht : " + bst.getTreeHeight());
//		System.out.println("count : " + bst.getNumberOfNodes());

	}

}
