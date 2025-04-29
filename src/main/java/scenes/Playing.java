package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import helpers.LevelBuilder;
import main.Game;
import main.tiles.Tile;
import managers.TIleManager;

public class Playing extends GameScene implements SceneMethods {

	
	private Tile[][] world; 
	private TIleManager tileManager; 
	public Playing(Game game) throws IOException {
		super(game);
		// TODO Auto-generated constructor stub
		world = LevelBuilder.getLevelData(); 
		
	}

	@Override
	public void render(Graphics g) {
	    for (int x = 0; x < world.length; x++) {
	        for (int y = 0; y < world[x].length - 1; y++) {
	            Tile tile = world[x][y];
	            if (tile != null && tile.getImage() != null) {
	                g.drawImage(tile.getImage(), x * 32, y * 32, null);
	            } else {
	                System.out.println("Null tile at: " + x + "," + y);
	            }
	        }
	    }
	}

}
