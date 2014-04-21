package gameData;

import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;

import javax.swing.*;

/**
 * @author Nate Fastar, Illiad Easle
 * <p>GameMech is responsible for constructing the game elements,
 * managing the layouts and events and running the game. Extends JPanel
 */
@SuppressWarnings("serial")
public class GameMech extends JPanel implements Runnable
{
	/**Constant, The amount the timer is delayed by*/
	private final int TIMER_DELAY = 20;
	/**Constant, the dimensions of the Display*/
	private final int DISPLAY_DIM = 500;
	/**How far each object is moved*/
	private int stepSize = 1;
	/**Element, Game Timer*/
	private Timer timer;
	
	boolean inPlay;
	boolean started;
	
	
	Player One = new Player(8,0,0,0);
	Npcs Others;
	Display Jigsaw;
	
	public GameMech()
	{
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new BoxLayout(bpanel, BoxLayout.Y_AXIS));
		Jigsaw = new Display(DISPLAY_DIM);
		setLayout(new BorderLayout());
		add(Jigsaw, BorderLayout.CENTER);
		
		run();
	}
	
	public void run()
	{
		Jigsaw.StartScreen();
		
	}
	
	public void introScreen()
	{
		
	}
	
	public void startScreen()
	{
		inPlay=true;
		//draw the start screen
		//build the option buttons: new, load, settings, quit
		//New starts the game at level Intro.
		//Load loads level from file
		//Settings sends to SetScreen
		//Quit closes the game
	}
	
	public void LoadScreen()
	{
		//draw the load screen
		//load save data from file
		//send to saved level
	}
	
	public void SetScreen()
	{
		//draw set screen
		//build option buttons: clearSave, addDLC, screenSize
		//visual settings are controlled by computer monitor
	}
	
	public boolean handleEvent(Event event)
	{
label0:
		switch(event.id)
		{
		default:
			break;
		
		case 503: //Event.MOUSE_MOVE
			{
				if(!started)
				{
					started=true;
					introScreen();
					break;
				}
				break;
			}
		case Event.KEY_ACTION:
		case 401: // Event.KEY_PRESS
			{
				if(!inPlay)
				{
					startScreen();
					break;
				}
				else
				{
					switch(event.key)
					{
					default:
						break;
					
					case Event.LEFT:
						//move char left
						break;
					
					case Event.RIGHT:
						//move char right
						break;
					
					case Event.UP:
						//move char up
						break;
					
					case Event.DOWN:
						//move char down
						break;
				
					case 65:
					case 97:
						//basic attack
						break;
					
					
					}
				}
			}
		}
	return false;
	}
}
