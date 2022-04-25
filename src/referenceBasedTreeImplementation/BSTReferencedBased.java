package referenceBasedTreeImplementation;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;
import utilities.BSTreeADT;
import utilities.Iterator;

public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT<E> {

	private BSTreeNode<E> root;

	public BSTReferencedBased() {
		this.root = null;
	}

	public BSTReferencedBased(E element) {
		this.root = new BSTreeNode<E>(element, null, null);
	}

	@Override
	public BSTreeNode<E> getRoot() throws TreeException {

		if (this.root == null)
			throw new TreeException("Root is empty");
		return this.root;
	}

	@Override
	public int getHeight() {

		if (this.root == null)
			return 0;
		return this.root.getHeight();
	}

	@Override
	public int size() {

		if (this.root == null)
			return 0;
		return this.root.getNumberNodes();
	}

	@Override
	public boolean isEmpty() {

		return (this.root == null);
	}

	@Override
	public void clear() {
		this.root = null;
	}

	@Override
	public boolean contains(E entry) throws TreeException {

		if (this.isEmpty())
			throw new TreeException("Tree is empty");

		return this.contains(entry, this.root);
	}

	private boolean contains(E entry, BSTreeNode<E> node) {
		if (node == null)
			return false;

		if (entry.compareTo(node.getElement()) < 0)
			return contains(entry, node.getLeft());
		else if (entry.compareTo(node.getElement()) > 0)
			return contains(entry, node.getRight());
		else
			return true;
	}

	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {

		if (this.isEmpty())
			throw new TreeException("Tree is empty");

		return this.search(entry, this.root);
	}

	private BSTreeNode<E> search(E entry, BSTreeNode<E> node) {
		if (node == null)
			return null;

		if (entry.compareTo(node.getElement()) < 0)
			return search(entry, node.getLeft());
		else if (entry.compareTo(node.getElement()) > 0)
			return search(entry, node.getRight());
		else
			return node;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {

		if (newEntry == null) {
			throw new NullPointerException("The element being added is null");
		}

		this.root = this.add(this.root, newEntry);
		return true;
	}

	private BSTreeNode<E> add(BSTreeNode<E> node, E newEntry) {

		if (node == null) {
			return new BSTreeNode<E>(newEntry);
		}

		if (newEntry.compareTo(node.getElement()) < 0) {
			node.setLeft(add(node.getLeft(), newEntry));
		} else if (newEntry.compareTo(node.getElement()) >= 0) {
			node.setRight(add(node.getRight(), newEntry));
		}

		return node;
	}

	@Override
	public Iterator<E> inorderIterator() {

		Stack<BSTreeNode<E>> travStack = new Stack<BSTreeNode<E>>();
		ArrayList<E> resultsList = new ArrayList<E>();
		BSTreeNode<E> curr = root;

		while (!travStack.isEmpty() || curr != null) {
			while (curr != null) { 
				travStack.push(curr);
				curr = curr.getLeft();
			}
			curr = travStack.pop();
			resultsList.add((E) curr.getElement());
			curr = curr.getRight();

		}

		return new Iterator<E>() {

			public int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < resultsList.size();
			}

			@Override
			public E next() throws NoSuchElementException {

				if (!hasNext())
					throw new NoSuchElementException("The iteration has no more elements");

				return resultsList.get(currentIndex++);
			}
			
		};
	}

	@Override
	public Iterator<E> preorderIterator() {

		Stack<BSTreeNode<E>> travStack = new Stack<BSTreeNode<E>>();
		ArrayList<E> resultsList = new ArrayList<E>();

		if (!this.isEmpty()) {
			travStack.push(this.root);
		}

		while (!travStack.isEmpty()) {
			BSTreeNode<E> node = travStack.pop();
			if (node.getRight() != null)
				travStack.push(node.getRight());
			if (node.getLeft() != null)
				travStack.push(node.getLeft());
			resultsList.add(node.getElement());
		}

		return new Iterator<E>() {

			public int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < resultsList.size();
			}

			@Override
			public E next() throws NoSuchElementException {

				if (!hasNext())
					throw new NoSuchElementException("The iteration has no more elements");

				return resultsList.get(currentIndex++);
			}
		};
	}

	@Override
	public Iterator<E> postorderIterator() {

		Stack<BSTreeNode<E>> travStack = new Stack<BSTreeNode<E>>();
		ArrayList<E> resultsList = new ArrayList<E>();

		if (!this.isEmpty()) {
			travStack.push(this.root);
		}

		while (!travStack.isEmpty()) {
			BSTreeNode<E> current = travStack.peek();
			if (current.isLeaf()) {
				BSTreeNode<E> node = travStack.pop();
				resultsList.add((E) node.getElement());
			} else {
				if (current.getRight() != null) {
					travStack.push(current.getRight());
					current.setRight(null);
				}
				if (current.getLeft() != null) {
					travStack.push(current.getLeft());
					current.setLeft(null);
				}
			}
		}

		return new Iterator<E>() {

			public int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < resultsList.size();
			}

			@Override
			public E next() throws NoSuchElementException {

				if (!hasNext())
					throw new NoSuchElementException("The iteration has no more elements");

				return resultsList.get(currentIndex++);
			}
		};
	}

}
