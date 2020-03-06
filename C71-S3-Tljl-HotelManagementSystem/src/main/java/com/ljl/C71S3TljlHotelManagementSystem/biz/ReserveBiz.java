package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.bean.ReserveExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.ReserveMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.OrderStatusEnum;

@Service
public class ReserveBiz {
	@Resource
	private ReserveMapper reserveMapper;
	
	private ReserveExample reserveExample = new ReserveExample();

	public PageInfo<Reserve> loadReserveInfo(int limit, int pageNumber) {
		PageHelper.startPage(pageNumber,limit);
		return new PageInfo<Reserve>(reserveMapper.selectByExample(null));
	}
	public Reserve loadReserveInfoById(int id) {
		return (reserveMapper.selectByPrimaryKey(id));
	}
	
	
	
	/**
	 * 计算符合条件的房间
	 * @author Da
	 * @param inTime
	 * @param outTime
	 * @param roomTypeId
	 * @return
	 */
	public int getRoomCount(String inTime, String outTime, int roomTypeId) {
		int usedRooms = 0;
		if(reserveMapper.selectUsedRooms(inTime, outTime, roomTypeId)!=null) {
			usedRooms = Integer.parseInt(reserveMapper.selectUsedRooms(inTime, outTime, roomTypeId));
		}
		return usedRooms;
	}

	/**
	 * 创建reserve订单
	 * @author Da
	 * @param reserve
	 * @throws BizException
	 */
	public void createReserve(Reserve reserve) throws BizException {
		 try {
			reserveMapper.insertSelective(reserve);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("订单创建失败！");
		}
	}

	/**
	 * 通过随机数来获取订单
	 * @author Da
	 * @param uniqueKey
	 * @return
	 */
	public Reserve selectByNumber(String uniqueKey) {
		reserveExample.clear();
		reserveExample.createCriteria().andReserveNumberEqualTo(uniqueKey);
		return reserveMapper.selectByExample(reserveExample).get(0);
	}

	/**
	 * 支付后更改支付状态
	 * @author Da
	 * @param out_trade_no
	 */
	public void updateStatus(String out_trade_no) {
		reserveExample.createCriteria().andReserveNumberEqualTo(out_trade_no);
		List<Reserve> objReserve = reserveMapper.selectByExample(reserveExample);
		//修改支付状态
		objReserve.get(0).setPayStatus(Integer.parseInt(OrderStatusEnum.PAID.key));
		reserveMapper.updateByExampleSelective(objReserve.get(0), reserveExample);
	}

}
