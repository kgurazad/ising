import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
	
	public static class Dipole extends JComponent {
		public int state;
		public int x;
		public int y;
		public int size;
		public int dimension;
		
		public Dipole (int s, int x, int y, int size, int dimension) {
			this.state = s;
			this.setSize(dimension*(size+1), dimension*(size+1));
			this.setLocation(x, y);
			this.x = x;
			this.y = y;
			this.size = size;
			this.dimension = dimension;
		}
		
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			if (state == -1) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.RED);
			}
			g.drawRect(x, y, dimension, dimension);
			g.fillRect(x, y, dimension, dimension);
			// System.out.println("drawing component for dipole at " + x + ", " + y);
		}
	}
	
	public static void main (String[] args) {
		int size = 20;
		double temperature = 0.2;
		int dimension = 30;
		Ising ising = new Ising(size, temperature);
		JFrame frame = new JFrame("Ising Model");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize((size+1)*dimension, (size+1)*dimension);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize((size+1)*dimension, (size+1)*dimension);
		frame.add(panel);
		frame.setVisible(true);
		for (int i = 0; i < 100000000; i++) {
			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ising.evolve();
			panel.removeAll();
			panel.setSize(new Dimension((size+1)*dimension, (size+1)*dimension));
			for (int j = 0; j < ising.grid.size; j++) {
				for (int k = 0; k < ising.grid.size; k++) {
					panel.add(new Dipole(ising.grid.state(j, k), j*dimension/2, k*dimension/2, size, dimension));
					// System.out.print(ising.grid.state(j, k) + 1);
				}
				// System.out.println();
			}
			// System.out.println();
			panel.repaint();
		}
	}
	public static void lol (String[] args) {
		int size = 10;
		JFrame frame = new JFrame("Ising Model");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize((size+1)*40, (size+1)*40);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize((size+1)*40, (size+1)*40);
		frame.add(panel);
		frame.setVisible(true);
		/*
		panel.add(new Dipole(1, 0, 0, size));
		panel.add(new Dipole(1, 0, 20, size));
		panel.add(new Dipole(1, 0, 40, size));
		panel.add(new Dipole(1, 0, 60, size));
		panel.add(new Dipole(1, 0, 80, size));
		panel.add(new Dipole(1, 0, 100, size));
		panel.add(new Dipole(1, 0, 120, size));
		panel.add(new Dipole(1, 0, 140, size));
		panel.add(new Dipole(1, 0, 160, size));
		panel.add(new Dipole(1, 0, 180, size));
		*/
	}
}
