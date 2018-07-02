package com.gmail.kleinikov.stanislav.service.impl;

import com.gmail.kleinikov.stanislav.entity.Order;
import com.gmail.kleinikov.stanislav.dao.OrderDao;
import com.gmail.kleinikov.stanislav.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao;
	
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Order makeOrder() {	
		// TODO Auto-generated method stub
		return orderDao.createOrder();
	}

	@Override
	public Order fetchOrder() {	
		// TODO Auto-generated method stub
		return orderDao.fetchOrder();
	}

}
