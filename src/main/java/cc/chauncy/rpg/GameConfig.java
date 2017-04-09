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
		images.put(0,Tools.getImage("res/img/map/tile/ground.png", 6 * 32, 2 * 32, 32, 32));
		images.put(1,Tools.getImage("res/img/map/tile/stone.png", 4 * 32, 3 * 32, 32, 32));
		images.put(2,Tools.getImage("res/img/map/tile/stone.png", 4 * 32, 3 * 32, 32, 32));
		images.put(3,Tools.getImage("res/img/map/tile/ground.png", 0 * 32, 13 * 32, 64, 64));
		images.put(4,Tools.getImage("res/img/map/tile/stone.png", 0 * 32, 4 * 32, 32, 64));
		images.put(5,Tools.getImage("res/img/map/tile/stone.png", 6 * 32, 8 * 32, 32, 32));
	}
}
