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
        if(username === ""){ //hvis brugernavn er forkert send fejlkode
            alert("Indtast venligst et CPR-nummer")
            return false
        }
        if(password === ""){ //hvis koden er forkert send fejlkode
            alert("Indtast venligst et kodeord")
            return false
         }
        if( username === "123456-7890" && password === "Test123"){
            window.location = "StartSide.html"; //gå til startsiden hvis username og kode er rigtigt
            return false;
        }
        else{ //hvis koden og/eller brugernavnet er forkert send fejlkode
            alert("Login fejlede - indtast venligst et gyldigt CPR-nummer og kodeord")
        }
    }