console.log("VOICE JS LOADED");
let questionNumber = 1;
let interviewHistory = [];
const question =
document.getElementById("chatBox");
const transcript =
document.getElementById("transcript");

document
.getElementById("startBtn")
.onclick = async function () {
    console.log("START CLICKED");

    const company =
        document.getElementById("company").value;

    const role =
        document.getElementById("role").value;

    questionNumber = 1;

    const response = await fetch(
        "/start-interview",
        {
            method: "POST",

            headers: {
                "Content-Type":
                "application/x-www-form-urlencoded"
            },

            body:

            "company="

            + encodeURIComponent(company)

            +

            "&role="

            + encodeURIComponent(role)

        }
    );

    const text =
        await response.text();

    question.innerHTML = `
<div class="ai-message">
    ${text}
</div>
`;
    interviewHistory.push({

    question: text,

    answer: ""

});

    speechSynthesis.speak(

        new SpeechSynthesisUtterance(text)

    );

};
document
.getElementById("stopBtn")
.onclick = async function(){

recognition.stop();

const answer =
transcript.innerHTML;
interviewHistory[
    interviewHistory.length - 1
].answer = answer;

const response =
await fetch(

"/submit-answer",

{

method:"POST",

headers:{

"Content-Type":
"application/x-www-form-urlencoded"

},

body:

"answer="

+

encodeURIComponent(answer)

}

);

const nextQuestion =
await response.text();

question.innerHTML = `
<div class="ai-message">
    ${nextQuestion}
</div>
`;
interviewHistory.push({

    question: nextQuestion,

    answer: ""

});

speechSynthesis.speak(

new SpeechSynthesisUtterance(

nextQuestion

)

);

transcript.innerHTML =
"Waiting for answer...";

};

document
.getElementById("finishBtn")
.onclick = function(){

    speechSynthesis.cancel();

    window.location.href="/finish-interview";

};


const SpeechRecognition=

window.SpeechRecognition||

window.webkitSpeechRecognition;

const recognition=

new SpeechRecognition();

recognition.continuous=false;

recognition.lang="en-US";

recognition.onresult=function(event){

transcript.innerHTML=

event.results[0][0].transcript;

};

document
.getElementById("micBtn")
.onclick=function(){

recognition.start();

};