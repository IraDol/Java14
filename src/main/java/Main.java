import Domain.Ticket;
import Manager.ManagerTicket;
import Manager.Repo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Repo repo = new Repo();
        ManagerTicket managerTicket = new ManagerTicket();

        Ticket ticket1 = new Ticket(111, 45_950, "SVO", "JFK", 720);
        Ticket ticket2 = new Ticket(222, 25_345, "SVO", "IST", 300);
        Ticket ticket3 = new Ticket(333, 43_200, "SVO", "JFK", 720);
        Ticket ticket4 = new Ticket(444, 41_250, "DME", "JFK", 715);
int res = ticket1.compareTo(ticket2);

       // System.out.println(res);

        Ticket[] tickets = {
                new Ticket(111, 45_950, "SVO", "JFK", 720),
                new Ticket(222, 25_345, "SVO", "IST", 300),
                new Ticket(333, 43_200, "SVO", "JFK", 720),
                new Ticket(444, 41_250, "DME", "JFK", 715),
        };
//        Arrays.sort(tickets);
//        System.out.println(Arrays.toString(tickets));

       // repo.getAll();
        managerTicket.findAll ("SVO", "JFK");
//        Arrays.sort(managerTicket.findAll("SVO", "JFK"));
//        System.out.println(Arrays.toString(tickets));

    }
}
