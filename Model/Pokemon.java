import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pokemon {
	private int number;
	private String name;
	private String type;
	private int attack;
	private int defense;
	private int health;
	private int currentHp;
	private Move[] moves;
	private Status status;
	private String Backimg;
	private String Frontimg;
	private boolean isFeinted;

	public Pokemon(int number, String name, String type, int health, int attack, int defense, String Backimg, 
			String Frontimg) {
		this.number = number;
		this.name = name;
		this.type = type;
		this.health = health;
		this.currentHp = health;
		this.attack = attack;
		this.defense = defense;
		this.moves = new Move[4];
		this.moves = getPokemonMoves();
		this.Backimg = Backimg;
		this.Frontimg = Frontimg;
		this.isFeinted = false;
		this.status = new Status();
	}


	
	/** 
	 * Read file
	 * @return ArrayList<Pokemon>
	 */
	public static ArrayList<Pokemon> readFile() {
		ArrayList<Pokemon> pokemonInfo = new ArrayList<>();
		Path filePath = Paths.get("Assets/", "pokemon.csv");
		String filePathAsString = filePath.toString();
		try {
			File file = new File(filePathAsString);
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String[] temp = line.split(",");
				Path frontImg = Paths.get("Assets/front", String.valueOf(temp[0]) + ".png");
				Path backImg = Paths.get("Assets/back", String.valueOf(temp[0]) + ".png");
				String stringfrontImg = frontImg.toString();
				String stringbackImg = backImg.toString();
				pokemonInfo.add(new Pokemon(Integer.valueOf(temp[0]), temp[1], temp[2], Integer.valueOf(temp[3]), 
				Integer.valueOf(temp[4]), Integer.valueOf(temp[5]), 
						stringbackImg, 
						stringfrontImg));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		return pokemonInfo;
	}


	
	/** 
	 * Get all moves for pokemon
	 * @return Move[]
	 */
	public Move[] getPokemonMoves() {
		ArrayList<Move> moves = Move.readFile();
		Move[] pokemonMoves = new Move[4];
		for(int i = 0; i < 4; ++i) {
			pokemonMoves[i] = moves.get(i);
		}
		return pokemonMoves;
	}


	/**
	 * Check if current hp is below or equal to 0, if so pokemon is feinted
	 */
	public void checkCurrenthp() {
		if(this.currentHp <= 0) {
			this.isFeinted = true;
		}
	}

	
	/** 
	 * Get number for pokemon type
	 * @param type
	 * @return Integer
	 */
	public static Integer toInteger(String type) {
		if(type.equals("Normal")) {
			return 0;
		} else if (type.equals("Fighting")) {
			return 1;
		} else if (type.equals("Flying")) {
			return 2;
		} else if (type.equals("Poison")) {
			return 3;
		} else if (type.equals("Ground")) {
			return 4;
		} else if (type.equals("Rock")) {
			return 5;
		} else if (type.equals("Bug")) {
			return 6;
		} else if (type.equals("Ghost")) {
			return 7;
		} else if (type.equals("Steel")) {
			return 8;
		} else if (type.equals("Fire")) {
			return 9;
		} else if (type.equals("Water")) {
			return 10;
		} else if (type.equals("Grass")) {
			return 11;
		} else if (type.equals("Electric")) {
			return 12;
		} else if (type.equals("Psychic")) {
			return 13;
		} else if (type.equals("Ice")) {
			return 14;
		} else if (type.equals("Dragon")) {
			return 15;
		} else if (type.equals("Dark")) {
			return 16;
		} else if (type.equals("Fairy")) {
			return 17;
		} else {
			return null;
		}
	}



	
	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}


	
	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	
	/** 
	 * @return String
	 */
	public String getType() {
		return type;
	}


	
	/** 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}


	
	/** 
	 * @return int
	 */
	public int getAttack() {
		return attack;
	}


	
	/** 
	 * @param attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}


	
	/** 
	 * @return int
	 */
	public int getDefense() {
		return defense;
	}


	
	/** 
	 * @param defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}


	
	/** 
	 * @return int
	 */
	public int getHealth() {
		return health;
	}


	
	/** 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}


	
	/** 
	 * @return Move[]
	 */
	public Move[] getMoves() {
		return moves;
	}


	
	/** 
	 * @param moves
	 */
	public void setMoves(Move[] moves) {
		this.moves = moves;
	}


	
	/** 
	 * @return Status
	 */
	public Status getStatus() {
		return status;
	}


	
	/** 
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}


	
	/** 
	 * @return int
	 */
	public int getNumber() {
		return number;
	}


	
	/** 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}



	
	/** 
	 * @return int
	 */
	public int getCurrentHp() {
		return currentHp;
	}


	
	/** 
	 * @param currentHp
	 */
	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}


	
	/** 
	 * @return boolean
	 */
	public boolean isFeinted() {
		return isFeinted;
	}


	
	/** 
	 * @param isFeinted
	 */
	public void setFeinted(boolean isFeinted) {
		this.isFeinted = isFeinted;
	}



	
	/** 
	 * @return String
	 */
	public String getBackimg() {
		return Backimg;
	}



	
	/** 
	 * @param backimg
	 */
	public void setBackimg(String backimg) {
		Backimg = backimg;
	}



	
	/** 
	 * @return String
	 */
	public String getFrontimg() {
		return Frontimg;
	}



	
	/** 
	 * @param frontimg
	 */
	public void setFrontimg(String frontimg) {
		Frontimg = frontimg;
	}

}