package org.lessons.lesson41.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private int id;
  private int totalCost;
  private List<Product> products;
  private Date createdAt;
}
