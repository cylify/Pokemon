import java.util.ArrayList;

public class Computer {
    private ArrayList<Pokemon> pokemonBag;
    private Pokemon currentPokemon;
    private ArrayList<Items> potionBag;

    public Computer() {
        this.pokemonBag = new ArrayList<>();
        this.potionBag = new ArrayList<>();
        fillPokemonBag();
        fillPotionBag();
    }

    public void fillPokemonBag() {
        ArrayList<Pokemon> pokemons = Pokemon.readFile();
        Main.mix(pokemons);

        for(int i = 0; i < 4; ++i) {
            pokemonBag.add(pokemons.get(i));
        }
    }

    public void fillPotionBag() {
        ArrayList<Items> potions = Items.readFile();
        Main.mix(potions);

        for(int i = 0; i < 4; ++i) {
            potionBag.add(potions.get(i));
        }
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public Pokemon getCurrentPokemon() {
        return this.currentPokemon;
    }

    public void selectPokemon() {
        // Code to randomly select a Pokemon from the computer player's bag
        int randomIndex = (int) (Math.random() * this.pokemonBag.size());
        this.currentPokemon = this.pokemonBag.get(randomIndex);
    }

    public Move selectMove() {
        // Code to randomly select a move from the computer player's current Pokemon
        Move[] moves = this.currentPokemon.getMoves();
        int randomIndex = (int) (Math.random() * moves.length);
        return moves[randomIndex];
    }

    public void attack(Player player) {
        // Code to make the computer player's current Pokemon attack the player's
        // defending Pokemon
        Move move = selectMove();
        this.currentPokemon.attack(move, this.currentPokemon, player.getDefendingPokemon());
    }
}
