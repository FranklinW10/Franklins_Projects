
import numpy as np
##M=mass of unraniam block
#S = a/b (the ratio of the lengths of two of the sides of the block)
#N = number of random fissions to use in calculating f.


def computeBolockDim(M,S):
    a=(M*S)**(1/3)
    b=(M/(S**2))**(1/3)
    return a,b

def isWithin(x,y,z,a,b):
    return (-a/2)<=x<=(a/2) and (-a/2)<=y<=(a/2) and (-b/2)<=z<=(b/2)

def simuateFission(a,b):
    r = np.random.rand(9)
    x0 = a*(r[0]-(1/2))
    y0 = a*(r[1]-(1/2))
    z0 = a*(r[2]-(1/2))
    phi = 2*(np.pi)*r[3]
    costheta=2*(r[4]-(1/2))
    theta = np.arccos(costheta)
    phip = 2*(np.pi)*r[5]
    costhetap=2*(r[6]-(1/2))
    theta2 = np.arccos(costhetap)
    d=r[7]
    dp=r[8]

    x1 = x0 + d * np.sin(theta) * np.cos(phi)
    y1 = y0 + d * np.sin(theta) * np.sin(phi)
    z1 = z0 + d * costheta

    x2 = x0 + dp * np.sin(theta2) * np.cos(phip)
    y2 = y0 + dp * np.sin(theta2) * np.sin(phip)
    z2 = z0 + dp * costhetap

    hits = 0
    if isWithin(x1, y1, z1, a, b):
        hits += 1
    if isWithin(x2, y2, z2, a, b):
        hits += 1

    return hits

def survivalFrac(M,S,N):
    
    a,b = computeBolockDim(M,S)
    Nin=0

    for _ in range(N):
        Nin += simuateFission(a,b)
    f=Nin/N
    return f

M=6.1
S=1.5
N=1000
f = survivalFrac(M,S,N)
print("Survival fraction equals", f)


