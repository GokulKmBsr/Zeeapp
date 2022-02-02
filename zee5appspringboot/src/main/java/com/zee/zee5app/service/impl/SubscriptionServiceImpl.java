package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.repository.SubscriptionRepository;
//import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public String addSubscription(Subscription subscription) throws InvalidAmountException {
		// TODO Auto-generated method stub
		Subscription subscription2 = subscriptionRepository.save(subscription);
		if (subscription2 != null) {
			return "Successfully added subscription";
		} else {
			return "failed toadd subscription";
		}
		//return null;
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional;
		try {
			optional = this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				subscriptionRepository.deleteById(id);
				return "subscription deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		//return null;
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(id);
		//return null;
	}

	@Override
	public Optional<List<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
		//return null;
	}

//	private SubscriptionRepository repository = SubscriptionRepositoryImpl.getInstance();
//	private static SubscriptionService service;	
//	
//	public static SubscriptionService getInstance() throws IOException {
//		if(service == null)
//			service = new SubscriptionServiceImpl();
//		return service;
//	}
//	
//    private SubscriptionServiceImpl() throws IOException {
//		
//	}

//	@Override
//	public String addSubscription(Subscription subscription) throws InvalidAmountException {
//		// TODO Auto-generated method stub
//		return this.repository.addSubscription(subscription);
//	}
//
//	@Override
//	public String deleteSubscription(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.deleteSubscription(id);
//	}
//
//	@Override
//	public String modifySubscription(String id, Subscription subscription) {
//		// TODO Auto-generated method stub
//		return this.repository.modifySubscription(id, subscription);
//	}
//
//	@Override
//	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
//		// TODO Auto-generated method stub
//		return this.repository.getSubscriptionById(id);
//	}
//
//	@Override
//	public Optional<List<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
//		// TODO Auto-generated method stub
//		return this.repository.getAllSubscription();
//	}
	
//	@Override
//	public String addSubscription(Subscription subscription) {
//		// TODO Auto-generated method stub
//		return this.repository.addSubscription(subscription);
//	}
//
//	@Override
//	public Subscription getSubscriptionById(String id) {
//		// TODO Auto-generated method stub
//		return this.repository.getSubscriptionById(id);
//	}
//
//	@Override
//	public Subscription[] getAllSubscriptions() {
//		// TODO Auto-generated method stub
//		return repository.getAllSubscription();
//	}

}