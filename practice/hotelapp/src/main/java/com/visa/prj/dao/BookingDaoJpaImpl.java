package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		TypedQuery<Hotel> query = em.
				createQuery("select h from Hotel h where hotel_name LIKE :n or address LIKE :a", Hotel.class);
		query.setParameter("n", "%"+criteria+"%");
		query.setParameter("a", "%"+criteria+"%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		TypedQuery<User> query = em.createQuery("from User where email= :e and password= :p", User.class);
		query.setParameter("e", email);
		query.setParameter("p", password);
		return query.getResultList().get(0);
	}

	@Override
	public long createBooking(Booking booking) {
		em.persist(booking);
		return 1;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		TypedQuery<Booking> query = em.createQuery("from Booking where user_id= :u", Booking.class);
		query.setParameter("u", user.getEmail());
		return query.getResultList();
	}

}
