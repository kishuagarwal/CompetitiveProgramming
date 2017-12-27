def get_cost(grid, color):
    cost = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if (i + j) % 2 == 0 and grid[i][j] == color:
                continue
            if (i + j) % 2 != 0 and grid[i][j] != color:
                continue
            cost += 3 if grid[i][j] == 'G' else 5
    return cost


t = int(input())

for i in range(t):
    n, m = list(map(int, input().strip().split()))
    grid = []
    for j in range(n):
        grid.append(input().strip())
    print(min(get_cost(grid, 'R'), get_cost(grid, 'G')))

