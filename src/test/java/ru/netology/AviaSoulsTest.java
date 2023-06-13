package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls souls = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "Kazan", 4000, 12, 20);
    Ticket ticket2 = new Ticket("Moscow", "Kazan", 14000, 10, 15);
    Ticket ticket3 = new Ticket("Saratov", "Ufa", 1500, 6, 7);
    Ticket ticket4 = new Ticket("Moscow", "Kazan", 8000, 9, 10);
    Ticket ticket5 = new Ticket("Sochi", "Vladivostok", 14000, 12, 20);
    Ticket ticket6 = new Ticket("Moscow", "Kazan", 1200, 6, 10);
    Ticket ticket7 = new Ticket("Moscow", "Kazan", 5800, 3, 6);
    Ticket ticket8 = new Ticket("Moscow", "Kazan", 6300, 10, 12);
    Ticket ticket9 = new Ticket("Moscow", "Kazan", 10000, 17, 23);


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
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        souls.add(ticket9);


        Ticket[] expected = {ticket6, ticket1, ticket7, ticket8, ticket4, ticket9, ticket2};
        Ticket[] actual = souls.search("Moscow", "Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortGrowthPriceOneTicket() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        souls.add(ticket9);


        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.search("Saratov", "Ufa");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortGrowthPriceNoneTicket() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        souls.add(ticket9);


        Ticket[] expected = {};
        Ticket[] actual = souls.search("Saratov", "Kazan");

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

        souls.add(ticket4);
        souls.add(ticket6);

        Assertions.assertEquals(-1, TimeComparator.compare(ticket4, ticket6));
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
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        souls.add(ticket9);

        Ticket[] expected = {ticket4, ticket8, ticket7, ticket6, ticket2, ticket9, ticket1};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Kazan", TimeComparator);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSortGrowthAndSortByOneTicket() {

        TicketTimeComparator TimeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        souls.add(ticket9);

        Ticket[] expected = {ticket5};
        Ticket[] actual = souls.searchAndSortBy("Sochi", "Vladivostok", TimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortGrowthAndSortByNoneTicket() {

        TicketTimeComparator TimeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);
        souls.add(ticket8);
        souls.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = souls.searchAndSortBy("Sochi", "Moscow", TimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
