import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
	private int numTasks;
	private int taskSpeed;
	private boolean taskflagVar;
	
	public BlueAstronaut(String n, int susL, int tasks, int speed) {
		super(n, susL);
		numTasks = tasks;
		taskSpeed = speed;
	}

	public BlueAstronaut(String n) {
		super(n,15);
		numTasks = 6;
		taskSpeed = 10;
	}
	
	
	 public boolean equals(Object o) {
	        if (o instanceof BlueAstronaut) {
	            BlueAstronaut b = (BlueAstronaut) o;
	            return this.getName().equals(b.getName()) && this.isFrozen() == b.isFrozen() && this.getSusLevel() == b.getSusLevel()
	                    && this.numTasks == b.numTasks && this.taskSpeed == b.taskSpeed;
	        }
	        return false;
	    }
	
	
	
	@Override
	public void completeTask() {
		// TODO Auto-generated method stub
		if(!this.isFrozen()) {
			if (this.taskSpeed>20) this.numTasks=-20;
			else
				this.numTasks--;
			
			if (this.numTasks<0) numTasks = 0;
			
			if (this.taskflagVar && this.numTasks==0) {
				this.taskflagVar = false;
				System.out.println("I have completed all my tasks");
				this.setSusLevel((int)(this.getSusLevel()*0.5));
			}
		}
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
	
    public String toString() {
        if (this.getSusLevel() > 15)
            return (super.toString() + " I have " + this.numTasks + " left over.").toUpperCase();
        return super.toString() + " I have " + this.numTasks + " left over.";
    }
}

