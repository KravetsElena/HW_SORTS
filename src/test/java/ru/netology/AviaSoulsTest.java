package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls souls = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "Kazan", 4000, 12, 14);
    Ticket ticket2 = new Ticket("Moscow", "Kazan", 14000, 10, 15);
    Ticket ticket3 = new Ticket("Saratov", "Ufa", 1500, 6, 7);
    Ticket ticket4 = new Ticket("Moscow", "Kazan", 8000, 9, 10);
    Ticket ticket5 = new Ticket("Sochi", "Vladivostok", 14000, 12, 20);

    @Test
    public void shouldComparePriceMore() {
        souls.add(ticket1);
        souls.add(ticket3);

        int expected = 1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceLess() {
        souls.add(ticket4);
        souls.add(ticket2);

        int expected = -1;
        int actual = ticket4.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceEqual() {
        souls.add(ticket2);
        souls.add(ticket5);

        int expected = 0;
        int actual = ticket2.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldSortGrowthPrice() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket1, ticket4, ticket2};
        Ticket[] actual = souls.search("Moscow", "Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTimeComparatorMore() {

        TicketTimeComparator TimeComparator = new TicketTimeComparator();

        souls.add(ticket5);
        souls.add(ticket3);

        Assertions.assertEquals(1, TimeComparator.compare(ticket5, ticket3));
    }

    @Test
    public void shouldTimeComparatorLess() {

        TicketTimeComparator TimeComparator = new TicketTimeComparator();

        souls.add(ticket1);
        souls.add(ticket2);

        Assertions.assertEquals(-1, TimeComparator.compare(ticket1, ticket2));
    }

    @Test
    public void shouldTimeComparatorEqual() {

        TicketTimeComparator TimeComparator = new TicketTimeComparator();

        souls.add(ticket3);
        souls.add(ticket4);

        Assertions.assertEquals(0, TimeComparator.compare(ticket3, ticket4));
    }


    @Test
    public void shouldSortGrowthAndSortBy() {

        TicketTimeComparator TimeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket4, ticket1, ticket2};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Kazan", TimeComparator);
        Assertions.assertArrayEquals(expected, actual);


    }
}
