package gameData;

import java.util.ArrayList;
import java.awt.Rectangle;

/**
 * @author Nate Fastar & Illiad Easle
 * <p>Stores the aspects of the players current character, such as name, file location, and special abilities.
 */
public class Player extends Entity
{
	
	int CurrentCharacter; //0-8, links to CharName, CharNameFile, and CharSize
	int bits; //Bits replace the Sonic rings
	final String[] CharName = new String[] {"Sonic","Tails","Twilight Sparkle","Rarity","Fluttershy","Rainbow Dash","Pinky Pie","Applejack","I. E."};//names of possible characters for the player.
	final static String[] CharNameFile = new String[] {"S","T","TS","R","F","RD","P","A","IE"};//Beginning of the name for all of the pose files.
	final static int[][] CharSize = new int[][] {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}};//these will be configured depending on the final image size.
	String CharFile;//The file name of the current pose.
	ArrayList <Integer> Available;
	int CharX;//positioning
	int CharY;//positioning
	//Generic Abilities
	boolean canSprint, canLift, canFly; //Sprint goes to Earth and Sonic, Lift goes to Uni, Fly goes to peg and tails.
	//Char Specific Abilities
	boolean canSonic, canBlast, canIlliad, canWhine, canStare, canRainboom, canCharCannon, canWinona, canDiamond;
	
	public Player(int Char, int x, int y, int StartBits)
	{
		super(x, y, CharSize[Char][0], CharSize[Char][1], CharNameFile[Char], true);
		Available = new ArrayList <Integer>();
		CurrentCharacter = Char;
		bits = StartBits; //default 0;
		Available.add(Char);
		CharX = x;
		CharY = y;
		falsify();
		Abilities();
	}
	
	public void changeChar()
	{
		int i = Available.size();
		int u = Available.indexOf(CurrentCharacter);
		if (u<=(i-2))
		{
			++u;
		}
		else
		{
			u=0;
		}
		CurrentCharacter = Available.get(u);
		falsify();
		Abilities();
	}
	
	public void falsify()
	{
		canSprint=false;
		canLift=false;
		canFly=false;
		canBlast=false;
		canSonic=false;
		canWhine=false;
		canStare=false;
		canRainboom=false;
		canCharCannon=false;
		canWinona=false;
		canDiamond=false;
		canIlliad=false;
	}
	
	public void Abilities()
	{
		switch(CurrentCharacter)
		{
			case 0: //Sonic
				canSprint=true;
				canSonic=true;
				break;
			case 1: //Tails
				canFly=true;
				canBlast=true;
				break;
			case 2: //TS
				canLift=true;
				canIlliad=true;
				break;
			case 3: //R
				canLift=true;
				canWhine=true;
				break;
			case 4: //FS
				canFly=true;
				canStare=true;
				break;
			case 5: //RD
				canSprint=true;
				canFly=true;
				canRainboom=true;
				break;
			case 6: //PP
				canSprint=true;
				canCharCannon=true;
				break;
			case 7: //AJ
				canSprint=true;
				canWinona=true;
				break;
			case 8: //IE
				canLift=true;
				canBlast=true;
				canDiamond=true;
				break;
			default:break;
		}
	}
	public String toString()
	{
		String Stats = new String();
		System.out.print(CurrentCharacter + " is: ");
		Stats = CharName[CurrentCharacter];
		Stats += ", File Tag:" + CharNameFile[CurrentCharacter] + ", ";
		Stats += "Co-ordinates: (" + CharX + ", " + CharY + ")";
		Stats += "Char size: ("+CharSize[CurrentCharacter][0]+"x"+CharSize[CurrentCharacter][1]+")";
		System.out.println(Stats);
		return Stats;
	}
	
	public static void main(String[] args) //remove prior to release
	{
		Player test = new Player(8, 1, 5, 0);
		test.toString();
	}
}