package cc.chauncy.rpg.util;

import java.io.*;

/**
 * Created by Chauncy on 2017/4/17.
 */
public class ObjectTool {
	/**
	 * 从文件中反序列化
	 * @param fileName 要反序列化的文件名字
	 * @return 反序列化得到的对象
	 */
	public static Object readObject(String fileName){
		File file = new File(fileName);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 序列化
	 * @param fileName 序列化要保存的文件名字
	 * @param object 要序列化的对象
	 * @throws Exception 可能出现的错误
	 */
	public static void writeObject(String fileName,Object object) throws Exception {
		File file = new File(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(object);
	}
}
