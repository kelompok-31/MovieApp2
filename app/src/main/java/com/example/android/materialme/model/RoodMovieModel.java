package com.example.android.materialme.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RoodMovieModel{

    @SerializedName("page")
    private Integer page;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("results")
    private List<ResultsItem> results;

    @SerializedName("total_results")
    private Integer totalResults;

    public void setPage(Integer page){
        this.page = page;
    }

    public Integer getPage(){
        return page;
    }

    public void setTotalPages(Integer totalPages){
        this.totalPages = totalPages;
    }

    public Integer getTotalPages(){
        return totalPages;
    }

    public void setResults(List<ResultsItem> results){
        this.results = results;
    }

    public List<ResultsItem> getResults(){
        return results;
    }

    public void setTotalResults(Integer totalResults){
        this.totalResults = totalResults;
    }

    public Integer getTotalResults(){
        return totalResults;
    }


}