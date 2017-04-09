package cc.chauncy.rpg;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by chauncy on 17-4-9.
 */
public class Map extends Canvas implements ImageObserver {
	private int w;
	private int h;
	private int cell = 32;
	private GameConfig game = GameConfig.getGameConfig();
	public Image ground;

	public Map(int w, int h) {
		super();
		this.w = w;
		this.h = h;
		this.setSize((w + 2) * cell, (h + 2) * cell);
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		for (int i = 0; i < w + 2; ++i) {
			for (int j = 0; j < h + 2; ++j) {
				graphics.drawImage(game.ground1, i * cell, j * cell, this);
				if (i == 0 || j == 0 || i == w + 1 || j == h + 1) {
					graphics.drawImage(game.stone1, i * cell, j * cell, this);
				}
			}
		}
	}
}
