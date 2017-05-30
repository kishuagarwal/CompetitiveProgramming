n = int(raw_input())

valid_strings = []
blocked_strings = []
for i in xrange(n):
    a,b = raw_input().strip().split()
    if a == '+':
        valid_strings.append(b.strip())
    else:
        blocked_strings.append(b.strip())

trie = {}

for s in valid_strings:
    current_node = trie
    for c in s:
        if current_node.has_key(c):
            current_node = current_node[c][1]
        else:
            current_node[c] = [0, {}]
            current_node = current_node[c][1]
ans = 0

is_possible = True

filters = []
for s in blocked_strings:
    current_node = trie
    length = len(s)
    for index, c in enumerate(s):
        if current_node.has_key(c):
            if current_node[c][0] == 1:
                break
            if index == length - 1:
                is_possible = False
                break
            current_node = current_node[c][1]
        else:
            current_node[c] = [1, {}]
            ans += 1
            filters.append(s[:index+1])
            break
    if not is_possible:
        break

print trie
if is_possible:
    print ans
    filters.sort()
    for i in filters:
        print i
else:
    print -1
