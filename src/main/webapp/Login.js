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
    function fetchrs(){
        const user = document.getElementById("cpr").value;
        const pass = document.getElementById("kode").value;

        fetch("http://localhost:8080/IT3_Delopgave_2_war/data/login?"+new URLSearchParams({
            username : user ,
            password : pass
            }
        )).then(resp => validate(resp) );
    }

    function validate(i){
        if(i==1){
            window.location.replace("StartSide.html");
        }else{
            alert("Forkert password");
        }
}