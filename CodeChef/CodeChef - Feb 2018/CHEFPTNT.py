t = int(input())

for i in range(t):
    n, m, x, k = list(map(int, input().strip().split()))
    even_odd = input().strip()
    odd_count = even_odd.count('O')
    even_count = len(even_odd) - odd_count
    # complete the odd month task
    n -= min(((m+1) // 2) * x, odd_count)
    # complete the even month task
    n -= min((m // 2) * x, even_count)
    if n <= 0:
        print('yes')
    else:
        print('no')
