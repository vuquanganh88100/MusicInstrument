const form = document.querySelector("#registration-form");
const errorMessage = document.querySelector("#error-message");

form.addEventListener("submit", function(event) {
    const password = form.elements.password.value;
    const confirmPassword = form.elements.confirmPassword.value;
    if (password !== confirmPassword) {
        errorMessage.textContent = "Passwords do not match";
        event.preventDefault();
    }
});
const registerButton = document.getElementById("register-button");
const registrationForm = document.getElementById("registration-form");
const container=document.getElementById("container")
const homeButton=document.getElementById("home-button")
registerButton.addEventListener("click", function() {
    registrationForm.style.display = "block";
    loginForm.style.display = "none";
    container.style.display="none";

});
const loginButton = document.getElementById("login-button");
const loginForm = document.getElementById("login-form");

loginButton.addEventListener("click", function() {
    loginForm.style.display = "block";
    registrationForm.style.display = "none";
    container.style.display="none";

});
document.getElementById("home-button").addEventListener("click", function(){
    location.reload();
});
$(document).ready(function() {
    $("#solo-albums").click(function() {
        window.location.href = "solo-albums.html"; // Navigate to solo albums page
    });
    $("#duet-albums").click(function() {
        window.location.href = "duet-albums.html"; // Navigate to duet albums page
    });
});
