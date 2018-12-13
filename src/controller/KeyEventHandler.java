package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import graphics.Board;

public class KeyEventHandler implements KeyListener {

	private Board board;
	private int hola;
	public static final int P1UP = KeyEvent.VK_W;
	public static final int P1DOWN = KeyEvent.VK_S;
	public static final int P2UP = KeyEvent.VK_UP;
	public static final int P2DOWN = KeyEvent.VK_DOWN;
	
	public KeyEventHandler(Board board){
		this.board = board;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			board.setEnter(true);
		}
		if(e.getKeyCode() == P1UP){ //jugador1 up
			board.movePlayer(1, 'u');
			board.repaint();
		}
		else if(e.getKeyCode() == P1DOWN){ //jugador1 down
			board.movePlayer(1, 'd');
			board.repaint();
		}
		else if(e.getKeyCode() == P2UP){ //jugador2 up
			board.movePlayer(2, 'u');
			board.repaint();
		}
		else if(e.getKeyCode() == P2DOWN){ //jugador2 down
			board.movePlayer(2, 'd');
			board.repaint();
		}
		else if(e.getKeyCode() == P1UP && e.getKeyCode() == P2UP){ //jugador1 && jugador2 up
			board.movePlayer(1, 'u');
			board.movePlayer(2, 'u');
			board.repaint();
		}
		else if(e.getKeyCode() == P1DOWN && e.getKeyCode() == P2DOWN){ //jugador1 && jugador2 down
			board.movePlayer(1, 'd');
			board.movePlayer(2, 'd');
			board.repaint();
		}
		else if(e.getKeyCode() == P1UP && e.getKeyCode() == P2DOWN){ //jugador1 up && jugador2 down
			board.movePlayer(1, 'u');
			board.movePlayer(2, 'd');
			board.repaint();
		}
		else if(e.getKeyCode() == P1DOWN && e.getKeyCode() == P2UP){ //jugador1 down && jugador2 up
			board.movePlayer(1, 'd');
			board.movePlayer(2, 'u');
			board.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
	
}