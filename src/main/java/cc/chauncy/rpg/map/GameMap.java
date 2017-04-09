package cc.chauncy.rpg.map;

import cc.chauncy.rpg.GameConfig;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * 游戏地图
 * Created by chauncy on 17-4-9.
 */
public class GameMap extends JPanel{
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

	private int size = 100;

	private Image image;

	public GameMap() {
		super();
		this.setVisible(true);
	}

	///////////////////////////////////////
	/// Override
	//////////////////////////////////////

	public void load() {
		this.setSize((10+2)*size,(10+2)*size);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i = 0; i < w +2; ++i){
			for(int j = 0; j < h +2; ++j){
				g.drawImage(GameConfig.getGameConfig().getImage(ground),i*size,j*size,size,size,this);
				if(i==0||j==0||i== w +1){
					g.drawImage(GameConfig.getGameConfig().getImage(borderImg),i*size,j*size,size,size,this);
				}
			}
		}
		for(MapCell cell:cells){
			g.drawImage(GameConfig.getGameConfig().getImage(cell.getImg()),
					cell.getX()*size,cell.getY()*size,cell.getW()*size,cell.getH()*size,this);
		}
		for(int i = 0; i < w +2; ++i ){
			g.drawImage(GameConfig.getGameConfig().getImage(borderImg),i*size,(h +1)*size,size,size,this);
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
