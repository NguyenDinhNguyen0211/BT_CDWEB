package btgk.ltw.springboot.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category {
   private String title;
   private Category parent;
   private List<Category> children = new ArrayList<Category>();

   public Category(String title) {
      this.title = title;
   }

   public Category(String title, Category parent) {
      this.title = title;
      if (parent != null) {
         this.parent = parent;
         parent.addChild(this);
      }
   }
   protected void addChild(Category child) {
      this.getChildren().add(child);
   }
}
