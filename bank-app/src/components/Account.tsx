import React, {ChangeEvent, useState} from "react";

export const Account = () => {
    const [name, setName] = useState("Bill");
    const [balance, setBalance] = useState(0.00);
    const [inputAmt, setInputAmt] = useState(0.00);

    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        setInputAmt(Number.parseFloat(event.target.value));
    }

    const handleDeposit = () => {
        if (inputAmt > 0) {
            setBalance(balance + inputAmt);
            setInputAmt(0.00);
        }
    }

    const handleWithdrawal = () => {
        if (inputAmt > 0)
            setBalance(balance - inputAmt);
    }

    return (
        <div>
            <h1>ACCOUNT PAGE</h1>
            <div>
                <h4>Hello, {name}</h4>
                <span>Account Balance: ${balance.toFixed(2)}</span>
                <div>
                    <input onChange={(event) => {
                        handleInputChange(event);
                    }}/>
                    <div>
                        <button
                            onClick={handleDeposit}
                        >Deposit
                        </button>
                        <button
                            onClick={handleWithdrawal}
                        >Withdrawal
                        </button>
                    </div>
                </div>
            </div>
        </div>
    )
}