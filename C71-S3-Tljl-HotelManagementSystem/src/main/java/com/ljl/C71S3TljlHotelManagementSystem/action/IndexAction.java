package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.bean.OrderForm;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.bean.User;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.ReserveBiz;
import com.ljl.C71S3TljlHotelManagementSystem.biz.ToReserveBiz;
import com.ljl.C71S3TljlHotelManagementSystem.dao.EntertainmentDeviceMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomTypeMapper;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class IndexAction {
	@Resource
	private RoomTypeMapper roomTypeMapper;
	@Resource
	private EntertainmentDeviceMapper entertainmentDeviceMapper;

	@Resource
	private ReserveBiz reserveBiz;
	@Resource
	private RoomMapper roomMapper;
	@Resource
	private ToReserveBiz toReserveBiz;

	@GetMapping("front/about.html")
	public String GotoAbout() {
		return "front/about";
	}

	@GetMapping("front/gallery.html")
	public String GotoGallery() {
		return "front/gallery";
	}

	@GetMapping("front/services.html")
	public String GotoServices() {
		return "front/services";
	}

	@GetMapping("front/contact.html")
	public String GotoContact() {
		return "front/contact";
	}

	@GetMapping("front/map.html")
	public String GotoMap() {
		return "front/map";
	}

	@GetMapping("front/index.html")
	public String index(Model model) {
		model.addAttribute("roomType", roomTypeMapper.selectByExample(null));
		model.addAttribute("entertainmentDevice", entertainmentDeviceMapper.selectByExample(null));

		return "front/index";
	}

	@GetMapping("front/goPay.html{uniqueKey}")
	public String goPay(@RequestParam String uniqueKey, Model model) {
		model.addAttribute("roomType", roomTypeMapper.selectByExample(null));
		model.addAttribute("entertainmentDevice", entertainmentDeviceMapper.selectByExample(null));
		model.addAttribute("order", reserveBiz.selectByNumber(uniqueKey));

		return "front/goPay";
	}

	/**
	 * 获取筛选后的房间数量
	 * 
	 * @author Da
	 * @param inTime     入住时间
	 * @param outTime    离开时间
	 * @param roomTypeId 房间种类id
	 * @return
	 */
	@PostMapping("front/getRoomCount")
	@ResponseBody
	public Result getRoomCount(String inTime, String outTime, int roomTypeId) {
		int iTotal = roomMapper.selectCountRoom(roomTypeId) - reserveBiz.getRoomCount(inTime, outTime, roomTypeId);
		return new Result(1, "", iTotal);
	}

	/**
	 * 处理房间预定
	 * 
	 * @author Da
	 * @param orderForm
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("front/order")
	@ResponseBody
	public Result Order(OrderForm orderForm,HttpServletRequest request) throws ParseException {
		Reserve objReserve = toReserveBiz.ToReserve(orderForm);
		User user = (User) request.getSession().getAttribute("objUser");
		objReserve.setUserId(user.getId());
		try {
			reserveBiz.createReserve(objReserve);
			return new Result(1, "", objReserve.getReserveNumber());
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙,请稍后再试！");
		}
	}

	/**
	 * 处理餐饮预定
	 * 
	 * @author Da
	 * @param userId
	 * @param dinnerTime
	 * @param dinnerNumber
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("front/foodOrder")
	@ResponseBody
	public Result foodOrder(String userId, String dinnerTime, String dinnerNumber,HttpServletRequest request) throws ParseException {
		User user = (User) request.getSession().getAttribute("objUser");
		Reserve objReserve = toReserveBiz.foodToReserve(String.valueOf(user.getId()), dinnerTime, dinnerNumber);
		System.out.println(objReserve.toString());
		try {
			reserveBiz.createReserve(objReserve);
			return new Result(1, "", objReserve.getReserveNumber());
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙,请稍后再试！");
		}
	}

	/**
	 * 处理娱乐预定
	 * 
	 * @author Da
	 * @param userId
	 * @param entertainmentTime
	 * @param entertainmentType
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("front/entertainmentOrder")
	@ResponseBody
	public Result entertainmentOrder(String userId, String entertainmentTime, String entertainmentType,HttpServletRequest request)
			throws ParseException {
		User user = (User) request.getSession().getAttribute("objUser");
		Reserve objReserve = toReserveBiz.entertainmentToReserve(String.valueOf(user.getId()), entertainmentTime, entertainmentType);
		System.out.println(objReserve);
		try {
			reserveBiz.createReserve(objReserve);
			return new Result(1, "", objReserve.getReserveNumber());
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙,请稍后再试！");
		}
	}

}
