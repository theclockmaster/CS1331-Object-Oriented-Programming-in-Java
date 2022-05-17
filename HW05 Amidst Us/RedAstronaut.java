import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
	private String skill;
	
	public RedAstronaut(String n, int sus, String sk){
		super(n, sus);
		skill = sk.toLowerCase();
	}
	
	public RedAstronaut(String n) {
		super(n, 15);
		skill = "experienced";
	}
	
	@Override
	public void emergencyMeeting() {
		if(!this.isFrozen()) {
			Player[] players = Player.getPlayers();
			Arrays.sort(players);
			int len;
			for(len = players.length-1; len>0; len--) {
				
				if (players[len].getSusLevel() != players[len - 1].getSusLevel() && players[len] != this) {
                    if (!players[len].isFrozen()) {
                        players[len].setFrozen(true);
                        break;
                    }
                } else if (players[len].getSusLevel() == players[len-1].getSusLevel() && !players[len].isFrozen() && !players[len-1].isFrozen())
                    return ;
            }
            if (len == 0 && !players[0].isFrozen() && players[0] != this)
                players[0].setFrozen(true);
            this.gameOver();
        }
    }
	
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut redAstro = (RedAstronaut) o;
            return this.getName().equals(redAstro.getName()) && this.isFrozen() == redAstro.isFrozen() && this.getSusLevel() == redAstro.getSusLevel()
                    && this.skill == redAstro.skill;
        }
        return false;
    }	
	
	public String toString() {
        if (this.getSusLevel() > 15)
            return (super.toString() + " I am an " + this.skill + " player!").toUpperCase();
        return super.toString() + " I am an " + this.skill + " player!";
    }

	

	@Override
	public void freeze(Player p) {
		// TODO Auto-generated method stub
		if (!this.isFrozen() && !(p instanceof Impostor)) {
            if (this.getSusLevel() < p.getSusLevel())
                p.setFrozen(true);
            else
                this.setSusLevel(this.getSusLevel() * 2);
            this.gameOver();
        } 
	}

	@Override
	public void sabotage(Player p) {
		// TODO Auto-generated method stub
	     if (!this.isFrozen() && !(p instanceof Impostor))
	         p.setSusLevel(this.getSusLevel() < 20 ? ((int) (p.getSusLevel() * 1.5)) : ((int) (p.getSusLevel() * 1.25)));
	}

}

