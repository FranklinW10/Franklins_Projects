import numpy as np

def compute_sphere_radius(M):
    # Density = 1, so volume = mass
    # Volume of sphere V = (4/3) * pi * r^3 = M
    r = (3 * M / (4 * np.pi)) ** (1/3)
    return r

def is_within_sphere(x, y, z, r):
    return x**2 + y**2 + z**2 <= r**2

def simulate_fission_sphere(r):
    # Generate random fission position inside the sphere
    while True:
        # Random point in cube [-r, r]^3
        x0, y0, z0 = (np.random.uniform(-r, r) for _ in range(3))
        if is_within_sphere(x0, y0, z0, r):
            break
    
    # Random neutron directions and distances as before
    r_vals = np.random.rand(7)  # we only need 7 randoms here
    
    phi = 2 * np.pi * r_vals[0]
    costheta = 2 * (r_vals[1] - 0.5)
    theta = np.arccos(costheta)
    
    phip = 2 * np.pi * r_vals[2]
    costhetap = 2 * (r_vals[3] - 0.5)
    theta2 = np.arccos(costhetap)
    
    d = r_vals[4]
    dp = r_vals[5]
    
    x1 = x0 + d * np.sin(theta) * np.cos(phi)
    y1 = y0 + d * np.sin(theta) * np.sin(phi)
    z1 = z0 + d * costheta

    x2 = x0 + dp * np.sin(theta2) * np.cos(phip)
    y2 = y0 + dp * np.sin(theta2) * np.sin(phip)
    z2 = z0 + dp * costhetap

    hits = 0
    if is_within_sphere(x1, y1, z1, r):
        hits += 1
    if is_within_sphere(x2, y2, z2, r):
        hits += 1

    return hits

def survival_fraction_sphere(M, N):
    r = compute_sphere_radius(M)
    Nin = 0

    for _ in range(N):
        Nin += simulate_fission_sphere(r)

    f = Nin / N
    return f

# Example usage:
M = 1.43# mass
N = 1000  # number of fissions to simulate
f = survival_fraction_sphere(M, N)
print("Survival fraction equals", f)