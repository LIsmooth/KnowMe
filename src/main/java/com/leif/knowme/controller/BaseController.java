package com.leif.knowme.controller;

import com.leif.knowme.exception.AuthException;

/**
 * @author HelloLeif
 * @date 2020/8/30
 */
public abstract class BaseController {
    protected void checkRequest(String token, String accountId) throws AuthException {

    }
}
