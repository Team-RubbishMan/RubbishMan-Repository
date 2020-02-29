package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Food;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodType;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.FoodBiz;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class FoodAction {

	@Resource
	private FoodBiz foodBiz;
	
	/**
	 * @author 蒋璐
	 * 分页展示信息
	 * @param limit   每页多少条数据
	 * @param pageNumber  页码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/back/loadFoodInfo")
	public PageInfo<Food> loadFoodInfo(@RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(defaultValue = "1") Integer pageNumber) {
		PageInfo<Food> loadFoodInfo = foodBiz.loadFoodInfo(pageNumber, limit);
		return loadFoodInfo;
	}
	/**
	 * @author 蒋璐
	 * 打开菜品管理页面
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping("back/foodmanagement.html")
	public String foodManagement(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<Food> lstFood = foodBiz.loadFoodInfo(page);
		model.addAttribute("lstFood", lstFood);

		List<FoodType> lstFoodType = foodBiz.selectAllFoodType();
		model.addAttribute("lstFoodType", lstFoodType);
		return "back/foodmanagement.html";
	}
	
	/**
	 * @author 蒋璐
	 * 删除菜品功能
	 * @param ids 要删除的菜品id数组
	 * @return
	 */
	@PostMapping("/back/deleteFoods")
	@ResponseBody
	public Result deleteFoods(@RequestParam String[] ids) {
		try {
			for(String id:ids) {
				foodBiz.deleteFood(Integer.valueOf(id));
			}
			return new Result(1,"删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0,"系统繁忙，请稍后再试！");
		}
		
	}
	
	/**
	 * @author 蒋璐
	 * 修改菜品信息功能
	 * @param food
	 * @return
	 */
	@RequestMapping("/back/updateFood")
	@ResponseBody
	public Result updateFoodInfo(Food food) {
		try {
			foodBiz.updateFoodInfo(food);
			return new Result(1, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙，请稍后再试！");
		}

	}
	/**
	 * @author 蒋璐
	 * 删除一种食物的功能
	 * @param id  要删除的食物id
	 * @return
	 */
	@RequestMapping("/back/deleteOneFood")
	@ResponseBody
	public Result deleteOneFood(Integer id) {
		try {
			foodBiz.deleteFood(id);
			return new Result(1, "删除成功!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙，请稍后再试！", null);
		}

	}
	
	/**
	 * @author 蒋璐
	 * 新增菜品功能
	 * @param food
	 * @return
	 */
	@PostMapping("back/addNewFood")
	@ResponseBody
	public Result addNewFood(Food food) {
		System.out.println("food=+++" + food);

		try {
			System.out.println("food++" + food.getName() + "++" + food.getPrice() + "++" + food.getFoodTypeId());
			foodBiz.addNewFood(food);
			return new Result(1, "添加菜品成功！", null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2, e.getMessage(), null);
		}catch (Exception e) {
			e.printStackTrace();
			return new Result(0,"系统繁忙，请稍后再试！");
		}
	}
}
