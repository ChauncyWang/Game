package cc.chauncy.rpg.entity;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * 图块
 * Created by Chauncy on 2017/4/11.
 */
public class Tile implements Serializable {
	/**
	 * 图块的大小
	 */
	public static int size = 64;
	/**
	 * 块通行
	 */
	private boolean blockPassable = true;
	/**
	 * 四方 通行
	 */
	private boolean LPassable = true;
	private boolean RPassable = true;
	private boolean UPassable = true;
	private boolean DPassable = true;
	/**
	 * 绘制优先级,0最高
	 */
	private short priority = 0;

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

}
