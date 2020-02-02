
public class Grid {
	int size;
	// number of cells wide/long
	int[][] states;
	// states of individual dipoles
	public Grid (int s) {
		this.size = s;
		this.states = new int[s][s];
	}
	public void setStates (int[][] newStates) {
		this.states = newStates;
	}
	public void setState (int row, int column, int state) {
		this.states[row][column] = state;
	}
	public int state (int row, int column) {
		return this.states[row][column];
	}
}
