stops = [ "Croy", "Cumbernauld", "Falkirk High", "Linlithgow", "Livingston", "Haymarket" ]

# 1. Add `"Edinburgh Waverley"` to the end of the list
stops.append("Edinburgh Waverley")

# 2. Add `"Glasgow Queen St"` to the start of the list
stops.insert(0, "Glasgow Queen St")

# 3. Add `"Polmont"` at the appropriate point (between `"Falkirk High"` and `"Linlithgow"`)
stops.insert(4, "Polmont")

# 4. Print out the index position of `"Linlithgow"`
stops.index("Linlithgow")

# 5. Remove `"Livingston"` from the list using its name
stops.remove("Livingston")

# 6. Delete `"Cumbernauld"` from the list by index
stops.pop(stops.index("Cumbernauld")) #
# Alternatively use the del operator
# del stops[stops.index("Cumbernauld")]

# 7. Print the number of stops in the list
len(stops)

# 8. Sort the list alphabetically
stops.sort()

# 9. Reverse the positions of the stops in the list
stops.reverse()

# 10. Print out all the stops using a for loop
for stop in stops:
  print(stop)
