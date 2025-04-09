package com.example.rewards;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/rewards")
public class RewardController {

	private final RewardService rewardservice;
	
	public RewardController(RewardService rewardService) {
		this.rewardservice = rewardService;
		}
@GetMapping

public List<RewardResponse> getRewards(){
	return rewardservice.calculateRewards();
	
}
}