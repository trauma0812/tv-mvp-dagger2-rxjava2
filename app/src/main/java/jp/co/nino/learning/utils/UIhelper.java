package jp.co.nino.learning.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liu.rui on 2017/12/22.
 */

public class UIhelper {

    public static String parseUnixTimeToString(String format, long unixTime) {
        Date date  = new Date(unixTime);
        String dateStr = new SimpleDateFormat(format).format(date);

        return dateStr;
    }

    public static void showMessageBySnackbar(View view, String message, int resId1, int resId2) {
        Snackbar snackbar;
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(resId1);
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(resId2);
        snackbar.show();
    }

}
