const btnhamburger=document.querySelector('#btnhamburger');
const header=document.querySelector('.header');
const overlay=document.querySelector('.overlay');
const body=document.querySelector('body');
const fadeElems=document.querySelectorAll('.has-fade'); 

btnhamburger.addEventListener('click',function(){
    if(header.classList.contains('open')){
        body.classList.remove('noscroll');
        header.classList.remove('open');
        fadeElems.forEach(function(elements){
            elements.classList.remove('fade-in');
            elements.classList.add('fade-out');
  
          });
        
    }else{
        body.classList.add('noscroll');
        header.classList.add('open');
        fadeElems.forEach(function(elements){
          elements.classList.remove('fade-out');
          elements.classList.add('fade-in');

        });
        
    }
});