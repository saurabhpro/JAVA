package com.saurabh.v6_mail_with_thymleaf.service.factory;

import com.saurabh.v6_mail_with_thymleaf.model.CustomerInfo;
import com.saurabh.v6_mail_with_thymleaf.model.ProductOrder;

/**
 * Created by saurabhkumar on 15/09/17.
 */
public final class ProductFactory {

	public static ProductOrder getDummyOrder() {

		ProductOrder order = new ProductOrder();
		order.setOrderId("1111");
		order.setProductName("Thinkpad T510");
		order.setStatus("confirmed");

		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName("ION Admin");
		customerInfo.setAddress("WallStreet");
		customerInfo.setEmail("saurabhk1511@gmail.com");


		order.setCustomerInfo(customerInfo);

		return order;
	}
}
