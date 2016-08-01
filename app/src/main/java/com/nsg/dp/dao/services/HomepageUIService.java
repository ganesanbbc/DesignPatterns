package com.nsg.dp.dao.services;

import com.nsg.dp.dao.adapter.Adapter;
import com.nsg.dp.dao.adapter.HomepageUIVO;
import com.nsg.dp.dao.fetcher.DataFetcher;
import com.nsg.dp.dao.fetcher.DataFetcherCallBack;

public class HomepageUIService implements Service<HomepageUIVO> {

    @Override
    public void request(DataFetcher dataFetcher, final Adapter<HomepageUIVO> adapter) {

        dataFetcher.fetch(new DataFetcherCallBack() {
            @Override
            public void onSuccess(byte[] data) {
                adapter.adapt(data);
            }
        });


    }
}