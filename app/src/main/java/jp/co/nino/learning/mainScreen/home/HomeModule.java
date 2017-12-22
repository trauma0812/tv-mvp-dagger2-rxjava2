package jp.co.nino.learning.mainScreen.home;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jp.co.nino.learning.di.ActivityScoped;
import jp.co.nino.learning.di.FragmentScoped;

/**
 * Created by liu.rui on 2017/12/13.
 */
@Module
public abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @ActivityScoped
    @Binds
    abstract HomeContract.Presenter homePresenter(HomePresenter presenter);

}
