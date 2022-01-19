package com.zee.zee5app.repository;
import com.zee.zee5app.dto.Subscription;

public class SubscriptionRepository {
	
	private Subscription[] subscriptions = new Subscription[10];
	private static int count=-1;
	private SubscriptionRepository() {
		// TODO Auto-generated constructor stub
	}

	public Subscription[] getSubscription() {
		return subscriptions;
	}

	public String deleteSubscription(String id) {
		return null;
	}

	
	public String updateSubscription(String id , Subscription subscription) {
		subscriptions[++count]=subscription;
		return "added";
	}
	
	public Subscription getSubscriptionById(String id) {
		
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id) ) {
				return subscription;
			}
		}
		
		return null;
		
	}
	
	// add a new user
	public String addSubscription(Subscription subscription) {
		

		if(count==subscriptions.length-1) {

			Subscription temp[] = new Subscription[subscriptions.length*2];
			
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions= temp;
			subscriptions[++count] = subscription;
			
			
			return "success";
			
		}
		subscriptions[++count] = subscription;
		return "success";
		
				
		
	}
	private static SubscriptionRepository subscriptionRepository;
	public static SubscriptionRepository getInstance() {
		
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepository();
		return subscriptionRepository;
		
	}

}
