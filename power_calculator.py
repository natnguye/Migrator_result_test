

```python
def power_func(base, exponent):
    if not isinstance(base, (int, float)):
        raise TypeError("Base must be a numeric value")
    if not isinstance(exponent, int) or exponent < 0:
        raise ValueError("Exponent must be a non-negative integer")
    
    result = 1
    for i in range(exponent):
        print(f"Iteration {i+1}: {result} * {base} = {result * base}")
        result *= base
    return result

base = 2
exponent = 8
try:
    result = power_func(base, exponent)
    print(f"Power({base}, {exponent}) = {result}")
except (TypeError, ValueError) as e:
    print(f"Error: {e}")
```