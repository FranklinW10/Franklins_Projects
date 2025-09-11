# Monte Carlo Nuclear Fission Simulation

**Authors:** Xander Kwa, Franklin Wohnoutka, Sagar Bhandari  
**Date:** May 2025  
**Course:** Advanced Lab – Modern Physics  

A Python project simulating nuclear fission using **Monte Carlo methods**. This project calculates **critical mass** and the **multiplication factor (f)** for different uranium geometries, providing insights into chain reactions and the physics of fission.

---

## Abstract

Heavy nuclei have been undergoing spontaneous fission since their creation. This experiment investigates nuclear fission, focusing on **chain reactions** simulated using Monte Carlo methods. Fission occurs when a heavy nucleus (like uranium-235) absorbs a neutron, splits into smaller nuclei, releases energy, and emits additional neutrons. These neutrons can induce further fissions, potentially creating a self-sustaining chain reaction. The lab explores the conditions necessary for such a reaction, including **critical mass**, **neutron moderation**, and the **multiplication factor (f)**.

---

## Introduction

To understand chain reactions, we created a Python simulation to calculate the **multiplication factor (f)**. The simulation models nuclear fission using Monte Carlo methods, exploring how factors like neutron absorption, escape probability, and material geometry affect the likelihood of a sustained chain reaction.  

Each fission releases 2 neutrons, each with a chance of inducing further fission. By calculating the survival fraction of neutrons, we estimate the conditions required for the system to reach the **critical value**, where each fission produces, on average, one induced fission.

The simulation repeats these events, testing how different shapes and sizes of fissile material affect the number of sustained chain reactions.

---

## Procedure

1. **Simulation Functions**  
   - Compute block dimensions `(a, b)` based on mass `M` and side ratio `S`.  
   - Simulate random fissions with randomly generated starting and endpoint coordinates for two neutrons.  
   - Test if endpoints are inside the uranium block. If yes, increment a `hits` variable.  
   - Repeat the process for `N` fissions.

2. **Critical Mass Calculations**  
   - For a cube (S = 1), gradually increase `M` until `f ≈ 1`.  
   - Repeat for other rectangular shapes (S = 0.5 and S = 1.5).  
   - Simulate a spherical geometry by setting radius = a/2 and calculate critical mass.

---

## Data & Results

- **Cube (S = 1):** Critical mass M ≈ 1.5  
- **Rectangle (S = 0.5):** Critical mass M ≈ 1.31  
- **Rectangle (S = 1.5):** Critical mass M ≈ 6  
- **Sphere:** Critical mass M ≈ 1.43  

Observations:

- For rectangles, as side ratio S increases, critical mass M grows rapidly (positive exponential relationship).  
- Spherical geometry requires slightly lower critical mass than elongated shapes, confirming theoretical expectations about neutron containment.  

---

## Conclusion

The Monte Carlo simulation successfully modeled nuclear fission chain reactions and determined critical mass for various uranium geometries. Key insights include:

- Shape and size significantly influence the multiplication factor f.  
- Rectangular blocks: larger side ratios lead to higher critical mass due to increased neutron escape.  
- Spheres: minimal surface-to-volume ratio reduces neutron escape, lowering critical mass.  

This simulation highlights the **importance of geometry in nuclear reactor design** and demonstrates the delicate balance needed to sustain chain reactions safely.

---

## How to Run
1. Clone the repository:

```bash
git clone https://github.com/FranklinW10/Franklins_Projects.git
cd Franklins_Projects/Projects/Python_Projects/ModernPhysicsFissionLab/FissionCode
```
2. Install dependencies:

```bash
pip install numpy matplotlib
```
3. Run either of the 2 simulations
```bash
Python3 Fission.py
```
or
```bash
Python3 FissionSphere.py
```
4. Review printed outputs for critical mass and survival fraction. 

