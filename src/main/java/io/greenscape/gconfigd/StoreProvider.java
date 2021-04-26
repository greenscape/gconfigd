package io.greenscape.gconfigd;

import java.util.Map;
import java.util.Optional;

public interface StoreProvider {

	Optional<String> getData(String path) throws Exception;

	Map<String, String> getChildren(String path) throws Exception;

	void addPath(String path, String value) throws Exception;

	void deletePath(String path) throws Exception;
}