package cc.chauncy.rpg;

import cc.chauncy.rpg.entity.TileSet;
import cc.chauncy.rpg.util.JSONTools;
import org.junit.Test;

/**
 * 测试类
 * Created by chauncy on 17-4-11.
 */
public class MyTest {
	@Test
	public void test() {
		TileSet tileSet = JSONTools.getTileSet("res/001.json");
		System.out.println(tileSet.getTiles().length + "-" + tileSet.getTiles()[0].length);
	}
}
