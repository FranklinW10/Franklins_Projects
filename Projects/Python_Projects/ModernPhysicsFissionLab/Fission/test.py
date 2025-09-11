import numpy as np

# Generate 9 random numbers between 0 and 1
r = np.random.rand(9)
print("Random values:", r)

# Try some math to verify NumPy works
theta = np.arccos(2 * r[0] - 1)
phi = 2 * np.pi * r[1]
print("Theta (radians):", theta)
print("Phi (radians):", phi)