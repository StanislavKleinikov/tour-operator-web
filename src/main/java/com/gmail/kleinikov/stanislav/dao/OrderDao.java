package com.gmail.kleinikov.stanislav.dao;

import com.gmail.kleinikov.stanislav.entity.Order;

public interface OrderDao {

	Order createOrder();

	Order fetchOrder();

}
