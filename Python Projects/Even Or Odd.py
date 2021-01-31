# Simple program to find out if a number entered by the user is even or odd. The inform the user of the answer.
year_input = int(input("Enter a number:  "))
if year_input % 2 == 0:
    print("The number you entered must be even.")
else:
    print("The number you have entered must be odd.")
