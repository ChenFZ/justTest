package a.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import utils.StringUtil;

public class TestRecord {
	public static void main(String[] args) {
		HashMap map1 = new HashMap();
		map1.put("id", "433de539a8564d2eb8b67fafb3e1c47f");
		map1.put("cid", "1");
		map1.put("survey_code", "2");
		map1.put("site_id", "00c08ddf9ed243189f7ecad0466bfb75");
		map1.put("begin_time", "2018-04-02 09:40:47");
		map1.put("complete_time", "2018-04-06 09:40:50");
		map1.put("state", "6801");
		map1.put("check_result", "2");
		map1.put("check_time", "2018-04-01 09:41:32");
		map1.put("check_id", "3d8287962ca447d5b10fe6c8643eb9cc");
		map1.put("checkUserName", "map1");
		map1.put("owner_id", "0bb17e9078514467bf2c68f19e6f0a65");
		map1.put("create_time", "2018-04-15 09:40:55");
		map1.put("userId", "acc6e5e58dbd47abb75e5d73d9636ae8");
		map1.put("userName", "治安监控");
		map1.put("surveryId", "433de539a8564d2eb8b67fafb3e1c47f");
		map1.put("level", "2");
		
		HashMap map2 = new HashMap();
		map2.put("id", "433de539a8564d2eb8b67fafb3e1c47f");
		map2.put("cid", "1");
		map2.put("survey_code", "1");
		map2.put("site_id", "6904");
		map2.put("begin_time", "宝山路派出所二期");
		map2.put("complete_time", "宝山路");
		map2.put("state", "6801");
		map2.put("check_result", "23.2222");
		map2.put("check_time", "58.2222");
		map2.put("check_id", "00bacc09ba27400ba02018e87b91aed8");
		map2.put("checkUserName", "宝山路派出所");
		map2.put("owner_id", "1");
		map2.put("create_time", "无");
		map2.put("userId", "6866cab9cbe1489f97b08490ccf84eb8");
		map2.put("userName", "jt001");
		map2.put("surveryId", "433de539a8564d2eb8b67fafb3e1c47f");
		map2.put("level", "1");
		ArrayList<Map> records = new ArrayList<Map>();
		records.add(map1);
		records.add(map2);
		
		// 需要输出的List<Map>
		ArrayList<Map> out = new ArrayList<Map>();
		// 存放一组信息
		Map map = null;
		// 存放遍历出的records的主键
		HashSet<String> recordIdSet = new HashSet<String>();
		// users下面的map列表
		List<Map> tempList = null;

		for (final Map record : records) {
			if (recordIdSet.add(record.get("id").toString())) {
				// 返回true，说明添加成功
				map = new HashMap<>();
				tempList = new ArrayList<Map>();
				if (StringUtil.isNotNull(record.get("id").toString())) {
					// record属性值
					map.put("id", record.get("id").toString());
					map.put("cid", record.get("cid").toString());
					map.put("surveyCode", record.get("survey_code").toString());
					map.put("siteId", record.get("site_id").toString());
					map.put("beginTime", record.get("begin_time").toString());
					map.put("completeTime", record.get("complete_time")
							.toString());
					map.put("state", record.get("state").toString());
					map.put("checkResult", record.get("check_result")
							.toString());
					map.put("checkTime", record.get("check_time").toString());
					map.put("checkId", record.get("check_id").toString());
					map.put("checkUserName", record.get("checkUserName")
							.toString());
					map.put("ownerId", record.get("owner_id").toString());
					map.put("createTime", record.get("create_time").toString());

					// user列表
					tempList.add(new HashMap() {
						{
							HashMap value = new HashMap();
							// user属性值
							value.put("userId", record.get("userId").toString());
							value.put("userName", record.get("userName")
									.toString());
							value.put("surveryId", record.get("surveryId")
									.toString());
							value.put("level",Integer.parseInt(record.get("level").toString()));
							int level =Integer.parseInt(record.get("level").toString());
							if (level == 1) {
								put("primary", value);
							}
							if (level == 2) {
								put("secondary", value);
							}
						}
					});
					map.put("users", tempList);
				}
			} else {
				// 添加失败，说明添加的主键重复
				tempList.add(new HashMap() {
					{
						HashMap value = new HashMap();
						value.put("userId", record.get("userId").toString());
						value.put("userName", record.get("userName").toString());
						value.put("surveryId", record.get("surveryId")
								.toString());
						value.put("level",Integer.parseInt(record.get("level").toString()));
						int level =Integer.parseInt(record.get("level").toString());
						if (level == 1) {
							put("primary", value);
						}
						if (level == 2) {
							put("secondary", value);
						}
					}
				});
			}

			out.add(map);

		}
		System.out.println(out);
		
		
	}
}
