package com.bigredgames.service;

import java.awt.List;

import com.bigredgames.model.Guest;

public interface GuestService {

	public List getAllGuests();
	public Guest getGuestById(int id);
	public void saveAllGuests(List guestList);
	public void saveGuestById(int id);
	public void deleteGuestById(int id);
	public void updateGuestById(int id);
}
