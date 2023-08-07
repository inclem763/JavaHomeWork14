package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls avia = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Санкт_Петербург", "Стамбул", 600, 15_00, 18_50);
    Ticket ticket2 = new Ticket("Санкт_Петербург", "Стамбул", 800, 10_05, 16_00);
    Ticket ticket3 = new Ticket("Санкт_Петербург", "Стамбул", 450, 5_55, 9_45);
    Ticket ticket4 = new Ticket("Санкт_Петербург", "Стамбул", 350, 13_00, 17_00);
    Ticket ticket5 = new Ticket("Ростов", "Стамбул", 900, 19_00, 21_25);
    Ticket ticket6 = new Ticket("Ростов", "Стамбул", 1050, 12_10, 15_45);

    @Test
    public void shouldSortTickets() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = {ticket4, ticket3, ticket1, ticket2, ticket5, ticket6};
        Ticket[] expected = avia.findAll();
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsBySort() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = {ticket4, ticket3, ticket1, ticket2};
        Ticket[] expected = avia.search("Санкт_Петербург", "Стамбул");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortMaxFastWay() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = {ticket5, ticket6, ticket1, ticket3, ticket4, ticket2};
        Ticket[] expected = avia.findAll();
        Arrays.sort(expected, timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTime() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = {ticket1, ticket3, ticket4, ticket2};
        Ticket[] expected = avia.searchAndSortBy("Санкт_Петербург", "Стамбул", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPrice() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = {ticket4, ticket3, ticket1, ticket2};
        Ticket[] expected = avia.searchAndSortBy("Санкт_Петербург", "Стамбул", Ticket::compareTo);

        Assertions.assertArrayEquals(expected, actual);
    }
}