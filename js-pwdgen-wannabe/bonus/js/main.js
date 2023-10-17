const generatePassButton = document.querySelector('#password-button');
const slider = document.getElementById('customRange1');
const lowerCaseRadio = document.getElementById('flexRadioDefault1');
const upperCaseRadio = document.getElementById('flexRadioDefault2');
const passwordInput = document.getElementById('passwordInput');
const chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_-+=";

let passwordLength = +slider.value;
slider.addEventListener('input', () => {
    passwordLength = +slider.value;
    sliderNumber.textContent = `Length: ${passwordLength}`;
});

generatePassButton.addEventListener('click', generatePassword);

function generatePassword() {
    passwordInput.value = '';
    const firstName = document.getElementById('first-name').value;
    const lastName = document.getElementById('last-name').value;
    const favoriteColor = document.getElementById('favorite-color').value;
    const birthYear = document.getElementById('birth-year').value;
    const generatedNum = birthYear.split('-').map(num => +num).reduce((acc, num) => acc += num, 0);

    // Password uppercase or lowercase
    let generatedText = firstName + lastName + favoriteColor;
    upperCaseRadio.checked ? generatedText = generatedText.toUpperCase() : generatedText = generatedText.toLowerCase();

    // Create password
    let generatedPassword = generatedText + generatedNum;

    // Check password length
    if (generatedPassword.length > passwordLength) {
        generatedPassword = generatedPassword.slice(0, passwordLength);
    }

    // Generate random password
    if (generatedPassword === '0') {
        for (let i = 0; i < passwordLength; i++) {
            let randomNum = Math.floor(Math.random() * chars.length);
            passwordInput.value += chars[randomNum];
        }
    } else {
        passwordInput.value = generatedPassword;
    }
}

// Copy password
const copyButton = document.getElementById('button-addon2');
copyButton.addEventListener('click', function() {
    passwordInput.select();
    passwordInput.setSelectionRange(0, 99999); // For mobile devices
    document.execCommand('copy');
    alert("Copied the text: " + passwordInput.value);
});

 
