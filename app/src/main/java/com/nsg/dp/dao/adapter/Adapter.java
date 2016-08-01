package com.nsg.dp.dao.adapter;

import java.util.List;

/**
 * Created by varshika on 01/08/16.
 */
public interface Adapter<O> {

    List<O> adapt(byte[] bytes);
}
