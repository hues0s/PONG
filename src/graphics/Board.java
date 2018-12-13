package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import logic.objects.Ball;
import logic.objects.Player;

@SuppressWarnings("serial")
public class Board extends Canvas{
	
	public static final int NUM_PLAYERS = 2;
	public static final int MAX_POINTS = 1;
	
	Player[] playerArray;
	Ball ball;
	GameWindow gw;
	private boolean hasPressedEnter = false;
	private boolean end = false;
	
	public Board(GameWindow gw){
		this.setBackground(Color.black);
		
		playerArray = new Player[NUM_PLAYERS];
		playerArray[0] = new Player(0, GameWindow.DIM_FRAME_Y/2 - 65);
		playerArray[1] = new Player(GameWindow.DIM_FRAME_X - Player.WIDTH, GameWindow.DIM_FRAME_Y/2 - 65);
		this.gw = gw;
		ball = new Ball(this);
		ball.start();
	}
	
	public void paint(Graphics g){
		if(!this.end){
			//fondo negro
			g.setColor(Color.white);
			//linea central
			g.drawLine(GameWindow.DIM_FRAME_X/2, 0, GameWindow.DIM_FRAME_X/2, GameWindow.DIM_FRAME_Y);
			//jugadores
			for(int i = 0; i < NUM_PLAYERS; i++) 
				g.fillRect(playerArray[i].getPosX(), playerArray[i].getPosY(), Player.WIDTH, Player.HEIGHT);
			//pelota
			g.fillOval(ball.getPosX(), ball.getPosY(), Ball.WIDTH, Ball.HEIGHT);
			//marcador
			g.drawString(""+playerArray[0].getScore(), GameWindow.DIM_FRAME_X/2 - 30, 50);
			g.drawString(""+playerArray[1].getScore(), GameWindow.DIM_FRAME_X/2 + 20, 50);
			if(!this.hasPressedEnter && ball.isInterlude()){
				g.drawString("PULSA ENTER", GameWindow.DIM_FRAME_X/2 - 100, 100);
				g.drawString("PULSA ENTER", GameWindow.DIM_FRAME_X/2 + 15, 100);
			}
		}
		else{
			g.setColor(Color.magenta);
			g.drawString("GAME OVER, "+getPlayerWins(), GameWindow.DIM_FRAME_X/2 - 70, GameWindow.DIM_FRAME_Y/2 - 10);
		}
	}
	
	public void endActivity() {
		this.gw.dispose();
		new MenuWindow();
	}
	
	private String getPlayerWins(){
		if(playerArray[0].getScore() == 5) return "Player 2 wins";
		return "Player 1 wins";
	}
	
	public void movePlayer(int playerNumber, char direction){
		switch(direction){
		case 'u': playerArray[playerNumber - 1].moveUp();break;
		case 'd': playerArray[playerNumber - 1].moveDown();break;
		}
	}
	
	public boolean hasPlayerHitBall(int posXBall, int posYBall){
		int numPlayer;
		if(posXBall < GameWindow.DIM_FRAME_X/2) numPlayer = 1;
		else numPlayer = 2;
		
		if(numPlayer == 1 && playerArray[numPlayer-1].getPosX() + 2 * Player.WIDTH - 4 >= posXBall &&
				posYBall >= playerArray[numPlayer-1].getPosY() &&
				posYBall <= playerArray[numPlayer-1].getPosY() + Player.HEIGHT) return true;
		else if(numPlayer == 2 && playerArray[numPlayer-1].getPosX() - 2 * Player.WIDTH + 4 <= posXBall &&
				posYBall >= playerArray[numPlayer-1].getPosY() &&
				posYBall <= playerArray[numPlayer-1].getPosY() + Player.HEIGHT) return true;
		return false;
	}
	
	public boolean setNewPoint(){
		if(ball.getPosX() <= 0) {
			ball.setPosX(Ball.INIT_POSX);
			playerArray[0].setPosY(GameWindow.DIM_FRAME_Y/2 - 65);
			playerArray[1].setPosY(GameWindow.DIM_FRAME_Y/2 - 65);
			playerArray[1].oneMorePoint();
			return true;
		}
		else if(ball.getPosX() >= GameWindow.DIM_FRAME_X - 20){
			ball.setPosX(Ball.INIT_POSX);
			playerArray[1].setPosY(GameWindow.DIM_FRAME_Y/2 - 65);
			playerArray[1].setPosY(GameWindow.DIM_FRAME_Y/2 - 65);
			playerArray[0].oneMorePoint();
			return true;
		}
		return false;
	}
	
	public boolean isFinished(){
		for(int i = 0; i < Board.NUM_PLAYERS; i++) if(playerArray[i].getScore() == Board.MAX_POINTS){
			this.end = true;
			return true;
		}
		return false;
	}
	
	
	public void setEnter(boolean b){
		this.hasPressedEnter = b;
	}
	
	public boolean getEnter(){
		return this.hasPressedEnter;
	}
	
}