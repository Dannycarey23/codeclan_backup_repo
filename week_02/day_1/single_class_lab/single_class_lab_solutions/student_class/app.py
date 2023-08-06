from modules.student import *

student1 = Student("Ada", "E42")  # creates a new Student object

print(f"{student1.name} is in {student1.cohort}")  # Ada is in E42

print(student1.talk())  # I can talk!
print(student1.say_favourite_language("Python"))  # I love Python
