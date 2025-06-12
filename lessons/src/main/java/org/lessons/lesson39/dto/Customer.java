    package org.lessons.lesson39.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {
    private int id;
    private String fullName;
    private String email;
    private String socialSecurityNumber;


}
