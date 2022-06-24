package Manager;

import Domain.Ticket;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ManagerTicket {
    private Repo repo = new Repo();


    public ManagerTicket(Repo repo) {
        this.repo = repo;
    }

    public ManagerTicket() {
    }

    public void saveTicket(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public Ticket[] findAll(String fromAirport, String toAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if (ticket.getToAirport().equals(toAirport) && ticket.getFromAirport().equals(fromAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }
}

