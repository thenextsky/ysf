package cn.ysf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * 文件工具类：保存、读取算法执行结果
 */
public class FileUtil {
	public static void save(Map<String,Object> map) {
		ObjectOutputStream oos = null;
		try {
			File file = new File("ysf.data");
			if(!file.exists()) {
				file.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(map);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Map<String,Object> read() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("ysf.data"));
			return (Map<String, Object>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois!=null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
