package gameData;

import java.util.ArrayList;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * @author Nate Fastar & Illiad Easle
 * <p>Stores the aspects of an NPC instance, namely: Name, Size, File Ext, and lines.
 */
public class Npcs extends Entity
{
	int charX;
	int charY;
	final String[] npcName = new String[] {};//configure with names of all NPCs
	final static String[] npcFileExt = new String[] {};//configure with initials of all NPCs
	final static int[][] CharSize = new int[][] {{}};//these will be configured depending on the final image size.
	String name;
	String fileExt;
	int sizeNum;
	Scanner in;
	ArrayList<String> Lines = new ArrayList<String>();
	int CurLine;
	
	public Npcs(int x, int y, int width, int hight, int charNum) throws FileNotFoundException
	{
		super(x,y,width,hight,npcFileExt[charNum], true);
		charX = x;
		charY = y;
		name = npcName[charNum];
		fileExt = npcFileExt[charNum];
		sizeNum = charNum;
		Linedump();
		in = new Scanner(new File("lines"+fileExt+".txt"));
	}
	
	
	
	public void Linedump()
	{
		while(in.hasNext())
		{
			Lines.add(in.nextLine());
		}
		CurLine = 0;
	}
}
