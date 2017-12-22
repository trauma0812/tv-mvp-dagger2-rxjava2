package jp.co.nino.learning.mainScreen.dash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import jp.co.nino.learning.R;

/**
 * Created by liu.rui on 2017/12/13.
 */

public class DashFragment extends DaggerFragment implements DashContract.View {

    @Inject
    DashContract.Presenter mPresenter;

    @Inject
    public DashFragment() {
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
        View root = inflater.inflate(R.layout.dash_frag, container, false);


        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void showMessage(String message) {
//        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
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
