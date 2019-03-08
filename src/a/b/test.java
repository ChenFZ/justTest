package a.b;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 测试一下
 * @author Administrator
 *
 */
public class test {
	public static void main(String[] args) {
		Calendar calendar = GregorianCalendar.getInstance();
		System.out.println(calendar.getTime() instanceof Date);
		Integer i = 5;
		System.out.println(i instanceof Integer);
		
		System.out.println(UUID.randomUUID().toString());
		
		System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		
		float parseFloat = Float.parseFloat("1.23");
		System.out.println(parseFloat);
	}
	
	
	
	public void testName() throws Exception {
		HashMap<String,Map> map1 = new HashMap<String, Map>();
		HashMap<String,Integer> map2 = new HashMap<String, Integer>();
		map2.put("key1", 1);
		map1.put("firstMap", map2);
		System.out.println(map1);
		map2.put("key2", 2);
		System.out.println(map1);
	}
	@Test
	public void test() {
//		Object[] prj = null;
//		List<Object[]> prjList = new ArrayList<Object[]>();
//		System.out.println(prj );
//		System.out.println(prjList);
		
//		System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		Long l = 1L;
		System.out.println((l.toString() instanceof String));
//		String[] sysCodes=null;
//		for (String sysCode : sysCodes) {
//			if (!"".equals(sysCode)) {
//				System.out.println(sysCode);
//			}
//		}

	}
	@Test
	public void demo(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		System.out.println(calendar.getTime());
	}
	
	@Test
	public void demo_1(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    try
	    {
	      Date d1 = df.parse("2004-03-26 13:31:40");
	      Date d2 = df.parse("2003-01-02 11:30:24");
	      long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
	      long days = diff / (1000 * 60 * 60 * 24);
	 
	      long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
	      long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
	      System.out.println(""+days+"天"+hours+"小时"+minutes+"分");
	    }catch (Exception e)
	    {
	    }
	}
}
class User {
	private static int userNumber  = 0 ;

	public User(){
		userNumber ++;
	}

	public static void main(String[] args) {
		User user1 = new User();
		User user2 = new User();
		System.out.println("user1 userNumber：" + User.userNumber);
		System.out.println("user2 userNumber：" + User.userNumber);
	}
}