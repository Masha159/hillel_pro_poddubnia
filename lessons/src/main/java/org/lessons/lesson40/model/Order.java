package org.lessons.lesson40.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.crypto.Data;
import java.util.List;

@Setter
@Getter
@ToString
public class Order {
    private int id;
    private Data creationDate;
    private double totalCost;
    private List<Product> products;
}
