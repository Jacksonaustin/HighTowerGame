package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import helpers.LevelBuilder;
import main.Game;
import main.tiles.Tile;
import managers.TIleManager;

public class Playing extends GameScene implements SceneMethods {

	
	private int[][] world; 
	private TIleManager tileManager;
	
	
	public Playing(Game game) throws IOException {
		super(game);
		// TODO Auto-generated constructor stub
		world = LevelBuilder.getLevelData(); 
		tileManager = new TIleManager();
		
	}

	@Override
	public void render(Graphics g) {
	    for (int x = 0; x < world.length; x++) {
	        for (int y = 0; y < world[x].length; y++) {
	        	int id = world[x][y] - 1;
	            g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
	        }
	    }
	} 
}
