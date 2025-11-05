package com.mh.test;

import android.content.pm.IPackageManager;

public class HMAService {

    public static IPackageManager pms;

    private HMAService Instance;

    private HMAService() {
    }

    public HMAService getInstance() {
        if (Instance == null) {
            Instance = new HMAService();
        }
        return Instance;
    }
}
