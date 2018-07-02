package com.gmail.kleinikov.stanislav.dao.impl;

import com.gmail.kleinikov.stanislav.entity.Order;
import com.gmail.kleinikov.stanislav.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {


	public OrderDaoImpl() {
	
	}

	@Override
	public Order createOrder() {
		// TODO Auto-generated method stub
		return new Order();
	}

	@Override
	public Order fetchOrder() {
		// TODO Auto-generated method stub
		return new Order();
	}

}
