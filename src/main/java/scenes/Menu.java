package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;
import main.Render;
import main.tiles.Tile;
import managers.TIleManager;
import ui.MyButton;

public class Menu extends GameScene implements SceneMethods{
	
	Tile[][] ObjectMap = new Tile[25][25]; 
	private MyButton bPlaying, bSettings, bQuit;
	
	
	public Menu(Game game) throws IOException {
		super(game);
		initButtons();

	}
	
	private void initButtons() {
		bPlaying = new MyButton("Play", 100,100,100,30); 
	}

	@Override
	public void render(Graphics g)  {
		
		drawButtons(g);
	}

	private void drawButtons(Graphics g) {
		// TODO Auto-generated method stub
		bPlaying.draw(g);
		
	}
	


}
