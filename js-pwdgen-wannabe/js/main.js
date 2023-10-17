const firstName = prompt("What's your name?")
const lastName = prompt("What's your last name?")
const favoriteColor = prompt("What's your favorite color?")
const numOne = +prompt("Pick a number?")
const numTwo = +prompt("Pick ANOTHER number")

const dividedNum = Math.round(numOne / numTwo)
const generatedPass = firstName + lastName + favoriteColor + dividedNum

console.log(generatedPass)
