package com.imooc.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String address;
    private Date birthday;

}
