import sys

inf = float("inf")

def dijkstra(adj,o,d):
    q = []
    parent = {}
    dist = {}
    for v in adj:
        dist[v] = inf
        q.append(v)
    dist[o] = 0
    while q:
        u = q[0]
        for w in q:
            if dist[w] < dist[u]:
                u = w
        q.remove(u)
        for (v,w) in adj[u]:
            alt = dist[u] + w
            if alt < dist[v]:
                dist[v] = alt
                parent[v] = u
    return dist[d]



grafo = {}
origem,destino = sys.stdin.readline().split()
for l in sys.stdin:
    cidades = l.split()
    if cidades[0] not in grafo:
        grafo[cidades[0]] = set()
    for i in range(1,len(cidades)-1):
        if cidades[i].isdigit():
            if cidades[i+1] not in grafo:
                grafo[cidades[i+1]] = set()
            grafo[cidades[i-1]].add((cidades[i+1],int(cidades[i])))
            grafo[cidades[i+1]].add((cidades[i-1],int(cidades[i])))
print dijkstra(grafo,origem,destino)
