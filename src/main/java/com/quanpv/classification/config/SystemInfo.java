package com.quanpv.classification.config;


public class SystemInfo {

    static {
        ConfigUtils.loadConfig();
    }

    public static String PATH_RAW_DATA_TRAIN;
    public static String PATH_DATA_TRAIN;
    public static String PATH_DATA_TEST;
    public static String PATH_TRAINED_MODEL;
    public static int MAX_ITERATOR;
    public static float PERCENT_TEST;
}

