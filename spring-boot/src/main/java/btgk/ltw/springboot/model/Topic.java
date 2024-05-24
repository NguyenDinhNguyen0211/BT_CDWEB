package btgk.ltw.springboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
@Setter
@ToString
public class Topic extends Entry implements Serializable {
    private Integer id;
    private Stack<Message> messages = new Stack<>();
    private Category category;

    public Topic(Integer id, String title, String content,
                 User creator, Category category) {
        super(title, content, creator);
        this.id = id;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessages(Stack<Message> messages) {
        this.messages = messages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        if (messages.isEmpty()) {
            return new ArrayList<>();
        }
        return messages.subList(0, messages.size());
    }

    public void addMessage(Message message) {
        messages.push(message);
    }

    public Message getNewMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.peek();
    }
}
