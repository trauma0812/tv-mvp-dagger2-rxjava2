/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package jp.co.nino.learning.data;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.co.nino.learning.data.api.model.RequestParams;

@Singleton
public class DataRepository implements DataSource{

    private final DataSource mRemoteDataSource;

    @Inject
    DataRepository(DataSource dataSource) {
        mRemoteDataSource = dataSource;
    }

    @Override
    public void getTvProgram (@NonNull final GetTvProgramCallback callback) {
        mRemoteDataSource.getTvProgram(callback);
    }

    @Override
    public void setParams (RequestParams params) {
        mRemoteDataSource.setParams(params);
    }

}
