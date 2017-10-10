package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void TestEmptyDeck() {

		Deck d = new Deck();
		for (int x = 1; x <= 52; x++) {
			thrown.expect(IndexOutOfBoundsException.class);
			d.Draw();
			System.out.println("card number " + x);
		}
	}
	
	@Test
	public void TestDrawSuit() {
		Deck d = new Deck();
		for (int x = 1; x <= 13; x++) {
			assertEquals(d.Draw(eSuit.CLUBS).geteSuit(), new Card(eSuit.CLUBS, eRank.THREE).geteSuit());
		}
	}
	
	@Test
	public void TestDrawRank() {
		Deck d = new Deck();
		for (int x = 1; x <= 4; x++) {
			assertEquals(d.Draw(eRank.THREE).geteRank(), new Card(eSuit.CLUBS, eRank.THREE).geteRank());
		}
	}
	
	public void TestDeckRankCount() {
		Deck d = new Deck();
		for (int x = 4; x > 0; x--) {
			assertEquals(d.Count(eRank.THREE), x);
			d.Draw(eRank.THREE);
		}
	}
	
	public void TestDeckSuitCount() {
		Deck d = new Deck();
		for (int x = 13; x > 0; x--) {
			assertEquals(d.Count(eSuit.CLUBS), x);
			d.Draw(eSuit.CLUBS);
		}
	}

}
