/**
 * 
 */
package designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 91978
 * 
 *         FlyWeight is a structural design pattern that lets you fit multiple
 *         objects into available amount of RAM by sharing common parts of state
 *         between multiple objects instead of keeping all of the data in each
 *         object.
 *
 *         Design 1. Game 2. Word Processor / Word Editor
 *
 */
public class FlyWeightDesignPatternExample {

	/**
	 * 
	 */
	public FlyWeightDesignPatternExample() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String args[]) {

		// 1. Game

		IRobot iRobot1 = RobotFactory.createRobot(RobotType.HUMAN.toString());

		iRobot1.display(1, 2);

		IRobot iRobot2 = RobotFactory.createRobot(RobotType.DOG.toString());

		iRobot2.display(3, 4);
		
		// 2. Word Processor
		
		//Good
		
		ILetter letter1 = LetterFactory.createLetter('g');

		letter1.display(1, 4);

		ILetter letter2 = LetterFactory.createLetter('o');

		letter2.display(2, 3);
		
		ILetter letter3 = LetterFactory.createLetter('o');

		letter3.display(3, 2);
		
		ILetter letter4 = LetterFactory.createLetter('g');

		letter4.display(4, 1);
		
	}

}

interface IRobot {

	void display(int x, int y);

}

final class HumanRobot implements IRobot {

	private final String type;
	private final Sprites sprites;

	public HumanRobot(String type, Sprites sprites) {
		this.type = type;
		this.sprites = sprites;
	}

	public String getType() {
		return type;
	}

	public Sprites getSprites() {
		return sprites;
	}

	@Override
	public void display(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("I am at x:" + x + "and y:" + y);
	}

}

final class DogRobot implements IRobot {

	private final String type;
	private final Sprites sprites;

	public DogRobot(String type, Sprites sprites) {
		this.type = type;
		this.sprites = sprites;
	}

	public String getType() {
		return type;
	}

	public Sprites getSprites() {
		return sprites;
	}

	@Override
	public void display(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("I am at x:" + x + "and y:" + y);
	}

}

class Sprites {

}

class RobotFactory {

	static Map<String, IRobot> cacheRobot = new HashMap<>();

	public static IRobot createRobot(String type) {

		IRobot robot = null;

		if (cacheRobot.containsKey(type)) {
			robot = cacheRobot.get(type);
		} else {
			if (RobotType.HUMAN.toString().equals(type)) {

				Sprites sp = new Sprites();

				IRobot hRobot = new HumanRobot(type, sp);

				cacheRobot.put(type, hRobot);

			} else {

				Sprites sp = new Sprites();

				IRobot dRobot = new DogRobot(type, sp);

				cacheRobot.put(type, dRobot);
			}
			robot = cacheRobot.get(type);
		}

		return robot;

	}

}

enum RobotType {
	HUMAN, DOG;
}


//////////////////////////

interface ILetter{
	
	void display(int x, int y);
	
}

final class DocumentCharacter implements ILetter{

	
	private final Character ch;
	private final Integer size;
	private final String font;

	
	
	public DocumentCharacter(Character ch, Integer size, String font) {
		super();
		this.ch = ch;
		this.size = size;
		this.font = font;
	}

	

	public Character getCh() {
		return ch;
	}



	public Integer getSize() {
		return size;
	}



	public String getFont() {
		return font;
	}



	@Override
	public void display(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Char at x:" + x + "and y:" + y);
	}
	
	
	
}

class LetterFactory {

	static Map<Character, ILetter> cacheLetter = new HashMap<>();

	public static ILetter createLetter(Character ch) {

		ILetter letter = null;

		if (cacheLetter.containsKey(ch)) {
			letter = cacheLetter.get(ch);
		} else {

			ILetter letter1 = new DocumentCharacter(ch, 10, "Arial");

			cacheLetter.put(ch, letter1);

			letter = cacheLetter.get(ch);
		}

		return letter;

	}

}



