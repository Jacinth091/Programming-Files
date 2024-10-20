// let win = document.getElementById('win').innerHTML;
// let loss = document.getElementById('loss').innerHTML;
// let tie = document.getElementById('tie');


    const plyScore = {
        win: 0,
        lose: 0,
        tie: 0
    }

    function updateProperty(plyScore){
        document.getElementById('win').innerHTML = plyScore.win;
        document.getElementById('lose').innerHTML = plyScore.lose;
        document.getElementById('tie').innerHTML = plyScore.tie;
    }


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
        console.log(plyScore);
        updateProperty(plyScore)

    }

    function determineScore(result){
        const win = result.search("Win");
        const lose = result.search("Lose");
        const tie = result.search("Tie");

        if(win){
            plyScore.win++
        }
        else if(lose){
            plyScore.lose++
        }
        else if(tie){
            plyScore.tie++
        }




    }


    function gameLogic(plM, cpM){
        let result = '';
        let msg =  '';   

        if(plM === 'Rock'){
            if(cpM === "Scissors"){
                result = "You Win!";
            }
            else if(cpM==="Rock"){
                result = "It's a Tie!";
            }
            else if(cpM === "Paper"){
                result = "You Lose!";
            }

        }
        else if(plM === 'Paper'){
            if(cpM === "Scissors"){
                result = "You Lose!";

            }
            else if(cpM==="Rock"){
                result = "You Win!";

            }
            else if(cpM === "Paper"){
                result = "It's a Tie!";

            }
        }
        else if(plM === 'Scissors'){
            if(cpM === "Scissors"){
                result = "It's a Tie!";
            }
            else if(cpM==="Rock"){
                result = "You Lose!";
            }
            else if(cpM === "Paper"){
                result = "You Win!";
            }
        }

        determineScore(result)

        return `${result} \nYou picked ${plM}, computer picked ${cpM}.`
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