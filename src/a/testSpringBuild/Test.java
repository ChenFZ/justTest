package a.testSpringBuild;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Test {
	public static void main(String[] args) {
		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < 26; i++) {
//			sb.append((char)('A'+i));
//		}
//		
//		System.out.println(sb.toString());
		
		demo(2, 2018, 5);
		
		
		
	}
	//通过反射调用对象的方法
	@org.junit.Test
	public void testReflect() throws Exception{
		String str = "hello";
		Method m = str.getClass().getMethod("toUpperCase");
		System.out.println(m.invoke(str));
	}
	
	@org.junit.Test
	public void testMap(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("isOnline", "1");
		String isOnline = ("0".equals((String)map.get("isOnline")))?"g":"b";
		System.out.println(isOnline);
	}
	
	public static void demo(Integer reptCycle, Integer yearLabel, Integer timeLabel){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startTime = null;
		Date endTime = null;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.YEAR, yearLabel);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		// reptCycle 日 	周	月	季	年
		if (reptCycle == 1) {
			calendar.set(Calendar.DAY_OF_YEAR, timeLabel);
			startTime = calendar.getTime();
			calendar.add(Calendar.DATE, 1);
			endTime = calendar.getTime();
		}else if(reptCycle == 2) {
			calendar.set(Calendar.WEEK_OF_YEAR, timeLabel);
			calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); 
			startTime = calendar.getTime();
			calendar.add(Calendar.DATE, 7);
			endTime = calendar.getTime();
		}else if(reptCycle == 3) {
			calendar.set(Calendar.MONTH, timeLabel-1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			startTime = calendar.getTime();
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			endTime = calendar.getTime();
		}else if(reptCycle == 4) {
			calendar.set(Calendar.MONTH, (timeLabel-1)*3);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			startTime = calendar.getTime();
			calendar.add(Calendar.MONTH, 3);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			endTime = calendar.getTime();
		}else if(reptCycle == 5) {
			calendar.set(Calendar.DAY_OF_YEAR, 1);
			startTime = calendar.getTime();
			calendar.add(Calendar.YEAR, 1);
			calendar.set(Calendar.DAY_OF_YEAR, 1);
			endTime = calendar.getTime();
		}
		System.out.println(df.format(startTime));
		System.out.println(df.format(endTime));
		
	}
	
	@org.junit.Test
	public void cal(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.YEAR, 2018);
		c.set(Calendar.WEEK_OF_YEAR, 1);
		c.set(Calendar.DAY_OF_WEEK, 1);
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(df.format(c.getTime()));
		System.out.println(c.get(Calendar.WEEK_OF_YEAR));
	}
}
