package cc.chauncy.rpg;

import cc.chauncy.rpg.util.Tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chauncy on 17-4-9.
 */
public class GameConfig {
	private static GameConfig gameConfig = null;
	public Image ground1;
	public Image ground2;
	public Image stone1;
	public Image stone2;

	public static GameConfig getGameConfig() {
		if (gameConfig == null) {
			gameConfig = new GameConfig();
		}

		return gameConfig;
	}


	private GameConfig() {
		ground1 = Tools.getImage("res/img/map/tile/ground.png", 6 * 32, 2 * 32, 32, 32);
		ground2 = Tools.getImage("res/img/map/tile/ground.png", 3 * 32, 7 * 32, 32, 32);
		stone1 = Tools.getImage("res/img/map/tile/stone.png", 4 * 32, 3 * 32, 32, 32);
		stone2 = Tools.getImage("res/img/map/tile/stone.png", 3 * 32, 7 * 32, 32, 32);
	}
}
