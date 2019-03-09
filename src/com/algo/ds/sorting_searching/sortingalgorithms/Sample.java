package com.algo.ds.sorting_searching.sortingalgorithms;

public class Sample implements Comparable<Sample>{
    private int count;
    private String city;

    @Override
    public int compareTo(Sample o) {
        if(this.count > o.count) return 1;
        if(this.count < o.count) return -1;
        return 0;
    }

    public Sample(int count, String city) {
        this.count = count;
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Count : " + this.getCount() + ", City : " + this.getCity();
    }
}
