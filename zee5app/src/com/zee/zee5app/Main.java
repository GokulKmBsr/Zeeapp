package com.zee.zee5app;

import java.util.Iterator;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.MoviesService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceimpl;

public class Main {

	public static void main(String[] args) throws InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		
		Register register6 = new Register("ab0001","abhi","chivate", "abc@gmail.com", "ac123");
		System.out.println(register6);

		Register register = new Register();
		//Register : class name
		// register : reference which will refer your object
		// new : is used to create the object 
		// Register() : constructor ===> DC ==> IDC
		
		try {
			register.setFirstName("abhi");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			register.setLastName("chivate");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		register.setEmail("abhi@gmail.com");
		register.setPassword("abhi1234");
		try {
			register.setId("ab00001");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(register);
		// whenever you will print the reference then it 
		// will call toString() method.
		
		System.out.println(register.toString());
	
		System.out.println(register.getEmail());
		
		// can u create the login object?
		// then can u print the login detials?
		Login login = new Login();
		login.setUsername("bsr");
		login.setPassword("abc123");
		System.out.println(login);
		
		//UserService service = UserService.getInstance();
		//we commented this because now we are using interface 
		UserService service = UserServiceimpl.getInstance();
		
		for(int i=1;i<=20;i++) {
		
			Register register2 = new Register();
			try {
				register2.setId("ab0000"+i);
				register2.setLastName("chivate"+i);
				register2.setFirstName("abhi"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			catch (Throwable e) {
				// TODO: handle exception
			}
			
			//According to the logic object should work 
			//but in catch maximum will take throwable its won't take throwable parent object
			//the jvm has written by somebody in this way
//			catch (object e) {
//				// TODO: handle exception
//			}
			
			register2.setPassword("abhi");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
		//Optional<Register> optional = service.getUserById("ab0001");
		//if(optional)
		
//		SubscriptionService service2 = SubscriptionService.getInstance();
//		
//		for(int i =1; i<=10;i++) {
//			Subscription subscription = new Subscription();
//			subscription.setType(null);
//			subscription.setId("s"+i);
//			subscription.setEmail(null);
//			subscription.setDateofpurcahse(null);
//			subscription.setStatus(null);
//			subscription.setPaymentmode(null);
//			subscription.setPackCountry(null);
//			subscription.setExpiryDate(null);
//			String result = service2.addSubscription(subscription);
//			System.out.println(result);
//			
//		}
//		
//		MoviesService service3 = MoviesService.getInstance();
//		for(int i =1; i<=3;i++) {
//			Movies movie = new Movies();
//			movie.setId("m"+i);
//			movie.setMovieName("puspa"+i);
//			movie.setCatagory(null);
//			movie.setReleaseDate(null);
//			movie.setTrailer(null);
//			movie.setLanguage(null);
//			movie.setMovieLength(null);
//			movie.setCast(args);
//			String result = service3.addMovies(movie);
//			System.out.println(result);
//			
//		}
//		
//		SeriesService service4 = SeriesService.getInstance();
//		for(int i =1; i<=10;i++) {
//			Series series = new Series();
//			series.setId("s"+i);
//			series.setSeriesName("abc"+i);
//			series.setCatagory(null);
//			series.setReleaseDate(null);
//			series.setTrailer(null);
//			series.setLanguage(null);
//			series.setCast(args);
//			series.setSeriesLength(null);
//			String result = service4.addSeries(series);
//			System.out.println(result);
//			
//		}
		
		
	
		
		
		// userservice object
		// main is consuming the service ?
		
		Optional<Register> optional;
		try {
			optional = service.getUserById("abhi1");
			if (optional.isPresent()) {
				System.out.println("getUserById"+optional.get());
			}
			else {
				System.out.println("Id not found ");
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.getAllUserDetails().forEach(e->System.out.println(e));
		//System.out.println(register2!=null);
		
//		for (Register register3 : service.getAllUsers()) {
//			if(register3!=null)
//			System.out.println(register3);
//		}
		
//		for (Subscription subscription : service2.getSubscription()) {
//			if(subscription!=null)
//			 System.out.println(subscription);
//					
//		}
//		
//		for (Movies movie : service3.getMovies()) {
//			if(movie!=null)
//			 System.out.println(movie);
//					
//		}
//		
//		for (Series series : service4.getSeries()) {
//			if(series!=null)
//			 System.out.println(series);
//					
//		}
		
		
		UserRepository repository = null;
		
		
	}

}