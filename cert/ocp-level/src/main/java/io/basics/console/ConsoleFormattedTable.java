package io.basics.console;

import java.io.Console;

class ConsoleFormattedTable {
	public static void main(String[] str) {
		ConsoleFormattedTable formattedTable = new ConsoleFormattedTable();
		Console console = System.console();

		// console is null for ide's - use cmd to run it
		if (console != null) {
			formattedTable.line(console);
			formattedTable.printHeader(console);
			formattedTable.line(console);
			formattedTable.printRow(console, "Demando", 100, 122);
			formattedTable.printRow(console, "Mushi", 80, 100);
			formattedTable.printRow(console, "Peale", 150, 180);
			formattedTable.line(console);
		}
	}

	void line(Console console) {
		console.printf("------------------------------------------------------------\n");
	}

	void printHeader(Console console) {
		console.printf("%-15s \t %s \t %s \t %s \n", "Player", "Matches", "Goals",
				"Goals per match");
	}

	void printRow(Console console, String player, int matches, int goals) {
		console.printf("%-15s \t %5d \t\t %d \t\t %.1f \n", player, matches, goals,
				((float) goals / (float) matches));
	}
}