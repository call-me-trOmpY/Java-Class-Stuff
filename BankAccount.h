//contents of BankAccount.h

#ifndef BANKACCOUNT_H
#define BANKACCOUNT_H

#include <iostream>

using namespace std;

//structure to be returned by
//monthlyProc() function
struct ServAndOwed{
    double servCharges;
    double totalOwed;
};

class BankAccount{
//member variables are declared protected
protected:
    double balance;
    int numDeposits;
    int numWithdrawal;
    double annualIntRate;
    double mnCharges;

    //added member to store service charges
    //of a month
    double serviceCharges;

public:
    //constructor that accepts values
    //for balance and annual interest rate
    BankAccount(double b, double air){
        //check for invalid input
        if(b < 0){
            cout << "Error! Balance cannot start with";
            cout << " a negative amount!\n";
            cout << "Now terminating!\n";
            exit(EXIT_FAILURE);
        }

        if(air < 0){
            cout << "Error! Annual interest rate";
            cout << " cannot be negative!\n";
            cout << "Now terminating!\n";
            exit(EXIT_FAILURE);
        }

        //set balance and annual interest rate
        //to argument values
        balance = b;
        annualIntRate = air;

        //set some initial values to other
        //member variables
        numDeposits = 0;
        numWithdrawal = 0;
        mnCharges = 0.0;

        //set service charges member
        serviceCharges = 0.0;
    }

    //accessor functions
    double getBalance() const{
        return balance;
    }

    int getNumDeposits() const{
        return numDeposits;
    }

    int getNumWithdrawals() const{
        return numWithdrawal;
    }

    double getAnnualIntRate() const{
        return annualIntRate;
    }

    double getMonthlyCharges() const{
        return mnCharges;
    }

    //mutator functions
    void setAnnualIntRate(double air){
        //validate input using while loop
        while(air < 0){
            cout << "Negative values for annual interest ";
            cout << "rates not accepted! Enter again: ";
            cin >> air;
        }

        //store value in member variable
        annualIntRate = air;
    }

    void setMonthlyCharges(double mc){
        //validate input using while loop
        while(mc < 0){
            cout << "Negative values for monthly charges ";
            cout << "are not accepted! Enter again: ";
            cin >> mc;
        }

        //store value in member variable
        mnCharges = mc;
    }

 
    //deposit() function
    virtual void deposit(double d){
        //add the argument to the balance
        balance += d;

        //increment number of deposits
        numDeposits++;
    }

    //withdraw() function
    virtual void withdraw(double w){
        //subtract the argument from balance
        balance -= w;

        //increment number of withdrawals
        numWithdrawal++;
    }

    //calcInt() function
    //to add the accumulated interest
    //to the balance
    virtual void calcInt(){
        //add to current balance the monthly interest
        balance += (annualIntRate/12.0)*balance;
    }

    //monthlyProc() function
    virtual ServAndOwed monthlyProc(){
        //subtract monthly charges from balance
        balance -= mnCharges;

        //add monthly interest to balance
        calcInt();

        //reset number of deposits and withdrawals
        numDeposits = 0;
        numWithdrawal = 0;

        //also reset monthly charges to 0
        mnCharges = 0.0;

        //also reset service charges
        serviceCharges = 0.0;

        //a return statement
        //could return any struct ServAndOwed
        ServAndOwed temp;
        return temp;
    }

};

#endif