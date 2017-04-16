package cc.chauncy.rpg;

import cc.chauncy.rpg.map.GameMap;
import cc.chauncy.rpg.util.JSONTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by chauncy on 17-4-9.
 */
public class GameFrame extends JFrame{

	public GameFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		GameMap map = JSONTools.getGameMap("res/map1.json");
		System.out.println(map);
		//map.load();
		//this.add(map);
		//this.setSize(map.getWidth(),map.getHeight());
		//this.add(playerIcon);
		//this.addKeyListener(this);
	}
}
