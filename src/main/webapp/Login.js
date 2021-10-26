
const visibilityListen = document.getElementById("visibilityListen")
visibilityListen.addEventListener("click", toggleVisibiliy) //brug functionen hvis man trykker på iconet

    function toggleVisibiliy() {
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
