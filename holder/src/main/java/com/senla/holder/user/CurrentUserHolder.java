package com.senla.holder.user;

import com.senla.entity.User;

public class CurrentUserHolder {

	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
