import java.util.ArrayList;
import java.util.Random;

public abstract class Player {
    protected ArrayList<Pokemon> pokemonBag;
    protected ArrayList<Items> potionBag;
    protected Pokemon currentPokemon;
    protected Pokemon defendingPokemon;

    public Player() {
        this.pokemonBag = new ArrayList<>();
        this.potionBag = new ArrayList<>();
        fillPokemonBag();
        fillPotionBag();
        this.currentPokemon = pokemonBag.get(0);
    }

    public abstract void fillPokemonBag();

    public abstract void fillPotionBag();

    public int dmgOfMove(Move move, Pokemon attacker, Pokemon defender) {
        int dmg = (int) (2 * Double.valueOf(move.getDmg()) * ((Double.valueOf(attacker.getAttack()) /
                Double.valueOf(defender.getDefense())) / 50.0 + 2.0)
                * Multiplier.getMultiplier(attacker, defender) * 5.0);
        return dmg;
    }

    public void inflictsStatus(Move move, Pokemon defender) {
        Random rand = new Random();
        for (SpecialMoves specialMove : SpecialMoves.readFile()) {
            if (specialMove.getName().equals(move.getName())) {
                if (rand.nextInt(0, 4) == 0)
                    defender.setStatus(new Status(specialMove.getStatus()));
                else
                    defender.setStatus(new Status("Normal"));
            }
        }
    }

    public void attack(Move move, Pokemon attacker, Pokemon defender) {
        int dmg = dmgOfMove(move, attacker, defender);
        defender.setCurrentHp(defender.getCurrentHp() - dmg);
        inflictsStatus(move, defender);
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