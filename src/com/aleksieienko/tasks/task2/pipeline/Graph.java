package com.aleksieienko.tasks.task2.pipeline;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private Integer currentPoint = 1;
    private Map<Integer, Point> pointsById;
    private Map<String, Point> pointsByName = new HashMap<>();

    public Graph(Integer size) {
        pointsById = new HashMap<>();
        for(int i=0; i<size; i++)
        {
            pointsById.put(i+1,new Point(i+1));
        }
    }

    public Map<Integer, Point> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Map<Integer, Point> pointsById) {
        this.pointsById = pointsById;
    }

    public Map<String, Point> getPointsByName() {
        return pointsByName;
    }

    public void setPointsByName(Map<String, Point> pointsByName) {
        this.pointsByName = pointsByName;
    }

    public Graph(Map<String, Point> pointsByName) {
        this.pointsByName = pointsByName;
    }

    public Point getPointByName(String name) {
        return pointsByName.get(name);
    }

    public Point getPointById(Integer id) {
        return pointsById.get(id);
    }

    public void addPoint(Point point) throws Exception {
        if(pointsByName.containsKey(point.getName())){
            throw new Exception("This name -> " + point.getName() + " already exists.");
        }
        if(currentPoint > pointsById.size()){
            throw new Exception("Trying to add more pointsByName than size of graph.");
        }
        Point realPoint = pointsById.get(currentPoint);
        realPoint.setName(point.getName());
        pointsByName.put(point.getName(), realPoint);
        currentPoint++;
    }

    public void removePoint(Point point){
        pointsByName.remove(point.getName());
    }

    public void addEdge(Integer pointAId, Integer pointBId, Integer weight) throws Exception {
        if(!pointsById.containsKey(pointAId)){
            throw new Exception("Point A with id -> " + pointAId + " does not exist");
        }
        if(!pointsById.containsKey(pointBId)){
            throw new Exception("Point B with id -> " + pointBId + " does not exist");
        }
        Point a = pointsById.get(pointAId);
        Point b = pointsById.get(pointBId);
        a.getNeighbors().put(b,weight);
    }

    public void removeEdge(Integer pointAId, Integer pointBId){
        Point a = pointsById.get(pointAId);
        if(a.getNeighbors().containsKey(pointBId)){
            a.getNeighbors().remove(pointBId);
        }
    }

    private boolean isRouteExist(String startPointName, String endPointName){
        Queue<Point> queue = new LinkedList();
        queue.add(pointsByName.get(startPointName));
        Set<Point> visitedPoints = new HashSet<>();
        Point point;

        while((point = queue.poll()) != null){

            if(visitedPoints.contains(point)){

                continue;
            }

            if(point.getName().equals(endPointName)){

                return true;
            }

            visitedPoints.add(point);
            queue.addAll(point.getNeighbors().keySet());
        }

        return false;
    }

    /**
     * @param startPointName
     * @param endPointName
     * @return return null if route does not exist
     */
    public Integer shortestRouteWeight(String startPointName, String endPointName){

        if(!isRouteExist(startPointName, endPointName)){

            return null;
        }

        Point point = pointsByName.get(startPointName);
        Map<Point, Integer> weightMap = new HashMap<>(point.getNeighbors());
        Queue<Point> queue = new LinkedList(point.getNeighbors().keySet());
        Set<Point> visitedPoints = new HashSet<>();

        while((point = queue.poll()) != null){

            if(visitedPoints.contains(point)){

                continue;
            }

            for(Map.Entry<Point,Integer> x : point.getNeighbors().entrySet()){

                if(!weightMap.containsKey(x.getKey())){

                    weightMap.put(x.getKey(),(weightMap.get(point)+x.getValue()));
                } else {

                    if(weightMap.get(x.getKey()) >= (weightMap.get(point) + x.getValue())){

                        weightMap.remove(x.getKey());
                        weightMap.put(x.getKey(),weightMap.get(point) + point.getNeighbors().get(x.getKey()));
                        queue.remove(x.getKey());
                    }
                }
            }

            visitedPoints.add(point);
            queue.addAll(point.getNeighbors().keySet());
        }

        return weightMap.get(pointsByName.get(endPointName));
    }


}
