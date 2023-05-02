package nl.onlyfour.openminetopia.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PinRequest {

    public Player payer;
    public Player requester;
    public double amount;
    public Location pinLocation;
    private String receiverAccountName;

    public PinRequest(Player payer, Player requester, String receiverAccountName, double amount) {
        this.payer = payer;
        this.requester = requester;
        this.receiverAccountName = receiverAccountName;
        this.amount = amount;

        Cache.pinInitiationRequests.put(requester.getName(), this);
    }

    public boolean isPending() {
        return Cache.pinRequests.containsKey(this.payer.getName());
    }

    public void awaitingPayment(Location pinLocation) {
        Cache.pinInitiationRequests.remove(this.requester.getName());

        this.pinLocation = pinLocation;
        Cache.pinRequests.put(this.payer.getName(), this);
    }

    public boolean tryPaying(Player p) {
        if (this.isPending()) {
            PinRequest pr = Cache.pinRequests.get(this.payer.getName());
            if (pr.amount <= Economy.getEconomy().getBalance(p)) {
                Economy.getEconomy().withdrawPlayer(p, pr.amount);

                // TODO: Add money to the appropiate account

                Cache.pinRequests.remove(this.payer.getName());
                return true;
            }
        }
        return false;
    }

}
