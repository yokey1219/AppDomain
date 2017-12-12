package com.ef.carparking.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * author : Richile
 * date   : 2017/3/28
 * email  : ruichao1001@foxmail.com
 */

public class Default0GsonBuilder {
    public static Gson build(){
        Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Integer.class, new IntegerDefault0Adapter())
                    .registerTypeAdapter(int.class, new IntegerDefault0Adapter())
                    .registerTypeAdapter(Double.class, new DoubleDefault0Adapter())
                    .registerTypeAdapter(double.class, new DoubleDefault0Adapter())
                    .registerTypeAdapter(Long.class, new LongDefault0Adapter())
                    .registerTypeAdapter(long.class, new LongDefault0Adapter())
                    .create();

        return gson;
    }
}
