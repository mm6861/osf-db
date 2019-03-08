package osf.food;

import java.util.HashMap;
import java.util.Map;

import osf.food.controller.FoodController;

public class Execute {
	private FoodController fc = new FoodController();
	public static void main(String[] args) {
		Map<String,String> req = new HashMap<>();
		Map<String,Object> res = new HashMap<>();
		Execute e = new Execute();
		try {
			req.put("cmd", "list");
			e.fc.doGet(req, res);
			System.out.println(res);			
			req = new HashMap<>();
			res = new HashMap<>();
			req.put("cmd", "food");
			req.put("foodNum", "1");
			e.fc.doGet(req, res);
			System.out.println(res);
// ==================  update			
//			req = new HashMap<>();
//			res = new HashMap<>();
//			req.put("cmd", "update");
//			req.put("number", "1");
//			req.put("name", "생연어");
//			req.put("price", "20000");
//			e.fc.doPost(req,res);
//			System.out.println(res);
			
// =================  insert			
//			req = new HashMap<>();
//			res = new HashMap<>();
//			req.put("cmd", "insert");
//			req.put("name", "우럭");
//			req.put("price", "25000");
//			e.fc.doPost(req,res);
//			System.out.println(res);

// ==================  delete
			req = new HashMap<>();
			res = new HashMap<>();
			req.put("cmd", "delete");
			req.put("number", "5");
			e.fc.doPost(req,res);
			System.out.println(res);
			
		}catch (Exception e1) {			
			e1.printStackTrace();
		}
	}
}
