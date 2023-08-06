package pl.camp.it.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

    @Autowired
    SimpleService simpleService;

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public String test1() {
        this.simpleService.addUser();
        return "test";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2() {
        this.simpleService.getUser();
        return "test";
    }

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public String test3() {
        this.simpleService.addOrder();
        return "test";
    }

    @RequestMapping(path = "/test4", method = RequestMethod.GET)
    public String test4() {
        this.simpleService.getOrder();
        return "test";
    }

    @RequestMapping(path = "/test5", method = RequestMethod.GET)
    public String test5() {
        this.simpleService.addOrderAndUser();
        return "test";
    }

    @RequestMapping(path = "/test6", method = RequestMethod.GET)
    public String test6() {
        this.simpleService.getUserByLogin();
        return "test";
    }

    @RequestMapping(path = "/test7", method = RequestMethod.GET)
    public String test7() {
        this.simpleService.getUserByLoginAndId();
        return "test";
    }

    @GetMapping(path = "/test8")
    public String test8() {
        this.simpleService.createFewUsers();
        return "test";
    }

    @GetMapping(path = "/test9")
    public String test9() {
        this.simpleService.printUsersWhereIdLessThan5();
        return "test";
    }
}
