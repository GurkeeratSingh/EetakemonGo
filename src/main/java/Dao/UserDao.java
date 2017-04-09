package Dao;

import Model.User;
import org.omg.CORBA.UShortSeqHelper;

import java.util.Hashtable;
import java.util.List;


/**
 * Created by Miguel Angel on 04/04/2017.
 */
public class UserDao implements IUserDao{

    private static IGenericDao<User> _service;

    public UserDao(IGenericDao<User> service)
    {
        _service = service;
    }

    public boolean add(User user){
        return _service.add(user);
    }

    public boolean updateById(User user) {
        return _service.updateById(user);
    }

    public boolean removeById(User user) {
        return _service.removeById(user);
    }

    public List<User> getAll() {
        return _service.getAll(User.class);
    }



    public User getUserByUsernameAndPassword(String username, String password)
    {
        User user = new User();

        Hashtable<String, String> conditions = new Hashtable<>();
        conditions.put("username", username);
        conditions.put("password", password);
        return _service.getByParameter(user, conditions);

    }

    public User getUserById(int id) {
        User user = new User();
        Hashtable<String, String> conditions = new Hashtable<>();
        conditions.put("id", Integer.toString(id));
        return _service.getByParameter(user, conditions);
    }

    public boolean isUsernameAlreadyInUse(String username) {
        User user = new User();
        Hashtable<String, String> conditions = new Hashtable<>();
        conditions.put("username", username);
        User result = _service.getByParameter(user, conditions);
        return result.username != null;
    }

    public boolean isEmailAlreadyInUse(String email) {
        User user = new User();
        Hashtable<String, String> conditions = new Hashtable<>();
        conditions.put("email", email);
        User result = _service.getByParameter(user, conditions);
        return result.email != null;
    }



/*
    private User getByParameter(User user, Hashtable<String,String> condition) {
        return _service.getByParameter(user, condition);
    }
*/
}