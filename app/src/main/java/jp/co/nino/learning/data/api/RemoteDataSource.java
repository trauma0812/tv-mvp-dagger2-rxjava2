package jp.co.nino.learning.data.api;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jp.co.nino.learning.data.DataSource;
import jp.co.nino.learning.data.api.model.ProgramList;
import jp.co.nino.learning.data.api.model.RequestParams;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by liu.rui on 2017/12/18.
 */
@Singleton
public class RemoteDataSource implements DataSource {

    private Retrofit mRetrofit;
    private OkHttpClient mClient;

    private RequestParams mParams;
    private final static String TAG = RemoteDataSource.class.toString();

    @Inject
    public RemoteDataSource(Retrofit retrofit, OkHttpClient okHttpClient) {
        mRetrofit = retrofit;
        mClient = okHttpClient;
    }

    @Override
    public void getTvProgram (@NonNull final GetTvProgramCallback callback) {
        ProgramAPI api = mRetrofit.create(ProgramAPI.class);
        api.getTvProgram(
                mParams.getArea(),
                mParams.getService(),
                mParams.getGenre(),
                mParams.getDate(),
                ApiUrl.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProgramList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // do sth.
                    }

                    @Override
                    public void onNext(ProgramList programList) {
                        Log.d(TAG, programList.toString());
                        callback.onLoaded(programList.getList().getG1());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        callback.onErrors(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "It's Complete!!!");
                    }
                });

    }

    @Override
    public void setParams (RequestParams params) {
       mParams = params;
    }



}
