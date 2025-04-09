package com.example.rewards;

import java.util.Map;

public class RewardResponse {

	private long customerid;
	private String customername;
	private Map<String, Integer> monthlyRewards;
	private int totalRewards;


	public RewardResponse(Long customerid, String customername, Map<String, Integer> monthlyRewards, int totalRewards) {

		this.customerid = customerid;
		this.customername = customername;
		this.monthlyRewards = monthlyRewards;
		this.totalRewards = totalRewards;


	}


	public long getCustomerid() {
		return customerid;
	}





	public String getCustomername() {
		return customername;
	}




	public Map<String, Integer> getMonthlyRewards() {
		return monthlyRewards;
	}





	public int getTotalRewards() {
		return totalRewards;
	}



}
