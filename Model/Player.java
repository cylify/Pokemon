import java.util.ArrayList;
import java.util.Random;

public abstract class Player {
    protected ArrayList<Pokemon> pokemonBag;
    protected ArrayList<Items> potionBag;
    protected Pokemon currentPokemon;
    protected Pokemon defendingPokemon;
    protected Multiplier multiplier;

    public Player() {
        this.multiplier = new Multiplier();
        this.pokemonBag = new ArrayList<>();
        this.potionBag = new ArrayList<>();
        fillPokemonBag();
        fillPotionBag();
        this.currentPokemon = pokemonBag.get(0);
    }

    public abstract void fillPokemonBag();

    public abstract void fillPotionBag();


    public void removePotion(ArrayList<Items> potions, Status status) {
        for(Items item : potions) {
            if(item.getName().equals(status.getCurrentStatus())) {
                potions.remove(item);
            }
        }
    }

    
    /** 
     * @param move
     * @param attacker
     * @param defender
     * @return int
     */
    public int dmgOfMove(Move move, Pokemon attacker, Pokemon defender) {
        int dmg = (int)((((2.0 * move.getDmg() * ((Double.valueOf(attacker.getAttack())/Double.valueOf(defender.getDefense()))/50.0)))
                + 2.0) * Multiplier.getMultiplier(attacker, defender) * 5.0);
                
        return dmg;
    }

    
    /** 
     * @param move
     * @param defender
     */
    public void inflictsStatus(Move move, Pokemon defender) {
        Random rand = new Random();
        for(SpecialMoves specialMove : SpecialMoves.readFile()) {
            if (specialMove.getName().equals(move.getName())) {
                if (rand.nextInt(0, 4) == 0)
                    defender.setStatus(new Status(specialMove.getStatus()));
                else
                    defender.setStatus(new Status("Normal"));
            }
        }
    }

    
    /** 
     * @param move
     * @param attacker
     * @param defender
     */
    public void attack(Move move, Pokemon attacker, Pokemon defender) {
        int dmg = dmgOfMove(move, attacker, defender);
        defender.setCurrentHp(defender.getCurrentHp() - dmg);
        inflictsStatus(move, defender);
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
     * @param defendingPokemon
     */
    public void setDefendingPokemon(Pokemon defendingPokemon) {
        this.defendingPokemon = defendingPokemon;
    }

    
    /** 
     * @return Pokemon
     */
    public Pokemon getDefendingPokemon() {
        return this.defendingPokemon;
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