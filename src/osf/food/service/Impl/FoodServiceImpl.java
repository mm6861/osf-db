package osf.food.service.Impl;

import java.util.List;

import osf.food.dao.FoodDAO;
import osf.food.dao.impl.FoodDAOImpl;
import osf.food.service.FoodService;
import osf.food.vo.FoodVO;

public class FoodServiceImpl implements FoodService{
	private FoodDAO fdao = new FoodDAOImpl();
	
	@Override
	public List<FoodVO> selectFoodList(FoodVO food) {
		return fdao.selectFoodList(food);
	}

	@Override
	public FoodVO selectFood(Integer foodNum) {
		// TODO Auto-generated method stub
		return fdao.selectFood(foodNum);
	}
	@Override
	public int insertFood(FoodVO food) throws Exception {
		List<FoodVO> tmpFoodList = fdao.selectFoodList(food);
		if(tmpFoodList.size()!=0) {
			throw new Exception("중복!");
		}
		return fdao.insertFood(food);
	}

	@Override
	public int updateFood(FoodVO food) throws Exception {
		List<FoodVO> tmpFoodList = fdao.selectFoodList(food);
		if(tmpFoodList.size()!=0) {
			throw new Exception("중복!");
		}
		return fdao.updateFood(food);
	}

	@Override
	public int deleteFood(FoodVO food) throws Exception {
		FoodVO tmpFood = fdao.selectFood(food.getFoodNum());
		if(tmpFood==null) {
			throw new Exception("이미 삭제된 음식입니다.");
		}
		return fdao.deleteFood(food);
	}
	
	public static void main(String[] args) {
		FoodService fs = new FoodServiceImpl();
		List<FoodVO> foodList = fs.selectFoodList(null);
		System.out.println(foodList);
		FoodVO food = new FoodVO();
//		food.setFoodName("유부초밥");
//		foodList = fs.selectFoodList(food);
//		System.out.println(foodList);
		
		int cnt=0;
		
// =====================  insert	
		
		food.setFoodName("삼겹살");
		food.setFoodPrice(12000);
		try {
			cnt = fs.insertFood(food);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("저장건수: " + cnt);
		foodList = fs.selectFoodList(null);
		System.out.println(foodList);
		
		
//=====================  update	
		
//		food.setFoodNum(1);
//		food.setFoodName("연어초밥");
//		food.setFoodPrice(45000);
//		try {
//			cnt = fs.updateFood(food);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("업데이트: " + cnt);
		
// ====================== delete	
		
//		food.setFoodNum(7);
//		try {
//			cnt = fs.deleteFood(food);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("삭제 " + cnt + "건");


	}
}
