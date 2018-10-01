t = int(input())

for i in range(t):
    n = int(input())
    fingers_length = list(map(int, input().strip().split()))
    sheaths_length = list(map(int, input().strip().split()))
    frontPossible = True
    backPossible = True
    for j in range(n):
        if fingers_length[j] > sheaths_length[j]:
            frontPossible = False
        if fingers_length[j] > sheaths_length[n-j-1]:
            backPossible = False
    if frontPossible and backPossible:
        print('both')
    elif frontPossible:
        print("front")
    elif backPossible:
        print('back')
    else:
        print("none")
