/**
 * 
 */
package bstreeUnitTest;
//package referenceBasedTreeImplementation;


import exceptions.TreeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import referenceBasedTreeImplementation.BSTReferencedBased;

import static org.junit.Assert.*;

/**
 * @author Asiyah Sakr
 *
 */
public class BSTreeUnitTest {

	//
	BSTReferencedBased myBST = new BSTReferencedBased();

	/**
	 * @throws Exception
	 */
	
	public void setUp() throws Exception {
		myBST = new BSTReferencedBased();
	}

	/**
	 * @throws Exception
	 */
	
	public void tearDown() throws Exception {
		myBST.clear();
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot()}.
	 * 
	 * @throws TreeException
	 */
	@Test
	public void testGetRoot() throws TreeException {

		assertThrows(TreeException.class, () -> myBST.getRoot().getElement());

		// Insert into the binary search tree
		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));

		assertEquals(41, myBST.getRoot().getElement());
		assertNotEquals("41", myBST.getRoot().getElement());
		assertNotEquals(null, myBST.getRoot().getElement());

	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	public void testGetHeight() {

		assertEquals(0, myBST.getHeight());

		assertTrue(myBST.add(41));
		assertEquals(1, myBST.getHeight());

		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));
		assertEquals(2, myBST.getHeight());

		assertTrue(myBST.add(50));
		assertTrue(myBST.add(91));
		assertTrue(myBST.add(29));
		assertTrue(myBST.add(11));
		assertEquals(3, myBST.getHeight());

	}

	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	public void testSize() {

		assertEquals(0, myBST.size());

		assertTrue(myBST.add(41));
		assertEquals(1, myBST.size());

		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));
		assertEquals(3, myBST.size());

		assertTrue(myBST.add(50));
		assertTrue(myBST.add(91));
		assertTrue(myBST.add(29));
		assertTrue(myBST.add(11));
		assertEquals(7, myBST.size());

	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {

		assertTrue(myBST.isEmpty());

		assertTrue(myBST.add(41));
		assertFalse(myBST.isEmpty());

	}

	/**
	 * Test method for {@link utilities.BSTree#clear()}.
	 */
	@Test
	public void testClear() {

		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));

		assertFalse(myBST.isEmpty());
		myBST.clear();
		assertTrue(myBST.isEmpty());
	}

	/**
	 * Test method for {@link utilities.BSTree#contains(Comparable)}.
	 * 
	 * @throws TreeException
	 */
	@Test
	public void testContains() throws TreeException {

		assertThrows(TreeException.class, () -> myBST.contains(1));
		myBST.add(1);
		assertEquals(true, myBST.contains(1));
		assertEquals(false, myBST.contains(2));

	}

	/**
	 * Test method for {@link utilities.BSTree#search(Comparable)}.
	 * 
	 * @throws TreeException
	 */
	@Test
	public void testSearch() throws TreeException {

		assertThrows(TreeException.class, () -> myBST.search(41).getElement());

		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));

		assertEquals(41, myBST.search(41).getElement());
		assertNotEquals("41", myBST.search(41).getElement());
		assertNotEquals(null, myBST.search(41).getElement());
	}

	/**
	 * Test method for {@link utilities.BSTree#add(Comparable)}.
	 */
	@Test
	public void testAdd() {
		// Expected Values
		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));
	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	public void testInorderIterator() {

		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));

		utilities.Iterator it = myBST.inorderIterator();
		assertEquals(20, it.next());
		assertEquals(41, it.next());
		assertEquals(65, it.next());
		assertFalse(it.hasNext());

	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	public void testPreorderIterator() {

		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));

		utilities.Iterator it = myBST.preorderIterator();
		assertEquals(41, it.next());
		assertEquals(20, it.next());
		assertEquals(65, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	public void testPostorderIterator() {

		assertTrue(myBST.add(41));
		assertTrue(myBST.add(65));
		assertTrue(myBST.add(20));

		utilities.Iterator it = myBST.postorderIterator();
		assertEquals(20, it.next());
		assertEquals(65, it.next());
		assertEquals(41, it.next());
		assertFalse(it.hasNext());

	}

}
