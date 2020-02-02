
public class Ising {
	public Grid grid;
	public double temperature;
	public int size;
	public Ising (int s, double t) {
		this.grid = new Grid(s);
		this.size = s;
		this.temperature = t;
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				grid.setState(i, j, (int) (2*Math.floor(Math.random() + 0.5) - 1));
			}
		}
		this.temperature = t;
	}
	public int energyChange (int row, int column) {
		// todo
		// compute the energy change due to a hypothetical flipping of the dipole in given row and column
		// we'll use periodic boundary conditions
		return 2*
				grid.state(row, column)*
				(grid.state((row - 1 + size) % size, column) 
						+ grid.state(row, (column - 1 + size) % size) 
						+ grid.state((row + 1) % size, column) 
						+ grid.state(row, (column + 1) % size));
	}
	public void evolve () {
		int row = (int) Math.floor(size*Math.random());
		int column = (int) Math.floor(size*Math.random());
		int energyChange = energyChange(row, column);
		if (energyChange < 0) {
			grid.setState(row, column, -1*grid.state(row, column));
		} else {
			if (Math.random() < Math.exp(-1*energyChange/temperature)) {
				grid.setState(row, column, -1*grid.state(row, column));
			}
		}
	}
}
