package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 日期工具类
 */
public class DateUtil {

	public static DateFormat sdf_Hms = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 获取当日期前/后某个月的所有日期  0表示当前月   负数表示前多少月  正数表示后多少月
	 * @param months
	 * @return
	 */
	 public static List<Date> getDayListOfMonth(Integer months){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
                    parse = sdf.parse(aDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            list.add(parse);
        }
        return list;
    }
	 
	 /**
	  * 格式化日期
	  * @param date  传入的日期
	  * @param flag	 转最大时间还是最小时间
	  * @return
	  */
	public static Date transformDate(Date date,boolean flag){
		Date result = null;
		try {
			if (flag) {
				result = sdf_Hms.parse(sdf_Hms.format(date).substring(0, 10) + " 23:59:59");
			}else {
				result = sdf_Hms.parse(sdf_Hms.format(date).substring(0, 10) + " 00:00:00");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
