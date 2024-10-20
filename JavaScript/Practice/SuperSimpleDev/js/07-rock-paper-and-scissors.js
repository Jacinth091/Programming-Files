
/*     function playGame(playerMove) {
        const computerMove = pickComputerMove();

        let result = '';

        if (playerMove === 'Scissors') {
            if (computerMove === 'Rock') {
            result = 'You lose :<';

            }
            else if (computerMove === 'Paper') {
                result = 'You win!';
            }
            else if (computerMove === 'Scissors') {
                result = 'It\'s a tie';

            }
        }

        else if (playerMove === 'Paper') {
            
            let result = '';
            if (computerMove === 'Rock') {
                result = 'You win!';

            }
            else if (computerMove === 'Paper') {
                result = 'It\'s a tie';
            }
            else if (computerMove === 'Scissors') {
                result = 'You lose :<';
            }
        }

        else if (playerMove === 'Rock') {
            let result = '';
            if (computerMove === 'Rock') {
                result = 'It\'s a tie';

            }
            else if (computerMove === 'Paper') {
                result = 'You lose :<';
            }
            else if (computerMove === 'Scissors') {
                result = 'You win!';
            }

        }
        alert(`You picked ${playerMove}. Computer picked ${computerMove}. ${result}.`);
    }
 */
    
    function playGame(playerMove){
        const compMove = pickComputerMove();
        // const compMove = 'Scissors';

        switch(playerMove){
            case "Rock":

                // alert(`You picked ${playerMove}, Computer picked ${compMove}`)
                // console.log(`You picked ${playerMove}, computer picked ${compMove}.`)

                alert(gameLogic(playerMove, compMove))


            break;
            case "Paper":
                // alert(`You picked ${playerMove}, Computer picked ${compMove}`)
                alert(gameLogic(playerMove, compMove))


            break;
            case "Scissors":
                // alert(`You picked ${playerMove}, Computer picked ${compMove}`)
                alert(gameLogic(playerMove, compMove))

            break;
            
        }

    }

    function gameLogic(plM, cpM){
        let result = '';    

        if(plM === 'Rock'){
            if(cpM === "Scissors"){
                result = `You Win! \nYou picked ${plM}, computer picked ${cpM}.`;
            }
            else if(cpM==="Rock"){
                result = `It's a Tie! \nYou picked ${plM}, computer picked ${cpM}.`;
            }
            else if(cpM === "Paper"){
                result = `You Lose! \nYou picked ${plM}, computer picked ${cpM}.`;

            }

        }
        else if(plM === 'Paper'){
            if(cpM === "Scissors"){
                result = `You Lose! \nYou picked ${plM}, computer picked ${cpM}.`;
            }
            else if(cpM==="Rock"){
                result = `You Win! \nYou picked ${plM}, computer picked ${cpM}.`;
            }
            else if(cpM === "Paper"){
                result = `It's a Tie! \nYou picked ${plM}, computer picked ${cpM}.`;

            }
        }
        else if(plM === 'Scissors'){
            if(cpM === "Scissors"){
                result = `It's a Tie! \nYou picked ${plM}, computer picked ${cpM}.`;
            }
            else if(cpM==="Rock"){
                result = `You Lose! \nYou picked ${plM}, computer picked ${cpM}.`;
            }
            else if(cpM === "Paper"){
                result = `You Win! \nYou picked ${plM}, computer picked ${cpM}.`;

            }
        }
        // else{
        //     console.log(`You picked ${plM}, computer picked ${cpM}.`)
        // }

        return result
    }


    function pickComputerMove(){
    const randomNumber = Math.random();

    let computerMove = '';

    if (randomNumber >= 0 && randomNumber < 1/3) {
        computerMove = 'Rock';
    }
    else if (randomNumber >= 1/3 && randomNumber < 2/3) {
        computerMove = 'Paper';

    }
    else if (randomNumber >= 2/3 && randomNumber < 1) {
        computerMove = 'Scissors';
    }

    return computerMove;

    }