package com.nsg.dp.dao.services;

/**
 * Created by varshika on 01/08/16.
 */
public class ServiceLocator {



    public void request(){


        Service service = new HomepageUIService();

        service.request(new ServiceCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }
}
