package cc.chauncy.rpg.util;

import cc.chauncy.rpg.map.GameMap;
import net.sf.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * json工具
 * Created by chauncy on 17-4-9.
 */
public class JSONTools {
	/**
	 * 从json文件中读取一个map
	 * @param file 文件名字
	 * @return 读取到的Map(没读到返回null)
	 */
	public static GameMap getGameMap(String file){
		//读取整个文件的内容
		StringBuffer sb = new StringBuffer();
		try {
			Scanner in = new Scanner(new File(file));
			while(in.hasNext()) {
				sb.append(in.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		//创建json对象
		JSONObject jsonObject =JSONObject.fromObject(new String(sb));
		//将json对象转换为java对象
		GameMap gameMap = (GameMap) JSONObject.toBean(jsonObject,GameMap.class);

		return gameMap;
	}
}
