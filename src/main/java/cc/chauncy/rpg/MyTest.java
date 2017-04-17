package cc.chauncy.rpg;

import cc.chauncy.rpg.entity.TileSet;
import cc.chauncy.rpg.util.JSONTools;
import org.junit.Test;

import java.io.*;

/**
 * 测试类
 * Created by chauncy on 17-4-11.
 */
public class MyTest {
	@Test
	public void test() {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(new File("1.obj")));
			TileSet tileSet = (TileSet) oos.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
