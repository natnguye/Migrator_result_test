

import sys

def power_func(a, b):
    res = 1
    for i in range(b):
        print(f"Iteration {i+1}, intermediate result: {res}")
        res *= a
    return res

def main():
    base = 2
    exponent = 3
    result = power_func(base, exponent)
    print(f"The final result is: {result}")

def extract_file_details_adapter_agent(metadata):
    return {
        "file_type": "FileType.TCL_SCRIPT",
        "file_type_details": "This file contains a TCL script with a procedure definition for calculating the power of a number.",
        "file_name": "main.tcl",
        "package": "N/A",
        "language": "TCL",
        "dependencies": [],
        "importable_elements": [
            {
                "name": "power_func",
                "fully_qualified_name": "power_func"
            }
        ]
    }

if __name__ == "__main__":
    main()