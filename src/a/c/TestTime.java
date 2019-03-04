package a.c;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class TestTime {
	// 日期转毫秒值
	@Test
	public void testName() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 2, 14, 14, 14);
		System.out.println(calendar.getTimeInMillis());
	}
	@Test
	public void test_1() throws Exception {
		String t = "1525241654789";
		long time = Long.parseLong(t);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		date.setTime(time);
		String format = dateFormat.format(date);
		for (int i = 0; i < 500; i++) {
			System.out.println(format);
		}
		Date parse = dateFormat.parse(format);
		System.out.println(parse.getTime());
	}
	@Test
	public void test_2() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		long time = date.getTime() - 24 * 3600 * 1000;
		Date date2 = new Date(time);

		System.out.println(date);
		System.out.println(date2);
		System.out.println(dateFormat.format(date));
	}

	/**
	 * 根据当前日期获得所在周的日期区间（周一和周日日期）
	 * 
	 * @return
	 * @author zhaoxuepu
	 * @throws ParseException
	 */
	public String getTimeInterval(Date date) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = sdf.format(cal.getTime());
		// System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(cal.getTime());
		// System.out.println("所在周星期日的日期：" + imptimeEnd);
		return imptimeBegin + "," + imptimeEnd;
	}

	/**
	 * 根据当前日期获得上周的日期区间（上周周一和周日日期）
	 * 
	 * @return
	 * @author zhaoxuepu
	 */
	public static String[] getLastTimeInterval() {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
		int offset1 = 1 - dayOfWeek;
		int offset2 = 7 - dayOfWeek;
		calendar1.add(Calendar.DATE, offset1 - 7);
		calendar2.add(Calendar.DATE, offset2 - 7);
		// System.out.println(sdf.format(calendar1.getTime()));// last Monday
		String lastBeginDate = sdf.format(calendar1.getTime());
		// System.out.println(sdf.format(calendar2.getTime()));// last Sunday
		String lastEndDate = sdf.format(calendar2.getTime());
		// 
		String[] dates = {lastBeginDate,lastEndDate};
		return dates;
	}

	public static String test_3() {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
		int offset1 = 1 - dayOfWeek;
		int offset2 = 7 - dayOfWeek;
		calendar1.add(Calendar.DATE, offset1 - 7);
		calendar2.add(Calendar.DATE, offset2 - 7);
		// System.out.println(sdf.format(calendar1.getTime()));// last Monday
		String lastBeginDate = sdf.format(calendar1.getTime());
		// System.out.println(sdf.format(calendar2.getTime()));// last Sunday
		String lastEndDate = sdf.format(calendar2.getTime());
		return lastBeginDate + "," + lastEndDate;
	}

	public static void main(String[] args) {
		/*try {
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String[] dates = getLastTimeInterval();
			Date startTime = sdf.parse(dates[0].substring(0, 10) + " 00:00:00");
			Date endtime = sdf.parse(dates[1].substring(0, 10) + " 23:59:59");
			System.out.println(startTime+","+endtime);
		} catch (ParseException e) {
			
		}*/
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		List<Date> list = getDayListOfMonth(0);
		for (Date date : list) {
			System.out.println(sdf.format(date));
		}
	}
	
	/**
	 * 获取当日期前/后某个月的所有日期  0表示当前月   负数表示前多少月  正数表示后多少月
	 * @param months
	 * @return
	 */
	 public static List<Date> getDayListOfMonth(Integer months){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> list = new ArrayList<>();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.add(aCalendar.MONTH, months);
        int year = aCalendar.get(Calendar.YEAR);//年份
        int month = aCalendar.get(Calendar.MONTH)+1;//月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String aDate = String.valueOf(year)+"-"+month+"-"+i;
            Date parse = null;
                try {
                    parse = simpleDateFormat.parse(aDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            list.add(parse);
        }
        return list;
    }
}
