package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() {
		try {

			return cardsInDeck.remove(0);
		} catch (Exception e) {

			System.out.println("No Cards");
			throw e;
		}
	}

	public Card Draw(eSuit eSuit) {
		for (Card c: this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	public Card Draw(eRank eRank) {
		for (Card c: this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	public int Count(eSuit eSuit) {
		ArrayList<Card> cardsInSuit = cardsInDeck.stream().filter(type -> type.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInSuit.size();

	}

	public int Count(eRank eRank) {
		ArrayList<Card> cardsInRank = cardsInDeck.stream().filter(type -> type.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInRank.size();

	}

	public int FindCard(Card c) {
		for (Card crds:cardsInDeck)
		{
			if (crds == c)
				return 1;
		}
		return 0;
	}
}

