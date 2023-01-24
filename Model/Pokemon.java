import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
	private int number;
	private String name;
	private String type;
	private int attack;
	private int defense;
	private int health;
	private Move[] moves;
	private Status status;
	private String img;

	public Pokemon(int number, String name, String type, int health, int attack, int defense) {
		this.number = number;
		this.name = name;
		this.type = type;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.moves = new Move[4];
		this.moves = getPokemonMoves();
	}


	public static ArrayList<Pokemon> readFile() {
		ArrayList<Pokemon> pokemonInfo = new ArrayList<>();
		
		try {
			File file = new File("Pokemon/Assets/pokemon.csv");
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String[] temp = line.split(",");
				pokemonInfo.add(new Pokemon(Integer.valueOf(temp[0]), temp[1], temp[2], Integer.valueOf(temp[3]), Integer.valueOf(temp[4]), Integer.valueOf(temp[5])));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		return pokemonInfo;
	}


	public Move[] getPokemonMoves() {
		ArrayList<Move> moves = Move.readFile();
		Move[] pokemonMoves = new Move[4];
		for(int i = 0; i < 4; ++i) {
			pokemonMoves[i] = moves.get(i);
		}
		return pokemonMoves;
	}

	public void attack(Pokemon target, Move move) {

	}

	public void takeDmg(int dmg) {
		
	}

	public static Pokemon valueOf(String name) {
		ArrayList<Pokemon> poks = readFile();
		for(Pokemon p : poks) {
			if(p.getName().equals(name));
			return p;
		}
		return null;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public int getDefense() {
		return defense;
	}


	public void setDefense(int defense) {
		this.defense = defense;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public Move[] getMoves() {
		return moves;
	}


	public void setMoves(Move[] moves) {
		this.moves = moves;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
}