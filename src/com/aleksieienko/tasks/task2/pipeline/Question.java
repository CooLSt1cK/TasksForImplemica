package com.aleksieienko.tasks.task2.pipeline;

public class Question {
    private Point pointA;
    private Point pointB;

    public Question(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Question() {
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    @Override
    public String toString() {
        return "Question{" +
                "pointAId=" + pointA +
                ", pointBId=" + pointB +
                '}';
    }
}
