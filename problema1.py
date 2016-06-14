import sys


def percorre(n,digitos,i):
    
    if i == 13:
        if (n%10) == 0:
            return True
        else:
            return False
    
    for x in p:
        d = int(digitos[i])
        n+=d*x
        if percorre(n,digitos,i+1):
            return True
        n-=d*x
    return False

livros = {}
p = [1,3]
for l in sys.stdin:
    (dig,nome) = l.split(', ')
    livros[dig] = nome[:-1]

errados = []
for dig in livros:
    if not percorre(0,dig,0):
        errados.append(livros[dig] + ", " + dig)
errados.sort()
for l in errados:
    print l
