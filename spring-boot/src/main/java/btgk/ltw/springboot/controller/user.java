package btgk.ltw.springboot.controller;

import btgk.ltw.springboot.model.User;
import btgk.ltw.springboot.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class user {
    @ResponseBody
    @GetMapping("/list-user")
    public List<User> listUser() {
        return ForumService.getInstance().getUser();
    }
}
