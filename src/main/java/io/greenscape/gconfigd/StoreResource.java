package io.greenscape.gconfigd;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {
	@Inject
	StoreProvider store;

	@GET
	@Path("key/{namespace}/{key}")
	public Response getValue(@PathParam("namespace") String namespace, @PathParam("key") String key) throws Exception {
		String path = key.replace(".", Util.PATH_SEP);
		return Response.ok(store.getData(Util.PATH_SEP + namespace + Util.PATH_SEP + path).orElse("Not found")).build();
	}

	@POST
	@Path("keys/{namespace}/{key}/{value}")
	public Response addValue(@PathParam("namespace") String namespace, @PathParam("key") String key,
			@PathParam("value") String value) throws Exception {
		store.addPath(Util.PATH_SEP + namespace + Util.PATH_SEP + key.replace(".", Util.PATH_SEP), value);
		return Response.ok().build();
	}

	@PUT
	@Path("keys/{namespace}/{key}/{value}")
	public Response updateValue(@PathParam("namespace") String namespace, @PathParam("key") String key,
			@PathParam("value") String value) throws Exception {
		store.addPath(Util.PATH_SEP + namespace + Util.PATH_SEP + key.replace(".", Util.PATH_SEP), value);
		return Response.ok().build();
	}

	@GET
	@Path("keys/{namespace}/{key}")
	public Response getChildren(@PathParam("namespace") String namespace, @PathParam("key") String key)
			throws Exception {
		String path = key.replace(".", Util.PATH_SEP);
		Map<String, String> map = store.getChildren(Util.PATH_SEP + namespace + Util.PATH_SEP + path);
		Map<String, String> map1 = new HashMap<>();
		map.forEach((prop, value) -> {
			map1.put(prop.replace(Util.PATH_SEP + namespace + Util.PATH_SEP, "").replace(Util.PATH_SEP, "."), value);
		});
		return Response.ok(map1).build();
	}

	@GET
	@Path("keys/{namespace}/{key}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getChildrenText(@PathParam("namespace") String namespace, @PathParam("key") String key)
			throws Exception {
		String path = key.replace(".", Util.PATH_SEP);
		Map<String, String> map = store.getChildren(Util.PATH_SEP + namespace + Util.PATH_SEP + path);
		Map<String, String> map1 = new HashMap<>();
		map.forEach((prop, value) -> {
			map1.put(prop.replace(Util.PATH_SEP + namespace + Util.PATH_SEP, "").replace(Util.PATH_SEP, "."), value);
		});
		return Response.ok(map1).build();
	}

	@DELETE
	@Path("keys/{namespace}/{key}")
	public Response deleteKey(@PathParam("namespace") String namespace, @PathParam("key") String key) throws Exception {
		store.deletePath(Util.PATH_SEP + namespace + Util.PATH_SEP + key.replace(".", Util.PATH_SEP));
		return Response.ok().build();
	}
}