def compare(number_1, number_2):
    if number_1 == number_2:
        return "numbers are the same"
    elif number_1 < number_2:
        return f"{number_1} is less than {number_2}"
    else:
        return f"{number_1} is greater than {number_2}"