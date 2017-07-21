package com.werner.webapp.base;

import org.springframework.core.NestedRuntimeException;

/**
 * @author 
 */
public class DaoException extends NestedRuntimeException {

    private static final long serialVersionUID = 1L;

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(String msg, Throwable obj) {
        super(msg, obj);
    }
}