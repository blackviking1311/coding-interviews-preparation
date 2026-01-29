package org.example.algorithms.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    private List<String> ans;

    private boolean isPathValid(int[][] grid, int i, int j) {
        return i < grid.length && j < grid[0].length && i >= 0 && j >= 0;
    }

    private void findPath(int[][] grid, int i, int j, String currentPath) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (grid[i][j] == 0) return;
            this.ans.add(currentPath);
            return;
        }

        if (!isPathValid(grid, i, j)) return;

        if (grid[i][j] == 0) return;

        grid[i][j] = 0;
        this.findPath(grid, i, j + 1, currentPath + "R");
        this.findPath(grid, i, j - 1, currentPath + "L");
        this.findPath(grid, i - 1, j, currentPath + "U");
        this.findPath(grid, i + 1, j, currentPath + "D");
        grid[i][j] = 1;
    }

    public List<String> findPath(int[][] grid) {
        this.ans = new ArrayList<>();
        this.findPath(grid, 0, 0, "");
        return this.ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        RatInMaze maze = new RatInMaze();
        System.out.println(maze.findPath(arr));
    }
}
