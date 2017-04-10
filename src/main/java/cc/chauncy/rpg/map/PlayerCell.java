package cc.chauncy.rpg.map;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chauncy on 17-4-10.
 */
public class PlayerCell extends MapCell {
	private int towards = 0;
	private int index = 0;
	private BufferedImage bi;
	private boolean stop = true;

	public PlayerCell() {
		super();
		super.setW(1);
		super.setH(2);
		try {
			bi = ImageIO.read(new File("res/img/player/player1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ImageIcon getIcon() {
		int x = index / 4 % 4;
		int y = towards;
		icon = new ImageIcon(bi.getSubimage(x * 32, y * 48, 32, 48));
		return icon;
	}

	public void setTowards(int towards) {
		this.towards = towards;
		if (!stop) {
			index++;
		}
	}

	public int getTowards() {
		return towards;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
		if (stop)
			index = 0;
	}
}
