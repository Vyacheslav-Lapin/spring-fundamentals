/**
 *
 */
package lab.dao;

import lab.model.simple.SimpleUser;
import lab.model.User;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author it.vaclav.kiev.ua
 */
@Log
public class HsqlPersonDao extends JdbcDaoSupport implements PersonDao {

    @Override
    public void insert(User user) {

        if (user != null) {
            log.finer(() -> "Processing user: " + user);
            getJdbcTemplate().update(
                    "INSERT INTO user (firstname, lastname) VALUES (?, ?)",
                    user.getFirstName(),
                    user.getLastName());

        } else {
            log.finer("Domain user is null!");
        }
    }

    @Override
    public User select(int id) {

        User user = null;

        if (id > 0) {
            user = getJdbcTemplate().queryForObject(
                    "SELECT id, firstname, lastname FROM user WHERE id = ?",
                    new Object[]{id}, new UserMapper());
        }
        log.finer("Receidved user: " + user);

        return user;
    }

    @Override
    public List<User> selectAll() {
        return this.getJdbcTemplate().query(
                "SELECT id, firstname, lastname FROM user"
                , new UserMapper());
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            SimpleUser user = new SimpleUser();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            return user;
        }
    }
}
