package com.leif.knowme.controller;

import com.leif.knowme.base.KmRequest;
import com.leif.knowme.exception.AuthException;

/**
 * @author HelloLeif
 * @date 2020/8/30
 */
public abstract class BaseController {
    protected void checkRequest(KmRequest<Object> request, String accountId) throws AuthException {
        if (!request.getHeader().getAccountId().equals(accountId)) {
            throw new AuthException("Not your account! Asshole!");
        }
    }
}
