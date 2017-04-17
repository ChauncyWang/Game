package cc.chauncy.rpg.UIlearn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Chauncy on 2017/4/14.
 */
public class Main {
	public static void main(String[] args) {
		new MFrame();
	}

	public static void GG() {
		BufferedImage bi1 = null;
		try {
			bi1 = ImageIO.read(new File("res/img/2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
		BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1.getHeight());

		Graphics2D g2 = bi2.createGraphics();
		g2.setColor(new Color(255, 255, 255, 0));
		g2.fill(new Rectangle(bi2.getWidth(), bi2.getHeight()));
		g2.setClip(shape);
		// 使用 setRenderingHint 设置抗锯齿
		g2.drawImage(bi1, 0, 0, null);
		g2.dispose();

		try {
			ImageIO.write(bi2, "png", new File("res/2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MFrame extends JFrame implements Runnable{
	public MFrame() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
		try {
			bi1 = ImageIO.read(new File("res/img/001-Blind01.png"));
			bi2 = ImageIO.read(new File("res/img/002-Blind02.png"));
			bi3 = ImageIO.read(new File("res/img/003-Blind03.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		if(iBuffer==null){
			iBuffer = createImage(this.getWidth(),this.getHeight());
			gBuffer = iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0,0,this.getWidth(),this.getHeight());
		gBuffer.setColor(Color.GREEN);
		gBuffer.fillRect(r*30,0,500,500);
		g.drawImage(iBuffer,0,0,this);
	}

	@Override
	public void run() {
		r = 0;
		while (true){
			try {
				Thread.sleep(100);
				r+=1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	private int r;
	private BufferedImage bi1;
	private BufferedImage bi2;
	private BufferedImage bi3;

	//
	private Image iBuffer = null;
	private Graphics gBuffer = null;
}
