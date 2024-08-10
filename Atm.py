import tkinter as tk
from tkinter import messagebox

class ATM:
    def __init__(self, root):
        self.balance = 0
        self.root = root
        self.root.title("ATM Simulation")

        # Create and place widgets
        self.label = tk.Label(root, text="ATM Simulation", font=("Helvetica", 16))
        self.label.pack(pady=10)

        self.balance_label = tk.Label(root, text="Balance: ₹0.00", font=("Helvetica", 14))
        self.balance_label.pack(pady=5)

        self.amount_entry = tk.Entry(root, width=20)
        self.amount_entry.pack(pady=5)

        self.deposit_button = tk.Button(root, text="Deposit", command=self.deposit)
        self.deposit_button.pack(pady=5)

        self.withdraw_button = tk.Button(root, text="Withdraw", command=self.withdraw)
        self.withdraw_button.pack(pady=5)

        self.check_balance_button = tk.Button(root, text="Check Balance", command=self.check_balance)
        self.check_balance_button.pack(pady=5)

        self.exit_button = tk.Button(root, text="Exit", command=root.quit)
        self.exit_button.pack(pady=5)

    def update_balance_label(self):
        self.balance_label.config(text=f"Balance: ₹{self.balance:.2f}")

    def deposit(self):
        amount = self.get_amount()
        if amount is not None:
            if amount > 0:
                self.balance += amount
                self.update_balance_label()
                messagebox.showinfo("Success", f"₹{amount:.2f} deposited successfully.")
            else:
                messagebox.showwarning("Invalid Input", "Deposit amount must be positive.")
        self.amount_entry.delete(0, tk.END)

    def withdraw(self):
        amount = self.get_amount()
        if amount is not None:
            if amount > self.balance:
                messagebox.showwarning("Insufficient Funds", "Insufficient balance.")
            elif amount <= 0:
                messagebox.showwarning("Invalid Input", "Withdraw amount must be positive.")
            else:
                self.balance -= amount
                self.update_balance_label()
                messagebox.showinfo("Success", f"₹{amount:.2f} withdrawn successfully.")
                
        self.amount_entry.delete(0, tk.END)

    def check_balance(self):
        messagebox.showinfo("Balance", f"Your current balance is ₹{self.balance:.2f}")

    def get_amount(self):
        try:
            amount = float(self.amount_entry.get())
            return amount
        except ValueError:
            messagebox.showwarning("Invalid Input", "Please enter a valid amount.")
            return None

if __name__ == "__main__":
    root = tk.Tk()
    atm = ATM(root)
    root.mainloop()
