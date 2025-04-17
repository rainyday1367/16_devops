package com.ohgiraffers.bootproject.dto;

import lombok.*;

/* 설명. 필요에 따라 생성자가 2개만인 DTO를 만들고 싶을 때 사용하는 @NonNull */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CalculatorDTO {
    @NonNull
    private int num1;
    @NonNull
    private int num2;

    private int sum;
}
