import java.util.*;

/**
 * @author kishu.agarwal
 */
public class TrainTimetable {

    private static int parseTimeIntoMinutes(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    static class Trip implements Comparable<Trip> {
        int departure;
        int arrival;
        boolean stationA;

        public Trip(int departure, int arrival, boolean stationA) {
            this.departure = departure;
            this.arrival = arrival;
            this.stationA = stationA;
        }

        @Override
        public int compareTo(Trip o) {
            return this.departure - o.departure;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t ; i += 1) {
            int turnAroundTime = in.nextInt();
            int na = in.nextInt();
            int nb = in.nextInt();

            Queue<Trip> trips = new PriorityQueue<>();
            Queue<Integer> availableAtA = new PriorityQueue<>();
            Queue<Integer> availableAtB = new PriorityQueue<>();

            for (int j = 0; j < na; j += 1) {
                int departure = parseTimeIntoMinutes(in.next());
                int arrival = parseTimeIntoMinutes(in.next());
                trips.add(new Trip(departure, arrival, true));
            }

            for (int j = 0; j < nb; j += 1) {
                int departure = parseTimeIntoMinutes(in.next());
                int arrival = parseTimeIntoMinutes(in.next());
                trips.add(new Trip(departure, arrival, false));
            }

            int requiredAtA = 0;
            int requiredAtB = 0;

            while (trips.size() > 0) {
                Trip trip = trips.poll();
                if (trip.stationA) {
                    if (availableAtA.size() > 0 && availableAtA.peek() <= trip.departure) {
                        availableAtA.poll();
                    } else {
                        requiredAtA += 1;
                    }
                    availableAtB.add(trip.arrival + turnAroundTime);
                } else {
                    if (availableAtB.size() > 0 && availableAtB.peek() <= trip.departure) {
                        availableAtB.poll();
                    } else {
                        requiredAtB += 1;
                    }
                    availableAtA.add(trip.arrival + turnAroundTime);
                }
            }

            System.out.format("Case #%d: %d %d\n", i, requiredAtA, requiredAtB);
        }
    }
}
