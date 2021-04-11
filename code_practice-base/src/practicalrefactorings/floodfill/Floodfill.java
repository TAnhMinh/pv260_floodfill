/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.floodfill;

import java.awt.Color;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Floodfill {

	public Grid<Color> fillAt(Grid<Color> original, int startX, int startY, Color color) {
		Position start = new Position(startX, startY);
		Grid<Color> copy = getGridCopy(original);
		Color replacingColor = original.get(startX, startY);

		Queue<Position> left = new LinkedList<>();
		left.add(start);
		if (!replacingColor.equals(color)) {
			while (!left.isEmpty()) {
				Position at = left.poll();
				copy.set(color, at.x(), at.y());
				Collection<Position> uncoloredNeighbors = getUncoloredNeighbors(copy, replacingColor, at);
				left.addAll(uncoloredNeighbors);
			}
		}
		return copy;
	}

	private Collection<Position> getUncoloredNeighbors(Grid<Color> copy, Color replacingColor, Position at) {
		Collection<Position> neighbors = getNeighbors(at);
		Collection<Position> uncoloredNeighbors = new ArrayList<>();
		for (Position position : neighbors) {
			try {
				Color colorAtPosition = copy.get(position.x(), position.y());
				if (colorAtPosition.equals(replacingColor)) {
					uncoloredNeighbors.add(position);
				}
			}
			catch(IndexOutOfBoundsException ignored){ }
		}
		return uncoloredNeighbors;
	}

	private Collection<Position> getNeighbors(Position at) {
		return asList(
					new Position(at.x() + 1, at.y()),
					new Position(at.x(), at.y() + 1),
					new Position(at.x() - 1, at.y()),
					new Position(at.x(), at.y() - 1)
			);
	}

	private Grid<Color> getGridCopy(Grid<Color> original) {
		Grid<Color> copy = new ArrayBackedGrid<>(original.width(), original.height());
		for (int x = 0; x < original.width(); x++) {
			for (int y = 0; y < original.height(); y++) {
				copy.set(original.get(x, y), x, y);
			}
		}
		return copy;
	}
}
