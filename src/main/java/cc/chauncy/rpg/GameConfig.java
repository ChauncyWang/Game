package cc.chauncy.rpg;

import cc.chauncy.rpg.util.Tools;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 游戏配置
 * Created by chauncy on 17-4-9.
 */
public class GameConfig {
	private static GameConfig gameConfig = null;
	private Map<Integer,Image> images;
	public Image getImage(int id){
		return images.get(id);
	}
	public static GameConfig getGameConfig() {
		if (gameConfig == null) {
			gameConfig = new GameConfig();
		}

		return gameConfig;
	}


	private GameConfig() {
		images = new HashMap<Integer,Image>();
		images.put(0,image("ground",6,2));
		images.put(1,image("stone",6,3));
		images.put(2,image("stone",4,3));
		images.put(3,image("ground",0,13,2,2));
		images.put(4,image("stone",0,4,1,2));
		images.put(5,image("stone",6,8));
	}
	private Image image(String file,int x,int y,int w,int h){
		return Tools.getImage("res/img/map/tile/"+file+".png", x * 32, y * 32, w*32, h*32);
	}
	private Image image(String file,int x,int y){
		return image(file,x,y,1,1);
	}
}
