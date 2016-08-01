package com.nsg.dp.dao.adapter;

import java.util.List;

/**
 * Created by varshika on 01/08/16.
 */
public class HomepageUIAdapter implements Adapter<HomepageUIVO> {

    @Override
    public List<HomepageUIVO> adapt(byte[] bytes) {
        Parser parser = new HomepageUIParser();
        return parser.parser(bytes);

    }
}
