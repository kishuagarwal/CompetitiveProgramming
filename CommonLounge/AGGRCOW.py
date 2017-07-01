t = int(raw_input())

for i in xrange(t):
    n,c= map(int, raw_input().strip().split())
    locations = []
    for j in xrange(n):
        locations.append(int(raw_input().strip()))
    locations.sort()
    lo = 1
    hi = int(1e9)

    while lo < hi:
        mid = lo + (hi - lo + 1) / 2
        possible = True
        prev = locations[0]
        stall_pos = 1
        for j in xrange(c-1):
            while True:
                if stall_pos < n and locations[stall_pos] - prev >= mid:
                    prev = locations[stall_pos]
                    stall_pos += 1
                    break
                elif stall_pos >= n:
                    possible = False
                    break
                stall_pos += 1
            if not possible:
                break

        if not possible:
            hi = mid - 1
        else:
            lo = mid 

    print lo