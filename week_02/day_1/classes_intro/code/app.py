from modules.bank_account import *

account = BankAccount('John', 500, 'business')
print(account.holder_name)

account.pay_monthly_fee()
print(account.balance)

account_1 = BankAccount('Ada', 100, 'personal')
account_1.pay_monthly_fee()
print(account_1.balance)
