package logic.objects;

import graphics.Board;
import graphics.GameWindow;

public class Ball extends Thread {

	public static final int WIDTH = 15;
	public static final int HEIGHT = 15;
	public static final int INIT_POSX = GameWindow.DIM_FRAME_X / 2;
	public static final int INIT_POSY = GameWindow.DIM_FRAME_Y / 2;
	public static final int SPEED = 17;
	
	private int posX;
	private int posY;
	private int directionX; // indica el sentido de la bola;
	private int directionY;
	private Board board;
	private boolean paintEnter;
	
	public Ball(Board board){
		this.posX = INIT_POSX;
		this.posY = INIT_POSY;
		this.board = board;
		this.directionX = -1;
		this.directionY = -1;
		this.paintEnter = false;
	}
	
	@Override
	public void run(){
		this.waitXTenths(30);
		while(!board.isFinished()){
			move();
			if(board.setNewPoint() && !board.isFinished()){
				while(!board.getEnter()){
					this.paintEnter();					
				}
				board.setEnter(false);
			}
			board.repaint();
		}
		this.waitXTenths(30);
		board.endActivity();
	}
	
	private void move(){
		if(board.hasPlayerHitBall(this.posX, this.posY)) this.directionX *= -1;
		if(this.hasTouchedUpperLimit() || this.hasTouchedLowerLimit()) this.directionY *= -1;
		this.posX += this.directionX * Ball.SPEED;
		this.posY += this.directionY * Ball.SPEED;
		waitXTenths(1);
	}
	
	private void waitXTenths(int tenths) {
		try {
			Thread.sleep(tenths * 100);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void paintEnter(){
		this.paintEnter = true;
		board.repaint();
		this.waitXTenths(5);
		this.paintEnter = false;
		board.repaint();
		this.waitXTenths(5);
	}
	
	private boolean hasTouchedUpperLimit(){
		if(this.posY <= 0 + Ball.HEIGHT/2)return true;
		return false;
	}
	
	private boolean hasTouchedLowerLimit(){
		if(this.posY >= GameWindow.DIM_FRAME_Y - 35 - Ball.HEIGHT/2) return true;
		return false;
	}
	
	public boolean isInterlude(){
		return this.paintEnter;
	}
	
	//Getters & setters
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int x){
		this.posX = x;
	}

	public int getPosY() {
		return posY;
	}

}