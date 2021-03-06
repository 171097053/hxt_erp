package com.jsh.erp.utils;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 返回信息实体
 *
 * @author Dongpo
 */
@Getter
@Setter
@AllArgsConstructor
public class Result implements Serializable {
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 提示信息
     */
    private String msg;
}

