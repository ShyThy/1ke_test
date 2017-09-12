package com.java.thy;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-30
 */
public class TestStream {
    private enum Status{
        OPEN,CLOSED
    };

    private static final class Task{
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points){
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public static void main(String args[]){
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 13)
        );

        final int totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.err.println("Total open pints : " + totalPointsOfOpenTasks);

        final Double totalPoints = tasks
                .stream()
                .parallel()
//                .map(task -> task.getPoints())
//                .map(Task::getPoints)
                .mapToDouble(Task::getPoints)
                .reduce(0, Double::sum);
        System.err.println("Total all tasks points : " + totalPoints);

        final Map<Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.err.println(map);
        System.err.println(map.get(Status.OPEN));

        final Map<Integer, List<Task>> pMap = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getPoints));
        System.err.println(pMap);

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        final Collection<String> result = tasks
                .stream()
                .mapToInt(Task::getPoints)
                .asLongStream()
                .mapToDouble(points -> points/totalPoints)
                .boxed()
//                .mapToLong( weight -> (long) (weight * 100))
                .mapToDouble( weight -> Double.valueOf(nf.format((weight * 100))))
                .mapToObj(percentage -> percentage + "%")
                .collect(Collectors.toList());
        System.err.println(result);
    }
}
