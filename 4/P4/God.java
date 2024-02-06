import java.util.Arrays;

abstract class Player {
    String name;
    String voted;

    Player(String name) {
        this.name = name;
    }

    public String vote() {
        return voted;
    }

    public abstract Player action();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoted() {
        return voted;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }
}

class Mafia extends Player {
    Player nightVote;

    Mafia(String name) {
        super(name);
    }

    public Player getNightVote() {
        return nightVote;
    }

    public void setNightVote(Player nightVote) {
        this.nightVote = nightVote;
    }

    public Player action() {
        Godfather.godfather().addVote(nightVote.getName());
        return nightVote;
    }
}

class Godfather extends Mafia {
    static Godfather godfather;
    String[] names;
    int size;
    Player finalVote;

    private Godfather(String name) {
        super(name);
        names = new String[10];
    }

    static Godfather godfather() {
        if (godfather == null) {
            godfather = new Godfather(null);
        }
        return godfather;
    }

    public String[] addVote(String name) {
        names[size++] = name;
        return names;
    }

    public String[] getNames() {
        return godfather.names;
    }

    public void setNames(String[] names) {
        godfather.names = names;
    }

    public int getSize() {
        return godfather.size;
    }

    public void setSize(int size) {
        godfather.size = size;
    }

    public Player getFinalVote() {
        return finalVote;
    }

    public void setFinalVote(Player finalVote) {
        this.finalVote = finalVote;
    }

    public Player action() {
        God.removePlayer(finalVote);
        return finalVote;
    }
}

class Villager extends Player {

    Villager(String name) {
        super(name);
    }

    public Player action() {
        return null;
    }
}

class Doctor extends Villager {
    static Doctor doctor;
    Player saved;

    private Doctor(String name) {
        super(name);
    }

    static Doctor doctor() {
        if (doctor == null) {
            doctor = new Doctor(null);
        }
        return doctor;
    }

    public Player getSaved() {
        return saved;
    }

    public void setSaved(Player saved) {
        this.saved = saved;
    }

    public Player action() {
        if (Godfather.godfather().getFinalVote().getName().equals(getSaved().getName())) {
            Player[] newPlayers = new Player[God.getSize()+1];

            int i = 0;
            for (Player player : God.players) {
                if (player != null) {
                    newPlayers[i++] = player;
                }
            }
            newPlayers[i++] = getSaved();

            God.setPlayers(newPlayers);
            God.setSize(i);
        }
        return getSaved();
    }
}

public class God {
    public static Player[] players;
    public static int size;

    public static Player[] getPlayers() {
        return players;
    }

    public static void setPlayers(Player[] players) {
        God.players = players;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        God.size = size;
    }

    public static String killedAtDay() {
        int maxVoted = 0;
        Player killed = null;
        

        for (Player player : God.players) {
            if (player != null) {
                int votedCount = votedCount(player);

                if (votedCount > maxVoted) {
                    maxVoted = votedCount;
                    killed = player;
                }
                else if (votedCount == maxVoted) {
                    killed = null;
                }
            }
        }
        if (killed != null) {
            God.removePlayer(killed);
            return killed.getName();
        }
        else {
            return null;
        }
    }

    private static int votedCount(Player p) {
        int count = 0;
        for (Player player : God.players) {
            if (player != null && player.getVoted().equals(p.getName())) {
                count++;
            }
        }
        return count;
    }

    public static String playerTypes(){
        StringBuilder sb = new StringBuilder();
        
        for (Player player: players) {
            if (player != null) {
                sb.append(player.getName());
                sb.append(": ");
                sb.append(getRole(player));
                sb.append("\n");
            }
        }
        return sb.toString();

    }
//
    private static String getRole(Player player) {
        if (player instanceof Godfather) {
            return "Godfather";
        } 
        else if (player instanceof Mafia) {
            return "Mafia";
        } 
        else if (player instanceof Doctor) {
            return "Doctor";
        } 
        else {
            return "Villager";
        }
    }
    
    public static void removePlayer(Player player) {
        int index = Arrays.asList(God.players).indexOf(player);
        for (int i = 0; i < God.getSize(); i++) {
            if (i > index-1 && i < God.getSize()-1)
                God.players[i] = God.players[i+1];

        }
        God.players[God.getSize() - 1] = null;
        God.setSize(God.getSize() - 1);
    }
}
