#!/usr/bin/env python3
def c_to_f(c): # Non-descriptive name, no docstring
    return(c*9/5)+32 # No spaces around operators
def c_to_k(c): # Non-descriptive name
    return c+273.15
def f_to_c(f): # Non-descriptive name
    return(f-32)*5/9
def k_to_c(k): # Non-descriptive name
    if k<0: # No spaces around <
        raise ValueError("Kelvin cannot be negative.")
    return k-273.15
def convertTemp(value,unit): # Mixed case naming, no space after comma
    unit=unit.lower() # No space around =
    if unit not in["c","f","k"]: # No spaces in list
        raise ValueError("Unit must be 'C', 'F', or 'K'.")
    r={} # Unclear variable name
    if unit=="c": # No spaces around ==
        r["Celsius"]=value
        r["Fahrenheit"]=c_to_f(value)
        r["Kelvin"]=c_to_k(value)
    elif unit=="f": # No spaces around ==
        c=f_to_c(value) # No space around =
        r["Celsius"]=c
        r["Fahrenheit"]=value
        r["Kelvin"]=c_to_k(c)
    else:
        c=k_to_c(value)
        r["Celsius"]=c
        r["Fahrenheit"]=c_to_f(c)
        r["Kelvin"]=value
    return r
def Main(): # Non-standard function name
    try:
        t=float(input("Enter temperature value:")) # No space after prompt
        u=input("Enter unit (C/F/K):").strip() # No space after prompt
        result=convertTemp(t,u) # No space after comma
        print("\nConversion Results:")
        for k,v in result.items(): # No space after comma
            print(f"{k}: {v:.2f}") # Inconsistent spacing
    except ValueError as e:
        print(f"Error:{e}") # No space after colon
if __name__=="__main__":
    Main()
