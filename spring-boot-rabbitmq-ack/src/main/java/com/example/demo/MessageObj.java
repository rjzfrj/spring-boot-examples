package com.example.demo;

import java.io.Serializable;

public class MessageObj implements Serializable {
    private  boolean b;
    private  int i;
    private  String zhangsan;
    private  String data;

    public void setACK(boolean b) {
    }

    public void setId(int i) {
    }

    public void setName(String zhangsan) {
    }

    public void setValue(String data) {
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getZhangsan() {
        return zhangsan;
    }

    public void setZhangsan(String zhangsan) {
        this.zhangsan = zhangsan;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageObj{" +
                "b=" + b +
                ", i=" + i +
                ", zhangsan='" + zhangsan + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
