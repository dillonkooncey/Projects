#More advanced calculator.
num1 = float(input("Enter first number:"))
op = input("Enter operator: ")
num2 = float(input("Enter second number: "))

#If condition statements to check the operator the user would like to use.
if op == "+":
    print(num1 + num2)
elif op == "-":
    print(num1 - num2)
elif op == "*":
    print(num1 * num2)
elif op == "/":
    print(num1 / num2)
else:
    print("Invalid operator.")
