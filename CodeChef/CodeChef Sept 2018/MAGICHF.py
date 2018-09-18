t = int(input())

for i in range(t):
	n, x, s = list(map(int, input().strip().split()))
	
	for _ in range(s):
		a, b = list(map(int, input().strip().split()))
		if a == x or b == x:
			x = b if (a == x) else a

	print(x)