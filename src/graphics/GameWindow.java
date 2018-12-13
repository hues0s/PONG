package graphics;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import controller.KeyEventHandler;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	public static final int DIM_FRAME_X = 650;
	public static final int DIM_FRAME_Y = 350;
	
	private Board gameBoard;

	public GameWindow(){
		this.setSize(DIM_FRAME_X, DIM_FRAME_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cuando clickes X, se cierra la ventana y el programa;
															// si no, el programa sigue aunque cierres la ventana.
		this.setTitle("PONG Game");
		setLocationRelativeTo(null);
		this.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("pong.png");
		this.setIconImage(icon);
		
		this.gameBoard = new Board();
		
		this.add(gameBoard);
		this.addKeyListener(new KeyEventHandler(this.gameBoard));
		this.setVisible(true); // esto se hace lo ultimo, porque antes hay que configurar la ventana
	}
	
}