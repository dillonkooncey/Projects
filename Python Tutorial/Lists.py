#Creating a basic list
friends = ["Kevin", "Karen", "Jim", "Oscar", "Dillon"]

#Accessing elements in list
print(friends)
#Prints first index of friends list
print(friends[0])
#Print last element in list
print(friends[-1])
#Print multiple elements in the list
print(friends[1:4])
#Update a value in the array
friends[1] = "Mike"
print(friends[1])

#Numbers list. Tuples are inmutable.
coordinates = (4, 5)
print(coordinates[0])

#Difference between tuples and lists: Can't modify the tuple. Only really use tuples for data that isnt going to change.
coordinates = [(4, 5), (6, 7)]
print(coordinates)
