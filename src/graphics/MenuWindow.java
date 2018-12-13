package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuWindow extends JFrame implements ActionListener {

	private static final int DIM_FRAME_X = 350;
	private static final int DIM_FRAME_Y = 268;
	
	private JButton exitButton, creditsButton, gameButton, settignsButton;
	private JLabel text;
	private JDialog creditsDialog, playersNameDialog;

	public MenuWindow() {
		this.setSize(DIM_FRAME_X, DIM_FRAME_Y);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Welcome to the game");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("pong.png");
		this.setIconImage(icon);
		
		this.text = new JLabel("Enjoy it! What do you want to do?");
		this.text.setBounds(100, 100, 100, 25);
		add(this.text);
		
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20)); // Centra los objetos que hay en la pantalla del menu
		this.gameButton = new JButton("PLAY!!");
		this.createButtonSettingd(gameButton, 0);
		this.settignsButton = new JButton("Settings");
		this.createButtonSettingd(settignsButton, 30);
		this.creditsButton = new JButton("Credits");
		this.createButtonSettingd(creditsButton, 70);
		this.exitButton = new JButton("Exit");
		this.createButtonSettingd(exitButton, 100);
		
		this.setVisible(true);
	}
	
	private void createButtonSettingd(JButton button, int increase) {
		button.setBounds(DIM_FRAME_X/8, DIM_FRAME_Y/9 - increase, 100, 25);
		add(button, BorderLayout.CENTER);
		this.getContentPane().add(button);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.LIGHT_GRAY);
		button.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.exitButton) {
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		}
		else if (e.getSource() == this.creditsButton) {			
			this.creditsButtonAction();
		}
		else if (e.getSource() == this.gameButton) {
			// Esperar a introducir los datos y continuar
			//this.getPlayersNameDialog();
			this.setVisible(false);
			this.dispose();
			new GameWindow();
		}
	}
	
	private void getPlayersNameDialog() {
		this.playersNameDialog = new JDialog(this, "Who are playing?");
		this.playersNameDialog.setBackground(Color.BLACK);
		this.playersNameDialog.setSize(300, 100);
		this.playersNameDialog.setResizable(false);
		this.playersNameDialog.setLocationRelativeTo(null);
		
		JLabel playerName1 = new JLabel("Player 1 name:");
		playerName1.setHorizontalTextPosition(JLabel.LEFT);
		playerName1.setVerticalTextPosition(JLabel.CENTER);
		JLabel playerName2 = new JLabel("Player 2 name:");
		playerName2.setHorizontalTextPosition(JLabel.LEFT);
		playerName2.setVerticalTextPosition(JLabel.CENTER);
		
		this.playersNameDialog.add(playerName1);
		this.playersNameDialog.add(playerName2);
		this.playersNameDialog.setVisible(true);
	}
	
	private void getTextBoxNames(JDialog playersNameDialog) {
		
	}
	
	private void creditsButtonAction() {
		this.creditsDialog = new JDialog(this, "Credits");
		this.creditsDialog.setBackground(Color.BLACK);
		this.creditsDialog.setSize(440, 100);
		this.creditsDialog.setResizable(false);
		this.creditsDialog.setLocationRelativeTo(null);
		
		JLabel creditsText = new JLabel();
		creditsText.setText("Special thanks to: Héctor Ullate & Carlos Segundo. 'Pong Game' developers");
		creditsText.setHorizontalTextPosition(JLabel.CENTER);
		creditsText.setVerticalAlignment(JLabel.CENTER);
		creditsText.setLocation(this.creditsDialog.getLocation());
		
		
		this.creditsDialog.add(creditsText);
		this.creditsDialog.setVisible(true);
	}
	
}
