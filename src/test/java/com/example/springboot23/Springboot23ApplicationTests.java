package com.example.springboot23;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
    Unit testing -- Class with methods are working as expected(business logic)

    Integration testing - repository layers,services
 */


class   Springboot23ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void itShouldAddTwoNumbers(){
        var calculator = new Calculator();
        //Given
        int a = 10;
        int b = 5;

        //when
        int res = calculator.addNumbers(a,b);

        //Then
        assertThat(res).isEqualTo(20);

    }

    class Calculator {
        public Integer addNumbers(Integer a, Integer b){
            return a + b;
        }
    }

}
