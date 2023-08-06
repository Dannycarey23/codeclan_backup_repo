# Single Class - minilab (45 mins)

Create a new directory 'planets'

Convert the following Python class into Java and get it to print out the same information. (Hint: You will need a Runner class with a main method).

```
class Planet:

  def __init__(self, name, size):
    self.name = name
    self.size = size
  
  def get_name(self):
    return self.name
  

  def get_size(self):
    return self.size
 
  def explode(self):
    return f"Boom! {self.name} has exploded."
 

def __main__():
  mars = Planet("Mars", 908973)
  print(f"{mars.get_name()} is {mars.get_size()}")
  print(mars.explode())
  
__main__()

```
