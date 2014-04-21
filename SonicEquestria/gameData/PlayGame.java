package gameData;

import javax.swing.JFrame;

public class PlayGame
{
	public static void main(String[]args)
	{
		JFrame frame = new JFrame("Sonic Equestria");
		GameMech Illiad = new GameMech();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(Illiad);
		frame.pack();
		frame.setVisible(true);
	}
}
