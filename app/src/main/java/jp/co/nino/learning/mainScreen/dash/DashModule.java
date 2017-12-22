package jp.co.nino.learning.mainScreen.dash;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jp.co.nino.learning.di.ActivityScoped;
import jp.co.nino.learning.di.FragmentScoped;

/**
 * Created by liu.rui on 2017/12/13.
 */
@Module
public abstract class DashModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract DashFragment dashFragment();

    @ActivityScoped
    @Binds
    abstract DashContract.Presenter dashPresenter(DashPresenter presenter);

}
