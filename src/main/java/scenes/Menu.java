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

public class Menu extends GameScene implements SceneMethods{
	Tile[][] ObjectMap = new Tile[25][25]; 
	
	
	
	public Menu(Game game) throws IOException {
		super(game);

	}

	@Override
	public void render(Graphics g) throws IOException {
		TIleManager ti = new TIleManager(); 


		int x = 0;
		int y = 0;
		 
		ObjectMap = ti.getTileMap(); 
	
		for(int r = 0; r < 25; r ++) {

		for(int p = 0; p < 25; p ++) {
			
			
			if(ObjectMap[r][p].getImage() != null) {
				g.drawImage(ObjectMap[r][p].getImage(), x, y, null); 
			}
			else {
				System.out.println("Help");
			}
			x += 32;	
		}
		y += 32; 
		x = 0;
		}		
	}
	


}
