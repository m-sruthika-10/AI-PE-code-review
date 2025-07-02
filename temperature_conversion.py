#!/usr/bin/env python3
"""A temperature converter for Celsius, Fahrenheit, and Kelvin."""

def celsius_to_fahrenheit(celsius: float) -> float:
    """Convert Celsius to Fahrenheit."""
    return (celsius * 9 / 5) + 32

def celsius_to_kelvin(celsius: float) -> float:
    """Convert Celsius to Kelvin."""
    return celsius + 273.15

def fahrenheit_to_celsius(fahrenheit: float) -> float:
    """Convert Fahrenheit to Celsius."""
    return (fahrenheit - 32) * 5 / 9

def kelvin_to_celsius(kelvin: float) -> float:
    """Convert Kelvin to Celsius."""
    if kelvin < 0:
        raise ValueError("Kelvin cannot be negative.")
    return kelvin - 273.15

def convert_temperature(value: float, unit: str) -> dict:
    """Convert temperature to all units."""
    unit = unit.lower()
    if unit not in ["c", "f", "k"]:
        raise ValueError("Unit must be 'C', 'F', or 'K'.")
    
    result = {}
    if unit == "c":
        result["Celsius"] = value
        result["Fahrenheit"] = celsius_to_fahrenheit(value)
        result["Kelvin"] = celsius_to_kelvin(value)
    elif unit == "f":
        celsius = fahrenheit_to_celsius(value)
        result["Celsius"] = celsius
        result["Fahrenheit"] = value
        result["Kelvin"] = celsius_to_kelvin(celsius)
    else:  # unit == "k"
        celsius = kelvin_to_celsius(value)
        result["Celsius"] = celsius
        result["Fahrenheit"] = celsius_to_fahrenheit(celsius)
        result["Kelvin"] = value
    return result

def main():
    """Main function to demonstrate temperature conversion."""
    try:
        temp = float(input("Enter temperature value: "))
        unit = input("Enter unit (C/F/K): ").strip()
        result = convert_temperature(temp, unit)
        print("\nConversion Results:")
        for unit_name, value in result.items():
            print(f"{unit_name}: {value:.2f}")
    except ValueError as error:
        print(f"Error: {error}")

if __name__ == "__main__":
    main()
