package cc.chauncy.rpg;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by chauncy on 17-4-9.
 */
public class PlayerIcon extends JPanel {
	private int towards = 0;
	private int index = 0;
	private BufferedImage bi;
	private boolean stop = true;


	public PlayerIcon() {
		this.setSize(64, 96);
		try {
			bi = ImageIO.read(new File("res/img/player/player1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		int x = index / 4 % 4;
		int y = towards;
		graphics.drawImage(bi.getSubimage(x * 32, y * 48, 32, 48), 0, 0, 63, 96, this);
	}

	public void setTowards(int towards) {
		this.towards = towards;
		if (!stop) {
			index++;
		}
		repaint();
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

		repaint();
	}
}
