package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.security.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Bill;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Indent;
import com.ljl.C71S3TljlHotelManagementSystem.dao.BillMapper;

@Service
public class BillBiz {
	@Resource
	private BillMapper billMapper;
	/**
	 *通过账单id查找对应账单
	 */
	public Bill selectBillById(int billId) {
		return billMapper.selectByPrimaryKey(billId);
	}
	/**
	 * 插入一条新的账单
	 */
	public int insertBill(Bill bill) {
		billMapper.insertSelective(bill);
		return bill.getId();
	}
	
	public PageInfo<Bill> loadBillInfo(int page,int pageSize) {
		PageHelper.startPage(page,pageSize);
		return new PageInfo<Bill>(billMapper.selectByExample(null));
	}
}
