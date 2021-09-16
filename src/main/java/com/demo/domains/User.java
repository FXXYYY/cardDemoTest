package com.demo.domains;

import lombok.Data;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/11 16:18
 */
@Data
public class User {

    /**
     * 人员id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    private String wKno;
}