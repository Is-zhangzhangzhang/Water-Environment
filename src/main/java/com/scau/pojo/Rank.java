package com.scau.pojo;

/**
 * Created by zhonghua on 2016/12/24.
 */
public class Rank {

    private String algorithmAuthor;

    private int submitNumber;

    public Rank(){}

    public Rank(String algorithmAuthor, int submitNumber) {
        this.algorithmAuthor = algorithmAuthor;
        this.submitNumber = submitNumber;
    }

    public String getAlgorithmAuthor() {
        return algorithmAuthor;
    }

    public void setAlgorithmAuthor(String algorithmAuthor) {
        this.algorithmAuthor = algorithmAuthor;
    }

    public int getSubmitNumber() {
        return submitNumber;
    }

    public void setSubmitNumber(int submitNumber) {
        this.submitNumber = submitNumber;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "algorithmAuthor='" + algorithmAuthor + '\'' +
                ", submitNumber=" + submitNumber +
                '}';
    }
}
