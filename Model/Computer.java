import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {

    public Computer() {
        super();
    }

    /**
     * Fill pokemon bag
     */
    public void fillPokemonBag() {
        ArrayList<Pokemon> pokemons = Pokemon.readFile();
        Main.mix(pokemons);

        for(int i = 0; i < 4; ++i) {
            pokemonBag.add(pokemons.get(i));
        }
    }

    /**
     * Fill potion bag
     */
    public void fillPotionBag() {
        ArrayList<Items> potions = Items.readFile();
        Main.mix(potions);

        for(int i = 0; i < 4; ++i) {
            potionBag.add(potions.get(i));
        }
    }

    
    /** 
     * @param currentPokemon
     */
    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    
    /** 
     * @return Pokemon
     */
    public Pokemon getCurrentPokemon() {
        return this.currentPokemon;
    }

    /**
     * Randomly select pokemon
     */
    public void selectPokemon() {
        int randomIndex = (int) (Math.random() * this.pokemonBag.size());
        this.currentPokemon = this.pokemonBag.get(randomIndex);
    }

    /**
     * Randomly select move of current pokemon
     */
    public Move selectMove() {
        Random rand = new Random();
        Move move = getCurrentPokemon().getMoves()[rand.nextInt(getCurrentPokemon().getMoves().length)];
        return move;
    }

    
    /** 
     * Check if item for status is available
     * @param pokemon
     * @param potionBag
     * @return boolean
     */
    public boolean hasItemForStatus(Pokemon pokemon, ArrayList<Items> potionBag) {
        for(Items i : potionBag) {
            if(i.getHealing().equals(pokemon.getStatus().getCurrentStatus())) return true;
        }
        return false;
    }
}
