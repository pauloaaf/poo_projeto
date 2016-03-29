import sys
from pprint import pprint

inf = float("inf")

def fazGrafo(grafo,matriz,linhas,colunas):
    for i in range(0,linhas):
        for j in range(0,colunas):
            if (i,j) not in grafo:
                grafo[(i,j)] = set()
            if limites(i-1,j,linhas,colunas):
                if (ord(matriz[i-1][j])-ord(matriz[i][j]))<=1:
                    grafo[(i,j)].add((i-1,j))
            if limites(i+1,j,linhas,colunas):
                if (ord(matriz[i+1][j])-ord(matriz[i][j]))<=1:
                    grafo[(i,j)].add((i+1,j))
            if limites(i,j+1,linhas,colunas):
                if (ord(matriz[i][j+1])-ord(matriz[i][j]))<=1:
                    grafo[(i,j)].add((i,j+1))
            if limites(i,j-1,linhas,colunas):
                if ord(matriz[i][j-1])-(ord(matriz[i][j]))<=1:
                    grafo[(i,j)].add((i,j-1))

def limites(i,j,linhas,colunas):
    return i>=0 and i<linhas and j>=0 and j<colunas

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
        for v in adj[u]:
            alt = dist[u] + 1
            if alt < dist[v]:
                dist[v] = alt
                parent[v] = u
    return dist[d]


matriz = []
grafo = {}
menores = []
linhas = colunas = 0
menor = inf
j1 = inf
for l in sys.stdin:
    if l != '\n':
        matriz.append(l.split()[0])
    linhas+=1
colunas = len(l.split()[0])
fazGrafo(grafo,matriz,linhas,colunas)
for j in range(colunas):
    x = dijkstra(grafo,(0,0),(linhas-1,j))
    if x<menor:
        j1 = j
        menor = x
if j1 != inf and menor != inf:
    print j1, menor
    
