package akahane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.akahane on 2016/05/25.
 */
public class Main {

    public static void main(String[] args) {
        List<Point> points = createMap();

        //スタート地点の初期処理
        Point startPoint = points.get(0);
        startPoint.setTotalCost(0);

        while (true) {
            Point processPoint = null;

            //地点ごとにスタートからかかったコストを設定
            for (int i = 0; i < points.size(); i++) {
                Point point = points.get(i);

                // 既に通ったかコストが未設定の場合は処理しない
                if (point.isDone() || point.getTotalCost() < 0) {
                    continue;

                }

                if (processPoint == null) {
                    processPoint = point;
                    continue;
                }

                // トータルコストが小さい地点をを探す
                if (point.getTotalCost() < processPoint.getTotalCost()) {
                    processPoint = point;
                }
            }

            if (processPoint == null) {
                break;
            }

            processPoint.setDone(true);

            for (int i = 0; i < processPoint.getAdjoinPoint().size(); i++) {
                Point point = processPoint.getAdjoinPoint().get(i);
                int cost = processPoint.getTotalCost() + 1;

                // コストが未設定 or コストの少ない経路がある場合は更新
                if (point.getTotalCost() < 0 || point.getTotalCost() > cost) {
                    point.setTotalCost(cost);
                    point.setPreviousPoint(processPoint);
                }
            }
        }
        Point goalPoint = points.get(points.size() - 1);
        System.out.println("最少交差点数: " + (goalPoint.getTotalCost() - 1));
        System.out.println("ルート:");
        StringBuilder sb = new StringBuilder();
        sb.append(goalPoint.getId());
        Point current = goalPoint;
        while (true) {
            Point p = current.getPreviousPoint();
            if (p == null) {
                break;
            }
            sb.insert(0, p.getId() + " > ");
            current = p;
        }
        System.out.println(sb.toString());
    }


    //マップを作成
    public static List<Point> createMap() {
        //地点（交差点）を作成
        Point point1 = new Point("Start");
        Point point2 = new Point("2");
        Point point3 = new Point("3");
        Point point4 = new Point("4");
        Point point5 = new Point("5");
        Point point6 = new Point("Goal");

        //隣接している地点をセット
        point1.addPoint(point2);
        point1.addPoint(point3);
        point1.addPoint(point4);

        point2.addPoint(point1);
        point2.addPoint(point6);
        point2.addPoint(point3);

        point3.addPoint(point2);
        point3.addPoint(point1);
        point3.addPoint(point4);
        point3.addPoint(point5);

        point4.addPoint(point1);
        point4.addPoint(point3);
        point4.addPoint(point5);

        point5.addPoint(point4);
        point5.addPoint(point3);
        point5.addPoint(point6);

        point6.addPoint(point2);
        point6.addPoint(point5);

        //スタート地点は先頭、ゴールは最後に追加してリストを返却
        List<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);
        points.add(point6);

        return points;
    }


}
