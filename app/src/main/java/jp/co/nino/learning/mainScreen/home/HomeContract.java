package jp.co.nino.learning.mainScreen.home;

import android.content.Context;

import java.util.List;

import jp.co.nino.learning.data.api.model.Genre1;
import jp.co.nino.learning.ui.BasePresenter;
import jp.co.nino.learning.ui.BaseView;

/**
 * Created by liu.rui on 2017/12/13.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showMessage(String message);

        void showMessage(int resId);

        void setHomeListData(List<Genre1> genre1s);

    }

    interface Presenter extends BasePresenter<View> {

        void takeView(HomeContract.View view);

        void dropView();

        void setParams(Context context);

        void getTvProgram();

    }

}
