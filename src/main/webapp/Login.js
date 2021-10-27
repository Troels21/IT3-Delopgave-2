/* kode til at skjule og vise kodeordet */
const visibilityListen = document.getElementById('visibilityListen')
visibilityListen.addEventListener('click', togglevisibiliy) //brug functionen hvis man trykker på iconet

    function togglevisibiliy() {
        const passwordInput = document.getElementById("kode")
        const icon = document.getElementById("icon")
        if (passwordInput.type === "password") { //vis koden
            passwordInput.type = "text"
            icon.innerText = "visibility_off"
        } else { //vis ikke koden
            passwordInput.type = "password"
            icon.innerText = "visibility"
        }
    }

/* kode til at validere koden */
    function validate(){
        const username = document.getElementById("cpr").value;
        const password = document.getElementById("kode").value;
        if(username === ""){
            alert("Indtast venligst et CPR-nummer")
            return false
        }
        if(password === ""){
            alert("Indtast venligst et kodeord")
            return false
         }
        if( username === "123456-7890" && password === "Test123"){
            window.location = "StartSide.html";
            return false;
        }
        else{
            alert("Login fejlede - indtast venligst et gyldigt CPR-nummer og kodeord")
        }
    }