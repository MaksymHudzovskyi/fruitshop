package uaedunung.se;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Ivan"));
        users.add(new User("Maria"));
        users.add(new User("Petro"));
    }

    @GET
    public List<User> getUsers() {
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> addUser(User user) {
        users.add(user);
        return users;
    }
}
