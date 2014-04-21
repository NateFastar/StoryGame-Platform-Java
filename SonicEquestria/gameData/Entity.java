package gameData;

import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Entity extends Rectangle
{
	int EntX;//positioning
	int EntY;//positioning
	int EntWidth;
	int EntHight;
	String EntPic;
	boolean Movable;
	int State;
	
	public Entity(int x, int y, int width, int hight, String fileName, boolean movable)
	{
		super(x, y, width, hight);
		EntX = x;
		EntY = y;
		EntWidth = width;
		EntHight = hight;
		EntPic = fileName;
		Movable = movable;
	}
	
	public String getFileName()
	{
		return EntPic;
	}

	public boolean isMovable()
	{
		return Movable;
	}
}