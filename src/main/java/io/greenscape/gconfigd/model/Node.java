package io.greenscape.gconfigd.model;

import java.util.Collection;
import java.util.Optional;

public interface Node {
	String PATH_SEPERATOR = ".";

	String getName();

	<T> Optional<T> getValue();

	Optional<Node> getParentNode();

	String getPath();

	Collection<Node> getChildren();
}
