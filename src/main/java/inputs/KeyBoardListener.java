package inputs;

import java.awt.event.KeyEvent;
import static main.GameStates.*;
import java.awt.event.KeyListener;

import main.GameStates;

public class KeyBoardListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_M) {
			System.out.println("M is pressed!"); 
			GameStates.gameState = MENU; 
			
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			System.out.println("P is pressed!"); 
			GameStates.gameState = PLAYING; 

			
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("S is pressed!"); 
			GameStates.gameState = SETTINGS; 

			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
