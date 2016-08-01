package com.nsg.dp.dao.services;

/**
 * Created by varshika on 01/08/16.
 */
public interface Service<O> {
    void request(ServiceCallback serviceListener);
}
