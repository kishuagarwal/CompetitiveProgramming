import heapq

t = int(raw_input())

for i in xrange(t):
    n, m = map(int, raw_input().strip().split(' '))
    minSalary = map(int, raw_input().strip().split(' '))
    offeredSalary = [0 for _ in xrange(m)]
    maxJobOffers = [0 for _ in xrange(m)] 

    hired = [False for _ in xrange(m)]
    jobGot = 0
    totalSal = 0
    coNotGot = 0

    for j in xrange(m):
        sal, offers = map(int, raw_input().strip().split(' '))
        offeredSalary[j] = sal
        maxJobOffers[j] = offers

    for j in xrange(n):
        offers = raw_input().strip()
        highest_index = -1
        highest_sal = -1
        for index, c in enumerate(offers):
            if c == '1':
                if offeredSalary[index] >= minSalary[j]:
                    if maxJobOffers[index] > 0 and offeredSalary[index] > highest_sal:
                        highest_sal = offeredSalary[index]
                        highest_index = index

        if highest_index != -1:
            maxJobOffers[highest_index] -= 1
            hired[highest_index] = True
            jobGot += 1
            totalSal += highest_sal

    for hire in hired:
        if not hire:
            coNotGot += 1

    print jobGot, totalSal, coNotGot