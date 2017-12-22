package jp.co.nino.learning.data.api;

import io.reactivex.Observable;
import jp.co.nino.learning.data.api.model.ProgramList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by liu.rui on 2017/12/18.
 */

public interface ProgramAPI {
    @GET(ApiUrl.ENDPOINT_GENRE + "{area}" + "/" + "{service}"+ "/"
            + "{genre}" + "/" + "{date}" +
            ApiUrl.ENDPOINT_JSON_SYMBOL)
    Observable<ProgramList> getTvProgram(
            @Path("area") String area,
            @Path("service") String service,
            @Path("genre") String genre,
            @Path("date") String date,
            @Query("key") String apiKey);


}
