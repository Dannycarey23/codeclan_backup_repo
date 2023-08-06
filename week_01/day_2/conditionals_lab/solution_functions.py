print("Let's see if we can get this sorted")
fixed = False
print("Turn Your Computer On")

def plugged_in():
    plugged_in = input("Is it plugged in(y/n)? ")
    return plugged_in == "y"

def plug_it_in():
    print("Plug it in")
    working = input("Did this fix the problem(y/n)? ")
    return working == "y"

status = input("Did it boot up (y/n)? ")
if status == "y":
    fixed = True
elif not plugged_in():
        if plug_it_in():
            fixed = True

if fixed == True:
    print("Login with password")
else:
    print("Your computer is broken")

print("Done")
