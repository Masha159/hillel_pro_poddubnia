package org.lessons.lesson13.Bar;

public enum Drinks {

    COFFEE(200),
    APEROL(500);

    //price in cents
    int price;

     Drinks (int price){
      this.price = price;
    }


}
