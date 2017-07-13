package com.scau.pojo;

/**
 * Created by zhonghua on 2016/8/9.
 */
public class QueryResult {

    private String resultTitle;
    private String resultContent;
    private String resultDocDate;

    public String getResultTitle() {
        return resultTitle;
    }

    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        if(resultContent.length()>300){
            resultContent=resultContent.substring(1,300);
        }
        resultContent+="...";
        this.resultContent = resultContent;
    }

    public String getResultDocData() {
        return resultDocDate;
    }

    public void setResultDocData(String resultDocDate) {
        this.resultDocDate = resultDocDate;
    }

}
