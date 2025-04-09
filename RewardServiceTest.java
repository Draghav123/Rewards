package com.example.rewards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class RewardServiceTest {
	
	
	private final RewardService rewardservice = new RewardService();
	
	@Test
	
	public void testRewardCaluculation() {
		
		List<RewardResponse> rewards = rewardservice.calculateRewards();
		assertFalse(rewards.isEmpty());
		assertEquals(2, rewards.size());
		assertTrue(rewards.get(0).getTotalRewards() > 0);
		
	}

}
