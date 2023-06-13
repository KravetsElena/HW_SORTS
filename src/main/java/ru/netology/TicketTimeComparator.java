package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {


    @Override
    public int compare(Ticket t1, Ticket t2) {

        int flightTimeT1 = t1.getTimeTo() - t1.getTimeFrom();
        int flightTimeT2 = t2.getTimeTo() - t2.getTimeFrom();

        if (flightTimeT1 < flightTimeT2) {
            return -1;
        } else if (flightTimeT1 > flightTimeT2) {
            return 1;
        } else {
            return 0;
        }
    }
}
