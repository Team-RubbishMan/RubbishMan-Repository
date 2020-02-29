package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Food;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodType;
import com.ljl.C71S3TljlHotelManagementSystem.dao.FoodMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.FoodTypeMapper;

@Service
public class FoodBiz {
	
	@Resource
	private FoodMapper foodMapper;
	
	@Resource
	private FoodTypeMapper foodTypeMapper;
	
	/**
	 * @author 蒋璐
	 * 展示菜单
	 * @param page 分页参数
	 * @return
	 */
	public List<Food> loadFoodInfo(int page) {
		PageHelper.startPage(page,8);
		return foodMapper.selectByExample(null);
	}
	
	/**
	 * @author 蒋璐
	 * 展示菜单
	 * @param page 分页参数
	 * @return
	 */
	public PageInfo<Food> loadFoodInfo(int page,int pageSize){
		PageHelper.startPage(page,pageSize);
		return new PageInfo<Food>(foodMapper.selectByExample(null));
		
	}
	
	
	/**
	 * @author 蒋璐
	 * 查foodtype中所有菜品类型
	 * @return
	 */
	public List<FoodType> selectAllFoodType(){
		return foodTypeMapper.selectByExample(null);
	}
	
	/**
	 * @author 蒋璐
	 * 插入符合条件的菜品
	 * @param food   新增的菜品
	 * @throws BizException
	 */
	public void addNewFood(Food food) throws BizException {
		List<Food> lstFood = foodMapper.selectByExample(null);
		//food.setPrice(0.0);
		for(Food objFood:lstFood) {
			if(food.getName().equals(objFood.getName())) {
				throw new BizException("菜单中以添加该类菜品，请勿重复添加！");
			}
		}
		if(food.getPrice()<=0) {
			throw new BizException("菜品价格不得低于0元，请核对后输入！");
		}
		if(food.getName()==null || food.getName().equals("")) {
			throw new BizException("菜名不得为空，请输入！");
		}
		if(food.getPrice()==null || food.getPrice().equals("")) {
			throw new BizException("菜价不得为空，请输入！");
		}
		if(food.getFoodTypeId()==0) {
			throw new BizException("请选择菜品类别！");
		}
		foodMapper.insert(food);
	}

	
	/**
	 * @author 蒋璐
	 * 更新食物信息
	 * @param food 菜品信息
	 * @return
	 */
	public Food updateFoodInfo(Food food) {
		foodMapper.updateByPrimaryKeySelective(food);
		System.out.println(food);
		return food;
	}
	
	/**
	 * @author 蒋璐
	 * 根据id删除食物
	 * @param id
	 */
	public void deleteFood(Integer id) {
		foodMapper.deleteByPrimaryKey(id);
	}

}
