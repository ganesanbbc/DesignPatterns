package com.nsg.dp.dao.fetcher;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by varshika on 31/07/16.
 */
public class AssetDataFetcher implements DataFetcher {

    public static final String RAW = "raw";
    Context context;
    private String fileName;

    public AssetDataFetcher(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    @Override
    public void fetch(DataFetcherCallBack dataFetcherCallBack) {
        InputStream ins = context.getResources().openRawResource(
                context.getResources().getIdentifier(fileName,
                        RAW, context.getPackageName()));
        byte[] data = readTextFile(ins);
        dataFetcherCallBack.onSuccess(data);
    }


    public byte[] readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toByteArray();
    }
}
