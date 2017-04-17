package cc.chauncy.rpg.uitools.components;
import cc.chauncy.rpg.entity.TileSet;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
/*
 * Created by JFormDesigner on Mon Apr 17 10:59:48 CST 2017
 */



/**
 * @author chauncy
 */
public class NewTilePanel extends JPanel {
	public NewTilePanel() {
		initComponents();
	}
	private TileSet tileSet = new TileSet();
	private void buttonOpenActionPerformed(ActionEvent e) {
		// TODO add your code here
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.isDirectory()||f.getName().endsWith(".png");
			}

			@Override
			public String getDescription() {
				return "png";
			}
		});
		chooser.showDialog(this,"G");
		String name =
		chooser.getSelectedFile().getAbsolutePath();
		textFieldPath.setText(name);
	}

	private void buttonSaveActionPerformed(ActionEvent e) {
		// TODO add your code here
		tileSet.setId(Integer.parseInt(textFieldID.getText()));
		tileSet.setImgFile(textFieldPath.getText());
		tileSet.setName(textFieldName.getText());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		textFieldPath = new JTextField();
		buttonOpen = new JButton();
		textFieldID = new JTextField();
		textFieldName = new JTextField();
		buttonSave = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();

		//======== this ========
		setLayout(null);
		setSize(400,300);

		//---- textFieldPath ----
		textFieldPath.setEnabled(false);
		add(textFieldPath);
		textFieldPath.setBounds(0, 0, 280, 60);

		//---- buttonOpen ----
		buttonOpen.setText("\u6253\u5f00");
		buttonOpen.addActionListener(e -> buttonOpenActionPerformed(e));
		add(buttonOpen);
		buttonOpen.setBounds(142*2, 0, 58*2, 30*2);
		add(textFieldID);
		textFieldID.setBounds(50*2, 40*2, 150*2, 30*2);
		add(textFieldName);
		textFieldName.setBounds(50*2, 75*2, 150*2, 30*2);

		//---- buttonSave ----
		buttonSave.setText("\u4fdd\u5b58");
		buttonSave.addActionListener(e -> buttonSaveActionPerformed(e));
		add(buttonSave);
		buttonSave.setBounds(142*2, 110*2,58*2, 30*2);

		//---- label1 ----
		label1.setText("\u7f16\u53f7");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label1);
		label1.setBounds(0, 40*2, 40*2, 30*2);

		//---- label2 ----
		label2.setText("text");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label2);
		label2.setBounds(0, 80*2, 40*2, 30*2);

		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JTextField textFieldPath;
	private JButton buttonOpen;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JButton buttonSave;
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
