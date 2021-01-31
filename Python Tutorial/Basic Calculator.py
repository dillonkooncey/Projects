#Building a basic calculator
num1 = input("Enter your first number: ")
num2 = input("Enter your second number: ")
#Make input int since all input from user will automatically be strings. Doesnt guard against doubles/floats.
result = int(num1) + int(num2)
print(result)
#Now use floats in case there are decimals.
result = float(num1) + float(num2)
