package cc.chauncy.rpg.Tools;

import cc.chauncy.rpg.entity.TileSet;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileFilter;

/*
 * Created by JFormDesigner on Mon Apr 17 05:51:04 CST 2017
 */
public class GUISaveTileSet extends JFrame {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new GUISaveTileSet();
	}

	private TileSet tileSet = null;
	private BufferedImage bi = null;
	private int mouseX = -1;
	private int mouseY = -1;

	public GUISaveTileSet() {
		initComponents();
	}

	private void imageAllMouseClicked(MouseEvent e) {
		// TODO add your code here
		mouseX = e.getX() / 32;
		mouseY = e.getY() / 32;
		repaint();
	}

	private void sliderPriorityStateChanged() {
		// TODO add your code here
	}

	private void radioButtonPassableStateChanged() {
		// TODO add your code here
	}

	private void checkBoxUStateChanged() {
		// TODO add your code here
	}

	private void checkBoxDStateChanged() {
		// TODO add your code here
	}

	private void checkBoxLStateChanged() {
		// TODO add your code here
	}

	private void checkBoxRStateChanged() {
		// TODO add your code here
	}

	private void buttonActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void buttonOpenActionPerformed() {
		// TODO add your code here
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.getName().endsWith("png") ||
						file.getName().endsWith("map") ||
						file.isDirectory();
			}

			@Override
			public String getDescription() {
				return "png/map";
			}
		});
		chooser.showDialog(this, "选择文件");
		File file = chooser.getSelectedFile();
		if (file.getName().endsWith("png")) {
			try {
				bi = ImageIO.read(file);
				imageAll.setIcon(new ImageIcon(bi));
				tileSet = new TileSet();
				tileSet.setId(1);
				tileSet.setImgFile(file.getAbsolutePath());
				tileSet.loadImg();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

		}
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		if (bi != null) {
			int w = imageChoice.getWidth() - 4;
			int h = imageChoice.getHeight() - 4;
			Image image = bi.getSubimage(mouseX * 32, mouseY * 32, 32, 32);
			image = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			imageChoice.setIcon(new ImageIcon(image));
			Graphics g = imageAll.getGraphics();
			g.setColor(Color.CYAN);
			g.drawRect(mouseX * 32, mouseY * 32, 32, 32);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		mainSplitPane = new JPanel();
		leftPanel = new JScrollPane();
		imageAll = new JLabel();
		rightPanel = new JPanel();
		imageChoice = new JLabel();
		labelX = new JLabel();
		labelY = new JLabel();
		sliderPriority = new JSlider();
		labelPriority = new JLabel();
		radioButtonPassable = new JRadioButton();
		checkBoxU = new JCheckBox();
		checkBoxD = new JCheckBox();
		checkBoxL = new JCheckBox();
		checkBoxR = new JCheckBox();
		buttonSave = new JButton();
		buttonOpen = new JButton();

		//======== this ========
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(400, 300);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== mainSplitPane ========
		{
			mainSplitPane.setBorder(null);
			mainSplitPane.setLayout(null);

			//======== leftPanel ========
			{
				leftPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				leftPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				leftPanel.setPreferredSize(new Dimension(200, 300));

				//---- imageAll ----
				imageAll.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						imageAllMouseClicked(e);
					}
				});
				leftPanel.setViewportView(imageAll);
			}
			mainSplitPane.add(leftPanel);
			leftPanel.setBounds(new Rectangle(new Point(0, 0), leftPanel.getPreferredSize()));

			//======== rightPanel ========
			{
				rightPanel.setPreferredSize(new Dimension(200, 300));
				rightPanel.setLayout(null);

				//---- imageChoice ----
				imageChoice.setBorder(new LineBorder(Color.yellow, 2, true));
				rightPanel.add(imageChoice);
				imageChoice.setBounds(0, 5, 60, 60);

				//---- labelX ----
				labelX.setText("X:\u5f53\u524d\u4f4d\u7f6e/\u603b\u5927\u5c0f");
				labelX.setBorder(new LineBorder(Color.black, 2));
				rightPanel.add(labelX);
				labelX.setBounds(70, 5, 120, 30);

				//---- labelY ----
				labelY.setText("Y:\u5f53\u524d\u4f4d\u7f6e/\u603b\u5927\u5c0f");
				labelY.setBorder(new LineBorder(Color.black, 2));
				rightPanel.add(labelY);
				labelY.setBounds(70, 40, 120, 25);

				//---- sliderPriority ----
				sliderPriority.setOrientation(SwingConstants.VERTICAL);
				sliderPriority.setMaximum(5);
				sliderPriority.setSnapToTicks(true);
				sliderPriority.setMinorTickSpacing(1);
				sliderPriority.setMajorTickSpacing(1);
				sliderPriority.setPaintLabels(true);
				sliderPriority.addChangeListener(e -> sliderPriorityStateChanged());
				rightPanel.add(sliderPriority);
				sliderPriority.setBounds(0, 85, 60, 145);

				//---- labelPriority ----
				labelPriority.setText("\u7ed8\u5236\u4f18\u5148\u7ea7");
				rightPanel.add(labelPriority);
				labelPriority.setBounds(0, 235, 70, 20);

				//---- radioButtonPassable ----
				radioButtonPassable.setText("\u5757\u901a\u8fc7");
				radioButtonPassable.addChangeListener(e -> radioButtonPassableStateChanged());
				rightPanel.add(radioButtonPassable);
				radioButtonPassable.setBounds(new Rectangle(new Point(100, 100), radioButtonPassable.getPreferredSize()));

				//---- checkBoxU ----
				checkBoxU.setText("\u4e0a\u65b9");
				checkBoxU.addChangeListener(e -> checkBoxUStateChanged());
				rightPanel.add(checkBoxU);
				checkBoxU.setBounds(115, 155, 65, 25);

				//---- checkBoxD ----
				checkBoxD.setText("\u4e0b\u65b9");
				checkBoxD.addChangeListener(e -> checkBoxDStateChanged());
				rightPanel.add(checkBoxD);
				checkBoxD.setBounds(115, 220, 65, 25);

				//---- checkBoxL ----
				checkBoxL.setText("\u5de6\u65b9");
				checkBoxL.setHorizontalTextPosition(SwingConstants.RIGHT);
				checkBoxL.addChangeListener(e -> checkBoxLStateChanged());
				rightPanel.add(checkBoxL);
				checkBoxL.setBounds(85, 185, 65, 25);

				//---- checkBoxR ----
				checkBoxR.setText("\u53f3\u65b9");
				checkBoxR.addChangeListener(e -> checkBoxRStateChanged());
				rightPanel.add(checkBoxR);
				checkBoxR.setBounds(145, 185, 65, 25);

				//---- buttonSave ----
				buttonSave.setText("\u4fdd\u5b58");
				buttonSave.addActionListener(e -> buttonActionPerformed(e));
				rightPanel.add(buttonSave);
				buttonSave.setBounds(95, 275, 100, buttonSave.getPreferredSize().height);

				//---- buttonOpen ----
				buttonOpen.setText("\u6253\u5f00");
				buttonOpen.addActionListener(e -> buttonOpenActionPerformed());
				rightPanel.add(buttonOpen);
				buttonOpen.setBounds(0, 275, 95, buttonOpen.getPreferredSize().height);

			}
			mainSplitPane.add(rightPanel);
			rightPanel.setBounds(new Rectangle(new Point(200, 0), rightPanel.getPreferredSize()));
		}
		contentPane.add(mainSplitPane);
		mainSplitPane.setBounds(0, 0, 400, 300);

		contentPane.setPreferredSize(new Dimension(400, 300));
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
	private JSlider sliderPriority;
	private JLabel labelPriority;
	private JRadioButton radioButtonPassable;
	private JCheckBox checkBoxU;
	private JCheckBox checkBoxD;
	private JCheckBox checkBoxL;
	private JCheckBox checkBoxR;
	private JButton buttonSave;
	private JButton buttonOpen;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}