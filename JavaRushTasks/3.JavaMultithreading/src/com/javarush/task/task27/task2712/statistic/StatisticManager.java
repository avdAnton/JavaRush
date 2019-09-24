package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager(){

    }

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<Date, Double> calculateProfit() {
        Map<Date, Double> calc = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        Map<EventType, List<EventDataRow>> strg = statisticStorage.getStorage();
        List<EventDataRow> dataRowList = strg.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow e : dataRowList) {

            Date currentDate = e.getDate();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(currentDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            double currentAmount = ((VideoSelectedEventDataRow) e).getAmount() / 100.00;
            if (calc.containsKey(calendar.getTime())) {
                currentAmount += calc.get(calendar.getTime());
            }
            calc.put(calendar.getTime(), currentAmount);
        }
        return calc;
    }

    public Map<Date, TreeMap<String, Integer>> calculateTimeOfWork() {
        Map<Date, TreeMap<String, Integer>> calc = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        Map<EventType, List<EventDataRow>> strg = statisticStorage.getStorage();
        List<EventDataRow> dataRowList = strg.get(EventType.COOKED_ORDER);
        for (EventDataRow e : dataRowList) {

            Date currentDate = e.getDate();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(currentDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) e;
            String cookName = cookedOrderEventDataRow.getCookName();


            TreeMap<String, Integer> cookedForThisDay = calc.get(calendar.getTime());
            if (cookedForThisDay == null) {
                cookedForThisDay = new TreeMap<>();
                calc.put(calendar.getTime(), cookedForThisDay);
            }
            Integer timeCooked = cookedForThisDay.get(cookName);
            if (timeCooked == null) {
                timeCooked = e.getTime();
            } else {
                timeCooked += e.getTime();
            }
            cookedForThisDay.put(cookName, timeCooked);

        }
        return calc;

    }

    private class StatisticStorage{
        Map<EventType, List<EventDataRow>> storage;

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        public StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType eventType : EventType.values()){
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }
}
