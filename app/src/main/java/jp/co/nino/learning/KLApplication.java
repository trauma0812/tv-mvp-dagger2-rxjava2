package jp.co.nino.learning;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import jp.co.nino.learning.data.DataRepository;
import jp.co.nino.learning.di.component.DaggerAppComponent;

/**
 * Created by liu.rui on 2017/09/11.
 */

public class KLApplication extends DaggerApplication {

    @Inject
    DataRepository dataRepository;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
