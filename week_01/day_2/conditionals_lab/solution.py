fixed = False
print("Let's see if we can get this sorted")
print("Turn Your Computer On")

status = input("Did it boot up (y/n)? ")
if status == "y":
    fixed = True
else:
    plugged_in = input("Is it plugged in(y/n)? ")
    if plugged_in == "n":
        print("Plug it in")
        working = input("Did this fix the problem(y/n)? ")
        if working == "y":
            fixed = True

if fixed == True:
    print("Login with password")
else:
    print("Your computer is broken")

print("Done")

# Pseudocode

# SET fixed = False
# PRINT "Let's see if we can get this sorted"
# PRINT "Turn Your Computer On"
# SET status = INPUT "Did it boot up (y/n)? "
# IF status is "y"
#   THEN SET fixed = True
# ELSE
#   SET plugged_in = INPUT "Is it plugged in(y/n)? "
#   IF plugged_in is "n"
#       PRINT "Plug it in"
#       SET working = INPUT "Did this fix the problem(y/n)? "
#       IF working is "y"
#           THEN SET fixed = True
# IF fixed is True
#   PRINT "Login with password"
# ELSE
#   PRINT "Your computer is broken"
# PRINT "Done"
# END