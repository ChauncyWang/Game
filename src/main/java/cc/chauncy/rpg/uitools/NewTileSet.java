package cc.chauncy.rpg.uitools;

import cc.chauncy.rpg.uitools.components.NewTilePanel;

import javax.swing.*;

/**
 *
 * Created by Chauncy on 2017/4/17.
 */
public class NewTileSet extends JFrame{
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new NewTileSet();
	}
	private NewTilePanel panel;
	public NewTileSet() {
		super();
		panel = new NewTilePanel();
		setSize(420,350);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(800,800);
		setVisible(true);
		panel.setBounds(0,0,420,350);
		this.add(panel);
	}
}
