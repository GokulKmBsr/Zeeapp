//package com.zee.zee5app;
//
//import com.zee.zee5app.dto.Login;
//import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.service.UserService;
//
//public class Main {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Register register = new Register();
//		//Register :class name
//		//register : reference which will refer your object
//		//new : is used to create the object 
//		//Register() : constructor ==> DC
//		register.setFirstName("GOKUL");
//		register.setLastName("K M");
//		register.setEmail("gokul@gmail.com");
//		register.setPassword("gokul123");
//		
//		System.out.println(register);
//		//whenever you will print the reference then it will call toString() method.
//		
//		System.out.println(register.toString());
//		System.out.println(register.getEmail());
//		
//		Login login = new Login();
//		login.setUsername("bsr");
//		login.setPassword("abc123");
//		System.out.println(login);
//		System.out.println(login.getPassword());
//		
//		//UserService service = new UserService();
//		UserService service = UserService.getInstance();
//		
//		for (int i=1;i<=20;i++) {
//			Register register2 =new Register();
//			register2.setId("gok00"+i);
//			register2.setFirstName("gokul"+i);
//			register2.setLastName("k m"+i);
//			register2.setPassword("bsr123");
//			String result = service.addUser(register);
//			System.out.println(result);
//		}
//		
//		Register register2 = service.getUserById("gk1");
//		System.out.println(register2!=null);
//		
//		for (Register register3 : service.getUsers()) {
//			if (register3!=null)
//			System.out.println(register3);
//		}
//		
//
//	}
//
//}


package com.zee.zee5app;

import java.util.Iterator;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Register register = new Register();
		//Register : class name
		// register : reference which will refer your object
		// new : is used to create the object 
		// Register() : constructor ===> DC ==> IDC
		
		register.setFirstName("abhi");
		register.setLastName("chivate");
		register.setEmail("abhi@gmail.com");
		register.setPassword("abhi1234");
		
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
		System.out.println(login.getPassword());
		
		UserService service = UserService.getInstance();
		
		for(int i=1;i<=20;i++) {
		
			Register register2 = new Register();
			register2.setId("ab00"+i);
			register2.setFirstName("abhi"+i);
			register2.setLastName("chivate"+i);
			register2.setPassword("abhi");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
	
		
		
		// userservice object
		// main is consuming the service ?
		
		Register register2 = service.getUserById("abhi1");
		System.out.println(register2!=null);
		
		for (Register register3 : service.getUsers()) {
			if(register3!=null)
			System.out.println(register3);
		}
		
		//movie
		Movies movie = new Movies();
		movie.setMovieName("pushpa");
		movie.setCatagory("Action/Drama");
		movie.setReleaseDate("17-12-2021");
		movie.setTrailer("https://youtu.be/uU4_YJmD_MY");
		movie.setLanguage("Kannada");
		//movie.setCast({"Allu Arjun", "Rashmika Mandanna", "Jagapathi Babu", "Prakash Raj"});
		movie.setMovieLength("2:30");
		movie.setId("pushpa1");
		
		System.out.println(movie.getMovieName());
		
		for(Register register3 : service.updateUser()) {
			System.out.println(register3);
		}
		
	}

}