

```python
def power_func(a, b):
    res = 1
    for i in range(b):
        print(f"Progress: {i+1}/{b}")
        res *= a
    return res

base = 2
exponent = 3
result = power_func(base, exponent)
print(result)
print(f"The result of {base} to the power of {exponent} is: {result}")
```