from itertools import combinations
import math



# Function to read input faster

# Main function for the problem

    # Your code logic goes here


# Function to calculate the factorial of a number
def factorial(n):
    return math.factorial(n)


# Function to calculate the nCr (combination) value
def nCr(n, r):
    return math.comb(n, r)


# Function to find the greatest common divisor (GCD) of two numbers
def gcd(a, b):
    return math.gcd(a, b)


# Function to find the least common multiple (LCM) of two numbers
def lcm(a, b):
    return a * b // math.gcd(a, b)


# Function to check if a number is prime
def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


# Function to get all the prime factors of a number
def prime_factors(n):
    factors = []
    while n % 2 == 0:
        factors.append(2)
        n //= 2
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            factors.append(i)
            n //= i
    if n > 2:
        factors.append(n)
    return factors


# Function to get all the divisors of a number
def divisors(n):
    divs = []
    for i in range(1, int(math.sqrt(n)) + 1):
        if n % i == 0:
            divs.append(i)
            if i != n // i:
                divs.append(n // i)
    return divs

def dgp(N, frnds):
    groups = []
    for comb in combinations(range(N), 3):
        i, j, k = comb
        if (i, j) in frnds and (j, k) in frnds and (i, k) in frnds:
            group = sorted([i + 1, j + 1, k + 1])
            if group not in groups:
                groups.append(group)
    return groups


def dfs(node, parent, adj, wts, xorv):
    xorv[node] = wts[node]
    for child in adj[node]:
        if child != parent:
            dfs(child, node, adj, wts, xorv)
            xorv[node] ^= xorv[child]

def main():
    n, q = map(int, input().split())

    wts = [0] + list(map(int, input().split()))  # Fix for reading space-separated integers
    xorv = [0] * (n+1)

    adj = [[] for _ in range(n+1)]

    for i in range(n-1):
        x, y = map(int, input().split())
        adj[x].append(y)
        adj[y].append(x)

    dfs(1, 0, adj, wts, xorv)

    lazy_updates = [0] * (n+1)  # Store lazy updates for XOR values

    while q > 0:
        q -= 1
        input_line = input().split()
        type = int(input_line[0])
        if type == 1:
            node, w = map(int, input_line[1:])
            xorv[node] ^= w ^ wts[node]
            wts[node] = w
            for child in adj[node]:
                if child != node:
                    lazy_updates[child] ^= w ^ wts[node]
        else:
            node = int(input_line[1])
            result = xorv[1] ^ xorv[node] ^ lazy_updates[node]
            print(result)

if __name__ == "__main__":
    main()
