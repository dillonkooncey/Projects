#Simple hangman Game
import sys
#Introduce player to the game
print("\nHello players. Welcome to HangMan!\nIn this game, players will have 8 tries to guess a word set by the host."
      "\nIf the players successfully guess the word, then victory has been acheived. \nIf the players fail to "
      "guess the word, then you lose the game.\nPlayers will be given 8 incorrect guesses before losing the game."
      "\nAlso, all words will be played in lower case.")
#While loop to guard against less than 1 players.
num_players = int(input("\nEnter the number of players: "))
print("Your game is being prepared to accomodate " + str(num_players) + " players...\n")
#Word to be played. Selected by the host.
word = str(input("Host, Enter a word to begin the game: "))
word = word.lower()
print(word)

#Create a counter for while loop to help keep track of which player is playing.
count = 1
#Add a guess list for the characters the players play.
guess_list = []
#Add a incorrect counter.
incorrect = 0

while count <= (num_players + 1):
      #If the count is at the max number of players, restart the count back to player 1.
      if count > num_players:
            count = 1
      #Notify the player it is their turn and provide the current list of characters played.
      print("\nPlayer " + str(count) + ". It is your turn...")
      print("Incorrect: " + str(incorrect) + "/8")
      char_guess = str(input("Guess the letter: "))

      #Check if letter has already been played.
      if char_guess in guess_list:
            print("'" + str(char_guess) + "' has already been played.")
      else:
            guess_list.append(char_guess)
            print("'" + str(char_guess) + "' has not already been played.")

      #Check if letter is in the word being played.
      if char_guess in word:
            print("'" + str(char_guess) +  "' was found in the word!")
            word = str.replace(word, char_guess, '', 1)
      else:
            print("'" + str(char_guess) + "' was not found in the word.")
            incorrect += 1

      #If no letters remain, then the player has won the game.
      if len(word) == 0:
            print("Congratulations, you have won the game!!!")
            sys.exit()
      #If the number of incorrect guesses = 8, then the player has exhausted all of their wrong guesses and lost the game.
      if incorrect == 8:
            print("Sorry, you have inputted too many wrong answers. Game over!")
            sys.exit()
      print("Letters currently played: " + str(guess_list))
      count += 1






