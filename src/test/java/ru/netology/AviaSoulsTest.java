package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Внуково",
            "Пулково",
            200,
            17,
            19

    );

    Ticket ticket2 = new Ticket(
            "Шереметьево",
            "Храброво",
            280,
            16,
            19

    );

    Ticket ticket3 = new Ticket(
            "Шереметьево",
            "Толмачёво",
            350,
            13,
            17

    );

    Ticket ticket4 = new Ticket(
            "Домодедово",
            "Елизово",
            478,
            10,
            18

    );

    Ticket ticket5 = new Ticket(
            "Шереметьево",
            "Кольцово",
            280,
            0,
            2

    );

    Ticket ticket6 = new Ticket(
            "Шереметьево",
            "Храброво",
            290,
            17,
            21

    );

    Ticket ticket7 = new Ticket(
            "Шереметьево",
            "Храброво",
            210,
            2,
            5

    );

    Ticket ticket8 = new Ticket(
            "Шереметьево",
            "Храброво",
            290,
            3,
            6

    );


    @Test
    public void testCompareToIfCheaper() {

        //  System.out.println(ticket1.compareTo(ticket2));

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToIfEqual() {

        //  System.out.println(ticket2.compareTo(ticket5));

        int expected = 0;
        int actual = ticket2.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToIfEqualExpensive() {

        //   System.out.println(ticket4.compareTo(ticket3));

        int expected = 1;
        int actual = ticket4.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        AviaSouls allTickets = new AviaSouls();
        allTickets.add(ticket1);
        allTickets.add(ticket2);
        allTickets.add(ticket3);
        allTickets.add(ticket4);
        allTickets.add(ticket5);
        allTickets.add(ticket6);
        allTickets.add(ticket7);
        allTickets.add(ticket8);

        Ticket[] expected = {ticket7, ticket2, ticket6, ticket8};
        Ticket[] actual = allTickets.search("Шереметьево", "Храброво");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testComparatorIfCheaper() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testComparatorIfEqual() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = timeComparator.compare(ticket7, ticket8);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testComparatorIfExpensive() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = timeComparator.compare(ticket4, ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy() {
        AviaSouls allTickets = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        allTickets.add(ticket6);
        allTickets.add(ticket7);
        allTickets.add(ticket8);


        Ticket[] expected = {ticket7, ticket8, ticket6};
        Ticket[] actual = allTickets.searchAndSortBy("Шереметьево", "Храброво", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
