package io.greenscape.gconfigd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

@ApplicationScoped
public class ZookeeperProvider implements StoreProvider {

	CuratorFramework client;

	@PostConstruct
	private void init() {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
		client.start();
	}

	@Override
	public Optional<String> getData(String path) throws Exception {
		byte[] b = client.getData().watched().forPath(path);
		return b == null ? Optional.empty() : Optional.of(new String(b));
	}

	@Override
	public Map<String, String> getChildren(String path) throws Exception {
		Map<String, String> map = new HashMap<>();
		List<String> childrens = client.getChildren().watched().forPath(path);
		recursiveFetch(path, childrens, map);
		return map;
	}

	private void recursiveFetch(String parentPath, List<String> childrens, Map<String, String> map) throws Exception {
		for (String path : childrens) {
			String fullPath = parentPath + Util.PATH_SEP + path;
			byte[] bytes = client.getData().watched().forPath(fullPath);

			if (bytes != null) {
				map.put(fullPath, new String(bytes));
			}
			List<String> childs = client.getChildren().watched().forPath(fullPath);
			recursiveFetch(fullPath, childs, map);
		}
	}

	@Override
	public void addPath(String path, String value) throws Exception {
		client.setData().forPath(path, value.getBytes());
	}

	@Override
	public void deletePath(String path) throws Exception {
		client.delete().forPath(path);
	}

}
