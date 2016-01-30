package com.hankkin.multipurposelistview.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Hankkin on 16/1/30.
 */
public class HankkinUtil {
    public static int dp2px(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * 提示字符串
     * short Toast
     *
     * @param context
     * @param text    by Hankkin at:2015-10-07 21:14:43
     */
    public static void showToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 提示字符串
     * short Toast
     *
     * @param context
     * @param text    by Hankkin at:2015-10-07 21:14:43
     */
    public static void showLToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 提示根据ResId关联字符串
     * short Toast
     *
     * @param context
     * @param resId   by Hankkin at:2015-10-07 21:14:43
     */
    public static void showToast(Context context, int resId) {
        Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
