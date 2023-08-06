"""
Exercise 1:
Write a program that takes a list of numbers and prints the sum of all the numbers in the list.
"""

numbers = [2, 4, 5, 10]
sum = 0

for number in numbers:
    sum += number

print(sum)

"""
Exercise 2:
Write a program that takes a list of strings and prints the length of each string in the list.
"""
str_list = ["Apple", "Google", "Meta", "Microsoft"]

for str in str_list:
    print("Length of", str, "is", len(str))


"""
Exercise 3:
Write a program that prompts the user to enter 5 names and stores them in a list. Then, print the list in alphabetical order.
HINT: Use a range(5) with a for loop to loop 5 times
HINT: To get user input and store it in a variable: name = input("Enter a name: ") 
"""

names = []
for i in range(5):
    name = input("Enter a name: ")
    names.append(name)

names.sort()

print("Names in alphabetical order:", names)


"""
Exercise 4:
Write a program that takes a list of numbers and prints the largest and smallest numbers in the list.
HINT: min and max are built-in Python functions
"""

numbers = [5, 2, 9, 1, 7]

smallest = min(numbers)
largest = max(numbers)

print("Smallest number:", smallest)
print("Largest number:", largest)

"""
Exercise 5:
Write a program that takes a list of integers and prints the average of the numbers in the list.
"""

numbers = [5, 2, 9, 1, 7]

sum = 0
for num in numbers:
    sum += num

average = sum / len(numbers)

print("Average:", average)

"""
Exercise 6:
Write a program that takes a list of integers and removes all the duplicates, printing the updated list.
HINT: Python's in-built set function will remove duplicates from a list
"""

numbers = [1, 2, 3, 2, 4, 5, 1, 3]

unique_numbers = list(set(numbers))

print("Updated list:", unique_numbers)

"""
Exercise 7:
Write a program that prompts the user to enter a sentence and prints the sentence in reverse order.
"""

sentence = input("Enter a sentence: ")

words = sentence.split()
words.reverse()
reversed_sentence = " ".join(words)

print("Reversed sentence:", reversed_sentence)

"""
BONUS CHALLENGE!
Write a program that prompts the user to enter a sentence and counts the frequency of each word in the sentence using a dictionary.
HINT: Python's split() method will turn a set into a List
"""

sentence = input("Enter a sentence: ")

word_frequency = {}
words = sentence.split()

for word in words:
    if word in word_frequency:
        word_frequency[word] += 1
    else:
        word_frequency[word] = 1

print("Word frequency:", word_frequency)
