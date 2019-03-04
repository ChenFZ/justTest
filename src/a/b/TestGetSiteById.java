package a.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.StringUtil;


public class TestGetSiteById {
	
	public static void main(String[] args) {
		HashMap map1 = new HashMap();
		map1.put("id", "1");
		map1.put("cid", "1");
		map1.put("prjId", "1");
		map1.put("siteCode", "6904");
		map1.put("siteName", "宝山路派出所二期");
		map1.put("location", "宝山路");
		map1.put("state", "6801");
		map1.put("longitude", "23.2222");
		map1.put("latitude", "58.2222");
		map1.put("deptId", "00bacc09ba27400ba02018e87b91aed8");
		map1.put("deptName", "宝山路派出所");
		map1.put("enale", "1");
		map1.put("note", "无");
		map1.put("sysCode", "3101");
		map1.put("sysName", "治安监控");
		
		HashMap map2 = new HashMap();
		map2.put("id", "1");
		map2.put("cid", "1");
		map2.put("prjId", "1");
		map2.put("siteCode", "6904");
		map2.put("siteName", "宝山路派出所二期");
		map2.put("location", "宝山路");
		map2.put("state", "6801");
		map2.put("longitude", "23.2222");
		map2.put("latitude", "58.2222");
		map2.put("deptId", "00bacc09ba27400ba02018e87b91aed8");
		map2.put("deptName", "宝山路派出所");
		map2.put("enale", "1");
		map2.put("note", "无");
		map2.put("sysCode", "3102");
		map2.put("sysName", "交警监控");
		ArrayList<Map> sites = new ArrayList<Map>();
		sites.add(map1);
		sites.add(map2);
		
		//输出的map
		Map out = new HashMap();
		//查看点位id是否重复
		boolean flag = false;
		//存放sys信息列表
		List<Map> sysList = new ArrayList<Map>();
		
		for (final Map site : sites) {
			if (flag) {
				//除第一条以外的记录
				if (StringUtil.isNotNull(site.get("id").toString())) {
					sysList.add(new HashMap(){
						{
							put("sysCode", site.get("sysCode").toString());
							put("sysName", site.get("sysName").toString());
						}
					});
				}
			}else {
				//第一条记录
				flag = true;
				if (StringUtil.isNotNull(site.get("id").toString())) {
					out.put("id", site.get("id").toString());
					out.put("cid", site.get("cid").toString());
					out.put("prjId", site.get("prjId").toString());
					out.put("siteCode", site.get("siteCode").toString());
					out.put("siteName", site.get("siteName").toString());
					out.put("location", site.get("location").toString());
					out.put("state", site.get("state").toString());
					out.put("longitude", site.get("longitude").toString());
					out.put("latitude", site.get("latitude").toString());
					out.put("deptId", site.get("deptId").toString());
					out.put("deptName", site.get("deptName").toString());
					out.put("enale", site.get("enale").toString());
					out.put("note", site.get("note").toString());
					sysList.add(new HashMap(){
						{
							put("sysCode", site.get("sysCode").toString());
							put("sysName", site.get("sysName").toString());
						}
					});
					out.put("systems", sysList);
				}
			}
		}
		System.out.println(out);
	}
	
}
