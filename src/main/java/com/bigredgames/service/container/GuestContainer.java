package com.bigredgames.service.container;

import java.awt.List;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigredgames.dao.GroupDao;
import com.bigredgames.model.Guest;
import com.bigredgames.service.GuestService;

public class GuestContainer implements GuestService {

	@Autowired
	GroupDao dao;
	
	@Override
	public List getAllGuests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest getGuestById(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void saveGuestById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGuestById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGuestById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAllGuests(List guestList) {
		// TODO Auto-generated method stub
		
	}

}
