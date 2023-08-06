class BankAccount:
    def __init__(self, input_holder_name, input_balance, input_type):
        self.holder_name = input_holder_name
        self.balance = input_balance
        self.type = input_type

        # self._rates = {
        #     "business": 50,
        #     "personal": 10
        # }

    def pay_in(self, amount):
        self.balance += amount

    def pay_monthly_fee(self):
        if self.type == "business":
            self.balance -= 50
        elif self.type == "personal":
            self.balance -= 10

        # ALTERNATIVE SOLUTION
        
        # self.balance -= self._rates[self.type]
