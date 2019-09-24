package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<Date, Double> advProfit = StatisticManager.getInstance().calculateProfit();

        Double sum = new Double(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        for (Map.Entry<Date, Double> d : advProfit.entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(d.getKey()) + " - " + String.format(Locale.ENGLISH, "%(.2f", d.getValue()));
            sum += d.getValue();
        }
        ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH, "%(.2f", sum));

    }

    public void printCookWorkloading() {
        Map<Date, TreeMap<String, Integer>> timeOfWorks = StatisticManager.getInstance().calculateTimeOfWork();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        boolean firstLine = true;

        for (Map.Entry<Date, TreeMap<String, Integer>> e : timeOfWorks.entrySet()) {
            ConsoleHelper.writeMessage((firstLine ? "" : "\n") + simpleDateFormat.format(e.getKey()));

            for (Map.Entry<String, Integer> m : e.getValue().entrySet()) {
                ConsoleHelper.writeMessage(m.getKey() + " - " + (int) Math.ceil(m.getValue() / 60.0d) + " min");
            }
            firstLine = false;
        }

    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }

}
