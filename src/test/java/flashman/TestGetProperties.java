package flashman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Test;

// 测试获取properties文件的属性
public class TestGetProperties {

	@Test
	public void getProperties() throws IOException {
		String configFile = "jdbc.properties";
		Properties properties = new Properties();
		InputStream is = TestGetProperties.class.getClassLoader().getResourceAsStream(configFile);
		properties.load(is);
		is.close();

		System.out.println(properties.getProperty("jdbc.username"));
	}

	@Test
	public void getProperties2() throws IOException {
		Properties properties = new Properties();
		BufferedReader br = new BufferedReader(
				new FileReader("F:\\tree\\flashman\\src\\main\\resources\\jdbc.properties"));
		properties.load(br);
		br.close();

		System.out.println(properties.getProperty("jdbc.driver"));
	}

	// 测试3：最简单
	@Test
	public void getProperties3() throws IOException {
		ResourceBundle resource = ResourceBundle.getBundle("jdbc");

		System.out.println(resource.getString("jdbc.url"));
	}

	@Test
	public void getProperties4() throws IOException {
		// BufferedReader br = new BufferedReader(new
		// FileReader("F:\\tree\\flashman\\src\\main\\resources\\jdbc.properties"));
		InputStream br = TestGetProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// 通过流的方式
		ResourceBundle resource = new PropertyResourceBundle(br);
		br.close();
		System.out.println(resource.getString("jdbc.password"));
	}
}
