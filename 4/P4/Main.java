import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Mafia x=new Mafia("x");
        // Mafia y=new Mafia("y");
        // Godfather g=Godfather.godfather();
        // g.setName("g");
        // Player a=new Villager("a");
        // Player b=new Villager("b");
        // Doctor d=Doctor.doctor();
        // d.setName("d");
        // Player[] players = {g, x, y, d, a, b};
        // God.setPlayers(players);
        // God.setSize(players.length);

        // x.setNightVote(a);
        // y.setNightVote(b);
        // x.action();
        // y.action();
        // for(String s: g.getNames()){
        //     if(s!=null){
        //             System.out.print(s+" ");
        //     }
        // }
        // System.out.println();

        // g.setFinalVote(a);
        // g.action();
        // System.out.println(God.playerTypes());

        // d.setSaved(a);
        // d.action();
        // System.out.println(God.playerTypes());
        
        // x.setVoted("a");
        // y.setVoted("a");
        // g.setVoted("b");
        // a.setVoted("b");
        // b.setVoted("x");
        // d.setVoted("y");
        // God.killedAtDay();
        // System.out.println(God.playerTypes());
        
        // b.setVoted("a");
        // God.killedAtDay();
        // System.out.println(God.playerTypes());
        // System.out.println(Arrays.toString(God.players));
        Player p=new Villager("a");
p.setVoted("b");
p.vote();
Mafia q=new Mafia("c");
q.setNightVote(new Villager("d"));
q.action().getName();
Godfather g=Godfather.godfather();
g.setFinalVote(new Villager("e"));
g.action().getName();
System.out.println(God.playerTypes().toString());    ;
    }
}