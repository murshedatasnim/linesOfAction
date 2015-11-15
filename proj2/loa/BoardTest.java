package loa;

import static loa.Piece.BP;
import static loa.Piece.EMP;
import static loa.Piece.WP;
import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testInitialize() {
		
		Board b = new Board();
		assertEquals(true, b.equals(new Board()));
		
		Board b2 = new Board(Board.INITIAL_PIECES, WP);
		assertEquals(false, b2.equals(new Board()));
		
		Board b3 = new Board(Board.INITIAL_PIECES, BP);
		assertEquals(true, b3.equals(new Board()));
		
		Piece[][] p1 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Board b4 = new Board(Board.INITIAL_PIECES, BP);
		Board b5 = new Board(b4);
		assertEquals(true, b4.equals(b5));	
	}
	
	@Test
	public void testEquals() {
		
		Piece[][] p1 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP,  EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP,  EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Piece[][] p2 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  WP,  EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP,  EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP,  EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Piece[][] p3 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, WP,  EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP,  EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP,  EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Board a = new Board(p1, WP);
		Board b = new Board(p2, WP);
		Board c = new Board(p3, WP);

		Board a2 = new Board(p1, BP);
		Board b2 = new Board(p2, BP);
		Board c2 = new Board(p3, BP);
		
		assertEquals(false, a.equals(b));
		assertEquals(false, b.equals(c));
		assertEquals(true, a.equals(a));
		assertEquals(true, b.equals(b));
		assertEquals(true, c.equals(c));
		
		assertEquals(false, a2.equals(a));
		assertEquals(false, b2.equals(b));
		assertEquals(false, c2.equals(c));
		assertEquals(true, a2.equals(a2));
		assertEquals(true, b2.equals(b2));
		assertEquals(true, c2.equals(c2));
	}
	
	@Test
	public void testSet() {
		
		Piece[][] p1 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP,  EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP,  EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Piece[][] p2 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  WP,  EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP,  EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP,  EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Piece[][] p3 = {
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP },
		        { WP,  EMP, EMP, EMP, WP, EMP, EMP, WP  },
		        { WP,  EMP, WP,  EMP, EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, BP,  EMP, EMP, EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { WP,  BP,	EMP, EMP, EMP, BP,  EMP, WP  },
		        { WP,  EMP, EMP, EMP, EMP, EMP, EMP, WP  },
		        { EMP, BP,  BP,  BP,  BP,  BP,  BP,  EMP }
			};
		
		Board a = new Board(p1, WP);
		
		Board b = new Board(p2, WP);
		Board bt = new Board(a);
		bt.set(2, 2, WP);
		
		Board c = new Board(p3, WP);
		Board ct = new Board(b);
		ct.set(2, 2, EMP);
		ct.set(3, 3, WP);
		ct.set(5, 2, WP);
		

		Board b2 = new Board(p2, BP);
		Board b2t = new Board(a);
		b2t.set(2, 2, WP, BP);
		Board c2 = new Board(p3, BP);
		Board c2t = new Board(b);
		c2t.set(2, 2, EMP);
		c2t.set(5, 2, WP);
		c2t.set(3, 3, WP, BP);
		
		assertEquals(false, a.equals(bt));
		assertEquals(false, bt.equals(ct));
		
		assertEquals(true, b.equals(bt));
		assertEquals(true, c.equals(ct));

		assertEquals(true, b2.equals(b2t));
		assertEquals(true, c2.equals(c2t));
		
		assertEquals(false, bt.equals(b2t));
		assertEquals(false, ct.equals(c2t));
	}
	
	@Test
	public void testColCount() {
		
		Board b = new Board();
		int[] colCount = new int[]{6, 2, 2, 2, 2, 2, 2, 6}; 
		for(int c = 1; c <= Board.M; c++) {
			assertEquals(colCount[c - 1], b.colCount(c));
		}
		
		Board c = new Board(b);
		c.set(1, 5, BP);
		c.set(2, 2, WP);
		c.set(3, 6, BP);
		c.set(4, 1, EMP);
		c.set(5, 3, WP);
		c.set(6, 8, EMP);
		c.set(7, 4, BP);
		c.set(8, 7, EMP);
		System.out.println(c);
		int[] colCount2 = new int[]{6, 3, 3, 1, 3, 1, 3, 5}; 
		for(int col = 1; col <= Board.M; col++) {
			assertEquals(colCount2[col - 1], c.colCount(col));
		}
	}
	
	@Test
	public void testRowCount() {
		
		Board b = new Board();
		int[] rowCount = new int[]{6, 2, 2, 2, 2, 2, 2, 6}; 
		for(int c = 1; c <= Board.M; c++) {
			assertEquals(rowCount[c - 1], b.rowCount(c));
		}
		
		Board c = new Board(b);
		c.set(1, 5, BP);
		c.set(2, 2, WP);
		c.set(3, 6, BP);
		c.set(4, 1, EMP);
		c.set(5, 3, WP);
		c.set(6, 8, EMP);
		c.set(7, 4, BP);
		c.set(8, 7, EMP);
		int[] rowCount2 = new int[]{5, 3, 3, 3, 2, 3, 1, 5}; 
		for(int row = 1; row <= Board.M; row++) {
			assertEquals(rowCount2[row - 1], c.rowCount(row));
		}
	}
	
	@Test
	public void testMajDiaCount() {
		
		Board b = new Board();
		int[][] majDiaCount = new int[][]{{0, 2, 2, 2, 2, 2, 2, 0}, // notice it's upside down
										  {2, 0, 2, 2, 2, 2, 2, 2},
										  {2, 2, 0, 2, 2, 2, 2, 2},
										  {2, 2, 2, 0, 2, 2, 2, 2},
										  {2, 2, 2, 2, 0, 2, 2, 2},
										  {2, 2, 2, 2, 2, 0, 2, 2},
										  {2, 2, 2, 2, 2, 2, 0, 2},
										  {0, 2, 2, 2, 2, 2, 2, 0}}; 
		for(int c = 1; c <= Board.M; c++) {
			for(int r = 1; r <= Board. M; r++) {
				System.out.println("step at " + c + " " + r);
				assertEquals(majDiaCount[r - 1][c - 1], b.majDiaCount(c, r));
			}
		}
		
		Board c = new Board(b);
		c.set(1, 5, BP);
		c.set(2, 2, WP);
		c.set(3, 6, BP);
		c.set(4, 1, EMP);
		c.set(5, 3, WP);
		c.set(6, 8, EMP);
		c.set(7, 4, BP);
		c.set(8, 7, EMP);
		System.out.println(c);
		int[][] majDiaCount2 = new int[][]{{1, 1, 3, 2, 2, 2, 2, 0}, // notice it's upside down
			  							   {2, 1, 1, 3, 2, 2, 2, 2},
			  							   {1, 2, 1, 1, 3, 2, 2, 2},
			  							   {3, 1, 2, 1, 1, 3, 2, 2},
			  							   {2, 3, 1, 2, 1, 1, 3, 2},
			  							   {2, 2, 3, 1, 2, 1, 1, 3},
			  							   {2, 2, 2, 3, 1, 2, 1, 1},
			  							   {0, 2, 2, 2, 3, 1, 2, 1}}; 
		for(int c2 = 1; c2 <= Board.M; c2++) {
			for(int r = 1; r <= Board. M; r++) {
				System.out.println("step at " + c2 + " " + r);
				assertEquals(majDiaCount2[r - 1][c2 - 1], c.majDiaCount(c2, r));
			}
		}
	}
	
	@Test
	public void testMinDiaCount() {
		
		Board b = new Board();
		int[][] minDiaCount = new int[][]{{0, 2, 2, 2, 2, 2, 2, 0}, // notice it's upside down
										  {2, 2, 2, 2, 2, 2, 0, 2},
										  {2, 2, 2, 2, 2, 0, 2, 2},
										  {2, 2, 2, 2, 0, 2, 2, 2},
										  {2, 2, 2, 0, 2, 2, 2, 2},
										  {2, 2, 0, 2, 2, 2, 2, 2},
										  {2, 0, 2, 2, 2, 2, 2, 2},
										  {0, 2, 2, 2, 2, 2, 2, 0}}; 
		for(int c = 1; c <= Board.M; c++) {
			for(int r = 1; r <= Board. M; r++) {
				System.out.println("step at " + c + " " + r);
				assertEquals(minDiaCount[r - 1][c - 1], b.minDiaCount(c, r));
			}
		}
		
		Board c = new Board(b);
		c.set(1, 5, BP);
		c.set(2, 2, WP);
		c.set(3, 6, BP);
		c.set(4, 1, EMP);
		c.set(5, 3, WP);
		c.set(6, 8, EMP);
		c.set(7, 4, BP);
		c.set(8, 7, EMP);
		System.out.println(c);
		int[][] minDiaCount2 = new int[][]{{0, 2, 3, 1, 2, 2, 3, 1}, // notice it's upside down
			  							   {2, 3, 1, 2, 2, 3, 1, 2},
			  							   {3, 1, 2, 2, 3, 1, 2, 3},
			  							   {1, 2, 2, 3, 1, 2, 3, 2},
			  							   {2, 2, 3, 1, 2, 3, 2, 2},
			  							   {2, 3, 1, 2, 3, 2, 2, 1},
			  							   {3, 1, 2, 3, 2, 2, 1, 1},
			  							   {1, 2, 3, 2, 2, 1, 1, 0}}; 
		for(int c2 = 1; c2 <= Board.M; c2++) {
			for(int r = 1; r <= Board. M; r++) {
				System.out.println("step at " + c2 + " " + r);
				assertEquals(minDiaCount2[r - 1][c2 - 1], c.minDiaCount(c2, r));
			}
		}
	}

	
	public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(BoardTest.class));
    }
}