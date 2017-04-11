package cc.chauncy.rpg.entity;

import javax.swing.*;
import java.awt.*;

/**
 * 图块
 * Created by Chauncy on 2017/4/11.
 */
public class Tile {
	/**
	 * 图块的大小
	 */
	public static int size = 64;
	/**
	 * 块通行
	 */
	private boolean blockPassable;
	/**
	 * 四方 通行
	 */
	private boolean LPassable;
	private boolean RPassable;
	private boolean UPassable;
	private boolean DPassable;
	/**
	 * 绘制优先级
	 */
	private short priority;
	/**
	 * 块的图标
	 */
	private ImageIcon icon;

	public Tile() {
	}


	@Override
	public String toString() {
		return "Tile{" +
				"blockPassable=" + blockPassable +
				", LPassable=" + LPassable +
				", RPassable=" + RPassable +
				", UPassable=" + UPassable +
				", DPassable=" + DPassable +
				", priority=" + priority +
				'}';
	}

	///////////////////////
	// getter and setter
	//////////////////////
	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Tile.size = size;
	}

	public boolean isBlockPassable() {
		return blockPassable;
	}

	public void setBlockPassable(boolean blockPassable) {
		this.blockPassable = blockPassable;
	}

	public boolean isLPassable() {
		return LPassable;
	}

	public void setLPassable(boolean LPassable) {
		this.LPassable = LPassable;
	}

	public boolean isRPassable() {
		return RPassable;
	}

	public void setRPassable(boolean RPassable) {
		this.RPassable = RPassable;
	}

	public boolean isUPassable() {
		return UPassable;
	}

	public void setUPassable(boolean UPassable) {
		this.UPassable = UPassable;
	}

	public boolean isDPassable() {
		return DPassable;
	}

	public void setDPassable(boolean DPassable) {
		this.DPassable = DPassable;
	}

	public short getPriority() {
		return priority;
	}

	public void setPriority(short priority) {
		this.priority = priority;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
