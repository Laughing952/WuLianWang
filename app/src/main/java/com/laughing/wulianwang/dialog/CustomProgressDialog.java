package com.laughing.wulianwang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 作者：Laughing on 2018/6/25 10:47
 * 邮箱：719240226@qq.com
 */
public class CustomProgressDialog extends Dialog {
    public CustomProgressDialog(@NonNull Context context) {
        super(context);
    }

    public CustomProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
