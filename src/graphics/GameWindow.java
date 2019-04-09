package graphics;

import javax.swing.JFrame;
import controller.KeyEventHandler;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	public static final int DIM_FRAME_X = 650;
	public static final int DIM_FRAME_Y = 350;
	
	private Board gameBoard;

	public GameWindow(){
		this.setSize(DIM_FRAME_X, DIM_FRAME_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PONG Game");
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.gameBoard = new Board();
		
		this.add(gameBoard);
		this.addKeyListener(new KeyEventHandler(this.gameBoard));
		this.setVisible(true);
	}
	
}