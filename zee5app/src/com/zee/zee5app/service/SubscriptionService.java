package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;

public interface SubscriptionService {
	
	public String addSubscription(Subscription subscription) throws InvalidAmountException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public String modifySubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public List<Subscription> getAllSubscription();


}