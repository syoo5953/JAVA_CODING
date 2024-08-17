import java.util.*;

public class FloodFill {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 상하좌우
    static boolean[][] visited;
    
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 1, 0}
        };
        
        List<Integer> areas = findAreas(grid);
        System.out.println("Areas: " + areas);
    }
    
    public static List<Integer> findAreas(int[][] grid) {
        List<Integer> areas = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = floodFill(grid, i, j);
                    System.out.println(area);
                    areas.add(area);
                }
            }
        }
        
        return areas;
    }
    
    public static int floodFill(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        
        visited[row][col] = true;
        int area = 1;
        
        for (int[] direction : directions) {
            area += floodFill(grid, row + direction[0], col + direction[1]);
        }
        
        return area;
    }
}
