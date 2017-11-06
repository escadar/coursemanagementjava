package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropsHelper {

	private static Properties props = null;
	private static String FILE_NAME = "c:/temp/app.properties";

	public static String get(String name) {
		if (props == null) {
			init();
		}
		return props.getProperty(name);
	}

	public static Reply1 set(String name, String val) {
		if (props == null) {
			init();
		}
		try {
			props.setProperty(name, val);
			save();
			return new Reply1();
		} catch (Exception e) {
			Reply1 r = new Reply1();
			r.setId(-1);
			r.setMsg(e.getMessage());
			return r;
		}
	}

	private static void save() {
		if (props != null) {
			try {
				FileOutputStream out = new FileOutputStream(new File(FILE_NAME));
				props.save(out, "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void init() {
		try {
			props = new Properties();
			FileInputStream in = new FileInputStream(FILE_NAME);
			props.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
