import java.util.ArrayList;

public class Player {
	private ArrayList<Pokemon> pokemonBag;
	private ArrayList<Items> potionBag;
	private Pokemon currentPokemon;
	private Pokemon defendingPokemon;

	public Player() {
		this.pokemonBag = new ArrayList<>();
		this.potionBag = new ArrayList<>();
		fillPokemonBag();
		fillPotionBag();
		this.currentPokemon = pokemonBag.get(0);
	}

	public void fillPokemonBag() {
		ArrayList<Pokemon> pokemons = Pokemon.readFile();
		Main.mix(pokemons);

		for (int i = 0; i < 4; ++i) {
			pokemonBag.add(pokemons.get(i));
		}
	}

	public void fillPotionBag() {
		ArrayList<Items> potions = Items.readFile();
		Main.mix(potions);

		for (int i = 0; i < 4; ++i) {
			potionBag.add(potions.get(i));
		}
	}

	public void setCurrentPokemon(Pokemon currentPokemon) {
		this.currentPokemon = currentPokemon;
	}

	public Pokemon getCurrentPokemon() {
		return this.currentPokemon;
	}

	public void setDefendingPokemon(Pokemon defendingPokemon) {
		this.defendingPokemon = defendingPokemon;
	}

	public Pokemon getDefendingPokemon() {
		return this.defendingPokemon;
	}

	public void selectPokemon() {
		// Code to allow the player to select a Pokemon from their bag
	}

	// public Move selectMove() {
	// 	// Code to allow the player to select a move from their current Pokemon
	// }

	public void attack(Computer computerPlayer) {
		// Code to make the player's current Pokemon attack the computer player's
		// current Pokemon
	}

	public ArrayList<Pokemon> getPokemonBag() {
		return pokemonBag;
	}

	public void setPokemonBag(ArrayList<Pokemon> pokemonBag) {
		this.pokemonBag = pokemonBag;
	}

	public ArrayList<Items> getPotionBag() {
		return potionBag;
	}

	public void setPotionBag(ArrayList<Items> potionBag) {
		this.potionBag = potionBag;
	}
}
