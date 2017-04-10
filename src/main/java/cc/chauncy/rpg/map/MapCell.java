package cc.chauncy.rpg.map;

import cc.chauncy.rpg.GameConfig;

import javax.swing.*;
import java.awt.*;

/**
 * 每一个格子
 * Created by chauncy on 17-4-9.
 */
public class MapCell {
	private int x;
	private int y;
	private int w = 1;
	private int h = 1;
	private int size = 32;
	private int img;
	protected ImageIcon icon;
	private boolean real = true;

	public MapCell() {
	}


	/////////////////////////////////
	// Override
	////////////////////////////////
	@Override
	public String toString() {
		return "MapCell{" +
				"x=" + x +
				", y=" + y +
				", w=" + w +
				", h=" + h +
				", size=" + size +
				", img=" + img +
				", real=" + real +
				'}';
	}

	/////////////////////////////
	// getter and setter
	//////////////////////////////
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
		icon = GameConfig.getGameConfig().getIcon(img);
	}

	public boolean isReal() {
		return real;
	}

	public void setReal(boolean real) {
		this.real = real;
	}

	public ImageIcon getIcon() {
		return icon;
	}
}
