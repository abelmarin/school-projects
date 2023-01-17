pragma solidity >=0.4.22 <0.6.0;

contract SimplePonzi {
    address payable[] public foolishInvestors;
    
    function invest () public payable {
        require(msg.value >= .01 ether);
        
        // checks to see whether the user has already invested
        bool alreadyInvestor = false;
        for (uint i = 0; i<foolishInvestors.length; i++) {
            if (foolishInvestors[i] == msg.sender)
                alreadyInvestor = true;
        }
        
        require(!alreadyInvestor);
        foolishInvestors.push(msg.sender);
        payOut();
    }
    
    function payOut () private {
        uint256 amountInContract = (address(this).balance)/10;
        uint256 payOutAmount = amountInContract/foolishInvestors.length;
        
        // Transfers a small part of the contract amount to each investor.
        for (uint i=0; i<foolishInvestors.length; i++) {
            foolishInvestors[i].transfer(payOutAmount);
        }
    }
}