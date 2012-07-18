package com.ericsson.algorithms.tw;

/**
 * Class representing the Generation inside universe or the infinite grid
 */
public class Generation {

	/*
	 * Head of the linked list of rules that need to be applied to each cell in
	 * the generation during a tick
	 */
	private Rule rule;

	/* The top-left bound of the generation inside the universe */
	private Location minLocation;

	/* The bottom-right bound of the generation inside the universe */
	private Location maxLocation;

	public Generation(String[][] seed) {
		loadRules();
		loadSeed(seed);
		loadNeighbours();
	}

	/**
	 * Initializing the rules linked list
	 */
	private void loadRules() {
		/*
		 * Rules may be loaded from an XML, for example, to create the rule
		 * chain as shown below
		 */
		rule = new Rule(3, 3, State.DEAD, State.LIVE)
				.setNext(new Rule(3, 3, State.LIVE, State.LIVE))
				.setNext(new Rule(2, 2, State.LIVE, State.LIVE))
				.setNext(new Rule(4, 9, State.LIVE, State.DEAD))
				.setNext(new Rule(0, 1, State.LIVE, State.DEAD));
	}

	/**
	 * Loading the initial seed provided into memory
	 * 
	 * @param seed
	 */
	private void loadSeed(String[][] seed) {
		for (int i = 0; i < seed.length; i++) {
			for (int j = 0; j < seed[0].length; j++) {
				Location location = Location.getLocation(i, j);
				location.setCell(new Cell(seed[i][j]));

				if (minLocation == null || location.compareTo(minLocation) < 0) {
					minLocation = location;
				}

				if (maxLocation == null || location.compareTo(maxLocation) > 0) {
					maxLocation = location;
				}
			}
		}
	}

	/**
	 * Populating the neighbours of each cell in the generation
	 */
	private void loadNeighbours() {
		for (int i = minLocation.getRow(); i <= maxLocation.getRow(); i++) {
			for (int j = minLocation.getColumn(); j <= maxLocation.getColumn(); j++) {
				Cell current = Location.getLocation(i, j).getCell();
				if (current.getNeighbours().isEmpty()) {
					// populate current cell's neighbours
					for (int m = (i - 1); m <= (i + 1); m++) {
						for (int n = (j - 1); n <= (j + 1); n++) {
							if (!(m == i && n == j)) {
								current.getNeighbours().add(
										Location.getLocation(m, n).getCell());
							}
						}
					}
				}
				current.updateLiveNeighbours();
			}
		}
	}

	public void tick() {

		/*
		 * Expanding the generation from all sides to accomodate any new live
		 * cells which may get generated outside the current generation
		 */
		minLocation = Location.getLocation(minLocation.getRow() - 1,
				minLocation.getColumn() - 1);
		maxLocation = Location.getLocation(maxLocation.getRow() + 1,
				maxLocation.getColumn() + 1);

		// Loading neighbours of new cells in the expanded generation.
		loadNeighbours();

		// Applying rules to each cell in the expanded generation
		for (int i = minLocation.getRow(); i <= maxLocation.getRow(); i++) {
			for (int j = minLocation.getColumn(); j <= maxLocation.getColumn(); j++) {
				rule.applyRule(Location.getLocation(i, j).getCell());
			}
		}

		// Trimming the expanded generation, if needed
		trimLeftColumn();
		trimRightColumn();
		trimTopRow();
		trimBottomRow();
	}

	/**
	 * Trimming the left expanded column, if it does not contain any live cell
	 */
	private void trimLeftColumn() {

		for (int i = minLocation.getRow(); i <= maxLocation.getRow(); i++) {
			Location location = Location
					.getLocation(i, minLocation.getColumn());
			if (location.getCell().getState().equals(State.LIVE))
				return;
		}

		minLocation = Location.getLocation(minLocation.getRow(),
				minLocation.getColumn() + 1);
	}

	/**
	 * Trimming the right expanded column, if it does not contain any live cell
	 */
	private void trimRightColumn() {

		for (int i = minLocation.getRow(); i <= maxLocation.getRow(); i++) {
			Location location = Location
					.getLocation(i, maxLocation.getColumn());
			if (location.getCell().getState().equals(State.LIVE))
				return;
		}

		maxLocation = Location.getLocation(maxLocation.getRow(),
				maxLocation.getColumn() - 1);
	}

	/**
	 * Trimming the top expanded row, if it does not contain any live cell
	 */
	private void trimTopRow() {

		for (int i = minLocation.getColumn(); i <= maxLocation.getColumn(); i++) {
			Location location = Location.getLocation(minLocation.getRow(), i);
			if (location.getCell().getState().equals(State.LIVE))
				return;
		}

		minLocation = Location.getLocation(minLocation.getRow() + 1,
				minLocation.getColumn());
	}

	/**
	 * Trimming the bottom expanded row, if it does not contain any live cell
	 */
	private void trimBottomRow() {

		for (int i = minLocation.getColumn(); i <= maxLocation.getColumn(); i++) {
			Location location = Location.getLocation(maxLocation.getRow(), i);
			if (location.getCell().getState().equals(State.LIVE))
				return;
		}

		maxLocation = Location.getLocation(maxLocation.getRow() - 1,
				maxLocation.getColumn());
	}

	public String[][] get() {
		int rows = maxLocation.getRow() - minLocation.getRow() + 1;
		int columns = maxLocation.getColumn() - minLocation.getColumn() + 1;

		int row = 0;
		int column = 0;
		String[][] nextGeneration = new String[rows][columns];

		for (int i = minLocation.getRow(); i <= maxLocation.getRow(); i++) {
			for (int j = minLocation.getColumn(); j <= maxLocation.getColumn(); j++) {
				nextGeneration[row][column++] = Location.getLocation(i, j)
						.getCell().getState().value();
			}
			row++;
			column = 0;
		}

		return nextGeneration;
	}
	
	public void print() {

		for (int i = minLocation.getRow(); i <= maxLocation.getRow(); i++) {
			for (int j = minLocation.getColumn(); j <= maxLocation.getColumn(); j++) {
				Location location = Location.getLocation(i, j);
				System.out.print(location.getCell() + " ");
			}
			System.out.println();
		}
	}
}
