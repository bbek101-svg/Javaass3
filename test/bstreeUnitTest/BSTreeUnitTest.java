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
import utilities.Iterator;

import static org.junit.Assert.*;

/**
 * @author Asiyah Sakr
 *
 */
public class BSTreeUnitTest {

	//
	BSTReferencedBased<Integer> myBST;
	private Integer a;
	private Integer b;
	private Integer c;
	private Integer d;
	private Integer e;
	private Integer f;
	private Integer g;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		myBST =  new BSTReferencedBased<Integer>();
		a = 41;
		b = 65;
		c = 20;
		d = 50;
		e = 91;
		f = 29;
		g = 11;
	}

	/**
	 * @throws Exception
	 */
	@After
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
		assertTrue(myBST.add(a));
		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));

		assertEquals(a, myBST.getRoot().getElement());
		assertNotEquals("41", myBST.getRoot().getElement());
		assertNotEquals(null, myBST.getRoot().getElement());

	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	public void testGetHeight() {

		assertEquals(0, myBST.getHeight());

		assertTrue(myBST.add(a));
		assertEquals(1, myBST.getHeight());

		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));
		assertEquals(2, myBST.getHeight());

		assertTrue(myBST.add(d));
		assertTrue(myBST.add(e));
		assertTrue(myBST.add(f));
		assertTrue(myBST.add(g));
		assertEquals(3, myBST.getHeight());

	}

	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	public void testSize() {

		assertEquals(0, myBST.size());

		assertTrue(myBST.add(a));
		assertEquals(1, myBST.size());

		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));
		assertEquals(3, myBST.size());

		assertTrue(myBST.add(d));
		assertTrue(myBST.add(e));
		assertTrue(myBST.add(f));
		assertTrue(myBST.add(g));
		assertEquals(7, myBST.size());

	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {

		assertTrue(myBST.isEmpty());

		assertTrue(myBST.add(a));
		assertFalse(myBST.isEmpty());

	}

	/**
	 * Test method for {@link utilities.BSTree#clear()}.
	 */
	@Test
	public void testClear() {

		assertTrue(myBST.add(a));
		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));

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

		assertThrows(TreeException.class, () -> myBST.contains(a));
		myBST.add(a);
		assertEquals(true, myBST.contains(a));
		assertEquals(false, myBST.contains(b));

	}

	/**
	 * Test method for {@link utilities.BSTree#search(Comparable)}.
	 * 
	 * @throws TreeException
	 */
	@Test
	public void testSearch() throws TreeException {

		assertThrows(TreeException.class, () -> myBST.search(a).getElement());

		assertTrue(myBST.add(a));
		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));

		assertEquals(a, myBST.search(a).getElement());
		assertNotEquals(b, myBST.search(a).getElement());
		assertNotEquals(null, myBST.search(a).getElement());
	}

	/**
	 * Test method for {@link utilities.BSTree#add(Comparable)}.
	 */
	@Test
	public void testAdd() {
		// Expected Values
		assertTrue(this.myBST.add(a));
		assertTrue(this.myBST.add(b));
		assertTrue(this.myBST.add(c));
	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	public void testInorderIterator() {
		
		assertTrue(myBST.add(a));
		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));

		Iterator<Integer> it = myBST.inorderIterator();
		assertEquals(c, it.next());
		assertEquals(a, it.next());
		assertEquals(b, it.next());
		assertFalse(it.hasNext());

	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	public void testPreorderIterator() {

		assertTrue(myBST.add(a));
		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));

		Iterator<Integer> it = myBST.preorderIterator();
		assertTrue(it.hasNext());
		assertEquals(a, it.next());
		assertEquals(c, it.next());
		assertEquals(b, it.next());
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	public void testPostorderIterator() {

		assertTrue(myBST.add(a));
		assertTrue(myBST.add(b));
		assertTrue(myBST.add(c));

		Iterator<Integer> it = myBST.postorderIterator();
		assertEquals(c, it.next());
		assertEquals(b, it.next());
		assertEquals(a, it.next());
		assertFalse(it.hasNext());

	}

}
