function init(){
    bindEvent();
}
var  login= document.getElementsByClassName('userLogin')[0];
var dialog = document.getElementsByClassName('dialog')[0];
var signin = document.getElementsByClassName(' userSignin')[0];
function bindEvent(){
    var btn = document.getElementById('btn');
    var mask = document.getElementsByClassName('mask')[0] 
    var sign = document.getElementsByClassName('sign')[0];
    var log = document.getElementsByClassName('log')[0];
    btn.addEventListener('click',loginin,false);
    mask.addEventListener('click',function(e){
        dialog.classList.remove('show');
    },false);
    sign.addEventListener('click',function(e){
        signin.classList.add('show');
        login.classList.remove('show');
    },false);
    log.addEventListener('click',function(e){
        login.classList.add('show');
        signin.classList.remove('show');
    },false);
}

function loginin(){
    dialog.classList.add('show');
    login.classList.add('show');
    // console.log(login);
}
init();