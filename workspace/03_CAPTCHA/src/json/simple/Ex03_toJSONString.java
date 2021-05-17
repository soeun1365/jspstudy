
package json.simple;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Ex03_toJSONString {
	public static void main(String[] args) {
	/*
		JSONObject obj = new JSONObject();
		obj.put("name", "브레드");					//put으로 데이터 저장
		obj.put("age", 50);
		
		String requestData = obj.toJSONString();	//스트링으로 바꿔라
		
		System.out.println(requestData);
	*/
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "브레드");		
		obj1.put("age", 50);
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "초코");		
		obj2.put("age", 30);
		
		JSONArray list = new JSONArray();
		list.add(obj1);								//add로 list에 추가
		list.add(obj2);
		
		String requestData = list.toJSONString();	//스트링으로 바꿔라
		System.out.println(requestData);
	}
}