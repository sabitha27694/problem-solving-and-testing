import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private static class CheckInRecord {
        String stationName;
        int time;

        CheckInRecord(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class TripStats {
        long totalDuration;
        int tripCount;

        TripStats(long totalDuration, int tripCount) {
            this.totalDuration = totalDuration;
            this.tripCount = tripCount;
        }
    }

    private final Map<Integer, CheckInRecord> activeCheckIns;
    private final Map<String, TripStats> routeStats;

    public UndergroundSystem() {
        activeCheckIns = new HashMap<>();
        routeStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        activeCheckIns.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord record = activeCheckIns.remove(id);
        if (record != null) {
            String routeKey = record.stationName + "->" + stationName;
            int duration = t - record.time;

            TripStats stats = routeStats.getOrDefault(routeKey, new TripStats(0, 0));
            stats.totalDuration += duration;
            stats.tripCount++;
            routeStats.put(routeKey, stats);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        TripStats stats = routeStats.get(routeKey);
        if (stats == null || stats.tripCount == 0) {
            return 0.0;
        }
        return (double) stats.totalDuration / stats.tripCount;
    }
}