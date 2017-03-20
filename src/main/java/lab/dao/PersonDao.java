package lab.dao;

import lab.model.User;

import java.util.List;

public interface PersonDao {

    void insert(User user);

    List<User> selectAll();

    default User select(int id) {
        return selectAll().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
