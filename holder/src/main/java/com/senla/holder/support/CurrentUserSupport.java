package com.senla.holder.support;

import com.senla.entity.User;
import com.senla.holder.provider.ApplicationContextProvider;
import com.senla.holder.user.CurrentUserHolder;

public interface CurrentUserSupport {
	public default User getCurrentUser() {
		return ApplicationContextProvider.getApplicationContext().getBean(CurrentUserHolder.class).getCurrentUser();
	}
}
