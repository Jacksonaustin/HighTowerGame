package helpers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Render;
import main.tiles.Tile;

public class LevelBuilder {
	
	 static Tile[][] ObjectMap; 
	 static int[][] tileMap = {
			    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			    {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			    {1,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2,1},
			    {1,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,2,1},
			    {1,2,3,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,3,2,1},
			    {1,2,3,1,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,2,2,2,2,2,2,2,2,2,2,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,3,3,3,3,3,3,3,3,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,1,1,1,1,1,1,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,2,2,2,2,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,3,3,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,1,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,2,1,3,2,1,3,2,1,3,2,1},
			    {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			};
	 
 
	public static Tile[][] getLevelData() throws IOException{
		
		
		 
		 	ObjectMap = setObjectMap(tileMap); 

		 
		 return ObjectMap; 
		
	}
	
	public static Tile[][] setObjectMap(int[][] tileMap) throws IOException {
	
	Tile[][] TheMap = new Tile[25][25]; 
	
	BufferedImage roadTile = importing("/dirt_32x32.png");
	BufferedImage waterTile = importing("/water_32x32.png");
	BufferedImage grassTile = importing("/downscaled_32x32.png");
	Tile grass = new Tile(grassTile, false, "Grass");
	Tile water = new Tile(waterTile, false, "Water");
	Tile dirt = new Tile(roadTile, true,"Road");

	
	for(int i = 0; i < 25; i++) {
		
		for(int p = 0; p < 24; p++) {
			
		
			if(tileMap[i][p] == 1) {
				
			    TheMap[i][p] = grass; 
				
			}
			else if(tileMap[i][p] == 2) {

		     	TheMap[i][p] = water; 


				
			}
			else if(tileMap[i][p] == 3) {
				TheMap[i][p] = dirt; 


			}
			else {
				TheMap[i][p] = grass; 
			}
			

			
			
		}
		System.out.println();
	}
	return TheMap; 

}
	
	private static BufferedImage importing(String file) {
	    
		
		BufferedImage img = null; 
		InputStream is = LevelBuilder.class.getResourceAsStream(file);

		
		if(is == null) {
			System.out.println(file + " wasn't loaded");
			return null; 
		}
		
		try {
			img = ImageIO.read(is); 
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		return img;
	}
	
	

	public static int[][] initializeWorld() {
		int[][] map = new int[25][25];
		
	    for (int y = 0; y < 25; y++) {
	        for (int x = 0; x < 25; x++) {
	            map[x][y] =  2; 
	        }
	    }
	    
	    return map; 
	}

}
