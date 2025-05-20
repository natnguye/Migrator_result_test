

```python
def calculate_power(base_value, exponent_value):
    result = 1
    for i in range(exponent_value - 1):
        print(f"Iteration {i+1}, Intermediate result: {result}")
        result *= base_value
    return result

def main():
    base_number = 2
    exponent_degree = 8
    result = calculate_power(base_number, exponent_degree)
    print(f"Power({base_number}, {exponent_degree}) = {result}")

if __name__ == "__main__":
    main()
```