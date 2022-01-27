const btnhamburger=document.querySelector('#btnhamburger');


btnhamburger.addEventListener('click',function(){
    if(btnhamburger.classList.contains('open')){
        btnhamburger.classList.remove('open');
    }else{
        btnhamburger.classList.add('open');
    }
});