package saurabh.j16;

record PointRecord(int latitude, int longitude) {
}

public class Point {
    public static void main(String[] args) {
        var pointRecord = new PointRecord(5, 3);
        System.out.println(pointRecord.latitude());
        System.out.println(pointRecord.longitude());
    }
}