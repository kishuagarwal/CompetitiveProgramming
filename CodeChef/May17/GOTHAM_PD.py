import sys
sys.setrecursionlimit(1000000)
n,q = map(int, raw_input().strip().split(' '))
r, key = map(int, raw_input().strip().split(' '))

r -= 1

#tree = [[] for i in xrange(n+q+10)]
tree = {}

#keys = [0 for i in xrange(n+q+10)]
keys = {}

keys[r] = key

for i in xrange(n-1):
    u,v,k = map(int ,raw_input().strip().split(' '))
    u -= 1
    v -= 1
    if v not in tree:
        tree[v] = []
    if u not in tree:
        tree[u] = []
    tree[v].append(u)
    tree[u].append(v)
    keys[u] = k

tries = {}

def add_key_to_trie(child, parent):
    if parent is None:
        root = {}
    else:
        root = tries[parent]

    s = bin(keys[child])[2:]
    s = '0' * (31 - len(s)) + s
    new_root = {}
    current_old_node = root
    current_new_node = new_root
    for c in s:
        if c == '0':
            current_new_node['0'] = {}
            if '1' in current_old_node: 
                current_new_node['1'] = current_old_node['1']
            current_new_node = current_new_node['0']

            if '0' in current_old_node:
                current_old_node = current_old_node['0']
            else:
                current_old_node = {}
        else:
            current_new_node['1'] = {}
            if '0' in current_old_node:
                current_new_node['0'] = current_old_node['0']
            current_new_node = current_new_node['1']
            if '1' in current_old_node:
                current_old_node = current_old_node['1']
            else:
                current_old_node = {}
    
    tries[child] = new_root

def dfs(node, parent):
    add_key_to_trie(node, parent)
    for child in tree[node]:
        if child != parent:
            dfs(child, node)


dfs(r, None)
last_answer = 0
for i in xrange(q):
    inp = map(int, raw_input().strip().split(' '))
    for j in xrange(len(inp)):
        inp[j] = inp[j] ^ last_answer
    if inp[0] == 0:
        v,u,k = inp[1], inp[2], inp[3]
        v -= 1
        u -= 1
        keys[u] = k
        add_key_to_trie(u, v)
    else:
        v,k = inp[1], inp[2]
        v -= 1
        trie = tries[v]
        s = bin(k)[2:]
        s = '0' * (31 - len(s)) + s
        a = ''
        b = ''
        current_a_node = trie
        current_b_node = trie
        #print 'Key to be found', k
        #print trie
        for c in s:
            if c == '0':
                same = '0'
                other = '1'
            else:
                same = '1'
                other = '0'
            if c in current_a_node:
                current_a_node = current_a_node[c]
                a += c
            else:
                current_a_node = current_a_node[other]
                a += other
            if other in current_b_node:
                b += other
                current_b_node = current_b_node[other]
            else:
                b += same
                current_b_node = current_b_node[same]
        a,b = int(a,2),int(b,2)
        print a^k,b^k
        a ^= k
        b ^= k
        last_answer = a ^ b