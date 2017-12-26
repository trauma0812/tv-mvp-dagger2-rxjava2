package jp.co.nino.learning.mainScreen.home;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import jp.co.nino.learning.R;

/**
 * Created by liu.rui on 2017/12/26.
 */

public class HomeListItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private static int adjustment = 15;

    public HomeListItemDecoration(int space) {
        this.space = space;
    }

    public static HomeListItemDecoration createDefaultDecoration(Context context) {
        int spacingInPixels = context.getResources().getDimensionPixelSize(R.dimen.home_list_item_margin);
        return new HomeListItemDecoration(spacingInPixels);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
        outRect.left = space - adjustment;
        outRect.right = space - adjustment;
        outRect.bottom = space;

    }

}
