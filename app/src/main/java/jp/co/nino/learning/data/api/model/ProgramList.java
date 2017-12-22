package jp.co.nino.learning.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by liu.rui on 2017/12/18.
 */

public class ProgramList {

    @SerializedName("list")
    @Expose
    private GenreList list;

    public GenreList getList() {
        return list;
    }

    public void setList(GenreList list) {
        this.list = list;
    }

}
