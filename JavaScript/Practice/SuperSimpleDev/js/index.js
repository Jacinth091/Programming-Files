// Bro Code | JavaScript Full Course

// Basics Of Javascript

// console.log("Hello, World!");
// console.log("I like Pizza!");

// window.alert(`This is an Alert Window!`);
// window.confirm(`Do you like pizza?`);

// Single Line Comment

/* Multiple 
    line 
    Comments 
*/

// document.getElementById('myH1').textContent = "Hello, World!";
// document.getElementById('myP').textContent = "I like Pizza!";

// Variables

// let x; // Declaration
// x = 324;    // Assignment

    // Data Type = NUMBERS

    // let age = 25;
    // let price = 10.99;
    // let gpa = 2.1;

    // console.log(typeof age, typeof price, typeof gpa);
    
    // console.log(`You are ${age} years old`);
    // console.log(`The price is $${price}`);
    // console.log(`Your GPA is: ${gpa}`);


    // Data Type = STRINGS

        // let firstName = "Jacinth";
        // let favFood = "Mango-Float"
        // let email= "jacinthcedricbarral123@gmail.com"

        // console.log(typeof firstName);
        // console.log(`Your name is ${firstName}`);
        // console.log(`You like ${favFood}`);
        // console.log(`Your Email is ${email}`);


    // Data Type = BOOLEANS 

        // let online = false;
        // let forSale = true;
        // let isStudent = true;


        // console.log(typeof online);
        // console.log(`User is Online: ${online}`);
        // console.log(`Is this car for sale? ${forSale}`);
        // console.log(`Enrolled:  ${isStudent}`);


    // let fullName = "Jacinth Cedric Barral";
    // let age = 20;
    // let isStudent = true;

    // document.getElementById('p1').textContent = `My name is: ${fullName}`;
    // document.getElementById('p2').textContent = `My Age is: ${age} years old`;
    // document.getElementById('p3').textContent = `Enrolled: ${isStudent}`;




    // Getting User Input
// function pressButton() {
//     let username;
    
//     // username = prompt("What is your name? ");

//     // // alert("Hiii");
    
//     // alert("LOL");
//     username = document.getElementById('userInput').value;


//     if (!username || username.length === 1){
//         alert("Invalid Value");
//         return false;

//     }
//     else {
//         alert("Hi, " + username + "!");
//     }

// }



// Type Conversion


// Number() = when converting a value into a number data type
// String() = when converting a value into a string data type
// Boolean() = when converting a value into a boolean data type

// Constants or Const variable
// function pressButton() {
//     const PI = 3.14159;
//     let radius;
//     let circumference;
    
    

//     radius = document.getElementById('userInput').value;
//     radius = Number(radius);
    
//     circumference = 2 * PI * radius;
    
//     document.getElementById('result').textContent = `The circumference of a circle is: ${circumference.toFixed(2)} cm`;

// }


const decreaseBtn = document.getElementById('decreaseBtn');
const resetBtn = document.getElementById('resetBtn');
const increaseBtn = document.getElementById('increaseBtn');
const countLabel = document.getElementById("countLabel");

let count = 0;

increaseBtn.onclick = function () {
    count++;
    countLabel.textContent = count;
}
decreaseBtn.onclick = function () {
    count--;
    countLabel.textContent = count;

}
resetBtn.onclick = function() {
    count = 0;
    countLabel.textContent = count;

}




        




    







































