package com.nb.springbootconsumer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author: nb
 * @Date: 2021/3/20 21:10
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {

    @NotBlank
    private String id;
    @NotBlank
    private String productName;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer num;
    @NotNull
    private BigDecimal totalAmt;
}