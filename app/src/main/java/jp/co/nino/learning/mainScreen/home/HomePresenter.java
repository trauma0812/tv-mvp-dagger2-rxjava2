package jp.co.nino.learning.mainScreen.home;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;
import javax.inject.Inject;

import jp.co.nino.learning.R;
import jp.co.nino.learning.data.DataRepository;
import jp.co.nino.learning.data.DataSource;
import jp.co.nino.learning.data.api.ApiUrl;
import jp.co.nino.learning.data.api.model.Genre1;
import jp.co.nino.learning.data.api.model.RequestParams;
import jp.co.nino.learning.utils.UIhelper;

/**
 * Created by liu.rui on 2017/12/13.
 */

final public class HomePresenter implements HomeContract.Presenter {

    private DataRepository mDataRepository;

    @Nullable
    private HomeContract.View mMainView;

    @Inject
    HomePresenter(DataRepository dataRepository) {
        mDataRepository = dataRepository;
    }

    @Override
    public void takeView(HomeContract.View view) {
        this.mMainView = view;
        mMainView.showMessage(R.string.entry_message);
    }

    @Override
    public void dropView() {
        if (mMainView != null) {
            mMainView = null;
        }
    }

    @Override
    public void setParams() {
        Calendar cal = Calendar.getInstance(Locale.JAPANESE);
        RequestParams params = new RequestParams("130", "g1", "0300",
                UIhelper.parseUnixTimeToString("yyyy-MM-dd", cal.getTimeInMillis()),
                ApiUrl.API_KEY);
        mDataRepository.setParams(params);
    }

    @Override
    public void getTvProgram() {
        mDataRepository.getTvProgram(new DataSource.GetTvProgramCallback() {
            @Override
            public void onLoaded(List<Genre1> genre1s) {
                mMainView.setMainContent(genre1s);
                mMainView.setLoadingIndicator(false);
            }

            @Override
            public void onDataNotAvailable() {
                mMainView.setLoadingIndicator(false);
            }

            @Override
            public void onErrors(String message) {
                mMainView.setLoadingIndicator(false);
                mMainView.showMessage(message);
            }
        });
    }
}
