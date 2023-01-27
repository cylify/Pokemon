import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {

    /**
     * Constructer
     */
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

        for(int i = 0; i < potions.size(); ++i) {
            potionBag.add(potions.get(i));
        }
    }


    
    /** 
     * Play computer turn
     * 
     * @param defender
     */
    public void playComp(Pokemon defender) {
        Random rand = new Random();
        int random = rand.nextInt(2);

        // if current pokemon is feinted
        if(getCurrentPokemon().isFeinted()) {
            // Switch to unfeinted pokemon
            checkFeintedPokemon();
            Main.checkWinner();
        } else if(getCurrentPokemon().getStatus().getCurrentStatus().equals("Normal")) {
            // Randomly play move or switch pokemon
            if(random == 0) {
                playMoveTurn(selectMove(), defender);
                Main.checkWinner();
            } else {
                selectPokemon();
                Main.checkWinner();
            }
        } else {
            // If has item for the current status then heal otherwise pokemon is not feinted and unusable
            if(hasItemForStatus(getCurrentPokemon(), getPotionBag())) {
                removePotion(getPotionBag(), getCurrentPokemon().getStatus());
                getCurrentPokemon().setStatus(new Status());
                Main.checkWinner();
            } else {
                getCurrentPokemon().setFeinted(true);
                Main.checkWinner();
            }
        }
    }

    
    /** 
     * Inflict status if applicable
     * @param move
     * @param defender
     */
    public void inflictsStatus(Move move, Pokemon defender) {
        Random rand = new Random();
        // Go through all special moves in special moves file
        for(SpecialMoves specialMove : SpecialMoves.readFile()) {
            // Apply status if it is a special move and hits special chance 
            if(specialMove.getName().equals(move.getName())) {
                if(rand.nextInt(1,101) < specialMove.getChance())
                    defender.setStatus(new Status(specialMove.getStatus()));
                else
                    defender.setStatus(new Status("Normal"));
            }
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
        Random rand = new Random();
        int num = rand.nextInt(pokemonBag.size());
        Pokemon tempPoke = pokemonBag.get(num);
        // Select pokemon until not current pokemon
        while(tempPoke != this.currentPokemon) {
            num = rand.nextInt(pokemonBag.size());
            tempPoke = pokemonBag.get(num);
            this.currentPokemon = tempPoke;
        }
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
     * 
     * @param move
     * @return boolean
     */
    public boolean isInflictable(Move move) {
        // If move is a special move
        for (SpecialMoves specialMove : SpecialMoves.readFile()) {
            if (specialMove.getName().equals(move.getName())) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * 
     * Get a random pokemon
     * 
     * @return Pokemon
     */
    public Pokemon getRandPokemon() {
        Random rand = new Random();
        return pokemonBag.get(rand.nextInt(pokemonBag.size()));
    }

    /**
     * Check if current pokemon is feinted then switch pokemon
     */
    public void checkFeintedPokemon() {
        if(this.currentPokemon.isFeinted()) {
            this.pokemonBag.remove(this.currentPokemon);
            if(!allPokemonFeinted())
                this.currentPokemon = this.pokemonBag.get(new Random().nextInt(this.pokemonBag.size()));
        }
    }

    
    /** 
     * Check if all pokemons are feinted
     * 
     * @return boolean
     */
    public boolean allPokemonFeinted() {
        for(Pokemon pokemon : pokemonBag) {
            if(!pokemon.isFeinted()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Attack human with move
     * 
     * @param humanPlayer
     * @param move
     */
    public void attack(HumanPlayer humanPlayer, Move move) {
        int damage = dmgOfMove(move, currentPokemon, humanPlayer.getCurrentPokemon());
        humanPlayer.getCurrentPokemon().setCurrentHp(humanPlayer.getCurrentPokemon().getCurrentHp() - damage);
        if(isInflictable(move))
            inflictsStatus(move, humanPlayer.getCurrentPokemon());
    }

    
    /** 
     * Play computer move turn
     * 
     * @param move
     * @param defender
     */
    public void playMoveTurn(Move move, Pokemon defender) {
        attack(move, getCurrentPokemon(), defender);
    }
}
