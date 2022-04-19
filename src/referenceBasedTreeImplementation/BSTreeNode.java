package referenceBasedTreeImplementation;

public class BSTreeNode<E> {

	private E data;
	private BSTreeNode<E> left;
	private BSTreeNode<E> right;

	
	public BSTreeNode(E elem) {
		this.data = elem;
		this.left = null;
		this.right = null;
	}

	public BSTreeNode(E elem, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.data = elem;
		this.left = left;
		this.right = right;
	}

	public int getHeight() {
		return getHeight(this);
	}

	private int getHeight(BSTreeNode<E> node) {
		if (node == null)
			return 0;

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public E getElement() {
		return this.data;
	}

	public void setElement(E elem) {
		this.data = elem;
	}

	public BSTreeNode<E> getLeft() {
		return this.left;
	}

	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	public BSTreeNode<E> getRight() {
		return this.right;
	}

	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

	public boolean hasLeftChild() {
		return (this.left != null);
	}

	public boolean hasRightChild() {
		return (this.right != null);
	}

	public boolean isLeaf() {
		return (this.left == null && this.right == null);
	}

	public int getNumberNodes() {

		return getNumberNodes(this);
	}

	private int getNumberNodes(BSTreeNode<E> node) {
		if (node == null)
			return 0;

		return getNumberNodes(node.left) + getNumberNodes(node.right) + 1;
	}
	
}
