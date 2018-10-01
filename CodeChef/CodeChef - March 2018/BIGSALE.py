t = int(input())

for i in range(t):
    n = int(input())
    total_loss = 0
    for j in range(n):
        price, quantity, discount = list(map(int, input().strip().split()))
        loss = price * quantity * (100 ** 2 - (100 ** 2 - discount ** 2)) / (100 ** 2)
        total_loss += loss
    print(total_loss)


