package Manager;

import Domain.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTicketTest {
    ManagerTicket managerTicket = new ManagerTicket();
    Ticket ticket1 = new Ticket(111, 45_950, "SVO", "JFK", 720);
    Ticket ticket2 = new Ticket(222, 25_345, "SVO", "IST", 300);
    Ticket ticket3 = new Ticket(333, 43_200, "SVO", "JFK", 720);
    Ticket ticket4 = new Ticket(444, 41_250, "DME", "JFK", 715);
    Ticket ticket5 = new Ticket(555, 35_950, "SVO", "JFK", 550);
    Ticket ticket6 = new Ticket(666, 15_950, "SVO", "JFK", 850);
    Ticket ticket7 = new Ticket(777, 115_950, "IST", "JFK", 450);
    Ticket ticket8 = new Ticket(888, 115_950, "IST", "JFK", 60);

    @Test
    void shouldSearchAndSortAll() {
        managerTicket.saveTicket(ticket1);
        managerTicket.saveTicket(ticket2);
        managerTicket.saveTicket(ticket3);
        managerTicket.saveTicket(ticket4);
        managerTicket.saveTicket(ticket5);
        managerTicket.saveTicket(ticket6);
        managerTicket.saveTicket(ticket7);


        Ticket[] actual = managerTicket.findAll("SVO", "JFK");
        Ticket[] expected = {ticket6, ticket5, ticket3, ticket1};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchAndSortTwoSameCost() {

        managerTicket.saveTicket(ticket7);
        managerTicket.saveTicket(ticket8);


        Ticket[] actual = managerTicket.findAll("IST", "JFK");
        Ticket[] expected = {ticket7, ticket8};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAndSortNoMatches() {

        managerTicket.saveTicket(ticket3);
        managerTicket.saveTicket(ticket4);
        managerTicket.saveTicket(ticket5);


        Ticket[] actual = managerTicket.findAll("IST", "SVO");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAndSortEmptyField() {


        Ticket[] actual = managerTicket.findAll("SVO", "JFK");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAndSortRepeatsTicket() {
        managerTicket.saveTicket(ticket3);
        managerTicket.saveTicket(ticket4);
        managerTicket.saveTicket(ticket5);
        managerTicket.saveTicket(ticket5);


        Ticket[] actual = managerTicket.findAll("SVO", "JFK");
        Ticket[] expected = {ticket5, ticket5, ticket3};

        assertArrayEquals(expected, actual);
    }

}