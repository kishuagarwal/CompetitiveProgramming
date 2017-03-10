s = raw_input()

m = {'R': 0,
    'B': 1,
    'Y': 2,
    'G': 3}

pos = [0, 0, 0 , 0]
count = [0, 0, 0, 0]

l = len(s)
for index,c in enumerate(s):
    if c != '!':
        pos[index % 4] = m[c]

for index, c in enumerate(s):
    if c == '!':
        count[pos[index % 4]] += 1
print count[0],count[1], count[2], count[3]