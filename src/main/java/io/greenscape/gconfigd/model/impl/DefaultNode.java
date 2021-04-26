package io.greenscape.gconfigd.model.impl;

import java.util.Collection;
import java.util.Optional;

import io.greenscape.gconfigd.model.Node;

public class DefaultNode implements Node {
	private String name;
	private Optional<Node> parentNode = Optional.empty();
	private Optional<?> value;

	public DefaultNode(String name, Object value) {
		this.name = name;
		if (value == null) {
			this.value = Optional.empty();
		} else {
			this.value = Optional.of(value);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Optional<Node> getParentNode() {
		return parentNode;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Optional<T> getValue() {
		return (Optional<T>) value;
	}

	@Override
	public String getPath() {
		String path = name;
		Optional<Node> parent = parentNode;
		while (parent.isPresent()) {
			path = parent.get().getName() + PATH_SEPERATOR + path;
			parent = parent.get().getParentNode();
		}
		return path;
	}

	@Override
	public Collection<Node> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}
}
