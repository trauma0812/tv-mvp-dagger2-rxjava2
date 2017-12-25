package jp.co.nino.learning.mainScreen.dash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaredrummler.materialspinner.MaterialSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;
import jp.co.nino.learning.R;
import jp.co.nino.learning.utils.Constants;
import jp.co.nino.learning.utils.SharePref;
import jp.co.nino.learning.utils.UIhelper;

/**
 * Created by liu.rui on 2017/12/13.
 */

public class DashFragment extends DaggerFragment implements DashContract.View {

    @BindView(R.id.tv_area)
    MaterialSpinner area;

    @BindView(R.id.tv_genre)
    MaterialSpinner genre;

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
        ButterKnife.bind(this, root);

        setHasOptionsMenu(true);
        setSpinner();

        return root;
    }

    @Override
    public void setSpinner () {
        area.setItems(getResources().getStringArray(R.array.areas));
        area.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                UIhelper.showMessageBySnackbar(view, item.concat(getResources().getString(R.string.has_been_selected)),
                        getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorMediumPurple));
                SharePref.putString(getContext(), Constants.KEY_PARAM_AREA, item.split(":")[0]);
            }
        });
        area.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {
            @Override
            public void onNothingSelected(MaterialSpinner spinner) {
                //
            }
        });
        genre.setItems(getResources().getStringArray(R.array.genres));
        genre.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                UIhelper.showMessageBySnackbar(view, item.concat(getResources().getString(R.string.has_been_selected)),
                        getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorMediumPurple));
                SharePref.putString(getContext(), Constants.KEY_PARAM_GENRE, item.split(":")[0]);
            }
        });
        genre.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {
            @Override
            public void onNothingSelected(MaterialSpinner spinner) {
                //
            }
        });
    }

    @Override
    public void showMessage(int resId) {
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
