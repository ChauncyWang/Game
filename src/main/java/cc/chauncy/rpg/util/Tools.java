package cc.chauncy.rpg.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 工具
 * Created by chauncy on 17-4-9.
 */
public class Tools {
	/**
	 * 在图片中截取区域
	 *
	 * @param file 要截取的文件
	 * @param x    要截取的图片坐标
	 * @param y    要截取的图片坐标
	 * @param w    图片的宽度
	 * @param h    图片的高度
	 * @return 截取到的图片
	 */
	public static Image getImage(String file, int x, int y, int w, int h) {
		BufferedImage bi;
		try {
			bi = ImageIO.read(new File(file));
		} catch (IOException e) {
			return null;
		}
		Image image = bi.getSubimage(x, y, w, h);
		return image;
	}
}
