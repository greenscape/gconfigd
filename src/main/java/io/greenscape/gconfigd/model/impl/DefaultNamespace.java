package io.greenscape.gconfigd.model.impl;

import io.greenscape.gconfigd.model.Namespace;

public class DefaultNamespace implements Namespace {
	public Long getId() {
		return 1L;
	}

	public String getName() {
		return "Default";
	}

	@Override
	public String toString() {
		return "Organisation [id=" + getId() + ", name=" + getName() + "]";
	}

}
