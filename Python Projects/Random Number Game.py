import random

print("Welcome to the number guessing game!\nIn this game, you will be able to choose a desired range of numbers"
      "and attempt to guess the randomly selected number.")

starting_num = int(input("Enter the number your range would like to start at: "))
last_num = int(input("Enter the number your range would like to end at: "))

random_num = int(random.randrange(starting_num, last_num, 1))

