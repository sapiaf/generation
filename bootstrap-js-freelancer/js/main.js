// Quando l’utente fa click sul bottone “send” del form, il sito deve calcolare l’ammontare del preventivo per le ore di lavoro richieste.
// Il prezzo orario per una commissione varia in questo modo:
// - se la commissione riguarda lo sviluppo backend il prezzo orario è di 20.5€ l’ora
// - se la commissione riguarda lo sviluppo frontend il prezzo orario è di 15.3€ l’ora
// - se la commissione riguarda l’analisi progettuale di un progetto il prezzo orario è di 33.6€
// L’utente potrebbe decidere di utilizzare un codice promozionale tra i seguenti:
// - YHDNU32
// - JANJC63
// - PWKCN25
// - SJDPO96
// - POCIE24
// Se l’utente inserisce un codice promozionale valido, ha diritto ad uno sconto del 25% sul prezzo finale. 
// Se il codice inserito non è valido, il sito deve informare l’utente che il codice non è valido e il prezzo finale viene calcolato senza applicare sconti.
// Il risultato del calcolo del prezzo finale deve essere visualizzato in “forma umana” (con 2 decimali e il simbolo dell’euro) in un apposito tag HTML 
// appena sotto il bottone send.
// Alcuni consigli
// - Ricordatevi che se non state bene attenti, Javascript vi fa le magie con i tipi :faccia_leggermente_sorridente:
// - Ricordatevi che il form ha un comportamento “strano” quando fate click sul bottone Send che è di tipo submit (type=submit).
// Bonus:
// Quando l’utente clicca sul pulsante “Send”, se il codice promozionale inserito non è valido, facciamo diventare quest’ultimo di colore rosso.
// Se il codice inserito è valido, dopo aver calcolato il prezzo scontato, eliminare quel codice dall’elenco dei codici sconto disponibili, 
// in modo che non sia più utilizzabile.


const formMessage = document.getElementById('form-message')
const formElement = document.getElementById("form");
const typeOfWork = document.getElementById('inputState')
const inputHours = document.getElementById('inputHours')
const inputDiscount = document.getElementById('inputDiscount')
const discountCodes = ['YHDNU32', 'JANJC63', 'PWKCN25', 'SJDPO96', 'POCIE24']


formElement.addEventListener('submit', event => {
    event.preventDefault()
    let price = 0;

    if (typeOfWork.value == 'Backend Development') {
        price = inputHours.value * 20.5
    } else if (typeOfWork.value == 'Frontend Development') {
        price = inputHours.value * 15.3
    } else if (typeOfWork.value == 'Project Analysis') {
        price = inputHours.value * 33.6
    }

    if (discountCodes.includes(inputDiscount.value)) {
        const index = discountCodes.indexOf(inputDiscount.value)
        discountCodes.splice(index, 1)
        price = price * 0.75
        inputDiscount.classList.remove('is-invalid', 'text-danger');
    } else if (inputDiscount.value) {
        inputDiscount.classList.add('is-invalid', 'text-danger');
    }

    inputHours.value !== '' ? formMessage.textContent = `Il prezzo finale è ${price.toFixed(2)}` : formMessage.textContent = ''


}) 
