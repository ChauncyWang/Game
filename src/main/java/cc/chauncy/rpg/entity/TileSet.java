package cc.chauncy.rpg.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * 图块集合
 * Created by Chauncy on 2017/4/11.
 */
public class TileSet implements Serializable {
	private int id;
	private String name;
	private String imgFile;
	private transient BufferedImage image;
	private int w;
	private int h;
	private Tile[][] tiles;

	public TileSet() {
	}

	/**
	 * 加载图像 为每个tile设置图像
	 */
	public void loadImage() {
		try {
			image = ImageIO.read(new File(imgFile));
			w = image.getWidth() / 32;
			h = image.getHeight() / 32;
			if(tiles==null){
				tiles = new Tile[h][];
			}
			for (int i = 0; i < h; ++i) {
				if(tiles[i]==null){
					tiles[i] = new Tile[w];
				}
				for (int j = 0; j < w; ++j) {
					if(tiles[i][j]==null){
						tiles[i][j] = new Tile();
					}
					tiles[i][j].setImg(image.getSubimage(j * 32, i * 32, 32, 32));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	///////////////////////////////////////////
	/// getter and setter
	//////////////////////////////////////////
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}
}

