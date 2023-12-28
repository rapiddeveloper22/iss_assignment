function validateForm() {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    document.getElementById('firstNameError').innerHTML = '';
    document.getElementById('lastNameError').innerHTML = '';
    document.getElementById('emailError').innerHTML = '';
    document.getElementById('passwordError').innerHTML = '';
    document.getElementById('confirmPasswordError').innerHTML = '';

    var isValid = true;

    if (firstName.trim() === '') {
        alert('Please enter your first name.');
        isValid = false;
    }

    if (lastName.trim() === '') {
        alert('Please enter your last name.');
        isValid = false;
    }

    if (!isValidEmail(email)) {
        alert('Please enter a valid email address.');
        isValid = false;
    }

    if (password.length < 8) {
        alert('Password must be at least 8 characters.');
        isValid = false;
    }

    if (password !== confirmPassword) {
        alert('Passwords do not match.');
        isValid = false;
    }

    return isValid;
}

function isValidEmail(email) {
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}
