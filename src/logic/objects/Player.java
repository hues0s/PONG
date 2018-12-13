package logic.objects;

import graphics.GameWindow;

public class Player extends Thread{

	public static final int WIDTH = 15;
	public static final int HEIGHT = 100;	
	
	private int posX;
	private int posY;
	private int score;
	
	public Player(int x, int y){
		this.posX = x;
		this.posY = y;
		this.score = 0;
	}
	
	public void moveUp(){
		if(this.posY - 10 >= 0) this.posY -= 10;
	}
	
	public void moveDown(){
		if(this.posY + Player.HEIGHT + 20 < GameWindow.DIM_FRAME_Y) this.posY += 10;
	}
	
	public void oneMorePoint(){
		this.score++;
	}
	
	//Getters & setters
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int y){
		this.posY = y;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}