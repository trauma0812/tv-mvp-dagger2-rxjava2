package jp.co.nino.learning.mainScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import jp.co.nino.learning.R;
import jp.co.nino.learning.mainScreen.dash.DashFragment;
import jp.co.nino.learning.mainScreen.home.HomeFragment;
import jp.co.nino.learning.mainScreen.home.HomePresenter;
import jp.co.nino.learning.utils.ActivityUtils;

public class MainActivity extends DaggerAppCompatActivity {

    private String TAG = MainActivity.this.getClass().toString();

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    @Inject
    HomePresenter mPresenter;
    @Inject
    Lazy<HomeFragment> homeFragmentProvider;
    @Inject
    Lazy<DashFragment> dashFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_home:
                        ActivityUtils.changeFragmentToActivity(
                                getSupportFragmentManager(), homeFragmentProvider.get(), R.id.fragment_container);
                        break;
                    case R.id.navigation_dashboard:
                        ActivityUtils.changeFragmentToActivity(
                            getSupportFragmentManager(), dashFragmentProvider.get(), R.id.fragment_container);
                        break;
                    case R.id.navigation_notifications:
                        break;
                }
                return true;
            }
        });

        // show the home fragment first.
        if (getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container) == null) {
            // Get the fragment from dagger
            HomeFragment homeFragment = homeFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), homeFragment, R.id.fragment_container);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

}
