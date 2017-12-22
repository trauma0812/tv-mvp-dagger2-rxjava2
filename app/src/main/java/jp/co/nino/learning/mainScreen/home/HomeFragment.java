package jp.co.nino.learning.mainScreen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;
import jp.co.nino.learning.R;
import jp.co.nino.learning.data.api.model.Genre1;
import jp.co.nino.learning.mainScreen.ScrollChildSwipeRefreshLayout;
import jp.co.nino.learning.utils.NetworkUtils;
import jp.co.nino.learning.utils.UIhelper;

/**
 * Created by liu.rui on 2017/12/13.
 */

public class HomeFragment extends DaggerFragment implements HomeContract.View{

    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.home_content)
    TextView content;

    @Inject
    HomeContract.Presenter mPresenter;

    @Inject
    public HomeFragment() {
        // Requires empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_frag, container, false);
        ButterKnife.bind(this, root);

        // Set up progress indicator
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorYellow),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorRetryBlue)
        );
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getContents();
            }
        });

        setHasOptionsMenu(true);

        return root;
    }

    private void getContents() {
        if (NetworkUtils.isNetworkConnected(getContext())) {
            mPresenter.setParams();
            mPresenter.getTvProgram();
        }
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(active);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        UIhelper.showMessageBySnackbar(getView(), message,
                getResources().getColor(R.color.colorRetryBlue), getResources().getColor(R.color.colorYellow));

    }

    @Override
    public void showMessage(int resId) {
        UIhelper.showMessageBySnackbar(getView(), getResources().getString(resId),
                getResources().getColor(R.color.colorRetryBlue), getResources().getColor(R.color.colorYellow));

    }

    @Override
    public void setMainContent(List<Genre1> genre1s) {
        content.setText(genre1s.toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();  //prevent leaking activity in
        // case presenter is orchestrating a long running task
    }

}
