package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ApplicationContext ctx = new ClassPathXmlBeanApplicationContext("beans.xml");
		ctx.scan("com.visa");
		ctx.refresh();

		BookingService service = ctx.getBean("bookingService", BookingService.class);
//		User u = new User();
//		u.setEmail("a@visa.com");
//		u.setPassword("pass");
//		
//		Hotel h = new Hotel();
//		h.setId(1L);
//		Booking b = new Booking(h, u);
//		b.setBeds(2);
//		b.setSmoking(false);
//		service.executeBooking(b);

		SearchCriteria sc = new SearchCriteria();
		sc.setPage(1);
		sc.setPageSize(10);
		sc.setSearchString("Westin");
		
		List<Hotel> hotels = service.findHotels(sc);
		for (Hotel h : hotels) {
			System.out.println(h.getName());
		}
		
		User u = service.getUser("a@visa.com", "pass");
		List<Booking> bookingsByUser = service.getAllBookingsOfUser(u);
		for (Booking b : bookingsByUser) {
			System.out.println(b);
		}

	}

}