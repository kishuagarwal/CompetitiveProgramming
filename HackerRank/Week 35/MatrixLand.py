n, m = map(int, input().strip().split())

a = [[0 for i in range(m+2)]]

for _ in range(n):
    row = [0]
    row.extend(map(int, input().strip().split()))
    row.append(0)
    a.append(row)

d = [0 for _ in range(m + 2)]
msl = d[:]
msr = d[:]

dpCurrent = d.copy()
for i in range(1, n + 1):
    aCurrent = a[i]
    for j in range(1, m+1):
        msl[j] = max(msl[j-1] + aCurrent[j], 0)
    for j in range(m, 0, -1):
        msr[j] = max(msr[j+1] + aCurrent[j], 0)

    dpPrevious = dpCurrent
    dpCurrent = d.copy()
    d[1] = dpPrevious[1] + aCurrent[1]
    dpCurrent[1] = d[1] + msr[2]
    for j in range(2, m+1):
        d[j] = max(d[j-1] + aCurrent[j], dpPrevious[j] + aCurrent[j] + msl[j-1])
        dpCurrent[j] = d[j] + msr[j+1]

    d[m] = dpPrevious[m] + aCurrent[m]
    dpCurrent[m] = max(dpCurrent[m], d[m] + msl[m-1])
    for j in range(m-1, 0, -1):
        d[j] = max(d[j+1] + aCurrent[j], dpPrevious[j] + aCurrent[j] + msr[j+1])
        dpCurrent[j] = max(dpCurrent[j], d[j] + msl[j-1])

print(max(dpCurrent))

