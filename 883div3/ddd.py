import sys

def calculate_total_area(n, d, h, heights):
    total_area = 0
    for i in range(n):
        area = (d - (heights[i] - total_area * h / d)) * h / 2
        total_area += area
    return total_area

def main():
    # Read the number of test cases
    t = int(input())

    # Process each test case
    for _ in range(t):
        # Read the values of n, d, and h
        n, d, h = map(int, input().split())

        # Read the heights of the bases of the branches
        heights = list(map(int, input().split()))

        # Calculate the total area of the tree branches
        total_area = calculate_total_area(n, d, h, heights)

        # Print the total area
        print(total_area)

if __name__ == "__main__":
    main()
