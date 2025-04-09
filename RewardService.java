package com.example.rewards;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service to calculate reward points for customer transactions.
 */
@Service
public class RewardService {

    private final List<Customer> customers = List.of(
        new Customer(1L, "Alice"),
        new Customer(2L, "Bob")
    );

    private final List<Transaction> transactions = List.of(
        new Transaction(1L, java.time.LocalDate.of(2025, 1, 15), 120.0),
        new Transaction(1L, java.time.LocalDate.of(2025, 2, 10), 75.0),
        new Transaction(2L, java.time.LocalDate.of(2025, 3, 5), 200.0),
        new Transaction(2L, java.time.LocalDate.of(2025, 3, 15), 50.0)
    );

    public List<RewardResponse> calculateRewards() {
        Map<Long, List<Transaction>> groupedByCustomer = transactions.stream()
            .collect(Collectors.groupingBy(Transaction::getCustomerId));

        List<RewardResponse> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            List<Transaction> customerTransactions = groupedByCustomer.getOrDefault(customer.getId(), List.of());

            Map<String, Integer> monthlyRewards = new HashMap<>();
            int total = 0;

            for (Transaction tx : customerTransactions) {
                String month = tx.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM"));
                int points = calculatePoints(tx.getAmount());
                monthlyRewards.merge(month, points, Integer::sum);
                total += points;
            }

            responseList.add(new RewardResponse(
                customer.getId(),
                customer.getName(),
                monthlyRewards,
                total
            ));
        }

        return responseList;
    }

    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (int)((amount - 100) * 2) + 50;
        } else if (amount > 50) {
            points += (int)(amount - 50);
        }
        return points;
    }
}
