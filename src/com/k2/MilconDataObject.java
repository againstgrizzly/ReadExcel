package com.k2;

import java.util.Optional;

public class MilconDataObject {

    private int project;
    private double value;
    private String must_fund;
    private String net;
    private int prerequisite;
    private String last_pom;
    private double cost;
    private int setup;
    private double setup_cost;
    private int post;
    private double post_cost;


    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getMust_fund() {
        return must_fund;
    }

    public void setMust_fund(String must_fund) {
        this.must_fund = must_fund;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public int getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(int prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getLast_pom() {
        return last_pom;
    }

    public void setLast_pom(String last_pom) {
        this.last_pom = last_pom;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getSetup() {
        return setup;
    }

    public void setSetup(int setup) {
        this.setup = setup;
    }

    public double getSetup_cost() {
        return setup_cost;
    }

    public void setSetup_cost(double setup_cost) {
        this.setup_cost = setup_cost;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public double getPost_cost() {
        return post_cost;
    }

    public void setPost_cost(double post_cost) {
        this.post_cost = post_cost;
    }

    @Override
    public String toString() {
        return "MilconDataObject{" +
                "project=" + project +
                ", value=" + value +
                ", must_fund='" + must_fund + '\'' +
                ", net='" + net + '\'' +
                ", prerequisite=" + prerequisite +
                ", last_pom='" + last_pom + '\'' +
                ", cost=" + cost +
                ", setup=" + setup +
                ", setup_cost=" + setup_cost +
                ", post=" + post +
                ", post_cost=" + post_cost +
                '}';
    }
}
