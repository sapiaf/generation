// BONUS 1:
// Continuare il superenalotto se non l'avete finito in classe questa mattina. 
// Potete pensare anche alla grafica del vostro sito e fare le palline con dentro i numeri estratti a caso e informare l'utente con l'HTML quante palline ha beccato, 
// magari evidenziando di un colore diverso le palline beccate!


// const computerContainer = document.querySelector('.container__computer')
// const userContainer = document.querySelector('.container__user')
// const userNums = document.querySelectorAll('.container__user .nums');
// const nums = document.querySelector('.nums')
// let contatore = 0;

// // CHIEDERE AL GIOCATORE QUANTI NUMERI GIOCARE
// let numeriDaGiocare = +prompt('Scegli quanti numeri giocare da 1 a 12')
// while (numeriDaGiocare < 1 || numeriDaGiocare > 12) {
//     numeriDaGiocare = +prompt('Scegli quanti numeri giocare da 1 a 12')
// }

// // CREAZIONE ARRAY NUMERI GIOCATORE
// function numeriUtente(num) {
//   const userArr = [];
//   for (let i = 0; i < num; i++) {
//     let userChoice = +prompt('Scegli un numero da 1 a 90');

//     while (userChoice < 1 || userChoice > 90 || userArr.includes(userChoice)) {
//         if (userArr.includes(userChoice)) {
//           alert('Il numero è già stato scelto. Scegli un numero diverso.');
//         } else {
//           alert('Il numero deve essere compreso tra 1 e 90. Riprova:');
//         }
//         userChoice = +prompt('Scegli un numero da 1 a 90');
//     }

//     userContainer.innerHTML += `<div class='nums'><p>${userChoice}</p></div>`
//     userArr.push(userChoice);

//   }
//   return userArr;
// }

// // GENERAZIONE NUMERI CASUALI
// function generaNumeriCasuali(numeroElementi, min, max) {
//   let arrayNumeri = [];

//   while (arrayNumeri.length < numeroElementi) {
    
//         let numeroCasuale = Math.floor(Math.random() * (max - min + 1)) + min;

//         if (!arrayNumeri.includes(numeroCasuale)) {
//             computerContainer.innerHTML += `<div class='nums computer'><p>${numeroCasuale}</p></div>`
//             arrayNumeri.push(numeroCasuale);
//         }
//     }
//     return arrayNumeri;

// }

// // CONTROLLARE QUANTI NUMERI HA INDOVINATO IL GIOCATORE
// function controllaNumeri(arr1, arr2) {
//   for (let i = 0; i < arr2.length; i++) {
//     if (arr1.includes(arr2[i])) {
//       contatore++;
//       userNums[i].classList.add('found');
//     }
//   }
// }

// const userArray = numeriUtente(numeriDaGiocare);
// const randomArray = generaNumeriCasuali(6, 1, 90);


// controllaNumeri(userArray, randomArray);

// console.log(`Il numero è uscito ${contatore} volte.
// I tuoi numeri sono: ${userArray} mentre i numeri del computer sono: ${randomArray}`);


// BONUS 2:
// Chiedi un numero di 4 cifre all’utente. Usa la funzione sommaNumeri per calcolare la somma di tutte le cifre che compongono il numero e ritorni il risultato. 
// Usa questa funzione per stampare poi a video il risultato ottenuto. Ad es: 1286 la somma di tutti le sue cifre sarà 17!

/* let numeroUtente = prompt('Scegli un numero di 4 cifre...');

while (numeroUtente < 1000 || numeroUtente > 9999) {
    numeroUtente = prompt('Scegli un numero di 4 cifre...');
}

function creaArrayUtente(numero) {
    const arrayUtente = [];
    for (let i = 0; i < numero.length; i++) {
      const cifra = numero[i];
      arrayUtente.push(cifra);
    }
    return arrayUtente;
}
  
function sommaNumeri(arr) {
    let somma = 0;
    for (let i = 0; i < arr.length; i++) {
        const numero = parseInt(arr[i]);
        somma += numero;
}
    return somma;
}   

const arrayUtente = creaArrayUtente(numeroUtente);
const somma = sommaNumeri(arrayUtente);

console.log(`Il numero scelto è ${numeroUtente}, la somma di tutte le sue cifre sarà ${somma}!`); */
  

// BONUS 3:
// Creare una funzione che dato un array di stringhe o di numeri mi restituisca il numero di volte che un elemento è presente dentro quell'array. 
// Ad esempio se ho un array con dei numeri mi dica quante volte il numero 2 compare dentro l'array.

/* function quanteVolte(element, arr) {
    let contatore = 0
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === element) {
            contatore++
        }
    }
    return contatore
}
console.log(quanteVolte(2, [1, 2, 3, 4, 2, 2, 1])) */

// BONUS 4:
// Chiedere all’utente di inserire una parola. Creare una funzione per capire se la parola inserita è palindroma. 
// Per palindroma di intende una parola che letta da sinistra a destra e da destra a sinistra si legge uguale. 
// Trovate in internet un sacco di parole palindrome, un esempio è ANNA.
// Fate un programma in cui chiedete la parola all'utente e gli comunicate dunque se la parola è palindroma o meno usando la funzione appena creata!

/* const userChoice = prompt('Inserisci una parola...').toLowerCase()
const userChoiceReversed = reverseWord(userChoice)

function reverseWord(word) {
    let reversedWord = ''
    for (let i = word.length - 1; i >= 0; i--) {
        const char = word[i]
        reversedWord += char
    }
    console.log(reversedWord)
    return reversedWord
}


function isPalindrome(word1, word2) {
    return word1 == word2
}


const palindromo = isPalindrome(userChoice, userChoiceReversed)

if (palindromo) {
    console.log('La parola scelta è un palindromo')
} else {
    console.log('La parola scelta non è un palindromo')
}
 */
