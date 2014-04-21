package gameData;

import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Display panel for Sonic Equestria
 *
 * @author Nate Fastar & Illiad Easle
 */

public class Display extends JPanel
{
	boolean StartScreen;
	boolean inGame;
	ArrayList <Entity> Pos = new ArrayList<Entity>();
	
	public Display(int dims)
	{
		setBackground(Color.CYAN);
		setPreferredSize(new Dimension(dims,dims));
	}
	
	public void StartScreen()
	{
		inGame = false;
		StartScreen = true;
		repaint();	
	}
	
	public void paintComponent(Graphics page)
	{
		if(inGame)
		{
			setBackground(Color.red);
			Image BG = Toolkit.getDefaultToolkit().getImage("StartScreen.png");
			super.paintComponent(page);
			page.drawImage(BG,0,0,this.getWidth(),this.getHeight(),this);
			Image Obj = Toolkit.getDefaultToolkit().getImage(Pos.get(0).getFileName());
			int i;
			for (i=0; i<Pos.size(); ++i)
			{
				Image Ent = Toolkit.getDefaultToolkit().getImage(Pos.get(i).EntPic+".png");
			}
		}
		else if(StartScreen)
		{
			setBackground(Color.white);
			Image BG = Toolkit.getDefaultToolkit().getImage("StartScreen.png");
			super.paintComponent(page);
			page.drawImage(BG,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
	
	public void setPos(Player Illiad, Npcs ... Jigsaw)
	{
		Pos.clear();
		Pos.add(Illiad);
		int i;
		for (i = 0; i<Jigsaw.length; ++i)
		{
			Pos.add(Jigsaw[i]);
		}
	}
}
