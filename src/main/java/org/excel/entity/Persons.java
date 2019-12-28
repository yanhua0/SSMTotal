package org.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persons {
    @ExcelProperty(value = {"姓名"},index = 0)
    private String name;
    @ExcelProperty(value = {"年龄"},index = 0)
    private Integer age;
    @ExcelProperty(value = {"地址"},index = 0)
    private String address;
}
