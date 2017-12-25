package jp.co.nino.learning.mainScreen.dash;

import jp.co.nino.learning.ui.BasePresenter;
import jp.co.nino.learning.ui.BaseView;

/**
 * Created by liu.rui on 2017/12/13.
 */

public interface DashContract {

    interface View extends BaseView<Presenter> {

        void showMessage(int resId);

        void setSpinner();

    }

    interface Presenter extends BasePresenter<View> {

        void takeView(DashContract.View view);

        void dropView();

    }

}
