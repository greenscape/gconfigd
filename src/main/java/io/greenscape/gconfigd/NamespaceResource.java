package io.greenscape.gconfigd;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.greenscape.gconfigd.model.Namespace;
import io.greenscape.gconfigd.model.impl.DefaultNamespace;

@Path("admin/namespace")
public class NamespaceResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Namespace> getNamespaces() {
		List<Namespace> namespaces = new ArrayList<>();
		Namespace namespace = new DefaultNamespace();
		namespaces.add(namespace);
		return namespaces;
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Namespace getNamespace(@PathParam("name") String name) {
		Namespace namespace = new DefaultNamespace();
		return namespace;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Namespace addNamespace() {
		Namespace namespace = new DefaultNamespace();
		return namespace;
	}

	@PUT
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Namespace updateNamespace(@PathParam("name") String name) {
		Namespace namespace = new DefaultNamespace();
		return namespace;
	}

	@DELETE
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public void removeNamespace(@PathParam("name") String name) {
	}
}