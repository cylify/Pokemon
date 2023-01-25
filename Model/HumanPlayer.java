import java.util.ArrayList;
import java.util.Random;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        super();
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

    public int dmgOfMove(Move move, Pokemon attacker, Pokemon defender) {
        int dmg = (int) (2 * Double.valueOf(move.getDmg()) * ((Double.valueOf(attacker.getAttack()) /
                Double.valueOf(defender.getDefense())) / 50.0 + 2.0)
                * Multiplier.getMultiplier(attacker, defender) * 5.0);
        return dmg;
    }


    public void inflictsStatus(Move move, Pokemon defender) {
        Random rand = new Random();
        for(SpecialMoves specialMove : SpecialMoves.readFile()) {
            if(specialMove.getName().equals(move.getName())) {
                if(rand.nextInt(0, 4) == 0)
                    defender.setStatus(new Status(specialMove.getStatus()));
                else
                    defender.setStatus(new Status("Normal"));
            }
        }
    }

    public void attack(Computer computerPlayer, Move move) {
        int damage = dmgOfMove(move, currentPokemon, computerPlayer.getCurrentPokemon());
        computerPlayer.getCurrentPokemon().setCurrentHp(computerPlayer.getCurrentPokemon().getCurrentHp() - damage);
        inflictsStatus(move, computerPlayer.getCurrentPokemon());
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public Pokemon getCurrentPokemon() {
        return this.currentPokemon;
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
