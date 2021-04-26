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

import io.greenscape.gconfigd.model.User;
import io.greenscape.gconfigd.model.impl.UserImpl;

@Path("admin/user")
public class UsersResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		User user = new UserImpl();
		users.add(user);
		return users;
	}

	@GET
	@Path("/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public User getUser(@PathParam("userId") Long userId) {
		User user = new UserImpl();
		return user;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public User addUser() {
		User user = new UserImpl();
		return user;
	}

	@PUT
	@Path("/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public User updateUser(@PathParam("userId") Long userId) {
		User user = new UserImpl();
		return user;
	}

	@DELETE
	@Path("/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public void removeUser(@PathParam("userId") Long userId) {
	}

	@GET
	@Path("/{orgId}")
	@Produces(MediaType.TEXT_PLAIN)
	public List<User> getAllOrganisationUsers(@PathParam("orgId") Long orgId) {
		List<User> users = new ArrayList<>();
		User user = new UserImpl();
		users.add(user);
		return users;
	}

	@GET
	@Path("/{orgId}/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public User getUser(@PathParam("orgId") Long orgId, @PathParam("userId") Long userId) {
		User user = new UserImpl();
		return user;
	}

	@POST
	@Path("/{orgId}")
	@Produces(MediaType.TEXT_PLAIN)
	public User addUser(@PathParam("orgId") Long orgId) {
		User user = new UserImpl();
		return user;
	}

	@PUT
	@Path("/{orgId}/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public User updateUser(@PathParam("orgId") Long orgId, @PathParam("userId") Long userId) {
		User user = new UserImpl();
		return user;
	}

	@DELETE
	@Path("/{orgId}/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public void removeUser(@PathParam("orgId") Long orgId, @PathParam("userId") Long userId) {
	}
}