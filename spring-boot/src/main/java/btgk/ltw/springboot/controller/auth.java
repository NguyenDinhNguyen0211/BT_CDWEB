package btgk.ltw.springboot.controller;

import btgk.ltw.springboot.Utils.AuthUtils;
import btgk.ltw.springboot.model.User;
import btgk.ltw.springboot.service.ForumService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class auth {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User userLogin = ForumService.getInstance().checkUser(username, password);
        ModelAndView mav = new ModelAndView("login");
        if (userLogin == null) {
            mav.addObject("message", "Sai tài khoản hoặc mật khẩu.");
            return mav;
        }
        session.setAttribute(AuthUtils.USER_SESSION, userLogin);
        mav = new ModelAndView(new RedirectView("/topics", true));
        return mav;
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Xóa session hiện tại
        }
        return "redirect:/login"; // Chuyển hướng đến trang đăng nhập hoặc trang chính
    }

}
