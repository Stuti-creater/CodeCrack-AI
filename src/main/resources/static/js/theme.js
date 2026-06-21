function setTheme(theme) {

    const body =
            document.getElementById(
                    "theme-body"
            );

    if(!body){
        return;
    }

    const previousTheme =
            localStorage.getItem(
                    "theme"
            );

    if(previousTheme){

        localStorage.setItem(
                "previousTheme",
                previousTheme
        );
    }

    body.classList.remove(
            "dark-theme",
            "aurora-theme",
            "saturn-theme"
    );

    body.classList.add(
            theme + "-theme"
    );

    localStorage.setItem(
            "theme",
            theme
    );
}


function undoTheme(){

    const previousTheme =
            localStorage.getItem(
                    "previousTheme"
            );

    if(previousTheme){

        setTheme(
                previousTheme
        );
    }
}


window.onload = function(){

    const body =
            document.getElementById(
                    "theme-body"
            );

    if(!body){
        return;
    }

    const savedTheme =
            localStorage.getItem(
                    "theme"
            );

    if(savedTheme){

        body.classList.add(
                savedTheme + "-theme"
        );
    }
};