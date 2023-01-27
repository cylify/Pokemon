import java.util.ArrayList;
import java.util.Random;

public class HumanPlayer extends Player {
    /**
     * Constructer
     */
    public HumanPlayer() {
        super();
    }

    /**
     * Fill pokemon bag
     */
    public void fillPokemonBag() {
        ArrayList<Pokemon> pokemons = Pokemon.readFile();
        Main.mix(pokemons);

        for (int i = 0; i < 4; ++i) {
            pokemonBag.add(pokemons.get(i));
        }
    }

    /**
     * Fill potion bag
     */
    public void fillPotionBag() {
        ArrayList<Items> potions = Items.readFile();
        Main.mix(potions);

        for (int i = 0; i < potions.size(); ++i) {
            potionBag.add(potions.get(i));
        }
    }

    
    /**
     * Get the damage of a move
     * 
     * @param move
     * @param attacker
     * @param defender
     * @return int
     */
    public int dmgOfMove(Move move, Pokemon attacker, Pokemon defender) {
        int dmg = (int) ((((2 * Double.valueOf(move.getDmg()) * ((Double.valueOf(attacker.getAttack()) /
                Double.valueOf(defender.getDefense())) / 50.0)) + 2.0))
                * Multiplier.getMultiplier(attacker, defender) * 5.0);

        return dmg;
    }


	
    /** 
     * Checks if move has status effect
     * @param move
     * @return boolean
     */
    public boolean isInflictable(Move move) {
		for(SpecialMoves specialMove : SpecialMoves.readFile()) {
			if(specialMove.getName().equals(move.getName())) {
				return true;
			}
		}
		return false;
	}

    
    /** 
     * Sets special move status
     * @param move
     * @param defender
     */
    public void inflictsStatus(Move move, Pokemon defender) {
        Random rand = new Random();
        // Go through all special moves in special moves file
        for(SpecialMoves specialMove : SpecialMoves.readFile()) {
            // Apply status if it is a special move and hits special chance
            if(specialMove.getName().equals(move.getName())) {
                if(rand.nextInt(1, 101) < specialMove.getChance())
                    defender.setStatus(new Status(specialMove.getStatus()));
                else
                    defender.setStatus(new Status("Normal"));
            }
        }
    }

    
    /** 
     * Attack computer with move
     * @param computerPlayer
     * @param move
     */
    public void attack(Computer computerPlayer, Move move) {
        int damage = dmgOfMove(move, currentPokemon, computerPlayer.getCurrentPokemon());
        computerPlayer.getCurrentPokemon().setCurrentHp(computerPlayer.getCurrentPokemon().getCurrentHp() - damage);
        if(isInflictable(move))
			inflictsStatus(move, computerPlayer.getCurrentPokemon());
    }

    
    /** 
     * Checks if all pokemons are feinted
     * @return boolean
     */
    public boolean allPokemonFeinted() {
        for (Pokemon pokemon : pokemonBag) {
            if (!pokemon.isFeinted()) {
                return false;
            }
        }
        return true;
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
     * @return ArrayList<Pokemon>
     */
    public ArrayList<Pokemon> getPokemonBag() {
        return pokemonBag;
    }

    
    /** 
     * @param pokemonBag
     */
    public void setPokemonBag(ArrayList<Pokemon> pokemonBag) {
        this.pokemonBag = pokemonBag;
    }

    
    /** 
     * @return ArrayList<Items>
     */
    public ArrayList<Items> getPotionBag() {
        return potionBag;
    }

    
    /** 
     * @param potionBag
     */
    public void setPotionBag(ArrayList<Items> potionBag) {
        this.potionBag = potionBag;
    }
}
