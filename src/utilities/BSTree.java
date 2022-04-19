package utilities;
import exceptions.TreeException;
import referenceBasedTreeImplementation.BSTreeNode;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E>{
	private static final long serialVersionUID = 1L;
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> inorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> preorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> postorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
