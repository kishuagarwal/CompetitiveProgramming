n = int(input())
v = list(map(int, input().split(' ')))


def dfs(day, previous_activity):
    if day >= n:
        return 0
    val = v[day]
    ans = n - day + 1
    if (val == 1 or val == 3) and previous_activity != 4:
        rest = dfs(day + 1, 4)
        ans = rest

    if (val == 2 or val == 3) and previous_activity != 5:
        rest = dfs(day + 1, 5)
        ans = min(ans, rest)

    rest = 1 + dfs(day + 1, 0)
    ans = min(ans, rest)
    return ans


print(dfs(0, -1))
