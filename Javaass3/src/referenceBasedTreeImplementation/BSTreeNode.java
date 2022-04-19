package referenceBasedTreeImplementation;

public class BSTreeNode<E> {
	private E element;
	private BSTreeNode<E> left, right;
	
	public BSTreeNode(E elem, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public BSTreeNode(E elem) {
		this.element = elem;
	}
	
	public E getElement() {
		return this.element;
	}
	
	public void setElement(E elem) {
		this.element = elem;
	}
	
	public BSTreeNode<E> getLeft(){
		return this.left;
	}
	
	public BSTreeNode<E> getRight(){
		return this.right;
	}
}
