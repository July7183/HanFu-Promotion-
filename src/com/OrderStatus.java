package com;

public enum OrderStatus {

	UNPAY(1), PAIED(2), SHIPPED(3), DONE(4), CANCEL(5);

	private int status;

	private OrderStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
