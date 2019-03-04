package properties;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class ProUtil {
	
	public ProUtil(){
		getProperties();
	}
	
	public void getProperties() {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		InputStream is = this.getClass().getResourceAsStream("/jdbc.properties");
		try {
			prop.load(is);
			
			String driverClass = prop.getProperty("c3p0.driverClass");
			System.out.println(driverClass);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	public void test(){
		float f = (float)0.3;
		System.out.println(f == 0.3F);
		
		double d = 0.3;
		System.out.println(d == 0.3);
		
		System.out.println( 3*0.1 == 0.3);
		
	}
	
}
