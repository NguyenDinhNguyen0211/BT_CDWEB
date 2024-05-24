package btgk.ltw.springboot.controller;

import btgk.ltw.springboot.Utils.AuthUtils;
import btgk.ltw.springboot.model.Category;
import btgk.ltw.springboot.model.Message;
import btgk.ltw.springboot.model.Topic;
import btgk.ltw.springboot.service.ForumService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class web {
    @GetMapping("/topics")
    public String topic(HttpSession session, Model model) {
//        if (!AuthUtils.isAuth(session)) {
//            return "redirect:/login";
//        }
        List<Topic> list = ForumService.getInstance().getTopics();
        model.addAttribute("topics", list);
        return "listTopic";
    }

    @GetMapping("/topic-details/{id}")
    public String detailsTopic(HttpSession session, Model model, @PathVariable Integer id) {
        if (!AuthUtils.isAuth(session)) {
            return "redirect:/login";
        }
        if (id == null) {
            return "listTopic";
        }
        Topic topic = ForumService.getInstance().findTopic(id);
        model.addAttribute("topic", topic);
        return "topic-details";
    }

    @GetMapping("/topic-reply/{id}")
    public String viewReplyTopic(HttpSession session, Model model, @PathVariable Integer id) {
        if (!AuthUtils.isAuth(session)) {
            return "redirect:/login";
        }
        if (id == null) {
            return "listTopic";
        }
        Topic topic = ForumService.getInstance().findTopic(id);
        model.addAttribute("topic", topic);
        return "topic-reply";
    }

    @PostMapping("/reply/{id}")
    public String replyTopic(HttpSession session, HttpServletRequest request, @PathVariable Integer id) {
        if (id == null) {
            return "listTopic";
        }
        Topic topic = ForumService.getInstance().findTopic(id);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        topic.addMessage(new Message(title, content, AuthUtils.getAuth(session)));
        return "redirect:/topic-details/" + id;
    }

    @GetMapping("/topic-create")
    public String viewCreateTopic(HttpSession session) {
        if (!AuthUtils.isAuth(session)) {
            return "redirect:/login";
        }
        return "topic-create";
    }

    @PostMapping("/create")
    public String createTopic(HttpSession session, HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Category cat1 = new Category("Học hành");
        int id = ForumService.getInstance().getTopics().size() + 1;
        Topic topic = new Topic(id, title,
                content, AuthUtils.getAuth(session),
                cat1);
        ForumService.getInstance().add(topic);
        return "redirect:/topics";
    }
}
