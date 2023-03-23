import java.util.ArrayList;
import java.util.List;
public class app{
    public static void main(String args[]) throws Exception{
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("INDIA"));
        teams.add(new Team("Australia"));
        teams.add(new Team("England"));
        teams.add(new Team("Pakistan"));
        teams.add(new Team("NeaZealand"));
        List<Match> matches = Scheduler.createSchedule(teams);
        System.out.println(matches);
        Simulator.playMatches(matches);
        Simulator.showPointsTable(teams,matches);
    }
}


public class Match{
    private Team team1;
    private Team team2;
    private Team winner;
    private Team loser;
    Match(Team team,Team team3){
        this.team1=team;
        this.team2=team3;
    }
    public Team getTeam1(){
        return team1;
    }
    public Team getTeam2(){
        return team2;
    }
    public Team getwinner(){
        return winner;
    }
    public void setWinner(Team winner) {
        this.winner = winner;
    }
    public void getLoser(){
        return loser;
    }
    public void setLoser(Team loser){
        this.loser=loser;
    }
    @Override
    public String toString(){
        String matchDescription = team1 +" vs "+ team2;
        if(winner!= null){
            String result="\n Winner = "+this.winner.toString()+"Loser = "+this.loser.toString()+"\n";
            matchDescription = matchDescription + result;
        }
        return matchDescription;
    }
}


import java.util.ArrayList;
import java.util.List;
public class Scheduler {
    public static List<Match> createSchedule(List<Team> teams){
        List<Match> matches = new ArrayList<>();
        for(int i=0;i<teams.size();i++){
            for(int j=j+1;j<teams.size();j++){
                Match match = new Match(teams.get(i),teams.get(j));
                matches.add(match);
            }
        }
        return matches;
    }
}


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
public class Simulator {
    /**
     * @param matches
     */
    public static void  playMatches(List<Match> matches){
        for(Match match : matches){
            int random = (int)((Math.random()*10)+1);
            //My random logic-This could be anything
            if(random % 2 == 0){
                match.setWinner(match.getTeam1());
                match.setLoser(match.getTeam2());
            }
            else{
                match.setWinner(match.getTeam2());
                match.setLoser(match.getTeam1());
            }
        }
    }
    static void showPointsTable(List<Team> teams,List<Match> matches){
        for(Team team : teams){
            int wonGames = matches.stream().filter(m -> m.getWinner().equals((team)).collect(Collectors.toList()).size());
            int lostGames = matches.stream().filter(m -> m.getLoser().equals((team)).collect(Collectors.toList()).size());
            System.out.println(team);
            System.out.println(String.valueOf(wonGames));
            System.out.println(String.valueOf(lostGames));
        
        
        }
    }
}


public class Team {
    private String name;
    Team(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        //ToDo Auto-generated method stub
        return name;
    }
    @Override
    public boolean equals(Object obj){
        //ToDo Auto-generated methos stub
        return this.name.equals(((Team)obj).name);
    }
}
