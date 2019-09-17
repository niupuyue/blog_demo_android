package com.paulniu.library;

import android.content.Context;

/**
 * Coder: niupuyue
 * Date: 2019/9/17
 * Time: 18:06
 * Desc:
 * Version:
 */
public class LibrariesCons {

    private static Context mContext;

    public static void setContext(Context context) {
        mContext = context;
    }

    public static Context getContext() {
        return mContext;
    }

}
