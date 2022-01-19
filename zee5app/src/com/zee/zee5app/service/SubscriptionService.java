package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;



public class SubscriptionService {

	private SubscriptionRepository repository = SubscriptionRepository.getInstance();
	// service is consuming the repository
	
	private SubscriptionService() {
		// TODO Auto-generated constructor stub
	}
	// if we want ot create that single object then we have to create it
	// inside the same class
	// and we have to share ref with others
	// to do the same we have to declare a method.
	private static SubscriptionService  service = null;
	// this would be a static 
	// only one copy.
	
	public static SubscriptionService getInstance() {
		// it  becomes object independant?
		// static will make it independant on the object for execution.
		
		// static method will access only static ref
		if(service==null)
		service = new SubscriptionService();
		return service;
		
	}
	
	public String addSubscription(Subscription subscription) {
		// do we need to consume the addUser method from repo.
		return this.repository.addSubscription(subscription);
	}
	
	public Subscription getSubscriptionById(String id) {
		return repository.getSubscriptionById(id);
	}
	public Subscription[] getSubscription() {
		return repository.getSubscription();
	}
	
	public String updateSubscription(String id, Subscription subscription) {
		return repository.updateSubscription("ab23", subscription);
	}
}