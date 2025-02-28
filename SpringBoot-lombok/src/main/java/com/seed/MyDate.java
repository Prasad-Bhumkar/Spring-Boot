package com.seed;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component("myDate")
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MyDate {
    private int day;
    private int month;
    private int year;

    
}
