package jp.co.nino.learning.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import jp.co.nino.learning.KLApplication;
import jp.co.nino.learning.data.DataRepository;
import jp.co.nino.learning.di.module.ActivityBindingModule;
import jp.co.nino.learning.di.module.ApplicationModule;
import jp.co.nino.learning.di.module.DataRepositoryModule;

@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        DataRepositoryModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<KLApplication> {

    DataRepository getDataManager();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

}