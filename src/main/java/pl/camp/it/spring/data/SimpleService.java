package pl.camp.it.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SimpleService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    OrderDAO orderDAO;

    public void addUser() {
        User user = new User(0, "janusz", "janusz");
        this.userDAO.save(user);
    }

    public void getUser() {
        System.out.println(this.userDAO.findById(1));
    }

    public void addOrder() {
        Optional<User> userBox = userDAO.findById(1);
        Order order = new Order();
        order.setUser(userBox.get());
        order.setTotal(100);

        this.orderDAO.save(order);
    }

    public void getOrder() {
        Order order = this.orderDAO.findById(1).get();
        System.out.println(order.getId());
        System.out.println(order.getTotal());
        System.out.println(order.getUser());
    }

    public void addOrderAndUser() {
        User user = new User(0, "wiesiek", "wiesiek");
        Order order = new Order();
        order.setTotal(200);
        order.setUser(user);

        this.orderDAO.save(order);
    }

    public void getUserByLogin() {
        System.out.println(this.userDAO.findByLogin("wiesiek"));
    }

    public void getUserByLoginAndId() {
        System.out.println(this.userDAO.findByLoginAndId("wiesiek", 2));
    }

    @Transactional
    public void createFewUsers() {
        this.userDAO.save(new User(0, "karol", "karol"));
        this.userDAO.save(new User(0, "wiesiek", "wiesiek"));
        this.userDAO.save(new User(0, "zbyszek", "zbyszek"));
        this.userDAO.save(new User(0, "bogdan", "bogdan"));
        this.userDAO.save(new User(0, "franek", "franek"));
        this.userDAO.save(new User(0, "mateusz", "mateusz"));
        this.userDAO.save(new User(0, "janusz", "janusz"));
        this.userDAO.save(new User(0, "piotrek", "piotrek"));
    }

    public void printUsersWhereIdLessThan5() {
        System.out.println(this.userDAO.findUserWhereIdLessThan5());
    }
}
