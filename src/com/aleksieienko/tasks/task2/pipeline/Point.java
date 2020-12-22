package com.aleksieienko.tasks.task2.pipeline;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point implements Serializable {
    private static final long serialVersionUID = 6329051366186278615L;
    private Integer id;
    private String name;
    private Map<Point,Integer> neighbors = new HashMap<>();

    public Point(Integer id, String name, Map<Point, Integer> neighbors) {
        this.id = id;
        this.name = name;
        this.neighbors = neighbors;
    }

    public Point(String name) {
        this.name = name;
    }

    public Point(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Point(Integer id) {
        this.id = id;
    }

    public Point() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Point, Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Map<Point, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return this.id.equals(point.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Point{" +
                "name=" + name +
                ", neighbors=" + neighbors +
                '}';
    }
}
