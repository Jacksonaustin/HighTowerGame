package main;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	private GameScreen gameScreen; 
	
	public Game() {
		setSize(800, 800); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		
		gameScreen = new GameScreen(); 
		add(gameScreen); 
		setVisible(true);

	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Tower Defense"); 
		Game game = new Game(); 
		
	}

    

}
