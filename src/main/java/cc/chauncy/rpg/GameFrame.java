package cc.chauncy.rpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by chauncy on 17-4-9.
 */
public class GameFrame extends JFrame implements KeyListener {
	private PlayerIcon playerIcon;

	public GameFrame() {
		playerIcon = new PlayerIcon();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		Map map = new Map(20, 15);
		map.setVisible(true);
		this.add(map);
		this.setSize(map.getSize());
		//this.add(playerIcon);
		//this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		playerIcon.setStop(false);
		if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
			playerIcon.setTowards(3);
		}
		if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
			playerIcon.setTowards(1);
		}
		if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerIcon.setTowards(2);
		}
		if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
			playerIcon.setTowards(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		playerIcon.setStop(true);
	}
}
