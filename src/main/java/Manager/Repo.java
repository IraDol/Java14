package Manager;

import Domain.Ticket;

public class Repo {
    private Ticket[] tickets = new Ticket[0];

    public void addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;

    }

    public Ticket[] getAll() {
        return tickets;
    }

    public void removeTicket (int id) {
        Ticket[] result = new Ticket[tickets.length -1];
        int firstIndex = 0;
        for (Ticket ticket:tickets) {
            if (ticket.getId()!= id)
                result [firstIndex] = ticket;
            firstIndex++;
        }
        tickets = result;
        }
    }



