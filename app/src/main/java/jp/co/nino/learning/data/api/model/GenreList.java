package jp.co.nino.learning.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by liu.rui on 2017/12/18.
 */

public class GenreList {

    @SerializedName("g1")
    @Expose
    private List<Genre1> g1 = null;

    public List<Genre1> getG1() {
        return g1;
    }

    public void setG1(List<Genre1> g1) {
        this.g1 = g1;
    }

}
