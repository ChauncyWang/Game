package cc.chauncy.rpg;

import cc.chauncy.rpg.util.Tools;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 游戏配置
 * Created by chauncy on 17-4-9.
 */
public class GameConfig {
	private static GameConfig gameConfig = null;
	private Map<Integer, ImageIcon> icons;

	public ImageIcon getIcon(int id) {
		return icons.get(id);
	}

	public static GameConfig getGameConfig() {
		if (gameConfig == null) {
			gameConfig = new GameConfig();
		}

		return gameConfig;
	}


	private GameConfig() {
		icons = new HashMap<Integer, ImageIcon>();
		icons.put(0, icon("ground", 6, 2));
		icons.put(1, icon("stone", 6, 3));
		icons.put(2, icon("stone", 4, 3));
		icons.put(3, icon("ground", 0, 13, 2, 2));
		icons.put(4, icon("stone", 0, 4, 1, 2));
		icons.put(5, icon("stone", 6, 8));
	}

	private ImageIcon icon(String file, int x, int y, int w, int h) {
		return Tools.getIcon("res/img/map/tile/" + file + ".png", x * 32, y * 32, w * 32, h * 32);
	}

	private ImageIcon icon(String file, int x, int y) {
		return icon(file, x, y, 1, 1);
	}
}
