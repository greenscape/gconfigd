package io.greenscape.gconfigd.model.impl;

import io.greenscape.gconfigd.model.User;

public class UserImpl implements User {
	public Long getId() {
		return 1L;
	}

	public String getName() {
		return "Default";
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", name=" + getName() + "]";
	}

}
