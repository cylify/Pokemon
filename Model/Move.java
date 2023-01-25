import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Move {
	private String name;
	private String type;
	private int dmg;

	public Move(String name, String type, int dmg) {
		this.name = name;
		this.type = type;
		this.dmg = dmg;
	}

	
	/**
	 * Read file 
	 * @return ArrayList<Move>
	 */
	public static ArrayList<Move> readFile() {
		ArrayList<Move> moves = new ArrayList<>();
		try {
			File file = new File("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/moves.csv");
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String temp[] = line.split(",");
				moves.add(new Move(temp[0], temp[1], Integer.valueOf(temp[2])));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		Main.mix(moves);
		return moves;
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
	public int getDmg() {
		return dmg;
	}

	
	/** 
	 * @param dmg
	 */
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
}