import random
import sys
#Introduce player to the game.
print("Welcome to the number guessing game!\n"
      "In this game, you will be able to choose a desired range of numbers and attempt to guess the randomly selected number. "
      "\nYou will have 10 chances to predict the number."
      "\nIf you guess the number correctly, you will have won the game. "
      "\nIf you have not guessed the number after 10 chances you will lose the game.")

#Create a starting number and ending number of the users choosing.
starting_num = int(input("\nEnter the number your range would like to start at: "))
last_num = int(input("Enter the number your range would like to end at: "))

#Create the random number that will be guessed by the user.
random_num = int(random.randrange(starting_num, last_num, 1))

#Initialize an attempts integer for wrong guesses
attempts = 0

#While loop for number of guesses and for the playing of the game.
while attempts <= 10:
      #allow user to guess the number.
      user_choice = int(input("Guess the number: "))
      #If the user correctly guessed the number, they have won the game.
      if user_choice == random_num:
            print("Congratulations, you have won the game!!!")
            sys.exit()
      #If the users guess was too high, give them a hint.
      elif user_choice > random_num:
            print("Your guess is a little too high...try again.")
      #If the users guess was too low give them a hint.
      elif user_choice < random_num:
            print("Your guess is a little too low...try again.")
      #Increment the number of attempts since the answer was incorrect.
      attempts += 1
