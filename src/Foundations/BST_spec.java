package Foundations;

public interface BST_spec {
	// Binary Search Tree interface for normal binary Trees
	
	// specify the insert/remove operations.
	public abstract Node search(Data target);
	public abstract Node remove(Data target);
	public abstract void insert(Node newnode);
}
