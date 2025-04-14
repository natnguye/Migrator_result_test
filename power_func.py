

```python
def power_func(a, b):
    try:
        a = float(a)
        b = int(b)
        if b < 0:
            raise ValueError
    except ValueError:
        return "Invalid input. 'a' should be a number and 'b' should be a non-negative integer."
    res = 1
    for i in range(b):
        res *= a
        print(f"Iteration {i+1} of {b}: res = {res}")
    return res

a = 2
b = 8
if isinstance(a, (int, float)) and isinstance(b, int) and b >= 0:
    result = power_func(a, b)
    print(result)
    print(f"power({a}, {b}) = {result}")
else:
    print("Invalid input. 'a' should be a number and 'b' should be a non-negative integer.")
```