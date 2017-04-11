package cc.chauncy.rpg;

import cc.chauncy.rpg.entity.Tile;
import cc.chauncy.rpg.entity.TileSet;
import cc.chauncy.rpg.util.JSONTools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

/*
 * Created by JFormDesigner on Tue Apr 11 18:47:30 CST 2017
 */
public class TileTool extends JFrame implements MouseListener, ActionListener {
	private int mouseX = -1;
	private int mouseY = -1;
	private TileSet tileSet;
	private File file;

	public static void main(String[] args) {
		new TileTool("res/ground.map");
	}


	public TileTool(String filename) {
		initComponents();
		file = new File(filename);
		if (file.exists()) {
			try {
				tileSet = (TileSet) new ObjectInputStream(new FileInputStream(file)).readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			tileSet = new TileSet();
			tileSet.setId(1);
			tileSet.setName("ground");
			tileSet.setImgFile("res/img/tile/ground.png");
		}
		imageAll.setIcon(new ImageIcon(tileSet.getImgFile()));
		imageAll.addMouseListener(this);
		buttonSave.setActionCommand("save");
		buttonSave.addActionListener(this);
		buttonSaveAll.setActionCommand("saveAll");
		buttonSaveAll.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equals("save")) {
			Tile tile = tileSet.getTiles()[mouseY][mouseX];
			tile.setPriority((short) slider1.getValue());
			tile.setBlockPassable(radioButtonPassable.isSelected());
			tile.setUPassable(checkBoxU.isSelected());
			tile.setDPassable(checkBoxD.isSelected());
			tile.setLPassable(checkBoxL.isSelected());
			tile.setRPassable(checkBoxR.isSelected());
		}
		if (actionEvent.getActionCommand().equals("saveAll")) {
			try {
				new ObjectOutputStream(new FileOutputStream(file)).writeObject(tileSet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("保存成功!");
		}
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		if (tileSet != null && mouseX != -1) {
			labelX.setText("X:" + (mouseY + 1) + "/" + tileSet.getW());
			labelY.setText("Y:" + (mouseX + 1) + "/" + tileSet.getH());
			Tile tile = tileSet.getTiles()[mouseY][mouseX];
			slider1.setValue(tile.getPriority());
			radioButtonPassable.setSelected(tile.isBlockPassable());
			checkBoxU.setSelected(tile.isUPassable());
			checkBoxD.setSelected(tile.isDPassable());
			checkBoxL.setSelected(tile.isLPassable());
			checkBoxR.setSelected(tile.isRPassable());
		}
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		mouseX = mouseEvent.getX() / 32;
		mouseY = mouseEvent.getY() / 32;

		//画个框框1
		Graphics graphics = imageAll.getGraphics();
		graphics.setColor(Color.cyan);
		graphics.drawRect(mouseX * 32, mouseY * 32, 32, 32);
		graphics.dispose();
		//画个选中的图像
		Image image = ((ImageIcon) imageAll.getIcon()).getImage();
		BufferedImage bufImg = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufImg.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		image = bufImg.getSubimage(32 * mouseX, 32 * mouseY, 32, 32).getScaledInstance(imageChoice.getWidth(), imageChoice.getHeight(), Image.SCALE_DEFAULT);
		imageChoice.setIcon(new ImageIcon(image));

		repaint();
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	/**
	 * 布局什么的,JFormDesigner 生成
	 */
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		mainSplitPane = new JPanel();
		leftPanel = new JScrollPane();
		imageAll = new JLabel();
		rightPanel = new JPanel();
		imageChoice = new JLabel();
		labelX = new JLabel();
		labelY = new JLabel();
		slider1 = new JSlider();
		labelPriority = new JLabel();
		radioButtonPassable = new JRadioButton();
		checkBoxU = new JCheckBox();
		checkBoxD = new JCheckBox();
		checkBoxL = new JCheckBox();
		checkBoxR = new JCheckBox();
		buttonSave = new JButton();
		buttonSaveAll = new JButton();

		//======== this ========
		setResizable(false);
		setSize(new Dimension(400, 300));
		Container contentPane = getContentPane();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setLayout(null);

		//======== mainSplitPane ========
		{
			mainSplitPane.setBorder(new LineBorder(Color.red, 2));
			mainSplitPane.setLayout(null);
			mainSplitPane.setSize(new Dimension(400, 300));

			//======== leftPanel ========
			{
				leftPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				leftPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				leftPanel.setPreferredSize(new Dimension(200, 300));
				leftPanel.setViewportView(imageAll);
			}
			mainSplitPane.add(leftPanel);
			leftPanel.setBounds(new Rectangle(new Point(0, 0), leftPanel.getPreferredSize()));

			//======== rightPanel ========
			{
				rightPanel.setSize(new Dimension(200, 300));
				rightPanel.setLayout(null);

				//---- imageChoice ----
				imageChoice.setBorder(new LineBorder(Color.yellow, 2, true));
				rightPanel.add(imageChoice);
				imageChoice.setOpaque(false);
				imageChoice.setBounds(0, 35, 60, 60);

				//---- labelX ----
				labelX.setText("X:\u5f53\u524d\u4f4d\u7f6e/\u603b\u5927\u5c0f");
				labelX.setBorder(new LineBorder(Color.black, 2));
				rightPanel.add(labelX);
				labelX.setBounds(70, 35, 120, 30);

				//---- labelY ----
				labelY.setText("Y:\u5f53\u524d\u4f4d\u7f6e/\u603b\u5927\u5c0f");
				labelY.setBorder(new LineBorder(Color.black, 2));
				rightPanel.add(labelY);
				labelY.setBounds(70, 70, 120, 25);

				//---- slider1 ----
				slider1.setOrientation(SwingConstants.VERTICAL);
				slider1.setMaximum(5);
				slider1.setPaintTicks(true);
				rightPanel.add(slider1);
				slider1.setBounds(15, 125, 55, 145);

				//---- labelPriority ----
				labelPriority.setText("\u7ed8\u5236\u4f18\u5148\u7ea7");
				rightPanel.add(labelPriority);
				labelPriority.setBounds(new Rectangle(new Point(0, 105), labelPriority.getPreferredSize()));

				//---- radioButtonPassable ----
				radioButtonPassable.setText("\u5757\u901a\u8fc7");
				rightPanel.add(radioButtonPassable);
				radioButtonPassable.setBounds(new Rectangle(new Point(100, 130), radioButtonPassable.getPreferredSize()));

				//---- checkBoxU ----
				checkBoxU.setText("\u4e0a\u65b9");
				rightPanel.add(checkBoxU);
				checkBoxU.setBounds(100, 160, 65, 25);

				//---- checkBoxD ----
				checkBoxD.setText("\u4e0b\u65b9");
				rightPanel.add(checkBoxD);
				checkBoxD.setBounds(100, 220, 65, 25);

				//---- checkBoxL ----
				checkBoxL.setText("\u5de6\u65b9");
				checkBoxL.setHorizontalTextPosition(SwingConstants.RIGHT);
				rightPanel.add(checkBoxL);
				checkBoxL.setBounds(70, 190, 65, 25);

				//---- checkBoxR ----
				checkBoxR.setText("\u53f3\u65b9");
				rightPanel.add(checkBoxR);
				checkBoxR.setBounds(135, 190, 65, 25);

				//---- buttonSave ----
				buttonSave.setText("\u4fdd\u5b58");
				rightPanel.add(buttonSave);
				buttonSave.setBounds(0, 5, 100, buttonSave.getPreferredSize().height);

				//---- buttonSaveAll ----
				buttonSaveAll.setText("\u4fdd\u5b58\u6240\u6709");
				rightPanel.add(buttonSaveAll);
				buttonSaveAll.setBounds(100, 5, 91, buttonSaveAll.getPreferredSize().height);
			}
			mainSplitPane.add(rightPanel);
			rightPanel.setBounds(new Rectangle(new Point(200, 0), rightPanel.getPreferredSize()));

		}
		contentPane.add(mainSplitPane);
		mainSplitPane.setBounds(0, -5, 395, 300);

		contentPane.setPreferredSize(new Dimension(405, 320));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel mainSplitPane;
	private JScrollPane leftPanel;
	private JLabel imageAll;
	private JPanel rightPanel;
	private JLabel imageChoice;
	private JLabel labelX;
	private JLabel labelY;
	private JSlider slider1;
	private JLabel labelPriority;
	private JRadioButton radioButtonPassable;
	private JCheckBox checkBoxU;
	private JCheckBox checkBoxD;
	private JCheckBox checkBoxL;
	private JCheckBox checkBoxR;
	private JButton buttonSave;
	private JButton buttonSaveAll;

	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
