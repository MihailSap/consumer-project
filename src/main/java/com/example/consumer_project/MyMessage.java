package com.example.consumer_project;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyMessage {
    String text;
    Integer number;
    Double price;
}
