package jp.co.nino.learning.mainScreen.dash;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * Created by liu.rui on 2017/12/13.
 */

final public class DashPresenter implements DashContract.Presenter {

    @Nullable
    private DashContract.View mMainView;

    @Inject
    DashPresenter() {
        // Requires empty public constructor
    }

    @Override
    public void takeView(DashContract.View view) {
        this.mMainView = view;
        mMainView.setSpinner();
    }

    @Override
    public void dropView() {
        if (mMainView != null) {
            mMainView = null;
        }
    }

}
