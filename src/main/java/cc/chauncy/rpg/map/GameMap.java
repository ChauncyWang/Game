package cc.chauncy.rpg.map;

import cc.chauncy.rpg.GameConfig;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * 游戏地图
 * Created by chauncy on 17-4-9.
 */
public class GameMap extends JPanel {
	/**
	 * 地图宽度,cell的数量
	 */
	private int w;
	/**
	 * 地图长度,cell的数量
	 */
	private int h;
	/**
	 * 地图地面的贴图标号
	 */
	private int ground;
	/**
	 * 地图围栏贴图标号
	 */
	private int borderImg;
	/**
	 * 附加的修饰
	 */
	private MapCell[] cells;

	private int size = 32;

	private ImageIcon[][] icons;

	private PlayerCell player = new PlayerCell();

	public GameMap() {
		super();
		this.setVisible(true);
		player.setX(2);
		player.setY(2);
	}

	// h w->
	// |
	// V
	public void load() {
		this.setSize((10 + 2) * size, (10 + 2) * size);

		icons = new ImageIcon[w + 2][];
		for (int i = 0; i < w + 2; ++i) {
			icons[i] = new ImageIcon[h + 2];
			for (int j = 0; j < h + 2; ++j) {
				icons[i][j] = null;
				if (i == 0 || j == 0 || i == w + 1 || j == h + 1) {
					icons[i][j] = GameConfig.getGameConfig().getIcon(borderImg);
				}
			}
		}

		for (MapCell cell : cells) {
			icons[cell.getX()][cell.getY()] = cell.getIcon();
		}
		icons[player.getX()][player.getY()] = player.getIcon();
		repaint();
	}

	///////////////////////////////////////
	/// Override
	///////////////////////////////////////
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < w + 2; ++i) {
			for (int j = 0; j < h + 2; ++j) {
				g.drawImage(GameConfig.getGameConfig().getIcon(ground).getImage(), i * size, j * size, size, size, this);
			}
		}
		for (int i = 0; i < w + 2; ++i) {
			for (int j = 0; j < h + 2; ++j) {
				ImageIcon icon = icons[i][j];
				if (icon != null) {
					int var1 = i * size;
					int var2 = j * size;
					int var3 = icon.getIconWidth();
					int var4 = icon.getIconHeight();
					if (var3 == 32 && var4 == 64) {
						var2 -= size;
					}
					Image image = icon.getImage();
					g.drawImage(image, var1, var2, var3, var4, this);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GameMap{" +
				"w=" + w +
				", h=" + h +
				", ground=" + ground +
				", borderImg=" + borderImg +
				", cells=" + Arrays.toString(cells) +
				'}';
	}

	///////////////////////////////////////
	/// getter and setter
	//////////////////////////////////////
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getGround() {
		return ground;
	}

	public void setGround(int ground) {
		this.ground = ground;
	}

	public int getBorderImg() {
		return borderImg;
	}

	public void setBorderImg(int borderImg) {
		this.borderImg = borderImg;
	}

	public MapCell[] getCells() {
		return cells;
	}

	public void setCells(MapCell[] cells) {
		this.cells = cells;
	}

}
