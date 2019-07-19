package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Transactional
	public void executeBooking(Booking b) {
		User u = bookingDao.getUser(b.getUser().getEmail(), b.getUser().getPassword());
		Hotel h = bookingDao.findHotelById(b.getHotel().getId());
		b.setUser(u);
		b.setHotel(h);
		bookingDao.createBooking(b);
	}
	
	public List<Hotel> findHotels(SearchCriteria sc){
		return bookingDao.findHotels(sc.getSearchString());
	}
	
	public Hotel findHotelById(long id) {
		return bookingDao.findHotelById(id);
	}
	
	public List<Booking> getAllBookingsOfUser(User user) {
		return bookingDao.getAllBookingsOfUser(user);
	}
	
	public User getUser(String email, String password) {
		return bookingDao.getUser(email, password);
	}
}